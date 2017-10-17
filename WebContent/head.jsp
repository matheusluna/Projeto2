<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag"%>
<html>
  <head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  </head>

  <body>
    <!--Menu principal-->
    <ul id="slide-out" class="side-nav">
      <li><div class="user-view">
        <div class="background">
          <img src="img/paisagem.jpg">
        </div>
              <c:if test="${sessionScope.usuario != null}">

                        <a href="#!user"><img class="circle" src="${usuario.foto}"></a>
                        <a href="#!name">${usuario.nome}</a>
                        <a href="#!email"><span class="white-text email">${usuario.email}</span></a>
               </c:if>
      </div></li>
      <li><a href="#!"><i class="material-icons">account_circle</i>Meu perfil</a></li>
      <li><a class="waves-effect waves-light modal-trigger" href="#modal1"><i class="material-icons">publish</i>Cadastrar tcc</a></li>
      <li><a href="#" data-activates="slide-out2" class="button-collapse2 show-on-large"><i class="material-icons">search</i>Pesquisar tcc</a></li>
      <li><a href="Logout"><i class="material-icons">power_settings_new</i>Logout</a></li>
    </ul>

    <!--Menu de pesquisa-->
    <ul id="slide-out2" class="side-nav">
      <form class="" action="Pesquisa" method="post">
        <div class="row">
          <div class="input-field col s12">
            <input type="text" name="pesquisa" id="pesquisa" value="">
            <label for="pesquisa">Pesquisa</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s2">
            <input type="submit" class="btn" name="" value="Pesquisar">
          </div>
        </div>
      </form>
    </ul>


    <!-- Modal de cadastro de tcc -->
    <div id="modal1" class="modal">
      <div class="modal-content">
        <h4>Cadastro Tcc</h4>
        <form action="CadastroTcc" enctype="multipart/form-data" method="post">
          <div class="row">
            <div class="input-field col s6">
              <input type="text" name="titulo" id="titulo" value="">
              <label for="titulo">Título</label>
            </div>
            <div class="input-field col s6">
              <input type="text" name="autor" id="autor" value="">
              <label for="autor">Autor</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <input type="text" name="orientador" id="orientador" value="">
              <label for="orientador">Orientador</label>
            </div>
            <div class="input-field col s6">
              <input type="text" name="palavrasChave" id="palavraChave" value="">
              <label for="palavraChave">Palavras-chave</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <textarea id="textarea1" name="resumo" class="materialize-textarea"></textarea>
              <label for="textarea1">Resumo</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <input type="number" name="ano" id="ano" value="">
              <label for="ano">Ano</label>
            </div>
            <div class="input-field col s6">
              <select name="area">
                <option value="Banco de Dados">Banco de Dados</option>
                <option value="Engenharia de Software">Engenharia de Software</option>
                <option value="Redes">Redes</option>
                <option value="Segurança">Segurança</option>
                <option value="Arquitetura de Sistemas">Arquitetura de Sistemas</option>
                <option value="Hardware">Hardware</option>
                <option value="Desenvolvimento de Sistemas">Desenvolvimento de Sistemas</option>
              </select>
              <label>Área de conhecimento</label>
            </div>
          </div>
          <div class="row">
            <div class="file-field input-field">
              <div class="btn">
                <span>Tcc</span>
                <input type="file" name="pdf">
              </div>
              <div class="file-path-wrapper">
                <input class="file-path validate" type="text">
              </div>
            </div>
          </div>
          <div class="row">
            <div class="modal-footer">
              <input class="modal-action modal-close waves-effect waves-green btn-flat" type="submit" name="" value="Salvar">
            </div>
          </div>
        </form>
      </div>
    </div>

    <!--Barra de menu-->
    <div class="navbar-fixed">
      <nav>
        <div class="nav-wrapper cyan darken-4">
          <a href="#" data-activates="slide-out" class="button-collapse show-on-large"><i class="material-icons">menu</i></a>
          <a href="#!" class="brand-logo"><img src="img/logo.png" height="60px" alt=""></a>
        </div>
      </nav>
    </div>
    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    <script type="text/javascript" src="js/plugin.js"></script>
  </body>
</html>
