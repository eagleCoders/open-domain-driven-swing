/**
 * 
 */
package com.eagle.coders.swing.core.ui.cache;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anees
 *
 */
public class UIComponentPropertyValueModelHolder {

	private String componentID;
	
	private List<DomainPropertyValueModelHolder> domainPropertyValueModelList  ;
	
	/**
	 * 
	 * @param componentID
	 * @param domainPropertyValueModelList
	 */
	public UIComponentPropertyValueModelHolder(String componentID, List<DomainPropertyValueModelHolder> domainPropertyValueModelList ){
		
		this.componentID = componentID;
		
		this.domainPropertyValueModelList = domainPropertyValueModelList;
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
	 * @return the domainPropertyValueModelList
	 */
	public List<DomainPropertyValueModelHolder> getDomainPropertyValueModelList() {
		return domainPropertyValueModelList;
	}

	/**
	 * @param domainPropertyValueModelList the domainPropertyValueModelList to set
	 */
	public void setDomainPropertyValueModelList(
			List<DomainPropertyValueModelHolder> domainPropertyValueModelList) {
		this.domainPropertyValueModelList = domainPropertyValueModelList;
	}
	
}
