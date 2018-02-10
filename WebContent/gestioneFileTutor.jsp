<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,Bean.*,Database.*,Servlet.*"%>
<%
Tutor utente = (Tutor) session.getAttribute("user_tutor");
ArrayList<FileP> pf=(ArrayList) request.getAttribute("lista_path");

if (utente != null) {
	String email = utente.getEmailT();
} else {
	response.sendRedirect("loginTutor.jsp");
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
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
	<%@ include file="header.jsp"%>
	
	<ul class="navbar-nav">
        <li class="nav-item dropdown">
         <li class="nav-item">
          <a class="nav-link" href="areaTutor.jsp">
            <i class="fa fa-fw fa-user"></i>Area Tutor</a>
        </li>
        <li class="nav-item dropdown">
			<li class="nav-item">
				<a class="nav-link">
					<i class="fa fa-fw fa-file"></i> Gestione File</a>
      </ul>
	
  	<%@ include file="sidenavTutor.jsp"%>
  </nav>
  
  <div class="content-wrapper">
    <div class="container-fluid">
        <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Data Table Example</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Azienda</th>
                  <th>Bottone</th>
                  <th>Scarica</th>
                  <th>Bottone</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>Azienda</th>
                  <th>Bottone</th>
                  <th>Scarica</th>
                  <th>Bottone</th>
                </tr>
              </tfoot>
              
              <tbody>
                <tr>
                <%for(int i=0;i<pf.size();i++){ %>
                  <td><%=pf.get(i).getNomeF() %></td>
                  <td><button class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Richiesta</button></td>
                  <td><a href="<%=pf.get(i).getPathF() %>" > Scarica File </a></td>
                  <td>
                    <button class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Conferma</button>
                  </td> <br>
                   <%} %>
                </tr>
               
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      
      
      
      
    
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
            <h5 class="modal-title" id="exampleModalLabel">Disconnet</h5>
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
