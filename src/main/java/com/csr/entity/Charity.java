package com.csr.entity;

import java.util.List;

public class Charity {
	
	private Integer userId;
	private String ngoName;
	private String pocName;
	private Contact contact;
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
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
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
