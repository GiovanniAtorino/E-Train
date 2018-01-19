<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>

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
<!-- HEADER + SIDENAV -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
	id="mainNav">
	<%@ include file="headerRegister.jsp"%>
</nav>
      
<body class="bg-dark">
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Registra Account Tutor</div>
      <div class="card-body">
        <form>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">Nome</label>
                <input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="Inserisci il Nome">
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Cognome</label>
                <input class="form-control" id="exampleInputLastName" type="text" aria-describedby="nameHelp" placeholder="Inserisci il Cognome">
              </div>
            </div>
          </div>
          <div class="form-group">
                <label for="exampleInputEmail1">Data Di Nascita:</label><br>
                <input id="date" type="date" aria-describedby="dateHelp" placeholder="Inserisci Data">
              </div>
              <div class="form-group">
                    <label for="exampleInputEmail1">Numero Matricola:</label><br>
                    <input class="form-control" id="exampleInputName" type="text" pattern="[0-9]" aria-describedby="nameHelp" placeholder="Inserisci Numero Matricola">
              </div>
          <div class="form-group">
            <label for="exampleInputEmail1">Email Accademica: </label>
            <input class="form-control" id="exampleInputEmail1" type="email" aria-describedby="emailHelp" placeholder="Inserisci Email Accademica">
            
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputPassword1">Password:</label>
                <input class="form-control" id="exampleInputPassword1" type="password" placeholder="Password">
              </div>
              
              <div class="col-md-6">
                <label for="exampleConfirmPassword">Conferma password:</label>
                <input class="form-control" id="exampleConfirmPassword" type="password" placeholder="Conferma password">
              </div>
            </div>
          </div>
          <a class="btn btn-primary btn-block" href="login.html">Register</a>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="login.jsp">Login Page</a>
          <a class="d-block small" href="forgot-password.jsp">Forgot Password?</a>
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
