/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.models;

import core.components.DateTimeComponent;
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
		components.install("DateTime", new DateTimeComponent());
	}
	
	@Override
	public boolean save(LinkedArray params) {
		if (isValid(params)) {
			String now = (String) components.use("DateTime", "rightNow");
			
			if ( ! params.containsKey(primaryKey))
				params.add("created", now);
			
			params.add("modified", now);
		}
		
		if (super.save(params)) {
			LinkedArray info = new LinkedArray();
			
			info.add("peopleType", getTable());
			info.add(foreignKey, recoverPrimaryKey(data));
			
			setTable("people");
			
			if (super.save(info)) {
				resetTable();
				return true;
			}
			resetTable();
		}
		return false;
	}
	
}
