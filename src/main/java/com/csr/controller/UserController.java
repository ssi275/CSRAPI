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
import com.csr.service.impl.AESencrp;

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
	public User LoginUser(@RequestBody User user) throws Exception {
		String emailId = user.getEmailId();
		String password = user.getPassword();
		User U = userRepository.findByUserId(emailId);
		System.out.println(U);
	if(U==null){	
		user.setUserId("N");
		return user;
		 }

	else if (null != U && (U.getEmailId().equals(emailId)) && (AESencrp.decrypt(U.getPassword()).equals(password)))  {
			return U;
		} 
	
	else {
		user.setUserId("W");
		return user;
	}
	
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void AddNewUser(@RequestBody User newUser) throws Exception {
		
		if (null == newUser.getEmailId() && null == newUser.getPassword() && null == newUser.getUserName()
				&& null == newUser.getUserType()) {
			System.out.println("please enter your crednetials");
		}
		else {
			int check=1;
			List<User> list = userRepository.findAll();
			for (int i = 0; i < list.size(); i++) {
				User u = list.get(i);
				if (newUser.getEmailId().equals(u.getEmailId())) {
					System.out.println("User Already exist");
					check=0;
					break;
				}
				
				
			}
			if(check==1){
				User user = new User();
				user.setEmailId(newUser.getEmailId());
				String passwordEnc = AESencrp.encrypt(newUser.getPassword());
				user.setPassword(passwordEnc );
				user.setUserName(newUser.getUserName());
				user.setUserType(newUser.getUserType());
				user.setUserStatus(true);
				userRepository.save(user);}
		}
	}
}
