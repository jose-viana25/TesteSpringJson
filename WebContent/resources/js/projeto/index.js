$(document).ready(function(){
    $("#btnCriar").on('click', function() {
    	criarTicket();	
	});
    
    $("#btnPesquisar").on('click', function() {
    	pesquisarTicket();	
	});
    
});

function criarTicket(){
	
	let titulo = $('#titulo').val();
	let descricao = $('#descricao').val();
	let tipo = $('#tipo').val();
	let prioridade = $('#prioridade').val();
	let urlDoSistema = $('#urlDoSistema').val();
	let sistema = $('#sistema').val();
	let dataObjetivo = formatarData($('#dataObjetivo').val());
	let areaSolicitante = {codigo: 0,nome:$('#areaSolicitante').val()};
	let areaDestinada = {codigo: 1, nome:$('#areaDestinada').val()};
	let gestor = {codigo: 1,nome:$('#gestor').val()};
	let numero = $('#numero').val();
	
	var ticket = {titulo,descricao,tipo,prioridade,
			urlDoSistema,sistema,dataObjetivo,areaSolicitante,areaDestinada,gestor,numero
			};
//console.log(dataObjetivo);
	$.ajax({
	      type: 'POST',
	      contentType : 'application/json; charset=utf-8',
	      dataType : 'json',
	      url: "tickets/criarTicket",
	      data: JSON.stringify(ticket),
	      success :function(resultado) {
	       console.log(resultado);
	     }
	  });
}

function pesquisarTicket(){
	
	let titulo = $('#titulo').val();
	let descricao = $('#descricao').val();
	let tipo = $('#tipo').val();
	let prioridade = $('#prioridade').val();
	let urlDoSistema = $('#urlDoSistema').val();
	let sistema = $('#sistema').val();
	let dataObjetivo = formatarData($('#dataObjetivo').val());
	let areaSolicitante = {codigo: 0,nome:$('#areaSolicitante').val()};
	let areaDestinada = {codigo: 1, nome:$('#areaDestinada').val()};
	let gestor = {codigo: 1,nome:$('#gestor').val()};
	let numero = $('#numero').val();
	
	var ticket = {titulo,descricao,tipo,prioridade,
			urlDoSistema,sistema,dataObjetivo,areaSolicitante,areaDestinada,gestor,numero
			};
	
	$.ajax({
	      type: 'GET',
	      contentType : 'application/json; charset=utf-8',
	      dataType : 'json',
	      url: "tickets/",
	      //data: JSON.stringify(ticket),
	      success :function(resultado) {
	       console.log(resultado);
	     }
	  });
	
}

function formatarData(data){
	data = data.replace(/\//g,'-');
	return data;
	
}