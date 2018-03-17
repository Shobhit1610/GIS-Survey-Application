 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="stl"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<title>Add Table</title>
	</head>
	<body>
		<div>
			<h1>
				Add Table Fields
			</h1>
		</div>
		<div>
			 <stl:if test="${requestScope.noOfColumns > 0}">
				<form:form action="${pageContext.request.contextPath}/admin/table/addTable" method="post" commandName="tablefieldsdetails">
					<fieldset>
						<legend>Fill the details of field ${requestScope.noOfColumns}</legend>
						<form:label path="fieldLabel">
							FIELD LABEL
							<form:input path="fieldLabel" required="required"/>
						</form:label>
						<br><br>
						<form:label path="fieldDesc">
							FIELD DESC
							<form:input path="fieldDesc" required="required"/>
						</form:label>
						<br><br>
						<form:label path="fieldType">
							FIELD TYPE
							<form:select path="fieldType">
								<form:option value="string" label="Text"/>
								<form:option value="number" label="Integer"/>
								<form:option value="decimal(4,2)" label="Real"/>
							</form:select>
						</form:label>
						<br><br>
						<form:label path="dataType">
							DATA TYPE
							<form:input path="dataType" value="ACTIVITY" readonly="true"/>
						</form:label>
						<br><br>
						<form:label path="dataTypeID">
							DATA TYPE ID
							<form:input path="dataTypeID" value="${requestScope.datatypeid}" readonly="true"/>
						</form:label>
						<br><br>
						<form:label path="fieldRequired">
							FIELD REQUIRED
							<form:select path="fieldRequired" required="required">
								<form:option value="Yes" label="Yes"/>
								<form:option value="No" label="No"/>
							</form:select>
						</form:label>
						<br><br>
						<form:label path="sequence">
							SEQUENCE
							<form:input path="sequence"/>
						</form:label>
						<br><br>
						<button type="submit">Submit</button>
					</fieldset>
				</form:form>
			</stl:if>
		</div>
	</body>
</html>