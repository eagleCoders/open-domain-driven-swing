/**
 * 
 */
package com.eagle.coders.swing.core.ui.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Anees
 *
 */
public class DomainUIPropertiesMapCache {
	
	private static DomainUIPropertiesMapCache instance;
	
	private UIComponentDomainPropertyHolder uiCompDomainHolder;
	
	private Map<String, UIDomainPropertyHolder> domainUiPropertyMap;
	
	private UIComponentPropertyValueModelHolder compValueModelHolder ;
	
	private List<UIComponentPropertyValueModelHolder> compValueModelHolderList;
	
	private Map<String, UiComponentsInterBindingInformationHolder> idBasedComponentInterBindingInfoMap;
	
	private Map<String, Map<Integer, Class>> clazzPositionHolder;
	

	private DomainUIPropertiesMapCache(){
		
		domainUiPropertyMap = new HashMap<String, UIDomainPropertyHolder>();
		
		idBasedComponentInterBindingInfoMap = new HashMap<String, UiComponentsInterBindingInformationHolder>();
		
		clazzPositionHolder = new HashMap<String, Map<Integer,Class>>();
		
		compValueModelHolderList = new ArrayList<UIComponentPropertyValueModelHolder>();
	}

	public static DomainUIPropertiesMapCache getInstance(){
		
		if(null == instance)
			instance = new DomainUIPropertiesMapCache();
		return instance;
	}

	/**
	 * 
	 * @param compPropertyHolder
	 */
	public void addCompValueModelHolder2List(UIComponentPropertyValueModelHolder compPropertyHolder){
		
		this.compValueModelHolderList.add(compPropertyHolder);
	}
	
	/**
	 * @return the compValueModelHolderList
	 */
	public List<UIComponentPropertyValueModelHolder> getCompValueModelHolderList() {
		return compValueModelHolderList;
	}

	/**
	 * @param compValueModelHolderList the compValueModelHolderList to set
	 */
	public void setCompValueModelHolderList(
			List<UIComponentPropertyValueModelHolder> compValueModelHolderList) {
		this.compValueModelHolderList = compValueModelHolderList;
	}

	/**
	 * @return the domainUiPropertyMap
	 */
	public Map<String, UIDomainPropertyHolder> getDomainUiPropertyMap() {
		return domainUiPropertyMap;
	}

	/**
	 * @param domainUiPropertyMap the domainUiPropertyMap to set
	 */
	public void setDomainUiPropertyMap(
			Map<String, UIDomainPropertyHolder> domainUiPropertyMap) {
		this.domainUiPropertyMap = domainUiPropertyMap;
	}

	/**
	 * 
	 * @param domainProperty
	 * @param uiProperty
	 */
	public void addDomainUiPropertyMap(String domainProperty, UIDomainPropertyHolder uiProperty){
		
		if(!domainUiPropertyMap.containsKey(domainProperty)){
			domainUiPropertyMap.put(domainProperty, uiProperty);
		}
	}
	
	
	/**
	 * @return the uiCompDomainHolder
	 */
	public UIComponentDomainPropertyHolder getUiCompDomainHolder() {
		return uiCompDomainHolder;
	}

	/**
	 * @param uiCompDomainHolder the uiCompDomainHolder to set
	 */
	public void setUiCompDomainHolder(
			UIComponentDomainPropertyHolder uiCompDomainHolder) {
		this.uiCompDomainHolder = uiCompDomainHolder;
	}

	/**
	 * @return the compValueModelHolder
	 */
	public UIComponentPropertyValueModelHolder getCompValueModelHolder() {
		return compValueModelHolder;
	}

	/**
	 * @param compValueModelHolder the compValueModelHolder to set
	 */
	public void setCompValueModelHolder(
			UIComponentPropertyValueModelHolder compValueModelHolder) {
		this.compValueModelHolder = compValueModelHolder;
	}

	/**
	 * @return the idBasedComponentInterBindingInfoMap
	 */
	public Map<String, UiComponentsInterBindingInformationHolder> getIdBasedComponentInterBindingInfoMap() {
		return idBasedComponentInterBindingInfoMap;
	}

	/**
	 * 
	 * @param componentID
	 * @return
	 */
	public UiComponentsInterBindingInformationHolder getComponentInterBindingInfoFromComponentID(String componentID){
		
		UiComponentsInterBindingInformationHolder compInterBindingInfo = null;
		
		if(this.idBasedComponentInterBindingInfoMap.containsKey(componentID))
			compInterBindingInfo = this.idBasedComponentInterBindingInfoMap.get(componentID);
		
		return compInterBindingInfo;
	}
	/**
	 * @param idBasedComponentInterBindingInfoMap the idBasedComponentInterBindingInfoMap to set
	 */
	public void setIdBasedComponentInterBindingInfoMap(
			Map<String, UiComponentsInterBindingInformationHolder> idBasedComponentInterBindingInfoMap) {
		this.idBasedComponentInterBindingInfoMap = idBasedComponentInterBindingInfoMap;
	}
	
	/**
	 * 
	 * @param componentID
	 * @param compInterBidningInfo
	 */
	public void addIdBasedComponentInterBindingInfoMap(String componentID,
			UiComponentsInterBindingInformationHolder compInterBidningInfo){
		
		if(!this.idBasedComponentInterBindingInfoMap.containsKey(componentID)){
			
			this.idBasedComponentInterBindingInfoMap.put(componentID, compInterBidningInfo);
		}
	}

	/**
	 * @return the clazzPositionHolder
	 */
	public Map<Integer, Class> getClazzPositionHolder(String componentID) {
		
		 Map<Integer, Class> clazzPositionMap = null;
		 
		if(this.clazzPositionHolder.containsKey(componentID)){
			
			clazzPositionMap =	this.clazzPositionHolder.get(componentID);
		}
		return clazzPositionMap;
	}

	/**
	 * @param clazzPositionHolder the clazzPositionHolder to set
	 */
	public void setClazzPositionHolder(
			Map<String, Map<Integer, Class>> clazzPositionHolder) {
		this.clazzPositionHolder = clazzPositionHolder;
	}

	/**
	 * 
	 * @param componentID
	 * @param clazzPostionMap
	 */
	public void addClazzPositionHolder(String componentID, Map<Integer, Class> clazzPostionMap){
		
		if(!this.clazzPositionHolder.containsKey(componentID)){
			
			this.clazzPositionHolder.put(componentID, clazzPostionMap);
		}
	}
}
