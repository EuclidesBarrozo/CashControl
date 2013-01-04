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
	protected boolean saveComplements(Integer id, LinkedArray complements) {
		LinkedArray saveSucess = new LinkedArray();

		for (int i = 0; i < hasOne.length; i++) {
			if (complements.containsKey(hasOne[i])) {
				LinkedArray complement = (LinkedArray) complements.get(hasOne[i]);

				if ( ! complement.containsKey(foreignKey))
					complement.add(foreignKey, id);

				useModel(hasOne[i]);
				saveSucess.add(hasOne[i], Boolean.valueOf(model.save(complement)));
			}
		}

		int sucess = 0;
		for (int i = 0; i < saveSucess.size(); i++)
			if ((Boolean) saveSucess.getValueByIndex(i))
				sucess++;
			else
				System.out.println("Failure to save data in " + saveSucess.getKeyByIndex(i));

		return sucess == saveSucess.size();
	}
	
	
	
	@Override
	public boolean save(LinkedArray params) {
		LinkedArray complements;
		
		data = params;
		complements = checkoutForComplements(hasOne);
		
		if (super.save(data))
			return saveComplements(recoverPrimaryKey(data), complements);
		else
			return false;
	}
	
	@Override
	public LinkedArray all() {
		LinkedArray data = super.all();
		
		useModel(hasOne);
		
		for (int i = 0; i < data.size(); i++) {
			LinkedArray tmp = (LinkedArray) data.get(i);	
			LinkedArray complement = model.firstBy(foreignKey + " = " + "'" + tmp.get(primaryKey) + "'");
			
			if (isValid(complement))
				tmp.add(hasOne, complement);
			
			data.add(i, tmp);
		}
		
		return data;
	}
	
	@Override
	public LinkedArray all(String options) {
		LinkedArray data = super.all(options);
		
		useModel(hasOne);
		
		for (int i = 0; i < data.size(); i++) {
			LinkedArray tmp = (LinkedArray) data.getValueByIndex(i);
			LinkedArray complement = model.firstBy(foreignKey + " = " + "'" + tmp.get(primaryKey) + "'");
			
			if (isValid(complement))
				tmp.add(hasOne, complement);
			
			data.add(i, tmp);
		}
		
		return data;
	}
	
	@Override
	public LinkedArray firstBy(String condition) {
		LinkedArray data = super.firstBy(condition);
		
		useModel(hasOne);
		
		LinkedArray complement = model.firstBy(foreignKey + " = " + "'" + data.get(primaryKey) + "'");
		
		if (isValid(complement))
			data.add(hasOne, complement);
		
		return data;
	}
	
	@Override
	public LinkedArray firstById(Integer id) {
		LinkedArray data = super.firstById(id);
		
		useModel(hasOne);
		
		LinkedArray complement = model.firstBy(foreignKey + " = " + "'" + id + "'");
		
		if (isValid(complement))
			data.add(hasOne, complement);
		
		return data;
	}
	
	@Override
	public boolean delete(Integer id) {
		LinkedArray data = this.firstById(id);
		
		if (super.delete(id)) {
			if (data.containsKey(hasOne) && isValid((LinkedArray) data.get(hasOne))) {
				useModel(hasOne);
				LinkedArray complement = (LinkedArray) data.extract(hasOne);
				return model.delete((Integer) complement.get(model.getPrimaryKey()));
			}
			else
				return true;
		}
		return false;
	}
	
	@Override
	public boolean delete(String condition) {
		LinkedArray allData = this.all(condition);
		
		for (int i = 0; i < allData.size(); i++) {
			LinkedArray data = (LinkedArray) allData.get(i);
			
			if ( ! this.delete((Integer) data.get(primaryKey)))
				return false;
		}
		
		return true;
	}
	
}
