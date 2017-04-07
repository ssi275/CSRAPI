package com.csr.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Document(collection = "CHARITY")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Charity {
	//@Id
	//private String id;
	private Integer userId;
	private String ngoName;
	private String pocName;
	private ArrayList<Contact> contact;
	
	private String detail;
	private List<CharityEvent> charityEvent;
	private String latLong;
	private String image;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNgoName() {
		return ngoName;
	}
	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}
	public String getPocName() {
		return pocName;
	}
	public void setPocName(String pocName) {
		this.pocName = pocName;
	}

	public ArrayList<Contact> getContact() {
		return contact;
	}
	public void setContact(ArrayList<Contact> contact) {
		this.contact = contact;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public List<CharityEvent> getCharityEvent() {
		return charityEvent;
	}
	public void setCharityEvent(List<CharityEvent> charityEvent) {
		this.charityEvent = charityEvent;
	}
	public String getLatLong() {
		return latLong;
	}
	public void setLatLong(String latLong) {
		this.latLong = latLong;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	

}
