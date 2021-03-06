<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,Bean.*,Database.*,Servlet.*"%>
<%

Azienda utenteA=(Azienda) session.getAttribute("user_aziend");

if (utenteA != null) {
	String nomeA = utenteA.getNomeA();
} else {
	response.sendRedirect("loginAzienda.jsp");
}
	
%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>E-Train Richiesta Tirocinio</title>
  <link rel="shortcut icon" type="image/x-icon" href="img/logo.png"/>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
	<%@ include file="header.jsp"%>
	
	<ul class="navbar-nav">
        <li class="nav-item dropdown">
         <li class="nav-item">
          <a class="nav-link" href="areaAzienda.jsp">
            <i class="fa fa-fw fa-building"></i>Area Azienda</a>
        </li>
      </ul>
	
  	<%@ include file="sidenavAzienda.jsp"%>
  	
  </nav>
  
  
  <div class="content-wrapper">
    <div class="container-fluid">
    
<div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Richiesta Tirocinio</div>
        <div class="card-body">
        <form action="InviaRichiestaTirocinioServlet" method="post" id="form">
        <div class="form-group">
            <div class="form-row">
                <label class="lbl" for="exampleInputName">Nome Tirocinio: </label>
                <input class="form-control" name="tirocinio_nome" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="Inserisci Nome Azienda">
            </div>
        <div class="form-group">
            <div class="form-row">
                <label class="lbl" for="exampleInputName">Descrizione Tirocinio: </label>
                <input class="form-control" name="tirocinio_descrizione" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="Inserisci Nome Azienda">
            </div>
        <div class="form-group">
            <div class="form-row">
                <label class="lbl" for="exampleInputDate">Data inizio Tirocinio: </label>
                <input class="form-control" name="tirocinio_data" id="exampleInputDate" type="date">
            </div>
              <div class="form-group">
            <div class="form-row">
                <label class="lbl" for="exampleInputDate">Data fine Tirocinio: </label>
                <input class="form-control" name="tirocinio_dataf" id="exampleInputDate" type="date">
            </div>
            <br><br>
            	<input class="btn btn-primary btn-block" type="submit"
								name="contact_submitted" value="invia" />
								</div></div></div></div>
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
              <span aria-hidden="true">X</span>
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
