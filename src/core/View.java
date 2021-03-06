/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

/**
 *
 * @author Macário Martins <macariomartinsjunior@gmail.com>
 *
 */
public abstract class View extends javax.swing.JFrame {

	protected Model model;
	protected Controller controller;
	protected LinkedArray data = new LinkedArray();
	
	public abstract void run();
	
	public void setData(LinkedArray data) {
		this.data = data;
	}
	
	public LinkedArray getData() {
		return data;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public void setModel(Model model) {
		this.model = model;
	}
	
	public void updateController(Object param) {
		String actionName;
		
		actionName = this.getClass().getSimpleName();
		actionName = actionName.replace("View", "");
		actionName = actionName.substring(0, 1).toLowerCase() + actionName.substring(1);
		
		controller.updateView(actionName, this, param);
	}
	
	public void updateController(Integer param) {
		String actionName;
		
		actionName = this.getClass().getSimpleName();
		actionName = actionName.replace("View", "");
		actionName = actionName.substring(0, 1).toLowerCase() + actionName.substring(1);
		
		controller.updateView(actionName, this, param);
	}
	
	public void updateController() {
		updateController(null);
	}
	
}
