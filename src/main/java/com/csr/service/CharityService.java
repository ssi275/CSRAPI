package com.csr.service;

import java.util.List;

import com.csr.entity.Charity;
import com.csr.entity.CharityEvent;

public interface CharityService {

	public Charity fetchNgoDetails(final String ngoId) ;

	public List<Charity> fetchNgoList();

	public boolean saveNgoDetails(Charity charity);

	public Charity addNewRequirement(String ngoId, CharityEvent event);

	public Charity removeRequirement(String ngoId, String reqId);
}
