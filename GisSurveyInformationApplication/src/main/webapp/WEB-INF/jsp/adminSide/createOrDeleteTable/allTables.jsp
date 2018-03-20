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
            								<stl:if test="${show}"><th></th></stl:if>
											<th>ID</th>
											<th>Name</th>
											<th>Description</th>
											<th>Active</th>
										</tr>
            						</thead>
            						<tbody>
            							<stl:forEach var="table" items="${details}">
											<tr>
												<stl:if test="${show}"><td><input type="radio" name="tableDeleted" value="${table.data_type_id}" class=""/></td></stl:if>
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