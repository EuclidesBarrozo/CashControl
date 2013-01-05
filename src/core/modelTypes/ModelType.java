/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core.modelTypes;

import core.dataManipulation.LinkedArray;
import core.mvc.Model;

/**
 *
 * @author Macário Martins <macariomartinsjunior@gmail.com>
 *
 */
public abstract class ModelType extends Model {

	protected String prefix;
	protected String sufix;
	protected String foreignKey;
	protected String[] models;
	protected Model	 model;
	
	public ModelType() {
		setPrefix(getTable() + "_");
	}
	
	protected abstract boolean saveComplements(Integer owner_id, LinkedArray complements);
	protected abstract LinkedArray getComplements(Integer owner_id);
	protected abstract boolean deleteComplements(Integer owner_id);
	
	@Override
	public boolean save(LinkedArray params) {
		LinkedArray complements;
		
		data = params;
		complements = checkoutForComplements(models);
		
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
	
	protected String modelName(String table) {
		return table.substring(0, 1).toUpperCase() + table.substring(1);
	}
	
	protected Integer recoverPrimaryKey(LinkedArray params) {
		Integer id;
		
		if (params.containsKey(primaryKey))
			id = (Integer) params.get(primaryKey);
		
		else {
			String conditions = "";

			for (int i = 0; i < params.size(); i++) {
				if (i + 1 < params.size()) {
					conditions += (String) params.getKeyByIndex(i);
					conditions += " = '" + (String) params.getValueByIndex(i) + "', ";
				}
				else {
					conditions += (String) params.getKeyByIndex(i);
					conditions += " = '" + (String) params.getValueByIndex(i) + "'";
				}
			}
			
			id = (Integer) firstBy(conditions).get(primaryKey);
		}
			
		return id;
	}
	
	protected void setPrefix(String prefix) {
		this.prefix = prefix;
		sufix = null;
		setForeignKey();
	}
	
	protected void setSufix(String sufix) {
		this.sufix = sufix;
		prefix = null;
		setForeignKey();
	}
	
	protected void setForeignKey() {
		if (prefix != null)
			foreignKey = prefix + "_" + primaryKey;
		else
			foreignKey = primaryKey + "_" + sufix;
	}
	
	protected void useModel(String modelName) {
		modelName += modelName.equals("App")? "Model" : "";
		
		try {
			model = (Model) Class.forName("app.models." + modelName).newInstance();
		}
		catch (ClassNotFoundException exception) {
			System.out.println("Model '"+ modelName +"' not found!");
			System.out.println(exception.getMessage());
		}
		catch (InstantiationException exception) {
			System.out.println("Failed to create an instance!");
			System.out.println(exception.getMessage());
		}
		catch (IllegalAccessException exception) {
			System.out.println("Illegal access!");
			System.out.println(exception.getMessage());
		}
	}
	
	protected LinkedArray checkoutForComplements(String[] models) {
		LinkedArray complements = new LinkedArray();
		
		for (int i = 0; i < models.length; i++)
			if (data.containsKey(models[i]))
				complements.add(models[i], (LinkedArray) data.extract(models));
		
		return complements.isEmpty()? null : complements;
	}
	
}
