var data = "";
$
		.ajax({
			type : 'post',
			url : 'adminviewroundonefilms',
			dataType : 'json',
			data : data,
			success : function(result) {
				console.log("Result" + result);
				if (result.data != null) {
					var source = $("#viewFilms").html();
					var template = Handlebars.compile(source);
					var context = result.data;
					var html = template(context);
					$(".viewfilms").append(html);
					$.fn.raty.defaults.path = 'lib/img';
					;
					for ( var itr = 0; itr < context.length; itr++) {
						console.log(itr + ":" + context[itr].FilmId);
						$('#' + context[itr].FilmId).raty(
								{
									score : context[itr].score,
									hints : [ 'Rotten', 'Poor', 'Indifferent',
											'Good', 'Gorgeous' ],
									half : true,
									click : updateRating,
								});
					}

					$(document)
							.ready(
									function() {

										$('#film-table')
												.dataTable(
														{
															"sDom" : "<'row'<'span8'l><'span8'f>r>t<'row'<'span8'i><'span8'p>>",
															"sPaginationType" : "bootstrap",
															"oLanguage" : {
																"sLengthMenu" : "_MENU_ records per page"
															}
														});

									});
				} else {
					var msg = result.message;
					console.log(msg);
					$("#display-message").html(msg);
					$("#display-error").show();
				}
			},
			error : function() {
				console.log("Error");
			}
		});

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
