<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="stl"      uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
	<%@include file="/WEB-INF/html/head/csslinks.html" %>
</head>

<body>
	<%@include file="/WEB-INF/html/body/navigationheader.html" %>
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
                                Click here 
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
                               Click here
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
                  		<form:form action="${pageContext.request.contextPath}/admin/user/deleteUser" method="post">
                  			<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit">
                  				Show Users
                  			</button>
                  		</form:form> 
                  	</div>	
                  </div>

                  <div class="row" id="addtable" style="display:none;">
                  	<div class="col-lg-4 text center">
                  		<form:form action="${pageContext.request.contextPath}/admin/user/addUser" method="post">
                  			<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit">
                  				Add Tables
                  			</button>
                  		</form:form> 
                  	</div>
                  	<div class="col-lg-4 text center">
                  		<form:form action="${pageContext.request.contextPath}/admin/user/editUser" method="post">
                  			<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit">
                  				Delete tables
                  			</button>
                  		</form:form> 
                  	</div>
                  	<div class="col-lg-4 text center">
                  		<form:form action="${pageContext.request.contextPath}/admin/user/editUser" method="post">
                  			<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit">
                  				Show tables
                  			</button>
                  		</form:form> 
                  	</div>
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
