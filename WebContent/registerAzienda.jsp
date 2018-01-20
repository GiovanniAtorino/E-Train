<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">

<%@ include file="head.jsp" %>

<!-- HEADER + SIDENAV -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
		<%@ include file="header.jsp"%>
		
		<ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
         <li class="nav-item">
          <a class="nav-link" href="sceltaLogin.jsp">
            <i class="fa fa-fw fa-sign-out"></i>Login</a>
        </li>
      </ul>
	</nav>
      
      
<div class="content-wrapper" style="margin-left: 0px;">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Registrazione Account Aziendale </div>
      <div class="card-body">
        <form>
          <div class="form-group">
            <div class="form-row">
                <label for="exampleInputName">Nome Azienda: </label>
                <input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="Inserisci Nome Azienda">
            </div>
            </div>
              <div class="form-group">
                <label for="exampleInputLastName">Domicilio Azienda</label>
                <input class="form-control" id="exampleInputLastName" type="text" aria-describedby="nameHelp" placeholder="Inserisci Domicilio Azienda">
              </div>
          <div class="form-group">
            <label for="exampleInputEmail1">Email :</label>
            <input class="form-control" id="exampleInputEmail1" type="email" aria-describedby="emailHelp" placeholder="Inserisci Email">
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputPassword1">Password</label>
                <input class="form-control" id="exampleInputPassword1" type="password" placeholder="Password">
              </div>
              <div class="col-md-6">
                <label for="exampleConfirmPassword">Conferma password</label>
                <input class="form-control" id="exampleConfirmPassword" type="password" placeholder="Conferma password">
              </div>
            </div>
          </div>
          <a class="btn btn-primary btn-block" href="sceltaUtente.jsp">Registrati</a>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="login.jsp">Login</a>
          <a class="d-block small" href="forgot-password.jsp">Password Dimenticata?</a>
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
