package com.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.bean.ServiceRequest;
import com.resource.Factory;
import com.service.ErrorRepositoryService;


@ManagedBean
@SessionScoped
public class ServiceRequstBean {
private int requestId;
private String trackingId;
private String facilities;
private String description;
private String status;
private String message;
private List<String> allRequestIds;
private int parentAccNo;


public int getParentAccNo() {
	return parentAccNo;
}


public void setParentAccNo(int parentAccNo) {
	this.parentAccNo = parentAccNo;
}


public List<String> getAllRequestIds() {
	return allRequestIds;
}


public void setAllRequestIds(List<String> allRequestIds) {
	this.allRequestIds = allRequestIds;
}


public String getTrackingId() {
	return trackingId;
}


public void setTrackingId(String trackingId) {
	this.trackingId = trackingId;
}


public String getMessage() {
	return message;
}


public void setMessage(String message) {
	this.message = message;
}




public int getRequestId() {
	return requestId;
}


public void setRequestId(int requestId) {
	this.requestId = requestId;
}


public String getFacilities() {
	
	return facilities;
}


public void setFacilities(String facilities) {
	this.facilities = facilities;
}


public String getDescription() {
	
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}


public String submitRequest(){
	
	try{
	     if(getDescription().equals("")){
	    	 message="Description is mandatory.";
	     }
	     else if(getFacilities().equals("")){
	    	 message="Please select any facility.";
	     }
	     else{
		ServiceRequest sr=new ServiceRequest();
		ErrorRepositoryService src=Factory.createErrorRepositoryService();
		sr.setFacilities(getFacilities());
		sr.setDescription(getDescription());
		sr.setStatus("submitted");
		String username=LoginBean.uName;
		int accno=src.getAccountNumberForMatching(username);
		sr.setParentAccNo(accno);
		String requestId= "RQ" + src.Request(sr);
	    message="Your request with id " + requestId+" has been submitted successfully";
	}
	     }
	catch(Exception e){
		e.printStackTrace();
		message=e.getMessage();
	}
	return message;
}

public String trackRequest(){
	
	try{
		String id=getTrackingId();
		int id1=Integer.parseInt(id.substring(2,id.length()));
		ErrorRepositoryService src=Factory.createErrorRepositoryService();
		String s1=LoginBean.uName;
		int num=src.getAccountNumberForMatching(s1);
		String s=src.trackRequest(id1,num);
	    status="your request status  is " + s;
	    
	}
	catch(Exception e){
		e.printStackTrace();
		status=e.getMessage();
	}
	return status;
}


public String reSet(){
	try{
	setFacilities("");
	setDescription("");
	setMessage("");
	setStatus("");
	allRequestIds=new ArrayList<>();
	ErrorRepositoryService src=Factory.createErrorRepositoryService();
	String s1=LoginBean.uName;
	int num=src.getAccountNumberForMatching(s1);
	allRequestIds=src.allRequestId(num);
	}
	catch(Exception e){
		e.getMessage();
	}
	return "ServiceRequest.xhtml?faces-redirect=true";
}
}
