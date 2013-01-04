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
	protected Model	 model;
		
	
	public ModelType() {
		setPrefix(getTable() + "_");
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
	
	protected LinkedArray checkoutForComplements(String[] modelsList) {
		LinkedArray complements = new LinkedArray();
		
		for (int i = 0; i < modelsList.length; i++)
			if (data.containsKey(modelsList[i]))
				complements.add(modelsList[i], (LinkedArray) data.extract(modelsList));
		
		return complements.isEmpty()? null : complements;
	}
	
	protected abstract boolean saveComplements(Integer id, LinkedArray complements);
//	protected abstract LinkedArray getComplements();
//	protected abstract boolean deleteComplements();
	
}
