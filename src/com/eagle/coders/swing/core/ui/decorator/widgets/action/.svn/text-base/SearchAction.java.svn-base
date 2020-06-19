/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eagle.coders.swing.core.ui.annotations.Action;
import com.eagle.coders.swing.core.ui.bindings.BeanMapUtils;
import com.eagle.coders.swing.core.ui.bindings.MapValueModel;
import com.eagle.coders.swing.core.ui.bindings.MapValueModelDirtyChecker;
import com.eagle.coders.swing.core.ui.cache.ComponentActionCache;
import com.eagle.coders.swing.core.ui.cache.DomainPropertyValueModelHolder;
import com.eagle.coders.swing.core.ui.controller.utils.JavaBeanUtils;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.jpa.DynamicJPAQueryGenerator;
import com.eaglecoders.control.server.delegates.EagleCoderGeneralDelegate;
import com.eaglescoders.userprofile.ejb.domain.UserDomain;

/**
 * @author Anees
 *
 */
public class SearchAction {
	
	/**
	 * 
	 * @param domainPropertyValueModuelHolder
	 */
	public static ActionResponse search(final ActionRequest actionRequest,
			final List<DomainPropertyValueModelHolder> domainPropertyValueModuelHolderList){
		
		System.out.println("[SearchAction] ::");
		
		ActionResponse actionResponse = new ActionResponse();
		
		actionResponse.setActionType(ActionTypes.SEARCH_ACTION);
		
		for(DomainPropertyValueModelHolder holder : domainPropertyValueModuelHolderList){
			
			try{
				
				Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(holder.getDomainObject());
				
				String className = JavaBeanUtils.getClassName(clazz);

				Map<String, Class<?>> propertyReturnTypeMap = JavaBeanUtils.getPropertiesOfBean(clazz);
				
				Map<String, List<String>> objectPropertiesListMap = new HashMap<String, List<String>>();
				
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
						
					}else{
						
//						TODO: For Temporary purpose... : I have to resolve this by some technical way
						if(actionResponse.getErrors().containsKey("login.query.nosearch")){
							
							actionResponse.getErrors().clear();
							
						}
						query = DynamicJPAQueryGenerator.createQuery(className, propertiesValueMap, propertyReturnTypeMap);
						
						System.out.println("[SearchAction] :: query :: "+query);
	
						
//						======= Checking wether usecase specific search implementation available or not ===== 
						Map<String, List<Map<ActionTypes, Action>>> componentActionTypesAtionListMap =
							ComponentActionCache.getInstance().getComponentActionTypeActionListMap();
						if(null == componentActionTypesAtionListMap ){
							
							if(componentActionTypesAtionListMap.containsKey(actionRequest.getComponentIDtoProcess())){
								
								List<Map<ActionTypes, Action>> actiontypesActionMapList =
									componentActionTypesAtionListMap.get(actionRequest.getComponentIDtoProcess());
								
								for(Map<ActionTypes, Action> actionTypesActionMap : actiontypesActionMapList ){
									
									if(actionTypesActionMap.containsKey(ActionTypes.SEARCH_ACTION)){

										ExecutionRequest executionRequest = new ExecutionRequest();
										
										executionRequest.setActionTypes(ActionTypes.SEARCH_ACTION);
										
										executionRequest.setQuery(query);
										
										executionRequest.setPropertiesValueMap(propertiesValueMap);
										
										Action action = actionTypesActionMap.get(ActionTypes.SEARCH_ACTION);
										
										Class<? extends IExecution> executionCLzz = action.exeution();
										
										if(!executionCLzz.getClass().getName().equals(Action.Empty.class.getName())){

											try{
												
												IExecution execution = executionCLzz.newInstance();
												
												ExecutionResponse executionResponse = execution.execute(executionRequest);
												
												if(executionResponse.hasErrors()){
													
													actionResponse.setErrors(executionResponse.getErrors());
													
												}else{
													
													actionResponse.setDataToReturn(executionResponse.getDataWithDomainObjectMap());
												}
												
											}catch(Exception e){
												
											}
										}


									}else {

										List<? extends Object> rsltList = EagleCoderGeneralDelegate.getObjectByQuery(query, propertiesValueMap);
										
										Class<? extends Object> object = rsltList.iterator().next().getClass();

										System.out.println(" ResultList :: size :: "+ rsltList.size());

										if(rsltList.size() > 0){
								
											List<Map<String, Object>> mapList = processBeans(rsltList);
											
											actionResponse.addDataToReturn(object, mapList);
											
										}else{
											
											actionResponse.getErrors().put("login.query.error", "No Record Found!");
										}

									}
								}
							}
						}else {
							
							List<? extends Object> rsltList = EagleCoderGeneralDelegate.getObjectByQuery(query, propertiesValueMap);
							
							Class<? extends Object> object = rsltList.iterator().next().getClass();

							System.out.println(" ResultList :: size :: "+ rsltList.size());

							if(rsltList.size() > 0){
					
								List<Map<String, Object>> mapList = processBeans(rsltList);
								
								actionResponse.addDataToReturn(object, mapList);
								
							}else{
								
								actionResponse.getErrors().put("login.query.error", "No Record Found!");
							}

						}
						
//						List<? extends Object> rsltList = EagleCoderGeneralDelegate.getObjectByQuery(query, propertiesValueMap);
//						
//						Class<? extends Object> object = rsltList.iterator().next().getClass();
//
//						System.out.println(" ResultList :: size :: "+ rsltList.size());
//
//						if(rsltList.size() > 0){
//				
//							List<Map<String, Object>> mapList = processBeans(rsltList);
//							
//							actionResponse.addDataToReturn(object, mapList);
//							
//						}else{
//							
//							actionResponse.getErrors().put("login.query.error", "No Record Found!");
//						}
					}
				}
				else {
//					TODO: Checking how to control the the No Data Found for this Serach
					if(actionResponse.getDataToReturn().size() == 0)
						actionResponse.getErrors().put("login.query.nosearch", "No Record For Search");
				}
				
			}catch(ClassNotFoundException cne){
//				DO NOTHING ...............
			}
//			break; //TODO: for temporary purpose
		}
		
		return actionResponse; //TODO: for temporary purpose
	}
	
	/**
	 * 
	 * @param rsltList
	 * @return
	 */
	private static List<Map<String, Object>> processBeans(List<? extends Object> rsltList){
		
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		
		for(Object object : rsltList){
			
			UserDomain userDomain = (UserDomain)object;
			
			mapList.add(BeanMapUtils.bean2MapConverter(object));
			
		}
		
		return mapList;
	}
}
