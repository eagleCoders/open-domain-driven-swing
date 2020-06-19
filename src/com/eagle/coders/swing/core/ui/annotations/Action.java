package com.eagle.coders.swing.core.ui.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.eagle.coders.swing.core.ui.decorator.widgets.action.ExecutionRequest;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.ExecutionResponse;
import com.eagle.coders.swing.core.ui.decorator.widgets.action.IExecution;
import com.eagle.coders.swing.core.ui.decorator.widgets.annotations.type.ActionTypes;

/**
 * 
 * @author Anees
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Action {
	
	static class Empty implements IExecution{

		@Override
		public ExecutionResponse execute(ExecutionRequest executionRequest) {
			return null;
		}
	}

	ActionTypes actionType();
	
	Class<? extends IExecution> exeution() default Empty.class;
}
