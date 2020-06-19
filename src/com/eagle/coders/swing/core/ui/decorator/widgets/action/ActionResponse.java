/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.frame.IFormContainer;

/**
 * @author Anees
 *
 */
public class ActionResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private IFormContainer formContair;
	
	private ActionTypes actionType;
	
	private String componentID;

	private Map<String, Object> paramters = new HashMap<String, Object>();
	
	private Map<String, String> errors = new HashMap<String, String>();
	
//	private Map<Class<? extends Object>, List<? extends Object>> dataToReturn = new HashMap<Class<? extends Object>, List<? extends Object>>();
	
	private Map<Class<? extends Object>, List<Map<String, Object>>> dataToReturn = new HashMap<Class<? extends Object>, List<Map<String,Object>>>();
	/**
	 * @return the formContair
	 */
	public IFormContainer getFormContair() {
		return formContair;
	}

	/**
	 * @param formContair the formContair to set
	 */
	public void setFormContair(IFormContainer formContair) {
		this.formContair = formContair;
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
	 * 
	 * @return
	 */
	public Map<String, Object> getParamters() {
		return paramters;
	}
	
	/**
	 * 
	 * @param paramters
	 */
	public void setParamters(Map<String, Object> paramters) {
		this.paramters = paramters;
	}

	/**
	 * @return the actionType
	 */
	public ActionTypes getActionType() {
		return actionType;
	}

	/**
	 * @param actionType the actionType to set
	 */
	public void setActionType(ActionTypes actionType) {
		this.actionType = actionType;
	}

	/**
	 * @return the dataToReturn
	 */
	public Map<Class<? extends Object>, List<Map<String, Object>>> getDataToReturn() {
		return dataToReturn;
	}

	/**
	 * @param dataToReturn the dataToReturn to set
	 */
	public void setDataToReturn(
			Map<Class<? extends Object>, List<Map<String, Object>>> dataToReturn) {
		this.dataToReturn = dataToReturn;
	}
	
	/**
	 * 
	 * @param clzName
	 * @param mapList
	 */
	public void addDataToReturn(Class<? extends Object> clzName, List<Map<String, Object>> mapList){
		
		if(!dataToReturn.containsKey(clzName)){
			
			dataToReturn.put(clzName, mapList);
			
		}
	}

//	/**
//	 * @return the dataToReturn
//	 */
//	public Map<Class<? extends Object>, List<? extends Object>> getDataToReturn() {
//		return dataToReturn;
//	}
//
//	/**
//	 * @param dataToReturn the dataToReturn to set
//	 */
//	public void setDataToReturn(Map<Class<? extends Object>, List<? extends Object>> dataToReturn) {
//		this.dataToReturn = dataToReturn;
//	}
	
//	/**
//	 * 
//	 * @param clzName
//	 * @param dataList
//	 */
//	public void addDateToReturn(Class<? extends Object> clzName, List<? extends Object> dataList){
//		
//		if(!dataToReturn.containsKey(clzName)){
//			
//			dataToReturn.put(clzName, dataList);
//		}
//	}
	
	
}