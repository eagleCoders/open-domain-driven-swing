package com.eagle.coders.swing.core.ui.decorator.widgets.component;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Collection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.java.dev.designgridlayout.DesignGridLayout;
import nl.jj.swingx.gui.modal.JModalDialog;
import nl.jj.swingx.gui.modal.JModalFrame;
import nl.jj.swingx.gui.modal.JModalInternalFrame;
import nl.jj.swingx.gui.utility.Utils;

import com.eagle.coders.swing.core.ui.cache.session.ApplicationSession;
import com.eagle.coders.swing.core.ui.decorator.UIMainDecorator;
import com.eagle.coders.swing.core.ui.decorator.widgets.CancelButtonWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.DeleteButtonWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.JExternalDialogWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.LoginButtonWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.SearchButtonWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.SubmitButtonWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.ActionResponse;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.decorator.widgets.listener.ActionListenerAssociator;
import com.eagle.coders.swing.core.ui.frame.IFormContainer;
import com.eagle.coders.swing.core.ui.images.utils.ImageLoaderUtils;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;
import com.eagle.coders.swing.core.ui.main.MainApp;
import com.sun.imageio.plugins.common.ImageUtil;

/**
 * 
 * @author Anees
 *
 */
public class LoginDialog<T extends IComponent> extends JModalDialog implements IFormContainer {

	private T component;
	
	private JPanel loginPanel;

	private LoginButtonWidget<IComponent> loginButton;
	
	private CancelButtonWidget<IComponent> cancelButton;
	
	private ActionListenerAssociator actionListenerAssociator;

	private JModalFrame frame ;
	
	public LoginDialog(T component, JModalFrame frame){
		
		super(frame);
		
		centerOfScreen();
		
		this.frame = frame;
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
//		super.setBounds(300, 400, 255, 300);
		
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
		
		loginButton = new LoginButtonWidget<IComponent>(component);
		
		actionListenerAssociator = new ActionListenerAssociator(this, null, null ,loginButton, cancelButton);

	}
	
	/**
	 * 
	 */
	private void createComponentPanel(){
		
		JPanel panel = new JPanel();
		
		DesignGridLayout layout = new DesignGridLayout(panel);

		layout.row().center().add(component.getPanel());

		loginPanel.add(panel, BorderLayout.CENTER);
	}
	
	/**
	 * 
	 */
	private void createButtonPanel(){
		
		JPanel panel = new JPanel();
		
		DesignGridLayout layout = new DesignGridLayout(panel);
		
		layout.row().right().add(loginButton, cancelButton);

		loginPanel.add(panel, BorderLayout.SOUTH);
	}
	
	

	@Override
	public String getComponentID() {
		
		return component.getComponentIdentity();
	}

	/**
	 * 
	 */
	@Override
	public void onFailure(JModalInternalFrame iFrame, ActionResponse actionResponse) {
		
		actionResponse.setActionType(ActionTypes.ERROR_ACTION);
		
		JExternalDialogWidget modalDialg = new JExternalDialogWidget(actionResponse, this, ActionTypes.ERROR_ACTION+" : Login Action");
		
		modalDialg.centerOfScreen();

		modalDialg.setVisible(true);
	}
	
	/**
	 * 
	 */
	@Override
	public void onSuccess(ActionResponse actionResponse) {

		dispose();
		
		ApplicationSession.getSession().store(actionResponse);
		
		try{
			
			
			UIMainDecorator.getInstance().decorate(frame);
			
			 frame.setVisible(true);
			 
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}

	@Override
	public void onAction4Popup(JModalInternalFrame frame,ActionResponse actionResponse,
			ActionTypes actionType) {
		
	}
}
