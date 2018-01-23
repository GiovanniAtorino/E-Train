<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html>
<html>

<%@ include file="head.jsp"%>
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

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
	id="mainNav">
	<%@ include file="header.jsp"%>
</nav>


<div class="card card-login mx-auto mt-5">
	<div class="card-header">Scelta Utente Registrazione</div>
	<div class="card-body">
		<form action="LoginServlet" method="post">
			<div class="form-group">
				<select id="utente"
					onchange="javascript: sceltaUtente(this.options[this.selectedIndex].value);">

					<option>Seleziona Utente Registrazione</option>
					<option>-</option>
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