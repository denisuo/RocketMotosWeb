<!DOCTYPE html>
<%@page import="br.com.rocketmotos.servlet.ServletServico"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inclusão de Moto</title>

</head>

<script type="text/javascript">

function processarInclusao(){
	document.getElementById("<%=ServletServico.NM_EVENTO%>").value = "<%=ServletServico.NM_EVENTO_PROCESSAR_INCLUSAO%>";
}
</script>

<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Adicionar Moto</h3>
		<form class="form-horizontal" action="ServletServico" method="post">
		<input type="hidden" id="<%=ServletServico.NM_EVENTO%>" name="<%=ServletServico.NM_EVENTO%>" value="">
			<fieldset>
				<div class="form-group">
					<label class="col-md-4 control-label">Nome</label>
					<div class="col-md-3">
						<input id="nmServico" name="nmServico" placeholder="digite o nome do serviço" class="form-control input-md" required="">
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">Valor</label>
					<div class="col-md-3">
						<input id="valor" name="valor" type="text" placeholder="digite o valor" class="form-control input-md" required="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Descrição</label>
					<div class="col-md-3">
						<textarea id="descricao" name="descricao" type="text" placeholder="digite a descrição" required="" class="form-control input-md" maxlength="200"></textarea>
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