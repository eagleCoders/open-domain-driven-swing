/**
 * 
 */
package com.eagle.coders.swing.core.ui.cache.session.type;

/**
 * @author Anees
 *
 */
public enum SessionType {

	USER_SESSION_INFO("userSessionInfo");
	
	private String value;
	
	private SessionType(String value){
		this.value = value;
	}

	public String getValue(){
		return this.value;
	}
	
}
