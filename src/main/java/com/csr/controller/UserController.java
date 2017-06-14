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
	public boolean createUser(@RequestBody User user) {
		if (user.getUserId() != null) {
			userRepository.save(user);
			log.info("Inside createUser method of User controller");
			return true;
		} else
			return false;
	}

	@RequestMapping(value = "/users", method = { RequestMethod.GET })
	public List<User> getUser() {
		List<User> user = userRepository.findAll();
		System.out.println("system variable" + System.getenv("spring.data.mongodb.uri"));
		log.info("Inside getUser method of User controller" + System.getenv("spring.data.mongodb.uri"));
		return user;
	}

	@RequestMapping(value = "/users", method = { RequestMethod.PUT })
	public static String updateUser() {
		log.info("Inside updateUser method of User controller");
		return "user";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String LoginUser(@RequestBody User user) {
		String userId = user.getUserId();
		String password = user.getPassword();
		User U = userRepository.findByUserId(userId);

		if (null != U && (U.getUserId().equals(userId)) && (U.getPassword().equals(password))) {
			return "welcome";
		} else if (null == U) {
			return "You need to register";
		} else {
			return "Wrong Credentials";
		}

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void AddNewUser(@RequestBody User newUser) {

		List<User> list = userRepository.findAll();
		for (int i = 0; i < list.size(); i++) {
			User u = list.get(i);
			if (null != newUser.getUserId() && null != newUser.getPassword() && null != newUser.getUserName()
					&& null != newUser.getUserType()) {
				if (newUser.getUserId().equals(u.getUserId())) {
					System.out.println("User Already exist");

				} else {
					User user = new User();
					user.setUserId(newUser.getUserId());
					user.setPassword(newUser.getPassword());
					user.setUserName(newUser.getUserName());
					user.setUserType(newUser.getUserType());
					userRepository.save(user);

				}
			}

		}

	}

}
