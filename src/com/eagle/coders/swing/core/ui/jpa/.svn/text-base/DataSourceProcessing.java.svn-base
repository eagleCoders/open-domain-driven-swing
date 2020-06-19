package com.eagle.coders.swing.core.ui.jpa;

import com.eagle.coders.swing.core.ui.annotations.DataSource;
import com.eagle.coders.swing.core.ui.annotations.type.DataSourceType;

/**
 * 
 * @author Anees
 *
 */
public class DataSourceProcessing {
	
	public static void processDataSource(DataSource dataSource){
		
		processEnumDataType(dataSource);
		
		processDBDataType(dataSource);
		
		processEntityDataType(dataSource);
		
	}
	
	/**
	 * 
	 * @param dataSource
	 */
	private static void processEnumDataType(DataSource dataSource){
		
		if(DataSourceType.ENUM.equals(dataSource.dataSourceType())){
			
			Class<? extends Object> entity = dataSource.entity();
			
			if(entity.isEnum()){
				
				Object[] objectArray = entity.getEnumConstants();
				
//				TODO: have to process the objects for methods and then execute those method
			}
			
		}
	}
	
	/**
	 * 
	 * @param dataSource
	 */
	private static void processDBDataType(DataSource dataSource){
		
		if(DataSourceType.DB.equals(dataSource.dataSourceType())){
			
		}
	}
	
	/**
	 * 
	 * @param dataSource
	 */
	private static void processEntityDataType(DataSource dataSource){
		
		if(DataSourceType.ENTITY.equals(dataSource.dataSourceType())){
			
		}
	}
	
	

}
