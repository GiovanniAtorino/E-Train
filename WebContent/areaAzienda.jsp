<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>SB Admin - Start Bootstrap Template</title>
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
		
		<ul class="navbar-nav">
        	<a class="nav-link" data-toggle="modal" data-target="#exampleModal"><i class="fa"></i>Area Azienda</a>
    	</ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
         <li class="nav-item">
          <a class="nav-link" href="home.jsp">
            <i class="fa fa-fw"></i>Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./logout.html">
            <i class="fa fa-fw"></i>Logout</a>
        </li>
      </ul>
	</nav>

  
  <div class="content-wrapper" style="margin-left: 0px;">
    <div class="contentArea">
    
      <div class="card elementArea" style="width: 18rem;">
        <img class="card-img-top" src="img/tirocinio.png" alt="Card image cap">
        <div class="card-body buttonElement">
          <a href="./richiestaTirocinioAzienda.jsp" class="btn btn-primary">Richiesta tirocinio</a>
        </div>
      </div>  
      
       <div class="card elementArea" style="width: 18rem;">
        <img class="card-img-top" src="img/file.png" alt="Card image cap">
        <div class="card-body buttonElement">
          <a href="./gestioneFileAzienda.jsp" class="btn btn-primary">Gestione File</a>
        </div>
      </div>  
      
        <div class="card elementArea" style="width: 18rem;">
          <img class="card-img-top" src="img/tutor.png" alt="Card image cap">
          <div class="card-body buttonElement">
            <a href="./visualizzaPartecipantiAzienda.jsp" class="btn btn-primary">Visualizza Partecipanti</a>
          </div>
        </div>
                    
              <div class="card  elementArea" style="width: 18rem;">
                <img class="card-img-top" src="img/presenze.png" alt="Card image cap">
                <div class="card-body buttonElement">
                  <a href="./gestionePresenzeAzienda.jsp" class="btn btn-primary">Gestione Presenze</a>
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
  </div>
</body>
</html>
