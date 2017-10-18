<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="container">
      <div class="row">
        <form id="formCliente" class="form-horizontal templatemo-login-form-2" enctype="multipart/form-data" role="form" action="AtualizaUsuario" method="post">
            
           <div class="row">
				<div class="btn">
	                <span>Foto</span>
	                <input name="foto" type="file" value="${usuario.foto}">
	              </div>
	              <div class="file-path-wrapper">
	                <input name="foto" class="file-path validate" type="text">
	              </div>

            </div>
          <div class="row">
            <div class="input-field col s12">
              <input id="nome" type="text" name="nome" value="${usuario.nome}" required>
              <label for="nome">Nome</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <input id="senha" type="password" name="senha" value="${usuario.senha}" required>
              <label for="senha">Senha</label>
            </div>
            <div class="input-field col s6">
              <input id="nascimento" name="nascimento" type="text" class="datepicker" required>
              <label for="nascimento">Data de nascimento</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <input id="telefone" type="tel" name="telefone" value="${usuario.telefone}">
              <label for="telefone">Telefone</label>
            </div>
            <div class="input-field col s6">
              <select name="sexo">
                <option value="masculino">Masculino</option>
                <option value="feminino">Feminino</option>
              </select>
              <label>Sexo</label>
            </div>
          </div>
          <div class="row right-align">
            <input class="btn" type="submit" name="" value="Cadastro">
          </div>
        </form>
      </div>
    </div>
    ${mensagem}
    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    <script type="text/javascript" src="js/plugin.js"></script>
</body>
</html>