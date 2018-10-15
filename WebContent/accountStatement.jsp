<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Infosys Devops Bank: Account Statement</title>
<link href="style.css" media="screen" rel="stylesheet">
</head>
<body>
<f:view>
<div style="float:up; height:140px;width:100%;">
           <h:graphicImage value="Header.png" height="64%" width="100%"></h:graphicImage>
           <h:graphicImage value="Logout1.png" height="31%" width="100%">
           <h:graphicImage value="logout_image.png" styleClass="RightCorner1"></h:graphicImage>
           <h:outputLink value="login.jsp" styleClass="RightCorner"><h2>Logout</h2></h:outputLink>
           </h:graphicImage>
           
           </div>
           
<h:form>
            
			<div style="float:left;width:17%;background:#B4CEFF;height:480Px">
		    <br><br><center>
			<h:commandButton value="Home" action="Home.jsp" styleClass="button"></h:commandButton><br><br>
            <h:commandButton value="Account statement" action="Account Statement.jsp" styleClass="button"></h:commandButton><br><br>
			<h:commandButton value="Fund Transfer" action="Fund Transfer.jsp" styleClass="button"></h:commandButton><br><br>
			<h:commandButton value="Contact" styleClass="button"></h:commandButton>
			</center>
			</div>
		
			
            
                  <div style="float:right; width:83%;height:500px;overflow:auto;">
                    <div style="height:35%;border:#3D7AC3;border-style:solid;width:99%;overflow: auto;">
                       <b>Case Search:</b><br>
                        <center>
                         <h:outputText value="Start Date:"></h:outputText>    
                         <h:inputText value="#{transactionHistoryBean.startDate}">
                         <f:convertDateTime type="date" pattern="MM/dd/yyyy"></f:convertDateTime>
                         </h:inputText><br><br>
                         <h:outputText value="End Date:"></h:outputText>    
                         <h:inputText value="#{transactionHistoryBean.endDate}">
                         <f:convertDateTime type="date" pattern="MM/dd/yyyy"></f:convertDateTime>
                         </h:inputText><br><br>
						<h:commandButton value="Search" action="#{transactionHistoryBean.accountStatementSearch}" type="submit" styleClass="submitButton"></h:commandButton>&nbsp;&nbsp;
						<h:commandButton value="Reset" action="#{transactionHistoryBean.searchReset}" styleClass="submitButton"></h:commandButton>
			
					</center>
				  </div><br>    
                       
				  <b><h:outputText value="Transaction History:"></h:outputText></b><br>
            <center>
            
            <h:outputText value="#{transactionHistoryBean.message}"></h:outputText>
					
					
				</center>       
			   </div>         
			    <h:dataTable border="0" value="#{transactionHistoryBean.transactionList}" var="row" headerClass="tableHeading" rowClasses="tableRows" styleClass="table" cellspacing="0" cellpadding="10">
						<h:column id="column1">
							<f:facet name="header">
								<h:outputText value="Transaction ID"></h:outputText>
							</f:facet>
							<h:outputText value="#{row.transactionId}"></h:outputText>
						</h:column>
						
						<h:column id="column2">
							<f:facet name="header">
								<h:outputText value="Target Account No"></h:outputText>
							</f:facet>
							<h:outputText value="#{row.targetAccountNo}"></h:outputText>
						</h:column>
						<h:column id="column3">
							<f:facet name="header">
								<h:outputText value="Transferred Amount"></h:outputText>
							</f:facet>
							<h:outputText value="#{row.amountTransferred}"></h:outputText>
						</h:column>
						<h:column id="column4">
							<f:facet name="header">
								<h:outputText value="Timestamp"></h:outputText>
							</f:facet>
							<h:outputText value="#{row.transactionTimeStamp}"></h:outputText>
						</h:column>
						
						
					</h:dataTable>
					        
			            
			           
				            
				            
			           
		                
            
</h:form>
            <div style="float:down;width:100%;height:40px;position:fixed;bottom:0;left:0;right:0;">
            <h:graphicImage value="Footer.png" height="100%" width="100%"></h:graphicImage>
            </div>

</f:view>
</body>
</html>