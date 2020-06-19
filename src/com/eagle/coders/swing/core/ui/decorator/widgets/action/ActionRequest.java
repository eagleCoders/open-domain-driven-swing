/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.action;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.frame.IFormContainer;

/**
 * @author Anees
 *
 */
public class ActionRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Locale locale;
	
	private String componentIDtoProcess;
	
	private ActionTypes actionTypes;
	
	private Object objectToProcess;
	
	private IFormContainer formContainer;
	
	private Map<String, Object> paramters;
	
	
	
	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * 
	 * @return
	 */
	public ActionTypes getActionTypes() {
		return actionTypes;
	}
	
	/**
	 * 
	 * @param actionTypes
	 */
	public void setActionTypes(ActionTypes actionTypes) {
		this.actionTypes = actionTypes;
	}

	/**
	 * 
	 * @return
	 */
	public String getComponentIDtoProcess() {
		return componentIDtoProcess;
	}

	/**
	 * 
	 * @param componentIDtoProcess
	 */
	public void setComponentIDtoProcess(String componentIDtoProcess) {
		this.componentIDtoProcess = componentIDtoProcess;
	}

	/**
	 * 
	 * @return
	 */
	public Object getObjectToProcess() {
		return objectToProcess;
	}
	
	/**
	 * 
	 * @param objectToProcess
	 */
	public void setObjectToProcess(Object objectToProcess) {
		this.objectToProcess = objectToProcess;
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
	 * 
	 * @param key
	 * @param value
	 */
	public void addParameter(String key, Object value){
		
		if(!paramters.containsKey(key)){
			
			paramters.put(key, value);
		}
	}

	/**
	 * @return the formContainer
	 */
	public IFormContainer getFormContainer() {
		return formContainer;
	}

	/**
	 * @param formContainer the formContainer to set
	 */
	public void setFormContainer(IFormContainer formContainer) {
		this.formContainer = formContainer;
	}
	

}
