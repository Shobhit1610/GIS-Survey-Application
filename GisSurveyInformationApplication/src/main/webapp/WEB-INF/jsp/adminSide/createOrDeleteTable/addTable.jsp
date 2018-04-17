<%@page import="oro.gis.model.TableFieldsModel"%>
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
                    <h1 class="page-header">Add Table</h1>
                </div>
            </div>
            <div class="row">
            	<div class="col-lg-12">
        			<div class="panel panel-info">
            			<div class="panel-heading">
            				Give details of table
            			</div>
       					<form action="${pageContext.request.contextPath}/admin/table/addTable" method="post" >
               			<input type="hidden" name="field-no" id="field-no" value="1">
               			<div class="panel-body" id="panel-body" >
	        				<div class="row">
                 				<div class="col-lg-3">
            						<div class="form-group">
            							<label for="tablename.dataTypeName">
											NAME OF TABLE
											<input name="tablename.dataTypeName" required class="form-control" placeholder="Name of table" type="text"/>
										</label>
            						</div>
            					</div>
            					<div class="col-lg-3">
            						<div class="form-group">
            							<label for="tablename.dataTypeDescription">
											DESCRIPTION OF TABLE
											<input name="tablename.dataTypeDescription" required class="form-control" placeholder="Description of table" type="text"/>
										</label>
            						</div>
            					</div>
            					<div class="col-lg-3">
            						<div class="form-group">
            							<label for="tablename.active">
											ACTIVE STATUS
											<select name="tablename.active" required class="form-control" >
													<option value="Yes">Yes</option>
													<option value="No">NO</option>
											</select>
										</label>
            						</div>
            					</div>
            					<div class="col-lg-3">
            						<div class="form-group">
            							<button id="add-field-button" class="btn btn-outline btn-primary btn-lg btn-block" type="button" style="border:none;">
               								Add Fields
               							</button>
            						</div>
            					</div>
             				</div>
            				<div class="row">
            					<div class="col-lg-12">
            						<h4 class="page-header">Details of Field 1</h4>
            					</div>
            				</div>
            				<div class="row">
            					<div class="col-lg-4">
            						<div class="form-group">
            							<label for="field[0].fieldLabel">
            								FIELD LABEL
            								<input name="field[0].fieldLabel" required class="form-control" placeholder="Name of field" type="text"/>
            							</label>
            						</div>
            					</div>
            					<div class="col-lg-4">
            						<div class="form-group">
            							<label for="field[0].fieldDesc">
            								DESCRIPTION OF FIELD
            								<input name="field[0].fieldDesc" required class="form-control" placeholder="Description of field" type="text"/>
            							</label>
            						</div>
            					</div>
            					<div class="col-lg-4">
            						<div class="form-group">
            							<label for="field[0].fieldType">
            								FIELD TYPE
            								<select name="field[0].fieldType" required class="form-control">
            									<option value="String">Text (String)</option>
            									<option value="Number">Integer (Number)</option>
            									<option value="Decimal(4,2)">Real (Decimal)</option>
            								</select>
            							</label>
            						</div>
            					</div>
            				</div>
            				<div class="row">
            					<div class="col-lg-4">
            						<div class="form-group">
            							<label for="field[0].fieldRequired">
            								FIELD REQUIRED
            								<select name="field[0].fieldRequired" required class="form-control">
            									<option value="Yes">Yes</option>
            									<option value="No">No</option>
            								</select>
            							</label>
            						</div>
            					</div>
            					<div class="col-lg-4">
            						<div class="form-group">
            							<label for="field[0].sequence">
            								SEQUENCE
            								<input name="field[0].sequence" readonly value ="0" class="form-control" required/>
            							</label>
            						</div>
            					</div>
            					<div class="col-lg-4">
            						<div class="form-group">
            							<input type="hidden" name="field[0].dataType" value="ACTIVITY"/>
            						</div>
            					</div>
            				</div>
            				<div class="row">
            					<div class="col-lg-12">
            						<h4 class="page-header"></h4>
            					</div>
            				</div>
	
            				</div>
            			
            			<div class="panel-footer">
                            	<div class="row">
                                	<div class="col-lg-6">
                                		<button class="btn btn-outline btn-primary btn-lg btn-block" type="submit" style="border:none;">
                  							Submit Form
                  						</button>
                                   	</div>
                                	<div class="col-lg-6">
                                		<a href = "${pageContext.request.contextPath}/admin" style="text-decoration: none;">
                               			<button class="btn btn-outline btn-primary btn-lg btn-block" type="button" style="border:none;">
                  								Back to Panel
                  						</button>
                  						</a>
            						</div>
                                </div> 
                          </div>
                        </form>
           			</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	
<%@include file="/WEB-INF/html/body/jsscripts.html" %> 
<script type="text/javascript">
	
	$(document).ready(
						function(){
									$('#add-field-button').on("click",function(){
																					var a = $('#field-no').val();
																					var b = a;
																					b++;
																					var field = '<div class="row" >\r\n' + 
																				    '                				<div class="col-lg-12">\r\n' + 
																				    '                    				<h4 class="page-header">Details of Field '+b+'</h4>\r\n' + 
																				    '                				</div>\r\n' + 
																				    '            				</div>\r\n' +
																				    '								<div class="row">\r\n' + 
																				    '            					<div class="col-lg-4">\r\n' + 
																				    '										<div class="form-group">\r\n' + 
																				    '            								<label for="field['+a+'].fieldLabel">\r\n' + 
																				    '												FIELD LABEL\r\n' + 
																				    '												<input name="field['+a+'].fieldLabel" required class="form-control" placeholder="Name of field" type="text"/>\r\n' + 
																				    '											</label>\r\n'+ 
																				    '            							</div>\r\n' + 
																				    '            					</div>\r\n' + 
																				    '            					<div class="col-lg-4">		\r\n' + 
																				    '            							<div class="form-group">\r\n' + 
																				    '            								<label for="field['+a+'].fieldDesc">\r\n' + 
																				    '												DESCRIPTION OF FIELD\r\n' + 
																				    '												<input name="field['+a+'].fieldDesc" required class="form-control" placeholder="Description of field" type="text"/>\r\n' + 
																				    '											</label>\r\n' + 
																				    '            							</div>\r\n' + 
																				    '            					</div>\r\n' + 
																				    '            					<div class="col-lg-4">\r\n' + 
																				    '            						 <div class="form-group">\r\n' + 
																				    '            								<label for="field['+a+'].fieldType">\r\n' + 
																				    '												FIELD TYPE\r\n' + 
																				    '													<select name="field['+a+'].fieldType" required class="form-control">\r\n' + 
																				    '														<option value="String">Text (String)</option>\r\n' + 
																				    '														<option value="Number">Integer (Number)</option>\r\n' + 
																				    '														<option value="Decimal(4,2)">Real (Decimal)</option>\r\n' + 
																				    '													</select>\r\n' + 
																				    '											</label>\r\n' + 
																				    '            							</div>\r\n' + 
																				    '            					</div>\r\n' + 
																				    '            				</div>\r\n' + 
																				    '            				<div class="row">\r\n' + 
																				    '            					<div class="col-lg-4">		\r\n' + 
																				    '            							<div class="form-group">\r\n' + 
																				    '            									<label for="field['+a+'].fieldRequired">\r\n' + 
																				    '												FIELD REQUIRED\r\n' + 
																				    '													<select name="field['+a+'].fieldRequired" required class="form-control">\r\n' + 
																				    '														<option value="Yes">Yes</option>\r\n' + 
																				    '														<option value="No">No</option>\r\n' + 
																				    '													</select>\r\n' + 
																				    '												</label>\r\n' + 
																				    '            							</div>\r\n' + 
																				    '            					</div>\r\n' + 
																				    '            					<div class="col-lg-4">		\r\n' + 
																				    '            							<div class="form-group">\r\n' + 
																				    '								            	<label for="field['+a+'].sequence">\r\n' + 
																				    '												SEQUENCE\r\n' + 
																				    '													<input name="field['+a+'].sequence" readonly value ="'+a+'" class="form-control" required/>\r\n' + 
																				    '												</label>	\r\n' + 
																				    '										</div>\r\n' + 
																				    '								</div>\r\n' + 
																				    '								<div class="col-lg-4">\r\n' + 
																				    '									<div class="form-group">\r\n' + 
																				    '            							<input type="hidden" name="field['+a+'].dataType" value="ACTIVITY"/>\r\n' + 
																				    '									</div>\r\n' + 
																				    '								</div>		\r\n' + 
																				    '							</div>\r\n' + 
																				    '            				<div class="row">\r\n' + 
																				    '                				<div class="col-lg-12">\r\n' + 
																				    '                    				<h4 class="page-header"></h4>\r\n' + 
																				    '                				</div>\r\n' + 
																				    '            				</div>';
																			
																	
																					$('#panel-body').append(field);
																					$('#field-no').val(Number(a)+1);
																				}
														)
							
							})
	
		
	
	
</script>
</body>
</html>