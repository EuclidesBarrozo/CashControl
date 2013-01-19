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
		setPrefix("people");
	}
	
	@Override
	protected void setModels() {
		models = new String[] {"Emails"};
	}
	
	@Override
	protected void setComponents() {
		components.install("DateTime", new DateTimeComponent());
	}
	
	@Override
	protected void setValidations() {
		addValidation("name", "phrase", "Nomes não devem conter números ou caracteres especiais.");
	}
	
	@Override
	public boolean save(LinkedArray params) {
		return save(params, true);
	}
	
	public boolean save(LinkedArray params, boolean setTime) {
		if (isValid(params) && ! redundantRegister(params)) {
			data.copy(params);
			LinkedArray complements = checkoutForComplements();
			
			if (setTime)
				setTimeInData();
			
			if (isValid(complements)) {
				boolean sucess = super.save(data);
				Integer id = recoverPrimaryKey(data);
				
				if ( ! data.containsKey(primaryKey)) {
					LinkedArray info = new LinkedArray();
					info.add("peopleType", getTable());
					info.add(foreignKey, id);
				
					setTable("people");
				
					sucess = sucess && super.save(info);
				
					id = recoverPrimaryKey(info);
					resetTable();
				}
				else {
					setTable("people");
					id = (Integer) firstBy(foreignKey + " = '" + id + "'").get(foreignKey);
					resetTable();
				}
				return sucess && saveComplements(id, complements);
			}
			return super.save(data);
		}
		else if (redundantRegister(params, new String[] {"login", "password"}))
			controller.message("Lamentamos o incoveniente, mas esse cadastro é redundante.\nAbortando operação!");
		
		return false;
	}
	
	public void setTimeInData() {
		String time = (String) components.use("DateTime", "rightNow");

		if ( ! data.containsKey(primaryKey))
			data.add("created", time);
		
		data.add("modified", time);
	}
	
}
