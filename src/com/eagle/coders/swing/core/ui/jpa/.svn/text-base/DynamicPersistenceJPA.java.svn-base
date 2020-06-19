/**
 * 
 */
package com.eagle.coders.swing.core.ui.jpa;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;

import org.hibernate.ejb.HibernatePersistence;
import org.hibernate.ejb.packaging.PersistenceMetadata;

/**
 * @author Anees
 *
 */
public class DynamicPersistenceJPA {
	
	private static final String PERSISTENCE_UNIT = "ddSwingPersistence";
	
	private static final String JTA_RESOURCE = "RESOURCE_LOCAL";
	
	private List<String> classesName;
	
	private PersistenceMetadata metadata ;
	
	private EagleCodersPersistenceInfo eagleCodersPersistence;
	
	public DynamicPersistenceJPA(EagleCodersPersistenceInfo eagleCodersPersistence){
		
		metadata = new PersistenceMetadata();
		
		this.eagleCodersPersistence = eagleCodersPersistence;
		
		init();
	}
	
	/**
	 * @return the metadata
	 */
	public PersistenceMetadata getMetadata() {
		return metadata;
	}

	/**
	 * 
	 * @param metadata
	 */
	private void init(){
		
		if(null != eagleCodersPersistence.getPersistenceUnitName()){
			
			metadata.setName(PERSISTENCE_UNIT);
		}
		
		if (eagleCodersPersistence.getTransactionType().equals("RESOURCE_LOCAL")){
			
			metadata.setTransactionType(PersistenceUnitTransactionType.RESOURCE_LOCAL);
			
		}else{
//			TODO:
		}
		
		if(eagleCodersPersistence.getManagedClassNames().size() > 0){
			
			metadata.getClasses().addAll(eagleCodersPersistence.getManagedClassNames());
		}
		
		if( null != eagleCodersPersistence.getProperties() && eagleCodersPersistence.getProperties().size() > 0){
			
			setProperties(eagleCodersPersistence.getProperties());
		}
		
	}
	
	/**
	 * 
	 * @param properties
	 */
	public void setProperties(Map<String, Object> properties){
		
		Set<String> keys = properties.keySet();
		
		for(String key : keys){
			
			metadata.getProps().put(keys, properties.get(key).toString());
		}
	}
}