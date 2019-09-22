/**
 * 
 */
package com.hhtsoft.frame.function;

/**
 * @author huoht
 *
 */
@FunctionalInterface
public interface ExFunction<T,R> {

	R execute(T t);
	
}
