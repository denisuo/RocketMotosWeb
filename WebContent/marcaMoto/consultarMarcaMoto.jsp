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

<link href="..\bootstrap-3.3.7-dist\css\bootstrap.min.css" rel="stylesheet">

<script src="..\bootstrap-3.3.7-dist\js\jquery.min.js"></script>
<script src="..\bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>

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
</script>
<%
	ArrayList<EntidadeMarcaMoto> alMarcaMoto;
	alMarcaMoto = (ArrayList<EntidadeMarcaMoto>) request.getAttribute("arrayMarcaMoto");
	
	if(alMarcaMoto == null){
		alMarcaMoto = new ArrayList<EntidadeMarcaMoto>();
	}
%>
<body>
<h1>TESTE MARCA MOTO</h1>

<form action="ServletMarcaMoto" method="post">

<input type="hidden" id="evento" name="evento" value="">
<input type="text" id="nmMarcaMoto" name="nmMarcaMoto" maxlength="50">
<input type="submit" value="CONSULTAR" onclick="consultar();">
<input type="submit" value="INCLUIR" onclick="incluir();">
<input type="submit" value="EXCLUIR" onclick="excluir();">
<input type="submit" value="ALTERAR" onclick="exibirAlteracao();">
<br>
<%
	for(EntidadeMarcaMoto eMarcaMoto : alMarcaMoto){
%>
	<input type="radio" id="cdMarcaMoto" name="cdMarcaMoto" value="<%=eMarcaMoto.getCodigo()%>"> <%=eMarcaMoto.getNome()%> <BR>
<%} %>

</form>

</body>
</html>