<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="stl"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<title>Add User</title>
	</head>
	<body>
		<div>
			<h1>Admin Add User</h1>
		</div>
		<div>
			<form:form action="${pageContext.request.contextPath}/admin/user/addUser" method="post">
				<button type="submit">ADD USER</button>
			</form:form>
			
		</div>
			<div>
			<form:form action="${pageContext.request.contextPath}/admin/user/editUser" method="post">
				<button type="submit">EDIT USER</button>
			</form:form>
			
		</div>
			<div>
			<form:form action="${pageContext.request.contextPath}/admin/user/deleteUser" method="post">
				<button type="submit">DELETE USER</button>
			</form:form>
			
		</div>
		<stl:import url="allUsers.jsp"/>
	</body>
</html>