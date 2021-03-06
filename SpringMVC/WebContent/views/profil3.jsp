<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8" />
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
		<nav>
			<div class="nav-wrapper">
				<a
					href="/SpringMVC"
					class="brand-logo logoGG text-darken-2 titleStyle"> Gastronome
					Gourmand</a>
				<ul id="nav-mobile" class="right hide-on-med-and-down">
					<c:if test="${user.username != null}">
						<b><li id="bonjour"><i class="material-icons">perm_identity</i></li></b>
						<b><li id="bonjour">Bonjour ${user.firstName}</li></b>
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

	<div id="modal1" class="modal col s3 modalBox">
		<div class="modal-content">
			<form class="col s3">

				<div class="input-field col s3">
					<i class="material-icons prefix">account_circle</i> <input
						id="icon_prefix" type="text" class="validate"> <label
						for="icon_prefix">Nom de compte</label>
				</div>
				<div class="input-field col s3">
					<i class="material-icons prefix">vpn_key</i> <input
						id="icon_telephone" type="tel" class="validate"> <label
						for="icon_telephone">Mot de passe</label>
				</div>
				<a class="waves-effect waves-light btn-large modalLink">Se
					connecter</a>
			</form>

		</div>
	</div>




	<div class="contourc">
		<div class="traitrouge"></div>

		<div class="milieu">
			<div class="container">
				<div class="row">

					<div class="col s3">

						<div class="card">
							<div class="card-image">
								<img src="sources/user.jpg" alt="" class="circle responsive-img"
									class="photouser">
							</div>
							<div class="card-content">
								<p class="user">${user.firstName}
								${user.lastName}</p>
							</div>
						</div>


						<div class="collection">
							<a href="/SpringMVC/bookingsUser" class="collection-item">Mes r&eacute;servations</a>
							<a href="/SpringMVC/infos" class="collection-item ">Mes informations</a>
							<a href="#!" class="collection-item active">Mes avis</a>
						</div>
					</div>


					<div class="col s9">
						<h5 class="titreresa">Mes avis</h5>
						<c:forEach items="${reviews}" var="review" varStatus="status">
							<div class="card horizontal">
								<div class="row">
									<!-- 										<div class="col s3"> -->
									<!-- 											<div class="card-image"> -->
									<!-- 												<img src="sources/resto.jpg" class="responsive-img"> -->
									<!-- 											</div> -->
									<!-- 										</div> -->
									<div class="card-content">
										<div>
											<b>Restaurant : </b>${review.eateryName}
										</div>
										<div>
											<b>Note : </b>${review.rating}
										</div>
										<div>
											<b>Commentaire : </b>${review.comment}
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="traitrouge"></div>
			</div>

			<div id="modalReview" class="modal col s12 modalBox2">
				<div class="modal-content">
					<FORM id="Reviewform" action="review" method="post">
						<input type="hidden" name="bookingId" />
						<label>Note attribuée au restaurant (sur 10)</label>
						<input type="number" name="rating" id="rating" min="0" max="10" />
<!-- 						<select name="rating" type="int"> -->
<!-- 							<option value="1">1</option> -->
<!-- 							<option value="2">2</option> -->
<!-- 							<option value="3">3</option> -->
<!-- 							<option value="4">4</option> -->
<!-- 							<option value="5">5</option> -->
<!-- 							<option value="6">6</option> -->
<!-- 							<option value="7">7</option> -->
<!-- 							<option value="8">8</option> -->
<!-- 							<option value="9">9</option> -->
<!-- 							<option value="10">10</option> -->
<!-- 						</select> -->
						<label>Commentaire</label>
						<input name="comment" type="text" />
						<br />
						<input type="submit" value="Envoyer" />
					</FORM>
				</div>
			</div>
		</div>
	</div>
</body>

<!-- Footer -->
<footer class="page-footer">


	<div id="espace-footer"></div>


	<div class="footer-copyright">
		<div class="container">@2017, Infotel</div>
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
