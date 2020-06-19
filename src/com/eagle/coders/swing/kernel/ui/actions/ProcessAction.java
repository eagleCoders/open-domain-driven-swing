/**
 * 
 */
package com.eagle.coders.swing.kernel.ui.actions;

import com.eagle.coders.swing.core.ui.decorator.widgets.action.ActionRequest;

/**
 * @author Anees
 *
 */
public class ProcessAction {
	
	/**
	 * 
	 * @param actionRequest
	 */
	public void update(final ActionRequest actionRequest){
		
		System.out.println("----------- updating the process -----------------");
	}
	
	/**
	 * 
	 * @param actionRequest
	 */
	public void create(){
		
		System.out.println(" ------------ creating the process -----------------------");
		
	}

}
