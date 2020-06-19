/**
 * 
 */
package com.eagle.coders.swing.core.ui.bindings;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anees
 *
 */
public class MapValueModelDirtyChecker {
	
	/**
	 * 
	 * @param mapValueModelCollection
	 */
	public static void makeMapValueModelClean(Collection<MapValueModel> mapValueModelCollection){
		
		for(MapValueModel mapValueModel : mapValueModelCollection){
			
//			if(mapValueModel.getDirty()){
				mapValueModel.setDirty(false);
//			}
		}
	}
	
	/**
	 * @return Boolean
	 * @param mapValueModelCollection
	 */
	public static Boolean checkMapValueModelIsDirty(Collection<MapValueModel> mapValueModelCollection){
		
		Boolean flag = false;
		
		
		for(MapValueModel valueModel : mapValueModelCollection){
			
			if(valueModel.getDirty()){

				flag = true;
				break;
			}
		}
		
		return flag;
	}
	
	/**
	 * 
	 * @param mapValueModelCollection
	 * @return
	 */
	public static Boolean checkMapValueModelIsQueryable(Collection<MapValueModel> mapValueModelCollection){
		
		Boolean flag = true;
		
		for(MapValueModel valueModel : mapValueModelCollection){
			
			if(!valueModel.getQueryAble()){
				flag = false;
				break;
			}
		}
		
		return flag;
	}
	
	
	
	/**
	 * 
	 * @param mapValueModelCollection
	 * @return Map<String, Object>
	 */
	public static Map<String, Object> createDirtyPropertiesValuesMap(Collection<MapValueModel> mapValueModelCollection){

		Map<String, Object> propertiesValueMap = new HashMap<String, Object>();

		for(MapValueModel valueModel : mapValueModelCollection){
			
			if(valueModel.getDirty() && valueModel.getQueryAble()){
				
				propertiesValueMap.put(valueModel.getKey().toString(), valueModel.getValue());

			}
		}
		
		return propertiesValueMap;
	}

}
