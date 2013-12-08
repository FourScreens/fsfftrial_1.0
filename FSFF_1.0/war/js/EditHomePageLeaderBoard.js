var data = "";
$.ajax({
	type : 'post',
	url : 'adminviewallfilms',
	dataType : 'json',
	data : data,
	success : function(result) {
		if (result.data != null) {
			var source = $("#viewFilms").html();
			var template = Handlebars.compile(source);
			var context = result.data;
			var html = template(context);
			$(".viewfilms").append(html);
			$.fn.raty.defaults.path = 'lib/img';
			;
			for ( var itr = 0; itr < context.length; itr++) {
				if (itr < 4) {
					$("#leader").checked(true);
				}
				console.log(itr + ":" + context[itr].FilmId);
				$('#' + context[itr].FilmId).raty(
						{
							score : context[itr].score,
							hints : [ 'Rotten', 'Poor', 'Indifferent', 'Good',
									'Gorgeous' ],
							half : true,
							click : updateRating,
						});
			}
		} else {
			var msg = result.message;
			$("#display-message").html(msg);
			$("#display-error").show();
		}
	},
	error : function() {
		console.log("Error");
	}
});

var updateRating = function(rating) {
	var data = {
		filmId : this.id,
		rating : rating,
	};
	$.ajax({
		url : "adminvoting",
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

$('.FilmList').on('submit', function(e) {
	var checkbox = $(this).find('input[type="checkbox"]');
	for ( var count = 0; count < checkbox.length; count++) {
		if ($checkbox[count].is(':checked')) {
			$(this).parents("div.row").hide();
		}
	}
	e.event.preventDefault();
	return false;
});
