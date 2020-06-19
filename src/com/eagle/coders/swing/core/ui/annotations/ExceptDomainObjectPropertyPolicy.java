/**
 * 
 */
package com.eagle.coders.swing.core.ui.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.eagle.coders.swing.core.ui.annotations.type.DomainPerpertiesAllowType;

/**
 * @author Anees
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ExceptDomainObjectPropertyPolicy {
	
	Class domainObject() ;
	
	DomainPerpertiesAllowType genralPolicy() default DomainPerpertiesAllowType.ALLOW_ALL ; // 1 -> Allow All, 0 -> deny all
	
	DomainProperties[] properties();

}
