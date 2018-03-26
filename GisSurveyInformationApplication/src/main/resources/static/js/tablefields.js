function addFields()
{
	var x = document.getElementById("field-area");
	x.innerHTML+='<form:form action="${pageContext.request.contextPath}/admin/table/addTable" method="post" commandName="tablenamedetails">'+
'<form:form action="${pageContext.request.contextPath}/admin/table/addTable" method="post" commandName="tablefieldsdetails">'+
'<div class="row">'+
'	<div class="col-lg-6">'+
'		<div class="form-group">'+
'			<form:label path="fieldLabel">'+
'				FIELD LABEL'+
'				<form:input path="fieldLabel" required="required" cssClass="form-control" placeholder="Name of field" type="text"/>'+
'			</form:label>'+
'		</div>'+
'	</div>'+
'	<div class="col-lg-6">'+
'		<div class="form-group">'+
'			<form:label path="fieldDesc">'+
'				DESCRIPTION OF FIELD'+
'				<form:input path="fieldDesc" required="required" cssClass="form-control" placeholder="Description of field" type="text"/>'+
'			</form:label>'+
'		</div>'+
'	</div>'+
'</div>'+
'<div class="row">'+
'	<div class="col-lg-4">'+
'		<div class="form-group">'+
'			<form:label path="fieldType">'+
'				FIELD TYPE'+
'					<form:select path="fieldType" required="required" cssClass="form-control">'+
'						<form:option value="string" label="Text"/>'+
'						<form:option value="number" label="Integer"/>'+
'						<form:option value="decimal(4,2)" label="Real"/>'+
'					</form:select>'+
'			</form:label>'+
'		</div>'+
'	</div>'+
'	<div class="col-lg-4">'+ 
'		<div class="form-group">'+
'				<form:label path="fieldRequired">'+
'				FIELD REQUIRED'+
'					<form:select path="fieldRequired" required="required" cssClass="form-control">'+
'						<form:option value="Yes" label="Yes"/>'+
'						<form:option value="No" label="No"/>'+
'					</form:select>'+
'				</form:label>'+
'		</div>'+
'	</div>'+
'	<div class="col-lg-4">'+
'		<div class="form-group">'+
'           	<form:label path="sequence" required="required" cssClass="form-control">'+
'				SEQUENCE'+
'					<form:input path="sequence"/>'+
'				</form:label>'+	
'		</div>'+
'	</div>'+
'</div>'+
'<div class="row">'+
'	<div class="col-lg-6">'+
'		<form:hidden value="ACTIVITY" path="dataType"/>'+
'		<form:hidden value="${requestScope.datatypeid}" path="dataTypeID"/>'+
'	</div>'+
'</div>'+
'</form:form>';
}	