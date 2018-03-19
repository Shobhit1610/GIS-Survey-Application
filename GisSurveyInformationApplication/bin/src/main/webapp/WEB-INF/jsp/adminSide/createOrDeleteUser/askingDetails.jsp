<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>${process}</title>
	</head>
	<body>
		<form:form action="${pageContext.request.contextPath}/admin/user/${link}" method="post" commandName="userDetails">
			<fieldset>
				<legend>Give Details</legend>
				<form:label path="name">
					NAME
					<form:input path="name" required="required"/>
				</form:label>
				<br><br>
				<form:label path="username">
					USERNAME
					<form:input path="username" required="required"/>
				</form:label>
				<br><br>
				<form:label path="password">
					PASSWORD
					<form:input path="password" required="required"/>
				</form:label>
				<br><br>
				<button type="submit">${process}</button>
			</fieldset>
		</form:form>
	</body>
</html>