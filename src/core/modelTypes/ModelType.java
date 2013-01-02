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
		
	protected String modelName(String table) {
		return table.substring(0, 1).toUpperCase() + table.substring(1);
	}
	
	protected Integer recoverId(LinkedArray params) {
		String conditions = "";
		
		for (int i = 0; i < params.size(); i++)
			if (i + 1 < params.size()) {
				conditions += (String) params.getKeyByIndex(i);
				conditions += " = '" + (String) params.getValueByIndex(i) + "', ";
			}
			else {
				conditions += (String) params.getKeyByIndex(i);
				conditions += " = '" + (String) params.getValueByIndex(i) + "'";
			}
			
		return (Integer) firstBy(conditions).get(primaryKey);
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
			
}
