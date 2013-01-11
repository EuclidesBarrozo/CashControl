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
		String password = (String) params.get("password");
		int name  = ((String) params.get("name")).hashCode();
		int login = ((String) params.get("login")).hashCode();
		
		params.add("password", password.hashCode());
		
		if(super.save(params)) {
			LinkedArray info = new LinkedArray();
			boolean sucess;

			setTable("usersPassword");
			
			info.add("login", login);
			info.add("name", name);
			info.add("password", password);
			
			sucess = super.save(info);
			
			resetTable();
			
			return sucess;
		}
		return false;
	}
	
}
