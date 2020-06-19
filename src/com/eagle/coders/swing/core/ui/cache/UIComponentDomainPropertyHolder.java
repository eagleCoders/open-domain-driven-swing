/**
 * 
 */
package com.eagle.coders.swing.core.ui.cache;

import java.util.List;
import java.util.Map;


/**
 * @author Anees
 *
 */
public class UIComponentDomainPropertyHolder {

	private String componentID;
	
	private Map<Class, List<UIDomainPropertyHolder>> clazzParamterMapAfterValidation;
	
	public UIComponentDomainPropertyHolder(String componentID, Map<Class, List<UIDomainPropertyHolder>> clazzParamterMapAfterValidation){
		
		this.componentID = componentID;
		
		this.clazzParamterMapAfterValidation = clazzParamterMapAfterValidation;
	}

	/**
	 * @return the componentID
	 */
	public String getComponentID() {
		return componentID;
	}

	/**
	 * @param componentID the componentID to set
	 */
	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}

	/**
	 * @return the clazzParamterMapAfterValidation
	 */
	public Map<Class, List<UIDomainPropertyHolder>> getClazzParamterMapAfterValidation() {
		return clazzParamterMapAfterValidation;
	}

	/**
	 * @param clazzParamterMapAfterValidation the clazzParamterMapAfterValidation to set
	 */
	public void setClazzParamterMapAfterValidation(
			Map<Class, List<UIDomainPropertyHolder>> clazzParamterMapAfterValidation) {
		this.clazzParamterMapAfterValidation = clazzParamterMapAfterValidation;
	}
	
}
