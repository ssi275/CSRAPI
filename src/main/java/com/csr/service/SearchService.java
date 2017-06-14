package com.csr.service;

import java.util.List;

import com.csr.entity.Charity;

public interface SearchService {

	List<Charity> fetchNearbyNgoList(double lat, double lon);

}
