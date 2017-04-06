package com.csr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/")
	private String testmethod() {
		log.info("test method hit by us");
	        return "First Controller";

	}
	
	
	@RequestMapping(value = "/users", method = { RequestMethod.POST })
	private boolean createUser()
	{
		log.info("create method hit by us");
		return true;
	}
	
	//TODO: Need to be changed by user pojo
	@RequestMapping(value = "/users", method = { RequestMethod.GET })
	private String getUser()
	{
		log.info("get method hit by us");
		return "user";
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
