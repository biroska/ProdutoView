<%@include file="header.jsp"%>
<body>
<div class="container" style="width: 98%;" >
<div class="bs-example" data-example-id="nav-tabs-with-dropdown">
	<ul class="nav nav-tabs">
		<li role="presentation" class="dropdown active">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
				Cadastros Básicos <span class="caret"></span>
			</a>
			<ul class="dropdown-menu">
				<li>
					<a href="#">Tipos</a>
				</li> 
			</ul>
		</li>
		<li role="presentation"><a href="${pageContext.request.contextPath}/product/">Produto</a></li>
	</ul>
</div>
</div>
</body>
<br/>
<%@include file="footer.jsp"%>