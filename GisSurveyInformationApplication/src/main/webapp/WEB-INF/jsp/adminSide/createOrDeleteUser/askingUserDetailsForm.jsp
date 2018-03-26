					<div class="panel panel-info">
            			<div class="panel-heading">
            				Give details of user
            			</div>
            			<div class="panel-body">
            				<div class="row">
            					<div class="col-lg-6">
            						<form:form action="${pageContext.request.contextPath}/admin/user/${link}" method="post" commandName="userDetails">
            							<div class="form-group">
            								<form:label path="name">
												NAME
												<form:input path="name" required="required" cssClass="form-control" placeholder="Name.." type="text"/>
											</form:label>
            							</div>
            							<div class="form-group">
            								<form:label path="username">
												USERNAME
												<form:input path="username" required="required" cssClass="form-control" placeholder="Username.." type="text"/>
											</form:label>
            							</div>
            							<div class="form-group">
            								<form:label path="password">
												PASSWORD
												<form:input path="password" required="required" cssClass="form-control" placeholder="User Password.." type="password"/>
											</form:label>
            							</div>
            							<div class="form-group">
            								<button type="submit" class="btn btn-default">${process} now</button>
            							</div>
            						</form:form>
            					</div>
            				</div>
            			</div>
            		</div>