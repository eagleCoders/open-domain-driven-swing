/**
 * 
 */
package com.eagle.coders.swing.core.ui.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eagle.coders.swing.core.ui.bindings.MapValueModel;
import com.jgoodies.binding.list.ArrayListModel;

/**
 * @author Anees
 *
 */
public class DomainPropertyValueModelHolder {

	private String domainObject;
	
	private Map<String, MapValueModel> domainPropertyModelMap;
	
	private Map<String, ArrayListModel<Map<String, Object>>> childDomainTableDataMap; //To store the data for the child table if any

	public DomainPropertyValueModelHolder(final String domainObject, final Map<String, MapValueModel> domainPropertyModelMap){
		
		this.domainObject = domainObject;
		
		this.domainPropertyModelMap = domainPropertyModelMap;
		
		childDomainTableDataMap = new HashMap<String, ArrayListModel<Map<String,Object>>>();
	}
	
	/**
	 * @return the domainObject
	 */
	public String getDomainObject() {
		return domainObject;
	}

	/**
	 * @param domainObject the domainObject to set
	 */
	public void setDomainObject(String domainObject) {
		this.domainObject = domainObject;
	}

	/**
	 * @return the domainPropertyModelMap
	 */
	public Map<String, MapValueModel> getDomainPropertyModelMap() {
		return domainPropertyModelMap;
	}

	/**
	 * @param domainPropertyModelMap the domainPropertyModelMap to set
	 */
	public void setDomainPropertyModelMap(
			Map<String, MapValueModel> domainPropertyModelMap) {
		this.domainPropertyModelMap = domainPropertyModelMap;
	}

	/**
	 * @return the childDomainTableDataMap
	 */
	public Map<String, ArrayListModel<Map<String, Object>>> getChildDomainTableDataMap() {
		return childDomainTableDataMap;
	}

	/**
	 * @param childDomainTableDataMap the childDomainTableDataMap to set
	 */
	public void setChildDomainTableDataMap(String className, ArrayListModel<Map<String, Object>> childDomainMapList) {
		
		if(!childDomainTableDataMap.containsKey(className)){
			
			childDomainTableDataMap.put(className, childDomainMapList);
			
		}
	}

}
