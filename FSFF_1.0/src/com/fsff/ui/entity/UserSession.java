package com.fsff.ui.entity;

import java.io.Serializable;

public class UserSession implements Serializable{
	private int id ;
	
	private String firstName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
}
