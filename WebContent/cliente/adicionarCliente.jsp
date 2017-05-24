<!DOCTYPE html>
<%@page import="br.com.rocketmotos.servlet.ServletCliente"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inclusão de Cliente</title>

</head>

<script type="text/javascript">

function processarInclusao(){
	document.getElementById("<%=ServletCliente.NM_EVENTO%>").value = "<%=ServletCliente.NM_EVENTO_PROCESSAR_INCLUSAO%>";
}
</script>

<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Adicionar Cliente</h3>
		<form class="form-horizontal" action="ServletCliente" method="post">
		<input type="hidden" id="<%=ServletCliente.NM_EVENTO%>" name="<%=ServletCliente.NM_EVENTO%>" value="">
			<fieldset>
				<div style="background-color: #4ED4E8"></div>
				<div class="form-group">
					<label class="col-md-4 control-label">Numero do Documento</label>
					<div class="col-md-3">
						<input id="nuDocumentoCliente" name="nuDocumentoCliente" type="text" placeholder="digite o documento de identificação do cliente" class="form-control input-md" required="" maxlength="20">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Nome</label>
					<div class="col-md-3">
						<input id="nmCliente" name="nmCliente" type="text" placeholder="nome do cliente" class="form-control input-md" required="" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Endereço</label>
					<div class="col-md-3">
						<input id="endereco" name="endereco" type="text" placeholder="digite o endereço" class="form-control input-md" required="" maxlength="200">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Telefone</label>
					<div class="col-md-3">
						<input id="telefone" name="telefone" type="text" placeholder="digite um numero de telefone para contato" required="" class="form-control input-md" maxlength="11">
					</div>
				</div>	
				<div class="form-group">
				  <label class="col-md-4 control-label">Tipo Cliente</label>
				  <div class="col-md-4"> 
				    <label class="radio-inline">
				      <input type="radio" name="tpCliente" id="tpCliente" value="PF" checked="checked">
				      Pessoa Física
				    </label> 
				    <label class="radio-inline">
				      <input type="radio" name="tpCliente" id="tpCliente" value="PJ">
				      Pessoa Jurídica
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