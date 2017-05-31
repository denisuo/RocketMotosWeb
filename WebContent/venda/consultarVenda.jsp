<!DOCTYPE html>
<%@page import="br.com.rocketmotos.entidade.EntidadeVenda"%>
<%@page import="br.com.rocketmotos.servlet.ServletVenda"%>
<%@page import="java.util.ArrayList"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Consulta de Venda</title>

</head>
<script type="text/javascript">

function consultar(){
	document.getElementById("<%=ServletVenda.NM_EVENTO%>").value = "<%=ServletVenda.NM_EVENTO_CONSULTAR_TODOS%>";
}

function excluir(){
	document.getElementById("<%=ServletVenda.NM_EVENTO%>").value = "<%=ServletVenda.NM_EVENTO_EXCLUIR%>";
}

function exibirAlteracao(){
	document.getElementById("<%=ServletVenda.NM_EVENTO%>").value = "<%=ServletVenda.NM_EVENTO_EXIBIR_ALTERACAO%>";
}

function exibirInclusao(){
	document.getElementById("<%=ServletVenda.NM_EVENTO%>").value = "<%=ServletVenda.NM_EVENTO_EXIBIR_INCLUSAO%>";
}

</script>
<%
	ArrayList<EntidadeVenda> alVenda;
	
	alVenda = (ArrayList<EntidadeVenda>) request.getAttribute(ServletVenda.NM_PARAMETRO_ArrayVenda);
	
	if(alVenda == null){
		alVenda = new ArrayList<EntidadeVenda>();
	}
%>
<body>
<jsp:include page="/template.jsp"/>

<div id="main" class="container-fluid">
<h3 class="page-header">Consultar Venda</h3>
<form class="form-horizontal" action="ServletVenda" method="post">

<div id="barraPesquisa" class="row">
    <div class="col-md-3">
    </div>
 
    <div class="col-md-6">
        <div class="input-group h2">
            <input id="cdVendaa" name="cdVendaa" class="form-control" type="text" placeholder="Pesquisar por codigo...">
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

<input type="hidden" id="<%=ServletVenda.NM_EVENTO%>" name="<%=ServletVenda.NM_EVENTO%>" value="">
	<div class="container">
	  
	  <%if(!alVenda.isEmpty()){ %>
	  <table class="table table-striped">
		<thead>
			<tr>
				<th>Código</th>
				<th>Documento Cliente</th>
				<th>Data</th>
				<th>Valor</th>
				<th>Tipo Pagamento</th>
			</tr>
		</thead>
		<tbody>
	    <%
			for(EntidadeVenda eVenda : alVenda){
		%>
			<tr>
				<td><input type="radio" id="cdVenda" name="cdVenda" value="<%=eVenda.getCodigo()%>">&nbsp<%=eVenda.getCodigo()%></td>
				<td><%=eVenda.getDocumentoCliente()%></td>
				<td><%=eVenda.getData()%></td>
				<td><%=eVenda.getValor()%></td>
				<td><%=eVenda.getTipoPagamento()%></td>
			</tr>
	        
		<%} %>
	    </tbody>
	  </table>
	  <%} %>
	 
	   <%if(!alVenda.isEmpty()){ %>
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