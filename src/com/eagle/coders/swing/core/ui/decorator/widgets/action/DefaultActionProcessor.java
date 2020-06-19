/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.action;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import nl.jj.swingx.gui.modal.JModalInternalFrame;

import com.eagle.coders.swing.core.ui.bindings.MapValueModel;
import com.eagle.coders.swing.core.ui.bindings.MapValueModelDirtyChecker;
import com.eagle.coders.swing.core.ui.cache.DomainPropertyValueModelHolder;
import com.eagle.coders.swing.core.ui.cache.DomainUIPropertiesMapCache;
import com.eagle.coders.swing.core.ui.cache.UIComponentPropertyValueModelHolder;
import com.eagle.coders.swing.core.ui.cache.UiComponentsInterBindingInformationHolder;
import com.eagle.coders.swing.core.ui.cache.session.ApplicationSession;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.WidgetRelationshipTypes;
import com.eagle.coders.swing.core.ui.frame.IFormContainer;
import com.eagle.coders.swing.core.ui.usecase.container.cache.UsecaseContainerComponentCache;

/**
 * @author Anees
 *
 */
public class DefaultActionProcessor implements IAction {

	private UIComponentPropertyValueModelHolder uiComoponentPropertyValueModelHolder;
	
	private static List<UIComponentPropertyValueModelHolder> uiComoponentPropertyValueModelHolderList; //TODO: changed on 27-07-2009
	
	@Override
	public ActionResponse execute(ActionRequest actionRequest) {
		
		uiComoponentPropertyValueModelHolder = DomainUIPropertiesMapCache.getInstance().getCompValueModelHolder();
		
		uiComoponentPropertyValueModelHolderList = 
			DomainUIPropertiesMapCache.getInstance().getCompValueModelHolderList();
		
		ActionResponse actionResponse = new ActionResponse();
		
		String componentID = actionRequest.getComponentIDtoProcess();
		
		ActionTypes actionType = actionRequest.getActionTypes();
		
		Map<String, Object> paramters = actionRequest.getParamters();
		
		processLoginAction(actionRequest);
		
		processLockUnLockAction(actionRequest);
		
		processSearchAction(actionRequest);
		
		processSubmitAction(actionRequest);
		
		processCancelAction(componentID, actionType);
		
		processDeleteAction(actionRequest);
		
		processInterComponentBindingAction(componentID, actionType, paramters);
		
		return actionResponse;
	}
	
	/**
	 * 
	 * @param actionRequest
	 */
	private void processLockUnLockAction(ActionRequest actionRequest){

		ActionResponse actionResponse = new ActionResponse();
		
		if(actionRequest.getActionTypes().equals(ActionTypes.LOCK_ACTION)){
			
			System.out.println("[DefaultActionProcess] :: LockUnlockAction ");
			
			IFormContainer container = actionRequest.getFormContainer();
			
			List<Map<String, Object>> rsltMap = ApplicationSession.getSession().getUserFromSession();
			
			List<DomainPropertyValueModelHolder> domainPropertyValueModuelHolderList =
				getDomainPropertyValueModelList(actionRequest.getComponentIDtoProcess());

			LockAction.lock(actionRequest, container, domainPropertyValueModuelHolderList);
			
//			if(null != domainPropertyValueModuelHolderList){
//				
//				for(DomainPropertyValueModelHolder holder : domainPropertyValueModuelHolderList){
//
//					Map<String, MapValueModel> propertyMapValueModelMap = holder.getDomainPropertyModelMap();
//
//					Collection<MapValueModel> mapValueModelCollection = propertyMapValueModelMap.values();
//
//					if(MapValueModelDirtyChecker.checkMapValueModelIsDirty(mapValueModelCollection)){
//						
//						Map<String, Object> propertiesValueMap =
//							MapValueModelDirtyChecker.createDirtyPropertiesValuesMap(mapValueModelCollection);
//						
//						for(Map<String, Object> map : rsltMap){
//							
//							if(map.containsKey("Password")){ //TODO: this is temporary purpose : have to make the tableMap to beanMap converter
//								
//								String password = propertiesValueMap.get("password").toString();
//								
//								String oPassword = map.get("Password").toString();
//								
//								if(password.equals(oPassword)){
//									
//									CancelAction.cancel(domainPropertyValueModuelHolderList);
//									
//									container.onSuccess(actionResponse);
//									
//									
//								}else{
//									
//									CancelAction.cancel(domainPropertyValueModuelHolderList);
//									
//									actionResponse.getErrors().put("lock.password.error", "password not correct");
//									
//									container.onFailure(null, actionResponse);
//								}
//							}
//						}
//						
//					}
//				}
//			
//			}
			
		}
	}
	
	/**
	 * 
	 * @param actionRequest
	 * @return
	 */
	private void processLoginAction(ActionRequest actionRequest){
		
		ActionResponse actionResponse = null;
		
		if(actionRequest.getActionTypes().equals(ActionTypes.LOGIN_ACTION)){
			
			System.out.println("[DefaultActionProcess] :: LoginAction ");
			
			IFormContainer container = actionRequest.getFormContainer();
			
			List<DomainPropertyValueModelHolder> domainPropertyValueModuelHolder =
				getDomainPropertyValueModelList(actionRequest.getComponentIDtoProcess());
			
			if(null != domainPropertyValueModuelHolder){
				
				actionResponse = LoginAction.login(domainPropertyValueModuelHolder);
				
				if(actionResponse.getErrors().size() > 0){
					
					container.onFailure(null,actionResponse);
					
				}else
					container.onSuccess(actionResponse);
				
			}
		}
	}
	
	/**
	 * 
	 * @param componentID
	 * @param actionType
	 */
	private void processSearchAction(ActionRequest actionRequest){
		
		
		if(actionRequest.getActionTypes().equals(ActionTypes.SEARCH_ACTION)){
			
			System.out.println("[DefaultActionProcess] :: searchAction ");
			
			List<DomainPropertyValueModelHolder> domainPropertyValueModuelHolder =
				getDomainPropertyValueModelList(actionRequest.getComponentIDtoProcess());
			
			if(null != domainPropertyValueModuelHolder){
				
				ActionResponse actionResponse =  SearchAction.search(actionRequest, domainPropertyValueModuelHolder);
				 
				 String compID = actionRequest.getComponentIDtoProcess();
				 
				 IFormContainer container = actionRequest.getFormContainer();
				 
//				 JInternalFrame frame = UsecaseContainerComponentCache.getInstance().getUsecaseContaineriFrameMap(compID);

				 JModalInternalFrame frame  = UsecaseContainerComponentCache.getInstance().getUsecaseContaineriModalFrameMap(compID);

					if(actionResponse.getErrors().size() > 0){
						
						container.onFailure(frame,actionResponse);

					}else{
						
						actionResponse.setActionType(ActionTypes.SEARCH_ACTION);
						
						container.onAction4Popup(frame,actionResponse, ActionTypes.SEARCH_ACTION);
					}
			}
		}
	}

	/**
	 * 
	 * @param componentID
	 * @param actionType
	 */
	private void processSubmitAction(ActionRequest actionRequest){
		
		if(actionRequest.getActionTypes().equals(ActionTypes.SUBMIT_ACTION)){
			
			List<DomainPropertyValueModelHolder> domainPropertyValueModuelHolder =
				getDomainPropertyValueModelList(actionRequest.getComponentIDtoProcess());

			if(null != domainPropertyValueModuelHolder){
				
				 SubmitAction.submit(actionRequest, domainPropertyValueModuelHolder);
			}
		}
	}
	
	/**
	 * 
	 * @param componentID
	 * @param actionType
	 */
	private void processDeleteAction(ActionRequest actionRequest){
		
		if(actionRequest.getActionTypes().equals(ActionTypes.DELETE_ACTION)){
			System.out.println("[DefaultActionProcess] :: deleteAction ");
	
		}
	}
	
	/**
	 * 
	 */
	private void processCancelAction(String componentID, ActionTypes actionType){
	
		if(actionType.equals(ActionTypes.CANCEL_ACTION)){
			
			List<DomainPropertyValueModelHolder> domainPropertyValueModuelHolder =
				getDomainPropertyValueModelList(componentID);
			
			if(null != domainPropertyValueModuelHolder){
				
				CancelAction.cancel(domainPropertyValueModuelHolder);
			}
		}
	}
	
	/**
	 * 
	 * @param componentID
	 */
	public static List<DomainPropertyValueModelHolder> getDomainPropertyValueModelList(String componentID){
		
		List<DomainPropertyValueModelHolder> domainPropertyValueModuelHolder = null;
		
		for(UIComponentPropertyValueModelHolder uiComoponentPropertyValueModelHolder1 : uiComoponentPropertyValueModelHolderList){

			if(uiComoponentPropertyValueModelHolder1.getComponentID().equals(componentID)){
				
				domainPropertyValueModuelHolder = uiComoponentPropertyValueModelHolder1.getDomainPropertyValueModelList();
				break;
			}

		}
		
		return domainPropertyValueModuelHolder;
	}
	
	/**
	 * 
	 * @param componentID
	 * @param actionTypes
	 * @param properties
	 */
	private void processInterComponentBindingAction(String componentID, ActionTypes actionType, Map<String, Object> prameters){
		
		if(actionType.equals(ActionTypes.INTERCOMP_BINDING_ACTION)){
			
			UiComponentsInterBindingInformationHolder holder =
				DomainUIPropertiesMapCache.getInstance().getComponentInterBindingInfoFromComponentID(componentID);

			
			Map<String, String> parentChildMap = holder.getParentChildComponentHolder();
			
			Map<String, JComponent> propertyComponentMap = holder.getPropertyComponentHolder();
			
			if(prameters.containsKey(WidgetRelationshipTypes.WIDGET_PARENT.getValue())){
				
				String parentCompName = prameters.get(WidgetRelationshipTypes.WIDGET_PARENT.getValue()).toString();

				String childCompName = parentChildMap.get(parentCompName);
				
				JComponent childComponent = null;
				
				if(propertyComponentMap.containsKey(childCompName)){
					
					childComponent = propertyComponentMap.get(childCompName);
				}
				List<DomainPropertyValueModelHolder> domainPropertyValueModuelHolderList =
					getDomainPropertyValueModelList(componentID);
				
				ComponentInterBindingAction.rebind(parentCompName, childCompName,childComponent,
						domainPropertyValueModuelHolderList);
			}
		}
	}
	
}
