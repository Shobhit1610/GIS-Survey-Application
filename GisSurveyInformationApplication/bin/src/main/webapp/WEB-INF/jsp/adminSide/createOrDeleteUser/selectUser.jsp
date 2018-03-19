<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="stl"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<title>${process} User</title>
	</head>
	<body>
		<form:form action="${pageContext.request.contextPath}/admin/user/${link}" method="post">
			<stl:import url="allUsers.jsp"/>
			<button type="submit">${process}</button>
		</form:form>
	</body>
</html>