/**
 * 
 */
package com.eagle.coders.swing.core.ui.bindings;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.eagle.coders.swing.core.ui.controller.utils.JavaBeanUtils;
import com.jgoodies.binding.list.ArrayListModel;

/**
 * @author Anees
 * 
 */
public class BeanMapUtils {

	/**
	 * 
	 * @param beanFrom
	 * @return
	 */
	public static Map<String, Object> bean2MapConverter(Object beanFrom) {

		Map<String, Object> beanValueMap = new HashMap<String, Object>();

		Class<? extends Object> beanClazz = beanFrom.getClass();

		Method[] methods = beanClazz.getDeclaredMethods();

		for (Method method : methods) {

			String name = method.getName();

			if (name.startsWith("get")) {

				String propertyName = JavaBeanUtils
						.getLabelNameFromMethod(method);

				try {
					Object rslt = method.invoke(beanFrom, null);

					if (null != rslt) {
						beanValueMap.put(propertyName, rslt);
					}

				} catch (Exception e) {
					e.printStackTrace();
					beanValueMap.put(propertyName, null);
				}
			}
		}

		return beanValueMap;
	}

	/**
	 * 
	 * @param mapTo
	 * @param mapFrom
	 */
	public static void map2MapConverter(Map<String, Object> mapTo,
			Map<String, Object> mapFrom) {

		Set<String> keySet = mapFrom.keySet();

		for (String key : keySet) {
			String pName = key.replaceFirst(key.substring(0, 1), key.substring(
					0, 1).toLowerCase());

			mapTo.put(pName, mapFrom.get(key));

		}
	}

	/**
	 * 
	 * @param objTo
	 * @param mapFrom
	 */
	public static void map2BeanConverter(Object objTo,
			Map<String, Object> mapFrom,
			Map<String, ArrayListModel<Map<String, Object>>> childTableDataMap) {

		Class<? extends Object> beanClazz = objTo.getClass();

		Method[] methods = beanClazz.getDeclaredMethods();
		try {
			for (Method method : methods) {

				String name = method.getName();

				if (name.startsWith("set")) {

					String propertyName = JavaBeanUtils
							.getPropertyFromMethod(name);

					String pName = name.replaceFirst(propertyName.substring(0,
							1), propertyName.substring(0, 1).toUpperCase());

					// //For OneToMany and ManyToMany methods
					Type gParamter = method.getGenericParameterTypes()[0];

					if (gParamter instanceof ParameterizedType) {

						ParameterizedType aType = (ParameterizedType) gParamter;

						Type parameterArgType = aType.getActualTypeArguments()[0];

						Class<?> parameterArgClass = (Class<?>) parameterArgType;

						String paramClazzName = parameterArgClass.getName();

						Class clzz = Class.forName(paramClazzName);
						
						Object object = clzz.newInstance();
						
						List<Object> list = new ArrayList<Object>();

						if (null != childTableDataMap
								&& childTableDataMap
										.containsKey(parameterArgClass
												.getName())) {

							ArrayListModel<Map<String, Object>> relationShipDataLsit = childTableDataMap.get(parameterArgClass.getName());

							int listSize = relationShipDataLsit.getSize();

							for (int i = 0; i < listSize; i++) {

								Map<String, Object> dataMap = relationShipDataLsit
										.get(i);

								Iterator<String> names = dataMap.keySet()
										.iterator();

								Map<String, Object> dataToProcedd = new HashMap<String, Object>();

								while (names.hasNext()) {

									String tPName = names.next();

									Object data = dataMap.get(tPName);

									dataToProcedd.put(tPName.replaceFirst(tPName.substring(0, 1),tPName.substring(0, 1).toLowerCase()), data);
									
								}
//								Object gObject= clzz.newInstance();
//								map2BeanConverter(gObject, dataToProcedd, null);
								
								map2BeanConverter(clzz, dataToProcedd, list);
//								list.add(gObject);
							}
						}
						mapFrom.put(propertyName, list);
						
						System.out.println("[mapFrom] :: "+ mapFrom);
					}
					if (mapFrom.containsKey(propertyName)) {
						Object obj = mapFrom.get(propertyName);
						if(null != obj){
							try {
								method.invoke(objTo, new Object[] { obj });
								
							} catch (Exception e) {	
								// Do Nothing just set object to null because it is
								// reflection exception
								// we cannot take the risk of un desired data
//								e.printStackTrace();
//								objTo = null;
							}
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param clazzTo
	 * @param mapFrom
	 * @return
	 */
	private static void map2BeanConverter(Class clazzTo,
			Map<String, Object> mapFrom, List<Object> list) throws Exception {

		Object object = clazzTo.newInstance();;
		
		Method[] methods = clazzTo.getDeclaredMethods();

		for (Method method : methods) {

			String name = method.getName();

			if (name.startsWith("set")) {

				String propertyName = JavaBeanUtils.getPropertyFromMethod(name);

				if (mapFrom.containsKey(propertyName)) {
				
					Object obj = mapFrom.get(propertyName);
					
					try {
						 
						 if(null != obj){
							method.invoke(object, new Object[]{obj});
						 }

					} catch (Exception e) {
						// Do Nothing just set object to null because it is
						// reflection exception
						// we cannot take the rist of un desired data
						e.printStackTrace();
//						 object = null;
					}

				}
			}
			
		}
		list.add(object);
	}
}