var data = "part=leaderboard";
$.ajax({
	type : 'post',
	url : 'indexpageleaderboard',
	dataType : 'json',
	data : data,
	success : function(result) {
		var source = $("#viewFilmslead").html();
		var template = Handlebars.compile(source);
		var context = result;
		var html = template(context);
		// console.log(html);
		$(".viewfilmleaderboard").append(html);
		$.fn.raty.defaults.path = 'lib/img';
		for ( var itr = 0; itr < context.length; itr++) {
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
		;

	}
});

var data = "part=editorpicks";
$.ajax({
	type : 'post',
	url : 'indexpageeditorpicks',
	dataType : 'json',
	data : data,
	success : function(result) {
		var source1 = $("#viewFilmseditor").html();
		var template1 = Handlebars.compile(source1);
		var context1 = result;
		var html1 = template1(context1);
		$(".viewfilmeditorpicks").append(html1);
		$.fn.raty.defaults.path = 'lib/img';
		for ( var itr = 0; itr < context1.length; itr++) {
			$('#lelement' + context1[itr].FilmId).tooltip();

			$('#' + context1[itr].FilmId).raty(
					{
						score : context1[itr].score,
						hints : [ 'Rotten', 'Poor', 'Indifferent', 'Good',
								'Gorgeous' ],
						half : true,
						click : updateRating,
					});
		}
		;

	}
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

$('img[data-videoLoader]').on(
		'click',
		function() {
			console.log("Clicked");
			var iframe = $('<iframe></iframe>');
			iframe.attr({
				src : 'http://www.youtube.com/embed/'
						+ $(this).attr('data-videoLoader'),
				name : "inlineframe",
				frameborder : "0",
				scrolling : "auto",
				width : "200",
				height : "200",
				marginwidth : "5",
				marginheight : "5"
			});
			console.log(this);
			$(this).hide();
			$(this).parent('.videoContainter').append(iframe);
		});