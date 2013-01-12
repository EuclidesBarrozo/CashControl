/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.models;

import core.dataManipulation.LinkedArray;

/**
 *
 * @author Macário Martins <macariomartinsjunior@gmail.com>
 *
 */
public class Users extends People {

	public String rememberPassword(Object params) {
		int nameCode  = ((LinkedArray) params).get("name").hashCode();
		int loginCode = ((LinkedArray) params).get("login").hashCode();
	
		setTable("usersPassword");
		
		String password = (String) firstBy(
				"login = " + loginCode + " and " +
				"name  = " + nameCode
		).get("password");
		
		resetTable();
		
		return password;
	}
	
	
	@Override
	public boolean save(LinkedArray params) {
		data = params;
		String password = (String) data.get("password");
		int name  = ((String) data.get("name")).hashCode();
		int login = ((String) data.get("login")).hashCode();
		
		data.add("password", password.hashCode());
		
		if (super.save(data)) {
			LinkedArray info = new LinkedArray();
			boolean sucess;

			setTable("usersPassword");
			
			info.add("login", login);
			info.add("name", name);
			info.add("password", password);
			
			sucess = super.save(info, false);
			
			resetTable();
			
			return sucess;
		}
		return false;
	}
	
}
