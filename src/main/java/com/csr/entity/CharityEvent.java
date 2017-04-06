package com.csr.entity;

import java.util.List;

public class CharityEvent {

	private String cause;
	private List<Requirement> requirement;
	
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public List<Requirement> getRequirement() {
		return requirement;
	}
	public void setRequirement(List<Requirement> requirement) {
		this.requirement = requirement;
	}
	
	
}
