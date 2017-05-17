<!DOCTYPE html>
<%@page import="br.com.rocketmotos.servlet.ServletMarcaMoto"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inclusão de Marca de Moto</title>

<link href="${pageContext.request.contextPath}\bootstrap-3.3.7-dist\css\bootstrap.min.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}\bootstrap-3.3.7-dist\js\jquery.min.js"></script>
<script src="${pageContext.request.contextPath}\bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>

</head>

<script type="text/javascript">
function incluir(){
	document.getElementById("<%=ServletMarcaMoto.NM_EVENTO%>").value = "<%=ServletMarcaMoto.NM_EVENTO_INCLUIR%>";
}
</script>

<input type="hidden" id="<%=ServletMarcaMoto.NM_EVENTO%>" name="<%=ServletMarcaMoto.NM_EVENTO%>" value="">

<body>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Adicionar Marca Moto</h3>
		<form class="form-horizontal" action="ServletMarcaMoto" method="post">
			<fieldset>
				<div style="background-color: #4ED4E8"></div>
				<div class="form-group">
					<label class="col-md-4 control-label">Nome</label>
					<div class="col-md-3">
						<input id="nmMarcaMoto" name="nmMarcaMoto" type="text" placeholder="Nome do fabricante" class="form-control input-md" required="" maxlength="50">
		
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<button id="btnIncluir" name="btnIncluir" class="btn btn-success" onclick="incluir();">Incluir</button>
						<a id="btnCancelar" name="btnCancelar" class="btn btn-default" href="../paginaInicial.jsp">Cancelar</a>
					</div>
				</div>
		
			</fieldset>
		</form>
		
	</div>
</body>
</html>