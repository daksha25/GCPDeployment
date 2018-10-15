<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
 history.forward();
    </script>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Infosys Devops Bank:Login</title>
<link href="style.css" media="screen" rel="stylesheet">
</head>
<body class="respBgImageLogin">


<f:view>
<h:form id="form_login">
			
          <div style="float:up; height:18%;width:100%;">
              <div style="height:64%; width:100%;background-color:#0000cc;border:#004d66;border-style:solid;">
                 <center>
                      <h:graphicImage value="Logo_for_header.png" height="30%" width="28%"></h:graphicImage>
                         </center>
              </div>
          </div>
           
           <br><br><br><br><br><br><br>
 
<center>    
           <div id="divcentre" style="centered;" class="appfont">             
			<h:panelGrid id="panelgridlogin" border="0" columns="2">
				<h:outputText id="usernametext" value="Username:"></h:outputText>
				<h:inputText id="usernameinput" value="#{loginBean.uname}" required="true" requiredMessage="User name is mandatory" validatorMessage="username should be less than or equal to 10 character.">
				<f:validateLength maximum="10"></f:validateLength>
				</h:inputText>
				<h:outputText id="passwordtext" value="Password:"></h:outputText>
				<h:inputSecret id="passwordinput" value="#{loginBean.password}" required="true" requiredMessage="Password is mandatory"></h:inputSecret>
			</h:panelGrid><br>
			
				<h:commandButton id="loginbtn" value="Login" action="#{loginBean.varifyData}" type="submit" styleClass="buttonErrorRepository" style="background:#3D7AC3;border: #3D7AC3"></h:commandButton>&nbsp;&nbsp;
				<h:commandButton id="resetbtn" value="Reset" action="#{loginBean.reSet}" type="submit" styleClass="buttonErrorRepository" style="background:#3D7AC3;border: #3D7AC3;"></h:commandButton><br>
			</div>	
			 <h:messages id="errormsglogin" styleClass="errormsg_login" style="appfont" ></h:messages><br>
			 <h:outputText id="errormsgtext" value="#{loginBean.message}" rendered="#{loginBean.flag eq true}" styleClass="errormsg_login" style="appfont"></h:outputText><br>
</center> 
                
              
               
                
</h:form>
            <center>
			<h:form id="form_signup">
				<h:outputText value="Not a NetBanking User:" id="signu_text" style="color:white"></h:outputText>&nbsp;
				<h:commandButton id="signupbtn" value="Sign up" action="#{loginBean.signUpButton}" type="submit" styleClass="buttonErrorRepository" style="background:#3D7AC3;border: #3D7AC3"></h:commandButton>
				</h:form>
			</center>	 
            <div id="footer" style="float:down;position:fixed;width:100%; height:4%;bottom:0;left:0;right:0;background-color:#ccccff;border:#000000;border-style:solid;">
	<center>
           <h:outputText value= " © 2017 DEVOPS TEAM, ALL RIGHTS RESERVED" style="font-size:x-small;" ></h:outputText> 
   </center>
            </div> 
</f:view>
</body>
</html>