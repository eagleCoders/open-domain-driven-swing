/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.dashboard;

import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import net.java.dev.designgridlayout.DesignGridLayout;

/**
 * @author Anees
 *
 */
public class DashBoardContainer {

	private static DashBoardContainer instance;
	
	private JInternalFrame iFrame;
	
	private JPanel iPanel;
	
	private JDesktopPane dashBoardDesktop;
	
	private int yPosition = 0;
	
	private DashBoardContainer(){}
	
	public static DashBoardContainer getInstance(){
		
		if(null == instance){
			
			instance = new DashBoardContainer();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param iFrame
	 */
	public void loadDashBoardContainer(JInternalFrame iFrame){
		
		this.iFrame = iFrame;
		
		iPanel = new JPanel();
		
		dashBoardDesktop = new JDesktopPane();
		
		DesignGridLayout layout = new DesignGridLayout(iPanel);
		
		
//		iFrame.add(iPanel);
		
		iFrame.add(dashBoardDesktop);

	}
	
	/**
	 * 
	 * @param component
	 */
	public void loadGadgetsForDashBoard(JComponent component){
		
		JInternalFrame frame = new JInternalFrame("", false,false,false,false);
		
		frame.add(component);
		
		frame.setBounds(0, yPosition * 50, 50, 50);
		
		frame.setVisible(false);
		
		dashBoardDesktop.add(frame);
		
		yPosition++;
		
	}
	
	
	
}
