<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,Bean.*,Database.*,Servlet.*"%>
<%

Segreteria utenteS=(Segreteria) session.getAttribute("user_segreteria");
ArrayList<Tirocinio> t=(ArrayList) request.getAttribute("richieste_tir");
if (utenteS != null) {
	String nomeS = utenteS.getNomeS();
	
} else {
	response.sendRedirect("loginSegreteria.jsp");
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
  <title>E-Train</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
 
 <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
	<%@ include file="header.jsp"%>
	
	<ul class="navbar-nav">
        <li class="nav-item dropdown">
         <li class="nav-item">
          <a class="nav-link" href="areaSegreteria.jsp">
            <i class="fa fa-fw fa-university"></i>Area Segreteria</a>
        </li>
      </ul>
	
  	<%@ include file="sidenavSegreteria.jsp"%>
 </nav>
 
  <div class="content-wrapper">
    <div class="container-fluid">
    <div class="card mb-3">
			<div class="card-header">
				<i class="fa fa-table"> Richieste Tirocinio: </i> 
			</div>
			<% for(int i=0;i<t.size();i++){ %>
			<div class="card-body">
				Nome: <%=t.get(i).getNomeTirocinio() %> <br>
		       Descrizione: <%=t.get(i).getDescrizioneTirocinio() %> <br>
		       Nome azienda: <%=t.get(i).getNomeaziendaTirocinio() %> <br>
		       	<button type="button" 
       				onclick="redirectToServlet('AccettaTirocinioServlet', '<%=t.get(i).getNomeTirocinio() %>')">
				Accetta
		</button>
		
		<button type="button" 
       				onclick="redirectToServlet('RifiutaRichiestaServlet', '<%=t.get(i).getNomeTirocinio() %>')">
				Rifiuta
		</button><br>
    	 		<HR>
			</div>
			<%  }%>
		</div>
    
      </div>
      
    </div>
    
    <!-- FOOTER -->
    <%@ include file="footer.jsp" %> 
    
    <script>
    
    	function redirectToServlet(servlet, param){
    		window.location = "./" + servlet + "?nomet=" + param;
    	}
    
    </script>
    
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
