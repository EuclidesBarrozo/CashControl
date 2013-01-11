/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.models;

import core.dataManipulation.LinkedArray;
import core.modelTypes.HasMany;

/**
 *
 * @author Macário Martins <macariomartinsjunior@gmail.com>
 *
 */
public class People extends HasMany {

	public People() {
		models = new String[] {"Emails"};
		setPrefix("people");
	}
	
	@Override
	public boolean save(LinkedArray params) {
		if (super.save(params)) {
			LinkedArray info = new LinkedArray();
			
			info.add("peopleType", getTable());
			info.add(foreignKey, recoverPrimaryKey(data));
			
			setTable("people");
			
			if (super.save(info)) {
				resetTable();
				return true;
			}
			else {
				resetTable();
				return false;
			}
		}
		return false;
	}
	
}
