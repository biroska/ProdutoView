/*!
 */

/*
 * Suport a webcam via JS nativo e HTML 5
 * Como usar:
 * 
 *  no onLoad do componente/ pagina acionar o suporte a camera
 *  onload="camaraSupport()"
 *  
 *  Criar uma tag video para receber o stream
 * 	<video id="webcam"> </video>
 * 
 * */
function hasGetUserMedia() {
	navigator.getUserMedia = navigator.getUserMedia || 		 // Opera << ESTE É RESPONSÁVEL PARA EXECUTAR O NAVEGADOR OPERA
							 navigator.webkitGetUserMedia || // Chrome, Safari< ESSE É RESPONSÁVEL PARA EXECUTAR NO NAVEGADOR CHROME E SAFARI
							 navigator.mozGetUserMedia || 	 // Mozilla<< ESTE É RESPONSÁVEL PARA EXECUTAR NO NAVEGADOR MOZILLA
							 navigator.msGetUserMedia;
	
	if (navigator.getUserMedia) { // << ESTE É O COMANDO QUE VAI EXECUTAR NO OPERA.
		return true 			  // << SE FOR VERDADE VAI EXECUTAR
	}
	
	return false; 				 // << SE FOR FALSO VAI VERIFICAR, SE FOR O PRÓXIMO NAVEGADOR
}

function hasURL() { 			 // << SE VERIFICA O NAVEGADOR CHROME OU SAFARI
	window.URL = window.URL || window.webkitURL || window.mozURL || window.msURL; // << VERIFICA SE É O NAVEGADOR MOZILLA
	
	if (window.URL && window.URL.createObjectURL) {
		return true; 			 // << SE FOR ALGUNS DESSES NAVEGADORES, VAI EXECUTAR
	}
	return false; 				 // << CASO CONTRÁRIO VAI EXECUTAR UM ERRO
}

function error(e) { 			 // << CASO HAJA ALGUM ERRO
	alert('Erro na aplicação ' + e); // << VAI EXECUTAR ESSE ERRO
}

function setStream( stream ) {
	
	var webcam = document.getElementById( "webcam" );
	webcam.src = window.URL.createObjectURL(stream);
	webcam.play();
}

function camaraSupport( ) { // << VERIFICA NOVAMENTE SE O NAVEGADOR SUPORTA A TECNOLOGIA HTML5
	
	if ( !hasGetUserMedia() || !hasURL()) {
		alert('Seu navegador não suporte a tecnologia de WebCam HTML5?'); // << SE NÃO SUPORTA IRÁ APARECER ESSE ERRO
	} else {
		navigator.getUserMedia({	// <<DIZ SE QUE O VÍDEO VAI ESTA LIGADO E O ÁUDIO DESLIGADO
			video : true,
			audio : false
		}, 
		setStream, error);
	}
}