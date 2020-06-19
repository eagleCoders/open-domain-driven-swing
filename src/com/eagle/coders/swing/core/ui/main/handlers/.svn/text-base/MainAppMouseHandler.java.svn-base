/**
 * 
 */
package com.eagle.coders.swing.core.ui.main.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Date;

import javax.swing.event.MouseInputAdapter;

/**
 * @author Anees
 *
 */
public class MainAppMouseHandler extends MouseInputAdapter {

	private static MainAppMouseHandler mainAppMouseHandler;
	
	private Date lastActivityTimestamp;
	
	public static MainAppMouseHandler getInstance(){
		
		if(null == mainAppMouseHandler){
			
			mainAppMouseHandler = new MainAppMouseHandler();
		}
		
		return mainAppMouseHandler;
	}
	
	/**
	 * 
	 */
	private void reinitializeLastActivityTime(){
		
		lastActivityTimestamp = new Date();
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
    public void mouseClicked(MouseEvent e) {
		
		reinitializeLastActivityTime();
	}

    /**
     * {@inheritDoc}
     */
	@Override
    public void mousePressed(MouseEvent e) {
		
		reinitializeLastActivityTime();
	}

    /**
     * {@inheritDoc}
     */
	@Override
    public void mouseReleased(MouseEvent e) {
		
		reinitializeLastActivityTime();
	}

    /**
     * {@inheritDoc}
     */
	@Override
    public void mouseEntered(MouseEvent e) {
    	
    	reinitializeLastActivityTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseExited(MouseEvent e) {
    	
    	reinitializeLastActivityTime();
    }

    /**
     * {@inheritDoc}
     * @since 1.6
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent e){
    	
    	reinitializeLastActivityTime();
    }

    /**
     * {@inheritDoc}
     * @since 1.6
     */
    @Override
    public void mouseDragged(MouseEvent e){
    	
    	reinitializeLastActivityTime();
    }

    /**
     * {@inheritDoc}
     * @since 1.6
     */
    @Override
    public void mouseMoved(MouseEvent e){
    	
    	reinitializeLastActivityTime();
    }
    
    /**
     * 
     * @return
     */
    public Date getLastActivityTimestamp(){
    	
    	if(null == lastActivityTimestamp) {
    		
    		lastActivityTimestamp = new Date();
    	}
    	
    	return lastActivityTimestamp;
    }
}
