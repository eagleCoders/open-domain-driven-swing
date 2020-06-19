/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JSpinner.DateEditor;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

import org.dom4j.Element;

import net.java.dev.designgridlayout.DesignGridLayout;
import net.java.dev.designgridlayout.INonGridRow;
import net.java.dev.designgridlayout.IRowCreator;

import com.eagle.coders.swing.core.ui.annotations.type.StringInputCaseType;
import com.eagle.coders.swing.core.ui.annotations.type.TextFiledInputDataType;
import com.eagle.coders.swing.core.ui.bindings.MapValueModel;
import com.eagle.coders.swing.core.ui.bindings.MapVetoableValueModelAdaptor;
import com.eagle.coders.swing.core.ui.cache.UIDomainPropertyHolder;
import com.eagle.coders.swing.core.ui.controller.utils.JavaBeanUtils;
import com.eagle.coders.swing.core.ui.decorator.widgets.controller.PromptText;
import com.eagle.coders.swing.core.ui.validation.ComponentConstraintAssociator;
import com.eagle.coders.swing.core.ui.validation.PropertyConstraintsHolder;
import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.list.ArrayListModel;
import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.binding.value.BufferedValueModel;
import com.toedter.calendar.JDateChooser;

/**
 * @author Anees
 *
 */
public class UiWidgets {
	
	private static final String alpha = "ABCDEFGHIJKLMNONPQRSTUVWXYZ";
	
	private static final String numeric = "1234567890";
	
	private static final String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

	/**
	 * 
	 * @param widgetNode
	 * @param type
	 */
	public static void createWidgetNode(Element widgetNode, String type, UIDomainPropertyHolder propertyHolder){
		
		if(null != widgetNode){
			
			Element typeNode = widgetNode.addElement("node-type");
			
			typeNode.addAttribute("type", type);
			
			if( null!= propertyHolder){

				Element validationNode = widgetNode.addElement("node-validation");

				PropertyConstraintsHolder constraintHolder = propertyHolder.getConstraints();
				
				if(null != constraintHolder ){
					
					if(null == constraintHolder.getMaxLength()){
						validationNode.addAttribute("max-length", "10");
					}else {
						validationNode.addAttribute("max-length", constraintHolder.getMaxLength().toString());
					}
					
					if(null == constraintHolder.getInputCaseType()){
						validationNode.addAttribute("case-type", "mixed");
					}else {

						if(StringInputCaseType.MIXEDCASE.equals(constraintHolder.getInputCaseType())){
							validationNode.addAttribute("case-type", "mixed");
						}else if(StringInputCaseType.UPPERCASE.equals(constraintHolder.getInputCaseType())){
							validationNode.addAttribute("case-type", "upper");
						}else if(StringInputCaseType.LOWERCASE.equals(constraintHolder.getInputCaseType())){
							validationNode.addAttribute("case-type", "lower");
						}
					}
					
					if(null == constraintHolder.getTextInputDataType()){
						validationNode.addAttribute("input-type", "alpha-numeric");
					}else{
						if(TextFiledInputDataType.ALPHANUMERIC.equals(constraintHolder.getTextInputDataType())){
							validationNode.addAttribute("input-type", "alpha-numeric");
						}else if(TextFiledInputDataType.ONLYALPHA.equals(constraintHolder.getTextInputDataType())){
							validationNode.addAttribute("input-type", "alpha");
						}else if(TextFiledInputDataType.ONLYNUMBER.equals(constraintHolder.getTextInputDataType())){
							validationNode.addAttribute("input-type", "numeric");
						}
					}
					
					if(null == constraintHolder.getAllowNull()){
						validationNode.addAttribute("allow-null", "true");
					}else{
						if(constraintHolder.getAllowNull()){
							validationNode.addAttribute("allow-null", "true");
						}else{
							validationNode.addAttribute("allow-null", "false");
						}
						
					}
				}else{
					
					validationNode.addAttribute("max-length", "10");
					
					validationNode.addAttribute("case-type", "mixed");
					
					validationNode.addAttribute("input-type", "alpha-numeric");
					
					validationNode.addAttribute("allow-null", "true");
				}
				
			}
		}
	}
	/**
	 * @For staitc panel binding information
	 * @param component
	 * @param propertyName
	 */
	public static void createBindableJComponent(JComponent component, String propertyName){
		
		Map<String, Object> valueMap = new HashMap<String, Object>();
		
		valueMap.put(propertyName, "");
		
		MapValueModel valueModel = new MapValueModel(valueMap, propertyName);
		
		Bindings.bind(component, propertyName, valueModel);
		
	}
	
//	TODO: temp
	public static void createBindableUserDefinedPanel(Map<String, JComponent> compMap, MapValueModel valueModel){
		
	}
	
	/**
	 * 
	 * @param label
	 * @param size
	 * @param valueModel
	 * @return
	 */
	public static JComponent createTextField(UIDomainPropertyHolder propertyHolder , Integer size, MapValueModel valueModel){

		JTextField textField = new JTextField();
		
//		PromptText promptText = new PromptText(propertyHolder.getUiPropertyLabel(), textField);
//		
//		promptText.setForeground( Color.RED );
//		promptText.changeAlpha(0.3f);
//		promptText.changeStyle(Font.BOLD + Font.ITALIC);
		
		if(255 == propertyHolder.getSize() || 0 == propertyHolder.getSize() ){
			textField.setColumns(10);
		}else
			textField.setColumns(propertyHolder.getSize());
		
		PropertyConstraintsHolder constraintHolder = propertyHolder.getConstraints();
		
		if(null != constraintHolder ){
			if(null == constraintHolder.getMaxLength())
				constraintHolder.setMaxLength(propertyHolder.getSize());
			if(null == constraintHolder.getInputCaseType())
				constraintHolder.setInputCaseType(StringInputCaseType.MIXEDCASE);
			if(null == constraintHolder.getTextInputDataType())
				constraintHolder.setTextInputDataType(TextFiledInputDataType.ALPHANUMERIC);
			if(null == constraintHolder.getAllowNull())
				constraintHolder.setAllowNull(new Boolean(true));
		}else{
			
			constraintHolder = new PropertyConstraintsHolder();
			constraintHolder.setMaxLength(propertyHolder.getSize());
			constraintHolder.setInputCaseType(StringInputCaseType.MIXEDCASE);
			constraintHolder.setTextInputDataType(TextFiledInputDataType.ALPHANUMERIC);
			constraintHolder.setAllowNull(new Boolean(true));
		}
		
		textField.setDocument(new TextComponentCaseDocument(constraintHolder));
		
//		ComponentConstraintAssociator.getInstance().associate(textField, propertyHolder, constraintHolder);
		
		MapVetoableValueModelAdaptor vetoableAdapter =
			new MapVetoableValueModelAdaptor(valueModel, textField, constraintHolder);

		Bindings.bind(textField, vetoableAdapter);
		
//		Bindings.bind(textField, valueModel);
		
		return textField;
	}
	
	/**
	 * TODO: have to develop the formats of the JFormatedTextField
	 * @param size
	 * @param valueModel
	 * @return
	 */
	public static JComponent createFormatedTextField(UIDomainPropertyHolder propertyHolder, MapValueModel valueModel){
		
		JFormattedTextField textField = new JFormattedTextField();
		
		textField.setColumns(10);

//		PropertyConstraintsHolder constraintHolder = propertyHolder.getConstraints();
		
//		if(null != constraintHolder ){
//			constraintHolder.setMaxLength(10);
//		}
		
//		MapVetoableValueModelAdaptor vetoableAdapter =
//			new MapVetoableValueModelAdaptor(valueModel, textField, constraintHolder);
//		
		
//		TODO: I have to replace binding by vetoableAdapter. so now valueModel is not going tobe binded
		Bindings.bind(textField, valueModel);

//		Bindings.bind(textField, vetoableAdapter);
		
		return textField;
	}
	
	/**
	 * 
	 * @param echochar
	 * @param valueModel
	 * @return
	 */
	public static JComponent createPasswordField(char echochar, MapValueModel valueModel){
		
		JPasswordField passwordField = new JPasswordField(10);
		
		passwordField.setEchoChar(echochar);
		
		Bindings.bind(passwordField, valueModel);
		
		return passwordField;
	}
	/**
	 * 
	 * @param label
	 * @param colSize
	 * @param rowSize
	 * @param valueModel
	 * @return
	 */
	public static JComponent createTextArea( Integer colSize, Integer rowSize, MapValueModel valueModel){
	
		int columnSize = 40;
		
		int rowwSize = 10;
		
		if(null != colSize)
			columnSize = colSize;
		
		if(null != rowSize)
			rowwSize = rowSize;
		
		JTextArea textArea = new JTextArea(rowwSize, columnSize);
		
		Bindings.bind(textArea, valueModel);
		
		return textArea;
		
	}
	
	/**
	 * 
	 * @param label
	 * @param valueModel
	 * @return
	 */
	public static JComponent createCheckbox(MapValueModel valueModel){
		
		JCheckBox checkBox = new JCheckBox();
		
		Bindings.bind(checkBox, valueModel);
		
		return checkBox;
	}
	
	/**
	 * 
	 * @param propertyHolderList
	 * @param widgetNode
	 * @param type
	 */
	public static void createRadioButtonNode(List<UIDomainPropertyHolder> propertyHolderList, Element widgetNode, String type){
		
		if(null != widgetNode){
			
			Element typeNode = widgetNode.addElement("node-type");
			
			typeNode.addAttribute("type", type);
			
			Element radioBtnNode = typeNode.addElement("radioButton");
			
			int radioPosition = 1;
			
			for(UIDomainPropertyHolder propertyHolder : propertyHolderList){
				
				Element radio = radioBtnNode.addElement("radio");
				
				radio.addAttribute("label", propertyHolder.getUiPropertyLabel());
				
				radio.addAttribute("position", String.valueOf(radioPosition));
				
				radio.addAttribute("choice", propertyHolder.getRadioButtonChoice().toString());
				
				radioPosition++;
			}
		}
	}
	/**
	 * TODO
	 * @param label
	 * @param radioText
	 * @param choice
	 * @param valueModel
	 * @return
	 */
	public static JComponent createRadioButton(List<UIDomainPropertyHolder> propertyHolderList, MapValueModel valueModel){
		
//		JPanel panel = new JPanel();
//		
//		for(UIDomainPropertyHolder propertyHolder : propertyHolderList){
//			
//			panel.add(createRadioButton(propertyHolder, valueModel));
//		}
		
//		return panel;
		
		return new RadioButtonWidget(propertyHolderList, valueModel);
	}
	
	/**
	 * 
	 * @param propertyHolder
	 * @param valueModel
	 * @return
	 */
	public static JComponent createRadioButton(UIDomainPropertyHolder propertyHolder, MapValueModel valueModel){
		
		JRadioButton radioButton = new JRadioButton(propertyHolder.getUiPropertyLabel());
		
		Bindings.bind(radioButton, valueModel, propertyHolder.getRadioButtonChoice());
		
		return radioButton;
	}
	
	/**
	 * 
	 * @param size
	 * @param valueModel
	 * @return
	 */
	public static <T extends Object>JComponent createCombobox(Integer size, MapValueModel valueModel){
		
		JComboBox comboBox = new JComboBox();
		
//		TODO: testing..............
		List<String> list1 = new ArrayList<String>();
		list1.add("First");
		list1.add("Second");
		list1.add("Third");
		list1.add("Fourth");
		
		SelectionInList<?> selectionInList = new SelectionInList(list1, valueModel);
		
		Bindings.bind(comboBox, selectionInList);
		
		return comboBox;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static JComponent createList(){
		
		JList list = new JList();
		
//TODO: have to create selectionInList		
		return list;
	}
	
	/**
	 * 
	 * @param widgetNode
	 * @param type
	 * @param entityClass
	 */
	public static void createTableNode(Element widgetNode, String type, Class entityClass){
		
		if(null != widgetNode){
			
			Element typeNode = widgetNode.addElement("node-type");
			
			typeNode.addAttribute("type", type);

			String clzzName = JavaBeanUtils.getClassName(entityClass);
			
			List<UIDomainPropertyHolder> uiDomainPropertyHolderList = JavaBeanUtils.getBeanIntrospection(entityClass);
			
			Element tableNode = typeNode.addElement("table");
			
			TableWidget tableWidget = new TableWidget();
			
			tableWidget.createTable(uiDomainPropertyHolderList, tableNode);
		}
	}
		
	/**
	 * TODO:
	 * @return
	 */
	public static JComponent createJTable(Class entityClass, List<Map<String, Object>> incomingRowDataMap,
			 Map<String, ArrayListModel<Map<String, Object>>> childTableMap, boolean isEditable){
		
		String clzzName = JavaBeanUtils.getClassName(entityClass);
		
		ArrayListModel<Map<String, Object>> mapArrayList = null;
		
		if( null != childTableMap  && childTableMap.containsKey(entityClass.getName())){
			
			mapArrayList = childTableMap.get(entityClass.getName());
		}
		
		List<UIDomainPropertyHolder> uiDomainPropertyHolderList = JavaBeanUtils.getBeanIntrospection(entityClass);
		
		TableWidget tableWiget = new TableWidget(uiDomainPropertyHolderList, incomingRowDataMap, mapArrayList, isEditable);
		
//		JLabel jLabel = new JLabel(label);

//		return tableWiget.getJTable();
		return tableWiget;
//		return new TestingTableWidget();
	}
	
	/**
	 * 
	 * @param valueModel
	 * @return
	 */
	public static JComponent createDate(String propertyName ,MapValueModel valueModel){
		
		JDateChooser dateChooser = new JDateChooser();
		
		JFormattedTextField dateTextField = (JFormattedTextField) dateChooser.getDateEditor().getUiComponent();
		
		Bindings.bind(dateTextField, valueModel);
		
		
		return dateChooser;
	}
	
	/**
	 * 
	 * @param component
	 * @param valueModel
	 */
	public static void rebindJComponents(JComponent component, MapValueModel valueModel, List<?> objectList,
			Object newValue, Object radioButtonChoice){
	
		
		if(component instanceof JComboBox){

			valueModel.setValue(null);
			
			valueModel.setDirty(false);
			
			JComboBox comboBox =(JComboBox) component;
			
			SelectionInList<?> selectionInList = new SelectionInList(objectList, valueModel);
			
			Bindings.bind(comboBox, selectionInList);
			
		} else {
			
			rebindJTextComponent(component, valueModel, newValue, radioButtonChoice);
		}
		
	}
	
	/**
	 * 
	 * @param component
	 * @param valueModel
	 * @param newValue
	 */
	public static void rebindJTextComponent(JComponent component, MapValueModel valueModel, 
			Object newValue, Object radioButtonChoice){
		
		valueModel.setValue(newValue);
		
		if(component instanceof JTextField){
			
			JTextField textField = (JTextField) component;
			
			Bindings.bind(textField, valueModel);
			
		} else if(component instanceof JCheckBox){
			
			JCheckBox checkBox =(JCheckBox) component;
			
			Bindings.bind(checkBox, valueModel);
			
		} else if(component instanceof JTextArea){
			
			JTextArea textArea =(JTextArea) component;
			
			Bindings.bind(textArea, valueModel);
			
		} else if(component instanceof JFormattedTextField){
			
			JFormattedTextField textField =(JFormattedTextField) component;
			
			Bindings.bind(textField, valueModel);
			
		} else if(component instanceof JPasswordField){
			
			Bindings.bind((JPasswordField)component, valueModel);
			
		} else if(component instanceof JRadioButton){
			
			Bindings.bind((JRadioButton)component,valueModel, radioButtonChoice);
		}
	}

	
	/**
	 * 
	 * @author Anees
	 *
	 */
	private static class TextComponentCaseDocument extends PlainDocument{
		
		private PropertyConstraintsHolder constraintHolder;
		
		public TextComponentCaseDocument(final PropertyConstraintsHolder constraintHolder){
			
			this.constraintHolder = constraintHolder;
		}

		@Override
	    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
	    	
			if(StringInputCaseType.UPPERCASE.equals(constraintHolder.getInputCaseType())){
				
				super.insertString(offs, str.toUpperCase(), a);
				
			}else if(StringInputCaseType.LOWERCASE.equals(constraintHolder.getInputCaseType())){
				
				super.insertString(offs, str.toLowerCase(), a);
				
			}else {
				
				super.insertString(offs, str, a);
			}
	    }
	}
		


}