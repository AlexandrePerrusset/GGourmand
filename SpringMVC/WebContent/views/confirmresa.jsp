<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="language" content="fr" />
  <title>Gastronome Gourmand</title>
  <!--Import Google Icon Font-->
  <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <!--Import materialize.css-->
  <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
  <link type="text/css" rel="stylesheet" href="css/style.css"/>
  <!--Let browser know website is optimized for mobile-->
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>




<header>
  <div class="navbar-fixed">
  <ul id="dropdown1" class="dropdown-content">
  <li><a href="#!">one</a></li>
  <li><a href="#!">two</a></li>
  <li class="divider"></li>
  <li><a href="#!">three</a></li>
</ul>
    <nav>
      <div class="nav-wrapper">
            <img src="sources/logo.jpg" class="logo1">
             <a href="/SpringMVC" class="brand-logo logoGG text-darken-2 titleStyle"><i class="fa fa-cutlery" aria-hidden="true"></i> Gastronome  Gourmand</a>
          <ul id="nav-mobile" class="right">
               <li><a class="dropdown-button" href="#!" data-activates="dropdown1">Dropdown<i class="material-icons right">arrow_drop_down</i></a></li>
            </ul>
      </div>
    </nav>
  </div>
</header>





<body>



<div class="contourc">
<div class="traitrouge"></div>

<h3 class="titreresa">R&eacute;servation</h3>

<div class="milieu">
<div class="container">
  <div class="card">
    <div class="card-content">
    <h5>${sessionScope.eatery.name}</h5>
    <span>${eatery.street} - ${eatery.postCode} ${eatery.city}</span>
    </div>
  </div>


  <div class="card">
    <div class="card-content">
      <i class="material-icons">today</i>
    <span><b>Date :</b> ${sessionScope.date}</span>
    </div>
  </div>

    <div class="card">
    <div class="card-content">
    <i class="material-icons">query_builder</i>
  <span><b>Heure :</b> heure de la r&eacute;servation</span>
    </div>
  </div>  

   <div class="card">
    <div class="card-content">
     <i class="material-icons">perm_identity</i>
    <span><b>Nombre de personnes :</b>  ${sessionScope.NbPer}</span>
    </div>
  </div> 

<c:if test="${sessionScope.NbPer != null && sessionScope.date != null && eatery.name != null }">
<form action="eateries/reservation/${eatery.id}/confirmresa/profil">
<input type="hidden" name="nbper">${sessionScope.NbPer}</input>
<input type="hidden" name="date">${sessionScope.date}</input>
<input type="hidden" name="name">${eatery.name}</input>
<button class="waves-effect waves-light btn" type="submit" name="resa">Confirmer<i class="material-icons left">thumb_up</i></button>
</form></c:if>




<c:if test="${sessionScope.user == null}"><div class="input-field col s8"><a href="#modal1"><button class="btn waves-effect waves-light buttonSpe" type="submit" name="resa">R&eacute;server<i class="material-icons right">done</i></button></a></div></c:if>					
<a class="waves-effect waves-light btn"><i class="material-icons left">thumb_down</i>Annuler</a>

</div>
</div>
<div class="traitrouge"></div>
</div>

 
</body>

<!-- Footer -->
  <footer class="page-footer">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">Footer Content</h5>
          <p class="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.</p>
        </div>
        <div class="col l4 offset-l2 s12">
          <h5 class="white-text">Links</h5>
          <ul>
            <li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
            <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
            <li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
            <li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
        Â© 2014 Copyright Text
        <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
      </div>
    </div>
  </footer>






<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  $('.parallax').parallax();
});
$('.datepicker').pickadate({
  selectMonths: true, // Creates a dropdown to control month
  format: 'dd/mm/yyyy',
  monthsFull: [ 'Janvier', 'Fevrier', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'AoÃ»', 'Septembre', 'Octobre', 'Novembre', 'Decembre' ],
  monthsShort: [ 'Jan', 'Fev', 'Mar', 'Avr', 'Mai', 'Juin', 'Juil', 'Aout', 'Sep', 'Oct', 'Nov', 'Dec' ],
  weekdaysFull: [ 'Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi' ],
  weekdaysShort: [ 'Dim', 'Lun', 'Mar', 'Mer', 'Jeu', 'Ven', 'Sam' ],
  weekdaysLetter: [ 'D', 'L', 'M', 'M', 'J', 'V', 'S' ],
  today: '',
  clear: 'Raz',
  close: 'Fermer'

});
$(document).ready(function() {
  $('select').material_select();
});
$(document).ready(function(){
  // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
  $('.modal').modal();
});

</script>
</html>
