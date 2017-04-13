$('#recherche').autocomplete({
    source : function(){ // la fonction anonyme permet de maintenir une requête AJAX directement dans le plugin
	$.ajax({
            url : 'http://localhost:9200/gourmand/city/_search', // on appelle le script JSON
            dataType : 'json', // on spécifie bien que le type de données est en JSON
            crossDomain : true,
            success : function(donnee){ // on se prépare à renvoyer les données réceptionnées grâce à l'évènement de succès
            	return donnee.hits.hits._source.name;
            }
        });
    },
    minLength : 3
});