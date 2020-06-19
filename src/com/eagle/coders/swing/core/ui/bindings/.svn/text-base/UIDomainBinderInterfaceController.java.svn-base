package com.eagle.coders.swing.core.ui.bindings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.eagle.coders.swing.core.ui.annotations.Action;
import com.eagle.coders.swing.core.ui.annotations.Actions;
import com.eagle.coders.swing.core.ui.annotations.DomainObject;
import com.eagle.coders.swing.core.ui.annotations.DomainObjects;
import com.eagle.coders.swing.core.ui.annotations.DomainProperties;
import com.eagle.coders.swing.core.ui.annotations.ExceptDomainObjectPropertyPolicy;
import com.eagle.coders.swing.core.ui.annotations.MultipleExceptDomainObjectPropertyPolicies;
import com.eagle.coders.swing.core.ui.annotations.type.DomainPerpertiesAllowType;
import com.eagle.coders.swing.core.ui.cache.ComponentActionCache;
import com.eagle.coders.swing.core.ui.cache.DomainPropertyValueModelHolder;
import com.eagle.coders.swing.core.ui.cache.DomainUIPropertiesMapCache;
import com.eagle.coders.swing.core.ui.cache.UIComponentDomainPropertyHolder;
import com.eagle.coders.swing.core.ui.cache.UIComponentPropertyValueModelHolder;
import com.eagle.coders.swing.core.ui.cache.UIDomainExceptPropertyHolder;
import com.eagle.coders.swing.core.ui.cache.UIDomainPropertyHolder;
import com.eagle.coders.swing.core.ui.controller.utils.JavaBeanUtils;
import com.eagle.coders.swing.core.ui.controller.utils.Map4BindingUtils;
import com.eagle.coders.swing.core.ui.decorator.UIFormDecorator;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;

/**
 * 
 * @author Anees
 * @history Ausgust 04,2009 : added boolean isXMLForm in Constructor UIDomainBinderInterfaceController(T component, boolean isXMLForm)
 * 							  to allow the feature to generate XML form structure for web based clients
 *
 */
public class UIDomainBinderInterfaceController <T extends IComponent> {

	private T component;
	
	public UIDomainBinderInterfaceController(T component, boolean isXMLForm){
		
		this.component = component;
		
		createBindableInterface();
		
		UIFormDecorator.getInstance().decorate(component.getComponentIdentity(), isXMLForm);
		
		/*
		 * setting the generated panel to the IComponent
		 */
		if(!isXMLForm){
			
			component.setPanel(UIFormDecorator.getInstance().getMainPanel());
			
		}else{
			
			component.setXml(UIFormDecorator.getInstance().getXmlForm());
		}
	}
	
	/**
	 * 
	 */
	public void createBindableInterface(){
		
		String componentID = component.getComponentIdentity();
		
		List<Class> clazzList = null;
		
		Map<Integer, Class> clazzPositionMap = null;
		
		if(component.getClass().isAnnotationPresent(DomainObjects.class)){
			
			DomainObjects domainObjects = component.getClass().getAnnotation(DomainObjects.class);
			
			DomainObject domainObject[] = domainObjects.values();

			clazzPositionMap = getDomainObjects(componentID, domainObject);

		}else if(component.getClass().isAnnotationPresent(DomainObject.class)){
			
			clazzList = new ArrayList<Class>();
			
			clazzPositionMap = new HashMap<Integer, Class>();
			
			DomainObject domainObject = component.getClass().getAnnotation(DomainObject.class);
			
			clazzList.add(getDomainObject(componentID, domainObject));
			
			clazzPositionMap.put(Integer.valueOf(domainObject.position()), getDomainObject(componentID, domainObject));
			
		}
		
		/* == Processing The Action Associated with the Usecase == */
		processAndStoreActionAssociated(component.getClass());
		
		Map<Class, List<UIDomainPropertyHolder>> clazzParamterMapAfterValidation = 
			getAllowedPropertiesOfDomainObjects(createBindingSetup(clazzPositionMap),
					requiredDomainPropertiesFromDomainObject());
		
		UIComponentDomainPropertyHolder uiCompDomainHolder =
			new UIComponentDomainPropertyHolder(componentID, clazzParamterMapAfterValidation);
	
		DomainUIPropertiesMapCache.getInstance().setUiCompDomainHolder(uiCompDomainHolder);
		
		/* ===== Creating the Binding Information =====*/
		List<DomainPropertyValueModelHolder> domainNameValueModelList =
			Map4BindingUtils.getMap4Binding(clazzParamterMapAfterValidation);
		
		UIComponentPropertyValueModelHolder compValueModelHolder =
			new UIComponentPropertyValueModelHolder(componentID, domainNameValueModelList);
		
		DomainUIPropertiesMapCache.getInstance().setCompValueModelHolder(compValueModelHolder);
		
		DomainUIPropertiesMapCache.getInstance().addCompValueModelHolder2List(compValueModelHolder);
		
		
	}
	
	/**
	 * 
	 * @param usecaseClazz
	 */
	private void processAndStoreActionAssociated( final Class<? extends Object> usecaseClazz ){

		List<Action> actionList = new ArrayList<Action>();
		
		List<Map<ActionTypes, Action>> actionTypeMapList = new ArrayList<Map<ActionTypes,Action>>();
		
		if(usecaseClazz.isAnnotationPresent(Actions.class)){
			
			Actions actions =(Actions) usecaseClazz.getAnnotation(Actions.class);
			
			Action[] actionArray = actions.actions();
			
			
			for(Action action : actionArray){
				
				ActionTypes actionType = action.actionType();
				
				Map<ActionTypes, Action> actionTypeActionMap = new HashMap<ActionTypes, Action>();
				
				actionTypeActionMap.put(actionType, action);
				
				actionTypeMapList.add(actionTypeActionMap);
//				actionList.add(action);
			}
			
			ComponentActionCache.getInstance().setComponentActionTypeActionListMap(component.getComponentIdentity(), actionTypeMapList);
			
		}else if(usecaseClazz.isAnnotationPresent(Action.class)){
			
			Action action = usecaseClazz.getAnnotation(Action.class);
			
			ActionTypes actionType = action.actionType();

			Map<ActionTypes, Action> actionTypeActionMap = new HashMap<ActionTypes, Action>();
			
			actionTypeActionMap.put(actionType, action);
			
			actionTypeMapList.add(actionTypeActionMap);
//			actionList.add(action);
			
			ComponentActionCache.getInstance().setComponentActionTypeActionListMap(component.getComponentIdentity(), actionTypeMapList);
		}
		
		/* == Storing the Action cache for action processing == */
//		ComponentActionCache.getInstance().setComponentActionListMap(component.getComponentIdentity(), actionList);

	}
	
	/**
	 * 
	 * @param clazzParamterMap
	 * @param uiDomainPropertyExepHolderList
	 */
	private Map<Class, List<UIDomainPropertyHolder>> getAllowedPropertiesOfDomainObjects(Map<Class, List<UIDomainPropertyHolder>> clazzParamterMap, 
			List<UIDomainExceptPropertyHolder> uiDomainPropertyExepHolderList ){
		
		if(uiDomainPropertyExepHolderList.size() > 0){

			for(UIDomainExceptPropertyHolder uiDomainExcepPeroperty : uiDomainPropertyExepHolderList) {
				
				if(clazzParamterMap.containsKey(uiDomainExcepPeroperty.getDomainObject())){
					
					List<UIDomainPropertyHolder> uidomainPeroertyHolderList =
						clazzParamterMap.get(uiDomainExcepPeroperty.getDomainObject());
					
					List<UIDomainPropertyHolder> uidomainPeroertyHolderList0 = 
						validatePropertiesViaPolicy(uiDomainExcepPeroperty.getPolicy() ,
								uidomainPeroertyHolderList, uiDomainExcepPeroperty.getPropertyList());
					
					clazzParamterMap.put(uiDomainExcepPeroperty.getDomainObject(), uidomainPeroertyHolderList0);
				}
			}
			
			return clazzParamterMap;
			
		}else{
			
			return clazzParamterMap;
			
		}
	}
	
	/**
	 * TODO: i need to verify this method in future
	 * @param policy
	 * @param uidomainPeroertyHolderList
	 * @param properties
	 */
	private List<UIDomainPropertyHolder> validatePropertiesViaPolicy(DomainPerpertiesAllowType policy, List<UIDomainPropertyHolder> uidomainPeroertyHolderList,
			List<String> properties){
		
		List<UIDomainPropertyHolder> uidomainPeroertyHolderList0 = uidomainPeroertyHolderList ;
		
		List<UIDomainPropertyHolder> updatedPropertyHolderList = new ArrayList<UIDomainPropertyHolder>();
		
		if(policy.equals(DomainPerpertiesAllowType.ALLOW_ALL)){
			
			
			for(String property : properties){
				
				for(UIDomainPropertyHolder uiDomainPropertyHolder : uidomainPeroertyHolderList0){

					if(!property.equals(uiDomainPropertyHolder.getDomainProperty())){
						
//						uidomainPeroertyHolderList0.remove(uiDomainPropertyHolder);
						updatedPropertyHolderList.add(uiDomainPropertyHolder);
						
					}
				}
				
			}
		}else {
			
//			uidomainPeroertyHolderList0 = new ArrayList<UIDomainPropertyHolder>();
			
			for(String property : properties){
				
				for(UIDomainPropertyHolder uiDomainPropertyHolder : uidomainPeroertyHolderList){

					if(property.equals(uiDomainPropertyHolder.getDomainProperty())){
						
						updatedPropertyHolderList.add(uiDomainPropertyHolder);
						
					}
				}
			}
		}
		return updatedPropertyHolderList;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private Map<Integer, Class> getDomainObjects(final String componentID, final DomainObject domainObjects[]){
		
		List<Class> clazzList = new ArrayList<Class>();
		
		Map<Integer, Class> clazzPositionMap = new HashMap<Integer, Class>();
		
		for(int i = 0 ; i < domainObjects.length; i++){
			
			DomainObject domainObject = domainObjects[i];
			
			clazzPositionMap.put(Integer.valueOf(domainObject.position()), domainObject.domainObject());
			
			clazzList.add(getDomainObject(componentID, domainObjects[i]));
			
		}
		
		
		return clazzPositionMap;
	}
	
	/**
	 * 
	 * @param domainObject
	 * @return
	 */
	private Class<?> getDomainObject(final String componentID, final DomainObject domainObject){
		
		return domainObject.domainObject();
	}
	
	/**
	 * 
	 * @param embedableUsecases
	 */
	
	/**
	 * 
	 * @param clazzList
	 * @return
	 */
	private Map<Class, List<UIDomainPropertyHolder>> createBindingSetup(Map<Integer, Class> clazzMap){
		
		
		Map<Class, List<UIDomainPropertyHolder>> clazzParamterMap = new HashMap<Class, List<UIDomainPropertyHolder>>();
		
		Map<Integer, Class> positionClazzes = new TreeMap<Integer, Class>(clazzMap);
		
		DomainUIPropertiesMapCache.getInstance().addClazzPositionHolder(component.getComponentIdentity(),positionClazzes);
		
		Set<Integer> iSet = positionClazzes.keySet();
		
		for(Integer seq : iSet){
			
			Class clazz = positionClazzes.get(seq);
			
			List<UIDomainPropertyHolder> holder = JavaBeanUtils.processClazz(clazz);
			
			clazzParamterMap.put(clazz, holder);
		}
		
		return clazzParamterMap;
		
	}

	/**
	 * 
	 * @param exceptDomainObjectPropertyPolicies
	 * @return
	 */
	private List<ExceptDomainObjectPropertyPolicy> getExceptDomainObjectPolicy(ExceptDomainObjectPropertyPolicy exceptDomainObjectPropertyPolicies[]){

		List<ExceptDomainObjectPropertyPolicy> exceptDomainPropertyList =
			new ArrayList<ExceptDomainObjectPropertyPolicy>();
		
		for(ExceptDomainObjectPropertyPolicy exceptDomainObjectExptPolicy : exceptDomainObjectPropertyPolicies){
			
			exceptDomainPropertyList.add(exceptDomainObjectExptPolicy);
		}
		
		return exceptDomainPropertyList;
	}
	
	/**
	 * @return
	 * @param domainProperties
	 */
	private List<String> processDomainProperties(DomainProperties domainProperties[]){
		
		List<String> propertyList = new ArrayList<String>();
		
		for(DomainProperties domainPropertys : domainProperties ){
			
			propertyList.add(domainPropertys.property());
		}
		
		return propertyList;
	}
	
	/**
	 * 
	 * @param exceptDomainObjectPropertyPolicy
	 */
	private UIDomainExceptPropertyHolder processExceptDomainObjectPropertyPolicy(ExceptDomainObjectPropertyPolicy exceptDomainObjectPropertyPolicy){
		
		UIDomainExceptPropertyHolder uiDomainPropertyExepHolder = new UIDomainExceptPropertyHolder();
		
		uiDomainPropertyExepHolder.setDomainObject(exceptDomainObjectPropertyPolicy.domainObject());
		
		uiDomainPropertyExepHolder.setPolicy(exceptDomainObjectPropertyPolicy.genralPolicy());

		uiDomainPropertyExepHolder.setPropertyList(processDomainProperties(exceptDomainObjectPropertyPolicy.properties()));

		return uiDomainPropertyExepHolder;
	}

	/**
	 * 
	 * @param exceptDomainPropertyList
	 */
	private List<UIDomainExceptPropertyHolder> processExceptDomainObjectPropertyPolicyList(List<ExceptDomainObjectPropertyPolicy> exceptDomainPropertyList){
		
		List<UIDomainExceptPropertyHolder> uiDomainPropertyExepHolderList = new ArrayList<UIDomainExceptPropertyHolder>();
		
		for(ExceptDomainObjectPropertyPolicy exceptDoaminPropertyPlicy : exceptDomainPropertyList){
			
			uiDomainPropertyExepHolderList.add(processExceptDomainObjectPropertyPolicy(exceptDoaminPropertyPlicy));
		}
		
		return uiDomainPropertyExepHolderList;
	}

	/**
	 * 
	 * @return
	 */
	private List<UIDomainExceptPropertyHolder> requiredDomainPropertiesFromDomainObject(){
		
		List<UIDomainExceptPropertyHolder> uiDomainPropertyExepHolderList = null;
		
		if(component.getClass().isAnnotationPresent(MultipleExceptDomainObjectPropertyPolicies.class)){
			
			MultipleExceptDomainObjectPropertyPolicies multipleExceptDomainObjectPropertyPolicies = 
					component.getClass().getAnnotation(MultipleExceptDomainObjectPropertyPolicies.class);
			
			ExceptDomainObjectPropertyPolicy exceptDomainObjectPropertyPolicy[] = 
				multipleExceptDomainObjectPropertyPolicies.getValue();
			
			uiDomainPropertyExepHolderList = 
				processExceptDomainObjectPropertyPolicyList(getExceptDomainObjectPolicy(exceptDomainObjectPropertyPolicy));
			
		}else if(component.getClass().isAnnotationPresent(ExceptDomainObjectPropertyPolicy.class)){
			
			ExceptDomainObjectPropertyPolicy exceptDomainObjectPropertyPolicy = 
				component.getClass().getAnnotation(ExceptDomainObjectPropertyPolicy.class);
			
			uiDomainPropertyExepHolderList = new ArrayList<UIDomainExceptPropertyHolder>();
			
			uiDomainPropertyExepHolderList.add(processExceptDomainObjectPropertyPolicy(exceptDomainObjectPropertyPolicy));
			
		}
		
		if(null == uiDomainPropertyExepHolderList)
			uiDomainPropertyExepHolderList = new  ArrayList<UIDomainExceptPropertyHolder>();
		
		return uiDomainPropertyExepHolderList;
	}
}