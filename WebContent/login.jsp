<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag"%>

<!DOCTYPE html>
<html>
  <head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  </head>

  <body class="indigo lighten-5">
    <!--Import jQuery before materialize.js-->
    <br>
    <div class="container">
      <div class="container">
        <div class="container">
          <div class="container">
            <div class="row center-align">
                <img src="img/logo.png" height="200px" alt="">
            </div>
            <div class="row">
              <form class="col s12" action="Login" method="post">
                <div class="row">
                  <div class="input-field col s12">
                    <input name="email" id="email" type="email" class="validate">
                    <label for="email">Email</label>
                  </div>
                </div>
                <div class="row">
                  <div class="input-field col s12">
                    <input name="senha" id="password" type="password" class="validate">
                    <label for="senha">Password</label>
                  </div>
                </div>
                <p>Não possui conta? <a href="cadastro.jsp">clique aqui!</a></p>
                <div class="row center-align">
                    <input class="waves-effect waves-light btn indigo darken-4" type="submit" value="Login" />

                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    ${mensagem}
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
  </body>
</html>

