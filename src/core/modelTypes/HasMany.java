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

	protected String[] hasMany;
	
	@Override
	public boolean save(LinkedArray data) {
		if (super.save(data)) {
			Integer id = recoverPrimaryKey(data);
			
			for (int i = 0; i < hasMany.length; i++)
				if (data.containsKey(hasMany[i])) {
					LinkedArray complement = (LinkedArray) data.extract(hasMany[i]);
					complement.add(foreignKey, id);
					
					useModel(hasMany[i]);
					
					if ( ! model.save(complement))
						return false;
				}
		}
		else
			return false;
		
		return true;
	}
	
	@Override
	public LinkedArray all() {
		LinkedArray data = super.all();
		
		for (int i = 0; i < data.size(); i++) {
			LinkedArray tmpData = (LinkedArray) data.get(i);
			Integer id = (Integer) tmpData.get(primaryKey);
			
			for (int j = 0; j < hasMany.length; j++) {
				useModel(hasMany[j]);
				tmpData.add(hasMany[j], model.all(foreignKey + " = '" + id + "'"));
			}
			
			data.add(i, tmpData);
		}
		
		return data;
	}
	
	@Override
	public LinkedArray all(String options) {
		LinkedArray data = super.all();
		
		for (int i = 0; i < data.size(); i++) {
			LinkedArray tmpData = (LinkedArray) data.get(i);
			Integer id = (Integer) tmpData.get(primaryKey);
			
			for (int j = 0; j < hasMany.length; j++) {
				useModel(hasMany[j]);
				tmpData.add(hasMany[j], model.all(foreignKey + " = '" + id + "'"));
			}
			
			data.add(i, tmpData);
		}
		
		return data;
	}
	
	@Override
	public LinkedArray firstBy(String condition) {
		LinkedArray data = super.firstBy(condition);
		Integer id = (Integer) data.get(primaryKey);
		
		for (int i = 0; i < hasMany.length; i++) {
			useModel(hasMany[i]);
			data.add(hasMany[i], model.all(foreignKey + " = '" + id + "'"));
		}
		
		return data;
	}
	
	@Override
	public LinkedArray firstById(Integer id) {
		LinkedArray data = super.firstById(id);
		
		for (int i = 0; i < hasMany.length; i++) {
			useModel(hasMany[i]);
			data.add(hasMany[i], model.all(foreignKey + " = '" + id + "'"));
		}
		
		return data;
	}
	
	@Override
	public boolean delete(Integer id) {
		if (super.delete(id))
			for (int i = 0; i < hasMany.length; i++) {
				
			}
		
		else
			return false;
		
		return true;
	}
	
	@Override
	public boolean delete(String condition) {
		return false;
	}
	
}
