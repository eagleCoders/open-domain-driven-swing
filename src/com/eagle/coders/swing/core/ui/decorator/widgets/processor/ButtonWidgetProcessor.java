/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.processor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.Button;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.interfaces.IButton;

/**
 * @author Anees
 *
 */
public class ButtonWidgetProcessor {

	/**
	 * 
	 * @param clazz
	 * @return
	 */
	public static Icon processButtonIcon(Class<? extends IButton> clazz){
		
		Icon icon = null;
		
		if(clazz.isAnnotationPresent(Button.class)){

			Button button = clazz.getAnnotation(Button.class);
			
			String imageFile = button.imageFiles();

			if(!imageFile.equals("")){

				icon = new ImageIcon(imageFile);
			}
		}
		
		return icon;
		
	}
	
	/**
	 * 
	 */
	public static JButton processButton(Class<? extends IButton> clazz){
		
		String buttonLabel = "";
		
		JButton jButton = new JButton();
		
		if(clazz.isAnnotationPresent(Button.class)){
			
			Button button = clazz.getAnnotation(Button.class);
			
			String imageFile = button.imageFiles();
			
			if(imageFile.equals("")){
				
				buttonLabel = button.buttonLabel();
				
				jButton.setName(buttonLabel);
				
			} else {
				
				Icon icon = new ImageIcon(imageFile);
				
				jButton.setIcon(icon);
			}
			
			if(!button.tooltipe().equals("")){
				
				jButton.setToolTipText(button.tooltipe());
			}
			
//			if(button.buttonType().equals(ButtonTypes.SEARCH_BUTTON)){
//				
//				
//			} else if (button.buttonType().equals(ButtonTypes.SUBMIT_BUTTON)){
//				
//			} else if (button.buttonType().equals(ButtonTypes.CANCEL_BUTTON)){
//				
//			} else if(button.buttonType().equals(ButtonTypes.DELETE_BUTTON)){
//				
//			} else if(button.buttonType().equals(ButtonTypes.PRINT_BUTTON)){
//				
//			} else if(button.buttonType().equals(ButtonTypes.VIEW_BUTTON)){
//				
//			}
		}
		
		return jButton;
	}

}
