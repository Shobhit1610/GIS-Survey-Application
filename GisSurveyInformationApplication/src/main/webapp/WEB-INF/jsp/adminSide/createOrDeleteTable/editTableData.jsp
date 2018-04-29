<%@include file="/WEB-INF/html/head/directives.html" %>
<%@page import ="java.util.List" %>
<%@page import ="java.util.ArrayList" %>
<%@page import ="oro.gis.model.EntryValuesModel" %>
<%@page import ="oro.gis.model.TableFieldsModel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Edit Data</title>
		<%@include file="/WEB-INF/html/head/csslinks.html" %>
</head>

<body>
	<%@include file="/WEB-INF/html/body/adminnavigationheader.html" %>
	<div id="wrapper">
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Edit Data</h1>
                </div>
            </div>
            <div class="row">
            	<div class="col-lg-12">
            		<div class="panel panel-info">
            			<div class="panel-heading">
            				Enter field values
            			</div>
            			<div class="panel-body">
            				<form action="${pageContext.request.contextPath}/admin/table/editTableData" method="post">
            				<stl:choose>
            				<stl:when test="${! empty fielddetails}">
            				<div class="table-responsive">
            					<table class="table table-hover">
            						<thead>
            							<tr>
											<th>Table ID : ${tabledetails.getDataTypeID()}</th>
											<th>FIELD</th>
											<th>VALUES</th>
										</tr>
            						</thead>
            						<tbody>
            							<%
            							List<List<EntryValuesModel>> modalMap = (List<List<EntryValuesModel>>)request.getAttribute("modalmap");
            							List<TableFieldsModel> tableFieldsList = (List<TableFieldsModel>)request.getAttribute("fielddetails");
            							int rowNumber = (Integer)request.getAttribute("rownumber");
            							
            							//System.out.println(modalMap.size());
            							//System.out.println(tableFieldsList.size());
            							for(int i = 0 ;i<tableFieldsList.size();i++)
            							{
            								try
            								{
            									modalMap.get(i).get(rowNumber).getFieldValue();
            							%>
            							<tr>
            								<td></td>
        									<td><h4><%out.println(tableFieldsList.get(i).getFieldLabel()); %></h4></td>
        									<td>
														<div class="form-group">
            												<input name="<%out.print(tableFieldsList.get(i).getFieldID());%>" required class="form-control" type="text" value="<%out.println(modalMap.get(i).get(rowNumber).getFieldValue());%>"/>
														</div>
											</td>
		    							</tr>
		    							<%
		    							
            								}
            								catch(Exception e)
            								{
            									
            								}
            							}	
            								%>
            						</tbody>
            					</table>
            				</div>
            				</stl:when>
            				<stl:otherwise>
            					<h3>No data to submit</h3>
            				</stl:otherwise>
            				</stl:choose>
            			</div>
            			<div class="panel-footer">
                             <div class="row">
                             	<div class="col-xs-6">
                             		<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit" style="border:none;">
                  								Enter data
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
