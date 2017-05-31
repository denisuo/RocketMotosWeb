<!DOCTYPE html>
<%@page import="br.com.rocketmotos.select.ComboSelect"%>
<%@page import="br.com.rocketmotos.servlet.ServletModeloMoto"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inclusão de Modelo de Moto</title>

</head>

<script type="text/javascript">

function processarInclusao(){
	document.getElementById("<%=ServletModeloMoto.NM_EVENTO%>").value = "<%=ServletModeloMoto.NM_EVENTO_PROCESSAR_INCLUSAO%>";
}
</script>

<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Adicionar Modelo Moto</h3>
		<form class="form-horizontal" action="ServletModeloMoto" method="post">
		<input type="hidden" id="<%=ServletModeloMoto.NM_EVENTO%>" name="<%=ServletModeloMoto.NM_EVENTO%>" value="">
			<fieldset>
				<div style="background-color: #4ED4E8"></div>
				<div class="form-group">
					<label class="col-md-4 control-label">Nome do Modelo</label>
					<div class="col-md-3">
						<input id="nmModeloMoto" name="nmModeloMoto" type="text" placeholder="nome do modelo" class="form-control input-md" required="" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Cilindrada</label>
					<div class="col-md-3">
						<input id="cilindrada" name="cilindrada" type="number" placeholder="cilindrada ex: 150, 200, 300.." class="form-control input-md" required="" maxlength="4">
					</div>
				</div>
				<div class="form-group">
				<label class="col-md-4 control-label" for="selectbasic">Marca</label>
					<div class="col-md-3"><%=ComboSelect.getInstancia().getSelectHtmlMarcaMoto("")%> </div>
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