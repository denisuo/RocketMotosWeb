<!DOCTYPE html>
<%@page import="br.com.rocketmotos.servlet.ServletItemOrdemServico"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inclusão de Moto</title>

</head>

<script type="text/javascript">

function processarInclusao(){
	document.getElementById("<%=ServletItemOrdemServico.NM_EVENTO%>").value = "<%=ServletItemOrdemServico.NM_EVENTO_PROCESSAR_INCLUSAO%>";
}
</script>

<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Adicionar Moto</h3>
		<form class="form-horizontal" action="ServletItemOrdemServico" method="post">
		<input type="hidden" id="<%=ServletItemOrdemServico.NM_EVENTO%>" name="<%=ServletItemOrdemServico.NM_EVENTO%>" value="">
			<fieldset>
				<div class="form-group">
					<label class="col-md-4 control-label">Código Ordem Serviço</label>
					<div class="col-md-3">
						<input id="cdOrdemServico" name="cdOrdemServico" placeholder="digite o código da ordem de serviço" class="form-control input-md" required="">
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">Código do Produto</label>
					<div class="col-md-3">
						<input id="cdProduto" name="cdProduto" type="text" placeholder="digite código do produto" class="form-control input-md" required="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Código do Serviço</label>
					<div class="col-md-3">
						<input id="cdServico" name="cdServico" type="text" placeholder="digite código do serviço" class="form-control input-md" required="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Qtd Produto Utilizado</label>
					<div class="col-md-3">
						<input id="qtdProdutoUtilizado" name="qtdProdutoUtilizado" type="text" placeholder="digite a quantidade do produto utilizado" class="form-control input-md" required="">
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