var data = "genre=Comedy";
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


var updateRating = function(rating){
    var data= {
    filmId:  this.id,
    rating: rating ,
  };
  $.ajax({
    url:"voting",
    type:'GET',
    dataType:'json',
    data: data,
    success: function(){

    },
    error: function(){
       $('#'+data.filmId).raty({
        score:data.rating,
  readOnly : true,

});

    }
  });
}
    $.fn.raty.defaults.path = 'lib/img';;
   for (var itr = 0; itr < context.length; itr++) {
    $('#'+context[itr].FilmId).raty({
      score:context[itr].score,
      hints: ['Rotten', 'Poor', 'Indifferent', 'Good', 'Gorgeous'],
      half: true,
      click: updateRating,
    });
   };

   $('img[data-videoLoader]').on('click', function()  {
      var iframe = $('<iframe></iframe>');
      iframe.attr({
        src: 'http://www.youtube.com/embed/' + $(this).attr('data-videoLoader'),
        name: "inlineframe",
        frameborder:"0",
        scrolling:"auto",
        width:"200",
        height:"200",
        marginwidth:"5",
        marginheight:"5"
      });
      console.log(this);
      $(this).hide();
      $(this).parent('.videoContainter').append(iframe);
   });