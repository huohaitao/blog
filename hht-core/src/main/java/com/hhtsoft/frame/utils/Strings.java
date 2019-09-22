/**
 * 
 */
package com.hhtsoft.frame.utils;

/**
 * @author huoht
 *
 */
public class Strings {

	public static String join(Object... elements) {
		if(elements == null || elements.length==0) return "";
		StringBuilder sb = new StringBuilder();
		for(Object o : elements) {
			if(o==null) continue;
			sb.append(o);
		}
		return sb.toString();
	}
}
