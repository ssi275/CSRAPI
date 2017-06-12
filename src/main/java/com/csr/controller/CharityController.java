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
import com.csr.entity.CharityEvent;
import com.csr.entity.Ngo;
import com.csr.entity.Requirement;
import com.csr.mongoRepositories.CharityRepository;
import com.mongodb.BasicDBObject;

@RestController
public class CharityController {
	
	
private static final Logger log = LoggerFactory.getLogger(CharityController.class);
	
@Autowired
private CharityRepository charityRepository;

	@RequestMapping(value = "/charity", method = { RequestMethod.POST })
	public boolean createCharity(@RequestBody Charity charity)
	{
		if(charity.getNgoName() != null){
			charityRepository.save(charity);
			log.info("Inside createCharity method of Charity controller");
			return true;
			}
		else
			return false;
	}
	


	
	@RequestMapping(value = "/charity", method = { RequestMethod.GET })
	public List<Charity> getCharity()
	{	
		List<Charity> charity= charityRepository.findAll();
		log.info("Inside getCharity method of Charity controller");
		return charity;
	}

	
	@RequestMapping(value = "/charity/{ngoId}", method = { RequestMethod.GET })
	public Charity getCharityDetails(@PathVariable String ngoId)
	{	
		System.out.println(ngoId);
		Charity charity= charityRepository.findByNgoId(ngoId);
		System.out.println(charity.getNgoName());
		log.info("Inside getCharityDetails method of Charity controller");
		return charity;
	}
// 	@RequestMapping(value = "/charity/{ngoName}/{event}", method = { RequestMethod.PUT })
// 	public Charity postCharityEvent(@PathVariable String ngoName, @RequestBody CharityEvent event)
// 	{	
// 		Charity charity= charityRepository.findByNgoName(ngoName);
// 		List<CharityEvent> list = charity.getCharityEvent();
// 		list.add(event);
// 		charity.setCharityEvent(list);
// 		charityRepository.save(charity);
		
// 		log.info("Inside getCharityDetails method of Charity controller");
// 		return charity;
// 	}
	
	@RequestMapping(value = "/charity/{ngoId}/event", method = { RequestMethod.PUT })
	public Charity postCharityEvent(@PathVariable String ngoId, @RequestBody CharityEvent event)
	{	
		Charity charity= charityRepository.findByNgoId(ngoId);
		List<CharityEvent> list = charity.getCharityEvent();
		list.add(event);
		charity.setCharityEvent(list);
		charityRepository.save(charity);
		
		log.info("Inside getCharityDetails method of Charity controller");
		return charity;
	}
// 	@RequestMapping(value = "/charity/{ngoName}/delete/{reqId}", method = { RequestMethod.PUT })
// 	public Charity deleteCharityEvent(@PathVariable String ngoName,  @PathVariable String reqId)
// 	{	
// 		Charity charity= charityRepository.findByNgoName(ngoName);
		
// 		List <CharityEvent> eventList = charity.getCharityEvent();
// 		for(CharityEvent cEvent : eventList){
// 			List<Requirement> req = cEvent.getRequirement();
// 			System.out.println(cEvent.getCause());
// 			System.out.println(reqId);
// 				for (Requirement temp : req) {
// 					if((temp.getReqId()).equals(reqId))	{
						
// 						temp.setStatus(false);
// 					}
// 				}
// 				cEvent.setRequirement(req);
// 			}
		
		
// 		charity.setCharityEvent(eventList);

// 		charityRepository.save(charity);
// 		log.info("Inside deleteCharityEvent method of Charity controller");
// 		return charity;
// 	}
	
	@RequestMapping(value = "/charity/{ngoId}/delete/{reqId}", method = { RequestMethod.PUT })
	public Charity deleteCharityEvent(@PathVariable String ngoId,  @PathVariable String reqId)
	{	
		Charity charity= charityRepository.findByNgoId(ngoId);
		
		List <CharityEvent> eventList = charity.getCharityEvent();
		for(CharityEvent cEvent : eventList){
			List<Requirement> req = cEvent.getRequirement();
			System.out.println(cEvent.getCause());
			System.out.println(reqId);
				for (Requirement temp : req) {
					if((temp.getReqId()).equals(reqId))	{
						
						temp.setStatus(false);
					}
				}
				cEvent.setRequirement(req);
			}
		
		
		charity.setCharityEvent(eventList);

		charityRepository.save(charity);
		log.info("Inside deleteCharityEvent method of Charity controller");
		return charity;
	}
	
	
}
