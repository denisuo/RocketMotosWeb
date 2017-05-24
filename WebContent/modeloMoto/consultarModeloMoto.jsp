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


<link href="${pageContext.request.contextPath}\bootstrap-3.3.7-dist\css\bootstrap.min.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}\bootstrap-3.3.7-dist\js\jquery.min.js"></script>
<script src="${pageContext.request.contextPath}\bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>

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

<div class="container" align="left">
	<div class="row">
        <div class="col-md-6">
            <div id="custom-search-input">
                <div class="input-group col-md-8">
                    <input type="text" id="nmModeloMoto" name="nmModeloMoto" class="form-control input-sm" placeholder="Buscar" />
                    <span class="input-group-btn">
                        <button class="btn btn-info btn-sm" type="submit" onclick="consultar();"> 
                        <i class="glyphicon glyphicon-search"></i>
                        </button>
                        <button class="btn btn-success btn-sm" type="submit" onclick="exibirInclusao();">Incluir</button>
                    </span>
                </div>
            </div>
        </div>
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
				<td><%=eModeloMoto.getCodigoMarcaMoto()%></td>
			</tr>
	        
		<%} %>
	    </tbody>
	  </table>
	  <%} %>
	 
	   <%if(!alModeloMoto.isEmpty()){ %>
	  <div class="container" align="center">
	  	<td>
	  		<button id="btnIncluir" name="btnIncluir" class="btn btn-success btn-xs" onclick="exibirInclusao();">Incluir</button>
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