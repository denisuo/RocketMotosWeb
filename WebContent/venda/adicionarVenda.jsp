<!DOCTYPE html>
<%@page import="br.com.rocketmotos.servlet.ServletVenda"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inclusão de Venda</title>

</head>

<script type="text/javascript">

function processarInclusao(){
	document.getElementById("<%=ServletVenda.NM_EVENTO%>").value = "<%=ServletVenda.NM_EVENTO_PROCESSAR_INCLUSAO%>";
}
</script>

<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Adicionar Venda</h3>
		<form class="form-horizontal" action="ServletVenda" method="post">
		<input type="hidden" id="<%=ServletVenda.NM_EVENTO%>" name="<%=ServletVenda.NM_EVENTO%>" value="">
			<fieldset>
				<div class="form-group">
					<label class="col-md-4 control-label">Código</label>
					<div class="col-md-3">
						<input id="cdVenda" name="cdVenda" placeholder="digite o código do venda..." class="form-control input-md" required="">
					</div>
				</div>			
				<div class="form-group">
					<label class="col-md-4 control-label">Documento Cliente</label>
					<div class="col-md-3">
						<input id="nuDocumentoCliente" name="nuDocumentoCliente" placeholder="digite o do documento do cliente..." class="form-control input-md" required="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Valor</label>
					<div class="col-md-3">
						<input id="valorVenda" name="valorVenda" placeholder="digite o valor" class="form-control input-md" required="">
					</div>
				</div>
				<div class="form-group">
				  <label class="col-md-4 control-label">Tipo Pagamento</label>
				  <div class="col-md-4"> 
				    <label class="radio-inline">
				      <input type="radio" name="tipoPagamento" id="tipoPagamento" value="D" checked="checked">
				      DINHEIRO
				    </label> 
				    <label class="radio-inline">
				      <input type="radio" name="tipoPagamento" id="tipoPagamento" value="C">
				      CARTÃO
				    </label> 
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