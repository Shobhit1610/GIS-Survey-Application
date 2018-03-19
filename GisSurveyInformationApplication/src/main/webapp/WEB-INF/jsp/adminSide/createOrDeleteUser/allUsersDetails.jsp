<div class="panel panel-info">
            			<div class="panel-heading">
            				All registered users are
            			</div>
            			<div class="panel-body">
            				<stl:choose>
            				<stl:when test="${! empty details}">
            				<div class="table-responsive">
            					<table class="table table-hover">
            						<thead>
            							<tr>
            								<stl:if test="${show}"><th></th></stl:if>
											<th>S.No</th>
											<th>Name</th>
											<th>UserName</th>
											<th>Password</th>
										</tr>
            						</thead>
            						<tbody>
            							<stl:forEach var="user" items="${details}">
											<tr>
												<stl:if test="${show}"><td><input type="radio" name="option" value="${user.user_id}" class=""/></td></stl:if>
												<td>${user.user_id}</td>
												<td>${user.name}</td>
												<td>${user.username}</td>
												<td>${user.password}</td>
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