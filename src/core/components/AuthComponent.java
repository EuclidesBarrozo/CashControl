/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core.components;

import core.components.Component;
import core.dataManipulation.LinkedArray;
import core.mvc.Model;
import java.util.Enumeration;
import java.util.Properties;

/**
 *
 * @author Macário Martins <macariomartinsjunior@gmail.com>
 *
 */
public class AuthComponent extends Component {
	
	private static LinkedArray users = new LinkedArray();
//	private LinkedArray blackList = new LinkedArray();
	
	
	public AuthComponent(Model model) {
		setModel(model);
	}
	
	public Boolean isLogged(LinkedArray params) {
		if ( ! params.isEmpty()) {
			String login = (String) params.get("login");
			Integer password = params.get("password").hashCode();

			for (Integer i = 0; i < users.size(); i++) {
				LinkedArray tmp = (LinkedArray) users.getValueByIndex(i);

				boolean flag1 = tmp.get("login").equals(login);
				boolean flag2 = password == tmp.get("password").hashCode();

				if (flag1 && flag2) {
					return Boolean.TRUE;
				}
			}
		}
		
		return Boolean.FALSE;
	}
	
	public Boolean login(LinkedArray params) {
		if ( ! isLogged(params)) {
			String condition1, condition2;
			
			condition1 = "login = \"" + params.get("login") + "\"";
			condition2 = "password = \"" + params.get("password").hashCode() + "\"";
			
			LinkedArray user = model.firstBy(condition1 + " and " + condition2);
			
			users.add(userCode(), user);
		}
		
		return isLogged(params);
	}
	
	public Boolean logout() {
		LinkedArray user = getUserData();
		users.remove(userCode());
		return ! isLogged(user);
	}
	
	public LinkedArray getUserData() {
		return (LinkedArray) users.get(userCode());
	}
	
	public Integer userCode() {
		int userCode  = 0;
		Properties p  = System.getProperties();
		Enumeration e = p.propertyNames();
		
		while (e.hasMoreElements()) {
			String pName  = (String) e.nextElement();
			String pValue = (String) p.get(pName);
			userCode += pValue.hashCode();
		}
		
		return userCode;
	}
	
//	public void deny(LinkedArray blackList) {
//		if ( ! this.blackList.isEmpty())
//			for (int i = 0; ! blackList.isEmpty(); i++) {
//				Object key = blackList.getKeyByIndex(i);
//				Object value = blackList.getValueByIndex(i);
//				this.blackList.add(key, value);
//				blackList.removeByIndex(i);
//			}
//		else
//			this.blackList = blackList;
//	}
	
}
