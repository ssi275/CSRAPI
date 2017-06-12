package com.csr.mongoRepositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.csr.entity.Charity;



public interface CharityRepository extends MongoRepository<Charity, String>{

	public Charity findByNgoId(String ngoId);

	}
