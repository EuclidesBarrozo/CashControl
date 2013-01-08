/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import core.dataManipulation.LinkedArray;

/**
 *
 * @author Eduardo Jr
 */
public class PhonesController extends AppController{
   /*public void create(){
        if ( ! data.isEmpty()) {
           System.out.println("Dados recebidos!");		
           System.out.println((String) data.get("phone"));
        }
        else{
	   display("create");
        }
     *
     * @return
     */
    public LinkedArray create() {
            if ( ! data.isEmpty()) {
                System.out.println("Dados recebidos!");		
                System.out.println((String) data.get("phone"));
            }
            if (data.isEmpty()){
		display("create");
            }
		
		return data.isEmpty()? null : data;
    }
}