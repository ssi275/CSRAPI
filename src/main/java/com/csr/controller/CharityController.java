package com.csr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csr.entity.Charity;
import com.csr.entity.CharityEvent;
import com.csr.mongoRepositories.CharityRepository;
import com.csr.service.CharityService;

@RestController
public class CharityController {

    private static final Logger log = LoggerFactory.getLogger(CharityController.class);

    @Autowired
    CharityRepository charityRepository;

    @Autowired
    CharityService charityService;

    @RequestMapping(value = "/charity", method = {RequestMethod.POST})
    public boolean createCharity(
            @RequestBody Charity charity) {

        return charityService.saveNgoDetails(charity);
    }

    @RequestMapping(value = "/charity", method = {RequestMethod.GET})
    public List<Charity> getCharity() {
        log.info("Inside getCharity method of Charity controller");
        return charityService.fetchNgoList();
    }

    /**
     * This method return Ngo's detail
     * @param ngoId
     * @return
     */
    @RequestMapping(value = "/charity/{ngoId}", method = {RequestMethod.GET})
    public Charity getCharityDetails(
            @PathVariable String ngoId) {
        log.info("Inside getCharityDetails method of Charity controller");
        return charityService.fetchNgoDetails(ngoId);
    }

    /**
     * This method add new requirement to a Ngo
     * @param ngoId
     * @param event
     * @return
     */
    @RequestMapping(value = "/charity/{ngoId}/event", method = {RequestMethod.PUT})
    public Charity postCharityEvent(
            @PathVariable String ngoId, @RequestBody CharityEvent event) {
        return charityService.addNewRequirement(ngoId, event);
    }

    /**
     * @param NgoId
     * @param reqId requirementId This method update the requirement status to false for requirement with redId of NGO
     *            with NgoId
     * @return updated Ngo
     */
    @RequestMapping(value = "/charity/{ngoId}/delete", method = {RequestMethod.PUT})
    public Charity deleteCharityEvent(
            @PathVariable String ngoId, @RequestParam(value = "reqIds", required = true) String reqIds) {
        log.info("Inside deleteCharityEvent method of Charity controller");
        String[] reqIdArray = reqIds.split(",");
        return charityService.removeRequirement(ngoId, reqIdArray);
    }

}
