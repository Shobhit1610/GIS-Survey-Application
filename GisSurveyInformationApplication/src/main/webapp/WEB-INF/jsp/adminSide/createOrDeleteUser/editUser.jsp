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
                    <h1 class="page-header">Edit User</h1>
                </div>
            </div>
            <div class="row">
            	<div class="col-lg-12">
            		<div class="panel panel-info">
            			<div class="panel-heading">
            				Give details of user
            			</div>
            			<div class="panel-body">
            				<form:form action="${pageContext.request.contextPath}/admin/user/editUser" method="post" commandName="newuserDetails">
            				<div class="row">
            					<div class="col-lg-12">
            						<div class="table-responsive">
            							<table class="table table-hover">
            								<thead>
            									<tr>
            										<input type="hidden" name="userid" value="${olddetails.getUserid()}"/>
            										<th>User ID : ${olddetails.getUserid()}</th>
													<th>OLD Details</th>
													<th>NEW Details</th>
												</tr>
        		    						</thead>
            								<tbody>
	            								<tr>
													<td>NAME</td>
													<td>
														<div class="form-group">
															<input value="${olddetails.getName()}" readonly="true" class="form-control"/>
														</div>
													</td>
													<td>
														<div class="form-group">
            												<form:input path="name" required="required" cssClass="form-control"  type="text"/>
														</div>
													</td>
												<tr>
												<tr>
													<td>USERNAME</td>
													<td>
														<div class="form-group">
															<input value="${olddetails.getUsername()}" readonly="true" class="form-control"/>
														</div>		
													</td>
													<td>
														<div class="form-group">
            												<form:input path="username" required="required" cssClass="form-control"  type="text"/>
														</div>
													</td>
												<tr>
												<tr>
													<td>PASSWORD</td>
													<td>
														<div class="form-group">
															<input value="${olddetails.getPassword()}" readonly="true" class="form-control"/>
														</div>
													</td>
													<td>
														<div class="form-group">
            												<form:input path="password" required="required" cssClass="form-control"  type="text"/>
														</div>
													</td>
												<tr>
            								</tbody>
            							</table>
            						</div>
            					</div>
            				</div>
            			</div>
            			<div class="panel-footer">
                             <div class="row">
                             	<div class="col-xs-6">
                             		<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit" style="border:none;">
                  								Edit Record
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
