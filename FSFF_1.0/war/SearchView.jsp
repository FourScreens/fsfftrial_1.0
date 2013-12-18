<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Bootbusiness | Short description about company">
<meta name="author" content="Your name">
<title>Four screens film festival</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap responsive -->
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<!-- Font awesome - iconic font with IE7 support -->
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/font-awesome-ie7.css" rel="stylesheet">
<!-- Bootbusiness theme -->
<link href="css/boot-business.css" rel="stylesheet">
</head>
<body>
	<%@ page import="com.fsff.ui.entity.UserSession"%>
	<!-- Start: HEADER -->
	<header>
		<!-- Start: Navigation wrapper -->
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container">
					<a href="#" class="brand brand-bootbus">Four Screens Film
						Festival</a>

					<!-- Start: Primary navigation -->
					<div class="nav-collapse collapse">
						<ul class="nav pull-right">
							<li class="active"><a href="index.jsp">Home</a></li>
							<li><a href="#about">About</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">View and Vote<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="Comedy.jsp">Comedy</a></li>
									<li><a href="Action.jsp">Action</a></li>
									<li><a href="Drama.jsp">Drama</a></li>
									<li><a href="Romance.jsp">Romance</a></li>
									<li><a href="Thriller.jsp">Thriller</a></li>
									<li><a href="Animation.jsp">Animation</a></li>
									<li><a href="Horror.jsp">Horror</a></li>
								</ul></li>
							<li><a href="uploadfilm.jsp">Enter the Film</a></li>
							<li><a href="Help.jsp">Help</a></li>
							<%
								if (request.getSession().getAttribute("JSESSIONID") == null) {
							%>
							<li><a href="signin.jsp">Sign in</a></li>
						</ul>
						<%
							} else if (request.getSession().getAttribute("JSESSIONID") != null) {
								UserSession sessionObject = (UserSession) request.getSession()
										.getAttribute("JSESSIONID");
								String login = sessionObject.getFirstName();
						%>

						<ul class="nav pull-right">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Welcome <%=login%> <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a class="active" href="LogOut" name="logout">Logout
									</a></li>
								</ul></li>
						</ul>

						<%
							}
						%>

					</div>
				</div>
			</div>
		</div>
		<!-- End: Navigation wrapper -->
	</header>
	<!-- End: HEADER -->
	<!-- Start: MAIN CONTENT -->
	<div class="content">
		<div class="container">
			<form method="post" name="srchfrm" action="Search">
				<div align=right class="search">
					<input type="search" name="search" placeholder="Search"> <select
						name="selector" id="selector">
						<option value="film">Film Name</option>
						<option value="cast">Cast</option>
						<option value="director">Director</option>
						<option value="writer">Writer</option>
						<option value="producer">producer</option>
					</select> <input type="submit" value="Search"
						class="btn btn-primary btn-large">
				</div>
			</form>

			<div class="viewfilm">

				<script id="viewFilms" type="text/x-handlebars-template">

          {{#each this}}
                     
          <div style="float:left;width:30%;">
        <h1>{{FilmName}}<h1>
       <div style="float:left;width:50%;margin: 0 auto;text-align:center;" class="flex-video widescreen videoContainter" >
<iframe name="inlineframe" src="http://www.youtube.com/embed/{{url}}" frameborder="0" scrolling="auto" width="200" height="200" marginwidth="5" marginheight="5" ></iframe>   
     </div>        
  <div style="float:right; width:40%; height:200px; overflow:scroll;" >
     <h6><span class="label label-primary">Cast:</span><br> {{Cast}} </h6>
       <h6><span class="label label-primary">Director:</span><br> {{Director}} </h6>
         <h6><span class="label label-primary">Producer:</span><br> {{Producer}} </h6>
          <h6><span class="label label-primary">Rating:</span><br><p class="star" id="{{FilmId}}"></p>
          <p class="star" id="num{{FilmId}}" style= "font-style:italic">({{numberOfVotes}} votes) </h6>
                
     </div>
     </div>

     {{/each}}
     </script>


			</div>
		</div>

		<div class="pagination pagination-right">
			<ul>
				<li><a href="#">Prev</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">Next</a></li>
			</ul>
		</div>
	</div>
	<!-- End: MAIN CONTENT -->
	<!-- Start: FOOTER -->
	<footer>
		<div class="container">
			<div class="row">

				<div class="span2">
					<h4>
						<i class="icon-beaker icon-white"></i> About
					</h4>
					<nav>
						<ul class="quick-links">

							<li><a href="news.html">News</a></li>
							<li><a href="events.html">Events</a></li>

							<ul>
					</nav>
				</div>
				<div class="span2">
					<h4>
						<i class="icon-thumbs-up icon-white"></i> Support
					</h4>
					<nav>
						<ul class="quick-links">
							<li><a href="contact_us.html">Contact us</a></li>
							<li><a href="#">Privacy Policy</a></li>
						</ul>
					</nav>

				</div>
				<div class="span3">
					<h4>Get in touch</h4>
					<div class="social-icons-row">
						<a href="#"><i class="icon-twitter"></i></a> <a href="#"><i
							class="icon-facebook"></i></a> <a href="#"><i
							class="icon-google-plus"></i></a>
					</div>
				</div>
			</div>
		</div>
		<hr class="footer-divider">
		<div class="container">
			<p>&copy; 2013-2014- Four Screen Film Festival, Inc. All Rights
				Reserved.</p>
		</div>
	</footer>
	<%
		String filmData = (String) request.getAttribute("filmData");
	%>

	<!-- End: FOOTER -->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/boot-business.js"></script>
	<script type="text/javascript" src="lib/jquery.raty.min.js"></script>
	<script type="text/javascript"
		src="https://raw.github.com/wycats/handlebars.js/1.0.0/dist/handlebars.js"></script>

	<script>
		var source = $("#viewFilms").html();
		//	console.log(source);
		var template = Handlebars.compile(source);
		//	console.log(template);
		var context =
	<%=filmData%>
		;
		console.log("search context= " + context);
		var html = template(context);
		//	console.log(html);
		$(".viewfilm").append(html);
		//star rating 
		$.fn.raty.defaults.path = 'lib/img';
		;
		for ( var itr = 0; itr < context.length; itr++) {
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
	</script>

</body>
</html>
