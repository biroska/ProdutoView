<%@include file="header.jsp"%>
<body>
<div class="container" style="width: 98%;" >
<div class="bs-example" data-example-id="nav-tabs-with-dropdown">
	<ul class="nav nav-tabs">
		<li role="presentation" class="dropdown ${MENU == null || MENU == "" ? "active" : null }">
		
			<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
				Cadastros Básicos <span class="caret"></span>
			</a>
			<ul class="dropdown-menu">
				<li role="presentation">
					<a href="#">
						Tipos
					</a>
				</li> 
			</ul>
		</li>
		<li role="presentation" class="dropdown ${MENU == "PRODUTO" ? "active" : null }" >
			
			<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
				Produtos <span class="caret"></span>
			</a>
			<ul class="dropdown-menu">
				<li role="presentation">
					<a href="${pageContext.request.contextPath}/product/">Cadastrar</a>
				</li>
				<li role="presentation">
					<a href="${pageContext.request.contextPath}/product/searchProduct/">Consultar</a>
				</li>
			</ul>
		</li>
	</ul>
</div>
</div>
</body>
<br/>
<%@include file="footer.jsp"%>