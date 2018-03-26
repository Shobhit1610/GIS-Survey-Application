<%@include file="/WEB-INF/html/head/directives.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Add Table</title>
		<%@include file="/WEB-INF/html/head/csslinks.html" %>
		<style>
			.table-field-form
			{}
			
		</style>
</head>

<body>
	<%@include file="/WEB-INF/html/body/adminnavigationheader.html" %>
		<div id="wrapper">
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Add Table</h1>
                </div>
            </div>
            <div class="row">
            	<div class="col-lg-12">
        			<div class="panel panel-info">
            			<div class="panel-heading">
            				Table details..
            			</div>
            			<div class="panel-body" id="panel-body" >
            				<div class="row">
            					<form:form cssClass="table-field-form" action="${pageContext.request.contextPath}/admin/table/addTable" method="post" commandName="tablenamedetails">
            						<div class="col-lg-3">
            							<div class="form-group">
            								<form:label path="dataTypeName">
												NAME OF TABLE
												<form:input path="dataTypeName" required="required" cssClass="form-control" placeholder="Name of table" type="text"/>
											</form:label>
            							</div>
            						</div>
            						<div class="col-lg-3">
            							<div class="form-group">
            								<form:label path="dataTypeDescription">
												DESCRIPTION OF TABLE
												<form:input path="dataTypeDescription" required="required" cssClass="form-control" placeholder="Description of table" type="text"/>
											</form:label>
            							</div>
            						</div>
            						<div class="col-lg-3">
            							<div class="form-group">
            								<form:label path="active">
												ACTIVE STATUS
												<form:select path="active" required="required" cssClass="form-control" >
													<form:option value="Yes" label="Yes"/>
													<form:option value="No" label="No"/>
												</form:select>
											</form:label>
            							</div>
            						</div>
            					</form:form>
            						<div class="col-lg-3">
            							<div class="form-group">
            								<button id="add-field-button" class="btn btn-outline btn-primary btn-lg btn-block" type="button" style="border:none;">
                  								Add Fields
                  							</button>
            							</div>
            						</div>
            				</div>
            				<form:form cssClass="table-field-form" action="${pageContext.request.contextPath}/admin/table/addTable" method="post" commandName="tableFieldList">
            				
            			</div>
            				</form:form>
            			<div class="panel-footer">
            				<div class="row">
            					<div class = "col-lg-6">
            						<button  id="submit-form-button" class="btn btn-outline btn-primary btn-lg btn-block" type="submit" style="border:none;" >
                  								Submit Form
                  					</button>
            					</div>
            					<div class = "col-lg-6">
            						<button id="remove-field-button" class="btn btn-outline btn-primary btn-lg btn-block" type="button" style="border:none;" >
                  								Remove Extra Field
                  					</button>
            					</div>
            				</div>
            			</div>	
           			</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	
<%@include file="/WEB-INF/html/body/jsscripts.html" %> 
<script type="text/javascript">
	var count = 1
	
	var addFieldButton = document.getElementById("add-field-button");
	var removeFieldButton = document.getElementById("remove-field-button");
	var submitFormButton = document.getElementById("submit-form-button");
	var tableNameForm = document.getElementById("table-name-form");
	var panelBody = document.getElementById("panel-body");
    
	addFieldButton.onclick = function(){
		var field = document.createElement('div');
			field.id = count;
			field.innerHTML = '<div class="row">\r\n' + 
		    '                				<div class="col-lg-12">\r\n' + 
		    '                    				<h4 class="page-header">Details of Field '+count+'</h4>\r\n' + 
		    '                				</div>\r\n' + 
		    '            				</div>\r\n' + 
		    '            				<form:form cssClass="table-field-form" action="${pageContext.request.contextPath}/admin/table/addTable" method="post" commandName="tableFieldList">\r\n' + 
		    '               				<div class="row">\r\n' + 
		    '            					<div class="col-lg-4">\r\n' + 
		    '										<div class="form-group">\r\n' + 
		    '            								<label for="tableFieldList['+count+'].fieldLabel">\r\n' + 
		    '												FIELD LABEL\r\n' + 
		    '												<input name="tableFieldList['+count+'].fieldLabel" required class="form-control" placeholder="Name of field" type="text"/>\r\n' + 
		    '											</label>\r\n'+ 
		    '            							</div>\r\n' + 
		    '            					</div>\r\n' + 
		    '            					<div class="col-lg-4">		\r\n' + 
		    '            							<div class="form-group">\r\n' + 
		    '            								<label for="tableFieldList['+count+'].fieldDesc">\r\n' + 
		    '												DESCRIPTION OF FIELD\r\n' + 
		    '												<input path="tableFieldList['+count+'].fieldDesc" required class="form-control" placeholder="Description of field" type="text"/>\r\n' + 
		    '											</label>\r\n' + 
		    '            							</div>\r\n' + 
		    '            					</div>\r\n' + 
		    '            					<div class="col-lg-4">\r\n' + 
		    '            						 <div class="form-group">\r\n' + 
		    '            								<label for="tableFieldList['+count+'].fieldType">\r\n' + 
		    '												FIELD TYPE\r\n' + 
		    '													<select path="tableFieldList['+count+'].fieldType" required class="form-control">\r\n' + 
		    '														<option value="string" label="Text"/>\r\n' + 
		    '														<option value="number" label="Integer"/>\r\n' + 
		    '														<option value="decimal(4,2)" label="Real"/>\r\n' + 
		    '													</select>\r\n' + 
		    '											</label>\r\n' + 
		    '            							</div>\r\n' + 
		    '            					</div>\r\n' + 
		    '            				</div>\r\n' + 
		    '            				<div class="row">\r\n' + 
		    '            					<div class="col-lg-4">		\r\n' + 
		    '            							<div class="form-group">\r\n' + 
		    '            									<label for="fieldRequired">\r\n' + 
		    '												FIELD REQUIRED\r\n' + 
		    '													<select name="tableFieldList['+count+'].fieldRequired" required class="form-control">\r\n' + 
		    '														<option value="Yes" label="Yes"/>\r\n' + 
		    '														<option value="No" label="No"/>\r\n' + 
		    '													</select>\r\n' + 
		    '												</label>\r\n' + 
		    '            							</div>\r\n' + 
		    '            					</div>\r\n' + 
		    '            					<div class="col-lg-4">		\r\n' + 
		    '            							<div class="form-group">\r\n' + 
		    '								            	<label for="tableFieldList['+count+'].sequence">\r\n' + 
		    '												SEQUENCE\r\n' + 
		    '													<input name="tableFieldList['+count+'].sequence" class="form-control" required/>\r\n' + 
		    '												</label>	\r\n' + 
		    '										</div>\r\n' + 
		    '								</div>\r\n' + 
		    '								<div class="col-lg-4">\r\n' + 
		    '									<div class="form-group">\r\n' + 
		    '            							<input type="hidden" name="tableFieldList['+count+'].dataType" value="ACTIVITY"/>\r\n' + 
		    '										<input type="hidden" name="tableFieldList['+count+'].dataTypeID" value="${requestScope.datatypeid}"/>\r\n' + 
		    '									</div>\r\n' + 
		    '								</div>		\r\n' + 
		    '							</div>\r\n' + 
		    '            				</form:form>\r\n' + 
		    '            				<div class="row">\r\n' + 
		    '                				<div class="col-lg-12">\r\n' + 
		    '                    				<h4 class="page-header"></h4>\r\n' + 
		    '                				</div>\r\n' + 
		    '            				</div>';
		    panelBody.appendChild(field);
		    count++;
	};
	
	removeFieldButton.onclick = function(){
		var field = document.getElementById(count-1);
			field.parentNode.removeChild(field);
		count--;	
	};
	
	submitFormButton.onclick = function(){
		var x = document.querySelectorAll(".table-field-form");
		var i;
		for(i=0;i<x.length;i++){
				x[i].submit();
			}
		
	};
	
</script>
</body>
</html>
