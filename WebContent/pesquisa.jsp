<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html lang="pt-br">
  <head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  </head>

  <body>
    <jsp:include page="head.jsp"></jsp:include>
    <div class="row container">
      <ul id="tabs-swipe-demo" class="tabs tabs-fixed-width">
        <li class="tab col s3"><a href="#test-swipe-1">Autor</a></li>
        <li class="tab col s3"><a class="active" href="#test-swipe-2">Ano</a></li>
        <li class="tab col s3"><a href="#test-swipe-3">Conteúdo</a></li>
      </ul>
      <div id="test-swipe-1" class="col s12">
          <div class="container">
          	<c:forEach var="tcc" items="${listaAutor}">
          		<ul class="collection">
	              <li class="collection-item avatar">
	                <span class="title"><a href="PaginaTcc?titulo=${tcc.titulo}">Título: ${tcc.titulo}</a></span>
	                <p>Autor: ${tcc.autor} <br>
	                 Orientador: ${tcc.orientador}
	                </p>
	                <a href="#!" class="secondary-content">Ano: ${tcc.ano}</a>
	              </li>
	            </ul>
          	</c:forEach>
            
          </div>
      </div>
      <div id="test-swipe-2" class="col s12">
      	<div class="container">
          	<c:forEach var="tcc" items="${listaAno}">
          		<ul class="collection">
	              <li class="collection-item avatar">
	                <span class="title"><a href="PaginaTcc?titulo=${tcc.titulo}">Título: ${tcc.titulo}</a></span>
	                <p>Autor: ${tcc.autor} <br>
	                   Orientador: ${tcc.orientador}
	                </p>
	                <a href="#!" class="secondary-content">Ano: ${tcc.ano}</a>
	              </li>
	            </ul>
          	</c:forEach>
            
          </div>
      </div>
      <div id="test-swipe-3" class="col s12">
      	<div class="container">
          	<c:forEach var="tcc" items="${listaConteudo}">
          		<ul class="collection">
	              <li class="collection-item avatar">
	                <span class="title"><a href="PaginaTcc?titulo=${tcc.titulo}">Título: ${tcc.titulo}</a></span>
	                <p>Autor: ${tcc.autor} <br>
	                   Orientador: ${tcc.orientador}
	                </p>
	                <a href="#!" class="secondary-content">Ano: ${tcc.ano}</a>
	              </li>
	            </ul>
          	</c:forEach>
            
          </div>
      </div>
    </div>


    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    <script type="text/javascript" src="js/plugin.js"></script>
  </body>
</html>
