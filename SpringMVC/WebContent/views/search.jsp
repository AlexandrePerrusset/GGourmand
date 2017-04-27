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
		<ul id="dropdown" class="dropdown-content">
			<li><a href="#modalU"><i id="icone" class="material-icons">person</i>Utilisateur</a></li>
			<li><a href="#modalM"><i id="icone" class="material-icons">person</i>Restaurateur</a></li>
		</ul>

		<nav>
			<div class="nav-wrapper">
				<a
					href="/SpringMVC"
					class="brand-logo logoGG text-darken-2 titleStyle"><i
					class="fa fa-cutlery" aria-hidden="true"></i> Gastronome Gourmand</a>
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

	<div id="modalU" class="modal col s5 modalBox">
		<div class="modal-content">
			<form class="col s3" action="authent" method="POST">

				<div class="input-field col s3">
					<i class="material-icons prefix">account_circle</i> <input
						name="username" id="icon_prefix" name="nom" type="text"
						class="validate" required="true"> <label for="icon_prefix">Email</label>
				</div>
				<div class="input-field col s3">
					<i class="material-icons prefix">vpn_key</i> <input name="password"
						id="icon_telephone" type="password" type="tel" class="validate" required="true"> <label
						for="icon_telephone">Mot de passe</label>
				</div>
				<div>
					<input name="connection" type="submit" value="Se connecter"
						class="waves-effect waves-light btn modalLink" />
				</div>
			</form>

		</div>
	</div>
	
	<div id="modalM" class="modal col s5 modalBox">
		<div class="modal-content">
			<form class="col s3" action="authentM" method="POST">

				<div class="input-field col s3">
					<i class="material-icons prefix">account_circle</i> <input
						name="usernameM" id="icon_prefix" name="nom" type="text"
						class="validate" required="true"> <label for="icon_prefix">Email</label>
				</div>
				<div class="input-field col s3">
					<i class="material-icons prefix">vpn_key</i>
					<input
						name="passwordM" id="icon_telephone" type="password" type="tel" class="validate" required="true">
					<label for="icon_telephone">Mot de passe</label>
				</div>
				<div>
					<input name="connection" type="submit" value="Se connecter"
						class="waves-effect waves-light btn modalLink" />
				</div>
			</form>

		</div>
	</div>

	<div id="modal2" class="modal col s12 modalBox2">
		<div class="modal-content">
			<div class="row">
				<form class="col s12" action="register" method="post">
					<div class="row">
						<div class="input-field col s2">
							<select name="title" id="type">
								<option value="mr">Mr</option>
								<option value="mme">Mme</option>
							</select>
						</div>
						<div class="input-field col s5">
							<input name="nom" id="first_name" type="text" class="validate"
								required="true"> <label for="first_name">Nom</label></input>
						</div>
						<div class="input-field col s5">
							<input name="prenom" id="last_name" type="text" class="validate"
								required="true"> <label for="last_name">Pr&eacute;nom</label></input>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="material-icons prefix">mail</i> <input name="username"
								id="email" type="email" class="validate" required="true">
							<label for="email">Email</label></input>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="material-icons prefix">vpn_key</i> <input
								name="password" id="password" type="password" class="validate"
								required="true"> <label for="password">Mot de
								passe</label></input>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="material-icons prefix">phone</i> <input name="tel"
								id="icon_telephone" type="tel" class="validate" required="true">
							<label for="icon_telephone">T&eacute;l&eacute;phone</label></input>
						</div>
					</div>
					<input type="submit"
						class="waves-effect waves-light btn-large modalLink"
						value="Cr&eacute;er mon compte" />
				</form>
			</div>

		</div>
	</div>

	<div class="barrerecherche">
		<div class="row container">
			<div class="row">
				<form class="col s12" action="eateries" method="get">
					<div class="row">
						<div class="input-field col s4">
							<input id="icon_prefix" type="text" class="validate"
								name="recherche" required="true"> <label for="icon_prefix">${sessionScope.recherche}</label>
						</div>
						<div class="input-field col s2">
							<select name="cooking" type="int">
								<option value="0" selected>${sessionScope.cookingname}</option>
								<c:forEach items="${cookingDto}" var="cookingstyle">
									<option value="${cookingstyle.id}">${cookingstyle.name}</option>
								</c:forEach>
							</select> <label for="icon_prefix">Cuisine</label>
						</div>
						<div class="input-field col s2">
							<i class="material-icons prefix">today</i> <input name="date"
								type="date" class="datepicker"> <label for="icon_prefix">${sessionScope.date}</label>
						</div>
						<div class="input-field col s2">
							<i class="material-icons prefix">supervisor_account</i> <select
								name="NbPer">
								<option>${sessionScope.NbPer}</option>
								<c:forEach var="i" begin="1" end="15" step="1">
									<option value="${i}">${i}</option>
								</c:forEach>
							</select> <label for="icon_prefix">Combien ?</label>
						</div>
						<div class="input-field col s2">
							<a class="searchLink"><button
									class="btn waves-effect waves-light buttonSpe" type="submit">
									Chercher <i class="material-icons right">search</i>
								</button></a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<div class="resultats">
		<div class="container">
			<div class="row">
<!-- 				<div class="col s3"> -->
<!-- 					<div class="card-panel white"> -->
<!-- 						<form class="filters" action="#"> -->
<!-- 							<p class="range-field"> -->
<!-- 								<label for="prix">Prix</label> <input type="range" id="prix" -->
<!-- 									min="0" max="100" /> -->
<!-- 							</p> -->
<!-- 							<p class="range-field"> -->
<!-- 								<label for="prix">Horaires</label> <input type="range" -->
<!-- 									id="horaires" min="0" max="23" /> -->
<!-- 							</p> -->
<!-- 							<p> -->
<!-- 								<input type="checkbox" class="filled-in checkbox-green" -->
<!-- 									id="parking" /> <label for="parking">Parking à  -->
<!-- 									proximit&eacute;</label> -->
<!-- 							</p> -->
<!-- 					</div> -->
<!-- 					</form> -->

<!-- 				</div> -->
				<div class="col s12">
					<h5 class="titreResultats">R&eacute;sultats</h5>

					<c:forEach items="${eateriesDto}" var="eatery" varStatus="status">
						<div class="card horizontale">
							<div class="row">
								<div class="col s3">
									<div class="card-image">
										<a href="eateries/reservation/${eatery.id}"><img
											src="${imgdto[status.index].content}" class="imgsearch"></a>
									</div>
								</div>
								<div class="col s9">
									<div class="card-content">

										<h5 style="display: inline;">
											<a class="titre2" href="eateries/reservation/${eatery.id}">${eatery.name}</a>
										</h5>
										<span class="titrecity">${eatery.city}</span>
										<ul>
											<li><i class="material-icons prefix">restaurant</i>${eatery.cookingStyle}</li>
											<li><i class="material-icons prefix">euro_symbol</i>${eatery.price}
												en moyenne par personne</li>
											<c:forEach items="${eatery.eateryTagName}" var="tag">
												<li><i class="material-icons prefix">favorite</i>${tag}
												</li>
											</c:forEach>

										</ul>




									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
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
		$('select').material_select();
	});
	$(document).ready(function() {
		// the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
		$('.modal').modal();
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
</script>
</html>
