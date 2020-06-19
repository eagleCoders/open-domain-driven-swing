/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import com.eagle.coders.swing.core.ui.bindings.MapValueModel;
import com.eagle.coders.swing.core.ui.cache.DomainPropertyValueModelHolder;
import com.eagle.coders.swing.core.ui.decorator.widgets.UiWidgets;

/**
 * @author Anees
 *
 */
public class ComponentInterBindingAction {

	/**
	 * 
	 * @param parentName
	 * @param childName
	 * @param domainPropertyValueModuelHolderList
	 */
	public static void rebind(String parentName, String childName,JComponent childComponent,
			List<DomainPropertyValueModelHolder> domainPropertyValueModuelHolderList){
	
		for(DomainPropertyValueModelHolder holder : domainPropertyValueModuelHolderList){
			
			Map<String, MapValueModel> propertyValueMap  = holder.getDomainPropertyModelMap();
			
			
			if(propertyValueMap.containsKey(childName)){
				
//				----------------------- TESTING List start----------------

				List<String> objectList = new ArrayList<String>();
				objectList.add("Anees1");
				objectList.add("Anees2");
				objectList.add("Anees3");
				objectList.add("Anees4");
				
//				----------------------- TESTING List end ----------------

				MapValueModel mapValueModel = propertyValueMap.get(childName);
				
				UiWidgets.rebindJComponents(childComponent, mapValueModel, objectList, "", "");
			}
		}
	}
}
