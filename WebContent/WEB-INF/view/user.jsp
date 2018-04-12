<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="${request.contextPath}/bootstrap"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
		
		 <a  style="position: absolute; right: 210px;  font-size: 25px;" href="${pageContext.request.contextPath }/exit">Exit</a>
		<h1>Task List</h1>
		
		
		<a class="btn btn-primary btn-lg"
			 onclick="window.location.href='task'; return false;" 
			 type="button" role="button">New Task</a>
			
		</div>
		
		
		<table class="table table-striped">
			<tr>
				<th>Task</th>
				<th>Date</th>
				<th>Description</th>
				<th>Status</th>
				<th>Update/Delete</th>
			</tr>
			<c:forEach var="task" items="${tasks }">
				<tr>
					<td>${task.name}</td>
					<td>${task.endDate }</td>
					<td>${task.description }</td>
					<td>${task.status }</td>
					<td>
					<a class="btn btn-warning" href="${pageContext.request.contextPath }/showupdateform?taskID=${task.id }">Update</a> 
					<a class="btn btn-danger" href="${pageContext.request.contextPath }/deletetask?taskID=${task.id }" onclick="return confirm('Are you sure?');">Delete</a></td>
				
				</tr>
			</c:forEach>
		</table>
	
	
	</div>
</body>
</html>