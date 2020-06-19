/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.Button;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.images.utils.ImageLoaderUtils;
import com.eagle.coders.swing.core.ui.interfaces.IButton;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;

/**
 * @author Anees
 *
 */
@Button(buttonType = ActionTypes.DELETE_ACTION, imageFiles = "delete.png")
public class DeleteButtonWidget<T extends IComponent> extends BaseButtonWidget<T> implements IButton {

	private static final long serialVersionUID = 1L;

	private static Icon icon;
	
	static {
		
		String deleteIconFile = ImageLoaderUtils.loadImage("delete.png");
		
		icon = new ImageIcon(deleteIconFile);
	}
	
	public DeleteButtonWidget(T component){

		super(component, icon, "Delete");
		
	}
	
}
