<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">

<%@ include file="head.jsp"%>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">

  <!-- HEADER + SIDENAV -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
		<%@ include file="header.jsp"%>
		
		<ul class="navbar-nav">
        <li class="nav-item dropdown">
         <li class="nav-item">
          <a class="nav-link">
            <i class="fa fa-fw fa-graduation-cap"></i>Area Admin</a>
        </li>
      </ul>
		
		
	<%@ include file="sidenavAdmin.jsp"%>	
	</nav>


  
  <div class="content-wrapper">
     <div class="card card-register mx-auto mt-5" style="margin-top: 2rem !important;">
    <div class="contentArea">
    <%if(request.getAttribute("signup_unsuccess")!=null)
     {%>
     <div class="alert alert-danger"> <strong>Spiacenti!</strong> <%=request.getAttribute("signup_unsuccess") %></div> 
   <%}%>
     <div class="card-header">Registra Account Studente</div>
      <div class="card-body">
       <form action="RegisterSegreteriaServlet" method="post" id="form">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">Nome: </label>
                <input class="form-control" name="segreteria_nome" id="segreteria_nome" type="text" aria-describedby="nameHelp" placeholder="Inserisci un Nome">
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Dipartimento: </label>
                <input class="form-control" name="segreteria_dipartimento" id="segreteria_cognome" type="text" aria-describedby="nameHelp" placeholder="Inserisci Cognome">
              </div>
            </div>
          </div>
          <div class="form-group">
              <label for="exampleInputEmail1">Facoltà:</label><br>
              <input id="form-control" name="segreteria_facolta" id="segreteria_facolta" type="date" aria-describedby="dateHelp" placeholder="Inserisci Dipartimento">
            </div>

            <div class="form-group">
            <label for="exampleInputName">Numero Telefono: </label>
                <input class="form-control" name="segreteria_telefono" id="segreteria_telefono" type="number" pattern="[0-9]" aria-describedby="numberHelp" placeholder="Inserisci Numero Matricola">
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">Email: </label>
            <input class="form-control" name="segreteria_email" id="segreteria_email" type="email" aria-describedby="emailHelp" placeholder="Inserisci Email">
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputPassword1">Password: </label>
                <input class="form-control" name="segreteria_password" id="segreteria_password" type="password" placeholder="Password">
              </div>
              <div class="col-md-6">
                <label for="exampleConfirmPassword">Conferma password: </label>
                <input class="form-control" id="exampleConfirmPassword" type="password" placeholder="Conferma password">
              </div>
            </div>
          </div>
        <input class="submit" type="submit"	name="contact_submitted" value="Registrati" />
        </form>
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
    

<!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Disconnect</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">X</span>
            </button>
          </div>
          <div class="modal-body">Sei sicuro di volerti disconnettere?</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancella</button>
            <a class="btn btn-primary" href="home.jsp">Logout</a>
          </div>
        </div>
      </div>
    </div>
    
    
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
