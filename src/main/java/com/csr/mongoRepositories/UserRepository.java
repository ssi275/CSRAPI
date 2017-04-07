package com.csr.mongoRepositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.csr.entity.User;

public interface UserRepository extends MongoRepository<User, String>{

}
