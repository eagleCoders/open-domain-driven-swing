/**
 * 
 */
package com.eagle.coders.swing.core.ui.validation;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

import com.eagle.coders.swing.core.ui.cache.UIDomainPropertyHolder;

/**
 * @author Anees
 *
 */
public class ComponentConstraintAssociator {
	
	private static ComponentConstraintAssociator instance;
	
	private Map<String, JComponent> propertyHolderComponentMap;
	
	private Map<String, PropertyConstraintsHolder> propertyDomainHolderMap;
	
	private ComponentConstraintAssociator(){
		
		propertyHolderComponentMap = new HashMap<String, JComponent>();
		
		propertyDomainHolderMap = new HashMap<String, PropertyConstraintsHolder>();
	}
	
	
	public static ComponentConstraintAssociator getInstance(){
		
		if(null == instance){
			instance = new ComponentConstraintAssociator();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param compoent
	 * @param propertyHolder
	 */
	public void associate(JComponent compoent, UIDomainPropertyHolder propertyHolder, PropertyConstraintsHolder constraints){

		if(!propertyHolderComponentMap.containsKey(propertyHolder)){
			
			propertyHolderComponentMap.put(propertyHolder.getDomainProperty(), compoent);
			
			propertyDomainHolderMap.put(propertyHolder.getDomainProperty(), constraints);
		}
	}
	
	/**
	 * 
	 * @param propertyName
	 * @return JComponent
	 */
	public Map<JComponent, PropertyConstraintsHolder> getComponentByPropertyName(String propertyName){
		
		Map<JComponent, PropertyConstraintsHolder> componentPropertiesHolder = new HashMap<JComponent, PropertyConstraintsHolder>();
		
		if(propertyHolderComponentMap.containsKey(propertyName)){
			
			componentPropertiesHolder.put(propertyHolderComponentMap.get(propertyName), propertyDomainHolderMap.get(propertyName));
			
//			return propertyHolderComponentMap.get(propertyName);
			return componentPropertiesHolder;
		}else
			return componentPropertiesHolder;
	}
	
	
//	/**
//	 * 
//	 * @param key
//	 * @param newValue
//	 */
//	public void validateJComponent(String key, Object newValue){
//	
//		if(propertyHolderComponentMap.containsKey(key)){
//			
//			JComponent component = propertyHolderComponentMap.get(key);
//			
//			if(component instanceof JFormattedTextField){
//				
//				JFormattedTextField textComponent =(JFormattedTextField) component;
//				
////				textComponent.setDocument(new JFormattedTextFieldDocument(10));
//			}
//		}
//	}

}
