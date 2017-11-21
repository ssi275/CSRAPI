package com.csr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csr.entity.Charity;
import com.csr.service.SearchService;

@RestController
public class SearchNgoController {

    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/calculateDistance/{lat}/{lon}", method = {RequestMethod.GET})
    public List<Charity> findNearbyNgos(
            @PathVariable Double lat, @PathVariable Double lon) {
        return searchService.fetchNearbyNgoList(lat, lon);
    }

    @RequestMapping(value = "charity/requirement/{lat}/{lon}", method = {RequestMethod.GET})
    public List<Charity> findNearbyNgosByRequirement(
            @PathVariable Double lat, @PathVariable Double lon,
            @RequestParam(value = "category", required = true) String category) {
        return searchService.fetchNearbyNgoListForRequiredCategory(category, lat, lon);
    }
}
