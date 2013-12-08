var data = "genre=Comedy";
$.ajax({
	type : 'post',
	url : 'viewFilm',
	dataType : 'json',
	data : data,
	success : function(result) {
		var source = $("#viewFilms").html();
		var template = Handlebars.compile(source);
		var context = result;
		var html = template(context);
		console.log(html);

		$(".viewfilm").append(html);
		$.fn.raty.defaults.path = 'lib/img';
		;
		for ( var itr = 0; itr < context.length; itr++) {
			console.log(itr + ":" + context[itr].FilmId);
			$('#element' + context[itr].FilmId).tooltip();
			$('#' + context[itr].FilmId).raty(
					{
						score : context[itr].score,
						hints : [ 'Rotten', 'Poor', 'Indifferent', 'Good',
								'Gorgeous' ],
						half : true,
						click : updateRating,
					});
		}
	},
	error : function() {
		console.log("Error");
	}

});

$(function() {
	$("[rel='tooltip']").tooltip();
});
var updateRating = function(rating) {
	var data = {
		filmId : this.id,
		rating : rating,
	};
	$.ajax({
		url : "voting",
		type : 'GET',
		dataType : 'json',
		data : data,
		success : function() {

		},
		error : function() {
			$('#' + data.filmId).raty({
				score : data.rating,
				readOnly : true,

			});

		}
	});
}

$(document).on("click", ".open-viewer", function() {
	var vidId = $(this).data('id');
	$('iframe').attr("src", 'http://www.youtube.com/embed/' + vidId);

});