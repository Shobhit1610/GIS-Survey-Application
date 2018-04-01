<%@include file="/WEB-INF/html/head/directives.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Admin Login</title>
		<%@include file="/WEB-INF/html/head/csslinks.html" %>
</head>
<body>
	<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form action="${pageContext.request.contextPath}/admin/login" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input name="username" type="text" class="form-control" placeholder=" Username"  autofocus="true"/>
                                </div>
                                <div class="form-group">
                                    <input name="password" type="password" class="form-control" placeholder=" Password"  autofocus="true"/>
                                </div>
                                <div>
                    				<h4>${error}</h4>
                    			</div>
                                <button type="submit" class="btn btn-lg btn-success btn-block">Login</button>
                            </fieldset>
                        </form>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
	<%@include file="/WEB-INF/html/body/jsscripts.html" %>
</body>
</html>