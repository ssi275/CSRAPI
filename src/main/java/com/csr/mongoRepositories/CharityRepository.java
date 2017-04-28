package com.csr.mongoRepositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.csr.entity.Charity;
//import com.csr.entity.CharityEvent;


public interface CharityRepository extends MongoRepository<Charity, String>{
	public Charity findByNgoName(String ngoName);
	//public CharityEvent findByCause(String cause);

	//public Charity findById(Integer id);
}
