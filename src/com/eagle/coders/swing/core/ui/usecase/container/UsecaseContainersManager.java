/**
 * 
 */
package com.eagle.coders.swing.core.ui.usecase.container;

/**
 * @author Anees
 *
 */
public class UsecaseContainersManager {

	private static UsecaseContainersManager instance;
	
	private UsecaseContainersManager(){}
	
	
	public static UsecaseContainersManager getInstance(){
		
		if(null == instance){
			
			instance = new UsecaseContainersManager();
		}
		
		return instance;
	}
	
	
}
