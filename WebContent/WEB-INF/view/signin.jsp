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

<div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form:form class="form-signin" modelAttribute="user" action="signin" method="POST">
                <span id="reauth-email" class="reauth-email"></span>
                <form:input type="email" id="inputEmail" class="form-control" placeholder="Email address"  path="email"/>
                <form:input type="password" id="inputPassword" class="form-control" placeholder="Password" path="password"/>
                <p style="color:red">${invalid}<p>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
            </form:form><!-- /form -->
            <a href="${pageContext.request.contextPath }/signup" class="forgot-password">
                Create an account
            </a>
        </div><!-- /card-container -->
        
    </div><!-- /container -->

<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/login.js"></script>

</body>
</html>