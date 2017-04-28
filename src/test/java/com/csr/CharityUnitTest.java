package com.csr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;

import com.csr.controller.CharityController;
import com.csr.entity.Charity;
import com.csr.mongoRepositories.CharityRepository;

public class CharityUnitTest extends CsrapiApplicationTests{
	
	@Autowired
	CharityController charityController;
	
	@Mock
	CharityRepository charityRepository;
	
	private List<Charity> getCharityListStub(){
		List<Charity> list = new ArrayList<>();
		
		list.add(getCharityStub());
		return list;
	}
	
	private Charity getCharityStub(){
		Charity charity = new Charity();
		charity.setNgoName("cry");
		charity.setNgoId("333");
		return charity;
	}
	
	@Test
	public void TestgetCharity(){
		
		List <Charity> list = getCharityListStub();
		when(charityRepository.findAll()).thenReturn(list);
		Whitebox.setInternalState(charityController, "charityRepository", charityRepository);
		List <Charity> charitylist = charityController.getCharity();
		assertNotNull(charitylist);
		assertEquals(charitylist.get(0).getNgoName(), "cry");
	}
	
	@Test
	public void TestgetCharityDetails(){
		Charity entity = getCharityStub();
		when(charityRepository.findByNgoName(entity.getNgoName())).thenReturn(entity);
		Whitebox.setInternalState(charityController, "charityRepository", charityRepository);
		Charity charity = charityController.getCharityDetails(entity.getNgoName());
		assertNotNull(charity);
		assertEquals(charity.getNgoId(),entity.getNgoId());
	}
	
	
	@Test
	public void TestcreateCharity(){
		Charity entity = getCharityStub();
		boolean charity = charityController.createCharity(entity); 
		assertEquals(charity,true);
		Charity dummy = new Charity();
		boolean charityFalse = charityController.createCharity(dummy); 
		assertEquals(charityFalse,false);
	}

}
