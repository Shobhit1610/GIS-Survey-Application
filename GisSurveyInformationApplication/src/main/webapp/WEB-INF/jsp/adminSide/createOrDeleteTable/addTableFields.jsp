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
                    <h1 class="page-header">Table fields details</h1>
                </div>
            </div>
            <div class="row">
            	<div class="col-lg-12">
            							<div class="panel panel-info">
            			<div class="panel-heading">
            				Field details..
            			</div>
            			<div class="panel-body">
            				<div class="row">
            					<div class="col-lg-6">
            					<stl:if test="${requestScope.noOfColumns > 0}">
									<form:form action="${pageContext.request.contextPath}/admin/table/addTable" method="post" commandName="tablefieldsdetails">
            							<div class="form-group">
            								<form:label path="fieldLabel">
												FIELD LABEL
												<form:input path="fieldLabel" required="required" cssClass="form-control" placeholder="Name of field" type="text"/>
											</form:label>
            							</div>
            							<div class="form-group">
            								<form:label path="fieldDesc">
												DESCRIPTION OF FIELD
												<form:input path="fieldDesc" required="required" cssClass="form-control" placeholder="Description of field" type="text"/>
											</form:label>
            							</div>
            							<div class="form-group">
            								<form:label path="fieldType">
												FIELD TYPE
													<form:select path="fieldType" required="required" cssClass="form-control">
														<form:option value="string" label="Text"/>
														<form:option value="number" label="Integer"/>
														<form:option value="decimal(4,2)" label="Real"/>
													</form:select>
											</form:label>
            							</div>
            							<div class="form-group">
            								<form:label path="dataType">
												DATA TYPE
												<form:input path="dataType" value="ACTIVITY" readonly="true" cssClass="form-control"/>
											</form:label>
            							</div>
            							<div class="form-group">
            								<form:label path="dataTypeID">
												DATA TYPE ID
												<form:input path="dataTypeID" value="${requestScope.datatypeid}" readonly="true" cssClass="form-control"/>
											</form:label>
            							</div>
            							<div class="form-group">
            									<form:label path="fieldRequired">
												FIELD REQUIRED
													<form:select path="fieldRequired" required="required" cssClass="form-control">
														<form:option value="Yes" label="Yes"/>
														<form:option value="No" label="No"/>
													</form:select>
												</form:label>
            							</div>
            							<div class="form-group">
								            	<form:label path="sequence" required="required" cssClass="form-control">
												SEQUENCE
													<form:input path="sequence"/>
												</form:label>	
										</div>
            							
            							<div class="form-group">
            								<button type="submit" class="btn btn-default">Proceed</button>
            							</div>
            						</form:form>
            						</stl:if>
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

  