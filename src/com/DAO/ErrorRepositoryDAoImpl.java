package com.DAO;


import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.AddPayee;
import com.bean.Contact;
import com.bean.Login;
import com.bean.ServiceRequest;
import com.bean.TransactionHistory;
import com.bean.accountInfo;
import com.entity.AddPayeeEntity;
import com.entity.ContactEntity;
import com.entity.LoginEntity;
import com.entity.ServiceRequestEntity;
import com.entity.TransactionHistoryEntity;
import com.entity.accountInfoEntity;
import com.resource.Factory;
import com.resource.HibernateUtility;
import com.service.ErrorRepositoryService;



public class ErrorRepositoryDAoImpl implements ErrorRepositoryDAo  {
	SessionFactory sessionFactory=HibernateUtility.createSessionFactory();
    Session session=sessionFactory.openSession();
   public static  int counter=0;

// DAO method for Login functionality
    public int varifyData(Login login) throws Exception
    {
		int number=0;
		
		try 
		{
			LoginEntity loginEntity = new LoginEntity();
			String uid=login.getUname().toLowerCase();
			String password=login.getPassword();
			loginEntity = (LoginEntity) session.get(LoginEntity.class,uid);
			if(loginEntity==null){
			    number=1;		
			}
			else if(loginEntity.getStatus().equals("locked")){
				
				number=2;
				
				
			}
			
			
			else if(loginEntity.getUname().equals(uid) && !loginEntity.getPassword().equals(password)){
				number=4;
				counter+=1;
				
				if(counter>2){
					LoginEntity loginEntity1=(LoginEntity)session.get(LoginEntity.class,uid);
					loginEntity1.setStatus("locked");
					session.beginTransaction();
					session.save(loginEntity1);
					session.getTransaction().commit();
					number=5;
					
				}
			}
		
			else if(loginEntity.getUname().equals(uid) && loginEntity.getPassword().equals(password) && loginEntity.getStatus().equals("unlocked"))
			{   int count=0;
				counter=0;
				number=3;
				
			}
			
			
		} 
		catch (Exception exception) 
		    {
			
			throw exception;
			} 
        return number;
	}
    
    public int getAccountNumberForMatching(String username) throws Exception{
    	int num=0;
    	try {
    		
    		List<Integer> accountNo=new ArrayList<>();
    		Query query = session.createQuery("select e.accountNo From  accountInfoEntity e where e.userName=:uname");
  			query.setParameter("uname",username);
  			accountNo= query.list();
    		num= accountNo.get(0);
    		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    	return num;
    }
	
    public boolean validateSourceAccount(int sourceAccount) throws Exception{
    	boolean flag=false;
    	try{
    		List<Integer> targetAccountNo=new ArrayList<>();
    		Query query = session.createQuery("select e.accountNo From  accountInfoEntity e where e.accountNo=:accNo");
  			query.setParameter("accNo",sourceAccount);
  			targetAccountNo= query.list();
  			if(targetAccountNo.size()>0){
  				flag=true;
  			}
  			else{
  				flag=false;
  			}		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		throw e;
    		
    	}
    	finally{
    		
    	}
    	return flag;
    }
    
    public boolean validateTargetAccount(int targetAccount) throws Exception{
    	boolean flag=false;
    	try{
    		List<Integer> targetAccountNo=new ArrayList<>();
    		Query query = session.createQuery("select e.accountNo From accountInfoEntity e where accountNo=:accNo");
  			query.setParameter("accNo",targetAccount);
  			targetAccountNo= query.list();
  			if(targetAccountNo.size()>0){
  				flag=true;
  			}
  			else{
  				flag=false;
  			}		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    	finally{
    		
    	}
    	return flag;
    }
    
    public boolean validateTargetAccounteeName(int targetAccount,String accounteeName) throws Exception{
    	boolean flag=false;
    	try{
    		List<Integer> targetAccountNo=new ArrayList<>();
    		Query query = session.createQuery("select e.accountNo From accountInfoEntity e where accountNo=:accNo and e.name=:accounteeName");
  			query.setParameter("accNo",targetAccount);
  			query.setParameter("accounteeName",accounteeName);
  			targetAccountNo= query.list();
  			if(targetAccountNo.size()>0){
  				flag=true;
  			}
  			else{
  				flag=false;
  			}		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    	finally{
    		
    	}
    	return flag;
    }
    
    
    public boolean validateAccountBalance(double amountTransfer,int accNo) throws Exception{
    	boolean flag=false;
    	try{
    		List<Double> balance=new ArrayList<>();
    		Query query = session.createQuery("select e.accountBalance From accountInfoEntity e where accountNo=:accNo");
  			query.setParameter("accNo",accNo);
  			balance= query.list();
  			if(balance.size()>0){
  				for(Double b:balance){
  				if(amountTransfer>0 && amountTransfer<b){
  					flag=true;	
  				}
  				else{
  					flag=false;
  				}
  				}
  				
  			}
  			else{
  				flag=false;
  			}		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    	finally{
    		
    	}
    	return flag;
    }
    
    
    public String successfulTransaction(TransactionHistory th) throws Exception{
    	int id=0;
    	double remainingBalance=0.0;
    	try {
    		accountInfoEntity aif=new accountInfoEntity();
    	    aif=(accountInfoEntity) session.get(accountInfoEntity.class,th.getSourceAccountNo());
    	    remainingBalance =aif.getAccountBalance()-th.getAmountTransferred();
    	    System.out.println(remainingBalance+"==========afgdfg");
    	    DecimalFormat df = new DecimalFormat("#.##");
    	    String dx=df.format(remainingBalance);
    	    remainingBalance=Double.valueOf(dx);
    	    System.out.println(remainingBalance);
    	    session.beginTransaction(); 
    	    aif.setAccountBalance(remainingBalance);
    	    session.getTransaction().commit();
    	    
    	    
    	    accountInfoEntity aif1=new accountInfoEntity();
    	    aif1=(accountInfoEntity) session.get(accountInfoEntity.class,th.getTargetAccountNo());
    	    Double increasedBalance =aif1.getAccountBalance() + th.getAmountTransferred();
    	    DecimalFormat df1 = new DecimalFormat("#.##");
    	    String dx1=df1.format(increasedBalance);
    	    increasedBalance=Double.valueOf(dx1);
    	    System.out.println(increasedBalance);
    	    session.beginTransaction(); 
    	    aif1.setAccountBalance(increasedBalance);
    	    session.getTransaction().commit();
    	    
    	    
    	    
    	    Timestamp ts=new Timestamp(System.currentTimeMillis());
    	    Calendar c=Calendar.getInstance();
    	    Date d=c.getTime();
    	    TransactionHistoryEntity the=new TransactionHistoryEntity();
    	    the.setSourceAccountNo(th.getSourceAccountNo());
    	    the.setTargetAccountNo(th.getTargetAccountNo());
    	    the.setTransactionTimeStamp(ts);
    	    the.setIfsc("INTERNAL");
    	    if(the.getSourceAccountNo()==aif.getAccountNo()){
                the.setType("Dr");
    	    }  

    	    the.setAmountTransferred(th.getAmountTransferred());
    	    the.setTransactionType("e-Transfer");
            the.setTransactionDate(d);
    	    session.beginTransaction();
    	    
    	     id=(Integer)session.save(the);
    	    session.getTransaction().commit();
    	    
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    	
    	
    	return "Transaction Successfull !!!  Transaction id is " +id+". Amount transferred is "+th.getAmountTransferred() +". Remaining Balance is " + remainingBalance;
    	}
    
    
    public String successfulTransactionOutsideBank(TransactionHistory th) throws Exception{
    	int id=0;
    	double remainingBalance=0.0;
    	try{
    		
    	accountInfoEntity aif=new accountInfoEntity();
	    aif=(accountInfoEntity) session.get(accountInfoEntity.class,th.getSourceAccountNo());
	    remainingBalance =aif.getAccountBalance()-th.getAmountTransferred();
	    DecimalFormat df2 = new DecimalFormat("#.##");
	    String dx2=df2.format(remainingBalance);
	    remainingBalance=Double.valueOf(dx2);
	    System.out.println(remainingBalance);
	    session.beginTransaction(); 
	    aif.setAccountBalance(remainingBalance);
	    session.getTransaction().commit();
	    
	    
	    Timestamp ts=new Timestamp(System.currentTimeMillis());
	    Calendar c=Calendar.getInstance();
	    Date d=c.getTime();
	    TransactionHistoryEntity the=new TransactionHistoryEntity();
	    the.setSourceAccountNo(th.getSourceAccountNo());
	    the.setTargetAccountNo(th.getTargetAccountNo());
	    the.setIfsc(th.getIfsc());
	    the.setAmountTransferred(th.getAmountTransferred());
	    the.setType("Dr"); 
	    the.setTransactionDate(d);
	    the.setTransactionType("e-Transfer");
	    the.setTransactionTimeStamp(ts);
	    session.beginTransaction();
	    id=(Integer)session.save(the);
	    session.getTransaction().commit();
	    
	} catch (Exception e) {
		e.printStackTrace();
		throw e;
	}
    	
	return "Transaction Successfull!!! Transaction id is " +id+".Amount transferred is "+th.getAmountTransferred() +".Remaining Balance is " + remainingBalance;
    }
    
    
    
    
    public List<TransactionHistory> accountStatement(int number) throws Exception{
    	List<TransactionHistory> transactionHistoryList=new ArrayList<TransactionHistory>();
	   	 List<TransactionHistoryEntity> traEntityHistoryList=new ArrayList<TransactionHistoryEntity>();
	   	 try
	   	 {  
	   		session=sessionFactory.openSession();
	   		Query query = session.createQuery("select d From TransactionHistoryEntity d where d.sourceAccountNo=:number or d.targetAccountNo=:number1 order by d.transactionDate desc");
	   		query.setParameter("number",number);
	   		query.setParameter("number1",number);
	   		traEntityHistoryList=query.list();
	   		
	   		
	   		for( TransactionHistoryEntity the : traEntityHistoryList)
	   		{	
	   			
	   			TransactionHistory th=new TransactionHistory();
	   			th.setTransactionId(the.getTransactionId());
	   			th.setSourceAccountNo(the.getSourceAccountNo());
	   			th.setTargetAccountNo(the.getTargetAccountNo());
	   			th.setAmountTransferred(the.getAmountTransferred());
                th.setType(the.getType());
                if(the.getType().equals("Dr") && the.getTargetAccountNo()==number)
                {
                       th.setType("Cr");
                }

	   			th.setTransactionTimeStamp(the.getTransactionTimeStamp());
	   			th.setTransactionDate(the.getTransactionDate());
	   	        
	   			transactionHistoryList.add(th);
	   			
	   			
	   		}
	   	
	   		
	   	 }
	   	 catch(Exception e)
	   	 {
	   		e.printStackTrace();
	   		throw e;
	     }
	   	 
	   	 
	   	 
	   	 return transactionHistoryList;
    }
    
   
    public List<TransactionHistory> search(TransactionHistory th,int number) throws Exception{
    	List<TransactionHistory> list1=new ArrayList<>();
    	List<TransactionHistoryEntity> list=new ArrayList<>();
   
        try {
        	TransactionHistoryEntity tre=new TransactionHistoryEntity();
        	
        	Date startDate =th.getStartDate();
        	Date endDate =th.getEndDate();
			 Calendar c=Calendar.getInstance();
			 c.setTime(endDate);
			 c.add(Calendar.DATE,1);
			 Date finalDate=c.getTime(); 
        	
        	
        	String hqlQuerry="select d From TransactionHistoryEntity d where d.transactionDate>=:startDate and d.transactionDate <=:endDate and (d.sourceAccountNo=:number or d.targetAccountNo=:number1) order by d.transactionDate desc";
        	
        	
        	Query query = session.createQuery(hqlQuerry);
            query.setParameter("startDate",startDate);
            query.setParameter("endDate",finalDate);
            query.setParameter("number",number);
	   		query.setParameter("number1",number);
       		list=query.list();
       	   
       		for( TransactionHistoryEntity the : list)
       		{	TransactionHistory th1=new TransactionHistory();
   			th1.setTransactionId(the.getTransactionId());
   			th1.setSourceAccountNo(the.getSourceAccountNo());
   			th1.setTargetAccountNo(the.getTargetAccountNo());
   			th1.setAmountTransferred(the.getAmountTransferred());
   		    th1.setType(the.getType());
            if(the.getType().equals("Dr") && the.getTargetAccountNo()==number)
            {
                th1.setType("Cr");
            }
            
   			th1.setTransactionTimeStamp(the.getTransactionTimeStamp());
   			th1.setTransactionDate(the.getTransactionDate());
   			list1.add(th1);
       		}
       	
        	
        }
        
        catch (Exception e) {
        	e.printStackTrace();
			throw e;
		}
        
        finally{
    		if(session.isOpen()|| session!=null)
      		 {
   	 				session.close();
      	     }
    	}return list1;
    }
    
    
    
    public List<Integer> allAccountList() throws Exception{
    	List<Integer> list1=new ArrayList<>();
    	try{
    	String hqlQuerry="select d.accountNo From accountInfoEntity d";
    	Query query = session.createQuery(hqlQuerry);
        list1=query.list();
       }
    	catch(Exception e){
    		throw e;
    	}
    	return list1;
    }
    
    public List<accountInfo> getPerticularAccInfo(String uname) throws Exception{
    	List<accountInfo> list1=new ArrayList<>();
    	List<accountInfoEntity> list2=new ArrayList<>();
    	try{
    	
    	String hqlQuerry="select d From accountInfoEntity d where d.userName=:username";
    	Query query = session.createQuery(hqlQuerry);
    	query.setParameter("username", uname);
    	list2=query.list();
        for( accountInfoEntity ae : list2)
   		{	accountInfo a=new accountInfo();
   			a.setAccountNo(ae.getAccountNo());
   			a.setAccountBalance(ae.getAccountBalance());
   			a.setAccountType(ae.getAccountType());
   			a.setName(ae.getName());
   			
   			list1.add(a);
   		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    	return list1;
    }
		    
		    public List<Contact> contactDAO() throws Exception{
		   	 
		   	 List<Contact> contactList=new ArrayList<>();
		   	 List<ContactEntity> contactEnList=new ArrayList<>();
		   	 try
		   	 {  
		   		session=sessionFactory.openSession();
		   		Query query = session.createQuery("select d From ContactEntity d");
		   		contactEnList=query.list();
		   		
		   		
		   		for( ContactEntity c : contactEnList)
		   		{	Contact ct=new Contact();
		   			
		   			ct.setName(c.getName());
		   			ct.setEmail_id(c.getEmail_id());
		   			ct.setRole(c.getRole());
		   		
		   			contactList.add(ct);
		   		}
		   	
		   		
		   	 }
		   	 catch(Exception e)
		   	 {
		   		throw e;
		     }
		   	 
		   	 finally
		   	 {
		   		 if(session.isOpen()|| session!=null)
		   		 {
			 				session.close();
		   	     }
		   	 
		    }
		   	 
		   	 return contactList;
		}
		    
    
		    
		    public int addPayeeWithin(AddPayee ap) throws Exception{
		    	int number=0;
		    	try {
					if(validateSourceAccount(ap.getPayeeAccNum())==false){
						number=1;
					}
					else if(validateTargetAccounteeName(ap.getPayeeAccNum(),ap.getPayeeName())==false){
						number=2;
					}
					else{
						AddPayeeEntity ape=new AddPayeeEntity();
						ape.setPayeeAccNum(ap.getPayeeAccNum());
						ape.setPayeeName(ap.getPayeeName());
						ape.setPayeeNickName(ap.getPayeeNickName());
						ape.setParentAccNo(ap.getParentAccNo());
						ape.setIfsc(null);
						session.beginTransaction();
						session.save(ape);
						session.getTransaction().commit();
						number=3;
					}
		    		
				} 
		    	catch (Exception e) {
		    		e.printStackTrace();
					throw e;
				}
		    	finally{
		    		
		    	}
		    	return number;
		    }
            
		    
		    public String addPayeeOthersBnak(AddPayee ap) throws Exception{
		    	try{
		    		
		    	AddPayeeEntity ape=new AddPayeeEntity();
		    	
				ape.setPayeeAccNum(ap.getPayeeAccNum());
				ape.setPayeeName(ap.getPayeeName());
				ape.setPayeeNickName(ap.getPayeeNickName());
				ape.setIfsc(ap.getIfsc());
				ape.setParentAccNo(ap.getParentAccNo());
				session.beginTransaction();
				session.save(ape);
				session.getTransaction().commit();
				
		    	}
		    	catch(Exception e){
		    		e.printStackTrace();
		    		throw e;
		    	}
		    	return "";
		    }
		    
		    public List<String> allPayeeListWithin(int accno) throws Exception{
		    	List<String> list1=new ArrayList<>();
		    	List<AddPayeeEntity> list2=new ArrayList<>();
		    	try{
		    	String hqlQuerry="select d From AddPayeeEntity d where d.ifsc is null and d.parentAccNo=:accNO";
		    	Query query = session.createQuery(hqlQuerry);
		    	query.setParameter("accNO", accno);
		        list2=query.list();
		        for(AddPayeeEntity ae:list2){
		        	String str=ae.getPayeeName() + "-" + ae.getPayeeAccNum();
		        	list1.add(str);
		        }
		    	}
		    	catch(Exception e){
		    		e.printStackTrace();
		    		throw e;
		    	}
		    	return list1;
		    }
		    
		    public List<String> allPayeeListOthers(int accno) throws Exception{
		    	List<String> list1=new ArrayList<>();
		    	List<AddPayeeEntity> list2=new ArrayList<>();
		    	try{
		    	String hqlQuerry="select d From AddPayeeEntity d where d.ifsc is not null and d.parentAccNo=:accNO";
		    	Query query = session.createQuery(hqlQuerry);
		    	query.setParameter("accNO", accno);
		        list2=query.list();
		        for(AddPayeeEntity ae:list2){
		        	String str=ae.getPayeeName() + "-" + ae.getPayeeAccNum() + "-" + ae.getIfsc();
		        	list1.add(str);
		        }
		    	}
		    	catch(Exception e){
		    		e.printStackTrace();
		    		throw e;
		    	}
		    	return list1;
		    }

		    public int signupverify(accountInfo ai) throws Exception {
				int signupNum=0;
				try{
					accountInfoEntity aie=(accountInfoEntity)session.get(accountInfoEntity.class, ai.getAccountNo());
					if(aie==null){
						signupNum=1;
					}
					else if(aie.getName().equals(ai.getName())==false){
						signupNum=2;
					}
					else if(aie.getUserName()!=null){
						signupNum=3;
					}
					else{
						signupNum=4;
					}
				   }
				
				catch (Exception e) {
					e.printStackTrace();
					e.getMessage();
				} 
			   	return signupNum;
			}

			
			public void RegisterWithbank(Login l) throws Exception {
				try{
				LoginEntity loginEntity1=new LoginEntity();
				accountInfoEntity aie=new accountInfoEntity();
				loginEntity1.setUname(l.getUname());
				loginEntity1.setPassword(l.getPassword());
				loginEntity1.setStatus("unlocked");
				loginEntity1.setSecurityQuestion(l.getSecurityQuestion());
				loginEntity1.setSecurityAnswer(l.getSecurityAnswer());
				loginEntity1.setAccounNumber(l.getAccounNumber());
				
			    System.out.println(l.getAccounNumber());
				aie=(accountInfoEntity)session.get(accountInfoEntity.class,l.getAccounNumber());
				session.beginTransaction();
				session.save(loginEntity1);
				session.getTransaction().commit();
			    System.out.println("hi");
				session.beginTransaction();
				aie.setAccountNo(l.getAccounNumber());
				aie.setUserName(l.getUname());
			    session.getTransaction().commit();
			    
				}
				catch (Exception e) {
					e.printStackTrace();
					e.getMessage();
				}
				
			}
			public int createRequestDao(ServiceRequest sr)throws Exception{
		    	int id=0;
		    	try{
		    		//session=sessionFactory.openSession();
		    		ServiceRequestEntity se=new ServiceRequestEntity();
		    		
		    		se.setFacilities(sr.getFacilities());
		    		se.setDescription(sr.getDescription());
		    		se.setStatus(sr.getStatus());
		    		se.setParentAccNo(sr.getParentAccNo());
		    		session.getTransaction().begin();
		    		id=(int)session.save(se);
		    		session.getTransaction().commit();
		    	}
		    	catch(Exception e){
		    		e.printStackTrace();
		    		throw e;
		    	}
		    	finally{
		    		if(session.isOpen()|| session!=null)
		      		 {
		   	 				session.close();
		      	     }
		    	
		    }
		    	return id;
		    }
		    
			public List<String> allRequestId(int accnum)throws Exception{
				List<String> list1=new ArrayList<>();
				List<ServiceRequestEntity> list2=new ArrayList<>();
		    	try{
		    	String hqlQuerry="select d From ServiceRequestEntity d where d.parentAccNo=:accnum";
		    	Query query = session.createQuery(hqlQuerry);
		    	query.setParameter("accnum", accnum);
		        list2=query.list();
		        for(ServiceRequestEntity sre:list2){
		        	String ids="RQ" + sre.getRequestId();
		        	list1.add(ids);
		        }return list1;
		    	}
		    	
		    	catch(Exception e){
		    		throw e;
		    	}
			}
			
			
			
		    public String trackReuestDao(int trackingId,int accnum) throws Exception{
		    	String status="";
		    	try{
		    		session=sessionFactory.openSession();
		    		
		    		String hqlQuerry="select s.Status From ServiceRequestEntity s where s.requestId=:trackingId and parentAccNo=:accnum";
		    		Query query = session.createQuery(hqlQuerry);
		    		query.setParameter("trackingId", trackingId);
		    		query.setParameter("accnum", accnum);
		        	String s=(String) query.uniqueResult();
		            if(s==(null)){
		            	status="  'No result found for this RequestId.' ";
		            }
		            else{
		            status=s;
		            }

		    	}
		    	catch(Exception e){
		    		e.printStackTrace();
		    		throw e;
		    	}
		    	finally{
		    		if(session.isOpen()|| session!=null)
		      		 {
		   	 				session.close();
		      	     }
		    	
		    }
		    	return status;
		        	
		    }
		    
}

