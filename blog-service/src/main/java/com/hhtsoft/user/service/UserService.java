/**
 * 
 */
package com.hhtsoft.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhtsoft.user.dao.UserDao;
import com.hhtsoft.user.entity.User;

/**
 * @author huoht
 *
 */
@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public User get(Integer id) {
		return this.dao.get(id);
	}
	
	public List<User> find(User query) {
		return this.dao.find(query);
	}
	
	public int insert(User user) {
		return this.dao.insert(user);
	}
	
	public int inserts(List<User> users) {
		return this.dao.inserts(users);
	}
}
