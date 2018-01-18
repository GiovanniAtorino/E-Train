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
  <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  
  	<!-- HEADER + SIDENAV -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
		<%@ include file="header.jsp"%>
	</nav>


  
  <div class="content-wrapper" style="margin-left: 0px;">
    <div class="contentArea">
    
      <div class="card elementArea" style="width: 18rem;">
        <img class="card-img-top" src="img/azienda.png" alt="Card image cap">
        <div class="card-body buttonElement">
          <a href="./ricercaStudenteSegreteria.jsp" class="btn btn-primary">Ricerca studente</a>
        </div>
      </div>  
      
       <div class="card elementArea" style="width: 18rem;">
        <img class="card-img-top" src="img/azienda.png" alt="Card image cap">
        <div class="card-body buttonElement">
          <a href="./visualizzaAziendaSegreteria.jsp" class="btn btn-primary">Visualizza Azienda</a>
        </div>
      </div>  
      
        <div class="card elementArea" style="width: 18rem;">
          <img class="card-img-top" src="img/tutor.png" alt="Card image cap">
          <div class="card-body buttonElement">
            <a href="./visualizzaTutorSegreteria.jsp" class="btn btn-primary">Visualizza Tutor</a>
          </div>
        </div>
        
          <div class="card  elementArea" style="width: 18rem;">
            <img class="card-img-top" src="img/tirocinio.png" alt="Card image cap">
            <div class="card-body buttonElement">
              <a href="./visualizzaTirocinioSegreteria.jsp" class="btn btn-primary">Visualizza Tirocinio</a>
            </div>
          </div>
          
            <div class="card  elementArea" style="width: 18rem;">
              <img class="card-img-top" src="img/file.png" alt="Card image cap">
              <div class="card-body buttonElement">
                <a href="./gestioneFileSegreteria.jsp" class="btn btn-primary">Gestione File</a>
              </div>
            </div>
            
              <div class="card  elementArea" style="width: 18rem;">
                <img class="card-img-top" src="img/presenze.png" alt="Card image cap">
                <div class="card-body buttonElement">
                  <a href="./gestionePresenzeSegreteria.jsp" class="btn btn-primary">Gestione Presenze</a>
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
            <h5 class="modal-title" id="exampleModalLabel">Pronto a partire?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">Ã</span>
            </button>
          </div>
          <div class="modal-body">Sei sicuro di volerti disconnettere?</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancella</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
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
