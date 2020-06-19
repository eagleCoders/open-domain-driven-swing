/**
 * 
 */
package com.eagle.coders.swing.core.ui.frame;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JPanel;

/**
 * @author Anees
 *
 */
public class BackGroundDockPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BackGroundDockPanel(){
	}

	@Override
	 protected void paintComponent(Graphics g) {
         if (g instanceof Graphics2D) {
             final int R = 255;
             final int G = 255;
             final int B = 255; 


//            Paint p =
//             new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 0),
//                 getWidth(), getHeight(), new Color(R, G, B, 255), true);
             Graphics2D g2d = (Graphics2D)g;
//             g2d.setPaint(p);
             
             g2d.setColor(new Color(R, G, B));
             g2d.fillRect(0, 0, getWidth(), getHeight());

      } else {
     super.paintComponent(g);
      }
    }
}
