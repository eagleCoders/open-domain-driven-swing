/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.component;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.java.dev.designgridlayout.DesignGridLayout;
import nl.jj.swingx.gui.modal.JModalDialog;
import nl.jj.swingx.gui.modal.JModalFrame;
import nl.jj.swingx.gui.modal.JModalInternalFrame;

import com.eagle.coders.swing.core.ui.cache.session.ApplicationSession;
import com.eagle.coders.swing.core.ui.decorator.widgets.CancelButtonWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.JExternalDialogWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.LockUnlcokButtonWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.ActionResponse;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.decorator.widgets.listener.ActionListenerAssociator;
import com.eagle.coders.swing.core.ui.frame.IFormContainer;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;
import com.eagle.coders.swing.core.ui.main.MainApp;

/**
 * @author Anees
 *
 */
public class LockDialog<T extends IComponent> extends JModalDialog implements IFormContainer {

	private T component;
	
	private JPanel loginPanel;

	private LockUnlcokButtonWidget<IComponent> lockButton;
	
	private CancelButtonWidget<IComponent> cancelButton;
	
	private ActionListenerAssociator actionListenerAssociator;

	private JModalFrame frame ;
	
	private DesignGridLayout layout;
	
	private JPanel panel;

	public LockDialog(T component, JModalFrame frame, JComponent rtrnComponent){
		
		super(frame, rtrnComponent);
		
		centerOfScreen();
		
		this.frame = frame;
		
		setUndecorated(true);
		
		this.component = component;
		
		loginPanel = new JPanel();
		
		loginPanel.setLayout(new BorderLayout());
		
		init();
		
		getContentPane().add(loginPanel);
	}

	private void init(){
		
		initButtons();
		
		createComponentPanel();
		
		createButtonPanel();
	}
	
	/**
	 * 
	 */
	private void initButtons(){
		

		cancelButton = new CancelButtonWidget<IComponent>(component);
		
		lockButton = new LockUnlcokButtonWidget<IComponent>(component);
		
//		actionListenerAssociator = new ActionListenerAssociator(this, null, null ,lockButton, cancelButton);
		actionListenerAssociator = new ActionListenerAssociator(this, null, null ,lockButton);

	}

	/**
	 * 
	 */
	private void createComponentPanel(){
		
		panel = new JPanel();
		
		layout = new DesignGridLayout(panel);

		List<Map<String, Object>> rsltMap = ApplicationSession.getSession().getUserFromSession();
		
		if(rsltMap.size() == 1){
			
			Map<String, Object> map = rsltMap.iterator().next();
			String userName = map.get("Username").toString();
			
			layout.row().center().add(new JLabel(userName));
			layout.row().center().add(new JLabel("you are locked"));
		}
		
		layout.row().center().add(component.getPanel());

		loginPanel.add(panel, BorderLayout.CENTER);
	}
	
	/**
	 * 
	 */
	private void createButtonPanel(){
		
		JPanel panel = new JPanel();
		
		DesignGridLayout layout = new DesignGridLayout(panel);
		
//		layout.row().right().add(lockButton, cancelButton);
		layout.row().right().add(lockButton);

		loginPanel.add(panel, BorderLayout.SOUTH);
	}

	@Override
	public String getComponentID() {

		return component.getComponentIdentity();
	}

	@Override
	public void onAction4Popup(JModalInternalFrame frame,
			ActionResponse actionResponse, ActionTypes actionType) {
		
	}

	@Override
	public void onFailure(JModalInternalFrame frame,
			ActionResponse actionResponse) {
		
		actionResponse.setActionType(ActionTypes.ERROR_ACTION);
		
		JExternalDialogWidget modalDialg = new JExternalDialogWidget(actionResponse, this, ActionTypes.ERROR_ACTION+" : Lock Action");
		
		modalDialg.centerOfScreen();

		modalDialg.setVisible(true);

	}

	@Override
	public void onSuccess(ActionResponse actionResponse) {
		
		setVisible(false);
		
//		dispose();
	}

}
