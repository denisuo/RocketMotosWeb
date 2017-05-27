<!DOCTYPE html>
<%@page import="com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator"%>
<%@page import="br.com.rocketmotos.servlet.ServletOrdemServico"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alteração de Ordem de Serviço</title>

<script type="text/javascript">

function processarAlteracao(){
	document.getElementById("<%=ServletOrdemServico.NM_EVENTO%>").value = "<%=ServletOrdemServico.NM_EVENTO_PROCESSAR_ALTERACAO%>";
}
</script>
</head>
<%
	String cdOrdemServico = (String) request.getAttribute(ServletOrdemServico.NM_PARAMETRO_CodigoOrdemServico);
	String placaMoto = (String) request.getAttribute(ServletOrdemServico.NM_PARAMETRO_PlacaMoto);
	String data = (String) request.getAttribute(ServletOrdemServico.NM_PARAMETRO_Data);
	String indicadorOrcamento = (String) request.getAttribute(ServletOrdemServico.NM_PARAMETRO_IndicadorOrcamento);
%>


<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Alterar Ordem de Serviço</h3>
		<form class="form-horizontal" action="ServletOrdemServico" method="post">
		<input type="hidden" id="<%=ServletOrdemServico.NM_EVENTO%>" name="<%=ServletOrdemServico.NM_EVENTO%>" value="">
		
			<fieldset>
				<div style="background-color: #4ED4E8"></div>
				<div class="form-group">
					<label class="col-md-4 control-label">Código</label>
					<div class="col-md-3">
						<input id="cdOrdemServico" name="cdOrdemServico" type="text" value="<%=cdOrdemServico%>" class="form-control input-md" required="" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Placa Moto</label>
					<div class="col-md-3">
						<input id="placaMoto" name="placaMoto" value="<%=placaMoto%>" class="form-control input-md" required="" readonly="readonly">
					</div>
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