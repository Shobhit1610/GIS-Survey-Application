<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>GIS Survey</title>
	</head>
	<body>
		<div>
			<h1>HOME PAGE</h1>
		</div>		
		<div>
			<div>
				<form:form action="${pageContext.request.contextPath}/user" method="get">
					<button type="submit">Login as USER</button>
				</form:form>
			</div>
			<div>
				<form:form action="${pageContext.request.contextPath}/admin" method="get">
					<button type="submit">Login as ADMIN</button>
				</form:form>
			</div>
			<div>
			</div>
		</div>
	</body>
</html>