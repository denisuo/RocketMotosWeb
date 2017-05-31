<!DOCTYPE html>
<%@page import="com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator"%>
<%@page import="br.com.rocketmotos.servlet.ServletVenda"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alteração de Venda</title>

<script type="text/javascript">

function processarAlteracao(){
	document.getElementById("<%=ServletVenda.NM_EVENTO%>").value = "<%=ServletVenda.NM_EVENTO_PROCESSAR_ALTERACAO%>";
}
</script>
</head>
<%
	String cdVenda = (String) request.getAttribute(ServletVenda.NM_PARAMETRO_CodigoVenda);
	String nuDocumentoCliente = (String) request.getAttribute(ServletVenda.NM_PARAMETRO_NuDocumentoCliente);
	String dataVenda = (String) request.getAttribute(ServletVenda.NM_PARAMETRO_DataVenda);
	String valorVenda = (String) request.getAttribute(ServletVenda.NM_PARAMETRO_ValorVenda);
	String tipoPagamento = (String) request.getAttribute(ServletVenda.NM_PARAMETRO_TipoPagamento);
	String desconto = (String) request.getAttribute(ServletVenda.NM_PARAMETRO_Desconto);
%>


<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Alterar Venda</h3>
		<form class="form-horizontal" action="ServletVenda" method="post">
		<input type="hidden" id="<%=ServletVenda.NM_EVENTO%>" name="<%=ServletVenda.NM_EVENTO%>" value="">
		
			<fieldset>
				<div style="background-color: #4ED4E8"></div>
				<div class="form-group">
					<label class="col-md-4 control-label">Código</label>
					<div class="col-md-3">
						<input id="cdVenda" name="cdVenda" type="text" value="<%=cdVenda%>" class="form-control input-md" required="" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Numero Documento Cliente</label>
					<div class="col-md-3">
						<input id="nuDocumentoCliente" name="nuDocumentoCliente" value="<%=nuDocumentoCliente%>" class="form-control input-md" required="" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Data</label>
					<div class="col-md-3">
						<input id="dataVenda" name="dataVenda" type="date" value="<%=dataVenda%>" class="form-control input-md" required="" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Valor</label>
					<div class="col-md-3">
						<input id="valorVenda" name="valorVenda" type="text" value="<%=valorVenda%>" class="form-control input-md" required="" readonly="readonly">
					</div>
				</div>			
				<div class="form-group">
					<label class="col-md-4 control-label">Tipo Pagamento</label>
					<div class="col-md-3">
						<input id="tipoPagamento" name="tipoPagamento" type="text" value="<%=tipoPagamento%>" class="form-control input-md" required="" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Desconto</label>
					<div class="col-md-3">
						<input id="desconto" name="desconto" type="text" value="<%=desconto%>" class="form-control input-md" required="">
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