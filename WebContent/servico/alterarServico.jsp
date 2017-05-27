<!DOCTYPE html>
<%@page import="com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator"%>
<%@page import="br.com.rocketmotos.servlet.ServletServico"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alteração de Modelo de Moto</title>

<script type="text/javascript">

function processarAlteracao(){
	document.getElementById("<%=ServletServico.NM_EVENTO%>").value = "<%=ServletServico.NM_EVENTO_PROCESSAR_ALTERACAO%>";
}
</script>
</head>
<%
	String cdServico = (String) request.getAttribute(ServletServico.NM_PARAMETRO_CodigoServico);
	String nomeServico = (String) request.getAttribute(ServletServico.NM_PARAMETRO_NomeServico);
	String descricao = (String) request.getAttribute(ServletServico.NM_PARAMETRO_Descricao);
	String valorServico = (String) request.getAttribute(ServletServico.NM_PARAMETRO_ValorSerico);
%>


<body>
<jsp:include page="/template.jsp"/>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Alterar Modelo Moto</h3>
		<form class="form-horizontal" action="ServletServico" method="post">
		<input type="hidden" id="<%=ServletServico.NM_EVENTO%>" name="<%=ServletServico.NM_EVENTO%>" value="">
		
			<fieldset>
				<div style="background-color: #4ED4E8"></div>
				<div class="form-group">
					<label class="col-md-4 control-label">Código</label>
					<div class="col-md-3">
						<input id="cdServico" name="cdServico" type="text" value="<%=cdServico%>" class="form-control input-md" required="" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Nome</label>
					<div class="col-md-3">
						<input id="nmServico" name="nmServico" value="<%=nomeServico%>" placeholder="digite o nome do serviço" class="form-control input-md" required="" >
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">Valor</label>
					<div class="col-md-3">
						<input id="valor" name="valor" type="text" value="<%=valorServico%>" placeholder="digite o valor" class="form-control input-md" required="">
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