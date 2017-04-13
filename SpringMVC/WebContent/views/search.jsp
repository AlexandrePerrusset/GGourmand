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
		<nav>
			<div class="nav-wrapper">
				<img src="sources/logo.jpg" class="logo1"> <a
					href="index.html"
					class="brand-logo logoGG text-darken-2 titleStyle"><i
					class="fa fa-cutlery" aria-hidden="true"></i> Gastronome Gourmand</a>
				<ul id="nav-mobile" class="right hide-on-med-and-down">
					<li><a href="#modalU">Se connecter</a></li>
					<li><a href="#modal2">Cr&eacute;er un compte</a></li>
				</ul>
			</div>
		</nav>
	</div>
</header>

<body>

	<div id="modalU" class="modal col s5 modalBox">
		<div class="modal-content">
			<form class="col s3"
				action="authent" method="POST">

				<div class="input-field col s3">
					<i class="material-icons prefix">account_circle</i> <input
						name="username" id="icon_prefix" name="nom" type="text" class="validate">
					<label for="icon_prefix">Nom de compte</label>
				</div>
				<div class="input-field col s3">
					<i class="material-icons prefix">vpn_key</i> <input
						name="password" id="icon_telephone" type="tel" class="validate"> <label
						for="icon_telephone">Mot de passe</label>
				</div>
				<div>
					<input name="connection" type="submit" value="Se connecter" class="waves-effect waves-light btn modalLink" />
				</div>
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
						value="CrÃ©er mon compte" />
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
								name="recherche"> <label for="icon_prefix">Cherchez
								un restaurant ou un plat !</label>
						</div>
						<div class="input-field col s2">
							<select name="cooking" type="int">
								<option value="0" selected>Type cuisine</option>
								<c:forEach items="${cookingDto}" var="cookingstyle">
									<option value="${cookingstyle.id}">${cookingstyle.name}</option>
								</c:forEach>
							</select> <label for="icon_prefix">Cuisine</label>
						</div>
						<div class="input-field col s2">
							<i class="material-icons prefix">today</i> <input type="date"
								class="datepicker"> <label for="icon_prefix">Date</label>
						</div>
						<div class="input-field col s2">
							<i class="material-icons prefix">supervisor_account</i>
							<select>
								<c:forEach var="i" begin="1" end="15" step="1">
									<option value="${i}">${i}</option>
								</c:forEach>
							</select> <label for="icon_prefix">Combien ?</label>
						</div>
						<div class="input-field col s2">
							<a class="searchLink" ><button
									class="btn waves-effect waves-light buttonSpe" type="submit">
									Chercher <i class="material-icons right">search</i>
								</button></a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</div>

	<div class="resultats">
		<div class="container">
			<div class="row">
				<div class="col s3">
					<div class="card-panel white">
						<form class="filters" action="#">
							<p class="range-field">
								<label for="prix">Prix</label> <input type="range" id="prix"
									min="0" max="100" />
							</p>
							<p class="range-field">
								<label for="prix">Horaires</label> <input type="range"
									id="horaires" min="0" max="23" />
							</p>
							<p>
								<input type="checkbox" class="filled-in checkbox-green"
									id="parking" /> <label for="parking">Parking à 
									proximit&eacute;</label>
							</p>
					</div>
					</form>

				</div>
				<div class="col s9">
					<h5 class="titreResultats">R&eacute;sultats</h5>

					<c:forEach items="${eateriesDto}" var="eatery" varStatus="status">
						<div class="card horizontale">
							<div class="row">
								<div class="col s3">
									<div class="card-image">
										<a href="eateries/reservation/${eatery.id}"><img src="${imgdto[status.index].content}" class="imgsearch"></a>
									</div>
								</div>
								<div class="col s9">
									<div class="card-content">

									<h5 style="display:inline;"><a class="titre2" href="eateries/reservation/${eatery.id}">${eatery.name}</a></h5>		
									<span class="titrecity">${eatery.city}</span>
									<ul>
									<li><i class="material-icons prefix">restaurant</i>${eatery.cookingStyle}</li>
									<li><i class="material-icons prefix">euro_symbol</i>${eatery.price} en moyenne par personne</li>						
									<c:forEach items="${eatery.eateryTagName}" var="tag">
											<li><i class="material-icons prefix">favorite</i>${tag} </li>
										</c:forEach>
							
									</ul>
					

										

									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					
			

					

				</div>
				<ul class="pagination">
					<li class="disabled"><a href="#!"><i
							class="material-icons">chevron_left</i></a></li>
					<li class="active"><a href="#!">1</a></li>
					<li class="waves-effect"><a href="#!">2</a></li>
					<li class="waves-effect"><a href="#!">3</a></li>
					<li class="waves-effect"><a href="#!">4</a></li>
					<li class="waves-effect"><a href="#!">5</a></li>
					<li class="waves-effect"><a href="#!"><i
							class="material-icons">chevron_right</i></a></li>
				</ul>
			</div>
		</div>
	</div>
	</div>
	</div>
</body>

<!-- Footer -->
<footer class="page-footer">
	<a id="lien_hp" class="btn-floating btn-large red" href="#"><i
		class="large material-icons">navigation</i></a>
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
