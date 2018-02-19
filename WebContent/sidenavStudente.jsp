<!-- HAMBURGER MENU -->
<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
</button>	

<div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Visualizza Azienda">
          <a class="nav-link" href="GetTirocinioAccettato">
            <i class="fa fa-fw fa-building"></i>
            <span class="nav-link-text">Visualizza Azienda</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Visualizza Tutor">
          <a class="nav-link" href="GetTutorStudente">
            <i class="fa fa-fw fa-user"></i>
            <span class="nav-link-text">Visualizza Tutor</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Visualizza Tirocinio">
          <a class="nav-link" href="GetStudenteAccettatoTirocinio">
            <i class="fa fa-fw fa-briefcase"></i>
            <span class="nav-link-text">Visualizza Tirocinio</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Gestione File">
          <a class="nav-link" href="GetFileServlet?action=studente">
            <i class="fa fa-fw fa-file"></i>
            <span class="nav-link-text">Gestione File</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Gestione Presenze">
          <a class="nav-link" href="ConfermaPresenzaServlet">
            <i class="fa fa-fw fa-table"></i>
            <span class="nav-link-text">Gestione Presenze</span>
          </a>
        </li>
        </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
         <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
      </ul>
</div>