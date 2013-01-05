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

	protected String[] hasOne;
	
	@Override
	protected boolean saveComplements(Integer owner_id, LinkedArray complements) {
		LinkedArray saveSucess = new LinkedArray();

		for (int i = 0; i < hasOne.length; i++)
			if (complements.containsKey(hasOne[i])) {
				LinkedArray complement = (LinkedArray) complements.get(hasOne[i]);

				if ( ! complement.containsKey(foreignKey))
					complement.add(foreignKey, owner_id);

				useModel(hasOne[i]);
				saveSucess.add(hasOne[i], Boolean.valueOf(model.save(complement)));
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
		
		for (int i = 0; i < hasOne.length; i++) {
			useModel(hasOne[i]);
			LinkedArray tmp = model.all(foreignKey + " = '" + owner_id + "'");
			data.add(hasOne[i], tmp);
		}
		
		return complements;
	}
	
	@Override
	protected boolean deleteComplements(Integer owner_id) {
		LinkedArray deleteSucess = new LinkedArray();
		LinkedArray complements  = getComplements(owner_id);

		for (int i = 0; i < hasOne.length; i++)
			if (complements.containsKey(hasOne[i])) {
				LinkedArray complement = (LinkedArray) complements.get(hasOne[i]);

				if ( ! complement.containsKey(foreignKey))
					complement.add(foreignKey, owner_id);

				useModel(hasOne[i]);
				Integer complement_id = (Integer) complement.get(model.getPrimaryKey());
				deleteSucess.add(hasOne[i], Boolean.valueOf(model.delete(complement_id)));
			}

		int sucess = 0;
		for (int i = 0; i < deleteSucess.size(); i++)
			if ((Boolean) deleteSucess.getValueByIndex(i))
				sucess++;
			else
				System.out.println("Failed to delete data in " + deleteSucess.getKeyByIndex(i));

		return sucess == deleteSucess.size();
	}
	
	@Override
	public boolean save(LinkedArray params) {
		LinkedArray complements;
		
		data = params;
		complements = checkoutForComplements(hasOne);
		
		if (super.save(data))
			return saveComplements(recoverPrimaryKey(data), complements);
		
		return false;
	}
	
	@Override
	public LinkedArray all() {
		LinkedArray members = super.all();
		
		for (int i = 0; i < members.size(); i++) {
			LinkedArray member = (LinkedArray) members.get(i);
			member.merge(getComplements((Integer) member.get(primaryKey)));
			members.add(i, member);
		}
		
		return members;
	}
	
	@Override
	public LinkedArray all(String options) {
		LinkedArray members = super.all(options);
		
		for (int i = 0; i < members.size(); i++) {
			LinkedArray member = (LinkedArray) members.get(i);
			member.merge(getComplements((Integer) member.get(primaryKey)));
			members.add(i, member);
		}
		
		return members;
	}
	
	@Override
	public LinkedArray firstBy(String conditions) {
		LinkedArray first = super.firstBy(conditions);
		
		first.merge(getComplements((Integer) first.get(primaryKey)));
		
		return first;
	}
	
	@Override
	public LinkedArray firstById(Integer id) {
		LinkedArray first = super.firstById(id);
		
		first.merge(getComplements(id));
		
		return first;
	}
	
	@Override
	public boolean delete(Integer id) {
		if (super.delete(id))
			return deleteComplements(id);
			
		return false;
	}
	
	@Override
	public boolean delete(String conditions) {
		LinkedArray deleteSucess = new LinkedArray();
		
		data = all(conditions);
		
		int sucess = 0;
		for (int i = 0; i < data.size(); i++) {
			LinkedArray member = (LinkedArray) data.get(i);
			if (delete((Integer) member.get(primaryKey)))
				sucess++;
		}
		
		return sucess == data.size();
	}
	
}
