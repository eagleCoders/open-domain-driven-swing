/**
 * 
 */
package com.eagle.coders.swing.core.ui.frame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author Anees
 *
 */
public class TaskBarPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void  paintComponent(Graphics g){
		
		super.paintComponent( g );
		
		Color color = new Color(240, 240, 240);
		g.setColor(color);
		
	}
	
}
