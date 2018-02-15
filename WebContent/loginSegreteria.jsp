<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html>
<html lang="en">

<%@ include file="head.jsp"%>


<!-- HEADER + SIDENAV -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
	id="mainNav">
	<%@ include file="header.jsp"%>
</nav>

<div class="container-fluid">
		<div class="container">
			<div class="card card-login mx-auto mt-5">
			<%if(request.getAttribute("signup_success")!=null)
			  {%>
				 <div class="alert alert-success"> <strong>Complimenti!</strong> <%=request.getAttribute("signup_success") %></div> 
			<%}%>
				<div class="card-header">Login Segreteria</div>
				<div class="card-body">
					<form action="LoginSegreteriaServlet" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">Email: </label> <input
								class="form-control" name="segreteria_email" id="studente_email"
								type="email" aria-describedby="emailHelp"
								placeholder="Inserisci email">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password:</label> <input
								class="form-control" name="segreteria_password"
								id="segreteria_password" type="password" placeholder="Password">
						</div>
						<div class="form-group">
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="checkbox"> Ricorda
									Password
								</label>
							</div>
						</div>
							<input class="submit" type="submit"
								name="contact_submitted" value="login" />
					</form>
					<div class="text-center">
						<a class="d-block small mt-3" href="sceltaUtente.jsp">Registra
							Account</a> <a class="d-block small" href="forgot-password.jsp">
							Password Dimenticata?</a>
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