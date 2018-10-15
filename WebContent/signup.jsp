<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>signup</title>
<script type="text/javascript">
          history.forward();
 </script>
 <link href="style.css" media="screen" rel="stylesheet">
</head>

<body class="respBgImageSignUp">
<f:view>
     <div style="float:up; height:36%;width:100%;">
				<div style="height:64%; width:100%;background-color:#0000cc;border:#004d66;border-style:solid;">

           			<center>
						<h:graphicImage value="Logo_for_header.png" height="30%" width="28%"></h:graphicImage>

          			</center>
				</div>
		 </div>
<h:form id="form_signupVerify">
<h:commandLink id="loginsignup" value="Click here to Login" action="#{accountInfoBeans.loginLinkSignup}" style="position:absolute;right:1%;top:17%;font-size:1.5vw"></h:commandLink>    
    <center>
    <h1 id="headings">Sign Up</h1>
    </center>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <b><h:outputText id="Process1" value="Step:1 Validation of Account Details" style="font-size:1.5vw"></h:outputText></b>
    <center>
    <h:panelGrid  id="signupverify" columns="2"  border="0">
    	 <h:outputText id="accountNo" value="Account Number"></h:outputText>
         <h:inputText id="accountNoinput" value="#{accountInfoBeans.accountNo}" disabled="#{accountInfoBeans.flag eq true}" maxlength="9"></h:inputText>
	     <h:outputText id="nameinputText"  value="Account Holder Name"></h:outputText>    
         <h:inputText id="nameinput" value="#{accountInfoBeans.name}" maxlength="15" disabled="#{accountInfoBeans.flag eq true}"></h:inputText>
    </h:panelGrid>
    <br>
    <br>
    
	  <h:commandButton id="nextbtn" value="verify" action="#{accountInfoBeans.signupverify}" type="submit" styleClass="buttonErrorRepository" style="background:#3D7AC3;border: #3D7AC3" disabled="#{accountInfoBeans.flag eq true}"></h:commandButton>&nbsp;&nbsp;<br>
	  <h:outputText id="verifyFailureMessage" value="#{accountInfoBeans.message}" rendered="#{accountInfoBeans.flag eq false}"></h:outputText>
	  <h:outputText id="verifySuccessMessage" value="#{accountInfoBeans.message}" rendered="#{accountInfoBeans.flag eq true}"></h:outputText>
    </center>
    
    
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <b><h:outputText id="Process2" value="Step:2 Personal information" style="font-size:1.5vw"></h:outputText></b>
     <center>
     <h:panelGrid  id="signupregister" columns="2"  border="0">
	     <h:outputText id="userName"  value="User Name:"></h:outputText>    
         <h:inputText id="Usernameinput" value="#{loginBean.uname}" maxlength="15" disabled="#{accountInfoBeans.flag eq false}"></h:inputText>
    
         <h:outputText id="Password" value="Password"></h:outputText>
         <h:inputSecret id="Passwordinput" value="#{loginBean.password}" maxlength="15" disabled="#{accountInfoBeans.flag eq false}"></h:inputSecret>
         
         <h:outputText id="ConfirmPassword" value="Confirm Password"></h:outputText>
         <h:inputSecret id="confirmpasswordinput" value="#{loginBean.confirmPassword}" maxlength="15" disabled="#{accountInfoBeans.flag eq false}"></h:inputSecret>
         
         <h:outputText id="SecurityQues" value="Security Question"></h:outputText>
         <h:selectOneMenu id="selectedsecurityQuesinput"  value="#{loginBean.securityQuestion}" disabled="#{accountInfoBeans.flag eq false}">
         <f:selectItem id="securityQuestionList0" itemLabel="--Select--"></f:selectItem>
	     <f:selectItem id="securityQuestionList" itemValue="Where you had first date?"></f:selectItem>
	     <f:selectItem id="securityQuestionList1" itemValue="What is your pet's name?"></f:selectItem>
	     <f:selectItem id="securityQuestionList2" itemValue="Who is your first crush?"></f:selectItem>
	     </h:selectOneMenu>
	     <h:outputText id="Securityanswer" value="Security Answer"></h:outputText>
	     <h:inputText id="SecurityAnswerInput" value="#{loginBean.securityAnswer}" disabled="#{accountInfoBeans.flag eq false}" maxlength="15"></h:inputText>
         
      </h:panelGrid>
      <br><br>

	<h:commandButton id="submit" value="Register" action="#{loginBean.RegisterWithbank}" styleClass="buttonErrorRepository" style="background:#3D7AC3;border: #3D7AC3" disabled="#{accountInfoBeans.flag eq false}"></h:commandButton><br>
	<h:outputText id="signupMessage" value="#{loginBean.message}" rendered="#{accountInfoBeans.flag eq true}"></h:outputText>
	</center>
   
    
    
    



</h:form>





</f:view>
</body>
</html>