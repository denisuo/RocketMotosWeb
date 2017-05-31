<!DOCTYPE html>
<%@page import="br.com.rocketmotos.entidade.EntidadeProduto"%>
<%@page import="br.com.rocketmotos.servlet.ServletProduto"%>
<%@page import="java.util.ArrayList"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Consulta de Produto</title>

</head>
<script type="text/javascript">

function consultar(){
	document.getElementById("<%=ServletProduto.NM_EVENTO%>").value = "<%=ServletProduto.NM_EVENTO_CONSULTAR_TODOS%>";
}

function excluir(){
	document.getElementById("<%=ServletProduto.NM_EVENTO%>").value = "<%=ServletProduto.NM_EVENTO_EXCLUIR%>";
}

function exibirAlteracao(){
	document.getElementById("<%=ServletProduto.NM_EVENTO%>").value = "<%=ServletProduto.NM_EVENTO_EXIBIR_ALTERACAO%>";
}

function exibirInclusao(){
	document.getElementById("<%=ServletProduto.NM_EVENTO%>").value = "<%=ServletProduto.NM_EVENTO_EXIBIR_INCLUSAO%>";
}

</script>
<%
	ArrayList<EntidadeProduto> alProduto;
	
	alProduto = (ArrayList<EntidadeProduto>) request.getAttribute(ServletProduto.NM_PARAMETRO_ArrayProduto);
	
	if(alProduto == null){
		alProduto = new ArrayList<EntidadeProduto>();
	}
%>
<body>
<jsp:include page="/template.jsp"/>

<div id="main" class="container-fluid">
<h3 class="page-header">Consultar Produto</h3>
<form class="form-horizontal" action="ServletProduto" method="post">

<div id="barraPesquisa" class="row">
    <div class="col-md-3">
    </div>
 
    <div class="col-md-6">
        <div class="input-group h2">
            <input id="nmServico" name="nmServico" class="form-control" type="text" placeholder="Pesquisar por nome do produto">
            <span class="input-group-btn">
                <button class="btn btn-primary" type="submit" onclick="consultar();">
                    <span class="glyphicon glyphicon-search"></span>
                </button>
            </span>
        </div>
    </div>
    <div class="col-md-3">
		<button class="btn btn-primary pull-center h1" type="submit" onclick="exibirInclusao();">Incluir</button>
    </div>
</div>

<input type="hidden" id="<%=ServletProduto.NM_EVENTO%>" name="<%=ServletProduto.NM_EVENTO%>" value="">
	<div class="container">
	  
	  <%if(!alProduto.isEmpty()){ %>
	  <table class="table table-striped">
		<thead>
			<tr>
				<th>Código</th>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Valor</th>
			</tr>
		</thead>
		<tbody>
	    <%
			for(EntidadeProduto eProduto : alProduto){
		%>
			<tr>
				<td><input type="radio" id="cdProduto" name="cdProduto" value="<%=eProduto.getCodigoProduto()%>">&nbsp<%=eProduto.getCodigoProduto()%></td>
				<td><%=eProduto.getNome()%></td>
				<td><%=eProduto.getDescricao()%></td>
				<td><%=eProduto.getValor()%></td>
			</tr>
	        
		<%} %>
	    </tbody>
	  </table>
	  <%} %>
	 
	   <%if(!alProduto.isEmpty()){ %>
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