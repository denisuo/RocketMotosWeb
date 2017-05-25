<!DOCTYPE html>
<%@page import="br.com.rocketmotos.entidade.EntidadeModeloMoto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.rocketmotos.servlet.ServletModeloMoto"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Consulta de Modelo de Moto</title>


</head>
<script type="text/javascript">

function consultar(){
	document.getElementById("<%=ServletModeloMoto.NM_EVENTO%>").value = "<%=ServletModeloMoto.NM_EVENTO_CONSULTAR_TODOS%>";
}

function excluir(){
	document.getElementById("<%=ServletModeloMoto.NM_EVENTO%>").value = "<%=ServletModeloMoto.NM_EVENTO_EXCLUIR%>";
}

function exibirAlteracao(){
	document.getElementById("<%=ServletModeloMoto.NM_EVENTO%>").value = "<%=ServletModeloMoto.NM_EVENTO_EXIBIR_ALTERACAO%>";
}

function exibirInclusao(){
	document.getElementById("<%=ServletModeloMoto.NM_EVENTO%>").value = "<%=ServletModeloMoto.NM_EVENTO_EXIBIR_INCLUSAO%>";
}

</script>
<%
	ArrayList<EntidadeModeloMoto> alModeloMoto;
	alModeloMoto = (ArrayList<EntidadeModeloMoto>) request.getAttribute(ServletModeloMoto.NM_PARAMETRO_ArrayModeloMoto);
	
	if(alModeloMoto == null){
		alModeloMoto = new ArrayList<EntidadeModeloMoto>();
	}
%>
<body>
<jsp:include page="/template.jsp"/>

<div id="main" class="container-fluid">
<h3 class="page-header">Consultar Modelo Moto</h3>
<form class="form-horizontal" action="ServletModeloMoto" method="post">

<div id="barraPesquisa" class="row">
    <div class="col-md-3">
    </div>
 
    <div class="col-md-6">
        <div class="input-group h2">
            <input id="nmModeloMoto" name="nmModeloMoto" class="form-control" type="text" placeholder="Pesquisar por nome do modelo">
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

<input type="hidden" id="<%=ServletModeloMoto.NM_EVENTO%>" name="<%=ServletModeloMoto.NM_EVENTO%>" value="">
	<div class="container">
	  
	  <%if(!alModeloMoto.isEmpty()){ %>
	  <table class="table table-striped">
		<thead>
			<tr>
				<th>Código</th>
				<th>Nome</th>
				<th>Cilindrada</th>
				<th>Marca</th>
			</tr>
		</thead>
		<tbody>
	    <%
			for(EntidadeModeloMoto eModeloMoto : alModeloMoto){
		%>
			<tr>
				<td><input type="radio" id="cdModeloMoto" name="cdModeloMoto" value="<%=eModeloMoto.getCodigoModeloMoto()%>">&nbsp<%=eModeloMoto.getCodigoModeloMoto()%></td>
				<td><%=eModeloMoto.getNome()%></td>
				<td><%=eModeloMoto.getCilindrada()%></td>
				<td><%=eModeloMoto.getNomeMarcaMoto()%></td>
			</tr>
	        
		<%} %>
	    </tbody>
	  </table>
	  <%} %>
	 
	   <%if(!alModeloMoto.isEmpty()){ %>
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