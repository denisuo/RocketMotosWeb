<!DOCTYPE html>
<%@page import="br.com.rocketmotos.servlet.ServletMarcaMoto"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alteração de Marca de Moto</title>

<script type="text/javascript">

function processarAlteracao(){
	document.getElementById("<%=ServletMarcaMoto.NM_EVENTO%>").value = "<%=ServletMarcaMoto.NM_EVENTO_PROCESSAR_ALTERACAO%>";
}
</script>
</head>
<%
	String cdMarcaMoto = (String) request.getAttribute(ServletMarcaMoto.NM_PARAMETRO_CodigoMarcaMoto);
	String nmMarcaMoto = (String) request.getAttribute(ServletMarcaMoto.NM_PARAMETRO_NomeMarcaMoto);
%>


<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Alterar Marca Moto</h3>
		<form class="form-horizontal" action="ServletMarcaMoto" method="post">
		<input type="hidden" id="<%=ServletMarcaMoto.NM_EVENTO%>" name="<%=ServletMarcaMoto.NM_EVENTO%>" value="">
		
			<fieldset>
				<div style="background-color: #4ED4E8"></div>
				<div class="form-group">
					<label class="col-md-4 control-label">Código</label>
					<div class="col-md-3">
						<input id="cdMarcaMoto" name="cdMarcaMoto" value="<%=cdMarcaMoto%>" class="form-control input-md" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Nome</label>
					<div class="col-md-3">
						<input id="nmMarcaMoto" name="nmMarcaMoto" value="<%=nmMarcaMoto%>" type="text" placeholder="Nome do fabricante" class="form-control input-md" required="" maxlength="50">
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