/**
 * 
 */
package com.eagle.coders.swing.core.ui.frame;

import javax.swing.JInternalFrame;

import nl.jj.swingx.gui.modal.JModalInternalFrame;

import com.eagle.coders.swing.core.ui.decorator.widgets.action.ActionResponse;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;

/**
 * @author Anees
 *
 */
public interface IFormContainer {
	
	String getComponentID();
	
	void onSuccess(ActionResponse actionResponse);
	
	void onFailure(JModalInternalFrame iFrame ,ActionResponse actionResponse);
	
	void onAction4Popup(JModalInternalFrame frame,ActionResponse actionResponse, ActionTypes actionType);
	
//	void onAction4Popup(JInternalFrame frame,ActionResponse actionResponse, ActionTypes actionType);

}
