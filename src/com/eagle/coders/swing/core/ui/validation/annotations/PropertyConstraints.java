/**
 * 
 */
package com.eagle.coders.swing.core.ui.validation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.eagle.coders.swing.core.ui.annotations.type.MandatoryType;
import com.eagle.coders.swing.core.ui.annotations.type.NullConstraintType;
import com.eagle.coders.swing.core.ui.annotations.type.StringInputCaseType;
import com.eagle.coders.swing.core.ui.annotations.type.TextFiledInputDataType;

/**
 * @author Anees
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface PropertyConstraints {

	NullConstraintType allowNull() default NullConstraintType.ALLOW;
	
	MandatoryType isMandatory() default MandatoryType.FALSE;
	
	StringInputCaseType inputCaseType() default StringInputCaseType.MIXEDCASE;
	
	TextFiledInputDataType textInputDataType() default TextFiledInputDataType.ALPHANUMERIC;
	
	String maxLength() default "";
	
	String minLength() default "";
	
	String pattern() default "";
}
