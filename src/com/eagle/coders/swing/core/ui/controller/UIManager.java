/**
 * 
 */
package com.eagle.coders.swing.core.ui.controller;

import java.util.Map;

import javax.swing.JPanel;

import com.eagle.coders.swing.core.ui.bindings.UIDomainBinderInterfaceController;
import com.eagle.coders.swing.core.ui.cache.ComponentFormContainerMapCache;
import com.eagle.coders.swing.core.ui.frame.FormContainer;
import com.eagle.coders.swing.core.ui.frame.container.builder.UseCaseContainerBuilder;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;

/**
 * @author Anees
 *
 */
public class UIManager {
	
	/**
	 * 
	 * @param usecaseKey
	 * @return
	 */
	public static FormContainer<IComponent> getUsecaseByKey( final String componentID){
		
		FormContainer<IComponent> formConatainer = ComponentFormContainerMapCache.getInstance().getComponentContainerMap(componentID);
		
		if(null == formConatainer){
			
			UseCaseContainerBuilder.getInstance().loadAllComponentsToCache();
		}
		return ComponentFormContainerMapCache.getInstance().getComponentContainerMap(componentID);
	}
	
	/**
	 * 
	 * @param componentID
	 * @return
	 */
	public static JPanel getPanelByKey(final String componentID ){

		FormContainer<IComponent> formConatainer = ComponentFormContainerMapCache.getInstance().getComponentContainerMap(componentID);
		
		if(null == formConatainer){
			
			UseCaseContainerBuilder.getInstance().loadAllComponentsToCache();
		}
		return ComponentFormContainerMapCache.getInstance().getComponentContainerMap(componentID).getComponent().getPanel();

	}
	
	/**
	 * 
	 * @return
	 */
	public static Map<String, FormContainer<IComponent>> getAllForms(){
		
		Map<String, FormContainer<IComponent>> forms =
			ComponentFormContainerMapCache.getInstance().getAllComponentContainer();
		
		if(null == forms )
			UseCaseContainerBuilder.getInstance().loadAllComponentsToCache();
		
		return ComponentFormContainerMapCache.getInstance().getAllComponentContainer();
	}
	
	
	/**
	 * 
	 * @param <T>
	 * @param component
	 * @return
	 */
	public static <T extends IComponent> FormContainer<IComponent>  getUsecaseByComponent(final T component ){
		
		UIDomainBinderInterfaceController<IComponent> componentFace =
			new UIDomainBinderInterfaceController<IComponent>(component, false);
		
		FormContainer<IComponent> container = new FormContainer<IComponent>(component);

		return container;
	}

}
