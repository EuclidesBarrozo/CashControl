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
   
    public LinkedArray createPhone() {
            if ( ! data.isEmpty()) {
                System.out.println("Dados recebidos!");		
                System.out.println((String) data.get("phone"));
            }
            else{
		display("createPhone");
            }
		
		return data.isEmpty()? null : data;
    }
    
    public LinkedArray createCell() {
            if ( ! data.isEmpty()) {
                System.out.println("Dados recebidos!");		
                System.out.println((String) data.get("cell"));
            }
            else{
		display("createCell");
            }
		
		return data.isEmpty()? null : data;
    }
    
    public boolean validaPhone(String phone){
        int ddd; 
 
        ddd = Integer.parseInt(phone.substring(0, 2));
        
        if ((ddd == 10 )||(ddd > 9 && ddd < 100) && (ddd % 10 != 0)){
            if(phone.charAt(2) != '1' && phone.length() == 10){
                return true;  
            }
        }
        return false;
        }
        
     public boolean validaCell(String cell){
        int ddd; 
 
        ddd = Integer.parseInt(cell.substring(0, 2));
        System.out.println("ddd " + cell.substring(3, 4));
        
        if ((ddd == 10 )||(ddd > 9 && ddd < 100) && (ddd % 10 != 0)){
            if(ddd == 11 && cell.charAt(2) == '9'){
                if(Integer.parseInt(cell.substring(3, 4)) > 4 && Integer.parseInt(cell.substring(3, 4)) < 10 
                && (cell.length() > 9 && cell.length() < 12)){
                    
                    return true;
                }  
            }
            else if(Integer.parseInt(cell.substring(2, 3)) > 4 && Integer.parseInt(cell.substring(2, 3)) < 10 
            && cell.length() == 10){
                
                return true;  
            }
        }
        return false;
    }
    
}