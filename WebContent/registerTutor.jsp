<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>

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
    <%if(request.getAttribute("signup_unsuccess")!=null)
     {%>
     <div class="alert alert-danger"> <strong>Spiacenti!</strong> <%=request.getAttribute("signup_unsuccess") %></div> 
   <%}%>
      <div class="card-header">Registra Account Tutor</div>
      <div class="card-body">
       <form action="RegisterTutorServlet" method="post" id="form">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">Nome</label>
                <input class="form-control" name="tutor_nome" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="Inserisci il Nome" required>
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Cognome</label>
                <input class="form-control" name="tutor_cognome" id="exampleInputLastName" type="text" aria-describedby="nameHelp" placeholder="Inserisci il Cognome" required>
              </div>
            </div>
          </div>
                 <div class="form-group">
                <label for="exampleInputEmail1">Nome tirocinio:</label><br>
                <input id="date" name="tutor_nometirocinio" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="Inserisci nome tirocinio" required>
              </div>
              
              <div class="form-group">
                <label for="exampleInputEmail1">Nome azienda:</label><br>
                <input id="date" name="tutor_nomeazienda" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="Inserisci nome azienda" required>
              </div>
              
              <div class="form-group">
                    <label for="exampleInputEmail1">Numero Matricola:</label><br>
                    <input class="form-control" name="tutor_matricola" id="exampleInputName" type="text" pattern="[0-9]{10}" aria-describedby="nameHelp" placeholder="Inserisci Numero Matricola" required>
              </div>
          <div class="form-group">
            <label for="exampleInputEmail1">Email Accademica: </label>
            <input class="form-control" name="tutor_email" id="exampleInputEmail1" type="email" aria-describedby="emailHelp" pattern=".+@unisa.it" placeholder="Inserisci Email con @unisa.it" required>
            
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputPassword1">Password:</label>
                <input class="form-control" name="tutor_password" id="exampleInputPassword1" type="password" placeholder="Password" required>
              </div>
              
              <div class="col-md-6">
                <label for="exampleConfirmPassword">Conferma password:</label>
                <input class="form-control" id="exampleConfirmPassword" type="password" placeholder="Conferma password" required>
              </div>
            </div>
          </div>
        	<input class="btn btn-primary btn-block" type="submit"	name="contact_submitted" value="Registrati" />
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
    <!-- Page level plugin JavaScript-->
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="js/sb-admin-datatables.min.js"></script>
    <script src="js/sb-admin-charts.min.js"></script>

</html>
