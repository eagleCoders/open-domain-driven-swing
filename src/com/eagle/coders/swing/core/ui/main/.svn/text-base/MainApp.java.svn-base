/**
 * 
 */
package com.eagle.coders.swing.core.ui.main;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import nl.jj.swingx.gui.modal.JModalFrame;

import org.jvnet.substance.SubstanceLegacyDefaultLookAndFeel;
import org.jvnet.substance.skin.SubstanceAutumnLookAndFeel;
import org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel;
import org.jvnet.substance.skin.SubstanceChallengerDeepLookAndFeel;
import org.jvnet.substance.skin.SubstanceEmeraldDuskLookAndFeel;
import org.jvnet.substance.skin.SubstanceMagmaLookAndFeel;
import org.jvnet.substance.skin.SubstanceNebulaBrickWallLookAndFeel;
import org.jvnet.substance.skin.SubstanceOfficeSilver2007LookAndFeel;
import org.jvnet.substance.skin.SubstanceRavenGraphiteGlassLookAndFeel;
import org.jvnet.substance.skin.SubstanceRavenGraphiteLookAndFeel;

import com.eagle.coders.swing.core.ui.bindings.UIDomainBinderInterfaceController;
import com.eagle.coders.swing.core.ui.decorator.UIMainDecorator;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.ActionRequest;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.DefaultActionProcessor;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.IAction;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.decorator.widgets.component.LockDialog;
import com.eagle.coders.swing.core.ui.decorator.widgets.component.LoginDialog;
import com.eagle.coders.swing.core.ui.decorator.widgets.component.LoginWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.component.ScreenLockWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.listener.ActionListenerAssociator;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;
import com.eagle.coders.swing.core.ui.usecase.container.FrameUsecaseContainersAdvisor;
import com.eagle.coders.swing.core.ui.usecase.container.cache.UsecaseContainerComponentCache;

/**
 * @author Anees
 *
 */
public class MainApp extends JApplet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static LoginDialog<IComponent> container;
	
	@Override
	public void init(){
		
		launch();
	}
	
	private void launch(){

		final JModalFrame frame = new JModalFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setUndecorated(true);

		try{
//			SubstanceBusinessBlackSteelLookAndFeel
//			SubstanceMagmaLookAndFeel
//			SubstanceAutumnLookAndFeel
//			SubstanceChallengerDeepLookAndFeel
//			SubstanceEmeraldDuskLookAndFeel
//			SubstanceLegacyDefaultLookAndFeel
//			SubstanceNebulaBrickWallLookAndFeel
//			SubstanceRavenGraphiteGlassLookAndFeel
//			SubstanceRavenGraphiteLookAndFeel
//			SubstanceOfficeSilver2007LookAndFeel
			
//			"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"

			UIManager.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());
	
		}catch(Exception ex){
			
//			-------------------- DO NOTHING ---------------------
		}
		
	    SwingUtilities.invokeLater(new Runnable() {
	        
	    	public void run() {
	    		try{
	    		
	    			preLogin(frame);
	    			
//	        	UIMainDecorator.getInstance().decorate(frame);
	    		}catch(Exception e){
	    			e.printStackTrace();
	    		}
	        }
        });

	    frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MainApp mApp = new MainApp();
		
		mApp.launch();
	}
	
	/**
	 * 
	 */
	private void preLogin(JModalFrame frame){
		
		IComponent comp = new LoginWidget();
		
		UIDomainBinderInterfaceController<IComponent> binding = new UIDomainBinderInterfaceController<IComponent>(comp, false);
				
		container = new LoginDialog<IComponent>(comp, frame);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (int)(dimension.getWidth()/2);
		
		int y = (int) (dimension.getHeight()/2);
		
		container.setBounds(450, 350, 400, 250);
		
		ActionListenerAssociator actionListenerAssociator = new ActionListenerAssociator(frame,comp.getPanel());
		
		container.setVisible(true);

	}
	
	/**
	 * for switching Users
	 */
	public static void logoff(){
		
		UIMainDecorator.getInstance().removeMainContainer();
		
		UsecaseContainerComponentCache.getInstance().getUsecaseFrameContainerMap().clear();
		
		UsecaseContainerComponentCache.getInstance().getUsecaseFrameContainerMap().clear();
		
		UsecaseContainerComponentCache.getInstance().getUsecaseiModalFrom().clear();
		
		FrameUsecaseContainersAdvisor.getInstance().setPosition(0);
		
		ActionRequest actionRequest = new ActionRequest();
		
		actionRequest.setActionTypes(ActionTypes.CANCEL_ACTION);
		
		actionRequest.setComponentIDtoProcess(LoginWidget.COMPONENT_ID);
		
		IAction action = new DefaultActionProcessor();
		
		action.execute(actionRequest);
		
		container.setVisible(true);
	}
	
	/**
	 * 
	 */
	public static void logout(){
		
		container.dispose();
		
		System.exit(0);
	}
	
}
