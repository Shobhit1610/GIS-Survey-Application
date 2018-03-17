<%@page import="java.util.List"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="stl" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%


List fieldList = (List) request.getAttribute("details");
out.print(fieldList.size());
// Sir maybe its telling that list is null
%> --%>


<html>
	<head>
		<title>User Panel</title>	
	</head>
	<body>
		<div>
			<h1>User Panel</h1>
		</div>
		<div>
			<form:form action="${pageContext.request.contextPath}/user/addEntry" method="post">
				<stl:if test="${! empty details}">
				<fieldset>
					<legend>All Table details</legend>
					<table>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Description</th>
							<th>Active</th>
							
						</tr>
						<stl:forEach var="table" items="${details}">
							<tr>
								<td>${table.data_type_id}</td>
								<td>${table.data_type_name}</td>
								<td>${table.data_type_description}</td>
								<td>${table.active}</td>
								<td><input type="radio" name="option" value="${table.data_type_id}"/>Select</td>
							</tr>
						</stl:forEach>
					</table>
				</fieldset>
				<button type="submit">Proceed</button>
			</stl:if>
			</form:form>
		</div>
	</body>
</html>