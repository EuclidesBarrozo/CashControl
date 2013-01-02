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

	protected String hasOne;
	
	protected HasOne() {
		hasOne = getTable(hasOne);
		setPrefix(getTable() + "_");
	}
	
	@Override
	public boolean save(LinkedArray data) {
		if (data.containsKey(modelName(hasOne))) {
			LinkedArray section = (LinkedArray) data.extract(modelName(hasOne));
		
			if (super.save(data)) {
				Integer id = data.containsKey(primaryKey)? (Integer) data.get(primaryKey) : recoverId(data);
				section.add(foreignKey, id);
				setTable(hasOne);
				
				if (super.save(section)) {
					resetTable();
					return true;
				}
				resetTable();
				return false;
			}
			return false;
		}
		return super.save(data);
	}
	
	@Override
	public LinkedArray all() {
		LinkedArray data = super.all();
		
		for (int i = 0; i < data.size(); i++) {
			LinkedArray tmp = (LinkedArray) data.getValueByIndex(i);
			
			setTable(hasOne);
			String condition = foreignKey + " = " + "'" + tmp.get(primaryKey) + "'";
			tmp.add(modelName(hasOne), super.firstBy(condition));
			resetTable();
			
			data.add(i, tmp);
		}
		
		return data;
	}
	
	@Override
	public LinkedArray all(String options) {
		LinkedArray data = super.all(options);
		
		for (int i = 0; i < data.size(); i++) {
			LinkedArray tmp = (LinkedArray) data.getValueByIndex(i);
			
			setTable(hasOne);
			String condition = foreignKey + " = " + "'" + tmp.get(primaryKey) + "'";
			tmp.add(modelName(hasOne), super.firstBy(condition));
			resetTable();
			
			data.add(i, tmp);
		}
		
		return data;
	}
	
	@Override
	public LinkedArray firstBy(String condition) {
		LinkedArray data = super.firstBy(condition);
		
		setTable(hasOne);
		condition = foreignKey + " = " + "'" + data.get(primaryKey) + "'";
		data.add(modelName(hasOne), super.firstBy(condition));
		resetTable();
		
		return data;
	}
	
	@Override
	public LinkedArray firstById(Integer id) {
		LinkedArray data = super.firstById(id);
		
		setTable(hasOne);
		String condition = foreignKey + " = " + "'" + id + "'";
		data.add(modelName(hasOne), super.firstBy(condition));
		resetTable();
		
		return data;
	}
	
	@Override
	public boolean delete(Integer id) {
		if (super.delete(id)) {
			setTable(hasOne);
			if (super.delete(foreignKey + " = '" + id + "'")) {
				resetTable();
				return true;
			}
			resetTable();
		}
		return false;
	}
	
	@Override
	public boolean delete(String condition) {
		LinkedArray allData = this.all(condition);
		
		for (int i = 0; i < allData.size(); i++) {
			LinkedArray data	= (LinkedArray) allData.getValueByIndex(i);
			
			if (super.delete((Integer) data.get(primaryKey))) {
				setTable(hasOne);
				
				if (super.delete(foreignKey + " = '" + data.get(primaryKey) + "'"))
					resetTable();
				
				else {
					resetTable();
					return false;
				}
			}
			else
				return false;
		}
		
		return true;
	}
	
}
