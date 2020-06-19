/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.action;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.eagle.coders.swing.core.ui.bindings.MapValueModel;
import com.eagle.coders.swing.core.ui.bindings.MapValueModelDirtyChecker;
import com.eagle.coders.swing.core.ui.cache.DomainPropertyValueModelHolder;
import com.eagle.coders.swing.core.ui.cache.session.ApplicationSession;
import com.eagle.coders.swing.core.ui.frame.IFormContainer;

/**
 * @author Anees
 *
 */
public class LockAction {
	
	
	public static void lock(ActionRequest actionRequest ,IFormContainer container, 
			List<DomainPropertyValueModelHolder> domainPropertyValueModuelHolderList){
		
		ActionResponse actionResponse = new ActionResponse();

		if(null != domainPropertyValueModuelHolderList){
			
			for(DomainPropertyValueModelHolder holder : domainPropertyValueModuelHolderList){

				Map<String, MapValueModel> propertyMapValueModelMap = holder.getDomainPropertyModelMap();

				Collection<MapValueModel> mapValueModelCollection = propertyMapValueModelMap.values();

				if(MapValueModelDirtyChecker.checkMapValueModelIsDirty(mapValueModelCollection)){
					
					Map<String, Object> propertiesValueMap =
						MapValueModelDirtyChecker.createDirtyPropertiesValuesMap(mapValueModelCollection);
					
					List<Map<String, Object>> rsltMap = ApplicationSession.getSession().getUserFromSession();
					
					for(Map<String, Object> map : rsltMap){
						
						if(map.containsKey("Password")){ //TODO: this is temporary purpose : have to make the tableMap to beanMap converter
							
							String password = propertiesValueMap.get("password").toString();
							
							String oPassword = map.get("Password").toString();
							
							if(password.equals(oPassword)){
								
								CancelAction.cancel(domainPropertyValueModuelHolderList);
								
								container.onSuccess(actionResponse);
								
								
							}else{
								
								CancelAction.cancel(domainPropertyValueModuelHolderList);
								
								actionResponse.getErrors().put("lock.password.error", "password not correct");
								
								container.onFailure(null, actionResponse);
							}
						}
					}
				}
			}
		}
	}

}
