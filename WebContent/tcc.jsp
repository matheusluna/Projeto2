<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Título: ${tcc.titulo}</p>
	<p>Autor: ${tcc.autor}</p>
	<p>Orientador: ${tcc.orientador}</p>
	<p>Resumo:<br> ${tcc.resumo}</p>
	<p>Arquivo: <a href="${tcc.caminho}" target="_blank">Clique aqui</a></p>
</body>
</html>