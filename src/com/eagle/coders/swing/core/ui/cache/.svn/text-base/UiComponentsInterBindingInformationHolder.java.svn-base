/**
 * 
 */
package com.eagle.coders.swing.core.ui.cache;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;

/**
 * @author Anees
 *
 */
public class UiComponentsInterBindingInformationHolder {

	private Map<String, JComponent> propertyComponentHolder;
	
	private Map<String, String> parentChildComponentHolder;

	public UiComponentsInterBindingInformationHolder(){
		
		propertyComponentHolder = new HashMap<String, JComponent>();
		
		parentChildComponentHolder = new HashMap<String, String>();

	}
	
	/**
	 * @return the propertyComponentHolder
	 */
	public Map<String, JComponent> getPropertyComponentHolder() {
		return propertyComponentHolder;
	}

	/**
	 * @param propertyComponentHolder the propertyComponentHolder to set
	 */
	public void setPropertyComponentHolder(
			Map<String, JComponent> propertyComponentHolder) {
		this.propertyComponentHolder = propertyComponentHolder;
	}

	/**
	 * 
	 * @param compName
	 * @param component
	 */
	public void addPropertyComponentHolder(String compName, JComponent component){
		
		if(!this.propertyComponentHolder.containsKey(compName)){
			
			this.propertyComponentHolder.put(compName, component);
		}
		
	}
	/**
	 * @return the parentChildComponentHolder
	 */
	public Map<String, String> getParentChildComponentHolder() {
		return parentChildComponentHolder;
	}

	/**
	 * @param parentChildComponentHolder the parentChildComponentHolder to set
	 */
	public void setParentChildComponentHolder(
			Map<String, String> parentChildComponentHolder) {
		this.parentChildComponentHolder = parentChildComponentHolder;
	}

	/**
	 * 
	 * @param parentProperty
	 * @param childProperty
	 */
	public void addParentChildComponentHolder(String parentProperty, String childProperty){
		
		if(!this.parentChildComponentHolder.containsKey(parentProperty)){
			
			this.parentChildComponentHolder.put(parentProperty, childProperty);
		}
		
	}
	

}
