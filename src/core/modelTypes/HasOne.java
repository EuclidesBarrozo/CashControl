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
public abstract class HasOne extends ModelType {
	
	@Override
	protected boolean saveComplements(Integer owner_id, LinkedArray complements) {
		LinkedArray saveSucess = new LinkedArray();

		for (int i = 0; i < models.length; i++)
			if (complements.containsKey(models[i])) {
				LinkedArray complement = (LinkedArray) complements.get(models[i]);

				if ( ! complement.containsKey(foreignKey))
					complement.add(foreignKey, owner_id);

				useModel(models[i]);
				saveSucess.add(models[i], Boolean.valueOf(model.save(complement)));
			}

		int sucess = 0;
		for (int i = 0; i < saveSucess.size(); i++)
			if ((Boolean) saveSucess.getValueByIndex(i))
				sucess++;
			else
				System.out.println("Failed to save data in " + saveSucess.getKeyByIndex(i));

		return sucess == saveSucess.size();
	}
	
	@Override
	protected LinkedArray getComplements(Integer owner_id) {
		LinkedArray complements = new LinkedArray();
		
		for (int i = 0; i < models.length; i++) {
			useModel(models[i]);
			LinkedArray tmp = model.firstBy(foreignKey + " = '" + owner_id + "'");
			data.add(models[i], tmp);
		}
		
		return complements;
	}
	
	@Override
	protected boolean deleteComplements(Integer owner_id) {
		LinkedArray deleteSucess = new LinkedArray();
		LinkedArray complements  = getComplements(owner_id);

		for (int i = 0; i < models.length; i++)
			if (complements.containsKey(models[i])) {
				LinkedArray complement = (LinkedArray) complements.get(models[i]);

				if ( ! complement.containsKey(foreignKey))
					complement.add(foreignKey, owner_id);

				useModel(models[i]);
				Integer complement_id = (Integer) complement.get(model.getPrimaryKey());
				deleteSucess.add(models[i], Boolean.valueOf(model.delete(complement_id)));
			}

		int sucess = 0;
		for (int i = 0; i < deleteSucess.size(); i++)
			if ((Boolean) deleteSucess.getValueByIndex(i))
				sucess++;
			else
				System.out.println("Failed to delete data in " + deleteSucess.getKeyByIndex(i));

		return sucess == deleteSucess.size();
	}
	
}
