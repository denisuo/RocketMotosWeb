<!DOCTYPE html>
<%@page import="br.com.rocketmotos.select.ComboSelect"%>
<%@page import="com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator"%>
<%@page import="br.com.rocketmotos.servlet.ServletProduto"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alteração de Produto</title>

<script type="text/javascript">

function processarAlteracao(){
	document.getElementById("<%=ServletProduto.NM_EVENTO%>").value = "<%=ServletProduto.NM_EVENTO_PROCESSAR_ALTERACAO%>";
}
</script>
</head>
<%
	String cdProduto = (String) request.getAttribute(ServletProduto.NM_PARAMETRO_CodigoProduto);
	String nomeProduto = (String) request.getAttribute(ServletProduto.NM_PARAMETRO_NomeProduto);
	String descricao = (String) request.getAttribute(ServletProduto.NM_PARAMETRO_Descricao);
	String validade = (String) request.getAttribute(ServletProduto.NM_PARAMETRO_Validade);
	String cdCategoriaProduto = (String) request.getAttribute(ServletProduto.NM_PARAMETRO_CodigoCategoriaProduto);
	String valorProduto = (String) request.getAttribute(ServletProduto.NM_PARAMETRO_ValorProduto);
	String qtdEstoque = (String) request.getAttribute(ServletProduto.NM_PARAMETRO_QtdEstoque);
%>


<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Alterar Produto</h3>
		<form class="form-horizontal" action="ServletProduto" method="post">
		<input type="hidden" id="<%=ServletProduto.NM_EVENTO%>" name="<%=ServletProduto.NM_EVENTO%>" value="">
		
			<fieldset>
				<div style="background-color: #4ED4E8"></div>
				<div class="form-group">
					<label class="col-md-4 control-label">Código</label>
					<div class="col-md-3">
						<input id="cdProduto" name="cdProduto" type="text" value="<%=cdProduto%>" class="form-control input-md" required="" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Nome</label>
					<div class="col-md-3">
						<input id="nmProduto" name="nmProduto" value="<%=nomeProduto%>" placeholder="digite o nome do produto..." class="form-control input-md" required="" >
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Validade</label>
					<div class="col-md-3">
						<input id="validade" name="validade" type="date" value="<%=validade%>" class="form-control input-md" required="">
					</div>
				</div>
				<div class="form-group">
				<label class="col-md-4 control-label" for="selectbasic">Categoria</label>
					<div class="col-md-3"><%=ComboSelect.getInstancia().getSelectHtmlCategoriaProduto(cdCategoriaProduto)%> </div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Valor</label>
					<div class="col-md-3">
						<input id="valorProduto" name="valorProduto" type="text" value="<%=valorProduto%>" placeholder="digite o valor do produto..." class="form-control input-md" required="">
					</div>
				</div>			
				<div class="form-group">
					<label class="col-md-4 control-label">Quantidade Estoque</label>
					<div class="col-md-3">
						<input id="qtdEstoque" name="qtdEstoque" type="number" value="<%=qtdEstoque%>" class="form-control input-md" required="">
					</div>
				</div>							
				<div class="form-group">
					<label class="col-md-4 control-label">Descrição</label>
					<div class="col-md-3">
						<textarea id="descricao" name="descricao" type="text" placeholder="digite a descrição" required="" class="form-control input-md" maxlength="200"><%=descricao%></textarea>
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