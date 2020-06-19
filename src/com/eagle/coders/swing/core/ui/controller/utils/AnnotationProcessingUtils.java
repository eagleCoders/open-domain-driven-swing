/**
 * 
 */
package com.eagle.coders.swing.core.ui.controller.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.print.attribute.HashAttributeSet;

import com.eagle.coders.swing.core.ui.annotations.DataSource;
import com.eagle.coders.swing.core.ui.annotations.DomainTitle;
import com.eagle.coders.swing.core.ui.annotations.RadioButton;
import com.eagle.coders.swing.core.ui.annotations.RadioButtons;
import com.eagle.coders.swing.core.ui.annotations.StaticPresentation;
import com.eagle.coders.swing.core.ui.annotations.TextArea;
import com.eagle.coders.swing.core.ui.annotations.UIBindingComponent;
import com.eagle.coders.swing.core.ui.annotations.UIComponentInterbinding;
import com.eagle.coders.swing.core.ui.annotations.UiComponentPosition;
import com.eagle.coders.swing.core.ui.annotations.UnBound;
import com.eagle.coders.swing.core.ui.annotations.type.NullConstraintType;
import com.eagle.coders.swing.core.ui.annotations.type.StringInputCaseType;
import com.eagle.coders.swing.core.ui.annotations.type.TextFiledInputDataType;
import com.eagle.coders.swing.core.ui.annotations.type.UIComponentType;
import com.eagle.coders.swing.core.ui.cache.UIDomainPropertyHolder;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.ActionRequest;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.IAction;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.Button;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;
import com.eagle.coders.swing.core.ui.interfaces.IButton;
import com.eagle.coders.swing.core.ui.interfaces.IUiComponent;
import com.eagle.coders.swing.core.ui.validation.PropertyConstraintsHolder;
import com.eagle.coders.swing.core.ui.validation.annotations.PropertyConstraints;

/**
 * @author Anees
 *
 */
public class AnnotationProcessingUtils {
	
	
	/**
	 * 
	 * @param annotations
	 * @param propertyName
	 */
	public static UIDomainPropertyHolder processAnnotation(Annotation annotations[], String propertyName, Method method){
		
		UIDomainPropertyHolder propertiesHolder = new UIDomainPropertyHolder();
		

		if(!method.isAnnotationPresent(UnBound.class)){
			
			propertiesHolder.setDomainProperty(propertyName);
			
/*			FOR CONSTRAINTs  				*/
			if(method.isAnnotationPresent(PropertyConstraints.class) || method.isAnnotationPresent(Id.class)){
				
				Boolean isMadatory = true;

				method.getAnnotation(PropertyConstraints.class);
				
				processForConstraints(method.getAnnotation(PropertyConstraints.class), isMadatory, propertiesHolder, method);
				
			}
			
			for(Annotation annotation : annotations){

				if(method.isAnnotationPresent(UIBindingComponent.class) || method.isAnnotationPresent(RadioButtons.class) ||
						method.isAnnotationPresent(RadioButton.class) || method.isAnnotationPresent(TextArea.class)){

					if(annotation instanceof UIBindingComponent){
						
						UIBindingComponent bindingComponent = (UIBindingComponent) annotation;

						AnnotationProcessingUtils.processUIBindingComponent(bindingComponent, propertiesHolder);
					}
					if(annotation instanceof RadioButtons || annotation instanceof RadioButton){
						
						String pName =
							getLabelNameFromMethod(method);
						
						propertiesHolder.setUiPropertyLabel(pName);
						
						AnnotationProcessingUtils.processingRadioButonAnnotation(annotation, propertiesHolder);
					} 
					if(annotation instanceof TextArea){
						
						String name =
							getLabelNameFromMethod(method);

						propertiesHolder.setUiPropertyLabel(name);
						
						propertiesHolder.setUiProperty(name);

						propertiesHolder.setUiPropertyType(UIComponentType.COMPONENT_TEXTAREA.getValue());
					}
					
				} else {
					
					String pName =
						getLabelNameFromMethod(method);
						
					AnnotationProcessingUtils.processByReturnType(method.getReturnType(), propertiesHolder, pName);

				}
				if ( annotation instanceof UIComponentInterbinding){
					
					UIComponentInterbinding interCompBinding = (UIComponentInterbinding) annotation;

					AnnotationProcessingUtils.processUIComponentInterbinding(interCompBinding, propertiesHolder);
				}
				if (annotation instanceof Column){
					
					Column column = (Column) annotation;
					
					AnnotationProcessingUtils.processColumn(column, propertiesHolder);
				}
				if( annotation instanceof OneToMany){
					
					OneToMany oneToManyRelation = (OneToMany) annotation;
					
					AnnotationProcessingUtils.processOneToMany(oneToManyRelation, propertiesHolder, method);
				}
				if(annotation instanceof ManyToOne){
					
					ManyToOne manyToOneRelation = (ManyToOne) annotation;
					
					AnnotationProcessingUtils.processManyToOne(manyToOneRelation, propertiesHolder, method);
				}
				if(annotation instanceof OneToOne){
					
					OneToOne oneToOneRelation = (OneToOne) annotation;
					
					AnnotationProcessingUtils.processOneToOne(oneToOneRelation, propertiesHolder, method);
				}
				if(annotation instanceof ManyToMany){
					
					ManyToMany manyToManyRelation = (ManyToMany) annotation;
					
					AnnotationProcessingUtils.processManyToMany(manyToManyRelation, propertiesHolder, method);
				}
				if(annotation instanceof UiComponentPosition){
					
					UiComponentPosition compPosition = (UiComponentPosition) annotation;
					
					AnnotationProcessingUtils.processUiComponentPosition(compPosition, propertiesHolder);
				}
				if(annotation instanceof StaticPresentation){
					
					StaticPresentation userPresentation =(StaticPresentation) annotation;
					
					AnnotationProcessingUtils.processingStaticPresentationAnnotation(userPresentation, propertiesHolder);
				}
				if(annotation instanceof Transient){
					
					propertiesHolder.setQuerable(false);
				}
				if(annotation instanceof DataSource){
					
					
				}
				
			}
			
		}
		
		return propertiesHolder;
	}
	
	
	/**
	 * 
	 * @param constrraint
	 * @param id
	 * @param propertiesHolder
	 */
	private static void processForConstraints(PropertyConstraints constrraint,Boolean isMadatory ,
			UIDomainPropertyHolder propertiesHolder, Method method ){
		
		PropertyConstraintsHolder holder = new PropertyConstraintsHolder();
		
		TextFiledInputDataType dataType = null;
		
		StringInputCaseType inputCaseType = null;
		
		if(isMadatory){
			
			holder.setIsMadatory(isMadatory);
			
			holder.setAllowNull(false);
		}
		
		if(null != constrraint){
			
			if(constrraint.allowNull().equals(NullConstraintType.NOTALLOWED)){
				holder.setAllowNull(false);
			}
			
			dataType = constrraint.textInputDataType();
			
			inputCaseType = constrraint.inputCaseType();
			
			if(!"".equals(constrraint.minLength()))
				holder.setMinLength(Integer.parseInt(constrraint.minLength()));
			if(!"".equals(constrraint.maxLength()))
				holder.setMaxLength(Integer.parseInt(constrraint.maxLength()));
			
			holder.setPatternForValidate(constrraint.pattern());
			
		}
		
		processConstraintDateType(method, holder, dataType, inputCaseType);
		
		propertiesHolder.setConstraints(holder);
	}

	/**
	 * 
	 * @param method
	 * @param holder
	 * @param dataType
	 * @param inputCaseType
	 */
	private static void processConstraintDateType(Method method, PropertyConstraintsHolder holder, 
			TextFiledInputDataType dataType, StringInputCaseType inputCaseType){
		
		if(method.getReturnType().equals(String.class)){
			
			if(null != dataType && null != inputCaseType){
				
				holder.setTextInputDataType(dataType);
				
				holder.setInputCaseType(inputCaseType);
				
			}else {
				
				holder.setTextInputDataType(TextFiledInputDataType.ALPHANUMERIC);
				
				holder.setInputCaseType(StringInputCaseType.MIXEDCASE);
			}
			
		}else if(method.getReturnType().equals(Integer.class)){
			
			holder.setTextInputDataType(TextFiledInputDataType.ONLYNUMBER);
			
		}else if(method.getReturnType().equals(BigDecimal.class)){
			
			holder.setTextInputDataType(TextFiledInputDataType.NUMBER_WITH_PRECSION);
			
		}else if(method.getReturnType().equals(Float.class)){

			holder.setTextInputDataType(TextFiledInputDataType.NUMBER_WITH_PRECSION);
			
		}else if(method.getReturnType().equals(Date.class)){
		
			holder.setTextInputDataType(TextFiledInputDataType.ALPHANUMERIC);

		}
	}
	/**
	 * 
	 * @param annotation
	 * @param propertiesHolder
	 */
	private static void processingStaticPresentationAnnotation(StaticPresentation annotation, UIDomainPropertyHolder propertiesHolder){
		
		propertiesHolder.setUiPropertyType(UIComponentType.COMPNENT_PANEL.getValue());
		
		propertiesHolder.setUserPanelDisplayPolicy(annotation.presentationPolicy());
		
		JavaBeanUtils.processUserDefinedPresentation(annotation.userPanel(), propertiesHolder);
		
	}
	
	/**
	 * 
	 * @param method
	 * @return
	 */
	private static String getLabelNameFromMethod(Method method){
	
		String name = method.getName().substring(3, method.getName().length());
		
		String pName = 
			name.replaceFirst(name.substring(0,1), name.substring(0,1).toUpperCase());
		
		return pName;
	}
	
	/**
	 * 
	 * @param annotation
	 */
	public static void processingRadioButonAnnotation(Annotation annotation, UIDomainPropertyHolder propertiesHolder){
		
		propertiesHolder.setUiPropertyType(UIComponentType.COMPNENT_RADIOBUTTON.getValue());
		
		if(annotation instanceof RadioButtons){
			
			RadioButtons radioButtons =(RadioButtons) annotation;
			
			RadioButton[] radioButton =radioButtons.values();
			
			processRadioButtonArray(radioButton, propertiesHolder );
			
		}else if (annotation instanceof RadioButton){
			
			List<UIDomainPropertyHolder> radioButtonHolder = new ArrayList<UIDomainPropertyHolder>();
			
			RadioButton radioButton =(RadioButton) annotation;
			
			processRadioButton(radioButton, radioButtonHolder);
			
			propertiesHolder.setDomainPropertyHolderList(radioButtonHolder);
		}
		
	}
	
	/**
	 * 
	 * @param radioButton
	 * @param propertiesHolder
	 */
	private static void processRadioButtonArray(RadioButton[] radioButton, UIDomainPropertyHolder propertiesHolder){
		
		List<UIDomainPropertyHolder> radioButtonHolder = new ArrayList<UIDomainPropertyHolder>();
		
		for(RadioButton radioBtn : radioButton){
			
			processRadioButton(radioBtn, radioButtonHolder);
		}
		
		propertiesHolder.setDomainPropertyHolderList(radioButtonHolder);
	}
	
	/**
	 * 
	 * @param radioButton
	 */
	private static void processRadioButton(RadioButton radioButton, List<UIDomainPropertyHolder> radioButtonHolder){
		
		UIDomainPropertyHolder holder = new UIDomainPropertyHolder();
		
		holder.setUiPropertyType(UIComponentType.COMPNENT_RADIOBUTTON.getValue());
		
		holder.setUiPropertyLabel(radioButton.label());
		
		holder.setRadioButtonChoice(radioButton.choice());
		
		radioButtonHolder.add(holder);
	}
	
	/**
	 * 
	 * @param returnType
	 * @param propertyHolder
	 */
	public static void processByReturnType(Class<?> returnType, UIDomainPropertyHolder propertiesHolder, String name){

		propertiesHolder.setUiPropertyLabel(name);
		
		propertiesHolder.setUiProperty(name);
		
		if(returnType.equals(String.class)){
			
			propertiesHolder.setUiPropertyType(UIComponentType.COMPNENT_TEXTFIELD.getValue());
			
		} else if(returnType.equals(Integer.class)){
			
			propertiesHolder.setUiPropertyType(UIComponentType.COMPONENT_FMT_TXT.getValue());
			
		} else if (returnType.equals(Boolean.class)) {
			
			propertiesHolder.setUiPropertyType(UIComponentType.COMPONENT_CHECKBOX.getValue());
			
		} else if (returnType.equals(Date.class)){
			
			propertiesHolder.setUiPropertyType(UIComponentType.COMPONENT_DATE.getValue());
			
		} 
//		else if( returnType.equals(IUiComponent.class)){
//			
//			propertiesHolder.setUiPropertyLabel(null);
//			
//			propertiesHolder.setUiProperty(null);
//			
//			propertiesHolder.setUiPropertyType(UIComponentType.COMPNENT_PANEL.getValue());
//		}

	}
	
	/**
	 * 
	 * @param propertiesHolder
	 */
	public static void processUIBindingComponent(UIBindingComponent bindingComponent,
			UIDomainPropertyHolder propertiesHolder){
		
		propertiesHolder.setUiProperty(bindingComponent.property());
		
		propertiesHolder.setUiPropertyType(bindingComponent.type());
		
		propertiesHolder.setUiPropertyLabel(bindingComponent.label());
		
		propertiesHolder.setUiPositionRow(Integer.parseInt(bindingComponent.row()));
		
		propertiesHolder.setUiPositionColumn(bindingComponent.column());
		
		if(!bindingComponent.tableDisplayColumn().equals("-1")){
			
			propertiesHolder.setTableDisplayPosition(Integer.parseInt(bindingComponent.tableDisplayColumn()));
		}

	}
	
	/**
	 * 
	 * @param propertiesHolder
	 */
	public static void processUIComponentInterbinding(UIComponentInterbinding interCompBinding,
			UIDomainPropertyHolder propertiesHolder){
		
		propertiesHolder.setDependentProperty(interCompBinding.childProperty());
		
		propertiesHolder.setParentProperty(interCompBinding.parentProperty());
		
	}
	
	/**
	 * 
	 * @param compPosition
	 * @param propertiesHolder
	 */
	public static void processUiComponentPosition(UiComponentPosition compPosition,
			UIDomainPropertyHolder propertiesHolder){
		
		if(null == propertiesHolder.getUiPositionRow())
			propertiesHolder.setUiPositionRow(Integer.parseInt(compPosition.positionRow()));
		
		if(null == propertiesHolder.getUiPositionColumn())
			propertiesHolder.setUiPositionColumn(compPosition.positionColumn());

		if(!compPosition.tableDisplayColumn().equals("-1")){
			
			propertiesHolder.setTableDisplayPosition(Integer.parseInt(compPosition.tableDisplayColumn()));
		}
	}
	
	/**
	 * 
	 * @param propertiesHolder
	 */
	public static void processColumn(Column column, UIDomainPropertyHolder propertiesHolder){
		
		propertiesHolder.setSize(column.length());

	}
	
	/**
	 * 
	 * @param propertiesHolder
	 */
	public static void processOneToMany(OneToMany oneToManyRelation, UIDomainPropertyHolder propertiesHolder, Method method){
		
		String name = JavaBeanUtils.getClassName(oneToManyRelation.targetEntity());
		
		if(null != name){

			propertiesHolder.setRelationshipClassProperty(oneToManyRelation.targetEntity());

		}else {
			
			name = JavaBeanUtils.getClassName(method.getReturnType());
			
			propertiesHolder.setRelationshipClassProperty(method.getReturnType());

		}
		
		propertiesHolder.setUiPropertyLabel(name);
		
		if(null == propertiesHolder.getUiPropertyType() ){
			
			propertiesHolder.setUiPropertyType(UIComponentType.COMPNENT_TABLE.getValue());
		}
	}
	
	/**
	 * 
	 * @param propertiesHolder
	 */
	public static void processManyToOne(ManyToOne manyToOneRelation, UIDomainPropertyHolder propertiesHolder, Method method){
		
		String name = JavaBeanUtils.getClassName(manyToOneRelation.targetEntity());

		if(null != name){

			propertiesHolder.setRelationshipClassProperty(manyToOneRelation.targetEntity());

		}else {
			
			name = JavaBeanUtils.getClassName(method.getReturnType());
			
			propertiesHolder.setRelationshipClassProperty(method.getReturnType());

		}

		propertiesHolder.setUiPropertyLabel(name);
		
		if(null == propertiesHolder.getUiPropertyType()){
			
			propertiesHolder.setUiPropertyType(UIComponentType.COMPNENT_COMBOBOX.getValue());
		}

	}
	
	/**
	 * 
	 * @param processingClazz
	 */
	public static void processForInterdependencyOfComponent(Class<? extends Object> processingClazz){
		
		Map<Class<?>, Class<?>> retrnTypeRelationshipMap = 
			JavaBeanUtils.processForMethodRelationshipAnnotation(processingClazz);
	}
	
	/**
	 * 
	 * @param propertiesHolder
	 */
	public static void processOneToOne(OneToOne oneToOneRelation, UIDomainPropertyHolder propertiesHolder, Method method){
		
		String name = JavaBeanUtils.getClassName(oneToOneRelation.targetEntity());

		if(null != name ){
			
			propertiesHolder.setRelationshipClassProperty(oneToOneRelation.targetEntity());
			
		}else {

			name = JavaBeanUtils.getClassName(method.getReturnType());

			propertiesHolder.setRelationshipClassProperty(method.getReturnType());
		}
		
		propertiesHolder.setUiPropertyLabel(name);
		
		if(null == propertiesHolder.getUiPropertyType()){
			
			propertiesHolder.setUiPropertyType(UIComponentType.COMPNENT_TEXTFIELD.getValue());
		}

	}
	
	/**
	 * 
	 * @param propertiesHolder
	 */
	public static void processManyToMany(ManyToMany manyToManyRelation ,UIDomainPropertyHolder propertiesHolder, Method method){
		
		String name = JavaBeanUtils.getClassName(manyToManyRelation.targetEntity());
		
		if(null != name ){
		
			propertiesHolder.setRelationshipClassProperty(manyToManyRelation.targetEntity());
			
		} else{

			name = JavaBeanUtils.getClassName(method.getReturnType());

			propertiesHolder.setRelationshipClassProperty(method.getReturnType());
		}
		
		propertiesHolder.setUiPropertyLabel(name);

		if(null == propertiesHolder.getUiPropertyType()){
			
			propertiesHolder.setUiPropertyType(UIComponentType.COMPNENT_TABLE.getValue());
		}

	}
	
	/**
	 * @return IAction
	 * @param button
	 */
	public static Map<ActionTypes, IAction> processExecutablenButton(IButton button){
		
		IAction iAction = null;
		
		Map<ActionTypes, IAction> buttonTypeActionMap = new HashMap<ActionTypes, IAction>();
		
		if(button.getCurrentObject().getClass().isAnnotationPresent(Button.class)){
			
			Button btn = button.getClass().getAnnotation(Button.class);
			
			Class<? extends IAction> action = btn.action();
			
			try{
				
				iAction = action.newInstance();
			}catch(IllegalAccessException iie){
				
				iAction = null;
			}catch(InstantiationException ine){
				
				iAction = null;
			}
			
			ActionTypes btnTypes = btn.buttonType();
			
			buttonTypeActionMap.put(btnTypes, iAction);
		}

		
		return buttonTypeActionMap;
	}
	
	/**
	 * 
	 * @param clazz
	 * @return
	 */
	public static String processDomainTitle(Class<?> clazz){
		
		String titleName = "";
		
		if(clazz.isAnnotationPresent(DomainTitle.class)){
			
			DomainTitle domainTitle = clazz.getAnnotation(DomainTitle.class);
			
			titleName= domainTitle.title();
		}
		return titleName;
	}
	
	
}
