<%-- 
    Document   : index
    Created on : 07-03-2020, 12:45:22 PM
    Author     : Admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>Sign-in Inventario</title>

    <!-- Bootstrap core CSS -->
    <!-- <link href="../assets/dist/css/bootstrap.css" rel="stylesheet">-->
    <link href="bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="bootstrap/css/signin.css" type="text/css" rel="stylesheet">
  </head>
  <body class="text-center">
      <form class="form-signin" action="sesion" method="POST">
      <img class="mb-4" src="assets/img/user2.png" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Iniciar Sesión</h1>
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="email" name="txtEmail" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" name="txtPassword" id="inputPassword" class="form-control" placeholder="Password" required>
      <div class="checkbox mb-3">
        <label>
          <!--<input type="checkbox" value="remember-me"> Remember me -->
          <a href="#" title="¿No tienes cuenta?">¿No tienes cuenta? | </a>
          <a href="#" title="Olvide mi contraseña">Olvidé mi contraseña</a>
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
      <p class="mt-5 mb-3 text-muted">MEGATEC-ZACATECOLUCA &copy; 2019-2020</p>
    </form>
</body>
</html>



