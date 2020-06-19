/**
 * 
 */
package com.eagle.coders.swing.core.ui.decorator.widgets.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.eagle.coders.swing.core.ui.decorator.widgets.action.DefaultActionProcessor;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.IAction;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;

/**
 * @author Anees
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Button {
	
	ActionTypes buttonType();
	
	String imageFiles() default "";
	
	String buttonLabel() default "";
	
	String tooltipe() default "";
	
	Class<? extends IAction> action() default DefaultActionProcessor.class;
	
}
