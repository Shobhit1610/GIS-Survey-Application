<%@include file="/WEB-INF/html/head/directives.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Delete User</title>
		<%@include file="/WEB-INF/html/head/csslinks.html" %>
</head>
<body>
	<%@include file="/WEB-INF/html/body/adminnavigationheader.html" %>
	<div id="wrapper">
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Delete Table</h1>
                </div>
            </div>
            <div class="row">
            	<div class="col-lg-12">
            		<form:form action="${pageContext.request.contextPath}/admin/table/deleteTable" method="post">
	            		<%@include file="/WEB-INF/jsp/adminSide/createOrDeleteTable/allTables.jsp" %>
	            		<button type="submit" class="btn btn-default">Delete</button>
	            	</form:form>	
            	</div>
            </div>
         </div>
    </div>
    <%@include file="/WEB-INF/html/body/jsscripts.html" %> 
</body>
</html>
	