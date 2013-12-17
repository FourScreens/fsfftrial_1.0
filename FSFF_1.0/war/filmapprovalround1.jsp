<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Bootbusiness | Short description about company">
<meta name="author" content="Your name">
<title>Four Screens Film Festival</title>
<!-- Bootstrap -->

<!-- Le styles -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/DT_bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/admin.css">
<link rel="stylesheet" type="text/css" href="css/admin.css">
</head>
<body>
	<%@ page import="com.fsff.ui.entity.AdminSession"%>
	<%
		if (request.getSession().getAttribute("ADMINJSESSIONID") == null) {
			response.sendRedirect("/adminlogin.jsp");
		}
	%>
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
				<iframe src="" style="zoom: 0.60" frameborder="0" height="400"
					width="500"></iframe>
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
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container">
					<button type="button" class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="brand" href="adminindex.jsp">FSFF Admin</a>
					<div class="nav-collapse collapse">
						<ul class="nav">
							<li class="active"><a href="adminindex.jsp">Home</a></li>
							<li><a href="createfestival.jsp">Festival</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Film <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="filmapproval.jsp">Submitted Films</a></li>
									<li class="divider"></li>
									<li class="active"><a href="filmapprovalround1.jsp">Round
											1</a></li>
									<li><a href="filmapprovalround2.jsp">Round 2</a></li>
									<li><a href="filmapprovalround3.jsp">Round 3</a></li>
								</ul></li>
							<li><a href="editorpicks.jsp">Editor's Picks</a></li>
						</ul>
						<%
							if (request.getSession().getAttribute("ADMINJSESSIONID") != null) {
								AdminSession sessionObject = (AdminSession) request
										.getSession().getAttribute("ADMINJSESSIONID");
								String login = sessionObject.getFirstName();
						%>

						<ul class="nav pull-right">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Welcome <%=login%> <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a class="active" href="AdminLogOut" name="logout">Logout
									</a></li>
								</ul></li>
						</ul>
						<%
							}
						%>

					</div>
					<!--/.nav-collapse -->
				</div>
			</div>
		</div>
		<!-- End: Navigation wrapper -->
	</header>
	<!-- End: HEADER -->
	<!-- Start: MAIN CONTENT -->

	<div class="alert fade in" id="display-error" style="display: none;">
		<button type="button" class="close">x</button>
		<div class="container" id="display-message">Yo</div>
	</div>

	<div class="container" id="tab4">
		<div class="viewfilms">
			<script id="viewFilms" type="text/x-handlebars-template">
				<form name="input" class="FilmList" action="approvefilms" method="post">
    					<table id="film-table" class="table table-striped table-hover table-condensed  bordered-table zebra-striped">
							<thead>
								<th>#</th>
								<th>Film Name</th>
								<th>3 min Clip </th>
								<th>5 min Clip </th>
								<th>10 min Clip </th>
								<th>Rating</th>
								<th>Votes</th>
								<th>Cast</th>
								<th>Director</th>
								<th>Producer</th>
								<th>Status</th>
							</thead>
    						{{#each this}}
								<tr class="success">
								<td><input type="checkbox" name="selector" value="{{FilmId}}"></td>
								<td>{{FilmName}}</td>
								<td><a data-toggle="modal" data-id={{url1}} title="Add this item" class="open-viewer" href="#viewFilmClipDialog">View Clip</a></td>
								<td><a data-toggle="modal" data-id={{url2}} title="Add this item" class="open-viewer" href="#viewFilmClipDialog">View Clip</a></td>
								<td><a data-toggle="modal" data-id={{url3}} title="Add this item" class="open-viewer" href="#viewFilmClipDialog">View Clip</a></td>
								<td><p class="star" id="{{FilmId}}"></p></td>
          						<td><p class="star" id="num{{FilmId}}" style= "font-style:italic">{{numberOfVotes}} </td>
								<td> {{Cast}}</td>
								<td>{{Director}}</td>
								<td>{{Producer}}</td>
								<td>{{status}}</td>
								</tr>
							{{/each}}
    					</table>
  						<div>
        					<button type="submit " class="btn btn-success" name="approval" value="Approved">Approve</button> 
        					<button type="submit " class="btn btn-danger" name="approval"  value="Rejected" >Reject</button>
    					</div>	
				
 				</form>
     		</script>
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
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="lib/jquery.raty.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/handlebars.js"></script>
	<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
	<script
		src="http://datatables.net/media/blog/bootstrap_2/DT_bootstrap.js"></script>
	<script type="text/javascript" src="js/FilmApprovalRoundOne.js"></script>

</body>
</html>
