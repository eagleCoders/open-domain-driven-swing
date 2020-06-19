/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;

import net.java.dev.designgridlayout.DesignGridLayout;
import net.java.dev.designgridlayout.INonGridRow;
import net.java.dev.designgridlayout.ISpannableGridRow;

import com.eagle.coders.swing.core.ui.annotations.type.StaticPresentationPolicyType;
import com.eagle.coders.swing.core.ui.annotations.type.UIComponentType;
import com.eagle.coders.swing.core.ui.bindings.MapValueModel;
import com.eagle.coders.swing.core.ui.cache.DomainUIPropertiesMapCache;
import com.eagle.coders.swing.core.ui.cache.UIDomainPropertyHolder;
import com.eagle.coders.swing.core.ui.cache.UiComponentsInterBindingInformationHolder;
import com.eagle.coders.swing.core.ui.decorator.widgets.RadioButtonWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.TableWidget;
import com.eagle.coders.swing.core.ui.decorator.widgets.UiWidgets;
import com.eagle.coders.swing.core.ui.validation.ComponentConstraintAssociator;
import com.jgoodies.binding.list.ArrayListModel;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.Sizes;
import com.sun.rowset.internal.Row;

/**
 * @author Anees
 *
 */
public class FormBuilder {

	private static UiComponentsInterBindingInformationHolder componentInterBindingInfoHolder;
	
	/**
	 * 
	 * @param domainPropertyModelMap
	 * @param propertyHolderListMap0
	 * @param componentID
	 * @param isXML
	 * @return String xmlString
	 */
	public static String build(Map<String, MapValueModel> domainPropertyModelMap,
			SortedMap<Integer, List<UIDomainPropertyHolder>> propertyHolderListMap0, String componentID, boolean isXML, Element usecaseNode){
		
//		Document document = DocumentFactory.getInstance().createDocument();
		
		Element usecaseRoot = usecaseNode.addElement("gwt-form");
		
//		usecaseRoot.addAttribute("id", componentID);
		
		if(isXML){

			Set<Integer> rows= propertyHolderListMap0.keySet();
		
			for(Integer row : rows){
				
				Element rowNode = usecaseRoot.addElement("row");
				
				rowNode.addAttribute("row", row.toString());
				
				List<UIDomainPropertyHolder> propertyColumnList = propertyHolderListMap0.get(row);

//				TODO: creating the nodes for xml rows showing the columns
				buildColumnNodes(propertyColumnList, domainPropertyModelMap, componentID, rowNode);
			}
		}
		
		
		return "";
	}
	
	/**
	 * 
	 * @param domainPropertyModelMap
	 * @param propertyHolderListMap0
	 * @return
	 */
	public static JPanel build(Map<String, MapValueModel> domainPropertyModelMap, Map<String, ArrayListModel<Map<String, Object>>> childTableMap, 
			SortedMap<Integer, List<UIDomainPropertyHolder>> propertyHolderListMap0, String componentID){
		
		componentInterBindingInfoHolder = new UiComponentsInterBindingInformationHolder();
		
		JPanel panel = new JPanel();
		
		DesignGridLayout gridLayout = new DesignGridLayout(panel);
		
		JScrollPane scrollPanel = new JScrollPane(panel);
		
		Set<Integer> rows= propertyHolderListMap0.keySet();
		
		for(Integer row : rows){
			
			List<UIDomainPropertyHolder> propertyColumnList = propertyHolderListMap0.get(row);
			
			JPanel rowPanel = buildColumns(propertyColumnList, domainPropertyModelMap, childTableMap, componentID);
			
			gridLayout.row().left().add(rowPanel);
//			
		}
		
		return panel;
	}
	
	
	/**
	 * 
	 * @param propertyColumnList
	 * @return
	 */
	public static JPanel buildColumns(List<UIDomainPropertyHolder> propertyColumnList,
			Map<String, MapValueModel> domainPropertyModelMap, Map<String, ArrayListModel<Map<String, Object>>> childTableMap,
			String componentID){
		
		return createComponent(propertyColumnList, domainPropertyModelMap, childTableMap, componentID);
//		return createComponent(propertyColumnList, domainPropertyModelMap, rowBuilder, componentID);
	}

	/**
	 * 
	 * @param propertyColumnList
	 * @param domainPropertyModelMap
	 * @param componentID
	 * @return
	 */
	public static String buildColumnNodes(List<UIDomainPropertyHolder> propertyColumnList,
			Map<String, MapValueModel> domainPropertyModelMap, String componentID, Element rowNumber){
		
		/* it will just create the xml for columns with the proper info for the component type, position in row 
		 * and validation properties 
		 */
		int colPosition = 1;

		for(UIDomainPropertyHolder propertyHolder : propertyColumnList ){
			
			Element columnNode = rowNumber.addElement("column");
			
			columnNode.addAttribute("colPosition", String.valueOf(colPosition));
			
			Element widgetNode = columnNode.addElement("widget");
			
			String pLabel= propertyHolder.getUiPropertyLabel();
			
			Element labelNode = widgetNode.addElement("node-label");
			
			labelNode.addAttribute("label", pLabel);
			
//			widgetNode.addAttribute("name", pLabel);
			
			String propertyName = propertyHolder.getDomainProperty();
			
			
//			rowBuilder.append(label);
			
			if(domainPropertyModelMap.containsKey(propertyName)){
				
				MapValueModel mapValueModel = domainPropertyModelMap.get(propertyName);
				
				String propertyType = propertyHolder.getUiPropertyType();
				
				generateWidgetNode(propertyHolder, mapValueModel, componentID, widgetNode);
			}
			
			colPosition++;
		}
		
		return "";
		
	}

	/**
	 * 
	 * @param propertyColumnList
	 * @param rowBuilder
	 * @return
	 */
	public static JPanel createComponent(List<UIDomainPropertyHolder> propertyColumnList,
			Map<String, MapValueModel> domainPropertyModelMap, Map<String, ArrayListModel<Map<String, Object>>> childTableMap,
			String componentID){

		JPanel panel = new JPanel();
		
		CellConstraints c = new CellConstraints();
		
		DesignGridLayout gridLayout = new DesignGridLayout(panel);
		
		ISpannableGridRow rowCreator = gridLayout.row().grid();
		
		for(UIDomainPropertyHolder propertyHolder : propertyColumnList ){
			
			String pLabel= propertyHolder.getUiPropertyLabel();
			
			String propertyName = propertyHolder.getDomainProperty();
			
			JLabel label = new JLabel(pLabel);
			
			if(domainPropertyModelMap.containsKey(propertyName)){
				
				MapValueModel mapValueModel = domainPropertyModelMap.get(propertyName);
				
				String propertyType = propertyHolder.getUiPropertyType();
				
				Class<? extends Object> relationshipInfoHolder = propertyHolder.getRelationshipClassProperty();
				
				JComponent component = 
					generateComponentByType(propertyHolder, mapValueModel, childTableMap, componentID);
				
				if(component instanceof JTextArea ){
					
					JPanel rowPanel = new JPanel();
					
					DesignGridLayout rowLayout = new DesignGridLayout(rowPanel);

					rowLayout.row().left().add(label);
					
					JScrollPane scrollPanel = new JScrollPane(component);
					
					rowLayout.row().left().add(scrollPanel);
				
					rowCreator.add(rowPanel);
					
				}else if(component instanceof TableWidget){
					
					TableWidget tableWidget =(TableWidget)component;
					
					tableWidget.setBorder(BorderFactory.createTitledBorder(label.getText()));
				
					rowCreator.add(tableWidget);
					
					
				}else if (component instanceof RadioButtonWidget){
					
					FormLayout formLayout = new FormLayout(new ColumnSpec[] {FormFactory.RELATED_GAP_COLSPEC,
							new ColumnSpec("right:60dlu:grow(1.0)"),
							FormFactory.RELATED_GAP_COLSPEC,
							FormFactory.DEFAULT_COLSPEC},
							new RowSpec[]{
							FormFactory.DEFAULT_ROWSPEC});
					
					JPanel nonTablePanel = new JPanel();
					
					nonTablePanel.setLayout(formLayout);

					nonTablePanel.add(label, new CellConstraints(2,1));

					nonTablePanel.add(component, new CellConstraints(4,1));

					rowCreator.add(nonTablePanel);
					
				}else if (component instanceof JPanel){ //TODO: have to work on this in latter stages to remove JPanel insetad of some
														// enhanced widgets
					
					JPanel userPanel =(JPanel) component;
					
					StaticPresentationPolicyType policy = propertyHolder.getUserPanelDisplayPolicy();
					
					rowCreator.add(processStaticPanel(userPanel, policy, label));
					
				}else {
					
					FormLayout formLayout = new FormLayout(new ColumnSpec[] {FormFactory.RELATED_GAP_COLSPEC,
							new ColumnSpec("right:60dlu:grow(1.0)"),
							FormFactory.RELATED_GAP_COLSPEC,
							new ColumnSpec("70dlu:grow(1.0)")},
							new RowSpec[]{
							FormFactory.DEFAULT_ROWSPEC});

					JPanel nonTablePanel = new JPanel();
					
					nonTablePanel.setLayout(formLayout);

					nonTablePanel.add(label, new CellConstraints(2,1));

					nonTablePanel.add(component, new CellConstraints(4,1));
					
//					rowLayout.row().left().add(label, component);
					
					rowCreator.add(nonTablePanel);
				}
				
//				rowCreator.add(label).add(component);
				
//				rowBuilder.append(component);
			}
			
		}
		return panel;
//		return rowBuilder.getPanel();
	}
	
	/**
	 * 
	 * @param userPanel
	 * @param policy
	 * @param label
	 * @return
	 */
	private static JPanel processStaticPanel(JPanel userPanel, StaticPresentationPolicyType policy, JLabel label){
		
		JPanel rowPanel = new JPanel();
		
		if(StaticPresentationPolicyType.PANEL.equals(policy)){
			
			DesignGridLayout rowLayout = new DesignGridLayout(rowPanel);
//
//			rowLayout.row().left().add(label);
//			
//			JScrollPane scrollPanel = new JScrollPane(component);
			userPanel.setBorder(BorderFactory.createTitledBorder(label.getText()));
//			
			rowLayout.row().left().add(userPanel);
			
		}
//		TODO: have to implement this latter
//		else if(StaticPresentationPolicyType.COLUMN.equals(policy)){
//			
//		}
		
		return rowPanel;
	}
	
	/**
	 * 
	 * @param propertyHolder
	 * @param valueModel
	 * @param componentID
	 * @param widgetElement
	 */
	private static void generateWidgetNode(UIDomainPropertyHolder propertyHolder, MapValueModel valueModel, String componentID,
			Element widgetElement){
		
		if(propertyHolder.getUiPropertyType().equals(UIComponentType.COMPNENT_TEXTFIELD.getValue())){
			
			UiWidgets.createWidgetNode(widgetElement, "text", propertyHolder);
			
		}else if (propertyHolder.getUiPropertyType().equals(UIComponentType.COMPNENT_PASSWORD.getValue())){
			
			UiWidgets.createWidgetNode(widgetElement, "password", propertyHolder);
			
		}else if(propertyHolder.getUiPropertyType().equals(UIComponentType.COMPONENT_TEXTAREA.getValue())){
			
			UiWidgets.createWidgetNode(widgetElement, "textArea", propertyHolder);
			
		}else if(propertyHolder.getUiPropertyType().equals(UIComponentType.COMPNENT_TABLE.getValue())){
		
			if(null != propertyHolder.getRelationshipClassProperty()){
				
				UiWidgets.createTableNode(widgetElement, "table", propertyHolder.getRelationshipClassProperty());
			}
			
		}else if(propertyHolder.getUiPropertyType().equals(UIComponentType.COMPONENT_CHECKBOX.getValue())){
			
			UiWidgets.createWidgetNode(widgetElement, "checkBox", null);
			
		}else if(propertyHolder.getUiPropertyType().equals(UIComponentType.COMPNENT_COMBOBOX.getValue())){
			
			UiWidgets.createWidgetNode(widgetElement, "combobox", null);
			
		}else if(propertyHolder.getUiPropertyType().equals(UIComponentType.COMPNENT_LIST.getValue())){
			
			UiWidgets.createWidgetNode(widgetElement, "list", null);
			
		}else if( propertyHolder.getUiPropertyType().equals(UIComponentType.COMPNENT_RADIOBUTTON.getValue())){
			
			UiWidgets.createRadioButtonNode(propertyHolder.getDomainPropertyHolderList(), widgetElement, "radioButton");
			
		}else if(propertyHolder.getUiPropertyType().equals(UIComponentType.COMPONENT_FMT_TXT.getValue())){
			
//			TODO: Formate definition of the JFormateTdTextField is left
			UiWidgets.createWidgetNode(widgetElement, "text", propertyHolder);
			
		}else if(propertyHolder.getUiPropertyType().equals(UIComponentType.COMPONENT_DATE.getValue())){
			
			UiWidgets.createWidgetNode(widgetElement, "date", null);
			
		}else if (propertyHolder.getUiPropertyType().equals(UIComponentType.COMPNENT_PANEL.getValue())){
			
			UiWidgets.createWidgetNode(widgetElement, "text", null);//Temporary purpose - I will change this latter
			
		}
		
//		TODO: ========================== I will do it latter ================================
//		if(null != propertyHolder.getParentProperty() && null != propertyHolder.getDependentProperty()){
//			
//			componentInterBindingInfoHolder.addParentChildComponentHolder(propertyHolder.getParentProperty(),
//					propertyHolder.getDependentProperty());
////			DomainUIPropertiesMapCache.getInstance().addParentChildComponentHolder(propertyHolder.getParentProperty(),
////					propertyHolder.getDependentProperty());
//		}
		
//		componentInterBindingInfoHolder.addPropertyComponentHolder(propertyHolder.getDomainProperty(),
//				component);
//		DomainUIPropertiesMapCache.getInstance().addPropertyComponentHolder(propertyHolder.getDomainProperty(),
//				component);
		
	}
	
	/**
	 * 
	 * @param label
	 * @param propertyName
	 * @param propertyType
	 */
	private static JComponent generateComponentByType(UIDomainPropertyHolder propertyHolder,
			MapValueModel valueModel, Map<String, ArrayListModel<Map<String, Object>>> childTableMap,
			String componentID){
		
		
		JComponent component = null;
		
		if(propertyHolder.getUiPropertyType().equals(UIComponentType.COMPNENT_TEXTFIELD.getValue())){
			
			component = UiWidgets.createTextField( propertyHolder, 10, valueModel);
			
//			component = UiWidgets.createFormatedTextField( propertyHolder, valueModel);

		}else if (propertyHolder.getUiPropertyType().equals(UIComponentType.COMPNENT_PASSWORD.getValue())){
			
			component = UiWidgets.createPasswordField('*', valueModel);
			
		}else if(propertyHolder.getUiPropertyType().equals(UIComponentType.COMPONENT_TEXTAREA.getValue())){
			
			component = UiWidgets.createTextArea(null, null, valueModel);
			
		}else if(propertyHolder.getUiPropertyType().equals(UIComponentType.COMPNENT_TABLE.getValue())){
		
			if(null != propertyHolder.getRelationshipClassProperty()){
				
				component = UiWidgets.createJTable(propertyHolder.getRelationshipClassProperty(), null, childTableMap, true);
			}
			
		}else if(propertyHolder.getUiPropertyType().equals(UIComponentType.COMPONENT_CHECKBOX.getValue())){
			
			component = UiWidgets.createCheckbox(valueModel);
			
		}else if(propertyHolder.getUiPropertyType().equals(UIComponentType.COMPNENT_COMBOBOX.getValue())){
			
			component = UiWidgets.createCombobox(null, valueModel);
			
		}else if(propertyHolder.getUiPropertyType().equals(UIComponentType.COMPNENT_LIST.getValue())){
			
			component = UiWidgets.createList();
			
		}else if( propertyHolder.getUiPropertyType().equals(UIComponentType.COMPNENT_RADIOBUTTON.getValue())){
			
			component = UiWidgets.createRadioButton(propertyHolder.getDomainPropertyHolderList(), valueModel);
			
		}else if(propertyHolder.getUiPropertyType().equals(UIComponentType.COMPONENT_FMT_TXT.getValue())){
			
//			TODO: Formate definition of the JFormateTdTextField is left
			component = UiWidgets.createFormatedTextField(propertyHolder, valueModel);
			
		}else if(propertyHolder.getUiPropertyType().equals(UIComponentType.COMPONENT_DATE.getValue())){
			
			component = UiWidgets.createDate(propertyHolder.getDomainProperty(), valueModel);
			
		}else if (propertyHolder.getUiPropertyType().equals(UIComponentType.COMPNENT_PANEL.getValue())){
			
			component = propertyHolder.getUserPanel();
			
		}
		
		if(null != propertyHolder.getParentProperty() && null != propertyHolder.getDependentProperty()){
			
			componentInterBindingInfoHolder.addParentChildComponentHolder(propertyHolder.getParentProperty(),
					propertyHolder.getDependentProperty());
//			DomainUIPropertiesMapCache.getInstance().addParentChildComponentHolder(propertyHolder.getParentProperty(),
//					propertyHolder.getDependentProperty());
		}
		
		componentInterBindingInfoHolder.addPropertyComponentHolder(propertyHolder.getDomainProperty(),
				component);
//		DomainUIPropertiesMapCache.getInstance().addPropertyComponentHolder(propertyHolder.getDomainProperty(),
//				component);
		
		return component;
	}
	
	/**
	 * @return the componentInterBindingInfoHolder
	 */
	public static UiComponentsInterBindingInformationHolder getComponentInterBindingInfoHolder() {
		return componentInterBindingInfoHolder;
	}
	
	
}