$('#icon_prefix').autocomplete({
		minlength : 5,
		source : function(requete, response) { // les deux arguments représentent les données nécessaires au plugin
			$.ajax({
				url : 'http://localhost:9200/bat/cities,eateries/_search?q=*' + requete.term + '*', // on appelle le script JSON
				type: "GET",
				dataType: "json", 				
				success : function(data) {
					response($.map(data.hits.hits, function(item){
					    return item._source.name;
					}));
				}
			})
		}
	});