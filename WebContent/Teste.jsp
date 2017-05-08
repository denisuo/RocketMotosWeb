<%@page import="br.com.rocketmotos.servlet.ServletMarcaMoto"%>
<%@page import="br.com.rocketmotos.entidade.EntidadeMarcaMoto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">

function incluir(){
	document.getElementById("<%=ServletMarcaMoto.NM_EVENTO%>").value = "<%=ServletMarcaMoto.NM_EVENTO_INCLUIR%>";
	//if(document.getElementById("nomeMarca").value == ""){
	//	alert('ABCD');
	//	return false;
	//}
}

function consultar(){
	document.getElementById("<%=ServletMarcaMoto.NM_EVENTO%>").value = "<%=ServletMarcaMoto.NM_EVENTO_CONSULTAR_TODOS%>";
}

function excluir(){
		alert(document.getElementById("rdCodigoMarca").value);
		document.getElementById("<%=ServletMarcaMoto.NM_EVENTO%>").value = "<%=ServletMarcaMoto.NM_EVENTO_EXCLUIR%>";
	//if(document.getElementById("rdCodigoMarca").value == null){	}
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
<input type="text" id="nomeMarca" name="nomeMarca" maxlength="50">
<input type="submit" value="INCLUIR" onclick="incluir();">
<input type="submit" value="CONSULTAR" onclick="consultar();">
<input type="submit" value="EXCLUIR" onclick="excluir();">
<br>
<%
	for(EntidadeMarcaMoto eMarcaMoto : alMarcaMoto){
%>
	<input type="radio" id="rdCodigoMarca" name="rdCodigoMarca" value="<%=eMarcaMoto.getCodigo()%>"> <%=eMarcaMoto.getNome()%> <BR>
<%} %>

</form>

</body>
</html>