/**
 * 
 */
package com.hhtsoft.frame.response;

import java.io.Serializable;

/**
 * @author huoht
 *
 */
public class ResWrap implements Serializable{

	private static final long serialVersionUID = 1L;

	private Object data;
	
	private boolean success = true;
	
	public ResWrap() { }

	/**
	 * @param success
	 */
	public ResWrap(boolean success) {
		this.success = success;
	}

	/**
	 * @param data
	 * @param success
	 */
	public ResWrap(Object data, boolean success) {
		this.data = data;
		this.success = success;
	}

	public static ResWrap success() {
		return new ResWrap();
	}
	
	public static ResWrap success(Object data) {
		return new ResWrap(data, true);
	}
	
	public static ResWrap fail() {
		return new ResWrap(false);
	}

	public static ResWrap fail(Object data) {
		return new ResWrap(data, false);
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
