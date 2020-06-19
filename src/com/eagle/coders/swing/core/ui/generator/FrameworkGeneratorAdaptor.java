/**
 * 
 */
package com.eagle.coders.swing.core.ui.generator;

import javax.swing.JPanel;

import com.eagle.coders.swing.core.ui.controller.TaskBarCreator;
import com.eagle.coders.swing.core.ui.controller.UIFrameworkAdvisor;
import com.eagle.coders.swing.core.ui.decorator.UIMainDecorator;
import com.eagle.coders.swing.core.ui.interfaces.IApplicationCreator;

/**
 * @author Anees
 *
 */
public class FrameworkGeneratorAdaptor<T extends UIFrameworkAdvisor, U extends UIMainDecorator> {

	private T uiFrameworkAdvisor;
	
	private U uiMainDecorator;
	
	private JPanel taksBarPanel4Display;
	
	public FrameworkGeneratorAdaptor(T uiFrameworkAdvisor, U uiMainDecorator){
		
		this.uiFrameworkAdvisor = uiFrameworkAdvisor;
		
		this.uiMainDecorator = uiMainDecorator;
	}
	
	public FrameworkGeneratorAdaptor generate(){
		
		generateTaskBar(uiFrameworkAdvisor.getTaskBarPanel());
		
//		generateToolBar(uiFrameworkAdvisor.getToolBarPanel());
		
//		generateNavigationBar(uiFrameworkAdvisor.getNavigationBarPanel());
		
		return this;
	}
	
	/**
	 * 
	 * @param taskBarPanel
	 * @return
	 */
	private void generateTaskBar(JPanel taskBarPanel){
		
		IApplicationCreator creator = new TaskBarCreator(taskBarPanel);
		
		taksBarPanel4Display = creator.create();
		
	}
	
	/**
	 * 
	 * @param toolBarPanel
	 * @return
	 */
	private JPanel generateToolBar(JPanel toolBarPanel){
		return new JPanel();
	}
	
	/**
	 * 
	 * @param navigationBarPanel
	 * @return
	 */
	private JPanel generateNavigationBar(JPanel navigationBarPanel){
		
		return new JPanel();
	}

	/**
	 * @return the taksBarPanel4Display
	 */
	public JPanel getTaksBarPanel4Display() {
		return taksBarPanel4Display;
	}
	
	
}
