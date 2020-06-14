<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd%22%3E
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
        <li><a target="_self" href="RankingView.jsp">Ranking</a></li>
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

<div class="wrapper wrapper--w780">
		<div class="card card-3">
			<div class="card-heading3"></div>
			<div class="card-body">
				<h2 class="title">Add SpeedRun</h2>
				<form action="addSpeedRun" method="post">
			Modo de jogo<br>
			<input type="radio" id="cheats" name="modoJogo" value="cheats" required="required">
			<label for="cheats">Cheats</label><br>
			<input type="radio" id="noCheats" name="modoJogo" value="noCheats">
			<label for="noCheats">No Cheats</label><br><br>
			
			Plataforma<br>
			<input type="radio" id="PC" name="plataforma" value="PC" required="required">
			<label for="PC">PC</label><br>
			<input type="radio" id="Playstation" name="plataforma" value="Playstation">
			<label for="Playstation">Playstation</label><br>
			<input type="radio" id="Switch" name="plataforma" value="Switch">
			<label for="Switch">Switch</label><br>
			<input type="radio" id="Xbox" name="plataforma" value="Xbox">
			<label for="Xbox">Xbox</label><br><br>
			
			Dia realizado<br>
			<input type="date" name="dia" required="required"><br><br>
			
			Tempo realizado<br>
			<input type="datetime" name="tempo" required="required"><br><br>
			
			<input type="submit" name="enviar" value="Enviar" id="btnEnviar">
		</form>
			</div>
		</div>
	</div>

</body>
</html>