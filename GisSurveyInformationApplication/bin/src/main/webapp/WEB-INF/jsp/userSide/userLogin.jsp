<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>User Login</title>
	</head>
	<body>
		<div>
			<h1>User Login</h1>
		</div>
		<div>
			<form:form action="${pageContext.request.contextPath}/user" method="post" modelAttribute="userDetails">
				<fieldset>
					<legend>Sign in here</legend>
					<form:label path="username">
					USERNAME
					<form:input path="username"/>
					</form:label>
					<form:label path="password">
					PASSWORD
					<form:input path="password"/>
					</form:label>
					<button type="submit">Proceed</button>
				</fieldset>
			</form:form>			
		</div>
		<div>
			<h1>${error}</h1>
		</div>
	</body>
</html>