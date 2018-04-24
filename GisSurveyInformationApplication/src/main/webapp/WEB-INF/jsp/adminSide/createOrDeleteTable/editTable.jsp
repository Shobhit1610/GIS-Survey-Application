<%@include file="/WEB-INF/html/head/directives.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Edit Table</title>
		<%@include file="/WEB-INF/html/head/csslinks.html" %>
</head>

<body>
	<%@include file="/WEB-INF/html/body/adminnavigationheader.html" %>
	<div id="wrapper">
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Edit Table</h1>
                </div>
            </div>
            <div class="row">
            	<div class="col-lg-12">
            		<div class="panel panel-info">
            			<div class="panel-heading">
            				Give details of table
            			</div>
            			<div class="panel-body">
            				<form action="${pageContext.request.contextPath}/admin/table/editTable" method="post">
            				<div class="row">
            					<div class="col-lg-12">
            						<div class="table-responsive">
            							<table class="table table-hover">
            								<thead>
            									<tr>
            										<input type="hidden" name="tablename.dataTypeId" value="${oldtablenamedetails.getDataTypeID()}"/>
            										<th>Table ID : ${oldtablenamedetails.getDataTypeID()}</th>
													<!-- <th>OLD Details</th>
													 -->
													 <th>NEW Details</th>
												</tr>
        		    						</thead>
            								<tbody>
	            								<tr>
													<td>NAME</td>
													<%-- <td>
														<div class="form-group">
															<input value="${oldtablenamedetails.getDataTypeName()}" readonly class="form-control"/>
														</div>
													</td>
													 --%>
													 <td>
														<div class="form-group">
            												<input name="tablename.dataTypeName" required class="form-control"  type="text"/>
														</div>
													</td>
												<tr>
												<tr>
													<td>DESCRIPTON</td>
													<%-- <td>
														<div class="form-group">
															<input value="${oldtablenamedetails.getDataTypeDescription()}" readonly class="form-control"/>
														</div>		
													</td>
													 --%>
													 <td>
														<div class="form-group">
            												<input name="tablename.dataTypeDescription" required="required" class="form-control"  type="text"/>
														</div>
													</td>
												<tr>
												<tr>
													<td>ACTIVE</td>
													<%-- <td>
														<div class="form-group">
															<input value="${oldtablenamedetails.getActive()}" readonly="true" class="form-control"/>
														</div>
													</td>
													 --%>
													 <td>
														<div class="form-group">
            												<select name="tablename.active" required class="form-control" >
            													<option value="Yes">Yes</option>
            													<option value="No">No</option>
            												</select>
														</div>
													</td>
												<tr>
												
            								</tbody>
            							</table>
            						</div>
            					</div>
            				</div>
            				<div class="row">
            					<div class="col-lg-12">
            						<div class="table-responsive">
            							<stl:forEach var="field" items="${oldtablefieldsdetails}" varStatus="i">
            							<table class="table table-hover">
            								<thead>
            									<th>Field : ${i.count} </th>
												<!-- <th>OLD Details</th>
												 -->
												 <th>NEW Details</th>
            								</thead>
            								<tbody>
            										<tr></tr>
            										<tr>
            											<td>LABEL</td>
            											<%-- <td>
															<div class="form-group">
																<input value="${field.getFieldLabel()}" readonly class="form-control"/>
															</div>
														</td>
														 --%>
														 <td>
															<div class="form-group">
            													<input name ="field[${i.count}].fieldLabel" required class="form-control"  type="text"/>
															</div>
														</td>
            										</tr>
            										<tr>
            											<td>DESCRIPTION</td>
            											<%-- <td>
															<div class="form-group">
																<input value="${field.getFieldDesc()}" readonly class="form-control"/>
															</div>
														</td>
														 --%>
														 <td>
															<div class="form-group">
            													<input name ="field[${i.count}].fieldDesc" required class="form-control"  type="text"/>
															</div>
														</td>
            										</tr>
            										<tr>
            											<td>TYPE</td>
            											<%-- <td>
															<div class="form-group">
																<input value="${field.getFieldType()}" readonly class="form-control"/>
															</div>
														</td>
														 --%>
														 <td>
															<div class="form-group">
																<select name="field[${i.count}].fieldType" required class="form-control">
																	<option value="String">Text (String)</option>
																	<option value="Number">Integer (Number)</option>
																	<option value="Decimal(4,2)">Real (Decimal)</option>
																</select>
															</div>
														</td>
            										</tr>
            										<tr>
            											<td>REQUIRED</td>
            											<%-- <td>
															<div class="form-group">
																<input value="${field.getFieldRequired()}" readonly class="form-control"/>
															</div>
														</td>
														 --%>
														 <td>
															<div class="form-group">
																<select name="field[${i.count}].fieldRequired" required class="form-control">
																	<option value="Yes">Yes</option>
																	<option value="No">No</option>
																</select>
															</div>
														</td>
            										</tr>
            								</tbody>
            							</table>
            							<input type="hidden" name="field[${i.count}].fieldId" value="${field.getFieldID()}"/>
            							<input type="hidden" name="field[${i.count}].dataType" value="ACTIVITY"/>
            							<input type="hidden" name="field[${i.count}].dataTypeId" value="${oldtablenamedetails.getDataTypeID()}"/>
            							<input type="hidden" name="field[${i.count}].sequence" value="${field.getSequence()}"/>
            							</stl:forEach>
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
                  				</form>
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
