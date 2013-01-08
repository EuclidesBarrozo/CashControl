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
public abstract class PeopleController extends AppController {

	public void create() {}
	public void read(Integer id) {}
	public void update(Integer id) {}
	public void delete(Integer id) {}
	
	public void newEmail() {
		/**
		 * 
		 * Resolver problema de controller auxiliar.
		 * 
		 */
		
		EmailsController emails = new EmailsController();
	}
	
	
	public void getEmails() {
		
	}
	
	
}
