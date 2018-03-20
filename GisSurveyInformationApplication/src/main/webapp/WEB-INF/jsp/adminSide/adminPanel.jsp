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
                            <div class="panel-footer" onclick="addUser()">
                                View Details... 
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
                           <div class="panel-footer" onclick="addTable()">
                               View Details...
                            </div>
                    	</div>
               		 </div>
                  </div>
                  <br><br><br>
                  <div class="row" id="adduser" style="display:none;">
                  	<div class="col-lg-3 text center">
                  		<form:form action="${pageContext.request.contextPath}/admin/user/addUser" method="post">
                  			<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit">
                  				Add Users
                  			</button>
                  		</form:form> 
                  	</div>
                  	<div class="col-lg-3 text center">
                  		<form:form action="${pageContext.request.contextPath}/admin/user/editUser" method="post">
                  			<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit">
                  				Edit Users
                  			</button>
                  		</form:form> 
                  	</div>
                  	<div class="col-lg-3 text center">
                  		<form:form action="${pageContext.request.contextPath}/admin/user/deleteUser" method="post">
                  			<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit">
                  				Delete Users
                  			</button>
                  		</form:form> 
                  	</div>	
                  	<div class="col-lg-3 text center">
                  		<form:form action="${pageContext.request.contextPath}/admin/user/showAllUsers" method="post">
                  			<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit">
                  				Show Users
                  			</button>
                  		</form:form> 
                  	</div>	
                  </div>

                  <div class="row" id="addtable" style="display:none;">
                  	<div class="col-lg-4 text center">
                  		<form:form action="${pageContext.request.contextPath}/admin/table/addTable" method="post">
                  			<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit">
                  				Add Tables
                  			</button>
                  		</form:form> 
                  	</div>
                  	<div class="col-lg-4 text center">
                  		<form:form action="${pageContext.request.contextPath}/admin/table/deleteTable" method="post">
                  			<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit">
                  				Delete tables
                  			</button>
                  		</form:form> 
                  	</div>
                  	<div class="col-lg-4 text center">
                  		<form:form action="${pageContext.request.contextPath}/admin/table/showAllTables" method="post">
                  			<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit">
                  				Show tables
                  			</button>
                  		</form:form> 
                  	</div>
                  </div>
                	<div class="footer navbar-fixed-bottom">
                  			<h3>${confirmation}</h3>
                	</div>
                  	
                  
            </div>
    </div>        
    <script>
    	function addUser()
    	{
    		var user = document.getElementById("adduser");
    		var table = document.getElementById("addtable");
    		if(table.style.display === "block")
    			{
    			table.style.display = "none";
    			}
    		user.style.display = "block";
    	}
    	function addTable()
    	{
    		var user = document.getElementById("adduser");
    		var table = document.getElementById("addtable");
    		if(user.style.display === "block")
    			{
    			user.style.display = "none";
    			}
    		table.style.display = "block";
    	}
    </script>
   	<%@include file="/WEB-INF/html/body/jsscripts.html" %>
</body>

</html>
