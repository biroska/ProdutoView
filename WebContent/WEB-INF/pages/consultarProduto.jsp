<%@include file="template/menu.jsp"%>
<script>

	$(document).ready(function() {
	    $('#tabelaProdutos').DataTable({
	    	fixedHeader: true,
	    	colReorder: true,
	        responsive: true,
	        select: true
	    });
	} );

</script>
<body>
<form:form id="productForm" method="post" modelAttribute="produto" action="${pageContext.request.contextPath}/product/save">
<div class="container" style="width: 98%;" >
	
	<!-- TABLE TESTE  -->
	<div class="panel panel-default">
		<div class="panel-heading">Panel heading</div>
			<div class="panel-body">
				<table id="tabelaProdutos" class="table table-striped table-hover table-bordered">
					<thead>
						<td>C&oacute;digo</td>
						<td>Nome</td>
						<td>Descriчуo</td>
						<td>Imagem</td>
					</thead>
		    		<tr>
		    			<td>cod123</td>
						<td>Produto_1</td>
						<td>Produto_1 щ bla bla bla</td>
						<td>Imagem_1</td>
		    		</tr>
		    		<tr>
		    			<td>cod456</td>
						<td>Produto_2</td>
						<td>Produto_2 щ bla bla bla</td>
						<td>Imagem_2</td>
		    		</tr>
		    		<tr>
		    			<td>cod789</td>
						<td>Produto_3</td>
						<td>Produto_3 щ bla bla bla</td>
						<td>Imagem_3</td>
		    		</tr>
		    		<tr>
		    			<td>codqe</td>
						<td>Produto_4</td>
						<td>Produto_4 щ bla bla bla</td>
						<td>Imagem_4</td>
		    		</tr>
		    		<tr>
		    			<td>codasd</td>
						<td>Produto_5</td>
						<td>Produto_5 щ bla bla bla</td>
						<td>Imagem_5</td>
		    		</tr>
		    		<tr>
		    			<td>codzxc</td>
						<td>Produto_6</td>
						<td>Produto_6 щ bla bla bla</td>
						<td>Imagem_6</td>
		    		</tr>
		    		<tr>
		    			<td>codrty</td>
						<td>Produto_7</td>
						<td>Produto_7 щ bla bla bla</td>
						<td>Imagem_7</td>
		    		</tr>
		    		<tr>
		    			<td>codfgh</td>
						<td>Produto_8</td>
						<td>Produto_8 щ bla bla bla</td>
						<td>Imagem_8</td>
		    		</tr>
		    		<tr>
		    			<td>codvbn</td>
						<td>Produto_9</td>
						<td>Produto_9 щ bla bla bla</td>
						<td>Imagem_9</td>
		    		</tr>
		    		<tr>
		    			<td>coduio</td>
						<td>Produto_10</td>
						<td>Produto_10 щ bla bla bla</td>
						<td>Imagem_10</td>
		    		</tr>
		    		<tr>
		    			<td>codjkl</td>
						<td>Produto_11</td>
						<td>Produto_11 щ bla bla bla</td>
						<td>Imagem_11</td>
		    		</tr>
		    		<tr>
		    			<td>codbnm</td>
						<td>Produto_12</td>
						<td>Produto_12 щ bla bla bla</td>
						<td>Imagem_12</td>
		    		</tr>
		    		<tr>
		    			<td>codzse</td>
						<td>Produto_13</td>
						<td>Produto_13 щ bla bla bla</td>
						<td>Imagem_13</td>
		    		</tr>
		    		<tr>
		    			<td>codcft</td>
						<td>Produto_14</td>
						<td>Produto_14 щ bla bla bla</td>
						<td>Imagem_14</td>
		    		</tr>
		    		<tr>
		    			<td>codxdr</td>
						<td>Produto_15</td>
						<td>Produto_15 щ bla bla bla</td>
						<td>Imagem_15</td>
		    		</tr>
		    		<tr>
		    			<td>codvgy</td>
						<td>Produto_16</td>
						<td>Produto_16 щ bla bla bla</td>
						<td>Imagem_16</td>
		    		</tr>
		    		<tr>
		    			<td>codbhu</td>
						<td>Produto_17</td>
						<td>Produto_17 щ bla bla bla</td>
						<td>Imagem_17</td>
		    		</tr>
		    		<tr>
		    			<td>codnji</td>
						<td>Produto_18</td>
						<td>Produto_18 щ bla bla bla</td>
						<td>Imagem_18</td>
		    		</tr>
		    		<tr>
		    			<td>codmko</td>
						<td>Produto_19</td>
						<td>Produto_19 щ bla bla bla</td>
						<td>Imagem_19</td>
		    		</tr>
				</table>
			</div>
	</div>
	
</div>
</form:form>
</body>
<%@include file="template/footer.jsp"%>