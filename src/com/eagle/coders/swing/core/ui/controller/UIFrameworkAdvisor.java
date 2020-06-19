/**
 * 
 */
package com.eagle.coders.swing.core.ui.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.java.dev.designgridlayout.DesignGridLayout;
import net.java.dev.designgridlayout.INonGridRow;

import com.blogofbug.swing.components.DockPanel;
import com.blogofbug.swing.components.ImageLabel;
import com.eagle.coders.swing.core.ui.cache.ComponentFormContainerMapCache;
import com.eagle.coders.swing.core.ui.controller.utils.FrameworkComponentLookupService;
import com.eagle.coders.swing.core.ui.decorator.widgets.TaskButtons;
import com.eagle.coders.swing.core.ui.images.utils.ImageLoaderUtils;
import com.eagle.coders.swing.core.ui.interfaces.IApplicationCreator;
import com.eagle.coders.swing.core.ui.interfaces.INavigationBar;
import com.eagle.coders.swing.core.ui.interfaces.ITaskBar;
import com.eagle.coders.swing.core.ui.interfaces.IToolbar;
import com.eagle.coders.swing.core.ui.usecase.container.cache.UsecaseContainerComponentCache;
import com.eagle.coders.swing.core.ui.usecase.container.listener.ContainerActionListenerAssociator;
import com.explodingpixels.macwidgets.MacUtils;

/**
 * @author Anees
 *
 */
public class UIFrameworkAdvisor {
	
	private static UIFrameworkAdvisor instance;
	
	private Collection<ITaskBar> taskBarList;
	
	private TreeSet<ITaskBar> taskBarSet;
	
	private Collection<IToolbar> toolBarList;
	
	private Collection<INavigationBar> navigationBarList;

	private Map<String, INavigationBar> navigationBarMap;
	
	private Map<String, IToolbar> toolBarMap;
	
	private Map<String, ITaskBar> taskBarMap;
	
	private JPanel navigationBarPanel;
	
	private JPanel taskBarPanel;
	
	private JPanel toolBarPanel;
	
	/**
	 * default taskBar component. TaskBar also includes ToolBar
	 */
	static {
		
	}
	
	private UIFrameworkAdvisor(){

		navigationBarMap = new HashMap<String, INavigationBar>();
		
		toolBarMap = new HashMap<String, IToolbar>();
		
		taskBarMap = new HashMap<String, ITaskBar>();
	
		buildFrameworkOutLook(new HashMap<String, String>());
		
	}
	


	/**
	 * 
	 * @return
	 */
	public static UIFrameworkAdvisor getInstance(){
		if( null == instance)
			instance = new UIFrameworkAdvisor();
		return instance;
	}
	/**
	 * 
	 */
	private void buildFrameworkOutLook(final Map<String, String> rights){
		
		if(rights.size() == 0 ){
			
			buildFrameworkOutLook();
		}else{

			taskBarList = FrameworkComponentLookupService.lookup(ITaskBar.class);

			taskBarSet = new TreeSet<ITaskBar>(taskBarList);

			toolBarList = FrameworkComponentLookupService.lookup(IToolbar.class);
			
			navigationBarList =	FrameworkComponentLookupService.lookup(INavigationBar.class);
			
//			UsecaseContainerComponentCache.getInstance().add
			
		}
		
	}

	/**
	 * 
	 */
	private void buildFrameworkOutLook(){
		
		taskBarList = FrameworkComponentLookupService.lookup(ITaskBar.class);
		
		toolBarList = FrameworkComponentLookupService.lookup(IToolbar.class);
		
		navigationBarList =	FrameworkComponentLookupService.lookup(INavigationBar.class);
		
		initNavigationBar();
		
		taskBarPanel = initTaskBar();
		
//		toolBarPanel = initToolBar();

	}

	/**
	 * 
	 */
	private void initNavigationBar(){
		
		for(INavigationBar navigationBar : navigationBarList){
		
			UsecaseContainerComponentCache.getInstance().addNavigationBarToCache(navigationBar.getNavigationBarIdentity(), navigationBar);
		}
		
	}
	
	/**
	 * 
	 * @return
	 */
	private JPanel initToolBar(){
		
		for(IToolbar toolBar : toolBarList){
			
			String componentID = toolBar.getBoundedComponent().getComponentIdentity();
			
			toolBarMap.put(componentID, toolBar);
		}
		
		return new JPanel();
	}
	
	/**
	 * 
	 * @return
	 */
	private JPanel initTaskBar(){
		
//		DockPanel dockPanel = new DockPanel(32, 100);
//		
//		dockPanel.setVisible(true);
		
		JPanel panel = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(panel);

		INonGridRow row = layout.row().center();
		
		TaskButtons<ITaskBar>[] btnArray = new TaskButtons[taskBarList.size()];
		
		int i = 0;
		
		for(ITaskBar taskBar : taskBarList){
			
//			ImageLabel imageLabel = new ImageLabel(taskBar.getTaskBarIcon(), 32,32);
			
			TaskButtons<ITaskBar> btn = new TaskButtons<ITaskBar>(taskBar);
			
			btnArray[i] = btn;
			
			row.add(btn);
			
			i++;
//			dockPanel.addDockElement(imageLabel, taskBar.getTaskBarLabel());
		}
		
		ContainerActionListenerAssociator.getInstance(btnArray);
		
		return panel;
	}



	/**
	 * @return the navigationBarPanel
	 */
	public JPanel getNavigationBarPanel() {
		return navigationBarPanel;
	}



	/**
	 * @return the taskBarPanel
	 */
	public JPanel getTaskBarPanel() {
		return taskBarPanel;
	}



	/**
	 * @return the toolBarPanel
	 */
	public JPanel getToolBarPanel() {
		return toolBarPanel;
	}
	
	

}
