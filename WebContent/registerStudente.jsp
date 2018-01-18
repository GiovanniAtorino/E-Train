<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,Bean.*,Database.*,Servlet.*"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>E-Train</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
        <div class="navbar-brand">
          <a class="" href="index.html">
            <img src="img/logo.png">
            <img src="img/unisa.png">
            <img src="img/logov1.2.jpg" id="logo">
          </a>
        </div>

        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
             <li class="nav-item">
                <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
                  <i class="fa fa-fw"></i>Login</a>
            </li>
          </ul>
        </div>
      </nav>
      
<body class="bg-dark">
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Registra Account Studente</div>
      <div class="card-body">
       <form action="RegisterServlet" method="post" id="form">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">Nome: </label>
                <input class="form-control" name="studente_nome" id="studente_nome" type="text" aria-describedby="nameHelp" placeholder="Inserisci un Nome">
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Cognome: </label>
                <input class="form-control" name="studente_cognome" id="studente_cognome" type="text" aria-describedby="nameHelp" placeholder="Inserisci Cognome">
              </div>
            </div>
          </div>
          <div class="form-group">
              <label for="exampleInputEmail1">Dipartimento:</label><br>
              <input id="form-control" name="studente_dipartimento" id="studente_dipartimento" type="date" aria-describedby="dateHelp" placeholder="Inserisci Dipartimento">
            </div>

            <div class="form-group">
            <label for="exampleInputName">Numero Matricola: </label>
                <input class="form-control" name="studente_matricola" id="studente_matricola" type="number" pattern="[0-9]" aria-describedby="numberHelp" placeholder="Inserisci Numero Matricola">
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">Email Accademica: </label>
            <input class="form-control" name="studente_email" id="studente_email" type="email" aria-describedby="emailHelp" placeholder="Inserisci Email">
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputPassword1">Password: </label>
                <input class="form-control" name="studente_password" id="studente_password" type="password" placeholder="Password">
              </div>
              <div class="col-md-6">
                <label for="exampleConfirmPassword">Conferma password: </label>
                <input class="form-control" id="exampleConfirmPassword" type="password" placeholder="Conferma password">
              </div>
            </div>
          </div>
          <input class="submit" type="submit"
								name="contact_submitted" value="Registrati" />
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="login.html">Login Page</a>
          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>
  
  <!-- FOOTER -->
  <%@ include file="footer.jsp" %>
  
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
