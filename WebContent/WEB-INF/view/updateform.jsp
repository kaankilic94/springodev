<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style type="text/css">
.selectpick{
    width: 150px;
    height: 30px;
    border-style: solid;
    color: black;
    font-size: 18px;
    font-weight: 200;
    padding-left: 6px;
    -moz-appearance: none;
    appearance: none;
}
</style>
<jsp:include page="${request.contextPath}/bootstrap"></jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/login.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!--Update Form = ${theTaskId}-->
		<br><br><br><br>
		
		<div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title">Update <small>task</small></h3>
			 			</div>
			 			<div class="panel-body">
			    		<form:form modelAttribute="task" action="updatetask" method="POST">
			    		<form:hidden path="id"/>
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			              			<form:input type="text"  id="name" path="name" class="form-control input-sm" placeholder="Task Name"/>			               
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="date" id="end_date" path="tempDate" class="form-control input-sm"/>
			    					</div>
			    				</div>
			    			</div>

			    			

			    			<div class="row">
			    				<div class="col-xs-12 col-sm-12 col-md-12">
			    					<div class="form-group">
			    						<form:input  type="text" id="description" path="description" class="form-control input-sm" placeholder="Description"/>
			    					</div>
			    				</div>
			    				
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:select class="selectpick" path="status">
										<form:options items="${status}" />
									</form:select>
			    					</div>
			    				</div> 
			    			</div>
			    			
			    			<p class = "error">${notNull }</p>
			    			
			    			<input type="submit" value="Register" class="btn btn-info btn-block">
			    		
			    		</form:form>
			    		
			    	</div>
	    		</div>
    		</div>
    	</div>
    </div>
</body>
</html>