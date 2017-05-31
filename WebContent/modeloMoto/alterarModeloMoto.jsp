<!DOCTYPE html>
<%@page import="br.com.rocketmotos.select.ComboSelect"%>
<%@page import="br.com.rocketmotos.servlet.ServletModeloMoto"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alteração de Modelo de Moto</title>

<script type="text/javascript">

function processarAlteracao(){
	document.getElementById("<%=ServletModeloMoto.NM_EVENTO%>").value = "<%=ServletModeloMoto.NM_EVENTO_PROCESSAR_ALTERACAO%>";
}
</script>
</head>
<%
	String cdModeloMoto = (String) request.getAttribute(ServletModeloMoto.NM_PARAMETRO_CodigoModeloMoto);
	String nmModeloMoto = (String) request.getAttribute(ServletModeloMoto.NM_PARAMETRO_NomeModeloMoto);
	String cilindrada = (String) request.getAttribute(ServletModeloMoto.NM_PARAMETRO_Cilindrada);
	String cdMarcaMoto = (String) request.getAttribute(ServletModeloMoto.NM_PARAMETRO_CodigoMarcaMoto);
%>


<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Alterar Modelo Moto</h3>
		<form class="form-horizontal" action="ServletModeloMoto" method="post">
		<input type="hidden" id="<%=ServletModeloMoto.NM_EVENTO%>" name="<%=ServletModeloMoto.NM_EVENTO%>" value="">
		
			<fieldset>
				<div style="background-color: #4ED4E8"></div>
				<div class="form-group">
					<label class="col-md-4 control-label">Código do Modelo</label>
					<div class="col-md-3">
						<input id="cdModeloMoto" name="cdModeloMoto" value="<%=cdModeloMoto%>" class="form-control input-md" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Nome do Modelo</label>
					<div class="col-md-3">
						<input id="nmModeloMoto" name="nmModeloMoto" value="<%=nmModeloMoto%>" type="text" placeholder="nome do modelo" class="form-control input-md" required="" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Cilindrada</label>
					<div class="col-md-3">
						<input id="cilindrada" name="cilindrada" value="<%=cilindrada%>" type="number" placeholder="cilindrada ex: 150, 200, 300.." class="form-control input-md" required="" maxlength="4">
					</div>
				</div>
				<div class="form-group">
				<label class="col-md-4 control-label" for="selectbasic">Marca</label>
					<div class="col-md-3"><%=ComboSelect.getInstancia().getSelectHtmlMarcaMoto(cdMarcaMoto)%> </div>
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