package com.csr.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csr.dao.ReadDao;
import com.csr.entity.Charity;
import com.csr.entity.CharityEvent;
import com.csr.entity.Requirement;
import com.csr.mongoRepositories.CharityRepository;

@Repository
public class ReadDaoImpl implements ReadDao{

	
	@Autowired
	CharityRepository charityRepository;
	
	@Override
	public Charity getNgoDetail(String ngoId) {
		Charity charity = charityRepository.findByNgoId(ngoId);
		List<CharityEvent> eventList = charity.getCharityEvent();
		List<CharityEvent> newEventList = new ArrayList<CharityEvent>();
		for (CharityEvent Event : eventList) {
			List<Requirement> requirementList = Event.getRequirement();
			int length = requirementList.size();
			int count = 1;
			for (Requirement req : requirementList) {
				if (!req.isStatus()) {

					break;
				}
				else {
					count++;
				}
			}
			if(count != length ) {
				newEventList.add(Event);
			}
		}
		
		charity.setCharityEvent(newEventList);
		return charity;
		
	}

	@Override
	public List<Charity> getNgoList() {
		return charityRepository.findAll();
	}

}
