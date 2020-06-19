/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.conatiners;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;

import com.eagle.coders.swing.core.ui.frame.FormContainer;
import com.eagle.coders.swing.core.ui.frame.IFormContainer;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;

/**
 * @author Anees
 *
 */
public class EaglePopupFactory {

	private FormContainer<IComponent> container;
	
	private PopupFactory popupFactory;
	
	public EaglePopupFactory(){
		
		this.container = container;
		
		popupFactory = PopupFactory.getSharedInstance();
	}
	
	
	public Popup getPopupWindow(int ownerX, int ownerY){
		
		return popupFactory.getPopup(container, new JButton("HELLO"), 100, 200);
		
	}
}
