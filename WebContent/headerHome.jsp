<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
	<%@ include file="header.jsp"%>

	<ul class="navbar-nav">
	</ul>
	<ul class="navbar-nav ml-auto">
		<li class="nav-item dropdown">
		<li class="nav-item"><a class="nav-link nav-link:hover" href="sceltaLogin.jsp" style="float: left;">
				<i class="fa fa-fw fa-sign-in" ></i>Login
		</a> 
		<a class="nav-link" href="sceltaUtente.jsp" style="float: left;"> <i
				class="fa fa-user-plus"></i>Register
		</a>
		</li>
	</ul>
</nav>