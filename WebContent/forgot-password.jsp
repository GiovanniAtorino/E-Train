<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<%@ include file="head.jsp"%>

 <!-- HEADER + NAVIGAZIONE MOBILE -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
	<%@ include file="headerHome.jsp"%>
  </nav>
  
  
<div class="container-fluid">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Reset Password</div>
      <div class="card-body">
        <div class="text-center mt-4 mb-5">
          <h4>Hai dimenticato la tua password?</h4>
          <p>Inserisci il tuo indirizzo email e ti invieremo le istruzioni su come reimpostare la tua password.</p>
        </div>
        <form>
          <div class="form-group">
            <input class="form-control" id="exampleInputEmail1" type="email" aria-describedby="emailHelp" placeholder="Inserisci la tua email">
          </div>
          <a class="btn btn-primary btn-block" href="sceltaUtente.jsp">Reset Password</a>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="sceltaUtente.jsp">Registra Account</a>
          <a class="d-block small" href="login.jsp">Pagina Login</a>
        </div>
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
