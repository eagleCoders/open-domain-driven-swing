/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.type;

/**
 * @author Anees
 *
 */
public enum WidgetClientPropertyType {
	
	WIDGET_CLIENT_PROPERTY("clientProperty");

	private String value;
	
	private WidgetClientPropertyType(String value){
		this.value = value;
	}

	public String getValue(){
		return this.value;
	}
}
