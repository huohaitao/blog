/**
 * 
 */
package com.hhtsoft.user.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.hhtsoft.frame.mybatis.annotation.Id;
import com.hhtsoft.frame.mybatis.annotation.Table;

/**
 * @author huoht
 *
 */
@Table
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	private String name;
	
	private String phone;
	
	private String email;
	
	private LocalDateTime createTime;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User {");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (phone != null) {
			builder.append("phone=");
			builder.append(phone);
			builder.append(", ");
		}
		if (email != null) {
			builder.append("email=");
			builder.append(email);
		}
		builder.append("}");
		return builder.toString();
	}
	
}
