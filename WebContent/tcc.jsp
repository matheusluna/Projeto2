<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="container">
		<p>Título: ${tcc.titulo}</p>
		<p>Autor: ${tcc.autor}</p>
		<p>Orientador: ${tcc.orientador}</p>
		<p>Resumo:<br> ${tcc.resumo}</p>
		<p>Ano: ${tcc.ano}</p>
		<p>Arquivo: <a href="${tcc.caminho}" target="_blank">Clique aqui</a></p>
		<h5>Mais Tccs Orientados por ${tcc.orientador}</h5>
		<div class="carousel">
			<c:forEach var="trabalho" items="${listaOrientador}">
				<ul class="collection">
	              <li class="collection-item avatar">
	                <span class="title"><a href="PaginaTcc?titulo=${trabalho.titulo}">Título: ${trabalho.titulo}</a></span>
	                <p>Autor: ${trabalho.autor}
	                </p>
	                <a href="#!" class="secondary-content">Ano: ${trabalho.ano}</a>
	              </li>
	            </ul>
			</c:forEach>
		    
		  </div>
		  <h5>Mais Tccs na área de ${tcc.area}</h5>
		<div class="carousel">
			<c:forEach var="trabalho" items="${listaArea}">
				<ul class="collection">
	              <li class="collection-item avatar">
	                <span class="title"><a href="PaginaTcc?titulo=${trabalho.titulo}">Título: ${trabalho.titulo}</a></span>
	                <p>Autor: ${trabalho.autor}
	                </p>
	                <a href="#!" class="secondary-content">Ano: ${trabalho.ano}</a>
	              </li>
	            </ul>
			</c:forEach>
		    
		  </div>
	</div>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    <script type="text/javascript" src="js/plugin.js"></script>
</body>
</html>