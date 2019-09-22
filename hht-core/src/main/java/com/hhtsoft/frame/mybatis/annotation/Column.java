/**
 * 
 */
package com.hhtsoft.frame.mybatis.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author huoht
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {

	public String name() default "";
	
	public String type() default "";
	
	public int length() default 11;
	
	public boolean nullable() default false;
	
	public String defaultValue() default "";
}
