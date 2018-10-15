package com.managedbeans;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.bean.accountInfo;
import com.resource.Factory;
import com.service.ErrorRepositoryService;
@ManagedBean
@SessionScoped
public class accountInfoBeans {
	private Integer accountNo;
	private String name; 
	private double accountBalance;
	private Date dateOfOpening;
	private String accountStatus;
	private String  accountType;
	private List<accountInfo> aeList;
	private boolean flag;
	private int number;
	private String message;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public List<accountInfo> getAeList() {
		return aeList;
	}
	public void setAeList(List<accountInfo> aeList) {
		this.aeList = aeList;
	}
	public Integer getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Date getDateOfOpening() {
		return dateOfOpening;
	}
	public void setDateOfOpening(Date dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	} 
	
    public String getPerticularAccInfo(){
    	try {
    	
			String s=LoginBean.uName;
		    aeList=new ArrayList<>();
			ErrorRepositoryService ers=Factory.createErrorRepositoryService();
			aeList=ers.getPerticularAccInfo(s);
			flag=true;
			number=2;
		} catch (Exception e) {
			
		}
    	return "Home.xhtml?faces-redirect=true";
    }

    public String logout(){
    	LoginBean.uName="";
    	number=1;
    	return "login.jsp?faces-redirect=true";
    }

    public String signupverify(){
    	try{
    		
    	accountInfo ai=new accountInfo();
    	ai.setAccountNo(getAccountNo());
    	LoginBean.accounNumber=getAccountNo();
    	ai.setName(getName());
    	ErrorRepositoryService ers=Factory.createErrorRepositoryService();
    	int num=ers.signupverify(ai);
    	if(num==1){
    		message="Please enter valid account number.";
    	}else if(num==2){
    		message="Please enter valid name.";
    	}else if(num==3){
    		message="You already have net banking facility.Login with correct credentials.";
    	}
    	else if(num==4){
    		message="First step of verification is done.Now you can create username & password.";
    		flag=true;
	}
    	
    	}catch (Exception e) {
			
		}
    	return message;
    }
    
    public String loginLinkSignup(){
    	message="";
    	flag=false;
    	return "login.jsp?faces-redirect=true";
    }
}
