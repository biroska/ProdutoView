/*
Itera por todos os li que compõe o menu e e remove o atributo
active da class, para que o menu não fique mais selecionado
*/

function clearMenuSelection(){
	// Pega a UL com a class 'nav-tabs'
	$('.nav-tabs').each(function(i, items_list){
	
	//	Pega todos os li dentro da ul, inclusive os submenus
		$(items_list).find('li').each(function(j, li){
	
	//		pega o valor do atributo class
			var classSelector = $(li).attr("class")		
		
	//		Se o class tiver valor preenchido substitui o 'active' por ''
			if ( classSelector != undefined && classSelector != '' ){
				classSelector = classSelector.replace('active', '');
			}
			
	//		Seta o valor de volta na class, pode ser um valor
	//		atualizado ou o mesmo de antes
			$(li).attr("class", classSelector);
		})
	});
}