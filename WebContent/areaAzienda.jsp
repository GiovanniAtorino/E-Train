<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,Bean.*,Database.*,Servlet.*"%>
<%

Azienda a=(Azienda) session.getAttribute("user_aziend");
if (a != null){
	String nomeA = a.getNomeA();
} 

else {
		response.sendRedirect("loginAzienda.jsp");
	}
%>

<!DOCTYPE html>
<html lang="en">

<%@ include file="head.jsp"%>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<%@ include file="header.jsp"%>

		<ul class="navbar-nav">
			<li class="nav-item dropdown">
			<li class="nav-item"><a class="nav-link"> <i
					class="fa fa-fw fa-building"></i>Area Azienda
			</a></li>
		</ul>

		<ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
         <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
            
			</li>
		</ul>
	</nav>


	<!-- Navigation-->
	<div class="content-wrapper" style="margin-left: 0px;">
		<div class="card elementArea" style="width: 18rem;">
			<img class="card-img-top" src="img/tirocinio.png"
				alt="Card image cap">
			<div class="card-body buttonElement">
				<a href="./richiestaTirocinioAzienda.jsp" class="btn btn-primary">Richiesta
					tirocinio</a>
			</div>
		</div>

		<div class="card elementArea" style="width: 18rem;">
			<img class="card-img-top" src="img/file.png" alt="Card image cap">
			<div class="card-body buttonElement">
				<a href="GetFileServlet?action=azienda" class="btn btn-primary">Gestione
					File</a>
			</div>
		</div>

		<div class="card elementArea" style="width: 18rem;">
			<img class="card-img-top" src="img/tutor.png" alt="Card image cap">
			<div class="card-body buttonElement">
				<a href="GetRichiestaTirocinioStudenteServlet"
					class="btn btn-primary">Visualizza Richieste Partecipanti</a>
			</div>
		</div>

		<div class="card  elementArea" style="width: 18rem;">
			<img class="card-img-top" src="img/presenze.png" alt="Card image cap">
			<div class="card-body buttonElement">
				<a href="./gestionePresenzeAzienda.jsp" class="btn btn-primary">Gestione
					Presenze</a>
			</div>
		</div>
	</div>
	
	
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
	<!-- FOOTER -->
	<%@ include file="footer.jsp"%>


	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fa fa-angle-up"></i>
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
