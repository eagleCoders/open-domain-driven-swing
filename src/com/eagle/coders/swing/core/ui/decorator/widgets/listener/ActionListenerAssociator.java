/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.JTextComponent;

import nl.jj.swingx.gui.modal.JModalDialog;
import nl.jj.swingx.gui.modal.JModalFrame;

//import org.hibernate.hql.ast.tree.ImpliedFromElement;

import com.eagle.coders.swing.core.ui.bindings.UIDomainBinderInterfaceController;
import com.eagle.coders.swing.core.ui.cache.DomainUIPropertiesMapCache;
import com.eagle.coders.swing.core.ui.cache.UIComponentPropertyValueModelHolder;
import com.eagle.coders.swing.core.ui.cache.UiComponentsInterBindingInformationHolder;
import com.eagle.coders.swing.core.ui.cache.session.ApplicationSession;
import com.eagle.coders.swing.core.ui.decorator.widgets.JExternalDialogWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.ActionRequest;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.DefaultActionProcessor;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.IAction;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.decorator.widgets.component.LockDialog;
import com.eagle.coders.swing.core.ui.decorator.widgets.component.LockScreen;
import com.eagle.coders.swing.core.ui.decorator.widgets.component.LoginWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.component.ScreenLockWidget;
import com.eagle.coders.swing.core.ui.frame.FormContainer;
import com.eagle.coders.swing.core.ui.frame.IFormContainer;
import com.eagle.coders.swing.core.ui.interfaces.IButton;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;
import com.eagle.coders.swing.core.ui.main.MainApp;

/**
 * @author Anees
 *
 */
public class ActionListenerAssociator {
	
	private JComponent[] components;
	
	private IFormContainer container;
	
	private String componentID;
	
	private Map<String, Object> parameters;
	
	private UiComponentsInterBindingInformationHolder holder;
	
	private UIComponentPropertyValueModelHolder uiComoponentPropertyValueModelHolder;

	private JComponent mainContainer;
	
	private JModalFrame mainFrame;

	/**
	 * 
	 * @param mainContainer
	 */
	public ActionListenerAssociator(final JModalFrame frame, final  JComponent mainContainer){
		
		this.mainContainer = mainContainer;
		
		this.mainFrame = frame;
		
		components = new JComponent[1];
		
		this.components[0] = mainContainer;
		
		initListeners();
		
		uiComoponentPropertyValueModelHolder = DomainUIPropertiesMapCache.getInstance().getCompValueModelHolder();

		
	}
	
	
	/**
	 * 
	 * @param components
	 */
	public ActionListenerAssociator(IFormContainer container,String componentID, Map<String, Object> parameters ,
			JComponent... components){
		
		this.components = components;
		
		if(null!= container)
			this.container = container;
		
		if(null!= componentID)
			this.componentID = componentID;
		
		if(null!= parameters)
			this.parameters = parameters;
		
		initListeners();
		
		uiComoponentPropertyValueModelHolder = DomainUIPropertiesMapCache.getInstance().getCompValueModelHolder();
		
	}

	/**
	 * 
	 */
	public void associateGlobalActions(ActionTypes actionTypes){
		
//		JExternalDialogWidget widget = new JExternalDialogWidget()
		if(ActionTypes.LOCK_ACTION.equals(actionTypes)){

			KeyStroke ks = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK);
			
			mainContainer.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(ks, "LOCK");
			
			mainContainer.getActionMap().put("LOCK", new AbstractAction() {
				
				public void actionPerformed(ActionEvent evt) {

//					LockScreen.lockScreen(mainFrame, mainContainer);
					
					LockScreen.getInstance(mainFrame, mainContainer).lockScreen();
					
//					MainApp.lockScreen();
				}
			});
		}
	}

	
	/**
	 * 
	 */
	private  void initListeners(){
		
		for(int i = 0; i < components.length; i++){
			
			JComponent component = components[i];
			
			initJButtonListener(component);
			
			initJCheckBoxListener(component);
			
			initJComboBox(component);
			
			initJRadioButtonListener(component);
			
			initJTextListener(component);
			
			initJPanelListener(component);
		}
		
	}
	
	/**
	 * 
	 * @param componennt
	 */
	private void initJPanelListener(JComponent component){
		
		if(component instanceof JPanel){
			
			JPanel panel =(JPanel) component;
			
			JTabbedPane tabbedPane =(JTabbedPane)panel.getComponents()[0];
			
			for(int i = 0 ; i < tabbedPane.getComponentCount(); i++){
				
				JPanel panel0 =(JPanel) tabbedPane.getComponent(i);
				
				processJPanel(panel0);
				
			}
		}
	}
	
	/**
	 * 
	 * @param panel
	 */
	private void processJPanel(final JPanel panel){
		
		for(int i = 0; i < panel.getComponentCount(); i++){
			
			if(panel.getComponent(i) instanceof JPanel){
			
				processJPanel((JPanel)panel.getComponent(i));
				
			}else{
				
				if(panel.getComponent(i) instanceof JTextComponent){
					
					JTextComponent jTextComponent =(JTextComponent) panel.getComponent(i);
					
					jTextComponent.addKeyListener(new CompKeyHandler());
				}
				
			}
		}
	}
	
	/**
	 * 
	 * @param component
	 */
	private void initJButtonListener(JComponent component){
	
		if(component instanceof JButton){

			JButton button =(JButton) component;
			IButton iButton =(IButton) component;

			button.addActionListener(new CompActionHandler());
			
//			button.addMouseListener(new CompMouseHandler());
//			
//			button.addKeyListener(new CompKeyHandler());
		}
	}
	
	/**
	 * 
	 * @param component
	 */
	private void initJTextListener(JComponent component){
		
		if(component instanceof JTextField){
		
			JTextField textField = (JTextField) component;
			
			textField.addActionListener(new CompActionHandler());
			
//			textField.addMouseListener(new CompMouseHandler());
//			
//			textField.addKeyListener(new CompKeyHandler());
			
		}
	}
	
	/**
	 * 
	 * @param component
	 */
	private void initJCheckBoxListener(JComponent component){
		
		if(component instanceof JCheckBox){
		
			JCheckBox checkBox =(JCheckBox) component;
			
			checkBox.addActionListener(new CompActionHandler());
			
//			checkBox.addMouseListener(new CompMouseHandler());
//			
//			checkBox.addKeyListener(new CompKeyHandler());
		}
	}
	
	/**
	 * 
	 * @param component
	 */
	private void initJRadioButtonListener(JComponent component){
		
		if(component instanceof JRadioButton){
		
			JRadioButton radioButton =(JRadioButton) component;
			
			radioButton.addActionListener(new CompActionHandler());
			
//			radioButton.addMouseListener(new CompMouseHandler());
//			
//			radioButton.addKeyListener(new CompKeyHandler());
		}
	}
	
	/**
	 * 
	 * @param component
	 */
	private void initJComboBox(JComponent component){
		
		if(component instanceof JComboBox){
			
			JComboBox comboBox = (JComboBox) component;
			
			comboBox.addActionListener(new CompActionHandler());
			
//			comboBox.addMouseListener(new CompMouseHandler());
//			
//			comboBox.addKeyListener(new CompKeyHandler());
			
		}
		
	}
	
	/**
	 * 
	 * @author Anees
	 *
	 */
	private class CompActionHandler implements ActionListener {
		

		@Override
		public void actionPerformed(ActionEvent e) {

			ListenerProcessor.process(e.getSource(), container, componentID, parameters);
		}
	}
	
	/**
	 * 
	 * @author Anees
	 *
	 */
	private class CompMouseHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
	}
	
	/**
	 * 
	 * @author Anees
	 *
	 */
	private class CompKeyHandler implements KeyListener {
		
		public CompKeyHandler(){
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				
				System.out.println(" KEY PRESSES ");
				
				IAction action = new DefaultActionProcessor();
				
				ActionRequest actionRequest = new ActionRequest();
				
				actionRequest.setActionTypes(ActionTypes.LOGIN_ACTION);
				
				actionRequest.setComponentIDtoProcess(LoginWidget.COMPONENT_ID);
				
				action.execute(actionRequest);

			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
		}
	}

}
