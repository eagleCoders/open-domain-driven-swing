/**
 * 
 */
package com.eagle.coders.swing.core.ui.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eagle.coders.swing.core.ui.annotations.Action;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;

/**
 * @author Anees
 *
 */
public class ComponentActionCache {

	private Map<String, List<Action>> componentActionListMap;
	
	private Map<String, List<Map<ActionTypes, Action>>> componentActionTypeActionListMap;
	
	private static ComponentActionCache instance;
	
	private ComponentActionCache(){
		
		componentActionListMap = new HashMap<String, List<Action>>();
		
		componentActionTypeActionListMap = new HashMap<String, List<Map<ActionTypes,Action>>>();
	}
	
	/**
	 * 
	 * @return
	 */
	public static ComponentActionCache getInstance(){
		
		if(null == instance)
			instance = new ComponentActionCache();
		
		return instance;
	}

	/**
	 * @return the componentActionListMap
	 */
	public Map<String, List<Action>> getComponentActionListMap() {
		return componentActionListMap;
	}

	/**
	 * @param componentActionListMap the componentActionListMap to set
	 */
	public void setComponentActionListMap( final String componentID, final List<Action> componentActionList) {
		
		if(!componentActionListMap.containsKey(componentID)){
			
			componentActionListMap.put(componentID, componentActionList);
		}
	}

	/**
	 * @return the componentActionTypeActionListMap
	 */
	public Map<String, List<Map<ActionTypes, Action>>> getComponentActionTypeActionListMap() {
		return componentActionTypeActionListMap;
	}

	/**
	 * @param componentActionTypeActionListMap the componentActionTypeActionListMap to set
	 */
	public void setComponentActionTypeActionListMap(final String componentID,
			final List<Map<ActionTypes, Action>> componentActionTypeActionList) {
		
		if(!componentActionTypeActionListMap.containsKey(componentID)){
			
			componentActionTypeActionListMap.put(componentID, componentActionTypeActionList);
		}
	}
	
	
	
}
