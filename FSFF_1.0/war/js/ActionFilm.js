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
		console.log(context);
		var html = template(context);
	//	console.log(html);
		$(".viewfilm").append(html);
		//star rating 
		$.fn.raty.defaults.path = 'lib/img';;
		   for (var itr = 0; itr < context.length; itr++) {
			   console.log(itr+":"+context[itr].FilmId); 
		    $('#'+context[itr].FilmId).raty({
		    	 score:context[itr].score,
		      hints: ['Rotten', 'Poor', 'Indifferent', 'Good', 'Gorgeous'],
		      half: true,
		      click: updateRating,
		    });
		   }
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

