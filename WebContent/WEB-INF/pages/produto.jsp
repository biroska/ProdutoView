<%@include file="template/menu.jsp"%>
<script>

var first;

$(document).ready(function() {
	
	first = 1;
	
	disableCamera();
	hideCameraPicture();
	
	$('#tabelaProdutos').dynatable();
	
});

function saveProduct(){

	 var code = $('#code').val();
	 var name = $('#name').val();
	 var description = $('#description').val();
	 var image = $("#snapshot").attr('src');
	 
	 image = image.replace("data:image/jpeg;base64,", "");
	 
	 var json = { 'code' : code, 'name' : name, 'description' : description, 'image' : "" };
	 
	  $.ajax({
	  	url: '${pageContext.request.contextPath}/product/save' ,
	  	data: JSON.stringify(json),
	  	type: "POST",
	
	  	beforeSend: function(xhr) {
	  		xhr.setRequestHeader("Accept", "application/json");
	  		xhr.setRequestHeader("Content-Type", "application/json");
	  	},
	  	
	  	success: function( product ) {
	  		
	  		$('#code').val( product.code );
	  		$('#name').val( product.name );
	  		$('#description').val( product.description );
	  		$('#snapshot').attr('src', "data:image/jpeg;base64," + image );
	  	}
	  });
}

function oopsError(errorId,errorMsg) {
	alert(errorMsg);
}

function getSnapshot() {
	sendImage( $.scriptcam.getFrameAsBase64() );
}


function sendImage( obj ){
	
	var json = { "base64Image" : obj };
	
	$.ajax({
  		url: '${pageContext.request.contextPath}/product/testeCaptura' ,
  		data: JSON.stringify(json),
  		type: "POST",

  		beforeSend: function(xhr) {
  			/* xhr.setRequestHeader("Accept", "application/json"); */
  			xhr.setRequestHeader("Content-Type", "application/json");
  		},
  		
  		success: function(response) {
  			disableCamera();
  			$("#snapshot").attr("src","data:image/jpeg;base64," + response );
		}
  });
}

function hideCameraPicture(){
	$('#cameraContainer').hide();
}

function enableCamera(){
	
	$('#cameraContainer').show();
	enableCameraPlugin();
	
	$("#snapshotDiv").hide();
	$("#anotherImageButton").hide();
	
	$("#getSnapshotButton").show();
}

function disableCamera(){
	
	$('#cameraContainer').show();
	$("#getSnapshotButton").hide();
	$("#camera").hide();
	
	$("#snapshotDiv").show();
	$("#anotherImageButton").show();
}

function enableCameraPlugin(){
	
	if ( first == 1 ){ 
		
		$("#camera").scriptcam({
			path: '${pageContext.request.contextPath}/resources/js/scriptCam/' ,	// path dos arquivos do scriptCam
			useMicrophone: false ,
			cornerRadius: 0,          // Borda reta, não arredondada
			cornerColor: '#ffffff' ,  // Fundo atras da borda --> Branco
			hideMouse: 'true' ,       // O esconde o mouse quando passar por cima da imagem
	//		showDebug: true ,         // Exibe as informacoes de debug no console do browser
			onError: oopsError ,      // Captura os erros ocorridos
			noFlashFound: '<p><a href="http://www.adobe.com/go/getflashplayer">\
			               Adobe Flash Player</a> 11.7 or greater is needed to use your webcam.</p>'
			               // Avisa que nao encoutrou-se o flash
		});
		
	} else {
		$('#cameraContainer').show();
		$("#camera").show();
	}
	
	first++;
}

</script>
<body>
<form:form id="productForm" method="post" modelAttribute="produto" action="${pageContext.request.contextPath}/product/save">
<div class="container" style="width: 98%;" >
	<div class="panel panel-info center-block" >
		<div class="panel-heading">
			Cadastro de produtos
		</div>
		<div class="panel-body">
		<div class="row-fluid show-grid">
			<div class="col-xs-12 col-sm-12 col-md-8">
				<div class="row-fluid lineHeight">
					<div class="span4" style="background-color:yellow;">
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1">Código</span>
						    <form:input path="code" class="form-control" placeholder="Código" title="Código do Produto"
								   aria-describedby="basic-addon1" style="width: 40%;" maxlength="10" />
							
						</div>
					</div>
				</div>
				<div class="row-fluid lineHeight">
					<div class="span4" style="background-color:gray;">
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1">Nome</span>
   						    <form:input path="name" class="form-control" placeholder="Nome" title="Nome do Produto"
								   aria-describedby="basic-addon1" style="width: 70%;" maxlength="50" />
						</div>
					</div>
				</div>
				<div class="row-fluid lineHeight">
					<div class="span4" style="background-color:blue;">
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1">Descrição</span>
   						    <form:input path="description" class="form-control" placeholder="Descrição" title="Descrição do Produto"
								   aria-describedby="basic-addon1" style="width: 85%;" maxlength="100" />
						</div>
					</div>
				</div>
				<div class="row-fluid lineHeight">
					<div class="span4" style="background-color:green;">
						<div class="row-fluid lineHeight" style="text-align: center;">
                			<button id="saveProductButton" type="button" class="btn btn-default" onclick="saveProduct();" >Salvar Produto</button>
               			</div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-4" style="background-color:red;">
				<div id="cameraContainer" class="row-fluid" style="height: 240px; text-align: center">
               		<div id="camera"></div>
               		<div id="snapshotDiv">
               			<img id="snapshot" src="data:image/jpeg;base64,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" />
               		</div>
               	</div>
               	<div class="row-fluid lineHeight" style="text-align: center;">
                	<button id="getSnapshotButton" type="button" class="btn btn-default" onclick="getSnapshot();" >Capturar Imagem</button>
                	<button id="anotherImageButton" type="button" class="btn btn-default" onclick="enableCamera();" >Tirar foto</button>
               	</div>
        	</div>
		</div>
		</div>
	</div>
	
	
	<!-- TABLE TESTE  -->
	<div class="panel panel-default">
		<div class="panel-heading">Panel heading</div>
	
			<table id="tabelaProdutos" class="table">
				<thead>
					<td>C&oacute;digo</td>
					<td>Nome</td>
					<td>Descrição</td>
					<td>Imagem</td>
				</thead>
	    		<tr>
	    			<td>cod123</td>
					<td>Produto_1</td>
					<td>Produto_1 é bla bla bla</td>
					<td>Imagem_1</td>
	    		</tr>
	    		<tr>
	    			<td>cod456</td>
					<td>Produto_2</td>
					<td>Produto_2 é bla bla bla</td>
					<td>Imagem_2</td>
	    		</tr>
	    		<tr>
	    			<td>cod789</td>
					<td>Produto_3</td>
					<td>Produto_3 é bla bla bla</td>
					<td>Imagem_3</td>
	    		</tr>
	    		<tr>
	    			<td>codqe</td>
					<td>Produto_4</td>
					<td>Produto_4 é bla bla bla</td>
					<td>Imagem_4</td>
	    		</tr>
	    		<tr>
	    			<td>codasd</td>
					<td>Produto_5</td>
					<td>Produto_5 é bla bla bla</td>
					<td>Imagem_5</td>
	    		</tr>
	    		<tr>
	    			<td>codzxc</td>
					<td>Produto_6</td>
					<td>Produto_6 é bla bla bla</td>
					<td>Imagem_6</td>
	    		</tr>
	    		<tr>
	    			<td>codrty</td>
					<td>Produto_7</td>
					<td>Produto_7 é bla bla bla</td>
					<td>Imagem_7</td>
	    		</tr>
	    		<tr>
	    			<td>codfgh</td>
					<td>Produto_8</td>
					<td>Produto_8 é bla bla bla</td>
					<td>Imagem_8</td>
	    		</tr>
	    		<tr>
	    			<td>codvbn</td>
					<td>Produto_9</td>
					<td>Produto_9 é bla bla bla</td>
					<td>Imagem_9</td>
	    		</tr>
	    		<tr>
	    			<td>coduio</td>
					<td>Produto_10</td>
					<td>Produto_10 é bla bla bla</td>
					<td>Imagem_10</td>
	    		</tr>
	    		<tr>
	    			<td>codjkl</td>
					<td>Produto_11</td>
					<td>Produto_11 é bla bla bla</td>
					<td>Imagem_11</td>
	    		</tr>
	    		<tr>
	    			<td>codbnm</td>
					<td>Produto_12</td>
					<td>Produto_12 é bla bla bla</td>
					<td>Imagem_12</td>
	    		</tr>
	    		<tr>
	    			<td>codzse</td>
					<td>Produto_13</td>
					<td>Produto_13 é bla bla bla</td>
					<td>Imagem_13</td>
	    		</tr>
	    		<tr>
	    			<td>codcft</td>
					<td>Produto_14</td>
					<td>Produto_14 é bla bla bla</td>
					<td>Imagem_14</td>
	    		</tr>
	    		<tr>
	    			<td>codxdr</td>
					<td>Produto_15</td>
					<td>Produto_15 é bla bla bla</td>
					<td>Imagem_15</td>
	    		</tr>
	    		<tr>
	    			<td>codvgy</td>
					<td>Produto_16</td>
					<td>Produto_16 é bla bla bla</td>
					<td>Imagem_16</td>
	    		</tr>
	    		<tr>
	    			<td>codbhu</td>
					<td>Produto_17</td>
					<td>Produto_17 é bla bla bla</td>
					<td>Imagem_17</td>
	    		</tr>
	    		<tr>
	    			<td>codnji</td>
					<td>Produto_18</td>
					<td>Produto_18 é bla bla bla</td>
					<td>Imagem_18</td>
	    		</tr>
	    		<tr>
	    			<td>codmko</td>
					<td>Produto_19</td>
					<td>Produto_19 é bla bla bla</td>
					<td>Imagem_19</td>
	    		</tr>
			</table>
	</div>
	
</div>
</form:form>
</body>
<%@include file="template/footer.jsp"%>