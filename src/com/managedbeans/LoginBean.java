package com.managedbeans;



import com.bean.Login;
import com.resource.Factory;
import com.service.ErrorRepositoryService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//ManagedBean class for Logging in
@ManagedBean
@SessionScoped


public class LoginBean {
          public static String uName;
          private String password;
          private String message;
          private String address;
          private int  mobileNumber;
          private int zipCode;
          private boolean flag;
          private String securityQuestion;
          private String securityAnswer;
          public static int accounNumber;
          private String confirmPassword;
          
          
          public int getAccounNumber() {
  			return accounNumber;
  		}

  		public void setAccounNumber(int accounNumber) {
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
  		
        public String getConfirmPassword() {
  			return confirmPassword;
  		}

  		public void setConfirmPassword(String confirmPassword) {
  			this.confirmPassword = confirmPassword;
  		}
	    public boolean isFlag() {
			return flag;
		}

		public void setFlag(boolean flag) {
			this.flag = flag;
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

	public String getMessage() {
			return message;
		}

	public void setMessage(String message) {
			this.message = message;
		}

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
    
	public String varifyData(){
	
		try{
		Login login=new Login();
		login.setPassword(getPassword());
		login.setUname(getUname());
		ErrorRepositoryService ers=Factory.createErrorRepositoryService();
		int number=ers.varifyData(login);
		if(number==3){
			message="Home.xhtml?faces-redirect=true";
			flag=false;
		}
		else if(number==1){
			message=" Username is not registered. Please visit Branch Office.";
			flag=true;
		}
		else if(number==2){
		    message="You have reached maximum incorrect login attempts. Your account has been locked. Please contact nearest Branch";
		    flag=true;
		}
		else if(number==4){
			message="Password is invalid. Please try with valid one.";
			flag=true;
		}
		
		else if(number==5){
			message="You have reached maximum incorrect login attempts. Your account has been locked. Please contact nearest Branch";
			flag=true;
		}
		
		}
	catch(Exception e){
		message=e.getMessage();
	}
		return message;	
}
	public String reSet(){
		setUname(" ");
		setPassword(" ");
		setMessage(" ");
		flag=false;
		return "login";
	}
	
public String RegisterWithbank(){
		
    	try{
    		Login login =new Login();
    		login.setUname(getUname());
    		if(password.length()<8){
    			message="Please enter valid password.Password should be greater than 7 characters.";
    		}
    		else if(getSecurityQuestion().equals("") || getSecurityAnswer().equals("")){
    			message="Security Question and Answer both fields are mandatory";
    		}
    		else if(uName.length()>10){
    			message="username should be less than or equal to 10 character.";
    		}
    		else if((password.equals(confirmPassword))){
    			login.setSecurityQuestion(getSecurityQuestion());
    			login.setSecurityAnswer(getSecurityAnswer());
	    		login.setPassword(getPassword());
	    		login.setAccounNumber(accounNumber);
	    		ErrorRepositoryService ers=Factory.createErrorRepositoryService();
	    		ers.RegisterWithbank(login);
	    		message="Congratulations!!Welcome to world of NetBanking.You are successfully registered.";
    		}
    		else{
    			message="Password and confirm password should be same.";
    		}
    		
    	}catch (Exception e) {
			
    		message=e.getMessage();
    		
		}
    	return message;
   
    }
	
	  public String signUpButton(){
		  uName="";
		  password="";
		  message="";
		  return "signup.jsp?faces-redirect=true";
	  }
	}
