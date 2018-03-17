<%@page import="com.mysql.jdbc.Field"%>
<%@page import="java.util.Map"%>
<%@page import="oro.gis.model.TableFieldsModel"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="stl" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%


List<TableFieldsModel> fieldList = (List<TableFieldsModel>) request.getAttribute("fieldList");
out.print(fieldList.size());
out.println(fieldList.get(0).getFieldLabel());
// Sir maybe its telling that list is null
%>
 --%>

<html>
	<head>
		<title>Panel</title>	
	</head>
	<body>
		<div>
			<h1>Panel details</h1>
		</div>
			
			<%-- <%
				for( int a=0;a<fieldList.size();a++){
					
					Map<String, Object> map = (Map)fieldList.get(a);
					%>
					
					<form:form action="${pageContext.request.contextPath}/user/panel" method="post" commandName="">
						<form:label path="<%=map.get("field_desc") %>"></form:label>
						<form:input path="<%=map.get("field_label") %>" id="<%=map.get("field_label") %>"/>
					</form:form>
					<%
					
				}
			
			%> --%>
			
			<!-- 
			command name set kr k try kro.. banega aise hi main lunch krne ja rha
			
			 -->
			 <div>
			 <form method="post" action="${pageContext.request.contextPath}/user/saveEntry">
			 	<fieldset>
			 		<legend>Give Details</legend>
			 		<table>
			 			<stl:forEach var="field" items="${fielddetails}" varStatus="i">
			 			<tr>
			 				<td>${field.getFieldLabel()}</td>
			 				<td>":"</td>
			 				<td><input name="${field.getFieldID()}" required='${field.getFieldRequired()=="Yes"?"required":"no"}' placeholder="${field.getFieldDesc()}"/></td>
			 			</tr>
			 			</stl:forEach>
			 		</table>
			  		<button type="submit">Proceed</button>
			 	</fieldset>
			 </form>
			 </div>
		</div>
	</body>
</html>