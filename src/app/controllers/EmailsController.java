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
public class EmailsController extends AppController {

	public LinkedArray create() {
		if (data.isEmpty())
			display("create");
		
		return data.isEmpty()? null : data;
	}
	
}
