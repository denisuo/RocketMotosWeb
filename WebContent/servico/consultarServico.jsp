<!DOCTYPE html>
<%@page import="br.com.rocketmotos.entidade.EntidadeServico"%>
<%@page import="br.com.rocketmotos.servlet.ServletServico"%>
<%@page import="br.com.rocketmotos.entidade.EntidadeMoto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.rocketmotos.servlet.ServletServico"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Consulta de Serviço</title>

</head>
<script type="text/javascript">

function consultar(){
	document.getElementById("<%=ServletServico.NM_EVENTO%>").value = "<%=ServletServico.NM_EVENTO_CONSULTAR_TODOS%>";
}

function excluir(){
	document.getElementById("<%=ServletServico.NM_EVENTO%>").value = "<%=ServletServico.NM_EVENTO_EXCLUIR%>";
}

function exibirAlteracao(){
	document.getElementById("<%=ServletServico.NM_EVENTO%>").value = "<%=ServletServico.NM_EVENTO_EXIBIR_ALTERACAO%>";
}

function exibirInclusao(){
	document.getElementById("<%=ServletServico.NM_EVENTO%>").value = "<%=ServletServico.NM_EVENTO_EXIBIR_INCLUSAO%>";
}

</script>
<%
	ArrayList<EntidadeServico> alServico;
	
	alServico = (ArrayList<EntidadeServico>) request.getAttribute(ServletServico.NM_PARAMETRO_ArrayServico);
	
	if(alServico == null){
		alServico = new ArrayList<EntidadeServico>();
	}
%>
<body>
<jsp:include page="/template.jsp"/>

<div id="main" class="container-fluid">
<h3 class="page-header">Consultar Serviço</h3>
<form class="form-horizontal" action="ServletServico" method="post">

<div id="barraPesquisa" class="row">
    <div class="col-md-3">
    </div>
 
    <div class="col-md-6">
        <div class="input-group h2">
            <input id="nmServico" name="nmServico" class="form-control" type="text" placeholder="Pesquisar por nome do serviço">
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

<input type="hidden" id="<%=ServletServico.NM_EVENTO%>" name="<%=ServletServico.NM_EVENTO%>" value="">
	<div class="container">
	  
	  <%if(!alServico.isEmpty()){ %>
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
			for(EntidadeServico eServico : alServico){
		%>
			<tr>
				<td><input type="radio" id="cdServico" name="cdServico" value="<%=eServico.getCodigoServico()%>">&nbsp<%=eServico.getCodigoServico()%></td>
				<td><%=eServico.getNome()%></td>
				<td><%=eServico.getDescricao()%></td>
				<td><%=eServico.getValor()%></td>
			</tr>
	        
		<%} %>
	    </tbody>
	  </table>
	  <%} %>
	 
	   <%if(!alServico.isEmpty()){ %>
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