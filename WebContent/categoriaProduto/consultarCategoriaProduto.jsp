<!DOCTYPE html>
<%@page import="br.com.rocketmotos.entidade.EntidadeCategoriaProduto"%>
<%@page import="br.com.rocketmotos.servlet.ServletCategoriaProduto"%>
<%@page import="java.util.ArrayList"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Consulta de Categoria Produto</title>

</head>
<script type="text/javascript">

function consultar(){
	document.getElementById("<%=ServletCategoriaProduto.NM_EVENTO%>").value = "<%=ServletCategoriaProduto.NM_EVENTO_CONSULTAR_TODOS%>";
}

function excluir(){
	document.getElementById("<%=ServletCategoriaProduto.NM_EVENTO%>").value = "<%=ServletCategoriaProduto.NM_EVENTO_EXCLUIR%>";
}

function exibirAlteracao(){
	document.getElementById("<%=ServletCategoriaProduto.NM_EVENTO%>").value = "<%=ServletCategoriaProduto.NM_EVENTO_EXIBIR_ALTERACAO%>";
}

function exibirInclusao(){
	document.getElementById("<%=ServletCategoriaProduto.NM_EVENTO%>").value = "<%=ServletCategoriaProduto.NM_EVENTO_EXIBIR_INCLUSAO%>";
}

</script>
<%
	ArrayList<EntidadeCategoriaProduto> alCategoriaProduto;
	
	alCategoriaProduto = (ArrayList<EntidadeCategoriaProduto>) request.getAttribute(ServletCategoriaProduto.NM_PARAMETRO_ArrayCategoriaProduto);
	
	if(alCategoriaProduto == null){
		alCategoriaProduto = new ArrayList<EntidadeCategoriaProduto>();
	}
%>
<body>
<jsp:include page="/template.jsp"/>

<div id="main" class="container-fluid">
<h3 class="page-header">Consultar Categoria Produto</h3>
<form class="form-horizontal" action="ServletCategoriaProduto" method="post">

<div id="barraPesquisa" class="row">
    <div class="col-md-3">
    </div>
 
    <div class="col-md-6">
        <div class="input-group h2">
            <input id="nmCategoriaProduto" name="nmCategoriaProduto" class="form-control" type="text" placeholder="Pesquisar por nome da categoria">
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

<input type="hidden" id="<%=ServletCategoriaProduto.NM_EVENTO%>" name="<%=ServletCategoriaProduto.NM_EVENTO%>" value="">
	<div class="container">
	  
	  <%if(!alCategoriaProduto.isEmpty()){ %>
	  <table class="table table-striped">
		<thead>
			<tr>
				<th>Código</th>
				<th>Nome</th>
				<th>Descrição</th>
			</tr>
		</thead>
		<tbody>
	    <%
			for(EntidadeCategoriaProduto eCategoriaProduto : alCategoriaProduto){
		%>
			<tr>
				<td><input type="radio" id="cdCategoriaProduto" name="cdCategoriaProduto" value="<%=eCategoriaProduto.getCodigo()%>">&nbsp<%=eCategoriaProduto.getCodigo()%></td>
				<td><%=eCategoriaProduto.getNome()%></td>
				<td><%=eCategoriaProduto.getDescricao()%></td>
			</tr>
	        
		<%} %>
	    </tbody>
	  </table>
	  <%} %>
	 
	   <%if(!alCategoriaProduto.isEmpty()){ %>
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