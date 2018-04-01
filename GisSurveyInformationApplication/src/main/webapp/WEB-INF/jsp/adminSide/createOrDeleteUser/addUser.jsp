<%@include file="/WEB-INF/html/head/directives.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Add User</title>
		<%@include file="/WEB-INF/html/head/csslinks.html" %>
</head>

<body>
	<%@include file="/WEB-INF/html/body/adminnavigationheader.html" %>
	<div id="wrapper">
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Add User</h1>
                </div>
            </div>
            <div class="row">
            	<div class="col-lg-12">
            							<div class="panel panel-info">
            			<div class="panel-heading">
            				Give details of user
            			</div>
            			<div class="panel-body">
            				<div class="row">
            					<div class="col-lg-6">
            						<form:form action="${pageContext.request.contextPath}/admin/user/addUser" method="post" commandName="userDetails">
            							<div class="form-group">
            								<form:label path="name">
												NAME
												<form:input path="name" required="required" cssClass="form-control" placeholder="Name.." type="text"/>
											</form:label>
            							</div>
            							<div class="form-group">
            								<form:label path="username">
												USERNAME
												<form:input path="username" required="required" cssClass="form-control" placeholder="Username.." type="text"/>
											</form:label>
            							</div>
            							<div class="form-group">
            								<form:label path="password">
												PASSWORD
												<form:input path="password" required="required" cssClass="form-control" placeholder="User Password.." type="text"/>
											</form:label>
            							</div>
            						
            					</div>
            				</div>
            			</div>
            			<div class="panel-footer">
                             <div class="row">
                             	<div class="col-xs-6">
                             		<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit" style="border:none;">
                  								Add Record
                  					</button>
                  				</div>
                  				</form:form>
                               	<div class="col-xs-6">
                               		<a href = "${pageContext.request.contextPath}/admin" style="text-decoration: none;">
                               			<button class="btn btn-outline btn-primary btn-lg btn-block" type="button" style="border:none;">
                  								Back to Panel
                  						</button>
                  					</a>
                  	       		</div>
                             </div>
                        </div>
            		</div>
            	</div>
            </div>
         </div>
    </div>
     <%@include file="/WEB-INF/html/body/jsscripts.html" %> 
 </body>

</html>
