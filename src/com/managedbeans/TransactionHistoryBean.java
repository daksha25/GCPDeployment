package com.managedbeans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.bean.TransactionHistory;
import com.resource.Factory;
import com.service.ErrorRepositoryService;
@ManagedBean
@SessionScoped
public class TransactionHistoryBean {
	private int transactionId;
	private Date transactionDate; 
	private String transactionType; 
	private Double amountTransferred;
	private int sourceAccountNo;
	private int targetAccountNo;
	private Timestamp transactionTimeStamp;
	private String targetAccounteeName;
	private String message;
	private String ifsc;
	private List<TransactionHistory> transactionList;
	private List<Integer> sourceAccNoList;
	private List<Integer> TargetAccNoList;
	private List<String> payeeList;
	private int number;
	private Date startDate;
	private Date endDate;
	private String transactionRemarks;
	private String type;
	private String PayeeDetails;
	
	
	
	public String getPayeeDetails() {
		return PayeeDetails;
	}
	public void setPayeeDetails(String payeeDetails) {
		PayeeDetails = payeeDetails;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public List<String> getPayeeList() {
		return payeeList;
	}
	public void setPayeeList(List<String> payeeList) {
		this.payeeList = payeeList;
	}
	public String getTransactionRemarks() {
		return transactionRemarks;
	}
	public void setTransactionRemarks(String transactionRemarks) {
		this.transactionRemarks = transactionRemarks;
	}
	public List<Integer> getTargetAccNoList() {
		return TargetAccNoList;
	}
	public void setTargetAccNoList(List<Integer> targetAccNoList) {
		TargetAccNoList = targetAccNoList;
	}
	public List<Integer> getSourceAccNoList() {
		return sourceAccNoList;
	}
	public void setSourceAccNoList(List<Integer> sourceAccNoList) {
		this.sourceAccNoList = sourceAccNoList;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public List<TransactionHistory> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<TransactionHistory> transactionList) {
		this.transactionList = transactionList;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTargetAccounteeName() {
		return targetAccounteeName;
	}
	public void setTargetAccounteeName(String targetAccounteeName) {
		this.targetAccounteeName = targetAccounteeName;
	}
	public int getSourceAccountNo() {
		return sourceAccountNo;
	}
	public void setSourceAccountNo(int sourceAccountNo) {
		this.sourceAccountNo = sourceAccountNo;
	}
	public int getTargetAccountNo() {
		return targetAccountNo;
	}
	public void setTargetAccountNo(int targetAccountNo) {
		this.targetAccountNo = targetAccountNo;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Double getAmountTransferred() {
		return amountTransferred;
	}
	public void setAmountTransferred(Double amountTransferred) {
		this.amountTransferred = amountTransferred;
	}
	public Timestamp getTransactionTimeStamp() {
		return transactionTimeStamp;
	}
	public void setTransactionTimeStamp(Timestamp transactionTimeStamp) {
		this.transactionTimeStamp = transactionTimeStamp;
	}
	
	
	public String populateAccountNoWithin(){
		try{
			sourceAccNoList=new ArrayList<Integer>();
			ErrorRepositoryService ers=Factory.createErrorRepositoryService();
			String s=LoginBean.uName;
			int num=ers.getAccountNumberForMatching(s);
			sourceAccNoList.add(num);
            payeeList =new ArrayList<>();
			payeeList=ers.allPayeeListWithin(num); 
		}
		catch(Exception e){
			e.printStackTrace();
			message=e.getMessage();
		}
		return "within bank transfer.xhtml?faces-redirect=true";
	}
	
	
	public String populateAccountNoOutside(){
		try{
			sourceAccNoList=new ArrayList<Integer>();
			ErrorRepositoryService ers=Factory.createErrorRepositoryService();
			String s=LoginBean.uName;
		    int num=ers.getAccountNumberForMatching(s);
			sourceAccNoList.add(num);
			payeeList =new ArrayList<>();
			payeeList=ers.allPayeeListOthers(num);
		}
		catch(Exception e){
			e.printStackTrace();
			message=e.getMessage();
		}
		return "Outside Fund Transfer.xhtml?faces-redirect=true";
	}
	
	public String ftWithinBank(){
		try{
		
		TransactionHistory th=new TransactionHistory();
		ErrorRepositoryService ers=Factory.createErrorRepositoryService();
		th.setSourceAccountNo(getSourceAccountNo());
		String payeeAccNameAndNumber=PayeeDetails;
		String arr[]=payeeAccNameAndNumber.split("-");
		String accHolderName=arr[0];
		String accountNumber=arr[1];
		th.setTargetAccounteeName(accHolderName);
		th.setTargetAccountNo(Integer.parseInt(accountNumber));
		th.setAmountTransferred(getAmountTransferred());
	    String s=""+getAmountTransferred();
	    String pattern="\\d*(\\.{0,1}\\d{0,2})";
	    boolean b=s.matches(pattern);
	    
	    if(getSourceAccountNo()==getTargetAccountNo()){
	        message="From Account and To Account can not be same";
	    }
	    
	    else if(getAmountTransferred()<=0){
	        message="Please enter valid amount.";
	    }
	    else if(b==false){
	    	message="In Transfer amount only two digits after decimal are allowed.";
	    }
	    else if(ers.validateAccountBalance(getAmountTransferred(), getSourceAccountNo())==false){
	        message="Insufficient balance!!!. You can not transfer money.";
	    }
	    else if(b==false){
	    	message="In Transfer amount Only two digits after decimal are allowed.";
	    }
	    else{
	    	message=ers.successfulTransaction(th);
	    }
	    number=1;
		
		
		}
		catch(Exception e){
			e.printStackTrace();
			message=e.getMessage();
		}
		return "";
	}
	
	public String ftoutsideBank(){
		try{
			boolean flag;
			
			TransactionHistory th=new TransactionHistory();
			String payeeAccNameAndNumber=PayeeDetails;
			String arr[]=payeeAccNameAndNumber.split("-");
			String accHolderName=arr[0];
			String accountNumber=arr[1];
			String ifscode=arr[2];
			ErrorRepositoryService ers=Factory.createErrorRepositoryService();
			th.setSourceAccountNo(getSourceAccountNo());
			th.setTargetAccounteeName(accHolderName);
			th.setTargetAccountNo(Integer.parseInt(accountNumber));
			th.setAmountTransferred(getAmountTransferred());
		    th.setIfsc(ifscode);
		    String s=""+getAmountTransferred();
		    String pattern="\\d*(\\.{0,1}\\d{0,2})";
		    boolean b=s.matches(pattern);
			flag=ers.validateSourceAccount(getSourceAccountNo());
			
		    if(getSourceAccountNo()==getTargetAccountNo()){
		        message="From Account and To Account can not be same";
		    }
		   else if(getAmountTransferred()<=0){
		        message="Please enter valid amount.";
		    }
		   else if(b==false){
		    	message="In Transfer amount only two digits after decimal are allowed.";
		    }
		   else if(ers.validateAccountBalance(getAmountTransferred(), getSourceAccountNo())==false){
		       message="Insufficient balance!!!. You can not transfer money.";
		    }
		    
		   else{
		    	message=ers.successfulTransactionOutsideBank(th);
		    }
		    number=2;
			
		}
			
			catch(Exception e){
				message=e.getMessage();
			}
			return "";
	}
	
	public String accountStatement(){
		try{
		transactionList=new ArrayList<TransactionHistory>();
		String s=LoginBean.uName;
		ErrorRepositoryService ers=Factory.createErrorRepositoryService();
		int num=ers.getAccountNumberForMatching(s);
		
		transactionList=ers.accountStatement(num);
		
		number=5;
		startDate=null;
		endDate=null;
		}
		catch(Exception e){
			message = e.getMessage();
		}
		return "Account Statement.xhtml?faces-redirect=true";
	}
	
	
	public String resetTransactionFields(){
		
		sourceAccountNo=0;
		targetAccountNo=0;
		amountTransferred=null;
	    message="";
		number=0;
		targetAccounteeName="";
		ifsc="";
		transactionRemarks="";
		return "Fund Transfer.xhtml?faces-redirect=true";
	}
	
	public String accountStatementSearch(){
		boolean flag;
		try{
			
		transactionList=new ArrayList<TransactionHistory>();
		TransactionHistory th=new TransactionHistory();
		Date date=new Date();
		th.setTargetAccountNo(targetAccountNo);
		th.setStartDate(startDate);
		th.setEndDate(endDate);
		if(getStartDate()==null || getEndDate()==null){
			message="Both Start Date and End Date are mandatory fields.";
			number=3;
		}
		else if(getStartDate().after(date) || getEndDate().after(date)){
			message="Both Start Date and End Date can not be greater than todays date.";
			number=3;
		}
		else if(getStartDate().after(getEndDate())){
			message="Entered End Date should be greater than Start Date.";
			number=3;
		}
		else{
		ErrorRepositoryService ers=Factory.createErrorRepositoryService();
		String s=LoginBean.uName;
		int num=ers.getAccountNumberForMatching(s);
		transactionList=ers.search(th,num);
		
		if(transactionList.size()==0){
			message="No Data Found for these enteries!!!";
			number=3;
		}
		
		else {
			transactionList=ers.search(th,num);
			number=4;
		}
		
		}
		}
		catch(Exception e){
			message=e.getMessage();
		}
		return message;
	}
	
	public String searchReset(){
		startDate=null;
		endDate=null;
		return "Account Statement.xhtml";
	}
	
	public String applyTypefilter(){
		try {
			List<TransactionHistory> l1=new ArrayList<>();
			String s=LoginBean.uName;
			ErrorRepositoryService ers=Factory.createErrorRepositoryService();
			int num=ers.getAccountNumberForMatching(s);
			l1=ers.accountStatement(num);
			if(l1.size()==0){
				message="No Data Found for selected filter.";
			}
			else{
			transactionList =new ArrayList<>();
			if(getType().equals("Dr")){
			for(TransactionHistory th:l1){
				if(th.getSourceAccountNo()==num){
					transactionList.add(th);
				}}
			
			}
			else if(getType().equals("Cr")){
				for(TransactionHistory th:l1){
					 if(th.getTargetAccountNo()==num){
						transactionList.add(th);
					}
			}
				
				
			}
			else if(getType().equals("*")){
				for(TransactionHistory th:l1){
					transactionList.add(th);
				}
			}number=6;
			}	
		} catch (Exception e) {
			e.printStackTrace();
			message=e.getMessage();
		}
		
		
		return "";
		
	}




	  
}
