/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core.modelTypes;

import core.dataManipulation.LinkedArray;
import core.mvc.Controller;

/**
 *
 * @author Macário Martins <macariomartinsjunior@gmail.com>
 *
 */
public abstract class BelongsTo extends ModelType {

	protected boolean foreignKeyPrefixed = false;
	protected boolean foreignKeySufixed  = false;
	
	public BelongsTo() {
		if ( ! (foreignKeyPrefixed || foreignKeySufixed))
			foreignKeyPrefixed = true;
	}
	
	@Override
	public boolean saveComplements(Integer owner_id, LinkedArray owner_data) {
		LinkedArray complement = owner_data.containsKey(models[0])?
				(LinkedArray) owner_data.extract(models[0]) :
				new LinkedArray();
		
		complement.put(data);
		owner_data.add(models[0], complement);
		sendData(owner_data);
		
		return owner_data.containsKey(models[0]);
	}

	@Override
	public LinkedArray getComplements(Integer owner_id) {
		for (int i = 0; i < models.length; i++) {
			LinkedArray complements = all(getForeignKey(models[i] + " = '" + owner_id + "'"));
			
			if (isValid(complements))
				data.add(models[i], complements);
		}
		
		return data;
	}

	@Override
	public boolean deleteComplements(Integer owner_id) {
		LinkedArray complements = getComplements(owner_id);
		
		for (int i = 0; i < complements.size(); i++) {
			LinkedArray complement = (LinkedArray) complements.get(i);
			
			if ( ! delete((Integer) complement.get(primaryKey)))
				return false;
		}
		
		return true;
	}
	
	public String getForeignKey(String modelName) {
		useModel(modelName);
		
		if (foreignKeyPrefixed)
			return getTable(modelName) + "_" + model.getPrimaryKey();
		else
			return model.getPrimaryKey() + "_" + getTable(modelName);
	}

}
