/**
 * 
 */
package com.eagle.coders.swing.core.ui.interfaces;

import nl.jj.swingx.gui.modal.JModalInternalFrame;

import com.eagle.coders.swing.core.ui.decorator.widgets.action.ActionResponse;

/**
 * @author Anees
 *
 */
public interface IDataResultForm {
	
	String getParentComponentID();
	
	String getResultFormID();
	
	void build(JModalInternalFrame iFrame, ActionResponse actionResponse);
	
	void onSucess(JModalInternalFrame iframe, ActionResponse actionResponse);
	
	void onFailiure(JModalInternalFrame iframe, ActionResponse actionResponse);
}
