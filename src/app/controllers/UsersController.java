/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.controllers;

import core.dataManipulation.LinkedArray;

/**
 *
 * @author Macário Martins <macariomartinsjunior@gmail.com>
 *
 */
public class UsersController extends PeopleController {

	public LinkedArray getData() {
		return data;
	}
	
	public void create() {
		if (data.isEmpty()) {
			display("create");
		}
		else {
			System.out.println("Dados colhidos em UsersController");
			if (data.containsKey("Emails")) {
				data.dump();
			}
		}
	}
	
}
