<!DOCTYPE html>
<%@page import="br.com.rocketmotos.servlet.ServletMoto"%>
<%@page import="br.com.rocketmotos.entidade.EntidadeMoto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.rocketmotos.servlet.ServletMoto"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Consulta de Moto</title>

</head>
<script type="text/javascript">

function consultar(){
	document.getElementById("<%=ServletMoto.NM_EVENTO%>").value = "<%=ServletMoto.NM_EVENTO_CONSULTAR_TODOS%>";
}

function excluir(){
	document.getElementById("<%=ServletMoto.NM_EVENTO%>").value = "<%=ServletMoto.NM_EVENTO_EXCLUIR%>";
}

function exibirAlteracao(){
	document.getElementById("<%=ServletMoto.NM_EVENTO%>").value = "<%=ServletMoto.NM_EVENTO_EXIBIR_ALTERACAO%>";
}

function exibirInclusao(){
	document.getElementById("<%=ServletMoto.NM_EVENTO%>").value = "<%=ServletMoto.NM_EVENTO_EXIBIR_INCLUSAO%>";
}

</script>
<%
	ArrayList<EntidadeMoto> alMoto;
	alMoto = (ArrayList<EntidadeMoto>) request.getAttribute(ServletMoto.NM_PARAMETRO_ArrayMoto);
	
	if(alMoto == null){
		alMoto = new ArrayList<EntidadeMoto>();
	}
%>
<body>
<jsp:include page="/template.jsp"/>

<div id="main" class="container-fluid">
<h3 class="page-header">Consultar Moto</h3>
<form class="form-horizontal" action="ServletMoto" method="post">

<div id="barraPesquisa" class="row">
    <div class="col-md-3">
    </div>
 
    <div class="col-md-6">
        <div class="input-group h2">
            <input id="placaMotoo" name="placaMotoo" class="form-control" type="text" placeholder="Pesquisar por placa">
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

<input type="hidden" id="<%=ServletMoto.NM_EVENTO%>" name="<%=ServletMoto.NM_EVENTO%>" value="">
	<div class="container">
	  
	  <%if(!alMoto.isEmpty()){ %>
	  <table class="table table-striped">
		<thead>
			<tr>
				<th>Placa</th>
				<th>Ano</th>
				<th>Cor</th>
				<th>Documento Cliente</th>
				<th>Modelo Moto</th>
			</tr>
		</thead>
		<tbody>
	    <%
			for(EntidadeMoto eMoto : alMoto){
		%>
			<tr>
				<td><input type="radio" id="placaMoto" name="placaMoto" value="<%=eMoto.getPlaca()%>">&nbsp<%=eMoto.getPlaca()%></td>
				<td><%=eMoto.getAno()%></td>
				<td><%=eMoto.getCor()%></td>
				<td><%=eMoto.getNumeroDocumentoCliente()%></td>
				<td><%=eMoto.getNomeModeloMoto()%></td>
			</tr>
	        
		<%} %>
	    </tbody>
	  </table>
	  <%} %>
	 
	   <%if(!alMoto.isEmpty()){ %>
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