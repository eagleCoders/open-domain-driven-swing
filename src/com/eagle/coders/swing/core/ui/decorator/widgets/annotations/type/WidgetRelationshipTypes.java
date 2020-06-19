/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type;

/**
 * @author Anees
 *
 */
public enum WidgetRelationshipTypes {

	WIDGET_PARENT("parent"), WIDGET_DEPENDENT("dependent");
	
	private String value;
	
	private WidgetRelationshipTypes(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
}
