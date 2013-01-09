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
		if (data.isEmpty())
			display("create");
		else {
			System.out.println("Enviando dados para saveComplements...");
			if (model.saveComplements(null, data))
				System.out.println("Dados salvos no controller auxiliar!");
			else
				System.out.println("Falha ao salvar os dados no controller auxiliar!");
		}
			
	}
	
}
