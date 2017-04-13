$('#recherche').autocomplete({
		source : function(requete, response) { // les deux arguments représentent les données nécessaires au plugin
			$.ajax({
				url : 'http://localhost:9200/gourmand/city/_search', // on appelle le script JSON
				dataType : 'json', // on spécifie bien que le type de données est en JSON
				crossDomain : true,
				minlength : 3,
				success : function(data) {
					response($.map(data.hits.hits, function(item){
					    return item._source.name;
					}));
				}
			});
		}
	});