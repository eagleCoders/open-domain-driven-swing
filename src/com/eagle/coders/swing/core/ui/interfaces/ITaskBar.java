/**
 * 
 */
package com.eagle.coders.swing.core.ui.interfaces;

import javax.swing.ImageIcon;

/**
 * @author Anees
 *
 */
public interface ITaskBar {
	
	int getTaskBarComponentPosition();
	
	ImageIcon getTaskBarIcon();
	
	String getTaskBarIconFilePath();
	
	String getTaskBarLabel();
	
	void executeAction();
	
	String getUseCaseContainerID();
	
	IUseCasesContainer getUseCaseContainer();
	
	
//	String getComponentIdentity();
	
//	IComponent getBoundedComponent();

}
