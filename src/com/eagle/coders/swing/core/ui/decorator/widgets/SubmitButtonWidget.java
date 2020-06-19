package com.eagle.coders.swing.core.ui.decorator.widgets;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.Button;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.images.utils.ImageLoaderUtils;
import com.eagle.coders.swing.core.ui.interfaces.IButton;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;

/**
 * 
 * @author Anees
 *
 */
@Button(buttonType = ActionTypes.SUBMIT_ACTION, imageFiles = "submit-action.png")
public class SubmitButtonWidget<T extends IComponent> extends BaseButtonWidget<T> implements IButton {

	private static final long serialVersionUID = 1L;
	
	private static Icon icon;
	
	static {
		
		String deleteIconFile = ImageLoaderUtils.loadImage("submit-action.png");
		
		icon = new ImageIcon(deleteIconFile);
	}
	
	public SubmitButtonWidget(T component){
		
		super(component, icon, "Submit");
		
	}
	
}
