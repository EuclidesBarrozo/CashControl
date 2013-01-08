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
                new PhonesController().createPhone();
//              display("main");
                new PhonesController().createCell();
//		display("main");
		new EmailsController().create();
	}
}
