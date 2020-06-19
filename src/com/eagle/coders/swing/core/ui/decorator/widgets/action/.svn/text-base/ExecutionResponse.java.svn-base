/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionStatusType;

/**
 * @author Anees
 *
 */
public class ExecutionResponse {
	
	private String componentID;

	private Map<String, Object> paramters = new HashMap<String, Object>();
	
	private Map<String, String> errors = new HashMap<String, String>();
	
	private ActionStatusType actionStatus;
	
//	private List<Map<String, Object>> dataToReturnList;
//	
//	private Class<? extends Object> domainObjectAssociatedWithReturnList;
	
	private Map<Class<?>, List<Map<String, Object>>> dataWithDomainObjectMap = new HashMap<Class<?>, List<Map<String,Object>>>();
	
	public ExecutionResponse(){
		
	}

	/**
	 * 
	 * @return
	 */
	public boolean hasErrors(){
		
		if(errors.size()> 0)
			return true;
		else 
			return false;
	}
	
	/**
	 * @return the actionStatus
	 */
	public ActionStatusType getActionStatus() {
		return actionStatus;
	}

	/**
	 * @param actionStatus the actionStatus to set
	 */
	public void setActionStatus(ActionStatusType actionStatus) {
		this.actionStatus = actionStatus;
	}

//	/**
//	 * @return the dataToReturnList
//	 */
//	public List<Map<String, Object>> getDataToReturnList() {
//		return dataToReturnList;
//	}
//
//	/**
//	 * @param dataToReturnList the dataToReturnList to set
//	 */
//	public void setDataToReturnList(List<Map<String, Object>> dataToReturnList) {
//		this.dataToReturnList = dataToReturnList;
//	}
//
//	/**
//	 * @return the domainObjectAssociatedWithReturnList
//	 */
//	public Class<? extends Object> getDomainObjectAssociatedWithReturnList() {
//		return domainObjectAssociatedWithReturnList;
//	}
//
//	/**
//	 * @param domainObjectAssociatedWithReturnList the domainObjectAssociatedWithReturnList to set
//	 */
//	public void setDomainObjectAssociatedWithReturnList(
//			Class<? extends Object> domainObjectAssociatedWithReturnList) {
//		this.domainObjectAssociatedWithReturnList = domainObjectAssociatedWithReturnList;
//	}

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
	 * @return the paramters
	 */
	public Map<String, Object> getParamters() {
		return paramters;
	}

	/**
	 * @param paramters the paramters to set
	 */
	public void setParamters(Map<String, Object> paramters) {
		this.paramters = paramters;
	}

	/**
	 * @return the errors
	 */
	public Map<String, String> getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	/**
	 * @return the dataWithDomainObjectMap
	 */
	public Map<Class<?>, List<Map<String, Object>>> getDataWithDomainObjectMap() {
		return dataWithDomainObjectMap;
	}

	/**
	 * @param dataWithDomainObjectMap the dataWithDomainObjectMap to set
	 */
	public void setDataWithDomainObjectMap(
			Map<Class<?>, List<Map<String, Object>>> dataWithDomainObjectMap) {
		this.dataWithDomainObjectMap = dataWithDomainObjectMap;
	}
	

	/**
	 * 
	 * @param domainObject
	 * @param dataList
	 */
	public void addDataForReturn(Class<?> domainObject, List<Map<String, Object>> dataList){
		
		if(!dataWithDomainObjectMap.containsKey(domainObject)){
			
			dataWithDomainObjectMap.put(domainObject, dataList);
		}
	}
}
