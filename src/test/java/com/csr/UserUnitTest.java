package com.csr;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import com.csr.controller.UserController;
import com.csr.entity.User;
import com.csr.mongoRepositories.UserRepository;

public class UserUnitTest extends CsrapiApplicationTests{

	

	@Autowired
	UserController userController;
	
	@Mock
	UserRepository userRepository;
	
	private List<User> getUserList(){
		List<User> list = new ArrayList<>();
		
		list.add(getUserData());
		return list;
	}
	
	private User getUserData(){
		User user = new User();
		user.setUserName("cry");
		user.setUserId(333);
		return user;
	}
	
	
	@Test
	public void testgetUser(){
		
		List <User> list = getUserList();
		when(userRepository.findAll()).thenReturn(list);
		
		Whitebox.setInternalState(userController, "userRepository", userRepository);
		List<User> userlist = userController.getUser();
		assertEquals(userlist.get(0).getUserName(), "cry");

	}
	
	@Test
	public void TestcreateUser(){
		User entity = getUserData();
		//Whitebox.setInternalState(userController, "userRepository", userRepository);
		boolean user = userController.createUser(entity); 
		assertEquals(user,true);
		User dummy = new User();
		boolean userFalse = userController.createUser(dummy); 
		assertEquals(userFalse,false);
	}
}
