<!DOCTYPE html>
<%@page import="br.com.rocketmotos.entidade.EntidadeServico"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="br.com.rocketmotos.util.Constantes"%>
<%@page import="br.com.rocketmotos.entidade.EntidadeItemOrdemServico"%>
<%@page import="br.com.rocketmotos.servlet.ServletItemOrdemServico"%>
<%@page import="java.util.ArrayList"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Consulta de Itens por Ordem de Serviço</title>

<script src="${pageContext.request.contextPath}\bootstrap-3.3.7-dist\js\jquery.min.js"></script>

</head>
<script type="text/javascript">

$(document).ready(function(){
	$("#btnAlterar").hide();
	//$("#btnAlterar").show();
	//$("#btnConsultar").click(function(){
	//	alert("REVISAR TODA FUNCIONALIDADE ITEM ORDEM SERVICO");	
	//});
});
		
function consultar(){
	//if(document.getElementById("cdOrdemServico").value == ""){
	//	alert("PREENCHER CAMPO OBRIGATÓRIO!");
	//}
	document.getElementById("<%=ServletItemOrdemServico.NM_EVENTO%>").value = "<%=ServletItemOrdemServico.NM_EVENTO_CONSULTAR_TODOS%>";
}

function excluir(){
	document.getElementById("<%=ServletItemOrdemServico.NM_EVENTO%>").value = "<%=ServletItemOrdemServico.NM_EVENTO_EXCLUIR%>";
}

function exibirAlteracao(){
	document.getElementById("<%=ServletItemOrdemServico.NM_EVENTO%>").value = "<%=ServletItemOrdemServico.NM_EVENTO_EXIBIR_ALTERACAO%>";
}

function exibirInclusao(){
	document.getElementById("<%=ServletItemOrdemServico.NM_EVENTO%>").value = "<%=ServletItemOrdemServico.NM_EVENTO_EXIBIR_INCLUSAO%>";
}

</script>
<%
	ResultSet rsResposta = null;

	String cdOrdemServico = (String) request.getAttribute(ServletItemOrdemServico.NM_PARAMETRO_CodigoOrdemServico);
	rsResposta =  (ResultSet) request.getAttribute(ServletItemOrdemServico.NM_PARAMETRO_ArrayItemOrdemServico);
		
%>
<body>
<jsp:include page="/template.jsp"/>

<div id="main" class="container-fluid">
<h3 class="page-header">Consultar Itens</h3>
<form class="form-horizontal" action="ServletItemOrdemServico" method="post">

<div id="barraPesquisa" class="row">
    <div class="col-md-3">
    </div>
 
    <div class="col-md-6">
        <div class="input-group h2">
            <input id="cdOrdemServico" name="cdOrdemServico" class="form-control" type="text" value="<%=cdOrdemServico%>" readonly="readonly">
            <span class="input-group-btn">
                <button class="btn btn-primary" id="btnConsultar" name="btnConsultar" type="submit" onclick="consultar();">
                    <span class="glyphicon glyphicon-search"></span>
                </button>
            </span>
        </div>
    </div>
    <div class="col-md-3">
		<button class="btn btn-primary pull-center h1" type="submit" onclick="exibirInclusao();">Incluir</button>
    </div>
</div>

<input type="hidden" id="<%=ServletItemOrdemServico.NM_EVENTO%>" name="<%=ServletItemOrdemServico.NM_EVENTO%>" value="">
	<div class="container">
	  
	  <%if(rsResposta != null){ %>
	  <table class="table table-striped">
		<thead>
			<tr>
				<th>Número Ordem Serviço</th>
				<th>Produto</th>
				<th>Serviço</th>
				<th>Quantidade Produto Utilizado</th>
			</tr>
		</thead>
		<tbody>
	    <%
			while(rsResposta.next()){
				String chaveItemOrdPedido = "";
				chaveItemOrdPedido = rsResposta.getString(EntidadeItemOrdemServico.NM_COL_CodigoOrdemServico) + Constantes.CAMPO_SERPARADOR_CHAVE_PRIMARIA
						+ rsResposta.getString(EntidadeItemOrdemServico.NM_COL_CodigoProduto)  + Constantes.CAMPO_SERPARADOR_CHAVE_PRIMARIA + 
						rsResposta.getString(EntidadeItemOrdemServico.NM_COL_CodigoServico); 
		%>
			<tr>
				<td><input type="radio" id="chavePrimaria" name="chavePrimaria" value="<%=chaveItemOrdPedido%>">&nbsp<%=rsResposta.getString(EntidadeItemOrdemServico.NM_COL_CodigoOrdemServico)%></td>
				<td><%=rsResposta.getString(EntidadeItemOrdemServico.NM_COL_CodigoProduto)%></td>
				<td><%=rsResposta.getString(EntidadeServico.NM_COL_Nome)%></td>
				<td><%=rsResposta.getString(EntidadeItemOrdemServico.NM_COL_QtdProdutoUtilizado)%></td>
			</tr>
	        
		<%} %>
	    </tbody>
	  </table>
	  <%} %>
	  <div class="container" align="center">
	  
	   <%if(rsResposta != null){ %>
	  	<td>
			<button id="btnAlterar" name="btnAlterar" class="btn btn-warning btn-xs" onclick="exibirAlteracao();">Alterar</button>
			<button id="btnExcluir" name="btnExcluir" class="btn btn-danger btn-xs" onclick="excluir();">Excluir</button>
			<button id="btnCancelar" name="btnCancelar" class="btn btn-warning btn-xs" onClick="history.go(-1)">Voltar</button>
		</td>
	  <%} else {%>
	  	<td>
	  		<button id="btnCancelar" name="btnCancelar" class="btn btn-warning btn-xs" onClick="history.go(-1)">Voltar</button>
	  	</td>
	  <%} %>
	  </div>
	  
	</div>
</form>
</div>

</body>
</html>