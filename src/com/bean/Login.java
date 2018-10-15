package com.bean;
//Bean class for Login functionality
public class Login {
	private String Uname;
    private String Password;
    private String message;
    private String address;
    private int  mobileNumber;
    private int zipCode; 
    private String securityQuestion;
    private String securityAnswer;
    private int accounNumber;
    
    
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

	public int getAccounNumber() {
		return accounNumber;
	}

	public void setAccounNumber(int accounNumber) {
		this.accounNumber = accounNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getUname() {
		return Uname;
    }

	public void setPassword(String password) {
		this.Password = password;
	}
	
	public String getPassword() {
	  return Password;
	}
	
	public void setUname(String uname) {
	  Uname = uname;
	}
	
	}
