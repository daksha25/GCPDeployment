package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
// Login entity class which is mapped with table name Login
@Entity
@Table(name="customerDetails")

public class LoginEntity {
	@Id
	@Column(name="userName")
	private String uName;
	@Column(nullable=false)
    private String password;
	//private String message;
    //private String address;
    private String status;
   // private int  mobileNumber;
    //private int zipCode;
    private String securityQuestion;
    private String securityAnswer;
    @Column(name="accountNo")
    private Integer accounNumber;
    
    
    
    public Integer getAccounNumber() {
		return accounNumber;
	}

	public void setAccounNumber(Integer accounNumber) {
		this.accounNumber = accounNumber;
	}
    
    public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public int getMobileNumber() {
//		return mobileNumber;
//	}
//
//	public void setMobileNumber(int mobileNumber) {
//		this.mobileNumber = mobileNumber;
//	}
//
//	public int getZipCode() {
//		return zipCode;
//	}

//	public void setZipCode(int zipCode) {
//		this.zipCode = zipCode;
//	}

	public String getUname() {
		return uName;
    }

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
	  return password;
	}
	
	public void setUname(String uname) {
		uName = uname;
	}  
}
