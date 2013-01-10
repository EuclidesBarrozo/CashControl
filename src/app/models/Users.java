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
	
}
