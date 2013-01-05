/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core.modelTypes;

import core.dataManipulation.LinkedArray;

/**
 *
 * @author Macário Martins <macariomartinsjunior@gmail.com>
 *
 */
public abstract class HasMany extends ModelType {
	
	@Override
	protected boolean saveComplements(Integer owner_id, LinkedArray complements) {
		boolean sucess = true;
		
		for (int i = 0; i < models.length; i++)
			if (complements.containsKey(models[i])) {
				LinkedArray complement = (LinkedArray) complements.get(models[i]);
				
				useModel(models[i]);
				for (int j = 0; j < complement.size(); j++) {
					LinkedArray part = (LinkedArray) complement.get(i);
					
					if ( ! part.containsKey(foreignKey))
						part.add(foreignKey, owner_id);
					
					if ( ! model.save(part)) {
						System.out.println("Failed to save data in " + models[i]);
						sucess = false;
					}
				}
			}
		
		return sucess;
	}
	
	@Override
	protected LinkedArray getComplements(Integer owner_id) {
		LinkedArray complements = new LinkedArray();
		
		for (int i = 0; i < models.length; i++) {
			useModel(models[i]);
			LinkedArray tmp = model.all(foreignKey + " = '" + owner_id + "'");
			data.add(models[i], tmp);
		}
		
		return complements;
	}
	
	@Override
	protected boolean deleteComplements(Integer owner_id) {
		LinkedArray complements = getComplements(owner_id);
		boolean sucess = true;
		
		for (int i = 0; i < models.length; i++)
			if (complements.containsKey(models[i])) {
				LinkedArray complement = (LinkedArray) complements.get(models[i]);
				
				useModel(models[i]);
				for (int j = 0; j < complement.size(); j++) {
					LinkedArray part = (LinkedArray) complement.get(i);
					Integer part_id  = (Integer) part.get(model.getPrimaryKey());
					
					if ( ! model.delete(part_id)) {
						System.out.println("Failed to delete data in " + models[i]);
						sucess = false;
					}
				}
			}
		
		return sucess;
	}
	
}
