package com.csr.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "CHARITY")

public class Charity {
	
	@Id
	private String ngoId;
	private String ngoName;
	
	private ArrayList<Contact> contact;
	
	private String detail;
	private List<CharityEvent> charityEvent;
	private Long latitude;
	private Long longitude;
	private String image;
	
	
	
	public String getNgoId() {
		return ngoId;
	}
	public void setNgoId(String ngoId) {
		this.ngoId = ngoId;
	}
	public String getNgoName() {
		return ngoName;
	}
	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
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
	
	
	public Long getLatitude() {
		return latitude;
	}
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}
	public Long getLongitude() {
		return longitude;
	}
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	

}
