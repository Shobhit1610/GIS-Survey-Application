<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>Admin Panel</title>
	</head>
	<body>
		<div>
			<h1>Admin Panel</h1>
		</div>
		<div>
			<fieldset>
				<legend>Choose any option</legend>
				<div>
					<form:form action="${pageContext.request.contextPath}/admin/user" method="post">
						<button type="submit">USER</button>
					</form:form>
				</div>
				<div>
					<form:form action="${pageContext.request.contextPath}/admin/table" method="post">
						<button type="submit">TABLE</button>
					</form:form>
				</div>
			</fieldset>
		</div>
		${confirmation}
	</body>
</html>