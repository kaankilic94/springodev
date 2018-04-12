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
		<h1>Task List</h1>
		<a style="position: absolute; right: 210px; top: 100px; font-size: 24px;" href="${pageContext.request.contextPath }/user">My Tasks</a>
   
		
		
		<table class="table table-striped">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Task</th>
				<th>Date</th>
				<th>Description</th>
				<th>Status</th>
				<th>Update/Delete</th>
			</tr>
			<c:forEach var="task" items="${dutys }">
				<tr>
					<td>${task.firstName}</td>
					<td>${task.lastName}</td>
					<td>${task.taskName}</td>
					<td>${task.date }</td>
					<td>${task.description }</td>
					<td>${task.status }</td>
					<td>
					<a class="btn btn-warning" href="${pageContext.request.contextPath }/adminshowupdateform?taskID=${task.id }">Update</a> 
					<a class="btn btn-danger" href="${pageContext.request.contextPath }/admindeletetask?taskID=${task.id }" onclick="return confirm('Are you sure?');">Delete</a></td>
				
				</tr>
			</c:forEach>
		</table>
	
	
	</div>
	</div>
</body>
</html>