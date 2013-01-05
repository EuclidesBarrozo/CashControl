/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.controllers;

/**
 *
 * @author Macário Martins <macariomartinsjunior@gmail.com>
 *
 */
public class EmailsController extends AppController {

	public void create() {
		if ( ! data.isEmpty()) {
			System.out.println("Dados recebidos!");
			System.out.println((String) data.get("email"));
		}
		else
			display("create");
	}
	
}
