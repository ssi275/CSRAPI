package com.csr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csr.entity.Charity;
import com.csr.mongoRepositories.CharityRepository;

@RestController
public class CharityController {
	
	
private static final Logger log = LoggerFactory.getLogger(CharityController.class);
	
@Autowired
private CharityRepository charityRepository;

	@RequestMapping("/")
	private String testmethod() {
		log.info("test method hit by us");
	        return "First Controller";

	}
	
	
	@RequestMapping(value = "/charity", method = { RequestMethod.POST })
	private boolean createCharity(@RequestBody Charity charity)
	{
		
		charityRepository.save(charity);
		log.info("create method hit by us");
		return true;
	}
	
	
	
	@RequestMapping(value = "/charity", method = { RequestMethod.GET })
	private List<Charity> getCharity()
	{	
		List<Charity> charity= charityRepository.findAll();
		System.out.println(charity.get(0) +"hello");
		log.info("get method hit by us");
		return charity;
	}
	
	@RequestMapping(value = "/charity/{ngoName}", method = { RequestMethod.GET })
	private Charity getCharityDetails(@PathVariable String ngoName)
	{	
		Charity charity= charityRepository.findByNgoName(ngoName);
		//System.out.println(charity.get(0) +"hello");
		log.info("get method hit by us");
		return charity;
	}
	
	@RequestMapping(value = "/charity/{ngoName}", method = { RequestMethod.PUT })
	private Charity updateCharity(@PathVariable String ngoName, @RequestBody Charity charity)
	{	
		Charity charityUpdate= charityRepository.findByNgoName(ngoName);
		charityUpdate.setCharityEvent(charity.getCharityEvent());
		//charityUpdate.save(charity);
		log.info("put method hit by us");
		charityRepository.save(charityUpdate);
		return charityUpdate;
	}
	
	@RequestMapping(value = "/charity", method = { RequestMethod.DELETE })
	private boolean deleteUser()
	{
		log.info("delete method hit by us");
		return false;
	}

}
