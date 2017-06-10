<!DOCTYPE html>
<%@page import="br.com.rocketmotos.select.ComboSelect"%>
<%@page import="br.com.rocketmotos.servlet.ServletItemOrdemServico"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inclus�o de Item</title>

</head>

<script type="text/javascript">

function processarInclusao(){
	document.getElementById("<%=ServletItemOrdemServico.NM_EVENTO%>").value = "<%=ServletItemOrdemServico.NM_EVENTO_PROCESSAR_INCLUSAO%>";
}
</script>

<%
	//recupera do request para manter a barra preenchida
	String cdOrdemServico = (String) request.getAttribute(ServletItemOrdemServico.NM_PARAMETRO_CodigoOrdemServico);
%>

<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Adicionar Item</h3>
		<form class="form-horizontal" action="ServletItemOrdemServico" method="post">
		<input type="hidden" id="<%=ServletItemOrdemServico.NM_EVENTO%>" name="<%=ServletItemOrdemServico.NM_EVENTO%>" value="">
			<fieldset>
				<div class="form-group">
					<label class="col-md-4 control-label">C�digo Ordem Servi�o</label>
					<div class="col-md-3">
						<input id="cdOrdemServico" name="cdOrdemServico" value="<%=cdOrdemServico%>" class="form-control input-md" required="" readonly="readonly">
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">C�digo do Produto</label>
					<div class="col-md-3">
						<input id="cdProduto" name="cdProduto" type="text" placeholder="digite c�digo do produto" class="form-control input-md" required="">
					</div>
				</div>
				<div class="form-group">
				<label class="col-md-4 control-label">Servi�o</label>
					<div class="col-md-3"><%=ComboSelect.getInstancia().getSelectHtmlServico("")%> </div>
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