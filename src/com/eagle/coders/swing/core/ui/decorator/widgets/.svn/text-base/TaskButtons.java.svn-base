/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets;

import javax.swing.JButton;

import com.eagle.coders.swing.core.ui.interfaces.ITaskBar;
import com.eagle.coders.swing.core.ui.interfaces.IUseCasesContainer;

/**
 * @author Anees
 *
 */
public class TaskButtons<T extends ITaskBar> extends JButton {
	
	private static final long serialVersionUID = 1L;

	private IUseCasesContainer usecaseContainer;
	
	private T taskBar;
	
	public TaskButtons(final T taskBar){
		
		super(taskBar.getTaskBarIcon());
		
		this.taskBar = taskBar;
		
		setToolTipText(taskBar.getTaskBarLabel());
		
		usecaseContainer = taskBar.getUseCaseContainer();
		
	}

	/**
	 * @return the usecaseContainer
	 */
	public IUseCasesContainer getUsecaseContainer() {
		return usecaseContainer;
	}
	
	/**
	 * 
	 * @return
	 */
	public T getTaskBar(){
		
		return taskBar;
	}

}
