$.fn.raty.defaults.path = 'lib/img';
;
for ( var itr = 0; itr < context.length; itr++) {
	console.log(itr + ":" + context[itr].FilmId);
	$('#' + context[itr].FilmId).raty({
		score : context[itr].score,
		hints : [ 'Rotten', 'Poor', 'Indifferent', 'Good', 'Gorgeous' ],
		half : true,
		click : updateRating,
	});
}

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
