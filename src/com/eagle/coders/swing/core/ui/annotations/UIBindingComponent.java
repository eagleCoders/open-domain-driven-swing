/**
 * 
 */
package com.eagle.coders.swing.core.ui.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.eagle.coders.swing.core.ui.annotations.type.ComponentType;

/**
 * @author Anees
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UIBindingComponent {

//	ComponentType type() default ComponentType.TEXT_FIELD;

	String type() default "tf";

	String label();
	
	String property();
	
	String row() default "1";
	
	String column() default "1";
	
	String tableDisplayColumn() default "-1";
	
}
