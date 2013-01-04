/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core.mvc;

import core.components.ComponentsManager;
import core.dataManipulation.Database;
import core.dataManipulation.LinkedArray;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *
 * @author Macário Martins <macariomartinsjunior@gmail.com>
 *
 */
public abstract class Model {
	
	protected Controller controller;
	protected Database db = Database.getConnection();
	protected String table = getTable();
	protected String primaryKey = "id";
	protected LinkedArray data = new LinkedArray();
	public ComponentsManager components;
	
	public boolean save(LinkedArray data) {
		if (data.containsKey(primaryKey))
			return db.update(table, data, "WHERE " + primaryKey + " = " + (Integer) data.get(primaryKey));
		else
			return db.insert(table, data);
	}
	
	public LinkedArray all() {
		ArrayList<String> params = new ArrayList<String>();
		params.add("*");
		return (LinkedArray) db.select(table, params);
	}
	
	public LinkedArray all(String options) {
		ArrayList<String> params = new ArrayList<String>();
		params.add("*");
		return (LinkedArray) db.select(table, params, options);
	}
	
	public LinkedArray firstBy(String condition) {
		ArrayList<String> params = new ArrayList<String>();
		params.add("*");
		return (LinkedArray) db.select(table, params, "WHERE " + condition).getValueByIndex(0);
	}
	
	public LinkedArray firstById(Integer id) {
		return firstBy("WHERE " + primaryKey + " = " + id);
	}
	
	public boolean delete(Integer id) {
		return db.delete(table, "WHERE " + primaryKey + " = " + id);
	}
	
	public boolean delete(String condition) {
		return db.delete(table, "WHERE " + condition);
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public void setTable(String table) {
		this.table = table;
	}
	
	public String getTable() {
		return getTable(this.getClass().getSimpleName());
	}
	
	public String getTable(String modelName) {
		return modelName.substring(0, 1).toLowerCase() + modelName.substring(1);
	}
	
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	public void sendData(LinkedArray data) {
		controller.setData(data);
	}
	
	public void resetTable() {
		table = getTable();
	}
	
	public Object callMethod(String methodName) {
		return callMethod(methodName, null);
	}
	
	public Object callMethod(String methodName, Object param) {
		try {
			Method method = param == null?
				this.getClass().getMethod(methodName) : 
				this.getClass().getMethod(methodName, Object.class);
			
			return param == null? method.invoke(this) : method.invoke(this, param);
		}
		catch (NoSuchMethodException exception) {
			System.out.println(exception.getMessage());
		}
		catch (SecurityException exception) {
			System.out.println(exception.getMessage());
		}
		catch (IllegalAccessException exception) {
			System.out.println(exception.getMessage());
		}
		catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
		catch (InvocationTargetException exception) {
			System.out.println(exception.getMessage());
		}
		
		return null;
	}
	
	public Object callMethod(String methodName, Integer param) {
		try {
			Method method = param == null?
				this.getClass().getMethod(methodName) : 
				this.getClass().getMethod(methodName, Integer.class);
			
			return param == null? method.invoke(this) : method.invoke(this, param);
		}
		catch (NoSuchMethodException exception) {
			System.out.println(exception.getMessage());
		}
		catch (SecurityException exception) {
			System.out.println(exception.getMessage());
		}
		catch (IllegalAccessException exception) {
			System.out.println(exception.getMessage());
		}
		catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
		catch (InvocationTargetException exception) {
			System.out.println(exception.getMessage());
		}
		
		return null;
	}
	
	protected boolean isValid(Object param) {
		return param != null;
	}
	
	protected boolean isValid(LinkedArray param) {
		return ! (param == null && param.isEmpty());
	}
	
	public String getPrimaryKey() {
		return primaryKey;
	}
	
}
