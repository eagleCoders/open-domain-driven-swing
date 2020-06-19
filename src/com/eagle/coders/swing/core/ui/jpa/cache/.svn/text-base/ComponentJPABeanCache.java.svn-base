/**
 * 
 */
package com.eagle.coders.swing.core.ui.jpa.cache;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Anees
 *
 */
public class ComponentJPABeanCache {

	
	private Map<String, List<Map<String, Object>>> componentResultListMap;
	
	private static ComponentJPABeanCache instance;
	
	private ComponentJPABeanCache(){
		
		componentResultListMap = new HashMap<String, List<Map<String,Object>>>();
	}
	
	public static ComponentJPABeanCache getInstance(){
		
		if(null == instance){
			
			instance = new ComponentJPABeanCache();
		}
		return instance;
	}
	
	
	/**
	 * 
	 * @param componentID
	 * @return
	 */
	public List<Map<String, Object>> getResultMapByComponentID(final String componentID){
		
		if(componentResultListMap.containsKey(componentID)){
			
			return componentResultListMap.get(componentID);
		}else
			return null;
	}
	
	/**
	 * 
	 * @param componentID
	 * @param resultMapList
	 */
	public void addSearchResultForComponentID(final String componentID, final List<Map<String, Object>> resultMapList){
		
		if(!componentResultListMap.containsKey(componentID)){
			
			componentResultListMap.put(componentID, resultMapList);
		}
	}
	
	/**
	 * 
	 * @param componentID
	 * @return
	 */
	public boolean purgeComponentFromCache(String componentID){
		
		if(componentResultListMap.containsKey(componentID)){
			
			componentResultListMap.remove(componentID);
			
			return true;
		}else
			return false;
		
	}
}
