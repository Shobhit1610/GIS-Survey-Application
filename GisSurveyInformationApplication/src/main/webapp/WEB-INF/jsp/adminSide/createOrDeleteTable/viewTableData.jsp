<%@include file="/WEB-INF/html/head/directives.html" %>
<%@page import ="java.util.List" %>
<%@page import ="java.util.ArrayList" %>
<%@page import ="oro.gis.model.EntryValuesModel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Table Data</title>
		<%@include file="/WEB-INF/html/head/csslinks.html" %>
</head>
<body>
	<%@include file="/WEB-INF/html/body/adminnavigationheader.html" %>
	<div id="wrapper">
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${tableName.getDataTypeName()}</h1>
                </div>
            </div>
            <div class="row">
            	<div class="col-lg-12">
            		<div class="form-group">
            			<div class="panel panel-info">
            			<div class="panel-body">
            				<div class = "row">
            					<div class= "col-lg-6">
            						<h4>Description : <i>${tableName.getDataTypeDescription()}</i></h4>
            					</div>
            					<div class="col-lg-6">
            						<h4>Active      : <i>${tableName.getActive()}</i></h4>
								</div>
            				</div>
            				<div class="table-responsive">
            					<table class="table table-hover">
            						<thead>
            							<tr >
            								<th>S.No (Click to edit)</th>
            								<stl:forEach var="field" items="${tableFieldsList}">
            									<th>${field.getFieldLabel()}</th>
            								</stl:forEach>
										</tr>
            						</thead>
            						<tbody>
            						
            							<%
										List<List<EntryValuesModel>> modalMap = (List<List<EntryValuesModel>>)request.getAttribute("modalMap");
										for(int i=0;i<modalMap.get(0).size();i++)
										{
											%>
											<tr>
												<td>
													<a href="${pageContext.request.contextPath}/admin/table/editTableData?tableid=${tableName.getDataTypeID()}&row=<%out.println(i);%>"><%out.println(i+1); %></a>	
												</td>
												<%
													for(int j=0;j<modalMap.size();j++)
													{
														%>
															<td>
																<%
																	out.println(modalMap.get(j).get(i).getFieldValue());
																%>
															</td>
														<%										
													}
												%>											
											</tr>
											<%		
										}
										%>
            						</tbody>
            					</table>
            				</div>
            			</div>
            			<div class="panel-footer">
                            	<div class="row">
                                	<div class="col-lg-12">
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
    </div>
    <%@include file="/WEB-INF/html/body/jsscripts.html" %> 
</body>
</html>
		