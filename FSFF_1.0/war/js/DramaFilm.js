var data = "genre=Drama";
$.ajax({
	type : 'post',
	url : 'viewFilm',
	dataType : 'json',
	data : data,
	success : function(result) {
		console.log("Success");
		var source = $("#viewFilms").html();
//		console.log(source);
		var template = Handlebars.compile(source);
//		console.log(template);
		var context = result;
//		console.log(context);
		var html = template(context);
		console.log(html);
		$(".viewfilm").append(html);
	},
	error : function() {
		console.log("Error");
	}

});