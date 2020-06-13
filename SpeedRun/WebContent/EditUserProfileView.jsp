<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<head>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link href="css/profile.css" rel="stylesheet" media="all">
<link rel="stylesheet" type="text/css" href="style.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link
	href="https://fonts.googleapis.com/css2?family=EB+Garamond:ital,wght@1,400;1,500;1,600;1,700;1,800&display=swap"
	rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"
	rel="stylesheet">
</head>

<body>
<div class="menu"> <span></span> </div>
<nav id="nav">
		<ul class="main">
		<li><a target="_self" href="">Home</a></li>
		<li><a target="_self" href="RankingView.jsp">Ranking</a></li>
		<li><a target="_blank" href="SupportView.jsp">Support</a></li>
		<li><a target="_self" href="RegisterView.jsp">Register</a></li>
		<li><a target="_self" href="LoginView.jsp">Login</a></li>
		</ul>
</nav>
<div class="overlay"></div>

<div class="container">
	<div class="row">
		<div class="col-md-offset-2 col-md-8 col-lg-offset-3 col-lg-6">
			<div class="well profile">
				<div class="col-sm-12">
					<div class="col-xs-12 col-sm-8">
						<input type="text" placeholder="username" maxlength="8" size="8">
						<p>
							<strong style="color:rgb(255,255,255)">About: </strong>
							<em style="color:rgb(255,255,255)">Brazilian master</em>
						</p>
						<p>
							<strong style="color:rgb(255,255,255)">Speedruns: </strong> <span class="tags " style="color:rgb(255,255,255)">All Bosses</span>
							<span class="tags" style="color:rgb(255,255,255)">Any%</span> <span class="tags" style="color:rgb(255,255,255)">Any%</span>
						</p>
					</div>
					<div class="col-xs-12 col-sm-4 text-center">
						<figure>
							<img
								src="http://www.localcrimenews.com/wp-content/uploads/2013/07/default-user-icon-profile.png"
								alt="" class="img-circle img-responsive">
							<figcaption class="ratings">
								<p style="color:rgb(255,255,255)">
									Ratings <a href="#"> <span class="fa fa-star"></span>
									</a> <a href="#"> <span class="fa fa-star"></span>
									</a> <a href="#"> <span class="fa fa-star"></span>
									</a> <a href="#"> <span class="fa fa-star"></span>
									</a> <a href="#"> <span class="fa fa-star-o"></span>
									</a>
								</p>
							</figcaption>
						</figure>
					</div>
				</div>
				<div class="col-xs-12 divider text-center">
					<div class="col-xs-12 col-sm-4 emphasis">
						<h2>
							<strong style="color:rgb(255,255,255)"> @insta</strong>
						</h2>
						<p>
							<small style="color:rgb(255,255,255)">Instagram</small>
						</p>
						<button type="button" class="btn btn-primary" style="color:rgb(255,255,255)">
							<span class="fa fa-user"></span> View Profile
						</button>
					</div>
					<div class="col-xs-12 col-sm-4 emphasis">
						<h2>
							<strong style="color:rgb(255,255,255)">@twit</strong>
						</h2>
						<p>
							<small style="color:rgb(255,255,255)">Twitter</small>
						</p>
						<button class="btn btn-info btn-block" style="color:rgb(255,255,255)">
							<span class="fa fa-user"></span> Follow
						</button>
					</div>
					<div class="col-xs-12 col-sm-4 emphasis">
						<h2>
							<strong style="color:rgb(255,255,255)">faceb</strong>
						</h2>
						<p>
							<small style="color:rgb(255,255,255)">Facebook</small>
						</p>
						<button type="button" class="btn btn-primary" style="color:rgb(255,255,255)">
							<span class="fa fa-user"></span> View Profile
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



<script>
$('.menu, .overlay').click(function () {
	$('.menu').toggleClass('clicked');
	
	$('#nav').toggleClass('show');
	
});
</script>


</body>