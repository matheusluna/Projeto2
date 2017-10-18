<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
  <head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>
    <link href="css/configuracao.css" rel="stylesheet" type="text/css">
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  </head>

  <body>
    <div class="navbar-fixed">
      <nav>
        <div class="nav-wrapper cyan darken-4">
          <a href="login.jsp" class="brand-logo"><i class="material-icons">arrow_back</i>Cadastro</a>
        </div>
      </nav>
    </div>

    <div class="container">
      <div class="row">
        <form id="formCliente" class="form-horizontal templatemo-login-form-2" enctype="multipart/form-data" role="form" action="Cadastro" method="post">
            
           <div class="templatemo-one-signin col-md-12">

                <div class="adicionar-foto">
                    <input class="btn" type="file" required name="foto" >
                </div>

            </div>
          <div class="row">
            <div class="input-field col s6">
              <input id="nome" type="text" name="nome" value="" required>
              <label for="nome">Nome</label>
            </div>
            <div class="input-field col s6">
              <input id="email" type="text" name="email" value="" required>
              <label for="email">E-mail</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <input id="senha" type="password" name="senha" value="" required>
              <label for="senha">Senha</label>
            </div>
            <div class="input-field col s6">
              <input id="nascimento" name="nascimento" type="text" class="datepicker" required>
              <label for="nascimento">Data de nascimento</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <input id="telefone" type="tel" name="telefone" value="">
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
