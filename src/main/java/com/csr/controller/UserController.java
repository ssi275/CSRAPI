package com.csr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csr.entity.User;
import com.csr.mongoRepositories.UserRepository;

@RestController
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/users", method = { RequestMethod.POST })
	private boolean createUser(@RequestBody User user)
	{	
		userRepository.save(user);
		log.info("Inside createUser method of User controller");
		return true;
	}
	
	@RequestMapping(value = "/users", method = { RequestMethod.GET })
	private List<User> getUser()
	{		
			List<User> user= userRepository.findAll();
			log.info("Inside getUser method of User controller");
			return  user;
	}
	
	@RequestMapping(value = "/users", method = { RequestMethod.PUT })
	private String updateUser()
	{
		log.info("Inside updateUser method of User controller");
		return "user";
	}
	

}
