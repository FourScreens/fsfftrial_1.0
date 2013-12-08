var data = "";
$.ajax({
	type : 'post',
	url : 'adminindex',
	dataType : 'json',
	data : data,
	success : function(result) {
		console.log("Result:" + result);
		var source = $("#indexData").html();
		var template = Handlebars.compile(source);
		var context = result;
		var html = template(context);
		$(".stats").append(html);
	},
	error : function() {
		console.log("Error");
	}
});
