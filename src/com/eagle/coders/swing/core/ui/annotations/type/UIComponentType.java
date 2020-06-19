/**
 * 
 */
package com.eagle.coders.swing.core.ui.annotations.type;

/**
 * @author Anees
 *
 */
public enum UIComponentType {
	
	COMPNENT_TEXTFIELD("tf"), COMPONENT_TEXTAREA("ta"), COMPONENT_CHECKBOX("ckbx"), 
	COMPNENT_RADIOBUTTON("E"), COMPNENT_COMBOBOX("cmbx"), COMPNENT_LIST("lst"),
	COMPNENT_TABLE("tb"), COMPNENT_PASSWORD("pswd"), COMPONENT_FMT_TXT("fmttf"), COMPONENT_DATE("dt"),
	COMPNENT_PANEL("panel");

	private String value;
	
	private UIComponentType(String value){
		this.value = value;
	}

	public String getValue(){
		return this.value;
	}

}
