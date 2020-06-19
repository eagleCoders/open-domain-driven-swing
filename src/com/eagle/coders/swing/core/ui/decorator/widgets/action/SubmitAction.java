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
import com.eagle.coders.swing.core.ui.cache.ComponentActionCache;
import com.eagle.coders.swing.core.ui.cache.DomainPropertyValueModelHolder;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.jgoodies.binding.list.ArrayListModel;

/**
 * @author Anees
 * 
 * TODO: Have to work on the JTable data to get and process
 *
 */
public class SubmitAction {

	public static ActionResponse submit(final ActionRequest actionRequest, 
			final List<DomainPropertyValueModelHolder> domainPropertyValueModuelHolderList){
		
		System.out.println("[SubmitAction] ::");
		
		List<Object> domainObjectList = new ArrayList<Object>();
		
		for(DomainPropertyValueModelHolder holder : domainPropertyValueModuelHolderList){
			
			try{
				
				Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(holder.getDomainObject());
				
				Map<String, MapValueModel> propertyMapValueModelMap = holder.getDomainPropertyModelMap();
				
				Map<String, ArrayListModel<Map<String, Object>>> childTableDataMap = holder.getChildDomainTableDataMap();
				
				Collection<MapValueModel> mapValueModelCollection = propertyMapValueModelMap.values();
				
				Map<String, Object> map2Bind = new HashMap<String, Object>();
				
				for(MapValueModel valueBean : mapValueModelCollection){
					
					map2Bind.put(valueBean.getKey().toString(), valueBean.getValue());

				}
				
				System.out.println("[SubmitAction] :: map2Bind :: "+ map2Bind);
				
				Object obj = clazz.newInstance();
				
				BeanMapUtils.map2BeanConverter(obj , map2Bind, childTableDataMap);
				
				domainObjectList.add(obj);
				
				ExecutionRequest executionRequest = new ExecutionRequest();
				
				executionRequest.setActionTypes(ActionTypes.SUBMIT_ACTION);
				
				executionRequest.setObjectsToProceed(domainObjectList);
				
				Map<String, List<Map<ActionTypes, Action>>> componentActionTypesAtionListMap =
					ComponentActionCache.getInstance().getComponentActionTypeActionListMap();
				
				if(componentActionTypesAtionListMap.containsKey(actionRequest.getComponentIDtoProcess())){
					
					List<Map<ActionTypes, Action>> actiontypesActionMapList =
						componentActionTypesAtionListMap.get(actionRequest.getComponentIDtoProcess());
					
					for(Map<ActionTypes, Action> actionTypesActionMap : actiontypesActionMapList ){
						
						if(actionTypesActionMap.containsKey(ActionTypes.SUBMIT_ACTION)){
							
							Action action = actionTypesActionMap.get(ActionTypes.SUBMIT_ACTION);
							
							Class<? extends IExecution> executionCLzz = action.exeution();
							
							if(!executionCLzz.getClass().getName().equals(Action.Empty.class.getName())){

								IExecution execution = executionCLzz.newInstance();
								
								execution.execute(executionRequest);
							}
							
						}
					}
						
				}
			}catch(Exception e){
				return null;
//				DO NOTHING ...............
			}
		}
		
		return new ActionResponse(); //TODO: for temporary purpose
	}
}
