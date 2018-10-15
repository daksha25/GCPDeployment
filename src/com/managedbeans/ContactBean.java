package com.managedbeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.bean.Contact;
import com.resource.Factory;
import com.service.ErrorRepositoryService;


@ManagedBean
@SessionScoped

public class ContactBean {
	private String name;
	private String email_id;
    private String role;
    private List<Contact> contactList;
    private String message;
    private int number;
    
    
    
    
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

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
   
	
	
	
	public String Contact(){
	try
	{
	contactList=new ArrayList<>();	
	ErrorRepositoryService ers=Factory.createErrorRepositoryService();
	contactList=ers.contact();
	message="ContactDetail.jsp";
	}
	catch (Exception e) 
	{
		message=e.getMessage();
		number=1;
	}return message;
	
	}
		}
	
	
    
	
	
	

