/**
 * 
 */
package com.eagle.coders.swing.core.ui.interfaces;

import java.util.List;

import javax.swing.Icon;

/**
 * @author Anees
 *
 */
public interface IUseCasesContainer {
	
	public String getUseCaseContainerID();
	
	public String getUseCaseContainerLabel();
	
	public List<String> getContainerComponentsIDs();
	
	public List<String> getTreebarIDs();
	
	public Icon getUsecaseContainerIcon();
	
	public String getUsecaseContainrIconFile();

}
