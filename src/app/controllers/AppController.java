/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.controllers;

import core.components.AuthComponent;
import core.dataManipulation.LinkedArray;
import core.mvc.Controller;

/**
 *
 * @author Macário Martins <macariomartinsjunior@gmail.com>
 *
 */
public class AppController extends Controller {

	public void main(Object params) {
		setControllerAux(new UsersController());
		controllerAux.components.install("Auth", new AuthComponent(controllerAux.getModel()));
	
		if (params == null || controllerAux.components.use("Auth", "isLogged", ((LinkedArray) params)) == Boolean.FALSE)
			controllerAux.display("login");
		else
			display("main");
	}

}
