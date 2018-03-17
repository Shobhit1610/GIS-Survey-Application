<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Admin Login</title>
	</head>
	<body>
		<div>
			<h1>Admin Login</h1>
		</div>
		<div>
			<form:form action="${pageContext.request.contextPath}/admin" method="post" commandName="adminDetails">
				<fieldset>
					<legend>Sign in here</legend>
					<form:label path="adminUsername">
					USERNAME
					<form:input path="adminUsername" type="text"/>
					</form:label>
					<form:label path="adminPassword">
					PASSWORD
					<form:input path="adminPassword" type="password"/>
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