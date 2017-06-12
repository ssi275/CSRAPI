package com.csr.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csr.dao.ReadDao;
import com.csr.entity.Charity;
import com.csr.mongoRepositories.CharityRepository;

@Repository
public class ReadDaoImpl implements ReadDao{

	
	@Autowired
	CharityRepository charityRepository;
	
	@Override
	public Charity getNgoDetail(String ngoId) {
		return charityRepository.findByNgoId(ngoId);
	}

	@Override
	public List<Charity> getNgoList() {
		return charityRepository.findAll();
	}

}
