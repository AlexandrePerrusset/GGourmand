<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<ul id="dropdown1" class="dropdown-content">
			<li><a href="#!">one</a></li>
			<li><a href="#!">two</a></li>
			<li class="divider"></li>
			<li><a href="#!">three</a></li>
		</ul>
		<nav>
			<div class="nav-wrapper">
				<img src="sources/logo.jpg" class="logo1"> <a
					href="index.html"
					class="brand-logo logoGG text-darken-2 titleStyle"><i
					class="fa fa-cutlery" aria-hidden="true"></i> Gastronome Gourmand</a>
				<ul id="nav-mobile" class="right">
					<li><a class="dropdown-button" href="#!"
						data-activates="dropdown1">Dropdown<i
							class="material-icons right">arrow_drop_down</i></a></li>
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

<!-- TODO : liste des bookings avec cases à cocher pour valider les bookings par restaurant -->

	<div class="col s9">
		<h5 class="titreNomRestaurant">Réservations du restaurant : ${eatery.name}</h5>
		<br/>
		<table>
			<c:forEach items="${bookings}" var="booking" varStatus="status">
				<tr>
					<th><b>Date</b></th>
					<th><b>Nombre de personnes</b></th>
					<th><b>Utilisateur</b></th>
					<th><b>Mail utilisateur</b></th>
					<th><b>Check</b></th>
				</tr>
				<tr>
					<td>${booking.dateTime}</td>
					<td>${booking.numberOfPeople}</td>
					<td>${booking.firstName} ${booking.lastName}</td>
					<td>${booking.customerId}</td>
					<td>case à cocher</td>
				</tr>
			</c:forEach>
		</table>
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
</html>
