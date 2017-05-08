<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cadastro de Cliente</title>

<link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap-3.3.7-dist/css/style.css" rel="stylesheet">

<script src="bootstrap-3.3.7-dist/js/jquery.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
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
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Início</a></li>
					<li><a href="#">Opções</a></li>
					<li><a href="#">Perfil</a></li>
					<li><a href="#">Ajuda</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<br><br><br>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Adicionar Cliente</h3>
		<form class="form-horizontal" action="ServletMarcaMoto" method="post">
			<fieldset>
				<!-- <legend>Cadastro de Clientes</legend> -->
				<div style="background-color: #4ED4E8"></div>
		
				<div class="form-group">
					<label class="col-md-4 control-label" for="nome">Nome</label>
					<div class="col-md-3">
						<input id="nome" name="nome" type="text" placeholder="Nome do cliente" class="form-control input-md" required="" maxlength="50">
		
					</div>
				</div>
		
				<div class="form-group">
					<label class="col-md-4 control-label" for="cpf">Documento</label>
					<div class="col-md-2">
						<input id="documento" name="documento" type="text" placeholder="Numero do documento" class="form-control input-md" required="" maxlength="15">
		
					</div>
				</div>
		
				<div class="form-group">
					<label class="col-md-4 control-label" for="sexo">Tipo de Cliente</label>
					<div class="col-md-2">
						<select id="tipoPessoa" name="tipoPessoa" class="form-control">
							<option value="PF" selected="selected">Pessoa Física</option>
							<option value="PJ">Pessoa Jurídica</option>
						</select>
					</div>
				</div>
		
				<div class="form-group">
					<label class="col-md-4 control-label" for="endereco">Endereco</label>
					<div class="col-md-3">
						<textarea rows="3" cols="4" id="endereco" name="endereco" type="text" placeholder="Preencher endereço completo" class="form-control input-md" maxlength="100" required=""></textarea>
					</div>
				</div>
		
				<div class="form-group">
					<label class="col-md-4 control-label" for="telefone">Telefone</label>
					<div class="col-md-2">
						<input id="telefone" name="telefone" type="text" placeholder="(99)999999999" class="form-control input-md" maxlength="11" required="">
		
					</div>
				</div>
		
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<button id="btnIncluir" name="btnIncluir" class="btn btn-success">Incluir</button>
						<a id="btnCancelar" name="btnCancelar" class="btn btn-default" href="template.jsp">Cancelar</a>
					</div>
				</div>
		
			</fieldset>
		</form>
		
	</div>
</body>
</html>