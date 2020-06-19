/**
 * 
 */
package com.eagle.coders.swing.core.ui.validation.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Anees
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE})
@Documented()
public @interface Constraint {

	   /**
     * An enumeration of the different types that a constraint may be applied to.
     */
    enum Type { 
        /**
         * The constraint may be applied to any type of object
         */
        ANY, 
        
        /**
         * The constraint may be applied to any object for which 
         * Object.toString() yields a meaningful result. In practice, it is up
         * to the application to determine what is meaningful.
         */
        STRING, 
        
        /**
         * The constraint may be applied to numeric objects only. This means
         * any subclass of Number or corresponding primitive type.
         */
        INTEGER, 
        
        /**
         * The constraint may be applied to collections only. Note the
         * constraints apply to some attribute of the collection itself (e.g. size)
         * and not to the objects in the collection.
         */
        COLLECTION ,

        /**
         * The constraint may be applied to BIG DECIMAL only. It is useful to validate the big number with precsion
         */
        BIGDECIMAL,

        /**
         * The constraint may be applied to BIG DECIMAL only. It is useful to validate the big number with precsion
         */
        FLOAT
    };
    
    /**
     * The type of object the constraint can be applied to. The default is ANY
     * type.
     */
    Type value() default Type.ANY;
}
