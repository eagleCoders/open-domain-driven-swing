/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets;

import javax.swing.Icon;
import javax.swing.JButton;

import com.eagle.coders.swing.core.ui.interfaces.IButton;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;

/**
 * @author Anees
 *
 */
public class BaseButtonWidget<T extends IComponent> extends JButton implements IButton  {

	private static final long serialVersionUID = 1L;

	private T component;
	
	private String componentID;
	
//	private  Icon icon;
	
	
	
	public BaseButtonWidget(T component, Icon icon, String tooltip){
	
		super(icon);
		
		this.component = component;
		
		this.setToolTipText(tooltip);
		
		setComponentID(this.component.getComponentIdentity());
		
	}
	
//	public BaseButtonWidget(T component, String label, String tooltip){
//		
//		button = new JButton(label);
//		
//		this.component = component;
//		
//		button.setToolTipText(tooltip);
//		
//		setComponentID(this.component.getComponentIdentity());
//
//	}
//	
//	public BaseButtonWidget(T component, Icon icon, String tooltip){
//		
//		button = new JButton(icon);
//		
//		button.setSize(icon.getIconWidth(), icon.getIconHeight());
//		
//		this.component = component;
//		
//		button.setToolTipText(tooltip);
//		
//		setComponentID(this.component.getComponentIdentity());
//		
//	}
//
//	public BaseButtonWidget(T component, String tooltip){
//		
//		button = new JButton();
//		
////		button.setSize(icon.getIconWidth(), icon.getIconHeight());
//		
//		this.component = component;
//		
//		button.setToolTipText(tooltip);
//		
//		setComponentID(this.component.getComponentIdentity());
//		
//	}
	

	/**
	 * 
	 * @return
	 */
	public String getComponentID() {
		return componentID;
	}

	/**
	 * 
	 * @param componentID
	 */
	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}

	@Override
	public Object getCurrentObject() {
		return this;
	}
	
}
