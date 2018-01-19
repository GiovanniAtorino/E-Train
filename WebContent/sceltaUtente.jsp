<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>E-Train</title>
<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">

<script language="javascript" type="text/javascript">
    function sceltaUtente(listindex)
    {
      if(listindex=='Studente')
       location.href="registerStudente.jsp";
      else if(listindex=='Tutor')
        location.href="registerTutor.jsp";
      else if(listindex=='Azienda')
       location.href="registerAzienda.jsp";
    }
  </script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<div class="navbar-brand">
			<a class="" href="index.html"> <img src="img/logo.png"> <img
				src="img/unisa.png"> <img src="img/logov1.2.jpg" id="logo">
			</a>
		</div>

		<ul class="navbar-nav ml-auto">
			<li class="nav-item dropdown">
			<li class="nav-item"><a class="nav-link" data-toggle="modal"
				data-target="#exampleModal"> <i class="fa fa-fw"></i>Login
			</a></li>
		</ul>

	</nav>



<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
	id="mainNav">
	<%@ include file="header.jsp"%>
</nav>

		
			<div class="card card-login mx-auto mt-5">
				<div class="card-header">Scelta Utente</div>
				<div class="card-body">
					<form action="LoginServlet" method="post">
						<div class="form-group">
						<select id="utente"
								onchange="javascript: sceltaUtente(this.options[this.selectedIndex].value);">

								<option>Seleziona Utente</option>
								<option onClick="sceltaUtente(this.id);" id="Studente">Studente</option>
								<option onClick="sceltaUtente(this.id);" id="Azienda">Azienda</option>
								<option onClick="sceltaUtente(this.id);" id="Tutor">Tutor</option>
							</select>
						</div>
						</form>
						</div>
						</div>
						





	

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav"></nav>






	<!-- FOOTER -->
	<%@ include file="footer.jsp"%>

</body>
</html>