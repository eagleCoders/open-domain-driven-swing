/**
 * 
 */
package com.eagle.coders.swing.core.ui.jpa;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import javax.naming.BinaryRefAddr;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.MappedSuperclass;
import javax.persistence.PersistenceException;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
//import org.hibernate.HibernateException;
//import org.hibernate.Interceptor;
//import org.hibernate.MappingException;
//import org.hibernate.MappingNotFoundException;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.cfg.Environment;
//import org.hibernate.cfg.NamingStrategy;
//import org.hibernate.cfg.Settings;
//import org.hibernate.cfg.SettingsFactory;
//import org.hibernate.ejb.Ejb3Configuration;
//import org.hibernate.ejb.Ejb3ConfigurationObjectFactory;
//import org.hibernate.ejb.EntityManagerFactoryImpl;
//import org.hibernate.ejb.EventListenerConfigurator;
//import org.hibernate.ejb.HibernatePersistence;
//import org.hibernate.ejb.InjectionSettingsFactory;
//import org.hibernate.ejb.Version;
//import org.hibernate.ejb.connection.InjectedDataSourceConnectionProvider;
////import org.hibernate.ejb.packaging.ClassFilter;
////import org.hibernate.ejb.packaging.FileFilter;
////import org.hibernate.ejb.packaging.Filter;
//import org.hibernate.ejb.packaging.JarVisitor;
////import org.hibernate.ejb.packaging.JarVisitorFactory;
////import org.hibernate.ejb.packaging.NamedInputStream;
////import org.hibernate.ejb.packaging.PackageFilter;
//import org.hibernate.ejb.packaging.PersistenceMetadata;
//import org.hibernate.ejb.packaging.PersistenceXmlLoader;
//import org.hibernate.ejb.transaction.JoinableCMTTransactionFactory;
//import org.hibernate.engine.FilterDefinition;
//import org.hibernate.event.EventListeners;
//import org.hibernate.mapping.AuxiliaryDatabaseObject;
//import org.hibernate.mapping.PersistentClass;
//import org.hibernate.proxy.EntityNotFoundDelegate;
//import org.hibernate.secure.JACCConfiguration;
//import org.hibernate.transaction.JDBCTransactionFactory;
//import org.hibernate.util.CollectionHelper;
//import org.hibernate.util.ReflectHelper;
//import org.hibernate.util.StringHelper;
import org.xml.sax.EntityResolver;


/**
 * @author Anees
 *
 */
public class EagleCoderEJB3Configuration  {
	
	private Logger log = Logger.getLogger(EagleCoderEJB3Configuration.class);
	
	
//
//	
//	private static final String IMPLEMENTATION_NAME = HibernatePersistence.class.getName();
//	private static final String META_INF_ORM_XML = "META-INF/orm.xml";
//	private static EntityNotFoundDelegate ejb3EntityNotFoundDelegate = new Ejb3EntityNotFoundDelegate();
////	private static Configuration DEFAULT_CONFIGURATION = new AnnotationConfiguration();
//	private String persistenceUnitName;
//	private String cfgXmlResource;
//
//	private static class Ejb3EntityNotFoundDelegate implements EntityNotFoundDelegate, Serializable {
//		public void handleEntityNotFound(String entityName, Serializable id) {
//			throw new EntityNotFoundException("Unable to find " + entityName  + " with id " + id);
//		}
//	}
//
//	static {
//		Version.touch();
//	}
//
//	private AnnotationConfiguration cfg;
//	private SettingsFactory settingsFactory;
//	//made transient and not restored in deserialization on purpose, should no longer be called after restoration
//	private transient EventListenerConfigurator listenerConfigurator;
//	private PersistenceUnitTransactionType transactionType;
//	private boolean discardOnClose;
//	//made transient and not restored in deserialization on purpose, should no longer be called after restoration
//	private transient ClassLoader overridenClassLoader;
//	private boolean isConfigurationProcessed = false;
//
//
//	public EagleCoderEJB3Configuration(){
//		
////		super();
//		
//		settingsFactory = new InjectionSettingsFactory();
//		cfg = new AnnotationConfiguration( settingsFactory );
//		cfg.setEntityNotFoundDelegate( ejb3EntityNotFoundDelegate );
////		listenerConfigurator = new EventListenerConfigurator( this );
//
//	}
//
//	/**
//	 * Used to inject a datasource object as the connection provider.
//	 * If used, be sure to <b>not override</b> the hibernate.connection.provider_class
//	 * property
//	 */
//	public void setDataSource(DataSource ds) {
//		if ( ds != null ) {
//			Map cpInjection = new HashMap();
//			cpInjection.put( "dataSource", ds );
//			( (InjectionSettingsFactory) settingsFactory ).setConnectionProviderInjectionData( cpInjection );
//			this.setProperty( Environment.CONNECTION_PROVIDER, InjectedDataSourceConnectionProvider.class.getName() );
//		}
//	}
//
//	/**
//	 * create a factory from a parsed persistence.xml
//	 * Especially the scanning of classes and additional jars is done already at this point.
//	 */
//	public EagleCoderEJB3Configuration configure(PersistenceMetadata metadata, Map overrides) {
//		log.debug( "Creating Factory: {}"+metadata.getName() );
//
//		Map workingVars = new HashMap();
//		workingVars.put( HibernatePersistence.PERSISTENCE_UNIT_NAME, metadata.getName() );
//		this.persistenceUnitName = metadata.getName();
//
//		if ( StringHelper.isNotEmpty( metadata.getJtaDatasource() ) ) {
//			this.setProperty( Environment.DATASOURCE, metadata.getJtaDatasource() );
//		}
//		else if ( StringHelper.isNotEmpty( metadata.getNonJtaDatasource() ) ) {
//			this.setProperty( Environment.DATASOURCE, metadata.getNonJtaDatasource() );
//		}
//		defineTransactionType( metadata.getTransactionType(), workingVars );
//		if ( metadata.getClasses().size() > 0 ) {
//			workingVars.put( HibernatePersistence.CLASS_NAMES, metadata.getClasses() );
//		}
//		if ( metadata.getPackages().size() > 0 ) {
//			workingVars.put( HibernatePersistence.PACKAGE_NAMES, metadata.getPackages() );
//		}
//		if ( metadata.getMappingFiles().size() > 0 ) {
//			workingVars.put( HibernatePersistence.XML_FILE_NAMES, metadata.getMappingFiles() );
//		}
//		if ( metadata.getHbmfiles().size() > 0 ) {
//			workingVars.put( HibernatePersistence.HBXML_FILES, metadata.getHbmfiles() );
//		}
//		Properties props = new Properties();
//		props.putAll( metadata.getProps() );
//		if ( overrides != null ) {
//			for ( Map.Entry entry : (Set<Map.Entry>) overrides.entrySet() ) {
//				Object value = entry.getValue();
//				props.put( entry.getKey(), value == null ? "" :  value ); //alter null, not allowed in properties
//			}
//		}
////		configure( props, workingVars );
//		return this;
//	}
//
////	//method used in a non managed environment
////	private JarVisitor getMainJarVisitor(URL url, PersistenceMetadata metadata, Map integration) {
////		URL jarURL = JarVisitorFactory.getJarURLFromURLEntry( url, "/META-INF/persistence.xml" );
////		Filter[] persistenceXmlFilter = getFilters( metadata, integration, metadata.getExcludeUnlistedClasses() );
////		return JarVisitorFactory.getVisitor( jarURL, persistenceXmlFilter );
////	}
//
////	private static void addMetadataFromVisitor(JarVisitor visitor, PersistenceMetadata metadata) throws IOException {
////		List<String> classes = metadata.getClasses();
////		List<String> packages = metadata.getPackages();
////		List<NamedInputStream> hbmFiles = metadata.getHbmfiles();
////		List<String> mappingFiles = metadata.getMappingFiles();
////		addScannedEntries( visitor, classes, packages, hbmFiles, mappingFiles );
////	}
//
////	private static void addScannedEntries(JarVisitor visitor, List<String> classes, List<String> packages, List<NamedInputStream> hbmFiles, List<String> mappingFiles) throws IOException {
////	
////		Filter[] filters = visitor.getFilters();
////
////		Set[] entries = visitor.getMatchingEntries();
////		
////		int size = filters.length;
////		for ( int index = 0; index < size ; index++ ) {
////			for (Object o : entries[index]) {
////				Entry entry = (Entry) o;
////				if ( filters[index] instanceof ClassFilter ) {
////					classes.add( entry.getName() );
////				}
////				else if ( filters[index] instanceof PackageFilter ) {
////					packages.add( entry.getName() );
////				}
////				else if ( filters[index] instanceof FileFilter ) {
////					hbmFiles.add( new NamedInputStream( entry.getName(), entry.getInputStream() ) );
////					if (mappingFiles != null) mappingFiles.remove( entry.getName() );
////				}
////			}
////		}
////	}
//
//
//
//	private void defineTransactionType(Object overridenTxType, Map workingVars) {
//		if ( overridenTxType == null ) {
////			if ( transactionType == null ) {
////				transactionType = PersistenceUnitTransactionType.JTA; //this is the default value
////			}
//			//nothing to override
//		}
//		else if ( overridenTxType instanceof String ) {
//			transactionType = PersistenceXmlLoader.getTransactionType( (String) overridenTxType );
//		}
//		else if ( overridenTxType instanceof PersistenceUnitTransactionType ) {
//			transactionType = (PersistenceUnitTransactionType) overridenTxType;
//		}
////		else {
////			throw new PersistenceException( getExceptionHeader() +
////					HibernatePersistence.TRANSACTION_TYPE + " of the wrong class type"
////							+ ": " + overridenTxType.getClass()
////			);
////		}
//
//	}
//
//	public EagleCoderEJB3Configuration setProperty(String key, String value) {
//		cfg.setProperty( key, value );
//		return this;
//	}
//
//	private boolean[] getDetectedArtifacts(Properties properties, Map overridenProperties, boolean excludeIfNotOverriden) {
//		boolean[] result = new boolean[2];
//		result[0] = false; //detect classes
//		result[1] = false; //detect hbm
//		String detect = overridenProperties != null ?
//				(String) overridenProperties.get( HibernatePersistence.AUTODETECTION ) :
//				null;
//		detect = detect == null ?
//				properties.getProperty( HibernatePersistence.AUTODETECTION) :
//				detect;
//		if (detect == null && excludeIfNotOverriden) {
//			//not overriden through HibernatePersistence.AUTODETECTION so we comply with the spec excludeUnlistedClasses
//			return result;
//		}
//		else if (detect == null){
//			detect = "class,hbm";
//		}
//		StringTokenizer st = new StringTokenizer( detect, ", ", false );
//		while ( st.hasMoreElements() ) {
//			String element = (String) st.nextElement();
//			if ( "class".equalsIgnoreCase( element ) ) result[0] = true;
//			if ( "hbm".equalsIgnoreCase( element ) ) result[1] = true;
//		}
//		log.debug( "Detect class: {}; detect hbm: {}"+result[0]+" "+result[1] );
//		return result;
//	}
//
////	private Filter[] getFilters(PersistenceMetadata metadata, Map overridenProperties, boolean excludeIfNotOverriden) {
////		Properties properties = metadata.getProps();
////		final List<String> mappingFiles = metadata.getMappingFiles();
////		boolean[] detectedArtifacts = getDetectedArtifacts( properties, overridenProperties, excludeIfNotOverriden );
////
////		return getFilters( detectedArtifacts, true, mappingFiles );
////	}
////
////	private Filter[] getFilters(final boolean[] detectedArtifacts, final boolean searchORM, final List<String> mappingFiles) {
////		final int mappingFilesSize = mappingFiles != null ? mappingFiles.size() : 0;
////		int size = ( detectedArtifacts[0] ? 2 : 0 ) + ( (searchORM || detectedArtifacts[1] || mappingFilesSize > 0 ) ? 1 : 0);
////		Filter[] filters = new Filter[size];
////		if ( detectedArtifacts[0] ) {
////			filters[0] = new PackageFilter( false, null ) {
////				public boolean accept(String javaElementName) {
////					return true;
////				}
////			};
////			filters[1] = new ClassFilter(
////					false, new Class[]{
////					Entity.class,
////					MappedSuperclass.class,
////					Embeddable.class}
////			) {
////				public boolean accept(String javaElementName) {
////					return true;
////				}
////			};
////		}
////		if ( detectedArtifacts[1] || searchORM || mappingFilesSize > 0) {
////			filters[size - 1] = new FileFilter( true ) {
////				public boolean accept(String javaElementName) {
////					return ( detectedArtifacts[1] && javaElementName.endsWith( "hbm.xml" ) )
////							|| ( searchORM && javaElementName.endsWith( META_INF_ORM_XML ) )
////							|| ( mappingFilesSize > 0 && mappingFiles.contains( javaElementName ) );
////				}
////			};
////		}
////		return filters;
////	}
////
////	private void scanForClasses(URL jar, List<String> packages, List<String> entities, List<NamedInputStream> hbmFiles, boolean[] detectedArtifacts, boolean searchORM) {
////		if (jar == null) {
////			log.error( "Container is providing a null PersistenceUnitRootUrl: discovery impossible");
////			return;
////		}
////		try {
////			JarVisitor visitor = JarVisitorFactory.getVisitor( jar, getFilters( detectedArtifacts, searchORM, null ) );
//////			addScannedEntries( visitor, entities, packages, hbmFiles, null );
////		}
////		catch (RuntimeException e) {
////			throw new RuntimeException( "error trying to scan <jar-file>: " + jar.toString(), e );
////		}
//////		catch( IOException e ) {
//////			throw new RuntimeException( "Error while reading " + jar.toString(), e );
//////		}
////	}
////
//////	/**
//////	 * create a factory from a list of properties and
//////	 * HibernatePersistence.CLASS_NAMES -> Collection<String> (use to list the classes from config files
//////	 * HibernatePersistence.PACKAGE_NAMES -> Collection<String> (use to list the mappings from config files
//////	 * HibernatePersistence.HBXML_FILES -> Collection<InputStream> (input streams of hbm files)
//////	 * HibernatePersistence.LOADED_CLASSES -> Collection<Class> (list of loaded classes)
//////	 * <p/>
//////	 * <b>Used by JBoss AS only</b>
//////	 * @deprecated use the Java Persistence API
//////	 */
//////	// This is used directly by JBoss so don't remove until further notice.  bill@jboss.org
//////	public EntityManagerFactory createEntityManagerFactory(Map workingVars) {
//////		Properties props = new Properties();
//////		if ( workingVars != null ) {
//////			props.putAll( workingVars );
//////			//remove huge non String elements for a clean props
//////			props.remove( HibernatePersistence.CLASS_NAMES );
//////			props.remove( HibernatePersistence.PACKAGE_NAMES );
//////			props.remove( HibernatePersistence.HBXML_FILES );
//////			props.remove( HibernatePersistence.LOADED_CLASSES );
//////		}
//////		configure( props, workingVars );
//////		return buildEntityManagerFactory();
//////	}
////
//////	/**
//////	 * Process configuration and build an EntityManagerFactory <b>when</b> the configuration is ready
//////	 * @deprecated
//////	 */
//////	public EntityManagerFactory createEntityManagerFactory() {
//////		configure( cfg.getProperties(), new HashMap() );
//////		return buildEntityManagerFactory();
//////	}
//////
////	public EntityManagerFactory buildEntityManagerFactory() {
////		Thread thread = null;
////		ClassLoader contextClassLoader = null;
////		if (overridenClassLoader != null) {
////			thread = Thread.currentThread();
////			contextClassLoader = thread.getContextClassLoader();
////			thread.setContextClassLoader( overridenClassLoader );
////		}
////		try {
////			configure( (Properties)null, null );
//////			NamingHelper.bind(this);
////			return new EntityManagerFactoryImpl(
////					cfg.buildSessionFactory(),
////					transactionType,
////					discardOnClose,
////					getSessionInterceptorClass( cfg.getProperties() )
////			);
////		}
////		catch (HibernateException e) {
////			throw new PersistenceException( getExceptionHeader() + "Unable to build EntityManagerFactory", e );
////		}
////		finally {
////			if (thread != null) {
////				thread.setContextClassLoader( contextClassLoader );
////			}
////		}
////	}
////
////	private Class getSessionInterceptorClass(Properties properties) {
////		String sessionInterceptorClassname = (String) properties.get( HibernatePersistence.SESSION_INTERCEPTOR );
////		if ( StringHelper.isNotEmpty( sessionInterceptorClassname ) ) {
////			try {
////				Class interceptorClass = ReflectHelper.classForName( sessionInterceptorClassname, Ejb3Configuration.class );
////				interceptorClass.newInstance();
////				return interceptorClass;
////			}
////			catch (ClassNotFoundException e) {
////				throw new PersistenceException( getExceptionHeader() + "Unable to load "
////						+ HibernatePersistence.SESSION_INTERCEPTOR + ": " + sessionInterceptorClassname, e);
////			}
////			catch (IllegalAccessException e) {
////				throw new PersistenceException( getExceptionHeader() + "Unable to instanciate "
////						+ HibernatePersistence.SESSION_INTERCEPTOR + ": " + sessionInterceptorClassname, e);
////			}
////			catch (InstantiationException e) {
////				throw new PersistenceException( getExceptionHeader() + "Unable to instanciate "
////						+ HibernatePersistence.SESSION_INTERCEPTOR + ": " + sessionInterceptorClassname, e);
////			}
////		}
////		else {
////			return null;
////		}
////	}
////
////	public Reference getReference() throws NamingException {
////		log.debug("Returning a Reference to the Ejb3Configuration");
////		ByteArrayOutputStream stream = new ByteArrayOutputStream();
////		ObjectOutput out = null;
////		byte[] serialized;
////		try {
////			out = new ObjectOutputStream( stream );
////			out.writeObject( this );
////			out.close();
////			serialized = stream.toByteArray();
////			stream.close();
////		}
////		catch (IOException e) {
////			NamingException namingException = new NamingException( "Unable to serialize Ejb3Configuration" );
////			namingException.setRootCause( e );
////			throw namingException;
////		}
////
////		return new Reference(
////				Ejb3Configuration.class.getName(),
////				new BinaryRefAddr("object", serialized ),
////				Ejb3ConfigurationObjectFactory.class.getName(),
////				null
////		);
////	}
////
////	/**
////	 * create a factory from a canonical workingVars map and the overriden properties
////	 *
////	 */
////	private EagleCoderEJB3Configuration configure(
////			Properties properties, Map workingVars
////	) {
////		//TODO check for people calling more than once this method (except buildEMF)
////		if (isConfigurationProcessed) return this;
////		isConfigurationProcessed = true;
////		Properties preparedProperties = prepareProperties( properties, workingVars );
////		if ( workingVars == null ) workingVars = CollectionHelper.EMPTY_MAP;
////
////		if ( preparedProperties.containsKey( HibernatePersistence.CFG_FILE ) ) {
////			String cfgFileName = preparedProperties.getProperty( HibernatePersistence.CFG_FILE );
////			cfg.configure( cfgFileName );
////		}
////
////		cfg.addProperties( preparedProperties ); //persistence.xml has priority over hibernate.cfg.xml
////
////		addClassesToSessionFactory( workingVars );
////
////		//processes specific properties
////		List<String> jaccKeys = new ArrayList<String>();
////
////
//////		Interceptor defaultInterceptor = DEFAULT_CONFIGURATION.getInterceptor();
//////		NamingStrategy defaultNamingStrategy = DEFAULT_CONFIGURATION.getNamingStrategy();
////
////		Iterator propertyIt = preparedProperties.keySet().iterator();
////		while ( propertyIt.hasNext() ) {
////			Object uncastObject = propertyIt.next();
////			//had to be safe
////			if ( uncastObject != null && uncastObject instanceof String ) {
////				String propertyKey = (String) uncastObject;
////				if ( propertyKey.startsWith( HibernatePersistence.CLASS_CACHE_PREFIX ) ) {
////					setCacheStrategy( propertyKey, preparedProperties, true, workingVars );
////				}
////				else if ( propertyKey.startsWith( HibernatePersistence.COLLECTION_CACHE_PREFIX ) ) {
////					setCacheStrategy( propertyKey, preparedProperties, false, workingVars );
////				}
////				else if ( propertyKey.startsWith( HibernatePersistence.JACC_PREFIX )
////						&& ! ( propertyKey.equals( HibernatePersistence.JACC_CONTEXT_ID )
////						|| propertyKey.equals( HibernatePersistence.JACC_ENABLED ) ) ) {
////					jaccKeys.add( propertyKey );
////				}
////			}
////		}
////		if ( preparedProperties.containsKey( HibernatePersistence.INTERCEPTOR )
////				&& ( cfg.getInterceptor() == null ) ) {
////			//cfg.setInterceptor has precedence over configuration file
////			String interceptorName = preparedProperties.getProperty( HibernatePersistence.INTERCEPTOR );
////			try {
////				Class interceptor = classForName( interceptorName );
////				cfg.setInterceptor( (Interceptor) interceptor.newInstance() );
////			}
////			catch (ClassNotFoundException e) {
////				throw new PersistenceException(
////						getExceptionHeader() + "Unable to find interceptor class: " + interceptorName, e
////				);
////			}
////			catch (IllegalAccessException e) {
////				throw new PersistenceException(
////						getExceptionHeader() + "Unable to access interceptor class: " + interceptorName, e
////				);
////			}
////			catch (InstantiationException e) {
////				throw new PersistenceException(
////						getExceptionHeader() + "Unable to instanciate interceptor class: " + interceptorName, e
////				);
////			}
////			catch (ClassCastException e) {
////				throw new PersistenceException(
////						getExceptionHeader() + "Interceptor class does not implement Interceptor interface: " + interceptorName, e
////				);
////			}
////		}
////		if ( preparedProperties.containsKey( HibernatePersistence.NAMING_STRATEGY )
////				&& ( cfg.getNamingStrategy() == null ) ) {
////			//cfg.setNamingStrategy has precedence over configuration file
////			String namingStrategyName = preparedProperties.getProperty( HibernatePersistence.NAMING_STRATEGY );
////			try {
////				Class namingStragegy = classForName( namingStrategyName );
////				cfg.setNamingStrategy( (NamingStrategy) namingStragegy.newInstance() );
////			}
////			catch (ClassNotFoundException e) {
////				throw new PersistenceException(
////						getExceptionHeader() + "Unable to find naming strategy class: " + namingStrategyName, e
////				);
////			}
////			catch (IllegalAccessException e) {
////				throw new PersistenceException(
////						getExceptionHeader() + "Unable to access naming strategy class: " + namingStrategyName, e
////				);
////			}
////			catch (InstantiationException e) {
////				throw new PersistenceException(
////						getExceptionHeader() + "Unable to instanciate naming strategy class: " + namingStrategyName, e
////				);
////			}
////			catch (ClassCastException e) {
////				throw new PersistenceException(
////						getExceptionHeader() + "Naming strategyy class does not implement NmaingStrategy interface: " + namingStrategyName,
////						e
////				);
////			}
////		}
////
////		if ( jaccKeys.size() > 0 ) {
////			addSecurity( jaccKeys, preparedProperties, workingVars );
////		}
////
////		//initialize listeners
////		listenerConfigurator.setProperties( preparedProperties );
////		listenerConfigurator.configure();
////
////		//some spec compliance checking
////		//TODO centralize that?
////		if ( ! "true".equalsIgnoreCase( cfg.getProperty( Environment.AUTOCOMMIT ) ) ) {
////			log.warn( "{} = false break the EJB3 specification"+Environment.AUTOCOMMIT );
////		}
////		discardOnClose = preparedProperties.getProperty( HibernatePersistence.DISCARD_PC_ON_CLOSE )
////				.equals( "true" );
////		return this;
////	}
////
////	private void addClassesToSessionFactory(Map workingVars) {
////		if ( workingVars.containsKey( HibernatePersistence.CLASS_NAMES ) ) {
////			Collection<String> classNames = (Collection<String>) workingVars.get(
////					HibernatePersistence.CLASS_NAMES
////			);
////			addNamedAnnotatedClasses( this, classNames, workingVars );
////		}
////		//TODO apparently only used for Tests, get rid of it?
////		if ( workingVars.containsKey( HibernatePersistence.LOADED_CLASSES ) ) {
////			Collection<Class> classes = (Collection<Class>) workingVars.get( HibernatePersistence.LOADED_CLASSES );
////			for ( Class clazz : classes ) {
////				cfg.addAnnotatedClass( clazz );
////			}
////		}
////		if ( workingVars.containsKey( HibernatePersistence.PACKAGE_NAMES ) ) {
////			Collection<String> packages = (Collection<String>) workingVars.get(
////					HibernatePersistence.PACKAGE_NAMES
////			);
////			for ( String pkg : packages ) {
////				cfg.addPackage( pkg );
////			}
////		}
////		if ( workingVars.containsKey( HibernatePersistence.XML_FILE_NAMES ) ) {
////			Collection<String> xmlFiles = (Collection<String>) workingVars.get(
////					HibernatePersistence.XML_FILE_NAMES
////			);
////			for ( String xmlFile : xmlFiles ) {
////				Boolean useMetaInf = null;
////				try {
////					if ( xmlFile.endsWith( META_INF_ORM_XML ) ) useMetaInf = true;
////					cfg.addResource( xmlFile );
////				}
////				catch( MappingNotFoundException e ) {
////					if ( ! xmlFile.endsWith( META_INF_ORM_XML ) ) {
////						throw new PersistenceException( getExceptionHeader()
////								+ "Unable to find XML mapping file in classpath: " + xmlFile);
////					}
////					else {
////						useMetaInf = false;
////						//swallow it, the META-INF/orm.xml is optional
////					}
////				}
////				catch( MappingException me ) {
////					throw new PersistenceException( getExceptionHeader()
////								+ "Error while reading JPA XML file: " + xmlFile, me);
////				}
////				if ( log.isInfoEnabled() ) {
////					if ( Boolean.TRUE.equals( useMetaInf ) ) {
////						log.info( "{} {} found"+getExceptionHeader()+" "+ META_INF_ORM_XML);
////					}
////					else if (Boolean.FALSE.equals( useMetaInf ) ) {
////						log.info( "{} No {} found" + getExceptionHeader()+" "+ META_INF_ORM_XML);
////					}
////				}
////			}
////		}
////		if ( workingVars.containsKey( HibernatePersistence.HBXML_FILES ) ) {
////			Collection<NamedInputStream> hbmXmlFiles = (Collection<NamedInputStream>) workingVars.get(
////					HibernatePersistence.HBXML_FILES
////			);
////			for ( NamedInputStream is : hbmXmlFiles ) {
////				try {
////					//addInputStream has the responsibility to close the stream
////					cfg.addInputStream( new BufferedInputStream( is.getStream() ) );
////				}
////				catch (MappingException me) {
////					//try our best to give the file name
////					if ( StringHelper.isEmpty( is.getName() ) ) {
////						throw me;
////					}
////					else {
////						throw new MappingException("Error while parsing file: " + is.getName(), me );
////					}
////				}
////			}
////		}
////	}
////
////	private String getExceptionHeader() {
////		if ( StringHelper.isNotEmpty( persistenceUnitName ) ) {
////			return "[PersistenceUnit: " + persistenceUnitName + "] ";
////		}
////		else {
////			return "";
////		}
////	}
////
////	private Properties prepareProperties(Properties properties, Map workingVars) {
////		Properties preparedProperties = new Properties();
////
////		//defaults different from Hibernate
////		preparedProperties.setProperty( Environment.RELEASE_CONNECTIONS, "auto" );
////		preparedProperties.setProperty( Environment.JPAQL_STRICT_COMPLIANCE, "true" );
////		//settings that always apply to a compliant EJB3
////		preparedProperties.setProperty( Environment.AUTOCOMMIT, "true" );
////		preparedProperties.setProperty( Environment.USE_IDENTIFIER_ROLLBACK, "false" );
////		preparedProperties.setProperty( Environment.FLUSH_BEFORE_COMPLETION, "false" );
////		preparedProperties.setProperty( HibernatePersistence.DISCARD_PC_ON_CLOSE, "false" );
////		if (cfgXmlResource != null) {
////			preparedProperties.setProperty( HibernatePersistence.CFG_FILE, cfgXmlResource );
////			cfgXmlResource = null;
////		}
////
////		//override the new defaults with the user defined ones
////		//copy programmatically defined properties
////		if ( cfg.getProperties() != null ) preparedProperties.putAll( cfg.getProperties() );
////		//copy them coping from configuration
////		if ( properties != null ) preparedProperties.putAll( properties );
////		//note we don't copy cfg.xml properties, since they have to be overriden
////
////		if (transactionType == null) {
////			//if it has not been set, the user use a programmatic way
////			transactionType = PersistenceUnitTransactionType.RESOURCE_LOCAL;
////		}
////		defineTransactionType(
////				preparedProperties.getProperty( HibernatePersistence.TRANSACTION_TYPE ),
////				workingVars
////		);
////		boolean hasTxStrategy = StringHelper.isNotEmpty(
////				preparedProperties.getProperty( Environment.TRANSACTION_STRATEGY )
////		);
////		if ( ! hasTxStrategy && transactionType == PersistenceUnitTransactionType.JTA ) {
////			preparedProperties.setProperty(
////					Environment.TRANSACTION_STRATEGY, JoinableCMTTransactionFactory.class.getName()
////			);
////		}
////		else if ( ! hasTxStrategy && transactionType == PersistenceUnitTransactionType.RESOURCE_LOCAL ) {
////			preparedProperties.setProperty( Environment.TRANSACTION_STRATEGY, JDBCTransactionFactory.class.getName() );
////		}
////		if ( hasTxStrategy ) {
////			log.warn(
////					"Overriding {} is dangerous, this might break the EJB3 specification implementation"+
////					Environment.TRANSACTION_STRATEGY
////			);
////		}
////		if ( preparedProperties.getProperty( Environment.FLUSH_BEFORE_COMPLETION ).equals( "true" ) ) {
////			preparedProperties.setProperty( Environment.FLUSH_BEFORE_COMPLETION, "false" );
////			log.warn( "Defining {}=true ignored in HEM"+Environment.FLUSH_BEFORE_COMPLETION );
////		}
////		return preparedProperties;
////	}
////
////	private Class classForName(String className) throws ClassNotFoundException {
////		return ReflectHelper.classForName( className, this.getClass() );
////	}
////
////	private void setCacheStrategy(String propertyKey, Map properties, boolean isClass, Map workingVars) {
////		String role = propertyKey.substring(
////				( isClass ? HibernatePersistence.CLASS_CACHE_PREFIX
////						.length() : HibernatePersistence.COLLECTION_CACHE_PREFIX.length() )
////						+ 1
////		);
////		//dot size added
////		String value = (String) properties.get( propertyKey );
////		StringTokenizer params = new StringTokenizer( value, ";, " );
////		if ( !params.hasMoreTokens() ) {
////			StringBuilder error = new StringBuilder( "Illegal usage of " );
////			error.append(
////					isClass ? HibernatePersistence.CLASS_CACHE_PREFIX : HibernatePersistence.COLLECTION_CACHE_PREFIX
////			);
////			error.append( ": " ).append( propertyKey ).append( " " ).append( value );
////			throw new PersistenceException( getExceptionHeader() + error.toString() );
////		}
////		String usage = params.nextToken();
////		String region = null;
////		if ( params.hasMoreTokens() ) {
////			region = params.nextToken();
////		}
////		if ( isClass ) {
////			boolean lazyProperty = true;
////			if ( params.hasMoreTokens() ) {
////				lazyProperty = "all".equalsIgnoreCase( params.nextToken() );
////			}
////			cfg.setCacheConcurrencyStrategy( role, usage, region, lazyProperty );
////		}
////		else {
////			cfg.setCollectionCacheConcurrencyStrategy( role, usage, region );
////		}
////	}
////
////	private void addSecurity(List<String> keys, Map properties, Map workingVars) {
////		log.debug( "Adding security" );
////		if ( !properties.containsKey( HibernatePersistence.JACC_CONTEXT_ID ) ) {
////			throw new PersistenceException( getExceptionHeader() +
////					"Entities have been configured for JACC, but "
////							+ HibernatePersistence.JACC_CONTEXT_ID
////							+ " has not been set"
////			);
////		}
////		String contextId = (String) properties.get( HibernatePersistence.JACC_CONTEXT_ID );
////		setProperty( Environment.JACC_CONTEXTID, contextId );
////
////		int roleStart = HibernatePersistence.JACC_PREFIX.length() + 1;
////
////		for ( String key : keys ) {
////			JACCConfiguration jaccCfg = new JACCConfiguration( contextId );
////			try {
////				String role = key.substring( roleStart, key.indexOf( '.', roleStart ) );
////				int classStart = roleStart + role.length() + 1;
////				String clazz = key.substring( classStart, key.length() );
////				String actions = (String) properties.get( key );
////				jaccCfg.addPermission( role, clazz, actions );
////			}
////			catch (IndexOutOfBoundsException e) {
////				throw new PersistenceException( getExceptionHeader() +
////						"Illegal usage of " + HibernatePersistence.JACC_PREFIX + ": " + key );
////			}
////		}
////	}
////
////	private void addNamedAnnotatedClasses(
////			EagleCoderEJB3Configuration cfg, Collection<String> classNames, Map workingVars
////	) {
////		for ( String name : classNames ) {
////			try {
////				Class clazz = classForName( name );
////				cfg.addAnnotatedClass( clazz );
////			}
////			catch (ClassNotFoundException cnfe) {
////				Package pkg;
////				try {
////					pkg = classForName( name + ".package-info" ).getPackage();
////				}
////				catch (ClassNotFoundException e) {
////					pkg = null;
////				}
////				if ( pkg == null ) {
////					throw new PersistenceException( getExceptionHeader() +  "class or package not found", cnfe );
////				}
////				else {
////					cfg.addPackage( name );
////				}
////			}
////		}
////	}
////
////
////	public Settings buildSettings() throws HibernateException {
////		Thread thread = null;
////		ClassLoader contextClassLoader = null;
////		if (overridenClassLoader != null) {
////			thread = Thread.currentThread();
////			contextClassLoader = thread.getContextClassLoader();
////			thread.setContextClassLoader( overridenClassLoader );
////		}
////		try {
////			return settingsFactory.buildSettings( cfg.getProperties() );
////		}
////		finally {
////			if (thread != null) thread.setContextClassLoader( contextClassLoader );
////		}
////	}
////
////	public EagleCoderEJB3Configuration addProperties(Properties props) {
////		cfg.addProperties( props );
////		return this;
////	}
////
////	public EagleCoderEJB3Configuration addAnnotatedClass(Class persistentClass) throws MappingException {
////		Thread thread = null;
////		ClassLoader contextClassLoader = null;
////		if (overridenClassLoader != null) {
////			thread = Thread.currentThread();
////			contextClassLoader = thread.getContextClassLoader();
////			thread.setContextClassLoader( overridenClassLoader );
////		}
////		try {
////			cfg.addAnnotatedClass( persistentClass );
////			return this;
////		}
////		finally {
////			if (thread != null) thread.setContextClassLoader( contextClassLoader );
////		}
////	}
////
////	public EagleCoderEJB3Configuration configure(String resource) throws HibernateException {
////		//delay the call to configure to allow proper addition of all annotated classes (EJB-330)
////		if (cfgXmlResource != null)
////			throw new PersistenceException("configure(String) method already called for " + cfgXmlResource);
////		this.cfgXmlResource = resource;
////		return this;
////	}
////
////	public EagleCoderEJB3Configuration addPackage(String packageName) throws MappingException {
////		Thread thread = null;
////		ClassLoader contextClassLoader = null;
////		if (overridenClassLoader != null) {
////			thread = Thread.currentThread();
////			contextClassLoader = thread.getContextClassLoader();
////			thread.setContextClassLoader( overridenClassLoader );
////		}
////		try {
////			cfg.addPackage( packageName );
////			return this;
////		}
////		finally {
////			if (thread != null) thread.setContextClassLoader( contextClassLoader );
////		}
////	}
////
////	public EagleCoderEJB3Configuration addFile(String xmlFile) throws MappingException {
////		Thread thread = null;
////		ClassLoader contextClassLoader = null;
////		if (overridenClassLoader != null) {
////			thread = Thread.currentThread();
////			contextClassLoader = thread.getContextClassLoader();
////			thread.setContextClassLoader( overridenClassLoader );
////		}
////		try {
////			cfg.addFile( xmlFile );
////			return this;
////		}
////		finally {
////			if (thread != null) thread.setContextClassLoader( contextClassLoader );
////		}
////	}
////
////	public EagleCoderEJB3Configuration addClass(Class persistentClass) throws MappingException {
////		Thread thread = null;
////		ClassLoader contextClassLoader = null;
////		if (overridenClassLoader != null) {
////			thread = Thread.currentThread();
////			contextClassLoader = thread.getContextClassLoader();
////			thread.setContextClassLoader( overridenClassLoader );
////		}
////		try {
////			cfg.addClass( persistentClass );
////			return this;
////		}
////		finally {
////			if (thread != null) thread.setContextClassLoader( contextClassLoader );
////		}
////	}
////
////	public EagleCoderEJB3Configuration addFile(File xmlFile) throws MappingException {
////		Thread thread = null;
////		ClassLoader contextClassLoader = null;
////		if (overridenClassLoader != null) {
////			thread = Thread.currentThread();
////			contextClassLoader = thread.getContextClassLoader();
////			thread.setContextClassLoader( overridenClassLoader );
////		}
////		try {
////			cfg.addFile( xmlFile );
////			return this;
////		}
////		finally {
////			if (thread != null) thread.setContextClassLoader( contextClassLoader );
////		}
////	}
////
////	public void buildMappings() {
////		Thread thread = null;
////		ClassLoader contextClassLoader = null;
////		if (overridenClassLoader != null) {
////			thread = Thread.currentThread();
////			contextClassLoader = thread.getContextClassLoader();
////			thread.setContextClassLoader( overridenClassLoader );
////		}
////		try {
////			cfg.buildMappings();
////		}
////		finally {
////			if (thread != null) thread.setContextClassLoader( contextClassLoader );
////		}
////	}
////
////	public Iterator getClassMappings() {
////		Thread thread = null;
////		ClassLoader contextClassLoader = null;
////		if (overridenClassLoader != null) {
////			thread = Thread.currentThread();
////			contextClassLoader = thread.getContextClassLoader();
////			thread.setContextClassLoader( overridenClassLoader );
////		}
////		try {
////			return cfg.getClassMappings();
////		}
////		finally {
////			if (thread != null) thread.setContextClassLoader( contextClassLoader );
////		}
////	}
////
////	public EventListeners getEventListeners() {
////		return cfg.getEventListeners();
////	}
////
////	SessionFactory buildSessionFactory() throws HibernateException {
////		return cfg.buildSessionFactory();
////	}
////
////	public Iterator getTableMappings() {
////		return cfg.getTableMappings();
////	}
////
////	public PersistentClass getClassMapping(String persistentClass) {
////		return cfg.getClassMapping( persistentClass );
////	}
////
////	public org.hibernate.mapping.Collection getCollectionMapping(String role) {
////		return cfg.getCollectionMapping( role );
////	}
////
////	public void setEntityResolver(EntityResolver entityResolver) {
////		cfg.setEntityResolver( entityResolver );
////	}
////
////	public Map getNamedQueries() {
////		return cfg.getNamedQueries();
////	}
////
////	public Interceptor getInterceptor() {
////		return cfg.getInterceptor();
////	}
////
////	public Properties getProperties() {
////		return cfg.getProperties();
////	}
////
////	public EagleCoderEJB3Configuration setInterceptor(Interceptor interceptor) {
////		cfg.setInterceptor( interceptor );
////		return this;
////	}
////
////	public EagleCoderEJB3Configuration setProperties(Properties properties) {
////		cfg.setProperties( properties );
////		return this;
////	}
////
////	public Map getFilterDefinitions() {
////		return cfg.getFilterDefinitions();
////	}
////
////	public void addFilterDefinition(FilterDefinition definition) {
////		cfg.addFilterDefinition( definition );
////	}
////
////	public void addAuxiliaryDatabaseObject(AuxiliaryDatabaseObject object) {
////		cfg.addAuxiliaryDatabaseObject( object );
////	}
////
////	public NamingStrategy getNamingStrategy() {
////		return cfg.getNamingStrategy();
////	}
////
////	public EagleCoderEJB3Configuration setNamingStrategy(NamingStrategy namingStrategy) {
////		cfg.setNamingStrategy( namingStrategy );
////		return this;
////	}
////
////	public void setListeners(String type, String[] listenerClasses) {
////		cfg.setListeners( type, listenerClasses );
////	}
////
////	public void setListeners(String type, Object[] listeners) {
////		cfg.setListeners( type, listeners );
////	}
////
////	/**
////	 * This API is intended to give a read-only configuration.
////	 * It is sueful when working with SchemaExport or any Configuration based
////	 * tool.
////	 * DO NOT update configuration through it.
////	 */
////	public AnnotationConfiguration getHibernateConfiguration() {
////		//TODO make it really read only (maybe through proxying)
////		return cfg;
////	}
////
////	public EagleCoderEJB3Configuration addInputStream(InputStream xmlInputStream) throws MappingException {
////		Thread thread = null;
////		ClassLoader contextClassLoader = null;
////		if (overridenClassLoader != null) {
////			thread = Thread.currentThread();
////			contextClassLoader = thread.getContextClassLoader();
////			thread.setContextClassLoader( overridenClassLoader );
////		}
////		try {
////			cfg.addInputStream( xmlInputStream );
////			return this;
////		}
////		finally {
////			if (thread != null) thread.setContextClassLoader( contextClassLoader );
////		}
////	}
////
////	public EagleCoderEJB3Configuration addResource(String path) throws MappingException {
////		Thread thread = null;
////		ClassLoader contextClassLoader = null;
////		if (overridenClassLoader != null) {
////			thread = Thread.currentThread();
////			contextClassLoader = thread.getContextClassLoader();
////			thread.setContextClassLoader( overridenClassLoader );
////		}
////		try {
////			cfg.addResource( path );
////			return this;
////		}
////		finally {
////			if (thread != null) thread.setContextClassLoader( contextClassLoader );
////		}
////	}
////
////	public EagleCoderEJB3Configuration addResource(String path, ClassLoader classLoader) throws MappingException {
////		cfg.addResource( path, classLoader );
////		return this;
////	}
////
////	private enum XML_SEARCH {
////		HBM,
////		ORM_XML,
////		BOTH,
////		NONE;
////
////		public static XML_SEARCH getType(boolean searchHbm, boolean searchOrm) {
////			return searchHbm ?
////					searchOrm ? XML_SEARCH.BOTH : XML_SEARCH.HBM :
////					searchOrm ? XML_SEARCH.ORM_XML : XML_SEARCH.NONE;
////		}
////	}
////
////
}
