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

	public void create() {
		if (data.isEmpty())
			display("create");
		else
			message(model.save(data)? "Salvo!" : "Falha ao salvar!");
	}
	
	public void read(Integer id) {}
	public void update(Integer id) {}
	public void delete(Integer id) {}
	
	public void newEmail() {
		EmailsController emails = new EmailsController();
		emails.controllerAux = this;
		emails.create();
	}
	
	
	public void getEmails() {
		
	}
	
	
}
