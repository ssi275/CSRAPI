package com.csr.dao;

import java.util.List;

import com.csr.entity.Charity;

public interface ReadDao {
	
	public Charity getNgoDetail(final String ngoId);
	public List<Charity> getNgoList();

}
