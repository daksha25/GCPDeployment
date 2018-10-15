package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class ContactEntity {
	
	private String name;
	@Id
    private String email_id;
    private String role;
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
    
    

}
