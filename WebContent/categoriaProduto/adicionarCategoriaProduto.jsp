<!DOCTYPE html>
<%@page import="br.com.rocketmotos.servlet.ServletCategoriaProduto"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inclusão de Categoria Produto</title>

</head>

<script type="text/javascript">

function processarInclusao(){
	document.getElementById("<%=ServletCategoriaProduto.NM_EVENTO%>").value = "<%=ServletCategoriaProduto.NM_EVENTO_PROCESSAR_INCLUSAO%>";
}
</script>

<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Adicionar Categoria Produto</h3>
		<form class="form-horizontal" action="ServletCategoriaProduto" method="post">
		<input type="hidden" id="<%=ServletCategoriaProduto.NM_EVENTO%>" name="<%=ServletCategoriaProduto.NM_EVENTO%>" value="">
			<fieldset>
				<div class="form-group">
					<label class="col-md-4 control-label">Nome</label>
					<div class="col-md-3">
						<input id="nmCategoriaProduto" name="nmCategoriaProduto" placeholder="digite o nome da categoria" class="form-control input-md" required="">
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