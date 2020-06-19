/**
 * 
 */
package com.eagle.coders.swing.core.ui.interfaces;

import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * @author Anees
 *
 */
public interface IUiComponent {
	
	String getPanelName();
	
	JPanel getJPanel();
	
	Map<String, JComponent> getBindableComponents();
	
}
