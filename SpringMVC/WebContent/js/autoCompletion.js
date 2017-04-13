$('#recherche').autocomplete({
    source : function(){ // la fonction anonyme permet de maintenir une requête AJAX directement dans le plugin
	$.ajax({
            url : 'http://localhost:9200/gourmand/city/_search', // on appelle le script JSON
            dataType : 'json', // on spécifie bien que le type de données est en JSON
            
            success : function(){ // on se prépare à renvoyer les données réceptionnées grâce à l'évènement de succès
            }
        });
    },
    minLength : 3
});