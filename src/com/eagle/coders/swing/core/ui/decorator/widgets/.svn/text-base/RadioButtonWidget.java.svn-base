/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.eagle.coders.swing.core.ui.bindings.MapValueModel;
import com.eagle.coders.swing.core.ui.cache.UIDomainPropertyHolder;
import com.jgoodies.binding.adapter.Bindings;

/**
 * @author Anees
 *
 */
public class RadioButtonWidget extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public RadioButtonWidget(){
		
	}

	public RadioButtonWidget(List<UIDomainPropertyHolder> propertyHolderList, MapValueModel valueModel){
		
		super();
		
		for(UIDomainPropertyHolder propertyHolder : propertyHolderList){
			
			add(createRadioButton(propertyHolder, valueModel));
		}

	}
	
	/**
	 * 
	 * @param propertyHolder
	 * @param valueModel
	 * @return
	 */
	public static JComponent createRadioButton(UIDomainPropertyHolder propertyHolder, MapValueModel valueModel){
		
		JRadioButton radioButton = new JRadioButton(propertyHolder.getUiPropertyLabel());
		
		Bindings.bind(radioButton, valueModel, propertyHolder.getRadioButtonChoice());
		
		return radioButton;
	}

}
