<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,Bean.*,Database.*,Servlet.*"%>

<!DOCTYPE html>
<html lang="en">

<%@ include file="head.jsp"%>

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
              <label for="exampleInputEmail1">Data:</label><br>
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
          <input class="submit" type="submit" name="contact_submitted" value="Registrati" />
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
  
   <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    
    
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="js/sb-admin-datatables.min.js"></script>
    <script src="js/sb-admin-charts.min.js"></script>
  
</body>
</html>
