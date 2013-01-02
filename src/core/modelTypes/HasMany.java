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
	
	protected HasMany() {
		for (int i = 0; i < hasMany.length; i++)
			hasMany[i] = getTable(hasMany[i]);
		
		setPrefix(getTable() + "_");
	}
	
	@Override
	public boolean save(LinkedArray data) {
		
		if (super.save(data)) {
			Integer id = data.containsKey(primaryKey)? (Integer) data.get(primaryKey) : recoverId(data);
		}
		
		return false;
	}
	
	@Override
	public LinkedArray all() {
		return null;
	}
	
	@Override
	public LinkedArray all(String options) {
		return null;
	}
	
	@Override
	public LinkedArray firstBy(String condition) {
		return null;
	}
	
	@Override
	public LinkedArray firstById(Integer id) {
		return null;
	}
	
	@Override
	public boolean delete(Integer id) {
		return false;
	}
	
	@Override
	public boolean delete(String condition) {
		return false;
	}
	
}
