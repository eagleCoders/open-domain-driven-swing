/**
 * 
 */
package com.eagle.coders.swing.core.ui.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Anees
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UiComponentPosition {
	
	String positionRow();
	
	String positionColumn();
	
	String tableDisplayColumn() default "-1";
}
