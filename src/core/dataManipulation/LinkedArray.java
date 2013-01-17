/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core.dataManipulation;

import java.util.ArrayList;
/**
 *
 * @author Macário Martins <macariomartinsjunior@gmail.com>
 *
 */
public class LinkedArray {
	
	private ArrayList keys = new ArrayList();
	private ArrayList values = new ArrayList();
	
	public int size() {
		return keys.size();
	}
	
	public boolean isEmpty() {
		return values.isEmpty();
	}
	
	public void merge(LinkedArray linkedArray) {
		if ( ! (linkedArray == null || linkedArray.isEmpty()))
			for (int i = 0; i < linkedArray.size(); i++)
				this.add(linkedArray.getKeyByIndex(i), linkedArray.getValueByIndex(i));
	}
	
	public void getTransference(LinkedArray linkedArray) {
		for (int i = 0; i < linkedArray.size(); i++) {
			Object key = linkedArray.getKeyByIndex(i);
			Object value = linkedArray.extract(key);
			this.add(key, value);
		}
	}
	
	public void add(Object key, Object value) {
		if ( ! keys.contains(key)) {
			keys.add(key);
			values.add(value);
		}
		else {
			int index = keys.indexOf(key);
			values.remove(index);
			values.add(index, value);
		}
	}
	
	public void put(Object value) {
		boolean added = false;
		
		for (Integer i = 0; i < this.size(); i++)
			if ( ! this.containsKey(i)) {
				this.add(i, value);
				added = true;
				break;
			}
		
		if ( ! added)
			this.add(this.size(), value);
	}
	
	public void remove(Object key) {
		removeByKey(key);
	}
	
	public void removeByIndex(int index) {
		keys.remove(index);
		values.remove(index);
	}
	
	public void removeByKey(Object key) {
		if (this.containsKey(key))
			removeByIndex(keys.indexOf(key));
	}
	
	public void removeByValue(Object value) {
		if (this.containsValue(value))
			removeByIndex(values.indexOf(value));
	}
	
	public Object get(Object key) {
		return this.containsKey(key)? getValueByKey(key) : null;
	}
		
	public Object getKeyByIndex(int index) {
		return keys.get(index);
	}
	
	public Object getValueByIndex(int index) {
		return values.get(index);
	}
	
	public Object getKeyByValue(Object value) {
		return getKeyByIndex(values.indexOf(value));
	}
	
	public Object getValueByKey(Object key) {
		return getValueByIndex(keys.indexOf(key));
	}
	
	public ArrayList getKeysArray() {
		return keys;
	}
	
	public ArrayList getValuesArray() {
		return values;
	}
	
	public Object extract(Object key) {
		if (this.containsKey(key)) {
			Object section = this.get(key);
			this.remove(key);

			return section;
		}
		return null;
	}
	
	public boolean containsKey(Object key) {
		return keys.contains(key);
	}
	
	public boolean containsValue(Object value) {
		return values.contains(value);
	}
	
	public void reset() {
		keys	= new ArrayList();
		values	= new ArrayList();
	}
	
	public void dump() {
		System.out.println("\nLinkedArray {");
		
		if (this.isEmpty())
			System.out.println("  [ EMPTY ]");
		else
			dumpContent(1);
				
		
		System.out.println("}\n");
	}
	
	private void dumpContent(int endent) {
		if (this.isEmpty())
			System.out.println("  [ EMPTY ]");
		else
			for (int i = 0; i < this.size(); i++) {
				Object key = keys.get(i);
				Object value = values.get(i);
				String output = "";
				
				for (int j = 1; j <= endent; j++) System.out.print("\t");
				
				output += "(" + key.getClass().getSimpleName() + ")" + "\"" + key.toString() + "\"\t--> ";
				
				if ( ! (value instanceof LinkedArray)) {
					output += "\t(" + value.getClass().getSimpleName() + ")" + "\"" + value.toString() + "\"";
					System.out.println(output);
				}	
				else {
					System.out.println("(" + key.getClass().getSimpleName() + ")" + "\"" + key.toString() + "\" {");
					((LinkedArray) value).dumpContent(endent + 1);
				
					for (int j = 1; j <= endent; j++) System.out.print("\t");
					
					System.out.println("}");
				}
			}
	}
	
}
