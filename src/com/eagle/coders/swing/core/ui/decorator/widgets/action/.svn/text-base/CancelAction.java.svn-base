/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.action;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.eagle.coders.swing.core.ui.bindings.MapValueModel;
import com.eagle.coders.swing.core.ui.cache.DomainPropertyValueModelHolder;
import com.jgoodies.binding.list.ArrayListModel;

/**
 * @author Anees
 *
 */
public class CancelAction {

	/**
	 * 
	 * @param domainPropertyValueModuelHolder
	 */
	public static void cancel(List<DomainPropertyValueModelHolder> domainPropertyValueModuelHolder){
		
		for(DomainPropertyValueModelHolder holder : domainPropertyValueModuelHolder){

			Map<String, MapValueModel> propertiesMapValueModel = holder.getDomainPropertyModelMap();
			
			Map<String, ArrayListModel<Map<String, Object>>> childTableDataListMap = holder.getChildDomainTableDataMap();
			
			Set<String> propertySet = propertiesMapValueModel.keySet();
			
			for(String property : propertySet){
				
				MapValueModel mapValueModel = propertiesMapValueModel.get(property);
				
				mapValueModel.setValue(null);
				
				mapValueModel.setDirty(false);
			}
			
			//Removing Rows from Child Tables Records
			Collection<ArrayListModel<Map<String, Object>>> childTableDataCollection = childTableDataListMap.values();
			
			for(ArrayListModel<Map<String, Object>> mapValueList : childTableDataCollection){
				
				mapValueList.removeAll(mapValueList);
			}
			
		}
	}
}
