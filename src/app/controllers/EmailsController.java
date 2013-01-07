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

	public void create(PeopleController people) {
		if (data.isEmpty())
			display("create");
		
		else {
			model.setController(people);
			model.saveComplements(null, people.getData());
		}
	}
	
}
