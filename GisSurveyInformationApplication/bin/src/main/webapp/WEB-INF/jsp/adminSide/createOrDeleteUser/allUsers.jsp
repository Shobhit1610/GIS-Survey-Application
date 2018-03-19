<%@ taglib prefix="stl"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<div>
			<stl:if test="${! empty details}">
				<fieldset>
					<legend>All User details</legend>
					<table>
						<tr>
							<th>S.No</th>
							<th>Name</th>
							<th>UserName</th>
							<th>Password</th>
							
						</tr>
						<stl:forEach var="user" items="${details}">
							<tr>
								<td>${user.user_id}</td>
								<td>${user.name}</td>
								<td>${user.username}</td>
								<td>${user.password}</td>
								<stl:if test="${show}"><td><input type="radio" name="option" value="${user.user_id}"/>Select</td></stl:if>
							</tr>
						</stl:forEach>
					</table>
				</fieldset>
			</stl:if>
</div>