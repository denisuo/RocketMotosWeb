<!DOCTYPE html>
<%@page import="br.com.rocketmotos.entidade.EntidadeCliente"%>
<%@page import="br.com.rocketmotos.entidade.EntidadeModeloMoto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.rocketmotos.servlet.ServletCliente"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Consulta de Cliente</title>

</head>
<script type="text/javascript">

function consultar(){
	document.getElementById("<%=ServletCliente.NM_EVENTO%>").value = "<%=ServletCliente.NM_EVENTO_CONSULTAR_TODOS%>";
}

function excluir(){
	document.getElementById("<%=ServletCliente.NM_EVENTO%>").value = "<%=ServletCliente.NM_EVENTO_EXCLUIR%>";
}

function exibirAlteracao(){
	document.getElementById("<%=ServletCliente.NM_EVENTO%>").value = "<%=ServletCliente.NM_EVENTO_EXIBIR_ALTERACAO%>";
}

function exibirInclusao(){
	document.getElementById("<%=ServletCliente.NM_EVENTO%>").value = "<%=ServletCliente.NM_EVENTO_EXIBIR_INCLUSAO%>";
}

</script>
<%
	ArrayList<EntidadeCliente> alCliente;
	alCliente = (ArrayList<EntidadeCliente>) request.getAttribute(ServletCliente.NM_PARAMETRO_ArrayCliente);
	
	if(alCliente == null){
		alCliente = new ArrayList<EntidadeCliente>();
	}
%>
<body>
<jsp:include page="/template.jsp"/>

<div id="main" class="container-fluid">
<h3 class="page-header">Consultar Cliente</h3>
<form class="form-horizontal" action="ServletCliente" method="post">

<div id="barraPesquisa" class="row">
    <div class="col-md-3">
    </div>
 
    <div class="col-md-6">
        <div class="input-group h2">
            <input id="nmCliente" name="nmCliente" class="form-control" type="text" placeholder="Pesquisar por nome">
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

<input type="hidden" id="<%=ServletCliente.NM_EVENTO%>" name="<%=ServletCliente.NM_EVENTO%>" value="">
	<div class="container">
	  
	  <%if(!alCliente.isEmpty()){ %>
	  <table class="table table-striped">
		<thead>
			<tr>
				<th>Documento</th>
				<th>Nome</th>
				<th>Endereço</th>
				<th>Telefone</th>
				<th>Tipo</th>
			</tr>
		</thead>
		<tbody>
	    <%
			for(EntidadeCliente eCliente : alCliente){
		%>
			<tr>
				<td><input type="radio" id="nuDocumentoCliente" name="nuDocumentoCliente" value="<%=eCliente.getDocumento()%>">&nbsp<%=eCliente.getDocumento()%></td>
				<td><%=eCliente.getNome()%></td>
				<td><%=eCliente.getEndereco()%></td>
				<td><%=eCliente.getTelefone()%></td>
				<td><%=eCliente.getTipoCliente()%></td>
			</tr>
	        
		<%} %>
	    </tbody>
	  </table>
	  <%} %>
	 
	   <%if(!alCliente.isEmpty()){ %>
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