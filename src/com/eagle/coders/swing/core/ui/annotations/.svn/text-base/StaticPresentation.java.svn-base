/**
 * 
 */
package com.eagle.coders.swing.core.ui.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.eagle.coders.swing.core.ui.annotations.type.StaticPresentationPolicyType;
import com.eagle.coders.swing.core.ui.interfaces.IUiComponent;

/**
 * @author Anees
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface StaticPresentation {

	Class<? extends IUiComponent> userPanel();
	
	String label() default "";
	
	String bindableDomainName() default "";
	
	StaticPresentationPolicyType presentationPolicy() default StaticPresentationPolicyType.PANEL;
}
