/**
 * 
 */
package com.eagle.coders.swing.core.ui.usecase.container;

import java.awt.Component;
import java.awt.MenuItem;
import java.awt.PopupMenu;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import com.eagle.coders.swing.core.ui.frame.container.builder.UseCaseContainerBuilder;
import com.eagle.coders.swing.core.ui.interfaces.IUseCasesContainer;
import com.eagle.coders.swing.core.ui.usecase.container.cache.UsecaseContainerComponentCache;

/**
 * @author Anees
 *
 */
public class FrameUsecaseContainersAdvisor {
	
	private JDesktopPane desktop;
	
	private int position;
	
	private int currentX;
	
	private int currentY;
	
	private int removedX;
	
	private int removedY;
	
	private static FrameUsecaseContainersAdvisor instance;
	
	private FrameUsecaseContainersAdvisor(){
		
		position = 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public static FrameUsecaseContainersAdvisor getInstance(){
		
		if(null == instance){
			
			instance = new FrameUsecaseContainersAdvisor();
		}
		return instance;
	}

	/**
	 * 
	 * @param desktop
	 */
	public void loadDesktop(final JDesktopPane desktop){

		this.desktop = desktop;

	}
	
	/**
	 * 
	 */
	public void loadFavouriteMenu(){
		
//		TODO: temp code for Fav. Button
		
		JPopupMenu popupMenu = new JPopupMenu("Welcome...");
	
		JMenuItem favMenu = new JMenuItem("Favoruite");
		JMenuItem globalSearch = new JMenuItem("Global Search");
		JMenuItem themeManager = new JMenuItem("Theme Manager");
		
		popupMenu.add(favMenu);
		popupMenu.add(globalSearch);
		popupMenu.add(themeManager);
		
		popupMenu.addSeparator();
		
		JMenuItem lockMenu = new JMenuItem("Lock System");
		
		popupMenu.add(lockMenu);
		
		int maxHeight =(int) desktop.getSize().getHeight();
		
		int maxWidth =(int) desktop.getSize().getWidth();
		
		int popupHeight = (int)popupMenu.getSize().getHeight();
		
		int popupWidth = (int) popupMenu.getSize().getWidth();

		popupMenu.setBounds(0,900,30 , 40);

		popupMenu.setVisible(true);
		
//		desktop.add(popupMenu);
	}
	
	/**
	 * 
	 * @param container
	 */
	public void loadUsecaseContainer(IUseCasesContainer container){

		JInternalFrame usecaseContainerFrame =
			UsecaseContainerComponentCache.getInstance().getUsecaseContainerFrmeFromMap(container.getUseCaseContainerID());
		
		if(usecaseContainerFrame != null){

			if(usecaseContainerFrame.isIcon()){

				usecaseContainerFrame.getDesktopPane().getDesktopManager().deiconifyFrame(usecaseContainerFrame);
			}
			
			return;
		}
			
//			UseCaseContainerBuilder.getInstance().createUseCaseContainer(container);
			
			JInternalFrame internaleFrame = new JInternalFrame(container.getUseCaseContainerLabel(),true, true, true, true);

			desktop.add(internaleFrame);
			
			UseCaseContainerBuilder uBuilder = new UseCaseContainerBuilder();

			internaleFrame.add(uBuilder.createUseCaseContainer(container));
			
			internaleFrame.setFrameIcon(container.getUsecaseContainerIcon());
			
			currentX = position * 25;
			
			currentY = position * 25;
			
			int maxHeight =(int) desktop.getSize().getHeight();
			
			int maxWidth =(int) desktop.getSize().getWidth();
			
			internaleFrame.setBounds(0, currentY, maxWidth-200, maxHeight-(currentY+30));
			
			internaleFrame.setVisible(true);
			
			internaleFrame.addInternalFrameListener(new FrameworkListener(container.getUseCaseContainerID()));
			
			UsecaseContainerComponentCache.getInstance().addUsecaseFrameToCache(container.getUseCaseContainerID(), internaleFrame);
			
			position++;
	}
	
	/**
	 * 
	 * @param position
	 */
	public void setPosition(int position){
		
		this.position = position;
	}
	
	/**
	 * 
	 * @author Anees
	 *
	 */
	private class FrameworkListener implements InternalFrameListener {

		private String containerID;
		
		public FrameworkListener(final String containerID){
			
			this.containerID = containerID;
		}
		
		@Override
		public void internalFrameActivated(InternalFrameEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void internalFrameClosed(InternalFrameEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void internalFrameClosing(InternalFrameEvent e) {
			
			JInternalFrame frame = UsecaseContainerComponentCache.getInstance().getUsecaseContainerFrmeFromMap(containerID);
			
			removedX =(int) frame.getBounds().getX();
			
			removedY =(int) frame.getBounds().getY();
		
//			TODO: have to do it latter ------ so that JDesktop can re-evaluate its postions and adjust them 
//			System.out.println(" FrameBounds :: removedX "+frame.getBounds().getX()+ " Y :: "+frame.getBounds().getY()+ " currX :: "+currentX+ " currY :: "+ currentY+ " mainPosition ::"+ ((position*25)-25));
			
			int totalComponents = desktop.getComponentCount();
			
			for(int i = 0; i< totalComponents; i++){
				
				Component component = desktop.getComponent(i);
				
				if(component instanceof JInternalFrame){
					
					JInternalFrame iframe = (JInternalFrame) component;
					
					int x = (int)iframe.getBounds().getX();
					
					int y = (int)iframe.getBounds().getY();
					
					if(x > removedX){
						
//						System.out.println(" component :: "+ x+ " exactly "+ (x-removedX)+ "frame :: "+frame);
						
						frame.setBounds(x-removedX, y-removedY, frame.getWidth(), frame.getWidth());
						
//						int positionTOMoveX = ((position*25)-25);
						
//						int positionToMoveY = ((position*25)-25);
					}
					
					desktop.validate();
				}
				
			}

			UsecaseContainerComponentCache.getInstance().getUsecaseiModalFrom().clear();//TODO: it is temporary purpose
			
			UsecaseContainerComponentCache.getInstance().removeUsecaseFrameFromCache(containerID);
		}

		@Override
		public void internalFrameDeactivated(InternalFrameEvent e) {
			
		}

		@Override
		public void internalFrameDeiconified(InternalFrameEvent e) {

		}

		@Override
		public void internalFrameIconified(InternalFrameEvent e) {

		}

		@Override
		public void internalFrameOpened(InternalFrameEvent e) {
			
		}
		
	}
}
