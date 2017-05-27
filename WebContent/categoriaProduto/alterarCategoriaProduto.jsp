<!DOCTYPE html>
<%@page import="com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator"%>
<%@page import="br.com.rocketmotos.servlet.ServletCategoriaProduto"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alteração de Categoria Produto</title>

<script type="text/javascript">

function processarAlteracao(){
	document.getElementById("<%=ServletCategoriaProduto.NM_EVENTO%>").value = "<%=ServletCategoriaProduto.NM_EVENTO_PROCESSAR_ALTERACAO%>";
}
</script>
</head>
<%
	String codigoCategoriaProduto = (String) request.getAttribute(ServletCategoriaProduto.NM_PARAMETRO_CodigoCategoriaProduto);
	String nomeCategoria = (String) request.getAttribute(ServletCategoriaProduto.NM_PARAMETRO_NomeCategoriaProduto);
	String descricao = (String) request.getAttribute(ServletCategoriaProduto.NM_PARAMETRO_Descricao);
%>


<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Alterar Categoria Produto</h3>
		<form class="form-horizontal" action="ServletCategoriaProduto" method="post">
		<input type="hidden" id="<%=ServletCategoriaProduto.NM_EVENTO%>" name="<%=ServletCategoriaProduto.NM_EVENTO%>" value="">
		
			<fieldset>
				<div style="background-color: #4ED4E8"></div>
				<div class="form-group">
					<label class="col-md-4 control-label">Código</label>
					<div class="col-md-3">
						<input id="cdCategoriaProduto" name="cdCategoriaProduto" type="text" value="<%=codigoCategoriaProduto%>" class="form-control input-md" required="" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Nome</label>
					<div class="col-md-3">
						<input id="nmCategoriaProduto" name="nmCategoriaProduto" value="<%=nomeCategoria%>" placeholder="digite o nome da categoria" class="form-control input-md" required="" >
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