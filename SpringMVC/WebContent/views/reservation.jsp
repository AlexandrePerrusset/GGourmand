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
		<ul id="dropdown" class="dropdown-content">
			<li><a href="#modal1"><i id="icone" class="material-icons">person</i>Utilisateur</a></li>
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


				</ul>

			</div>
		</nav>
	</div>
</header>






<body>

	<div id="modal1" class="modal col s5 modalBox">
		<div class="modal-content">
			<form class="col s3" action="authentResa" method="POST">

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
				<div id="divbtn">
					<input name="connection" type="submit" value="Se connecter"
						class="waves-effect waves-light btn modalLink" /> <a
						href="#modal2"><input name="creation" type="submit"
						value="Créer un compte"
						class="waves-effect waves-light btn modalLink" /></a>
				</div>
			</form>

		</div>
	</div>

	<div id="modalM" class="modal col s5 modalBox">
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
				<div id="divbtn">
					<input name="connection" type="submit" value="Se connecter"
						class="waves-effect waves-light btn modalLink" />
				</div>
			</form>

		</div>
	</div>

	<div id="modal2" class="modal col s12 modalBox2">
		<div class="modal-content">
			<div class="row">
				<form class="col s12" action="registerResa" method="post">
					<div class="row">
						<div class="input-field col s2">
							<select name="title" id="type">
								<option value="mr">Mr</option>
								<option value="mme">Mme</option>
							</select>
						</div>
						<div class="input-field col s5">
							<input name="nom" id="first_name" type="text" class="validate" required="true">
							<label for="first_name">Nom</label></input>
						</div>
						<div class="input-field col s5">
							<input name="prenom" id="last_name" type="text" class="validate" required="true">
							<label for="last_name">Pr&eacute;nom</label></input>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="material-icons prefix">mail</i> <input name="username"
								id="email" type="email" class="validate" required="true"> <label
								for="email">Email</label></input>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="material-icons prefix">vpn_key</i> <input
								name="password" id="password" type="password" class="validate" required="true">
							<label for="password">Mot de passe</label></input>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="material-icons prefix">phone</i> <input name="tel"
								id="icon_telephone" type="tel" class="validate" required="true"> <label
								for="icon_telephone">T&eacute;l&eacute;phone</label></input>
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
							<i class="material-icons prefix">today</i> <input type="date"
								name="date" class="datepicker"> <label for="icon_prefix">${sessionScope.date}</label>
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
	</div>

	<div class="contourc">
		<div class="traitrouge"></div>

		<div class="milieu">
			<div class="container">
				<div class="card">


					<div class="card-content">
						<div class="row">
							<div class="input-field col s4">
								<h5 class="titre">${eatery.name}</h5>
							</div>
							<c:if test="${sessionScope.user != null}">
								<div class="input-field col s8">
									<a href="eateries/reservation/${eatery.id}/confirmresa"><button
											class="btn waves-effect waves-light buttonSpe" type="submit"
											name="resa">
											R&eacute;server<i class="material-icons right">done</i>
										</button></a>
								</div>
							</c:if>
							<c:if test="${sessionScope.user == null}">
								<div class="input-field col s8">
									<a href="#modal1"><button
											class="btn waves-effect waves-light buttonSpe" type="submit"
											name="resa">
											R&eacute;server<i class="material-icons right">done</i>
										</button></a>
								</div>
							</c:if>
						</div>
					</div>



					<div class="card-tabs">
						<ul class="tabs tabs-fixed-width">
							<li class="tab"><a class="active" href="#infos">Informations
									pratiques</a></li>
							<li class="tab"><a href="#description">Description</a></li>
							<li class="tab"><a href="#menu">Menu</a></li>
							<li class="tab"><a href="#avis">Avis</a></li>
						</ul>
					</div>
					<div class="card-content">
						<div id="infos" class="row">
							<div class="col s4">

								<div>
									<img class="imgdto" src="${imgdto.content}">
								</div>
								<br>
								
								<c:if test="${eatery.eateryTagName == null}"></c:if>
								<c:if test="${eatery.eateryTagName != null}">
									<div>
										<c:forEach items="${eatery.eateryTagName}" var="tag">
											<div class="chip">${tag}</div>
										</c:forEach>
									</div>
								</c:if>

							</div>
							<div class="col s8">
								<h6>Type de cuisine</h6>
								<p>${eatery.cookingStyle}</p>
								<hr>
								<h6>Horaires d'ouverture</h6>
								<p>${eatery.hoursOfOperation1}</p>
								<p>${eatery.hoursOfOperation2}</p>
								<hr>
								<h6>Coordonn&eacute;es et localisation</h6>
								<p>
									<b>Adresse :</b> ${eatery.street} - ${eatery.postCode}
									${eatery.city}
								</p>
								<p>
									<b>Comment y acc&eacute;der :</b> ${eatery.gettingThere}
								</p>
								<p>
									<c:if test="${eatery.parking == null}"></c:if>
									<c:if test="${eatery.parking != null}">
										<b>Parking : </b>${eatery.parking}</c:if>
								</p>
								<hr />
								<h6>Options de paiement</h6>
								<p>${eatery.paymentOptions}</p>
							</div>
						</div>
						<div id="description" class="description">${eatery.description}</div>
						<div id="menu">
							<h5 class="titre">Prix moyen d'un repas - ${eatery.price}</h5>
							<h6>
								<c:if test="${eatery.executiveChef == null}"></c:if>
								<c:if test="${eatery.executiveChef != null}">
									<b>Chef cuisinier : </b>${eatery.executiveChef}</c:if>
							</h6>
							<br />
							<c:forEach items="${eatery.menu.parts}" var="part">
								<h6>${part.title}</h6>
								<br />
								<c:forEach items="${part.items}" var="item">
									<div>${item.title}- ${item.price}</div>
								</c:forEach>
								<br />
							</c:forEach>
						</div>

						<div id="avis">
							<c:forEach items="${eatery.reviews}" var="review">
								<p>
									<b>Date : </b><fmt:formatDate dateStyle="short"
										value="${review.dateTime.time}" />
								</p>
								<p>
									<b>Avis publi&eacute; par</b> ${review.lastName}
								</p>
								<p>
									<b>Note : </b>${review.rating}/10</p>
								<p>
									<b>Commentaire : </b>${review.comment}</p>
								<hr>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="traitrouge"></div>
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
