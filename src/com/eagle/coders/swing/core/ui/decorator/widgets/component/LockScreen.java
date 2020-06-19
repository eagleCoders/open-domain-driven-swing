/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.component;

import javax.swing.JComponent;

import nl.jj.swingx.gui.modal.JModalFrame;

import com.eagle.coders.swing.core.ui.bindings.UIDomainBinderInterfaceController;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;

/**
 * @author Anees
 * @history: August 04,2009 : UIDomainBinderInterfaceController<IComponent> binding = new UIDomainBinderInterfaceController<IComponent>(comp, false);
 */
public class LockScreen {
	
	private static LockScreen instance;
	
	private IComponent comp;
	
	private LockDialog<IComponent> lockDialog;
	
	private LockScreen(final JModalFrame mainFrame, final JComponent mainContainer){
		
		comp = new ScreenLockWidget();

		UIDomainBinderInterfaceController<IComponent> binding = new UIDomainBinderInterfaceController<IComponent>(comp, false);
	
		lockDialog = new LockDialog<IComponent>(comp, mainFrame, mainContainer);

	}
	
	/**
	 * 
	 * @param mainFrame
	 * @param mainContainer
	 * @return
	 */
	public static LockScreen getInstance(final JModalFrame mainFrame, final JComponent mainContainer){
		
		if(null == instance){
			
			instance = new LockScreen(mainFrame, mainContainer);
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public void lockScreen(){
		
		lockDialog.pack();
		
		lockDialog.setVisible(true);
		
		lockDialog.centerOfScreen();

	}
	
	/**
	 * 
	 */
	public void unlockScreen(){
		
		lockDialog.dispose();
	}
	
	
}
