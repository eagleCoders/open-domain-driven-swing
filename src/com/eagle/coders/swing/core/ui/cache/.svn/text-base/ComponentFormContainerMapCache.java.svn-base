/**
 * 
 */
package com.eagle.coders.swing.core.ui.cache;

import java.util.HashMap;
import java.util.Map;

import com.eagle.coders.swing.core.ui.frame.FormContainer;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;

/**
 * @author Anees
 *
 */
public class ComponentFormContainerMapCache {

	private static ComponentFormContainerMapCache instance;
	
	private Map<String, FormContainer<IComponent>> componentContainerMap;
	
	
	private ComponentFormContainerMapCache(){
		
		componentContainerMap = new HashMap<String, FormContainer<IComponent>>();
	}
	
	public synchronized static ComponentFormContainerMapCache getInstance(){
		if(null == instance)
			instance = new ComponentFormContainerMapCache();
		
		return instance;
	}

	/**
	 * @return the componentContainerMap
	 */
	public FormContainer<IComponent> getComponentContainerMap(String componentID) {
		
		FormContainer<IComponent> container = null;
		
		if(componentContainerMap.containsKey(componentID)){
			container = componentContainerMap.get(componentID);
		}
		
		return container;
	}

	/**
	 * 
	 * @return
	 */
	public Map<String, FormContainer<IComponent>> getAllComponentContainer(){
		
		return componentContainerMap;
	}
	
	/**
	 * @param componentContainerMap the componentContainerMap to set
	 */
	public void setComponentContainerMap(
			Map<String, FormContainer<IComponent>> componentContainerMap) {
		this.componentContainerMap = componentContainerMap;
	}
	
	/**
	 * 
	 * @param componentID
	 * @param container
	 */
	public void addComponentConterMap(String componentID, FormContainer<IComponent> container){
		
		if(!this.componentContainerMap.containsKey(componentID)){
			
			this.componentContainerMap.put(componentID, container);
		}
	}
}
