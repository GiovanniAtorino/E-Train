<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,Bean.*,Database.*,Servlet.*"%>
<%
Studente utente = (Studente) session.getAttribute("user_stud");
ArrayList<Presenza> p=(ArrayList) request.getAttribute("list_pre");

if (utente != null) {
	String email = utente.getEmail();
} else {
	response.sendRedirect("loginStudente.jsp");
}
	
%>

<!DOCTYPE html>
<html lang="en">

<%@ include file="head.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">

<!-- HEADER + NAVIGAZIONE MOBILE -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<%@ include file="header.jsp"%>

		<ul class="navbar-nav">
			<li class="nav-item dropdown">
			<li class="nav-item"><a class="nav-link" href="areaStudente.jsp">
					<i class="fa fa-fw fa-graduation-cap"></i>Area Studente</a>
			</li>
			<li class="nav-item dropdown">
			<li class="nav-item">
				<a class="nav-link"> 
					<i class="fa fa-fw fa-table"></i>Gestione Presenze di <%=utente.getCognome() %></a>		
		</ul>

		<%@ include file="sidenavStudente.jsp"%>
	</nav>

	<div class="content-wrapper">
		<div class="container-fluid">
		
			<!-- Example DataTables Card-->
			<div class="card mb-3">
			
			
			
				<div class="card-header">
					<i class="fa fa-table"></i> Ore svolte Tirocinio
				</div>
			
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
							<thead>
								<tr>
									<th>Tirocinio</th>
									
									<th>Data</th>
									<th>Ore inizo</th>
									<th>Ore fine</th>
									<th>Conferma </th>
								</tr>
							</thead>
							<%for (int i=0;i<p.size();i++){ %>
							<tbody>
								<tr>
									<td><%= p.get(i).getNometP() %></td>
									<td><%= p.get(i).getData()  %></td>
									<td><%= p.get(i).getOraInzio()  %></td>
									<td><%= p.get(i).getOrafine()  %></td>
								
									<td>
										<button class="firma" type="submit" data-toggle="modal" data-target=".bs-example-modal-sm">Conferma</button>
									</td>
								</tr>
							</tbody>
						</table></form> 
					</div>
				</div>
		</div> <%} %>
		


		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i class="fa fa-angle-up"></i>
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
						<a class="btn btn-primary" href="home.jsp?logout=true"">Logout</a>
					</div>
				</div>
			</div>
		</div>
		<div class="modal bs-example-modal-sm" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<h4>Conferma</h4>
					</div>
					<div class="modal-body">
						<i class="fa fa-question-circle"></i> Sei sicuro di voler confermare?
					</div>
					<div class="modal-footer">
						<a href="areaStudente.jsp" class="btn btn-primary btn-block">Conferma</a>
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
		
		
		<script type="text/javascript">
	$(".firma").click(function(){
		
		
		$.ajax({
			type:"get",
		url: "PresenzaAccettataServlet",
		
			success: function(){
				
			}
		});
	});
	
	
	
	</script>
	
</body>
</html>
