/**
 * 
 */
package com.eagle.coders.swing.core.ui.jpa;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.spi.ClassTransformer;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;

/**
 * @author Anees
 *
 */
public class EagleCodersPersistenceInfo {

	private DataSource dataSource;
	
	private DataSource jtaDataSource;
	
	private DataSource nonJtaDataSource;

	private List<URL>  jarFileUrls;
	
	private List<String> managedClassesName;
	
	private String persistenceUnitName;
	
	private Map<String, Object> properties;
	
	private PersistenceUnitTransactionType persistenceUnitTransactionType;
	
	public EagleCodersPersistenceInfo(){
		
		jarFileUrls = new ArrayList<URL>();
		
		managedClassesName = new ArrayList<String>();
	}
	
	/**
	 * 
	 * @param className
	 */
	public void addManagedClassNames(String className){
		
		if(!managedClassesName.contains(className)){
			
			managedClassesName.add(className);
		}
	}
	

	public List<URL> getJarFileUrls() {

		return jarFileUrls;
	}

	public DataSource getJtaDataSource() {

		return jtaDataSource;
	}

	public List<String> getManagedClassNames() {
	
		return managedClassesName;
	}

	public List<String> getMappingFileNames() {

		return null;
	}

	public ClassLoader getNewTempClassLoader() {

		return null;
	}

	public DataSource getNonJtaDataSource() {

		return nonJtaDataSource;
	}

	public String getPersistenceProviderClassName() {

		return null;
	}

	public String getPersistenceUnitName() {

		return persistenceUnitName;
	}

	public URL getPersistenceUnitRootUrl() {

		return null;
	}

	public Map<String, Object> getProperties() {

		return properties;
	}

	public PersistenceUnitTransactionType getTransactionType() {

		return persistenceUnitTransactionType;
	}

	/**
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * @param jtaDataSource the jtaDataSource to set
	 */
	public void setJtaDataSource(DataSource jtaDataSource) {
		this.jtaDataSource = jtaDataSource;
	}

	/**
	 * @param nonJtaDataSource the nonJtaDataSource to set
	 */
	public void setNonJtaDataSource(DataSource nonJtaDataSource) {
		this.nonJtaDataSource = nonJtaDataSource;
	}

	/**
	 * @param jarFileUrls the jarFileUrls to set
	 */
	public void setJarFileUrls(List<URL> jarFileUrls) {
		this.jarFileUrls = jarFileUrls;
	}

	/**
	 * @param persistenceUnitName the persistenceUnitName to set
	 */
	public void setPersistenceUnitName(String persistenceUnitName) {
		this.persistenceUnitName = persistenceUnitName;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	/**
	 * @param persistenceUnitTransactionType the persistenceUnitTransactionType to set
	 */
	public void setPersistenceUnitTransactionType(
			PersistenceUnitTransactionType persistenceUnitTransactionType) {
		this.persistenceUnitTransactionType = persistenceUnitTransactionType;
	}

	/**
	 * @return the managedClassesName
	 */
	public List<String> getManagedClassesName() {
		return managedClassesName;
	}

	/**
	 * @param managedClassesName the managedClassesName to set
	 */
	public void setManagedClassesName(List<String> managedClassesName) {
		this.managedClassesName = managedClassesName;
	}

}
