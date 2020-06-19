/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import net.java.dev.designgridlayout.DesignGridLayout;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.jvnet.substance.SubstanceLookAndFeel;

import com.eagle.coders.swing.core.ui.annotations.type.UIComponentType;
import com.eagle.coders.swing.core.ui.bindings.MapValueModel;
import com.eagle.coders.swing.core.ui.bindings.UIDomainBinderInterfaceController;
import com.eagle.coders.swing.core.ui.cache.ComponentFormContainerMapCache;
import com.eagle.coders.swing.core.ui.cache.DomainPropertyValueModelHolder;
import com.eagle.coders.swing.core.ui.cache.DomainUIPropertiesMapCache;
import com.eagle.coders.swing.core.ui.cache.UIComponentDomainPropertyHolder;
import com.eagle.coders.swing.core.ui.cache.UIComponentPropertyValueModelHolder;
import com.eagle.coders.swing.core.ui.cache.UIDomainPropertyHolder;
import com.eagle.coders.swing.core.ui.controller.utils.AnnotationProcessingUtils;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.ComponentInterdependentActionAssociator;
import com.eagle.coders.swing.core.ui.interfaces.IComponent;
import com.eagle.coders.swing.core.ui.taskbar.utils.UiColumnComparator;
import com.eagle.coders.swing.core.ui.taskbar.utils.UiRowComparator;
import com.jgoodies.binding.list.ArrayListModel;

/**
 * @author Anees
 *
 */
public class UIFormDecorator {

	private static UIFormDecorator instance;
	
	private String componentID;
	
	private JPanel mainPanel;
	
	private JPanel compPanel;
	
	private String xmlForm;
	
	private Document document ;
	
	private Element root;
	
	private boolean isXMLForm = false;
	

	private UIFormDecorator(){
	}
	
	public static UIFormDecorator getInstance(){
		
		if(null == instance)
			instance = new UIFormDecorator();
		
		return instance;
	}
	
	/**
	 * 
	 * @param componentID
	 */
	public void decorate(String componentID, boolean isXMLForm){
		
		this.componentID = componentID;
		
		this.isXMLForm = isXMLForm;
		
		if(!isXMLForm)
			mainPanel = new JPanel();

		init();
	}
	
	/**
	 * 
	 */
	private void init(){

		Map<Class, List<UIDomainPropertyHolder>> clazzParamterMapAfterValidation = null;
	
		List<DomainPropertyValueModelHolder> domainPropertyVMHolderList = null;
		
		UIComponentDomainPropertyHolder uiComponentDomainPropertyHolder = 
			DomainUIPropertiesMapCache.getInstance().getUiCompDomainHolder();
		
		UIComponentPropertyValueModelHolder compValueModelHolder =
			DomainUIPropertiesMapCache.getInstance().getCompValueModelHolder();
		
		if(uiComponentDomainPropertyHolder.getComponentID().equals(componentID) && 
				compValueModelHolder.getComponentID().equals(componentID)){
			
			clazzParamterMapAfterValidation =
				uiComponentDomainPropertyHolder.getClazzParamterMapAfterValidation();
			
			
			domainPropertyVMHolderList = compValueModelHolder.getDomainPropertyValueModelList();
			
		    createUserInterface(clazzParamterMapAfterValidation, domainPropertyVMHolderList );
		}

	}
	
	/**
	 * 
	 * @param clazzParamterMapAfterValidation
	 * @param domainPropertyVMHolderList
	 */
	private void createUserInterface(Map<Class, List<UIDomainPropertyHolder>> clazzParamterMapAfterValidation,
			List<DomainPropertyValueModelHolder> domainPropertyVMHolderList ){

		JTabbedPane domainTabbedPane = new JTabbedPane();
		
		if(isXMLForm){
			
			document = DocumentFactory.getInstance().createDocument();
			
			root = document.addElement("gwt-usecase");
			
			root.addAttribute("usecaseID", componentID);
		}

		
		Map<Integer, Class> processMap = DomainUIPropertiesMapCache.getInstance().getClazzPositionHolder(componentID);
		
		Set<Integer> iSet= processMap.keySet();
		
		for(Integer seq : iSet){
			
			Class clazz = processMap.get(seq);
			
			String title = AnnotationProcessingUtils.processDomainTitle(clazz);
			
			if(clazzParamterMapAfterValidation.containsKey(clazz)){
				
				clazzParamterMapAfterValidation.get(clazz);
				
				Map<String, MapValueModel> domainPropertyModelMap = 
					getValueModelForGivenDomainObject(clazz.getName(), domainPropertyVMHolderList);
				
//				// Bindable Data for the child table if any
				Map<String, ArrayListModel<Map<String, Object>>> childTableDataMap =
					getChildTablePerDomainListMap(clazz.getName(), domainPropertyVMHolderList);
				
				List<UIDomainPropertyHolder> propertyHolderList = clazzParamterMapAfterValidation.get(clazz);
				
				SortedMap<Integer, List<UIDomainPropertyHolder>> propertyHolderListMap0 = 
					sortUiDomainPropertyHolderList(propertyHolderList);
				
				/*
				 * setting the generated Form to the mainPanel
				 */
//				mainPanel = FormBuilder.build(domainPropertyModelMap, propertyHolderListMap0);
				if(!isXMLForm){
					
					compPanel = FormBuilder.build(domainPropertyModelMap, childTableDataMap, propertyHolderListMap0, componentID);
					
				}else{
					
					Element usecaeNode = root.addElement("usecase");
					
					usecaeNode.addAttribute("title", title);
					
					FormBuilder.build(domainPropertyModelMap, propertyHolderListMap0, componentID, true, usecaeNode);
				}
				
//				interdependncy association
				DomainUIPropertiesMapCache.getInstance().addIdBasedComponentInterBindingInfoMap(componentID, 
						FormBuilder.getComponentInterBindingInfoHolder());
				
				ComponentInterdependentActionAssociator.associateInterComponentBinding(componentID);
				
				if(!isXMLForm){
					
					compPanel.putClientProperty(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,
							Boolean.FALSE);
					domainTabbedPane.addTab(title, compPanel);
//				
					mainPanel.add(domainTabbedPane);
				}

			}
		}
		
		if(isXMLForm){
			xmlForm = document.asXML();
		}
		
	}
	
	/**
	 * 
	 * @param propertyHolderList
	 * @return
	 */
	private SortedMap<Integer, List<UIDomainPropertyHolder>> sortUiDomainPropertyHolderList(List<UIDomainPropertyHolder> propertyHolderList){
		
		SortedMap<Integer, List<UIDomainPropertyHolder>> rowPropertyHolderMap =
			new TreeMap<Integer, List<UIDomainPropertyHolder>>();
		
		
		
		for(UIDomainPropertyHolder uiDomainPropertyHolder : propertyHolderList){
			
			if(null !=  uiDomainPropertyHolder.getUiPositionRow()){

				if(rowPropertyHolderMap.containsKey(uiDomainPropertyHolder.getUiPositionRow())){
					
					List<UIDomainPropertyHolder> propertyHolderList1 = 
						rowPropertyHolderMap.get(uiDomainPropertyHolder.getUiPositionRow());
					
					propertyHolderList1.add(uiDomainPropertyHolder);
					
					Collections.sort(propertyHolderList1, new UiColumnComparator());
					
					rowPropertyHolderMap.put(uiDomainPropertyHolder.getUiPositionRow(), propertyHolderList1);
					
				}else {

					List<UIDomainPropertyHolder> propertyHolderList0 = new ArrayList<UIDomainPropertyHolder>();

					propertyHolderList0.add(uiDomainPropertyHolder);
					
					rowPropertyHolderMap.put(uiDomainPropertyHolder.getUiPositionRow(), propertyHolderList0);
				}
			}
		}
		
		return rowPropertyHolderMap;
	}
	
	/**
	 * 
	 * @param domainObject
	 * @param domainPropertyVMHolderList
	 */
	private Map<String, MapValueModel> getValueModelForGivenDomainObject(String domainObject,
			List<DomainPropertyValueModelHolder> domainPropertyVMHolderList){
		
		Map<String, MapValueModel> domainPropertyModelMap = null;
		
		for(DomainPropertyValueModelHolder domainPropertyValueModelHolder : domainPropertyVMHolderList){
			
			if(domainPropertyValueModelHolder.getDomainObject().equals(domainObject)){
				
				domainPropertyModelMap = domainPropertyValueModelHolder.getDomainPropertyModelMap();
				
				break;
				
			}
		}
		
		if(null != domainPropertyModelMap)
			return domainPropertyModelMap;
		else 
			return new HashMap<String, MapValueModel>();
	}
	
	/**
	 * 
	 * @param domainObject
	 * @param domainPropertyVMHolderList
	 * @return
	 */
	private Map<String, ArrayListModel<Map<String, Object>>> getChildTablePerDomainListMap(String domainObject,
			List<DomainPropertyValueModelHolder> domainPropertyVMHolderList){
		
		Map<String, ArrayListModel<Map<String, Object>>> childTableListMap = null;
		
		for(DomainPropertyValueModelHolder domainPropertyValueModelHolder : domainPropertyVMHolderList){
			
			if(domainPropertyValueModelHolder.getDomainObject().equals(domainObject)){
				
				childTableListMap = domainPropertyValueModelHolder.getChildDomainTableDataMap();
				
				break;
				
			}
		}
		
		if(null != childTableListMap)
			return childTableListMap;
		else 
			return new HashMap<String, ArrayListModel<Map<String,Object>>>();
	
	}
	
	/**
	 * @return the mainPanel
	 */
	public JPanel getMainPanel() {
		return mainPanel;
	}

	/**
	 * 
	 * @return xmlForm
	 */
	public String getXmlForm(){
		return xmlForm;
	}
}
