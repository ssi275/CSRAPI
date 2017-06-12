package com.csr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csr.dao.ReadDao;
import com.csr.dao.SaveDao;
import com.csr.entity.Charity;
import com.csr.entity.CharityEvent;
import com.csr.entity.Requirement;
import com.csr.mongoRepositories.CharityRepository;
import com.csr.service.CharityService;

@Service
public class CharityServiceImpl implements CharityService {

	@Autowired
	CharityRepository charityRepository;

	@Autowired
	ReadDao readDao;

	@Autowired
	SaveDao saveDao;

	@Override
	public Charity fetchNgoDetails(String ngoId) {
		Charity charity = readDao.getNgoDetail(ngoId);
		return charity;
	}

	/**
	 * This method fetch Ngo List
	 */
	@Override
	public List<Charity> fetchNgoList() {
		List<Charity> charityList = readDao.getNgoList();
		return charityList;
	}

	/**
	 * This method add new Ngo in Charity Collection
	 * 
	 */
	@Override
	public boolean saveNgoDetails(Charity charity) {
		if (charity.getNgoName() != null) {
			charityRepository.save(charity);
			return true;
		} else
			return false;
	}

	/**
	 * @param ngoId
	 * @param event
	 *  CharityEvent This method add new requirement to Ngo
	 */
	@Override
	public Charity addNewRequirement(String ngoId, CharityEvent event) {
		Charity charity = readDao.getNgoDetail(ngoId);
		List<CharityEvent> list = charity.getCharityEvent();
		list.add(event);
		charity.setCharityEvent(list);
		saveDao.saveNgoDetails(charity);
		return charity;
	}

	
	/**
	 *  This method update the requirement status to false 
	 */
	@Override
	public Charity removeRequirement(String ngoId, String reqId) {
		Charity charity = readDao.getNgoDetail(ngoId);
		List<CharityEvent> eventList = charity.getCharityEvent();
		for (CharityEvent cEvent : eventList) {
			List<Requirement> req = cEvent.getRequirement();
			System.out.println(cEvent.getCause());
			System.out.println(reqId);
			for (Requirement temp : req) {
				if ((temp.getReqId()).equals(reqId)) {

					temp.setStatus(false);
				}
			}
			cEvent.setRequirement(req);
		}

		charity.setCharityEvent(eventList);

		saveDao.saveNgoDetails(charity);

		return charity;
	}

}
