<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<title>Add Table</title>
	</head>
	<body>
		Add Table Name
		<form:form action="${pageContext.request.contextPath}/admin/table/addTable" method="post" commandName="tablenamedetails">
			<fieldset>
				<legend>Give Details</legend>
				<form:label path="dataTypeName">
					NAME OF TABLE
					<form:input path="dataTypeName" required="required"/>
				</form:label>
				<br><br>
				<form:label path="dataTypeDescription">
					DESCRIPTION OF TABLE
					<form:input path="dataTypeDescription" required="required"/>
				</form:label>
				<br><br>
				<form:label path="active">
					ACTIVE STATUS
					<form:select path="active" required="required">
						<form:option value="Yes" label="Yes"/>
						<form:option value="No" label="No"/>
					</form:select>
				</form:label>
				<label for="totalColumns">
					NO. OF COLUMNS
					<input type="number" name="totalColumns"/>
				</label>
				<br><br>
				<button type="submit">PROCEED</button>
			</fieldset>
		</form:form>
	</body>
</html>