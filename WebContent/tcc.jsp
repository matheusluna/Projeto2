<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
				<div class="carousel-item">
			    	<div class="card grey lighten-4">
			            <div class="card-content">
			              <span class="card-title">Titulo: ${trabalho.titulo} <br> Autor: ${trabalhor.autor}</span>
			              <p>Ano: ${trabalho.ano}</p>
			            </div>
			          </div>
			    </div>
			</c:forEach>
		    
		  </div>
		  <h5>Mais Tccs na área de ${tcc.area}</h5>
		<div class="carousel">
			<c:forEach var="trabalho" items="${listaArea}">
				<div class="carousel-item">
			    	<div class="card grey lighten-4">
			            <div class="card-content">
			              <span class="card-title"><a href="PaginaTcc?titulo=${trabalho.titulo}">Titulo: ${trabalho.titulo}</a> <br> Autor: ${trabalhor.autor}</span>
			              <p>Ano: ${trabalho.ano}</p>
			            </div>
			          </div>
			    </div>
			</c:forEach>
		    
		  </div>
	</div>
</body>
</html>