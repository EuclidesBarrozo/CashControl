/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.models;

import core.modelTypes.HasMany;

/**
 *
 * @author Macário Martins <macariomartinsjunior@gmail.com>
 *
 */
public abstract class People extends HasMany {

	public People() {
		models = new String[] {"Phones","Emails","Adresses"};
	}
	
}
