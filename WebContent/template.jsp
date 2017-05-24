<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cadastro de Cliente</title>

<link href="${pageContext.request.contextPath}\bootstrap-3.3.7-dist\css\bootstrap.min.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}\bootstrap-3.3.7-dist\js\jquery.min.js"></script>
<script src="${pageContext.request.contextPath}\bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand">Rocket Motos Web</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-left">
					<li><a href="#">Início</a></li>
					<li><a href="#">Opções</a></li>
					<li><a href="#">Perfil</a></li>
					<li><a href="#">Ajuda</a></li>
					<li><a href="${pageContext.request.contextPath}\ServletCliente?evento=">Cliente</a></li>
					<li><a href="${pageContext.request.contextPath}\ServletMarcaMoto?evento=">Marca Moto</a></li>
					<li><a href="${pageContext.request.contextPath}\ServletModeloMoto?evento=">Modelo Moto</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<br><br><br>
</body>
</html>