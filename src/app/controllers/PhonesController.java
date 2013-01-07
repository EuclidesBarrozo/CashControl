/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

/**
 *
 * @author Eduardo Jr
 */
public class PhonesController extends AppController{
    public void create(){
        if ( ! data.isEmpty()) {
           System.out.println("Dados recebidos!");		
           System.out.println((String) data.get("phone"));
        }
        else{
	   display("create");
        }
    }
    
}
