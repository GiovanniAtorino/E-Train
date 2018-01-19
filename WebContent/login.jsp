<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html>
<html lang="en">

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
</head>



<!-- HEADER + SIDENAV -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
	id="mainNav">
	<%@ include file="header.jsp"%>
</nav>
<div class="container-fluid">
	<div class="card card-register mx-auto mt-5">
		<div class="container">
			<div class="card card-login mx-auto mt-5">
				<div class="card-header">Login</div>
				<div class="card-body">
					<form action="LoginServlet" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">Email address</label> <input
								class="form-control" name="studente_email" id="studente_email"
								type="email" aria-describedby="emailHelp"
								placeholder="Enter email">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								class="form-control" name="studente_password"
								id="studente_password" type="password" placeholder="Password">
						</div>
						<div class="form-group">
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="checkbox"> Remember
									Password
								</label>
							</div>
						</div>
						<input class="submit" type="submit" name="contact_submitted"
							value="login" />
					</form>
					<div class="text-center">
						<a class="d-block small mt-3" href="sceltaUtente.jsp">Register
							an Account</a> <a class="d-block small" href="forgot-password.jsp">Forgot
							Password?</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
	id="mainNav"></nav>


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