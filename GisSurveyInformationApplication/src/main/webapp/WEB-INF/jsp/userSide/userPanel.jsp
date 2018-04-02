<%@include file="/WEB-INF/html/head/directives.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>User Panel</title>
		<%@include file="/WEB-INF/html/head/csslinks.html" %>
</head>
<body>
	
	<%@include file="/WEB-INF/html/body/usernavigationheader.html" %>


        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header text-center">User Panel</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
             <div class="row">
            	<div class="col-lg-12">
            		<div class="form-group">
            		
            			<div class="panel panel-info">
            			<div class="panel-heading">
            				All tables are
            			</div>
            			<div class="panel-body">
            				<stl:choose>
            				<stl:when test="${! empty details}">
            				<div class="table-responsive">
            					<table class="table table-hover">
            						<thead>
            							<tr>
            								<th>ID</th>
											<th>Name</th>
											<th>Description</th>
											<th>Active</th>
										</tr>
            						</thead>
            						<tbody>
            							<stl:forEach var="table" items="${details}">
											<tr class='clickable-row' data-href="${pageContext.request.contextPath}/user/addEntry?tableid=${table.data_type_id}">
												 <td>${table.data_type_id}</td>
												<td>${table.data_type_name}</td>
												<td>${table.data_type_description}</td>
												<td>${table.active}</td>
											<tr>
										</stl:forEach>
            						</tbody>
            					</table>
            				</div>
            				</stl:when>
            				<stl:otherwise>
            					<h3>No data available</h3>
            				</stl:otherwise>
            				</stl:choose>
            			</div>
            		</div>
                  	</form>
	            	</div>
	            </div>
            </div>
            <div class="row">
               <div class="footer navbar-fixed-bottom text-right">
                  			<h3 class="text-center" style="paddingi-right:5px;padding-bottom:5px;">${confirmation}</h3>
                  </div>
               </div>
 </div>
   	<%@include file="/WEB-INF/html/body/jsscripts.html" %>
</body>
<script type="text/javascript">
$(document).ready(function($) {
    $(".clickable-row").click(function() {
        window.location = $(this).data("href");
    });
});
</script>
</html>
