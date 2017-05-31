<!DOCTYPE html>
<%@page import="br.com.rocketmotos.select.ComboSelect"%>
<%@page import="br.com.rocketmotos.servlet.ServletMoto"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alteração de Modelo de Moto</title>

<script type="text/javascript">

function processarAlteracao(){
	document.getElementById("<%=ServletMoto.NM_EVENTO%>").value = "<%=ServletMoto.NM_EVENTO_PROCESSAR_ALTERACAO%>";
}
</script>
</head>
<%
	String placaMoto = (String) request.getAttribute(ServletMoto.NM_PARAMETRO_PlacaMoto);
	String anoFabricacao = (String) request.getAttribute(ServletMoto.NM_PARAMETRO_AnoFabricacao);
	String cor = (String) request.getAttribute(ServletMoto.NM_PARAMETRO_Cor);
	String nuDocumentoCliente = (String) request.getAttribute(ServletMoto.NM_PARAMETRO_NumeroDocumentoCliente);
	String codigoModelo = (String) request.getAttribute(ServletMoto.NM_PARAMETRO_CodigoModeloMoto);
%>


<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Alterar Modelo Moto</h3>
		<form class="form-horizontal" action="ServletMoto" method="post">
		<input type="hidden" id="<%=ServletMoto.NM_EVENTO%>" name="<%=ServletMoto.NM_EVENTO%>" value="">
		
			<fieldset>
				<div style="background-color: #4ED4E8"></div>
				<div class="form-group">
					<label class="col-md-4 control-label">Placa</label>
					<div class="col-md-3">
						<input id="placaMoto" name="placaMoto" type="text" value="<%=placaMoto%>" class="form-control input-md" required="" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Numero do Documento</label>
					<div class="col-md-3">
						<input id="nuDocumentoCliente" name="nuDocumentoCliente" value="<%=nuDocumentoCliente%>" class="form-control input-md" required="" readonly="readonly">
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">Ano de Fabricação</label>
					<div class="col-md-3">
						<input id="anoFabricacao" name="anoFabricacao" type="text" value="<%=anoFabricacao%>" placeholder="digite o ano de fabricação" class="form-control input-md" required="" maxlength="4">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Cor</label>
					<div class="col-md-3">
						<input id="cor" name="cor" type="text" value="<%=cor%>" placeholder="digite a cor da moto" required="" class="form-control input-md" maxlength="15">
					</div>
				</div>
				<div class="form-group">
				<label class="col-md-4 control-label" for="selectbasic">Modelo</label>
					<div class="col-md-3"><%=ComboSelect.getInstancia().getSelectHtmlModeloMoto(codigoModelo)%> </div>
				</div>						
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<button id="btnAlterar" name="btnAlterar" class="btn btn-success" onclick="processarAlteracao();">Alterar</button>
						<button id="btnCancelar" name="btnCancelar" class="btn btn-default" onClick="history.go(-1)">Cancelar</button>
						
					</div>
				</div>
		
			</fieldset>
		</form>
		
	</div>
</body>
</html>