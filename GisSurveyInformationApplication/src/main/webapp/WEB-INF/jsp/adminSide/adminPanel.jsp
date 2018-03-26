<%@include file="/WEB-INF/html/head/directives.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Admin Panel</title>
		<%@include file="/WEB-INF/html/head/csslinks.html" %>
</head>
<body>
	<%@include file="/WEB-INF/html/body/adminnavigationheader.html" %>
	<div id="wrapper">

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Admin Dashboard</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-6 col-md-3 text-center">
                    <div class="panel panel-primary">
                        <div class="panel-heading ">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="huge">${users_count}</div>
                                    <div>Users registered</div>
                                </div>
                            </div>
                        </div>
                            <div class="panel-footer">
                                <div class="row">
                                	<div class="col-xs-6">
                                		<form:form action="${pageContext.request.contextPath}/admin/user/addUser" method="post" >
                  							<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit" style="border:none;">
                  								Add Users
                  							</button>
                				  		</form:form> 
                                	</div>
                                	<div class="col-xs-6">
                                		<form:form action="${pageContext.request.contextPath}/admin/user/showUsers" method="post">
                  							<button class="btn btn-no-border btn-outline btn-primary btn-lg btn-block btn-no-border"  style="border:none;" type="submit">
                  								Show Users
                  							</button>
                  						</form:form>
                                	</div>
                                </div>
                            </div>
                       </div>
                </div>
                <div class="col-lg-6 col-md-3 text-center" >
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-12 text-center">
                                    <div class="huge">${tables_count}</div>
                                    <div>Tables made</div>
                                </div>
                            </div>
                        </div>
                           <div class="panel-footer">
                               <div class="row">
                               		<div class="col-xs-6">
                               			<form:form action="${pageContext.request.contextPath}/admin/table/addTable" method="post">
                  							<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit" style="border:none;">
                  								Add Tables
                  							</button>
                  						</form:form>
                               		</div>
                               		<div class="col-xs-6">
                               			<form:form action="${pageContext.request.contextPath}/admin/table/deleteTable" method="post">
                  							<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit" style="border:none;">
                  								Show Tables
                  							</button>
                  						</form:form>
                               		</div>
                               </div>
                            </div>
                    	</div>
               		 </div>
                  </div>
                  <div class="footer navbar-fixed-bottom text-right">
                  			<h3 style="paddingi-right:5px;padding-bottom:5px;">${confirmation}</h3>
                  </div>
               </div>
    </div>        
   	<%@include file="/WEB-INF/html/body/jsscripts.html" %>
</body>

</html>
