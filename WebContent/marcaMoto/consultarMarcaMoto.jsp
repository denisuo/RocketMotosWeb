<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.rocketmotos.servlet.ServletMarcaMoto"%>
<%@page import="br.com.rocketmotos.entidade.EntidadeMarcaMoto"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Consulta de Marca de Moto</title>

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

function exibirInclusao(){
	document.getElementById("<%=ServletMarcaMoto.NM_EVENTO%>").value = "<%=ServletMarcaMoto.NM_EVENTO_EXIBIR_INCLUSAO%>";
}

</script>
<%
	ArrayList<EntidadeMarcaMoto> alMarcaMoto;
	alMarcaMoto = (ArrayList<EntidadeMarcaMoto>) request.getAttribute(ServletMarcaMoto.NM_PARAMETRO_ArrayMarcaMoto);
	
	if(alMarcaMoto == null){
		alMarcaMoto = new ArrayList<EntidadeMarcaMoto>();
	}
%>
<body>
<jsp:include page="/template.jsp"/>

<div id="main" class="container-fluid">
<h3 class="page-header">Consultar Marca Moto</h3>
<form class="form-horizontal" action="ServletMarcaMoto" method="post">

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
                        <button class="btn btn-success btn-sm" type="submit" onclick="exibirInclusao();">Incluir</button>
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
			</tr>
		</thead>
		<tbody>
	    <%
			for(EntidadeMarcaMoto eMarcaMoto : alMarcaMoto){
		%>
			<tr>
				<td><input type="radio" id="cdMarcaMoto" name="cdMarcaMoto" value="<%=eMarcaMoto.getCodigo()%>">&nbsp<%=eMarcaMoto.getCodigo()%></td>
				<td><%=eMarcaMoto.getNome()%></td>
			</tr>
	        
		<%} %>
	    </tbody>
	  </table>
	  <%} %>
	 
	   <%if(!alMarcaMoto.isEmpty()){ %>
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


<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modalConfirmarExclusao">Open Modal</button>

<!-- Modal -->
<div id="modalConfirmarExclusao" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Confirmar</h4>
      </div>
      <div class="modal-body">
        <p class="text-warning">Deseja confirmar a exclusão?</p>
      </div>
      <div class="modal-footer">
		<button type="button" class="btn btn-primary" onclick="excluir();">Confirmar</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
      </div>
    </div>

  </div>
</div>





</body>
</html>