/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eagle.coders.swing.core.ui.bindings.BeanMapUtils;
import com.eagle.coders.swing.core.ui.bindings.MapValueModel;
import com.eagle.coders.swing.core.ui.bindings.MapValueModelDirtyChecker;
import com.eagle.coders.swing.core.ui.cache.DomainPropertyValueModelHolder;
import com.eagle.coders.swing.core.ui.controller.utils.JavaBeanUtils;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.jpa.DynamicJPAQueryGenerator;
import com.eaglecoders.control.server.delegates.EagleCoderGeneralDelegate;

/**
 * @author Anees
 *
 */
public class LoginAction {
	
	/**
	 * 
	 * @param domainPropertyValueModuelHolderList
	 * @return
	 */
	public static ActionResponse login(List<DomainPropertyValueModelHolder> domainPropertyValueModuelHolderList){
		
		ActionResponse actionResponse = new ActionResponse();
		
		actionResponse.setActionType(ActionTypes.LOGIN_ACTION);
		
		for(DomainPropertyValueModelHolder holder : domainPropertyValueModuelHolderList){
			
			try{
				
				Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(holder.getDomainObject());
				
				String className = JavaBeanUtils.getClassName(clazz);
				
				Map<String, Class<?>> propertyReturnTypeMap = JavaBeanUtils.getPropertiesOfBean(clazz);
				
//				Map<String, List<String>> objectPropertiesListMap = new HashMap<String, List<String>>();
				
				Map<String, MapValueModel> propertyMapValueModelMap = holder.getDomainPropertyModelMap();
				
				Collection<MapValueModel> mapValueModelCollection = propertyMapValueModelMap.values();

				/*
				 * checking if the any of the MapValueModel is consider as dirty of the given Domain Object screen
				 */
				if(MapValueModelDirtyChecker.checkMapValueModelIsDirty(mapValueModelCollection)){

					Map<String, Object> propertiesValueMap =
						MapValueModelDirtyChecker.createDirtyPropertiesValuesMap(mapValueModelCollection);
					
					String query = "";
					
					if(propertiesValueMap.size() == 0){
						
//						return actionResponse;
					}else{
						
						query = DynamicJPAQueryGenerator.createQuery(className, propertiesValueMap, propertyReturnTypeMap);
						
						List<? extends Object> rsltList = EagleCoderGeneralDelegate.getObjectByQuery(query, propertiesValueMap);
						
						if(rsltList.size() > 0){
						
							actionResponse.setDataToReturn(processResultList(rsltList));
							
						}else{
							
							actionResponse.getErrors().put("login.user.error", "username and/or password is not correct");
						}
					}
					
				}else {
					
					actionResponse.getErrors().put("login.cannot.empty", "UserName and/or password cannot be empty");
				}
				
			}catch(Exception e){
				
				e.printStackTrace();
			}
		}
		
		if(null != actionResponse.getErrors() && actionResponse.getErrors().size() > 0){
			
			CancelAction.cancel(domainPropertyValueModuelHolderList);
		}
		
		return actionResponse;
	}
	
	/**
	 * 
	 * @param rsltList
	 * @return
	 */
	private static Map<Class<? extends Object> , List<Map<String, Object>>> processResultList(List<? extends Object> rsltList){
		
		Class<? extends Object> clazzName = null;
		List<Map<String, Object>> resultListMap = new ArrayList<Map<String,Object>>();
		
		Map<Class<? extends Object> , List<Map<String, Object>>> rtrnDataMap =
			new HashMap<Class<? extends Object>, List<Map<String,Object>>>();
		
		for(Object object : rsltList){
			
			if(null == clazzName)
				clazzName = object.getClass();
			
			resultListMap.add(BeanMapUtils.bean2MapConverter(object));
		}
		
		rtrnDataMap.put(clazzName, resultListMap);
		
		return rtrnDataMap;
	}
}