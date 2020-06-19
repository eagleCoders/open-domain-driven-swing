/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;

/**
 * @author Anees
 *
 */
public class ExecutionRequest {

	private ActionTypes actionTypes;

	private List<? extends Object> objectsToProceed;
	
	private Map<String, Object> propertiesValueMap;
	
	private String query;
	
	public ExecutionRequest(){
		
		objectsToProceed = new ArrayList<Object>();
		
		propertiesValueMap = new HashMap<String, Object>();
	}

	/**
	 * @return the objectsToProceed
	 */
	public List<? extends Object> getObjectsToProceed() {
		return objectsToProceed;
	}

	/**
	 * @param objectsToProceed the objectsToProceed to set
	 */
	public void setObjectsToProceed(List<? extends Object> objectsToProceed) {
		this.objectsToProceed = objectsToProceed;
	}

	/**
	 * @return the propertiesValueMap
	 */
	public Map<String, Object> getPropertiesValueMap() {
		return propertiesValueMap;
	}

	/**
	 * @param propertiesValueMap the propertiesValueMap to set
	 */
	public void setPropertiesValueMap(Map<String, Object> propertiesValueMap) {
		this.propertiesValueMap = propertiesValueMap;
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @return the actionTypes
	 */
	public ActionTypes getActionTypes() {
		return actionTypes;
	}

	/**
	 * @param actionTypes the actionTypes to set
	 */
	public void setActionTypes(ActionTypes actionTypes) {
		this.actionTypes = actionTypes;
	}
	
	
}
