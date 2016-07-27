<%@include file="template/menu.jsp"%>
<script>

	$(document).ready(function() {
	    $('#tabelaProdutos').DataTable({
	    	"fixedHeader": true,
	    	"colReorder": true,
	        "responsive": true,
	        "select": true,
	    	"processing": true,
	        "serverSide": true,
	        "ajax": {
	            "url": '${pageContext.request.contextPath}/product/testJSON' ,
	            "type": "POST"
	        },
	        "columns": [
	            { "data": "first_name" },
	            { "data": "last_name" },
	            { "data": "position" },
	            { "data": "office" },
	            { "data": "start_date" },
	            { "data": "salary" }
	        ]
	    
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
			            <tr>
			                <th>First name</th>
			                <th>Last name</th>
			                <th>Position</th>
			                <th>Office</th>
			                <th>Start date</th>
			                <th>Salary</th>
			            </tr>
			        </thead>
			        <tfoot>
			            <tr>
			                <th>First name</th>
			                <th>Last name</th>
			                <th>Position</th>
			                <th>Office</th>
			                <th>Start date</th>
			                <th>Salary</th>
			            </tr>
			        </tfoot>
				</table>
			</div>
	</div>
	
</div>
</form:form>
</body>
<%@include file="template/footer.jsp"%>