/**
 * 
 */
package com.hhtsoft.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hhtsoft.user.entity.User;

/**
 * @author huoht
 *
 */
@Mapper
public interface UserDao {

	public User get(Integer id);
	
	public List<User> find(User query);
	
	public int insert(User user);
	
	public int inserts(List<User> users);
}
