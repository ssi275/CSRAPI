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
	
//	@RequestMapping("/")
//	private String testmethod() {
//		log.info("test method hit by us");
//	        return "First Controller";
//
//	}
//	
	
	@RequestMapping(value = "/users", method = { RequestMethod.POST })
	private boolean createUser(@RequestBody User user)
	{	
		userRepository.save(user);
		log.info("create method hit by us");
		return true;
	}
	
	//TODO: Need to be changed by user pojo
	@RequestMapping(value = "/users", method = { RequestMethod.GET })
	private List<User> getUser()
	{		
			List<User> user= userRepository.findAll();
//			user.get(0).getUserName();
			System.out.println("" +"hello");
			log.info("get method hit by us");
			return  user;
//		log.info("get method hit by us");
//		return "user";
	}
	
	//TODO: Need to be changed by user pojo
	@RequestMapping(value = "/users", method = { RequestMethod.PUT })
	private String updateUser()
	{
		log.info("put method hit by us");
		return "user";
	}
	
	@RequestMapping(value = "/users", method = { RequestMethod.DELETE })
	private boolean deleteUser()
	{
		log.info("delete method hit by us");
		return false;
	}

}
