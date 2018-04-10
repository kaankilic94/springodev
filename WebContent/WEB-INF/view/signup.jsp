<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<jsp:include page="${request.contextPath}/bootstrap"></jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/login.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br><br>
<div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title">Sign Up <small>It's free!</small></h3>
			 			</div>
			 			<div class="panel-body">
			    		<form:form modelAttribute="user" action="signup" method="POST">
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    					<form:input  type="text" class="form-control input-sm" id="first_name" placeholder="First Name" path="firstName"/>
			    					<br/><form:errors path="firstName" cssClass="error"></form:errors>
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    					<form:input  type="text"  class="form-control input-sm" id="last_name" placeholder="Last Name" path="lastName"/>
			    					<br/><form:errors path="lastName" cssClass="error"></form:errors>
			    					</div>
			    				</div>
			    			</div>

			    			<div class="form-group">
			    				<form:input type="email" class="form-control input-sm" id="email" placeholder="Email Address" path="email"/>
			    				<br/><form:errors path="email" cssClass="error"></form:errors>
			    			</div>

			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="password" class="form-control input-sm" placeholder="Password" id="password" path="password"/>
			    						<br/><form:errors path="password" cssClass="error"></form:errors>
			    					</div>
			    				</div>
			    				 <div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="password" class="form-control input-sm" id="password_confirmation" placeholder="Confirm Password" path="confirmPassword"/>
			    						<br/><form:errors path="confirmPassword" cssClass="error"></form:errors>
			    					</div>
			    				</div> 
			    			</div>
			    			
			    			<input type="submit" value="Register" class="btn btn-info btn-block">
			    		
			    		</form:form>
			    	</div>
	    		</div>
    		</div>
    	</div>
 </div>

</body>
</html>