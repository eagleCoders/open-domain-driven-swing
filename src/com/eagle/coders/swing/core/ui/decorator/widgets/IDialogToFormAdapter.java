/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.eagle.coders.swing.core.ui.bindings.BeanMapUtils;
import com.eagle.coders.swing.core.ui.bindings.MapValueModel;
import com.eagle.coders.swing.core.ui.cache.DomainPropertyValueModelHolder;
import com.eagle.coders.swing.core.ui.cache.DomainUIPropertiesMapCache;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.DefaultActionProcessor;

/**
 * @author Anees
 *
 */
public class IDialogToFormAdapter {
	
	private JInternalDialogWidget internalWidget;
	
	private String componentID;
	
	private String clazzName;
	
	public IDialogToFormAdapter(final JInternalDialogWidget internalDialogWidget, final String componentID, String clazzName){
		
		this.internalWidget = internalDialogWidget;
		
		this.componentID = componentID;
		
		this.clazzName = clazzName;
	}
	
	/**
	 * 
	 * @param data
	 */
	public void injectDataIntoForm(final Map<String, Object> dataToInject){
		
		Map<String, Object> mapToInject = new HashMap<String, Object>();
		
		BeanMapUtils.map2MapConverter(mapToInject, dataToInject);
		
		List<DomainPropertyValueModelHolder> domainPropertyValueModuelHolder =
			DefaultActionProcessor.getDomainPropertyValueModelList(componentID);
		
		for(DomainPropertyValueModelHolder holder : domainPropertyValueModuelHolder){

			if(holder.getDomainObject().equals(clazzName)){
				
				Map<String, MapValueModel> mapTobeInjected = holder.getDomainPropertyModelMap();

				inject(mapTobeInjected, mapToInject);
				
				holder.setDomainPropertyModelMap(mapTobeInjected);
			}
			
		}
	}
	
	/**
	 * 
	 * @param mapTobeInjected
	 * @param mapToInject
	 */
	private void inject(final Map<String, MapValueModel> mapTobeInjected, final Map<String, Object> mapToInject){
		
		Set<String> keySet = mapToInject.keySet();
		
		for(String key : keySet){
			
			if(mapTobeInjected.containsKey(key)){
				
				MapValueModel mapValueModel = mapTobeInjected.get(key);
				
				mapValueModel.setValue(mapToInject.get(key).toString());
				
				mapTobeInjected.put(key, mapValueModel);
				
			}else {
				
				Map<String, Object> keyValueMap = new HashMap<String, Object>();
				
				keyValueMap.put(key, mapToInject.get(key).toString());
				
				MapValueModel valueModel = new MapValueModel(keyValueMap, key);
				
				mapTobeInjected.put(key, valueModel);
			}
		}
	}

}
