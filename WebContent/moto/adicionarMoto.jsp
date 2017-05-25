<!DOCTYPE html>
<%@page import="br.com.rocketmotos.servlet.ServletMoto"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inclusão de Moto</title>

</head>

<script type="text/javascript">

function processarInclusao(){
	document.getElementById("<%=ServletMoto.NM_EVENTO%>").value = "<%=ServletMoto.NM_EVENTO_PROCESSAR_INCLUSAO%>";
}
</script>

<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Adicionar Moto</h3>
		<form class="form-horizontal" action="ServletMoto" method="post">
		<input type="hidden" id="<%=ServletMoto.NM_EVENTO%>" name="<%=ServletMoto.NM_EVENTO%>" value="">
			<fieldset>
				<div style="background-color: #4ED4E8"></div>
				<div class="form-group">
					<label class="col-md-4 control-label">Placa</label>
					<div class="col-md-3">
						<input id="placaMoto" name="placaMoto" type="text" placeholder="digite a placa da moto" class="form-control input-md" required="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Numero do Documento</label>
					<div class="col-md-3">
						<input id="nuDocumentoCliente" name="nuDocumentoCliente" placeholder="digite o documento do cliente" class="form-control input-md" required="">
					</div>
				</div>				
				<div class="form-group">
					<label class="col-md-4 control-label">Ano de Fabricação</label>
					<div class="col-md-3">
						<input id="anoFabricacao" name="anoFabricacao" type="text" placeholder="digite o ano de fabricação" class="form-control input-md" required="" maxlength="4">
					</div>
				</div>				
				<div class="form-group">
					<label class="col-md-4 control-label">Cor</label>
					<div class="col-md-3">
						<input id="cor" name="cor" type="text" placeholder="digite a cor da moto" class="form-control input-md" required="" maxlength="15">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Modelo Moto</label>
					<div class="col-md-3">
						<input id="cdModeloMoto" name="cdModeloMoto" type="text" placeholder="digite o codigo do modelo" class="form-control input-md" required="" maxlength="2">
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