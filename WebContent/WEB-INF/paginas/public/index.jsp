<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form>

	<input type="hidden" id="numero" />
	
	Título: <input type="text" id="titulo" />
	Descrição: <input type="text" id="descricao" />
	Tipo: <input type="text" id="tipo" />
	Prioridade: <input type="text" id="prioridade" />
	Url Do Sistema: <input type="text" id="urlDoSistema" />
	Sistema: <input type="text" id="sistema" />
	Data Objetivo: <input type="text" id="dataObjetivo" />
	Área Solicitante: <input type="text" id="areaSolicitante" />
	Área Destinada: <input type="text" id="areaDestinada" />
	Gestor: <input type="text" id="gestor" />
	
	<input type="button" id="btnCriar" value="Criar" />
	<input type="button" id="btnPesquisar" value="Pesquisar" />
	
</form>

<script src='<c:url value="/resources/js/jquery.min.js"></c:url>'></script>
<script src='<c:url value="/resources/js/projeto/index.js"></c:url>'></script>
</body>
</html>