package com.csr.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csr.dao.SaveDao;
import com.csr.entity.Charity;
import com.csr.mongoRepositories.CharityRepository;

@Repository
public class SaveDaoImpl implements SaveDao{

	
	@Autowired
	CharityRepository charityRepository; 
	
	@Override
	public void saveNgoDetails(Charity charity) {
		charityRepository.save(charity);
		
	}

}
