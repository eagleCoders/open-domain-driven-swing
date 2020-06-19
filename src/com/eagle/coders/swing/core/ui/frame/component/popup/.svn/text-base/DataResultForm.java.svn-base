/**
 * 
 */
package com.eagle.coders.swing.core.ui.frame.component.popup;

import javax.swing.JPanel;

import net.java.dev.designgridlayout.DesignGridLayout;
import nl.jj.swingx.gui.modal.JModalInternalFrame;

import com.eagle.coders.swing.core.ui.decorator.widgets.JInternalDialogWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.ActionResponse;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;
import com.eagle.coders.swing.core.ui.interfaces.IDataResultForm;

/**
 * @author Anees
 *
 */
public class DataResultForm<T extends IComponent> implements IDataResultForm{
	
	public static final String RSLT_FORM = DataResultForm.class.getName();
	
	private T component;
	
	
	
	
	public DataResultForm(final T component, final JModalInternalFrame frame, final ActionResponse actionResponse){
		
		this.component = component;
		
		build(frame, actionResponse);
	}

	@Override
	public void build(JModalInternalFrame frame, ActionResponse actionResponse) {
		
		JInternalDialogWidget jif = new JInternalDialogWidget(actionResponse, frame, component.getPanel(),component.getFormTitle(), component);

	    frame.getDesktopPane().add(jif);
	    
	    jif.centerOfOwner();
	    
	    jif.setVisible(true);

	}

	@Override
	public String getParentComponentID() {
		
		return component.getComponentIdentity();
	}

	@Override
	public String getResultFormID() {
		
		return RSLT_FORM;
	}

	@Override
	public void onFailiure(JModalInternalFrame iframe,
			ActionResponse actionResponse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSucess(JModalInternalFrame iframe,
			ActionResponse actionResponse) {
		// TODO Auto-generated method stub
		
	}

}
