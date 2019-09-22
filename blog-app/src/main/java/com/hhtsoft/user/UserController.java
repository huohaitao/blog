/**
 * 
 */
package com.hhtsoft.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hhtsoft.frame.response.ResWrap;
import com.hhtsoft.user.entity.User;
import com.hhtsoft.user.service.UserService;

/**
 * @author huoht
 *
 */
@RestController("/user")
public class UserController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/list")
	public ResWrap view() {
		logger.debug("1232");
		User query = new User();
		query.setName("霍海涛11");
		List<User> users = this.service.find(query);
		return ResWrap.success(users);
	}
}
