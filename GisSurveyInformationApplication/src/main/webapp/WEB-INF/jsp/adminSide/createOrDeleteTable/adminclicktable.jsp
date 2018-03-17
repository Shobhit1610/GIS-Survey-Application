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
			<form:form action="${pageContext.request.contextPath}/admin/table/addTable" method="post">
				<button type="submit">ADD TABLE</button>
			</form:form>
			
		</div>
		<div>
			<stl:if test="${!empty details}">
				<form:form action="${pageContext.request.contextPath}/admin/table/deleteTable" method="post">
					<fieldset>
						<legend>All Tables</legend>
						<table>
							<tr>
								<th>S.No</th>
								<th>Table Name</th>
								<th>Table Description</th>
								<th>Active Status</th>
							</tr>
							<stl:forEach var="table" items="${details}">
									<tr>
										<td>${table.data_type_id}</td>
										<td>${table.data_type_name}</td>
										<td>${table.data_type_description}</td>
										<td>${table.active}</td>
										<td><input type="radio" name="option" value="${table.data_type_id}"/>Select to delete</td>
									</tr>
							</stl:forEach>
						</table>
						<button type="submit">PROCEED</button>
					</fieldset>
				</form:form>
			</stl:if>
		</div>
		<%-- <div>
			<stl:if test="${!empty details}">
			<form:form action="${pageContext.request.contextPath}/admin/user/deleteUser" method="post">
				<fieldset>
					<legend>Select the record to delete</legend>
					<table>
						<tr>
							<th>S.No</th>
							<th>Name</th>
							<th>UserName</th>
							<th>Password</th>
							<th>DELETE</th>
						</tr>
						<stl:forEach var="user" items="${details}">
							<tr>
								<td>${user.user_id}</td>
								<td>${user.name}</td>
								<td>${user.username}</td>
								<td>${user.password}</td>
								<td><input type="radio" name="option" value="${user.user_id}"/>Select to delete</td>
							</tr>
						</stl:forEach>
					</table>
					<button type="submit">PROCEED</button>
				</fieldset>
			</form:form>
			</stl:if>
		</div> --%>
	</body>
</html>