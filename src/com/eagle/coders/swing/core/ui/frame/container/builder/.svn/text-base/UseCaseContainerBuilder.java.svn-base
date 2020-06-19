package com.eagle.coders.swing.core.ui.frame.container.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

import com.eagle.coders.swing.core.ui.bindings.UIDomainBinderInterfaceController;
import com.eagle.coders.swing.core.ui.cache.ComponentFormContainerMapCache;
import com.eagle.coders.swing.core.ui.controller.utils.FrameworkComponentLookupService;
import com.eagle.coders.swing.core.ui.frame.FormContainer;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;
import com.eagle.coders.swing.core.ui.interfaces.INavigationBar;
import com.eagle.coders.swing.core.ui.interfaces.IUseCasesContainer;
import com.eagle.coders.swing.core.ui.taskbar.utils.SortingNavigationBarComparator;
import com.eagle.coders.swing.core.ui.usecase.container.UsecaseContainerAdvisor;
import com.eagle.coders.swing.core.ui.usecase.container.cache.UsecaseContainerComponentCache;

/**
 * 
 * @author Anees
 * @history  August 04,2009 : adding UIDomainBinderInterfaceController<IComponent> binding = new UIDomainBinderInterfaceController<IComponent>(
 *							  comp, false); for loadAllComponentsToCache()
 */
public class UseCaseContainerBuilder {


	private static UseCaseContainerBuilder instance;
	
	private List<INavigationBar> navigationBarList;
	
	private JDesktopPane desktop;
	
	private UsecaseContainerAdvisor childContainer ;
	
	/**
	 * @return the navigationBarList
	 */
	public List<INavigationBar> getNavigationBarList() {
		return navigationBarList;
	}

	public UseCaseContainerBuilder() {
		
	}

	/**
	 * 
	 * @return
	 */
	public static UseCaseContainerBuilder getInstance() {

		if (null == instance) {

			instance = new UseCaseContainerBuilder();
		}

		return instance;
	}

	public JSplitPane createUseCaseContainer(final IUseCasesContainer container) {

		List<String> treeBarList = container.getTreebarIDs();
		
		navigationBarList = new ArrayList<INavigationBar>();
		

		List<String> useCaseContainerList = container
				.getContainerComponentsIDs();

		if( null != useCaseContainerList){
			
			for (String component : useCaseContainerList) {

				FormContainer<IComponent> formConatainer = ComponentFormContainerMapCache.getInstance().getComponentContainerMap(component);
				
				if(null == formConatainer){
					
					loadAllComponentsToCache();
					break;
				}
			}
		}
		
		if(null != treeBarList){
			
			for(String treeBar : treeBarList){
				
				if(null != UsecaseContainerComponentCache.getInstance().getNavigationByID(treeBar)){
					
					INavigationBar navigationBar = UsecaseContainerComponentCache.getInstance().getNavigationByID(treeBar);
					
					navigationBarList.add(navigationBar);
				}
			}
		}
		
		Collections.sort(navigationBarList, new SortingNavigationBarComparator());

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		if(navigationBarList.size() > 0)
			splitPane.setLeftComponent(createNavigationTree(navigationBarList, container));
		else
			splitPane.setLeftComponent(new JTree());
		
		desktop = new JDesktopPane();
		
		childContainer = new UsecaseContainerAdvisor();
		
//		UsecaseContainerAdvisor.getInstance().loadDesktop(desktop);
		
		childContainer.loadDesktop(desktop, navigationBarList.size());
		
		splitPane.setRightComponent(desktop);
		
		splitPane.setVisible(true);

		return splitPane;

	}

	/**
	 * 
	 */
	public void loadAllComponentsToCache() {

		List<IComponent> coll = (List) FrameworkComponentLookupService.lookup(IComponent.class);

		for (IComponent comp : coll) {
			
			UIDomainBinderInterfaceController<IComponent> binding = new UIDomainBinderInterfaceController<IComponent>(
					comp, false);

			FormContainer<IComponent> frameContainer = new FormContainer<IComponent>(comp);

			ComponentFormContainerMapCache.getInstance().addComponentConterMap(comp.getComponentIdentity(), frameContainer);
		}
	}

	/**
	 * 
	 */
	private JTree createNavigationTree(final List<INavigationBar> navigationBarList, final IUseCasesContainer container){
		
		
		MutableTreeNode root = new DefaultMutableTreeNode(container.getUseCaseContainerLabel());

		for(INavigationBar navigationBar : navigationBarList){
			
			MutableTreeNode childNode = new DefaultMutableTreeNode(navigationBar);
			
			root.insert(childNode, navigationBar.getNavigationBarComponentPosition());
		}
		
		DefaultTreeModel treeModel = new DefaultTreeModel(root);
		
		JTree tree = new JTree(treeModel);
		
		tree.addTreeSelectionListener(new NavigationTreeListener());
		
//		tree.setRootVisible(false);
		
		return tree;
	}
	
	/**
	 * 
	 * @author Anees
	 *
	 */
	private class NavigationTreeListener implements TreeSelectionListener {

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			
			JTree tree = (JTree) e.getSource();
			
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			
			if (node == null) return;
			
			Object nodeInfo = node.getUserObject();
		    
			if (node.isLeaf()) {
		        
				INavigationBar navigationBar =(INavigationBar) nodeInfo;
				
				FormContainer<IComponent> fContainer =
					ComponentFormContainerMapCache.getInstance().getComponentContainerMap(navigationBar.getComponentIdentity());
				
//				UsecaseContainerAdvisor.getInstance().loadFormContainer(fContainer, "Hi");
				
				childContainer.loadFormContainer(fContainer, "Hi");

		    }
		}

		
	}
	
}
