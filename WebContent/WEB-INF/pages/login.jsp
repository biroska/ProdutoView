<%@include file="template/header.jsp"%>
<body>
<div class="container" style="width: 90%;" >
	<div class="panel panel-info">
	<div class="panel-heading">Login</div>
	<form:form id="form" method="POST" modelAttribute="user" action="${pageContext.request.contextPath}/login/login.html">
		<div class="panel-body">
			<div class="row">
				<div class="form-group col-md-8">
					<label class="col-md-4 control-lable" for="username">Username:</label>
					<div class="col-md-8">
						<form:input id="username" type="text" path="username" class="form-control input-sm" />
					</div>
				</div>
			</div>
		
			<div class="row">
				<div class="form-group col-md-8">
					<label class="col-md-4 control-lable" for="username">password:</label>
					<div class="col-md-8">
						<form:input id="password" type="password" path="password" class="form-control input-sm" />
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-8">
					<button type="button" class="btn btn-default" onclick="document.getElementById('form').submit();">Login</button>
				</div>
			</div>
		</div>
	</form:form>
	</div>
</div>
</body>
<%@include file="template/footer.jsp"%>