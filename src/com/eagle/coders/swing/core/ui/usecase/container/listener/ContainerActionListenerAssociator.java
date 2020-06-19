/**
 * 
 */
package com.eagle.coders.swing.core.ui.usecase.container.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.eagle.coders.swing.core.ui.decorator.widgets.TaskButtons;
import com.eagle.coders.swing.core.ui.interfaces.ITaskBar;
import com.eagle.coders.swing.core.ui.usecase.container.FrameUsecaseContainersAdvisor;

/**
 * @author Anees
 *
 */
public class ContainerActionListenerAssociator {

	private TaskButtons<ITaskBar>[] taskBtns;
	
	private static ContainerActionListenerAssociator instance;
	
	public static ContainerActionListenerAssociator getInstance(TaskButtons<ITaskBar>... btns){
		
		if(null == instance){
			instance = new ContainerActionListenerAssociator(btns);
		}
		return instance;
	}
	
	private ContainerActionListenerAssociator(){}
	
	private ContainerActionListenerAssociator( TaskButtons<ITaskBar>... btns){
		
		this.taskBtns = btns;
		
		initListeners();
	}
	
	private void initListeners(){
		
		for(int i = 0; i < taskBtns.length; i++){
			
			TaskButtons<ITaskBar> btn= taskBtns[i];
			
			btn.addActionListener(new ContainerActionHandler(btn.getTaskBar()));
		}
		
	}
	
	/**
	 * 
	 * @author Anees
	 *
	 */
	private class ContainerActionHandler implements ActionListener {
		
		private ITaskBar taskBar;
		
		public ContainerActionHandler(ITaskBar taskBar){
			
			this.taskBar = taskBar;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			FrameUsecaseContainersAdvisor.getInstance().loadUsecaseContainer(taskBar.getUseCaseContainer());
			
		}
	}
}
