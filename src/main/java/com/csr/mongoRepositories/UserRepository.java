package com.csr.mongoRepositories;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.csr.entity.User;

public interface UserRepository extends MongoRepository<User, String>{
	public User findByUserId( String userId);
	//public Charity findByNgoId(String ngoId);
	public List<User> findAll();

}
