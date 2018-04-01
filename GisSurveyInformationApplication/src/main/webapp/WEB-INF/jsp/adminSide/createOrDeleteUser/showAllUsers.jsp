<%@include file="/WEB-INF/html/head/directives.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>All Users</title>
		<%@include file="/WEB-INF/html/head/csslinks.html" %>
</head>
<body>
	<%@include file="/WEB-INF/html/body/adminnavigationheader.html" %>
	<div id="wrapper">
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">All Users</h1>
                </div>
            </div>
            <div class="row">
            	<div class="col-lg-12">
            		<div class="form-group">
            		<form action="${pageContext.request.contextPath}/admin/user/deleteUsers" method="post">
            			<div class="panel panel-info">
            			<div class="panel-heading">
            				All registered users are
            			</div>
            			<div class="panel-body">
            				<stl:choose>
            				<stl:when test="${! empty details}">
            				<div class="table-responsive">
            					<table class="table table-hover">
            						<thead>
            							<tr>
            								<th></th>
											<th>ID</th>
											<th>Name</th>
											<th>UserName</th>
											<th>Password</th>
										</tr>
            						</thead>
            						<tbody>
            							<stl:forEach var="user" items="${details}">
											<tr>
												<td><input type="checkbox" name="usersDeleted" value="${user.user_id}" class="checkbox" /></td>
												<td><a href="${pageContext.request.contextPath}/admin/user/editUser?userid=${user.user_id}">${user.user_id}</a></td>
												<td>${user.name}</td>
												<td>${user.username}</td>
												<td>${user.password}</td>
											<tr>
										</stl:forEach>
            						</tbody>
            					</table>
            				</div>
            				</stl:when>
            				<stl:otherwise>
            					<h3>No data available</h3>
            				</stl:otherwise>
            				</stl:choose>
            			</div>
            			<div class="panel-footer">
                            	<div class="row">
                                	<stl:if test="${! empty details}">
                                	<div class="col-lg-6">
                                		<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit" style="border:none;">
                  							Delete
                  						</button>
                                   	</div>
                                   	</stl:if>
                                	<div class="col-lg-6">
                                		<a href = "${pageContext.request.contextPath}/admin" style="text-decoration: none;">
                               			<button class="btn btn-outline btn-primary btn-lg btn-block" type="button" style="border:none;">
                  								Back to Panel
                  						</button>
                  						</a>
            						</div>
                                </div> 
                          </div>
            		</div>
                  	</form>
	            	</div>
	            </div>
            </div>
         </div>
    </div>
    <%@include file="/WEB-INF/html/body/jsscripts.html" %> 
</body>
</html>
	