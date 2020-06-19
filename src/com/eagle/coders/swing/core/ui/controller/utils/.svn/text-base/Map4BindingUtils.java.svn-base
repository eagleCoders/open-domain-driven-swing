/**
 * 
 */
package com.eagle.coders.swing.core.ui.controller.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JComponent;

import com.eagle.coders.swing.core.ui.annotations.type.UIComponentType;
import com.eagle.coders.swing.core.ui.bindings.MapValueModel;
import com.eagle.coders.swing.core.ui.cache.DomainPropertyValueModelHolder;
import com.eagle.coders.swing.core.ui.cache.DomainUIPropertiesMapCache;
import com.eagle.coders.swing.core.ui.cache.UIDomainPropertyHolder;
import com.jgoodies.binding.list.ArrayListModel;

/**
 * @author Anees
 *
 */
public class Map4BindingUtils {
	
	/**
	 * 
	 * @param componentMap
	 * @param clazzName
	 * @return
	 */
	public static Map<Class, List<UIDomainPropertyHolder>> process4BindingMap(Map<String, JComponent> componentMap, String clazzName){
		
		List<UIDomainPropertyHolder> domainPropertyList = new ArrayList<UIDomainPropertyHolder>();
		
		Map<Class, List<UIDomainPropertyHolder>> map = new HashMap<Class, List<UIDomainPropertyHolder>>();
		
		try{
			
			Class clzz = Thread.currentThread().getContextClassLoader().loadClass(clazzName);
			
			Set<String> propertySet = componentMap.keySet();
			
			for(String property : propertySet){
				
				JComponent component = componentMap.get(property);
			}
			
			
			return map;
	
		}catch(Exception e){
		
			return map;
		}
	}
	
	/**
	 * 
	 * @param clazzParamterMapAfterValidation
	 * @return
	 */
	public static List<DomainPropertyValueModelHolder> getMap4Binding(Map<Class,
			List<UIDomainPropertyHolder>> clazzParamterMapAfterValidation){

		Iterator<Class> iterator = clazzParamterMapAfterValidation.keySet().iterator();
		
		List<DomainPropertyValueModelHolder> domainNameValueModelList = new ArrayList<DomainPropertyValueModelHolder>();
		
		while(iterator.hasNext()){

			Map<String, Object> domainPropertyMap = new HashMap<String, Object>();
			
			Map<String, MapValueModel> domainPropertyModelMap = new HashMap<String, MapValueModel>();

			Class clazz = iterator.next();

			DomainPropertyValueModelHolder holder = new DomainPropertyValueModelHolder(clazz.getName(), domainPropertyModelMap);
			
			List<UIDomainPropertyHolder> domainUiList = clazzParamterMapAfterValidation.get(clazz);
	
			for(UIDomainPropertyHolder uiDomainPropertyHolder : domainUiList){
				
				if(null != uiDomainPropertyHolder.getDomainProperty()){
					
					domainPropertyMap.put(uiDomainPropertyHolder.getDomainProperty(), "");
					
					MapValueModel mapValueModel = new MapValueModel(domainPropertyMap, uiDomainPropertyHolder.getDomainProperty());
					
					if(!uiDomainPropertyHolder.getQuerable()){
						mapValueModel.setQueryAble(false);
					}
					
					//TODO:
					if(uiDomainPropertyHolder.getUiPropertyType().equals(UIComponentType.COMPNENT_TABLE.getValue())){

						String childClassName = uiDomainPropertyHolder.getRelationshipClassProperty().getName();
						
						ArrayListModel<Map<String, Object>> tableListModel = new ArrayListModel<Map<String,Object>>();	
						
						holder.setChildDomainTableDataMap(childClassName, tableListModel);
					}
					
					domainPropertyModelMap.put(uiDomainPropertyHolder.getDomainProperty(), mapValueModel);
					
					DomainUIPropertiesMapCache.getInstance().addDomainUiPropertyMap(uiDomainPropertyHolder.getDomainProperty(),
							uiDomainPropertyHolder);
				}
			}
			
			
			domainNameValueModelList.add(holder);
		}
		
		return domainNameValueModelList;
	}
}