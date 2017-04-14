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
				<img src="sources/logo.jpg" class="logo1"> <a
					href="/SpringMVC"
					class="brand-logo logoGG text-darken-2 titleStyle"><i
					class="fa fa-cutlery" aria-hidden="true"></i> Gastronome Gourmand</a>
				<ul id="nav-mobile" class="right hide-on-med-and-down">
					<c:if test="${userM.username != null}">
						<li><a href="/SpringMVC/reports">Mes validations</a></li>
						<li><a href="/SpringMVC/logout">Se d&eacute;connecter</a></li>
					</c:if>
					<c:if test="${userM.username == null}">
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
			<form class="col s3"
				action="http://localhost:8080/HelloWorldTest/bonjour" method="POST">

				<div class="input-field col s3">
					<i class="material-icons prefix">account_circle</i> <input
						id="icon_prefix" name="nom" type="text" class="validate">
					<label for="icon_prefix">Nom de compte</label>
				</div>
				<div class="input-field col s3">
					<i class="material-icons prefix">vpn_key</i> <input
						id="icon_telephone" type="tel" class="validate"> <label
						for="icon_telephone">Mot de passe</label>
				</div>
				<input type="submit"
					class="waves-effect waves-light btn-large modalLink"
					value="Se connecter" />
			</form>

		</div>
	</div>

	<div id="modal2" class="modal col s12 modalBox2">
		<div class="modal-content">
			<div class="row">
				<form class="col s12">
					<div class="row">
						<div class="input-field col s2">
							<select id="type">
								<option value="mr">Mr</option>
								<option value="mme">Mme</option>
							</select>
						</div>
						<div class="input-field col s5">
							<input id="first_name" type="text" class="validate"> <label
								for="first_name">Nom</label>
						</div>
						<div class="input-field col s5">
							<input id="last_name" type="text" class="validate"> <label
								for="last_name">Pr&eacute;nom</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="material-icons prefix">vpn_key</i> <input id="password"
								type="password" class="validate"> <label for="password">Mot
								de passe</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="material-icons prefix">mail</i> <input id="email"
								type="email" class="validate"> <label for="email">Email</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="material-icons prefix">phone</i> <input
								id="icon_telephone" type="tel" class="validate"> <label
								for="icon_telephone">t&eacute;l&eacute;phone</label>
						</div>
					</div>
					<input type="submit"
						class="waves-effect waves-light btn-large modalLink"
						value="Cr&eacute;er mon compte" />
				</form>
			</div>

		</div>
	</div>

	<div class="contourc">
		<div class="traitrouge"></div>

		<div class="milieu">
			<div class="col s9">
				<h5 class="titreNomRestaurant">R&eacute;servations du
					restaurant : ${eatery.name}</h5>
				<div class="container">
					<div class="card">
						<c:forEach items="${bookings}" var="booking" varStatus="status">
							<div class="card horizontal">
								<div class="row">
									<div class="card-content">
										<div>
											<b>R&eacute;servation n° : </b>${booking.id}
										</div>
										<div>
											<b>Date : </b>
											<fmt:formatDate value="${booking.dateTime.time}"
												dateStyle="short" />
										</div>
										<div>
											<b>Nombre de personnes : </b>${booking.numberOfPeople}
										</div>
										<div>
											<b>Utilisateur : </b>${booking.firstName} ${booking.lastName}
										</div>
										<div>
											<b>Mail utilisateur : </b>${booking.customerId}
										</div>
										<div onclick="updateForm(this)">
											<a href="#modalForm"><b>Confirmer</b></a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="traitrouge"></div>
			</div>
		</div>
	</div>

	<script>
		function updateForm(element) {
			var parent = $(element).parent();
			var bookid = $(parent).children().eq(0).text();

			$('#bookingform input').eq(0).val(bookid);

		}
	</script>

	<div id="modalForm" class="modal col s12 modalBox2">
		<div class="modal-content">
			<FORM id="bookingform" action="report" method="post">
				<input type="hidden" name="bookingId" /> <input id="presence"
					name="presence" type="checkbox" /><label for="presence">Présence
					client</label> <br /> <label>Montant payé</label><input name="montantPaye"
					type="number" /> <label>Commentaire</label><input name="comment"
					type="text" /> <input type="submit" value="Valider" />
			</FORM>
		</div>
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
