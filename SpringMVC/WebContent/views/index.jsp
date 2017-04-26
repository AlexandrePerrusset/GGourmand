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
		<ul id="dropdown" class="dropdown-content">
			<li><a href="#modalU"><i id="icone" class="material-icons">person</i>Utilisateur</a></li>
			<li><a href="#modalM"><i id="icone" class="material-icons">person</i>Restaurateur</a></li>

		</ul>

		<nav>
			<div class="nav-wrapper">
				<img src="sources/logo.jpg" class="logo1"> <a
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
						type="password" id="icon_telephone" type="tel" class="validate" required="true">
					<label for="icon_telephone">Mot de passe</label>
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
					<i class="material-icons prefix">vpn_key</i> <input
						name="passwordM" type="password" id="icon_telephone" type="tel" class="validate"
						required="true"> <label for="icon_telephone">Mot
						de passe</label>
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


	<div class="parallax-container">
		<div class="parallax">
			<img src="sources/para1.jpg">
		</div>
	</div>
	<div class="section paraBox">
		<div class="row container">
			<div class="row">
				<form class="col s12" action="eateries" method="get">
					<div class="row">
						<div class="input-field col s4">
							<input id="icon_prefix" type="text" class="validate"
								name="recherche" required="true"> <label
								for="icon_prefix">Cherchez un restaurant ou une ville !</label>
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
							<i class="material-icons prefix">today</i> <input name="date"
								type="date" class="datepicker"> <label for="icon_prefix">Date</label>
						</div>
						<div class="input-field col s2">
							<i class="material-icons prefix">supervisor_account</i> <select
								name="NbPer">
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
	<div class="parallax-container">
		<div class="parallax">
			<img src="sources/para2.jpg">
		</div>
	</div>
</body>


<footer class="page-footer">
	<div class="container">
<h5 id="villes">Villes les plus populaires</h5>
	<div class="image-grid">
		<c:forEach items="${citiesDto}" var="city" varStatus="status">			
				<div class="card">
					<div class="card-image">
					<a href="eateries?recherche=${city.name}&cooking=0&date=0&NbPer=1" ><img id="imgville" src="${imgdto[status.index].content}">
						<span id="ville" class="card-title">${city.name}</span></a>
					</div>
				</div>			
		</c:forEach>
		</div>
	</div>

<div id="espace-footer"></div>


	<div class="footer-copyright">
		<div class="container">@2017, Infotel</div>
	</div>
</footer>






<!--Import jQuery before materialize.js-->
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/base/jquery-ui.css" type="text/css" media="all" />
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.js" type="text/javascript"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript" src="js/autoCompletion.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.parallax').parallax();
	});
	$('.datepicker').pickadate(
			{
				selectMonths : true, // Creates a dropdown to control month
				format : 'dd/mm/yyyy',
				monthsFull : [ 'Janvier', 'F&eacute;vrier', 'Mars', 'Avril',
						'Mai', 'Juin', 'Juillet', 'Ao&ucirc;t', 'Septembre',
						'Octobre', 'Novembre', 'D&eacute;cembre' ],
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
	
// 	$document.ready(function() {
// 		var dateToday = new Date();
// 		$('.datepicker').change(function() {
// 			var updatedDate = $(this).val();
// 			var instance = $(this).data("datepicker");
// 			var date = $.datepicker.parseDate(instance.settings.dateFormat || $.datePicker._defaults.dateFormat, updatedDate, instance.settings);
// 			startDate: "21/04/2017";
			
// 			if(date < dateToday) {
// 				$(this).datepicker("setDate", dateToday);
// 			}
// 		});
// 	});
	
// 	$('.datepicker').datepicker(
//          { 
//             beforeShow: function() {
//             $(this).datepicker('option', 'minDate', $('.datepicker').val());
//             if($('.datepicker').val() === '') $(this).datepicker('option', 'minDate', 0);
//             minDate: new Date(2017, 04, 21)
//           }
//        });
</script>
</html>
