/**
 * 
 */
package com.eagle.coders.swing.core.ui.controller.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JPopupMenu.Separator;

import com.eagle.coders.swing.core.ui.cache.UIDomainPropertyHolder;
import com.eagle.coders.swing.core.ui.interfaces.IUiComponent;
//import com.eaglescoders.userprofile.ejb.domain.UserRolesDomain;


/**
 * @author Anees
 *
 */
public class JavaBeanUtils {
	
	public static void lookup(){
		
	}
	
	/**
	 * 
	 * @param bean
	 */
	public static Map<String, Class<?>> getPropertiesOfBean(Class<? extends Object> bean){
		
		Field fields[] = bean.getDeclaredFields();

		List<String> propertyList = new ArrayList<String>();
		
		Map<String, Class<?>> propertyReturnTypeMap = new HashMap<String, Class<?>>();
		
		for(Field field : fields){
			
			if(!field.getName().equals("serialVersionUID")){
			
//				propertyList.add(field.getName());
				
				propertyReturnTypeMap.put(field.getName(), field.getType());
			}
		}
		
		return propertyReturnTypeMap;
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static String getClassName(Class<? extends Object> c) {
		 
		 String fQClassName = c.getName();
		 
		 int firstChar;
		 
		 firstChar = fQClassName.lastIndexOf ('.') + 1;
		 
		 if ( firstChar > 0 ) {
		 
			 fQClassName = fQClassName.substring ( firstChar );
		    
		 }
		 
		 return fQClassName;
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static List<UIDomainPropertyHolder> getBeanIntrospection(Class<? extends Object> c) {
		try {
			
			Method[] methods = c.getDeclaredMethods();
			
			Field[] fields = c.getDeclaredFields();
			
			return processMethods(methods, fields);
			
			
		} catch(Exception e){
			e.printStackTrace();
			
			return new ArrayList<UIDomainPropertyHolder>();
		}
	}
	
	/**
	 * 
	 * @param clazz
	 * @return
	 */
	public static List<UIDomainPropertyHolder> processClazz(Class<?> clazz){
		
		return processMethods(clazz.getDeclaredMethods(), clazz.getDeclaredFields());
	}

	
	/**
	 * 
	 * @param methods
	 * @return
	 */
	public static List<UIDomainPropertyHolder> processMethods(Method methods[], Field fields[]){
		
		List<UIDomainPropertyHolder> holder = new ArrayList<UIDomainPropertyHolder>();
		
		for(Method method : methods){
		
			String name = method.getName();
			
			Class<?> returnType = method.getReturnType();
			
			if(name.startsWith("get")){
				
				String propertyName = getPropertyFromMethod(name);
				
				boolean flag = compareFieldAndMethod(propertyName, fields);
				
				if(true){

					Annotation annotations[] = method.getAnnotations();
					
					UIDomainPropertyHolder propertyHolder =
						AnnotationProcessingUtils.processAnnotation(annotations, propertyName, method);
					
					propertyHolder.setPropertyReturnType(returnType);
					
//					holder.add(AnnotationProcessingUtils.processAnnotation(annotations, propertyName, method));
					
					holder.add(propertyHolder);
				}
			}
		}
		
		return holder;
	}
	
	public static String getPropertyFromMethod(String name){
		
		String orginalName = name.substring(3, name.length());
		
		String propertyName = 
			orginalName.replaceFirst(orginalName.substring(0,1), orginalName.substring(0,1).toLowerCase());
		
		return propertyName;

	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	private static String processMethodNameForLabel(String name){
		
		String propertyName = "";
		
		if(name.startsWith("get")){
			
			String orginalName = name.substring(3, name.length());
			
			propertyName = 
				orginalName.replaceFirst(orginalName.substring(0,1), orginalName.substring(0,1).toLowerCase());
		}
		
		return propertyName;
	}
	
	/**
	 * 
	 * @param processingClazz
	 * @return
	 */
	public static Map<Class<?>, Class<?>> processForMethodRelationshipAnnotation(Class<? extends Object> processingClazz){
		
		Map<String, Class<?>> propertyNameRelationshipMap = new HashMap<String, Class<?>>();
		
		Map<Class<?>, Class<?>> retrnTypeRelationshipMap = new HashMap<Class<?>, Class<?>>();
		
		Method methods[] = processingClazz.getDeclaredMethods();
		
		for(Method method : methods){
			
			if(method.isAnnotationPresent(OneToMany.class)){
				
				propertyNameRelationshipMap.put(processMethodNameForLabel(method.getName()), OneToMany.class);
				
				retrnTypeRelationshipMap.put(method.getReturnType(), OneToMany.class);
				
			} else if(method.isAnnotationPresent(OneToOne.class)){
				
				propertyNameRelationshipMap.put(processMethodNameForLabel(method.getName()), OneToOne.class);
				
				retrnTypeRelationshipMap.put(method.getReturnType(), OneToOne.class);
				
			}
		}
		
		return retrnTypeRelationshipMap;
	}

	/**
	 * 
	 * @param fieldName
	 * @param fields
	 * @return
	 */
	private static boolean compareFieldAndMethod(String fieldName, Field fields[]){
		
		boolean flag = false;
		
		for(Field field : fields){

			if(fieldName.equals(field.getName())){
				
				flag = true;
			}
		}
		
		return flag;
	}
	
	/**
	 * 
	 * @param uiClazz
	 * @return
	 */
	public static void processUserDefinedPresentation(Class<? extends IUiComponent> uiClazz,
			UIDomainPropertyHolder propertiesHolder){
		try{
			
			IUiComponent comp = uiClazz.newInstance();
			
			propertiesHolder.setUserPanel(comp.getJPanel());
			
			propertiesHolder.setUserPanelPropertyComponentMap(comp.getBindableComponents());
			
			propertiesHolder.setUserPanelLabel(comp.getPanelName());
			
		}catch(Exception e){
			
//			do nothing
		}
	}
	
	/**
	 * 
	 * @param method
	 * @return
	 */
	public static String getLabelNameFromMethod(Method method){
	
		String name = method.getName().substring(3, method.getName().length());
		
		String pName = 
			name.replaceFirst(name.substring(0,1), name.substring(0,1).toUpperCase());
		
		return pName;
	}

	
}
