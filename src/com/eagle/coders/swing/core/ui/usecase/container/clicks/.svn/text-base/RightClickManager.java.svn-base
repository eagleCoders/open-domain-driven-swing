/**
 * 
 */
package com.eagle.coders.swing.core.ui.usecase.container.clicks;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.JComponent;

/**
 * @author Anees
 *
 */
public class RightClickManager {
	
	List<JComponent> componentForRightClickList;
	
	private static RightClickManager instance;
	
	private RightClickManager(){}

	Container contentPane;
	
	public static RightClickManager getInstance(){
		
		if(null == instance){
			
			instance = new RightClickManager();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param component
	 */
	public void assingRightClick(final JComponent component){
		
		System.out.println("[RightClickManager]Component :: "+component);
		
		component.addMouseListener(new RightClick());
		
		component.addMouseMotionListener(new RightClick());
		
	}
	
	/**
	 * 
	 * @author Anees
	 *
	 */
	private class RightClick implements MouseListener, MouseMotionListener{

		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

}
