<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="FSFF | Short description about company">
<meta name="author" content="Your name">
<title>FOUR SCREENS FILM FESTIVAL</title>
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

	<!-- Start: MODAL -->

	<div id="viewFilmClipDialog" class="modal hide fade" tabindex="-1"
		role="dialog">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">x</button>
			<h3>Video</h3>
		</div>
		<div class="modal-body">
			<div
				style="float: left; width: 50%; margin: 0 auto; text-align: center;"
				class="flex-video widescreen videoContainter">
				<iframe id="dialogIFrame" src="" style="zoom: 0.60" frameborder="0"
					height="400" width="500"></iframe>
			</div>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal">OK</button>
		</div>
	</div>
	<!-- End: MODAL -->
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
	<!-- Start: popular films -->
	<div class="content">

		<div class="container">
			<div class="page-header">
				<h2>Popular Movies</h2>
			</div>
			<div class="row-fluid">

				<div class="viewfilmleaderboard thumbnails">
					<script id="viewFilmslead" type="text/x-handlebars-template">
          					{{#each this}}
               					<div id="element{{FilmId}}" data-toggle="tooltip" data-placement="top" title="" data-original-title="<p>CAST:{{Cast}} </p><p>DIRECTOR:{{Director}} </p><p>PRODUCER: {{Producer}}</p>" style="float:left;margin:25px;" class="flex-video widescreen videoContainter" >
          						<h4> {{FilmName}}</h4>
       							<img src="http://img.youtube.com/vi/{{url}}/hqdefault.jpg" style="height:200px; width:200px" class="clearfix" >
       							<div><a data-toggle="modal" data-id={{url}} data-ratingId={{Rating}} title="Add this item" class="open-viewer" href="#viewFilmClipDialog">View Film</a></div>
       							<p class="star" id="{{FilmId}}"></p>
       							</div> 
     						{{/each}}
     					</script>
				</div>
			</div>
		</div>
		<!-- End: popular films -->
		<!-- Start: Editor Pics -->
		<div class="container">
			<div class="page-header">
				<h2>Editor's Picks</h2>
			</div>
			<div class="row-fluid">

				<div class="viewfilmeditorpicks thumbnails">
					<script id="viewFilmseditor" type="text/x-handlebars-template">
          				{{#each this}}
               				<div id="lelement{{FilmId}}" data-toggle="tooltip" data-placement="top" title="" data-original-title="<p>CAST:{{Cast}} </p><p>DIRECTOR:{{Director}} </p><p>PRODUCER: {{Producer}}</p>" style="float:left;margin:25px;" class="flex-video widescreen videoContainter" >
          					<h4> {{FilmName}}</h4>
       						<img src="http://img.youtube.com/vi/{{url}}/hqdefault.jpg" style="height:200px; width:200px" class="clearfix" >
       						<div><a data-toggle="modal" data-id={{url}} data-ratingId={{Rating}} title="Add this item" class="open-viewer" href="#viewFilmClipDialog">View Film</a></div>
       						<p class="star" id="{{FilmId}}"></p>
       						</div>   
						{{/each}}
     					</script>
				</div>

			</div>

		</div>

		<!-- ENd popular-->

		<!-- Start: PRODUCT LIST -->
		<div class="container">
			<div class="page-header">
				<h2>About us</h2>
			</div>
			<div class="row-fluid">
				<ul class="thumbnails">
					<li class="span4">
						<div class="thumbnail">
							<img src="img/placeholder-360x200.jpg" alt="product name">
							<div class="caption">
								<h3>Who are we?</h3>
								<p>who are we?</p>
							</div>
							<div class="widget-footer">
								<p>
									<a href="product.html" class="btn btn-primary">Read more</a>
								</p>
							</div>
						</div>
					</li>
					<li class="span4">
						<div class="thumbnail">
							<img src="img/placeholder-360x200.jpg" alt="product name">
							<div class="caption">
								<h3>What do we do?</h3>
								<p>What do we do?</p>
							</div>
							<div class="widget-footer">
								<p>
									<a href="product.html" class="btn btn-primary">Read more</a>
								</p>
							</div>
						</div>
					</li>
					<li class="span4"><iframe
							src="//www.facebook.com/plugins/likebox.php?href=https%3A%2F%2Fwww.facebook.com%2Fpages%2FFour-Screens-Film-Festival%2F627616933962800&amp;width=295&amp;height=320&amp;colorscheme=light&amp;show_faces=true&amp;header=true&amp;stream=false&amp;show_border=true"
							scrolling="no" frameborder="0"
							style="border: none; overflow: hidden; width: 295px; height: 320px;"
							allowTransparency="true"></iframe> <br> <br>
						<div align="left">
							<a href="https://twitter.com/fest_four"
								class="twitter-follow-button" data-show-count="false"
								data-size="large">Follow @fest_four</a>
							<script>
								!function(d, s, id) {
									var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/
											.test(d.location) ? 'http'
											: 'https';
									if (!d.getElementById(id)) {
										js = d.createElement(s);
										js.id = id;
										js.src = p
												+ '://platform.twitter.com/widgets.js';
										fjs.parentNode.insertBefore(js, fjs);
									}
								}(document, 'script', 'twitter-wjs');
							</script>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- End: PRODUCT LIST -->


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

						</ul>
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
	<!-- End: FOOTER -->

	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script src="lib/jquery.raty.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/boot-business.js"></script>
	<script type="text/javascript" src="js/handlebars.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
</body>
</html>


