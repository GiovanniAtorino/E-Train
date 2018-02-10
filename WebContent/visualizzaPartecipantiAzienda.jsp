<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,Bean.*,Database.*,Servlet.*"%>
<%
try{
Azienda a=(Azienda) session.getAttribute("user_aziend");
ArrayList<Studente> s=(ArrayList) request.getAttribute("rich_studenti");
if (a != null) {
	String nomeA = a.getNomeA();
	
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
          <a class="nav-link" href="areaAzienda.jsp">
            <i class="fa fa-fw fa-building"></i>Area Azienda</a>
        </li>
      </ul>
		
  		<%@ include file="sidenavAzienda.jsp"%>
  	</nav>
 
  <div class="content-wrapper">
    <div class="container-fluid">
    
    
      Richieste Studenti: <br>
      
      <%for(int i=0;i<s.size();i++){ %>
      
     Nome: <%=s.get(i).getNome() %> <br>
       Descrizione: <%=s.get(i).getDipartimento() %> <br>
       Nome azienda: <%=s.get(i).getMatricola() %> <br>
       	<button type="button"
				id="<%=s.get(i).getNome()%>" name="submitta"
									class="addamico" value="addamico">
								</button>
								
								<button type="button"
									id="<%=s.get(i).getNome()%>" name="submitta"
									class="deleteamico" value="deleteamico">
								</button> <br>
     
      </div>
    </div>
     
    <%}}catch (IndexOutOfBoundsException exx) {
	
    	response.sendRedirect("errorrichAzienda.jsp");
    	%>
		<%
	} %> 
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
     	<script type="text/javascript">
	$(".addamico").click(function(){
		var nomeS=$(this).attr("id");
		
		$.ajax({
			type:"get",
		url: "AccettaStudenteTirocinioServlet",
		data: {
			nomeS : nomeS
			},
			success: function(){
				alert("Studente accettato");
			}
		});
	});
	
	
	
	</script>
	<script type="text/javascript">
	$(".deleteamico").click(function(){
		var nomeS=$(this).attr("id");
		
		$.ajax({
			type:"get",
		url: "RifiutaStudenteTirocinio",
		data: {
			nomeS : nomeS
			},
			success: function(){
				alert("Richiesta rifiutata");
			}
		});
	});
	
	
	
	</script>
  
</body>
</html>
