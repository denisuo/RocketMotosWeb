<!DOCTYPE html>
<%@page import="br.com.rocketmotos.servlet.ServletOrdemServico"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inclusão de Ordem de Serviço</title>

</head>

<script type="text/javascript">

function processarInclusao(){
	document.getElementById("<%=ServletOrdemServico.NM_EVENTO%>").value = "<%=ServletOrdemServico.NM_EVENTO_PROCESSAR_INCLUSAO%>";
}
</script>

<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Adicionar Ordem Serviço</h3>
		<form class="form-horizontal" action="ServletOrdemServico" method="post">
		<input type="hidden" id="<%=ServletOrdemServico.NM_EVENTO%>" name="<%=ServletOrdemServico.NM_EVENTO%>" value="">
			<fieldset>
				<div class="form-group">
					<label class="col-md-4 control-label">Codigo</label>
					<div class="col-md-3">
						<input id="cdOrdemServico" name="cdOrdemServico" placeholder="digite o código da ordem de serviço" class="form-control input-md" required="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Placa Moto</label>
					<div class="col-md-3">
						<input id="placaMoto" name="placaMoto" type="text" placeholder="digite a placa da moto" class="form-control input-md" required="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<button id="btnIncluir" name="btnIncluir" class="btn btn-success" onclick="processarInclusao();">Incluir</button>
						<button id="btnCancelar" name="btnCancelar" class="btn btn-default" onClick="history.go(-1)">Cancelar</button>
					</div>
				</div>
			</fieldset>
		</form>
		
	</div>
</body>
</html>