<!DOCTYPE html>
<%@page import="br.com.rocketmotos.util.Constantes"%>
<%@page import="br.com.rocketmotos.entidade.EntidadeItemOrdemServico"%>
<%@page import="br.com.rocketmotos.servlet.ServletItemOrdemServico"%>
<%@page import="java.util.ArrayList"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Consulta de Item por Ordem de Serviço</title>

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
	ArrayList<EntidadeItemOrdemServico> alItemOrdemServico;
	
	alItemOrdemServico = (ArrayList<EntidadeItemOrdemServico>) request.getAttribute(ServletItemOrdemServico.NM_PARAMETRO_ArrayItemOrdemServico);
	
	if(alItemOrdemServico == null){
		alItemOrdemServico = new ArrayList<EntidadeItemOrdemServico>();
	}
%>
<body>
<jsp:include page="/template.jsp"/>

<div id="main" class="container-fluid">
<h3 class="page-header">Consultar Item por Ordem de Serviço</h3>
<form class="form-horizontal" action="ServletItemOrdemServico" method="post">

<div id="barraPesquisa" class="row">
    <div class="col-md-3">
    </div>
 
    <div class="col-md-6">
        <div class="input-group h2">
            <input id="cdOrdemServico" name="cdOrdemServico" class="form-control" type="text" placeholder="Pesquisar por codigo de ordem de serviço">
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
	  
	  <%if(!alItemOrdemServico.isEmpty()){ %>
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
			for(EntidadeItemOrdemServico eItemOrdemServico : alItemOrdemServico){
				String chaveItemOrdPedido = "";
				chaveItemOrdPedido = eItemOrdemServico.getCodigoOrdemServico() + Constantes.CAMPO_SERPARADOR_CHAVE_PRIMARIA
						+ eItemOrdemServico.getCodigoProduto() + Constantes.CAMPO_SERPARADOR_CHAVE_PRIMARIA + eItemOrdemServico.getCodigoServico(); 
		%>
			<tr>
				<td><input type="radio" id="chavePrimaria" name="chavePrimaria" value="<%=chaveItemOrdPedido%>">&nbsp<%=eItemOrdemServico.getCodigoOrdemServico()%></td>
				<td><%=eItemOrdemServico.getCodigoProduto()%></td>
				<td><%=eItemOrdemServico.getCodigoServico()%></td>
				<td><%=eItemOrdemServico.getQtdProdutoUtilizado()%></td>
			</tr>
	        
		<%} %>
	    </tbody>
	  </table>
	  <%} %>
	 
	   <%if(!alItemOrdemServico.isEmpty()){ %>
	  <div class="container" align="center">
	  	<td>
			<button id="btnAlterar" name="btnAlterar" class="btn btn-warning btn-xs" onclick="exibirAlteracao();">Alterar</button>
			<button id="btnExcluir" name="btnExcluir" class="btn btn-danger btn-xs" onclick="excluir();">Excluir</button>
		</td>
	  <%} %>
	  </div>
	  
	</div>
</form>
</div>

</body>
</html>