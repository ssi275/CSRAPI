package com.csr.service;

import java.util.List;

import com.csr.entity.Category;
import com.csr.entity.Charity;

public interface SearchService {

	List<Charity> fetchNearbyNgoList(double lat, double lon);
	List<Charity> fetchNearbyNgoListForRequiredCategory(String category, double lat, double lon);

}
