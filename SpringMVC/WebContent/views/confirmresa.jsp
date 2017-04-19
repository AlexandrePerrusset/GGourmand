<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="language" content="fr" />
<title>Gastronome Gourmand</title>
<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
				<img src="sources/logo.jpg" class="logo1"> <a
					href="/SpringMVC"
					class="brand-logo logoGG text-darken-2 titleStyle"><i
					class="fa fa-cutlery" aria-hidden="true"></i> Gastronome Gourmand</a>

				<ul id="nav-mobile" class="right">
					<li><a class="dropdown-button" href="#!"
						data-activates="dropdown1">Dropdown<i
							class="material-icons right">arrow_drop_down</i></a></li>

					<ul id="nav-mobile" class="right hide-on-med-and-down">
						<c:if test="${user.username != null}">
							<li><a href="/SpringMVC/bookingsUser">Mon profil</a></li>
							<li><a href="/SpringMVC/logout">Se d&eacute;connecter</a></li>
						</c:if>
						<c:if test="${user.username == null}">
							<li><a class="dropdown-button" href="#!"
								data-activates="dropdown" data-beloworigin="true">Se
									connecter<i class="mdi-navigation-arrow-drop-down right"></i>
							</a></li>
							<li><a href="#modal2">Cr&eacute;er un compte</a></li>
						</c:if>

					</ul>
			</div>
		</nav>
	</div>
</header>





<body>



	<div class="contourc">
		<div class="traitrouge"></div>

		<h3 class="titreresa">R&eacute;servation</h3>


		<div class="milieuresa">
			<div class="container">
				<div class="card">
					<div class="card-content">
						<h5>${sessionScope.eatery.name}</h5>
						<span>${eatery.street} - ${eatery.postCode} ${eatery.city}</span>
					</div>
				</div>


<div id="formulaire">
				<form class="col s12"
					action="eateries/reservation/${eatery.id}/confirmresa/profil"
					method="get">
					<div class="card">
						<div class="card-content">
							<div class="row ">
								
									<div class="input-field col s6">
										<i class="material-icons prefix">today</i> <input name="date" value="${sessionScope.date}"
											type="date" class="datepicker"> <label
											for="icon_prefix">${sessionScope.date}</label>
									</div>
									<div class="input-field col s6">
										<i class="material-icons prefix">supervisor_account</i> <select
											name="nbper">
											<option>${sessionScope.NbPer}</option>
											<c:forEach var="i" begin="1" end="15" step="1">
												<option value="${i}">${i}</option>
											</c:forEach>
										</select> <label for="icon_prefix">Combien ?</label>
									</div>
								
							</div>
						</div>
					</div>
					<button class="waves-effect waves-light btn" type="submit"
						name="resa">
						Confirmer<i class="material-icons left">thumb_up</i>
					</button>

					
				</form>
				<a href="/SpringMVC/eateries/reservation/${eatery.id}"><button
							class="waves-effect waves-light btn"  name="resa"
							id="btnannuler">
							Annuler<i class="material-icons left">thumb_up</i>
						</button></a>
				</div>

				<%-- <c:if test="${ sessionScope.date != null}">	
				<div id="formulaire">		
					<form action="eateries/reservation/${eatery.id}/confirmresa/profil">
						<input type="hidden" name="nbper" value="${sessionScope.NbPer}" />
						<input type="hidden" name="date" value="${sessionScope.date}" />
						<button class="waves-effect waves-light btn" type="submit"
							name="resa">
							Confirmer<i class="material-icons left">thumb_up</i>
						</button>
					</form>
			
					<form action="eateries/reservation/${eatery.id}/">
						<input type="hidden" name="nbper" value="${sessionScope.NbPer}" />
						<input type="hidden" name="date" value="${sessionScope.date}" />
						<button class="waves-effect waves-light btn" type="submit"
							name="resa" id="btnannuler">
							Annuler<i class="material-icons left">thumb_up</i>
						</button>
					</form>	
					</div>			
				</c:if>
 --%>


			</div>
		</div>
		<div class="traitrouge"></div>
	</div>


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
				<p class="grey-text text-lighten-4">You can use rows and columns
					here to organize your footer content.</p>
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
			Â© 2014 Copyright Text <a class="grey-text text-lighten-4 right"
				href="#!">More Links</a>
		</div>
	</div>
</footer>






<!--Import jQuery before materialize.js-->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.parallax').parallax();
	});
	$('.datepicker').pickadate(
			{
				selectMonths : true, // Creates a dropdown to control month
				format : 'dd/mm/yyyy',
				monthsFull : [ 'Janvier', 'Fevrier', 'Mars', 'Avril', 'Mai',
						'Juin', 'Juillet', 'AoÃ»', 'Septembre', 'Octobre',
						'Novembre', 'Decembre' ],
				monthsShort : [ 'Jan', 'Fev', 'Mar', 'Avr', 'Mai', 'Juin',
						'Juil', 'Aout', 'Sep', 'Oct', 'Nov', 'Dec' ],
				weekdaysFull : [ 'Dimanche', 'Lundi', 'Mardi', 'Mercredi',
						'Jeudi', 'Vendredi', 'Samedi' ],
				weekdaysShort : [ 'Dim', 'Lun', 'Mar', 'Mer', 'Jeu', 'Ven',
						'Sam' ],
				weekdaysLetter : [ 'D', 'L', 'M', 'M', 'J', 'V', 'S' ],
				today : '',
				clear : 'Raz',
				close : 'Fermer'

			});
	$(document).ready(function() {
		$('select').material_select();
	});
	$(document).ready(function() {
		// the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
		$('.modal').modal();
	});
</script>
</html>
