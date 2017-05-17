<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.rocketmotos.servlet.ServletMarcaMoto"%>
<%@page import="br.com.rocketmotos.entidade.EntidadeMarcaMoto"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inclusão de Marca de Moto</title>


<link href="${pageContext.request.contextPath}\bootstrap-3.3.7-dist\css\bootstrap.min.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}\bootstrap-3.3.7-dist\js\jquery.min.js"></script>
<script src="${pageContext.request.contextPath}\bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>

</head>
<script type="text/javascript">

function consultar(){
	document.getElementById("<%=ServletMarcaMoto.NM_EVENTO%>").value = "<%=ServletMarcaMoto.NM_EVENTO_CONSULTAR_TODOS%>";
}

function excluir(){
	document.getElementById("<%=ServletMarcaMoto.NM_EVENTO%>").value = "<%=ServletMarcaMoto.NM_EVENTO_EXCLUIR%>";
	//if(document.getElementById("rdCodigoMarca").value == null){	}
}

function exibirAlteracao(){
	document.getElementById("<%=ServletMarcaMoto.NM_EVENTO%>").value = "<%=ServletMarcaMoto.NM_EVENTO_EXIBIR_ALTERACAO%>";
}
function incluir(){
	document.getElementById("<%=ServletMarcaMoto.NM_EVENTO%>").value = "<%=ServletMarcaMoto.NM_EVENTO_INCLUIR%>";
}

</script>
<%
	ArrayList<EntidadeMarcaMoto> alMarcaMoto;
	alMarcaMoto = (ArrayList<EntidadeMarcaMoto>) request.getAttribute("arrayMarcaMoto");
	
	if(alMarcaMoto == null){
		alMarcaMoto = new ArrayList<EntidadeMarcaMoto>();
	}
%>
<body>
<jsp:include page="../template.jsp"/>
<h1>TESTE MARCA MOTO</h1>

<div id="main" class="container-fluid">
<h3 class="page-header">Consultar Marca Moto</h3>
<form class="form-horizontal" action="ServletMarcaMoto" method="post">

<input type="submit" value="EXCLUIR" onclick="excluir();">

<div class="container" align="left">
	<div class="row">
        <div class="col-md-6">
            <div id="custom-search-input">
                <div class="input-group col-md-8">
                    <input type="text" id="nmMarcaMoto" name="nmMarcaMoto" class="form-control input-sm" placeholder="Buscar" />
                    <span class="input-group-btn">
                        <button class="btn btn-info btn-sm" type="submit" onclick="consultar();"> 
                        <i class="glyphicon glyphicon-search"></i>
                        </button>
                        <button class="btn btn-success btn-sm" type="submit" onclick="incluir();">Incluir</button>
                    </span>
                </div>
            </div>
        </div>
	</div>
</div>

<input type="hidden" id="<%=ServletMarcaMoto.NM_EVENTO%>" name="<%=ServletMarcaMoto.NM_EVENTO%>" value="">
	<div class="container">
	  
	  <%if(!alMarcaMoto.isEmpty()){ %>
	  <table class="table table-striped">
		<thead>
			<tr>
				<th>Código</th>
				<th>Marca</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
	    <%
			for(EntidadeMarcaMoto eMarcaMoto : alMarcaMoto){
		%>
			<tr>
				<td><input type="radio" id="cdMarcaMoto" name="cdMarcaMoto" value="<%=eMarcaMoto.getCodigo()%>"><%=eMarcaMoto.getCodigo()%></td>
				<td><%=eMarcaMoto.getNome()%></td>
			</tr>
	        
		<%} %>
	    </tbody>
	  </table>
	  <%} %>
	 
	   <%if(!alMarcaMoto.isEmpty()){ %>
	  <div class="container" align="center">
	  	<td>
			<button id="btnAlterar" name="btnAlterar" class="btn btn-success btn-xs" onclick="exibirAlteracao();">Alterar</button>
			<button id="btnExcluir" name="btnExcluir" class="btn btn-danger btn-xs" onclick="excluir();">Excluir</button>
		</td>
	  </div>
	  <%} %>
	  
	</div>
</form>
</div>


</body>
</html>