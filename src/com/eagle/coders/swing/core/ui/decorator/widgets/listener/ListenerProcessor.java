/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.listener;

import java.util.Map;

import javax.swing.JComboBox;

import com.eagle.coders.swing.core.ui.cache.DomainUIPropertiesMapCache;
import com.eagle.coders.swing.core.ui.cache.UiComponentsInterBindingInformationHolder;
import com.eagle.coders.swing.core.ui.controller.utils.AnnotationProcessingUtils;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.ActionRequest;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.ActionResponse;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.DefaultActionProcessor;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.IAction;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.frame.IFormContainer;
import com.eagle.coders.swing.core.ui.interfaces.IButton;

/**
 * @author Anees
 *
 */
public class ListenerProcessor {

	/**
	 * 
	 * @param object
	 */
	public static ActionResponse process(Object object, IFormContainer formContainer, String componentID, 
			Map<String, Object> parameters){
		
		ActionResponse actionResposne = new ActionResponse();
		
		if (object instanceof IButton){
			
			ActionRequest actionRequest = new ActionRequest();
			
			IButton button =(IButton) object;
			
			actionRequest.setComponentIDtoProcess(button.getComponentID());
			
			actionRequest.setFormContainer(formContainer);
			
			Map<ActionTypes, IAction> buttonTypeActionMap =	AnnotationProcessingUtils.processExecutablenButton(button);
			
			ActionTypes actionType = buttonTypeActionMap.keySet().iterator().next();
			
			actionRequest.setActionTypes(actionType);
			
			IAction action = buttonTypeActionMap.get(actionType);
			
			if(null != action){
				
				actionResposne = action.execute(actionRequest);
				
			}
//			TODO: have to play with error coming from execution of IAction
		}
		
		if(object instanceof JComboBox){
			
			IAction action = new DefaultActionProcessor();
			
			ActionRequest actionRequest = new ActionRequest();
			
			actionRequest.setActionTypes(ActionTypes.INTERCOMP_BINDING_ACTION);
			
			if(null != componentID){

				actionRequest.setComponentIDtoProcess(componentID);

				actionRequest.setParamters(parameters);
			}
			
			action.execute(actionRequest);
		}
		
		return actionResposne;
	}
}
