/**
 * 
 */
package com.eagle.coders.swing.core.ui.usecase.container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import nl.jj.swingx.gui.modal.JModalInternalFrame;

import com.eagle.coders.swing.core.ui.frame.FormContainer;
import com.eagle.coders.swing.core.ui.frame.IFormContainer;
import com.eagle.coders.swing.core.ui.frame.container.builder.UseCaseContainerBuilder;
import com.eagle.coders.swing.core.ui.images.utils.ImageLoaderUtils;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;
import com.eagle.coders.swing.core.ui.usecase.container.cache.UsecaseContainerComponentCache;

/**
 * @author Anees
 *
 */
public class UsecaseContainerAdvisor {

	private JDesktopPane desktop;
	
	private int maxNodes;
	
	private int position;
	
	private int currentX;
	
	private int currentY;

	
	private static UsecaseContainerAdvisor instance;
	
	public UsecaseContainerAdvisor(){}
	
	public static UsecaseContainerAdvisor getInstance(){
		
		if(null == instance){
			
			instance = new UsecaseContainerAdvisor();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param desktop
	 */
	public void loadDesktop(final JDesktopPane desktop, final Integer maxNodes){

		this.desktop = desktop;

		this.maxNodes = maxNodes;
	}
	
	/**
	 * 
	 * @param container
	 */
	public void loadFormContainer(FormContainer<IComponent> container, String label){
		
		JModalInternalFrame usecaseContainerFrame =
			UsecaseContainerComponentCache.getInstance().getUsecaseContaineriModalFrameMap(container.getComponentID());
		
		if(usecaseContainerFrame != null){

			if(usecaseContainerFrame.isIcon()){

				usecaseContainerFrame.getDesktopPane().getDesktopManager().deiconifyFrame(usecaseContainerFrame);
			}
			
			return;
		}
		
		JModalInternalFrame internaleFrame = new JModalInternalFrame(container.getComponent().getFormTitle(), true, true, true,true);
		
		internaleFrame.add(container);

		desktop.add(internaleFrame);
		
		int width = container.getComponent().getPanel().getWidth();
		
 	    String iFrameIconFile = ImageLoaderUtils.loadImage("eagle-iframe.png");
 	   
// 	    Icon iframeIcon = new ImageIcon(iFrameIconFile);

//		internaleFrame.setFrameIcon(iframeIcon);
 	    
		currentX = position;
//		
		currentY = position * 25;

 	    
 	    int height =(int) desktop.getSize().getHeight();
		
		internaleFrame.setBounds(currentX, position * 25, width+40, height-(currentY+30)); 
		
		internaleFrame.setVisible(true);
		
		internaleFrame.addInternalFrameListener(new FrameworkListener(container.getComponentID(), container));
		
		UsecaseContainerComponentCache.getInstance().addUsecaseiModalFrameToCache(container.getComponentID(), internaleFrame);
		
		position++;
	}
	
	/**
	 * 
	 * @author Anees
	 *
	 */
	private class FrameworkListener implements InternalFrameListener {

		private String containerID;
		
		private FormContainer<IComponent> container;
		
		public FrameworkListener(final String containerID, final FormContainer<IComponent> container){
			
			this.containerID = containerID;
			
			this.container = container;
		}
		
		@Override
		public void internalFrameActivated(InternalFrameEvent e) {
			
		}

		@Override
		public void internalFrameClosed(InternalFrameEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void internalFrameClosing(InternalFrameEvent e) {
			
//			JInternalFrame frame = UsecaseContainerComponentCache.getInstance().getUsecaseContainerFrmeFromMap(containerID);
			
//			UsecaseContainerComponentCache.getInstance().removeUsecaseiFrameFromCache(containerID);
			
			//TODO: checking the removal of the usecase from the container
			
//			UsecaseContainerComponentCache.getInstance().removeUsecaseiModalFromCache(containerID);

			UsecaseContainerComponentCache.getInstance().removeUsecaseiModalFromCache(container.getComponentID());
			
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
