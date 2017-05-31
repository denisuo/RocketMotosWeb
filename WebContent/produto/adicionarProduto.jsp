<!DOCTYPE html>
<%@page import="br.com.rocketmotos.servlet.ServletProduto"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inclus�o de Produto</title>

</head>

<script type="text/javascript">

function processarInclusao(){
	document.getElementById("<%=ServletProduto.NM_EVENTO%>").value = "<%=ServletProduto.NM_EVENTO_PROCESSAR_INCLUSAO%>";
}
</script>

<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Adicionar Produto</h3>
		<form class="form-horizontal" action="ServletProduto" method="post">
		<input type="hidden" id="<%=ServletProduto.NM_EVENTO%>" name="<%=ServletProduto.NM_EVENTO%>" value="">
			<fieldset>
				<div class="form-group">
					<label class="col-md-4 control-label">C�digo</label>
					<div class="col-md-3">
						<input id="cdProduto" name="cdProduto" placeholder="digite o c�digo do produto..." class="form-control input-md" required="">
					</div>
				</div>			
				<div class="form-group">
					<label class="col-md-4 control-label">Nome</label>
					<div class="col-md-3">
						<input id="nmProduto" name="nmProduto" placeholder="digite o nome do produto..." class="form-control input-md" required="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Categoria</label>
					<div class="col-md-3">
						<input id="cdCategoriaProduto" name="cdCategoriaProduto" placeholder="digite o nome c�digo da categoria do produto..." class="form-control input-md" required="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Validade</label>
					<div class="col-md-3">
						<input id="validade" name="validade" type="date" class="form-control input-md" required="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Valor</label>
					<div class="col-md-3">
						<input id="valorProduto" name="valorProduto" placeholder="digite o valor" class="form-control input-md" required="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Quantidade Estoque</label>
					<div class="col-md-3">
						<input id="qtdEstoque" name="qtdEstoque" type="number" class="form-control input-md" required="">
					</div>
				</div>				
				<div class="form-group">
					<label class="col-md-4 control-label">Descri��o</label>
					<div class="col-md-3">
						<textarea id="descricao" name="descricao" type="text" placeholder="digite a descri��o" required="" class="form-control input-md" maxlength="200"></textarea>
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