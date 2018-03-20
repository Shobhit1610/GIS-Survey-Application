<%@include file="/WEB-INF/html/head/directives.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Add Table</title>
		<%@include file="/WEB-INF/html/head/csslinks.html" %>
</head>

<body>
	<%@include file="/WEB-INF/html/body/adminnavigationheader.html" %>
		<div id="wrapper">
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Table name details</h1>
                </div>
            </div>
            <div class="row">
            	<div class="col-lg-12">
            							<div class="panel panel-info">
            			<div class="panel-heading">
            				Table name details..
            			</div>
            			<div class="panel-body">
            				<div class="row">
            					<div class="col-lg-6">
            						<form:form action="${pageContext.request.contextPath}/admin/table/addTable" method="post" commandName="tablenamedetails">
            							<div class="form-group">
            								<form:label path="dataTypeName">
												NAME OF TABLE
												<form:input path="dataTypeName" required="required" cssClass="form-control" placeholder="Name of table" type="text"/>
											</form:label>
            							</div>
            							<div class="form-group">
            								<form:label path="dataTypeDescription">
												DESCRIPTION OF TABLE
												<form:input path="dataTypeDescription" required="required" cssClass="form-control" placeholder="Description of table" type="text"/>
											</form:label>
            							</div>
            							<div class="form-group">
            								<form:label path="active">
												ACTIVE STATUS
												<form:select path="active" required="required" cssClass="form-control" >
													<form:option value="Yes" label="Yes"/>
													<form:option value="No" label="No"/>
												</form:select>
											</form:label>
            							</div>
            							<div class="form-group">
            								<label for="totalColumns">
												Name
												<input name="totalColumns" required  class="form-control" placeholder="No of columns" type="number"/>
											</label>
            							</div>
            							<div class="form-group">
            								<button type="submit" class="btn btn-default">Proceed to add fields</button>
            							</div>
            						</form:form>
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
