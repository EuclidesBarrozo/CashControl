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
public abstract class BelongsTo extends ModelType {

	@Override
	protected boolean saveComplements(Integer owner_id, LinkedArray complements) {
		return false;
	}
	
	@Override
	protected LinkedArray getComplements(Integer owner_id) {
		return null;
	}
	
	@Override
	protected boolean deleteComplements(Integer owner_id) {
		return false;
	}
	
}
