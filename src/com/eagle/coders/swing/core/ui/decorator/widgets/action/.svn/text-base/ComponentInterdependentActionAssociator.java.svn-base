/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JComponent;

import com.eagle.coders.swing.core.ui.cache.DomainUIPropertiesMapCache;
import com.eagle.coders.swing.core.ui.cache.UiComponentsInterBindingInformationHolder;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.WidgetRelationshipTypes;
import com.eagle.coders.swing.core.ui.decorator.widgets.listener.ActionListenerAssociator;

/**
 * @author Anees
 *
 */
public class ComponentInterdependentActionAssociator {

	/**
	 * 
	 */
	public static void associateInterComponentBinding(String componentID){
		
		UiComponentsInterBindingInformationHolder holder =
			DomainUIPropertiesMapCache.getInstance().getComponentInterBindingInfoFromComponentID(componentID);
		
		if(null != holder){

			Map<String, String> parentChildMap = holder.getParentChildComponentHolder();
			
			Map<String, JComponent> componentMap = holder.getPropertyComponentHolder();
			
			Set<String> parentSet = parentChildMap.keySet();
			
			for(String parentComp : parentSet){

				Map<String, Object> parnentDependentMap = new HashMap<String, Object>();
				
				Map<String, JComponent> parentlevelCompMap = new HashMap<String, JComponent>();
				
				JComponent parentComponent = null;
				
				if(componentMap.containsKey(parentComp)){
					
					parentComponent = componentMap.get(parentComp);
					
					parentlevelCompMap.put(parentComp, componentMap.get(parentComp));
					
					parnentDependentMap.put(WidgetRelationshipTypes.WIDGET_PARENT.getValue(), parentComp);

					new ActionListenerAssociator(null, componentID, parnentDependentMap ,parentComponent);
				}

			}
			
		}
		
	}
	

}
