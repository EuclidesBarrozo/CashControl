/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.controllers;

import core.mvc.Controller;
/**
 *
 * @author Macário Martins <macariomartinsjunior@gmail.com>
 *
 */
public class AppController extends Controller {

	
	public void main() {
//              display("main");
                new PhonesController().create();
//		display("main");
		UsersController users = new UsersController();
		users.newEmail();
//		data = users.getData();
//		
//		if (data.containsKey("Emails"))
//			System.out.println("Os dados estão em Users!"); 
	}
}
