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
    public Charity fetchNgoDetails(
            String ngoId) {
        Charity charity = readDao.getNgoDetail(ngoId);
        return charity;
    }

    /**
     * This method is to fetch Ngo List
     */
    @Override
    public List<Charity> fetchNgoList() {
        List<Charity> charityList = readDao.getNgoList();
        return charityList;
    }

    /**
     * This method add new Ngo in Charity Collection
     */
    @Override
    public boolean saveNgoDetails(
            Charity charity) {
        if (charity.getNgoName() != null) {
            charityRepository.save(charity);
            return true;
        } else
            return false;
    }

    /**
     * @param ngoId
     * @param event CharityEvent This method add new requirement to Ngo
     */
    @Override
    public Charity addNewRequirement(
            String ngoId, CharityEvent event) {
        Charity charity = readDao.getNgoDetail(ngoId);
        List<CharityEvent> list = charity.getCharityEvent();
        list.add(event);
        charity.setCharityEvent(list);
        saveDao.saveNgoDetails(charity);
        return charity;
    }

    /**
     * @param ngoId
     * @param ReqId This method update the requirement status to false if the requirement has been removed
     */
    @Override
    public Charity removeRequirement(
            String ngoId, String[] reqIds) {
        Charity charity = readDao.getNgoDetail(ngoId);
        List<CharityEvent> eventList = charity.getCharityEvent();
        for (String reqId : reqIds) {
            for (CharityEvent Event : eventList) {
                List<Requirement> requirementList = Event.getRequirement();
                for (Requirement req : requirementList) {
                    if ((req.getReqId()).equals(reqId)) {

                        req.setStatus(false);
                    }
                }
                Event.setRequirement(requirementList);
            }
        }
        charity.setCharityEvent(eventList);
        saveDao.saveNgoDetails(charity);
        return charity;
    }

}
