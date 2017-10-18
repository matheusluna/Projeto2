<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <style media="screen">
      .parallax-container {
        height: 300px;
      }
    </style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="parallax-container">
      <div class="parallax"><img src="img/paisagem.jpg"></div>
      <div class="section transparent">
        <br>
        <div class="row container">
          <img src="${usuario.foto}" class="circle" height="100px" alt="">
          <h4 class="header white-text">${usuario.nome}</h4>
        </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col s3">
          <ul class="collection">
            <li class="collection-item"><a href="editaPerfil.jsp">Editar perfil</a></li>
            <li class="collection-item">Excluir conta</li>
          </ul>
        </div>
      </div>
    </div>
    ${mensagem}
	<!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    <script type="text/javascript" src="js/plugin.js">
	
</body>
</html>