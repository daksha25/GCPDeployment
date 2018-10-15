package com.managedbeans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.bean.AddPayee;
import com.resource.Factory;
import com.service.ErrorRepositoryService;

@ManagedBean
@SessionScoped
public class AddPayeeBean {
       private String payeeName;
       private Integer payeeAccNum;
       private String payeeNickName;
       private String ifsc;
       private String message;
       private int number1;
       private int parentAccNo;
       
       
   	public int getParentAccNo() {
   		return parentAccNo;
   	}
   	public void setParentAccNo(int parentAccNo) {
   		this.parentAccNo = parentAccNo;
   	}
    public int getNumber1() {
		return number1;
	}
	public void setNumber1(int number1) {
		this.number1 = number1;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public Integer getPayeeAccNum() {
		return payeeAccNum;
	}
	public void setPayeeAccNum(Integer payeeAccNum) {
		this.payeeAccNum = payeeAccNum;
	}
	public String getPayeeNickName() {
		return payeeNickName;
	}
	public void setPayeeNickName(String payeeNickName) {
		this.payeeNickName = payeeNickName;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	
	public String navigateAaddPayeewithin(){
		payeeAccNum=null;
		payeeName="";
		payeeNickName="";
		message="";
		number1=1;
		return "Add Payee.xhtml?faces-redirect=true";
	}
	
	public String navigateAaddPayeeother(){
		payeeAccNum=null;
		payeeName="";
		payeeNickName="";
		ifsc="";
		message="";
		number1=2;
		return "Add Payee.xhtml?faces-redirect=true";
	}
     
	public String addPayeewithin(){
		try{
		AddPayee ap=new AddPayee();
		ErrorRepositoryService ers=Factory.createErrorRepositoryService();
		ap.setPayeeName(getPayeeName());
		ap.setPayeeAccNum(getPayeeAccNum());
		ap.setPayeeNickName(getPayeeNickName());
		String username=LoginBean.uName;
		int accno=ers.getAccountNumberForMatching(username);
		ap.setParentAccNo(accno);
		String accInString=""+getPayeeAccNum();
		if(accInString.length()<8 || accInString.length()>8){
			message="Account no length is 8 digits";
		}
		
		else{
		
		int number=ers.addPayeeWithin(ap);
		if(number==1){
			message="You are not a registered Bank customer. Please open account in nearest branch";
		}
		else if(number==2){
			message="Please enter same name used during opening bank account.";
		}
		else if(number==3){
			message="Payee has been added successfully.";
		}
		}
		}
		catch(Exception e){
			e.printStackTrace();
			message=e.getMessage();
		}
		return message;
	}
       
	
	public String addPayeeOthersBnak(){
		try {
			AddPayee ap1=new AddPayee();
			ErrorRepositoryService ers=Factory.createErrorRepositoryService();
			ap1.setPayeeName(getPayeeName());
			ap1.setPayeeAccNum(getPayeeAccNum());
			ap1.setPayeeNickName(getPayeeNickName());
			ap1.setIfsc(getIfsc());
			String username=LoginBean.uName;
			int accno=ers.getAccountNumberForMatching(username);
			ap1.setParentAccNo(accno);
			String accInString=""+getPayeeAccNum();
			if(accInString.length()<8 || accInString.length()>8){
				message="Account no length is 8 digits";
			}
			else if(ifsc.equals("")){
				message="IFSC is mandatory.";
			}
			else if(ifsc.length()<11 || ifsc.length()>11 ){
				message="IFSC length is 11 digits";
			}
			else{
			
			ers.addPayeeOthersBnak(ap1);
			message="Payee for other bank has been added successfully.";
		}
		 }
		
		catch (Exception e) {
			e.printStackTrace();
			message=e.getMessage();
		}
		return message;
	}
}
