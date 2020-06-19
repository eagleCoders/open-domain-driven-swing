/**
 * 
 */
package com.eagle.coders.swing.core.ui.jpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Anees
 *
 */
public class DynamicJPAQueryGenerator {

	private static List<String> allowedAliases = new ArrayList<String>();
	
	private static List<String> reservedAliases = new ArrayList<String>();
	
	static {
	
		allowedAliases.add("o");
		allowedAliases.add("t");
		allowedAliases.add("u");
		allowedAliases.add("v");
		allowedAliases.add("x");
		allowedAliases.add("y");
		allowedAliases.add("z");
		
	}
	
	/**
	 * 
	 * @param domainName
	 * @param propertiesNValues
	 * @return
	 */
	public static String createQuery(String domainName, Map<String, Object> propertiesValuesMap,
			Map<String, Class<?>> propertyReturnTypeMap){
		
		String emptySpace = " ";
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("from");
		
		builder.append(emptySpace);

		String alias = getAlias(0);

		builder.append(domainName+" "+alias);
		
		builder.append(emptySpace);
		
		builder.append("where");

		builder.append(emptySpace);

		Set<String> propertiesSet = propertiesValuesMap.keySet();
		
		int i = 1;
		
		for(String property : propertiesSet){
			
//			builder.append(domainName+"."+property+"= :"+property);
			
			if(propertyReturnTypeMap.containsKey(property)){
				
				builder.append(alias+"."+property+" = :"+property);
				
				if(i < propertiesSet.size())
					builder.append(" and ");
				
				Class<?> retrnClazz = propertyReturnTypeMap.get(property);
				
				if(retrnClazz.equals(String.class) ||
				   retrnClazz.equals(Integer.class)||
				   retrnClazz.equals(BigDecimal.class)||
				   retrnClazz.equals(Date.class)||
				   retrnClazz.equals(Short.class)){
					
				}
			}
			
			i++;
		}
		
		return builder.toString();
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	private static String getAlias(int index){
		
		
		String alias = null;
		
		if(!reservedAliases.contains(allowedAliases.get(index))){
			
			alias = allowedAliases.get(index);
			
		} else{
			getAlias(index++);
		}
		
		return alias;
	}
}
