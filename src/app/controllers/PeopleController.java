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
		
		else {
			data.add("peopleType", model.getTable());
			
			if (model.save(data))
				System.out.println("Dados salvos com sucesso!");
			else
				System.out.println("Falha ao salvar os dados!");
		}
		
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
