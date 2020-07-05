<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="https://fonts.googleapis.com/css?family=Poppins:400,500,600,700" rel="stylesheet">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DarkSouls Speedrun</title>


</head>
<body>

<div class="menu"> <span></span> </div>
<nav id="nav">
        <ul class="main">
        <li><a target="_self" href="">Home</a></li>
        <li><a target="_blank" href="SupportView.jsp">Support</a></li>
        <li><a target="_self" href="RegisterView.jsp">Register</a></li>
        <li><a target="_self" href="LoginView.jsp">Login</a></li>
        </ul>
</nav>
<div class="overlay"></div>

<script>
$('.menu, .overlay').click(function () {
    $('.menu').toggleClass('clicked');

    $('#nav').toggleClass('show');

});
</script>
<div class="container">
<div class="wrapper wrapper--w780">
		<div class="card card-3 p-3 my-3 bg-dark text-white">
			<div class="card-heading2"></div>
			<div class="card-body">
				<h2 class="title">Adicionar Speed Run</h2>
				<form action="addSpeedRun" method="post">
					<div class="form-group row">
						<legend class="col-form-label col-sm-2 pt-0 text-white">Modo de Jogo</legend>
						<div class="form-check form-check-inline">
							<input type="radio" class="form-check-input" id="cheats" name="modoJogo" value="cheats" required="required">
							<label for="cheats" class="form-check-label text-white">Cheats</label><br>	
						</div>
						<div class="form-check form-check-inline">
							<input type="radio" class="form-check-input" id="noCheats" name="modoJogo" value="noCheats">
							<label for="noCheats" class="form-check-label text-white">No Cheats</label><br><br>	
						</div>
					</div>
					<div class="form-group row">
						<legend class="col-form-label col-sm-2 pt-0 text-white">Plataforma</legend>
						<div class="form-check form-check-inline">
							<input type="radio" class="form-check-input" id="PC" name="plataforma" value="PC" required="required">
							<label for="PC" class="form-check-label text-white">PC</label>
						</div><br>
						<div class="form-check form-check-inline">
							<input type="radio" class="form-check-input" id="Playstation" name="plataforma" value="Playstation">
							<label for="Playstation" class="form-check-label text-white">Playstation</label><br>
						</div><br>
						<div class="form-check form-check-inline">
							<input type="radio" class="form-check-input" id="Switch" name="plataforma" value="Switch">
							<label for="Switch" class="form-check-label text-white">Switch</label><br>
						</div><br>
						<div class="form-check form-check-inline">
							<input type="radio" class="form-check-input" id="Xbox" name="plataforma" value="Xbox">
							<label for="Xbox" class="form-check-label text-white">Xbox</label><br><br>
						</div><br>
					</div>
					<div class="form-group row">
						<label for="diaRealizado" class="col-sm-2 col-form-label text-white">Dia realizado</label>
						<div class="col-sm-10">
							<input id="diaRealizado" class="form-control" type="date" required="required" name="dia" pattern=".*\S+.*" title="This field is required">
						</div>
					</div>
					<div class="form-group row">
						<label for="tempRealizado" class="col-sm-2 col-form-label text-white">Tempo Realizado</label>
						<div class="col-sm-10">
							<input id="tempRealizado" class="form-control" type="datetime" required="required" name="tempo" pattern=".*\S+.*" title="This field is required">
						</div>
					</div>
					<!-- <div class="container"> -->
						<div class="p-t-10">
							<button class="btn btn--pill btn--green" type="submit">Send SpeedRun</button>
						</div>
					<!-- </div> -->
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>