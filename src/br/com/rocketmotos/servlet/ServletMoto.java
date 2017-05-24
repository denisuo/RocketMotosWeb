package br.com.rocketmotos.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rocketmotos.dao.DAOCliente;
import br.com.rocketmotos.dao.DAOMarcaMoto;
import br.com.rocketmotos.dao.DAOModeloMoto;
import br.com.rocketmotos.dao.DAOMoto;
import br.com.rocketmotos.entidade.EntidadeCliente;
import br.com.rocketmotos.entidade.EntidadeMarcaMoto;
import br.com.rocketmotos.entidade.EntidadeModeloMoto;
import br.com.rocketmotos.entidade.EntidadeMoto;

/**
 * Servlet implementation class ServletMoto
 */
@WebServlet("/ServletMoto")
public class ServletMoto extends ServletGenerico {

	private static final String NM_JSP_CONSULTAR = "/moto/consultarMoto.jsp";
	// private static final String NM_JSP_ALTERAR_MARCA_MOTO =
	// "/marcaMoto/alterarMarcaMoto.jsp";

	private static final String NM_JSP_INCLUIR_MOTO = "/moto/adicionarMoto.jsp";

	private static final String NM_JSP_ALTERAR_MOTO = "/moto/alterarMoto.jsp";

	private static final String NM_SERVLET = ServletMoto.class
			.getSimpleName();

	public static final String NM_PARAMETRO_PlacaMoto = "placaMoto";
	public static final String NM_PARAMETRO_AnoFabricacao = "anoFabricacao";
	public static final String NM_PARAMETRO_Cor = "cor";
	public static final String NM_PARAMETRO_NumeroDocumentoCliente = "nuDocumentoCliente";
	public static final String NM_PARAMETRO_CodigoModeloMoto = "cdModeloMoto";
	public static final String NM_PARAMETRO_ArrayMoto = "alMoto";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String acao = "";

		// recupera o evento desejado
		acao = request.getParameter("evento");

		if (acao != null
				&& acao.equalsIgnoreCase(this.NM_EVENTO_EXIBIR_INCLUSAO)) {
			this.exibirInclusao(request, response);
		} else if (acao != null
				&& acao.equalsIgnoreCase(this.NM_EVENTO_PROCESSAR_INCLUSAO)) {
			this.processarInclusao(request, response);
		} else if (acao != null
				&& acao.equalsIgnoreCase(this.NM_EVENTO_CONSULTAR_TODOS)) {
			this.consultarTodos(request, response);
		} else if (acao != null
				&& acao.equalsIgnoreCase(this.NM_EVENTO_EXCLUIR)) {
			this.excluir(request, response);
		} else if (acao != null
				&& acao.equalsIgnoreCase(this.NM_EVENTO_EXIBIR_ALTERACAO)) {
			this.exibirAlteracao(request, response);
		} else if (acao != null
				&& acao.equalsIgnoreCase(this.NM_EVENTO_PROCESSAR_ALTERACAO)) {
			this.processarAlteracao(request, response);
		} else {
			// caso nao tenha nenhum evento, redireciona para a pagina de
			// consulta
			this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
		}

	}

	@Override
	public void exibirInclusao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// redireciona para a pagina de inclusao
		this.redirecionarPagina(request, response,
				this.NM_JSP_INCLUIR_MOTO);
	};

	@Override
	public void processarInclusao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String placaMoto = "";
		String ano = "";
		String cor = "";
		String nuDocumentoCliente = "";
		String cdModeloMoto = "";

		// recupera os parametros do request
		placaMoto = request.getParameter(this.NM_PARAMETRO_PlacaMoto);
		ano = request.getParameter(this.NM_PARAMETRO_AnoFabricacao);
		cor = request.getParameter(this.NM_PARAMETRO_Cor);
		nuDocumentoCliente = request.getParameter(this.NM_PARAMETRO_NumeroDocumentoCliente);
		cdModeloMoto = request.getParameter(this.NM_PARAMETRO_CodigoModeloMoto);

		//monta a entidade para poder incluir
		EntidadeMoto eMoto = new EntidadeMoto();
		eMoto.setPlaca(placaMoto);
		eMoto.setAno(ano);
		eMoto.setCor(cor);
		eMoto.setNumeroDocumentoCliente(nuDocumentoCliente);
		eMoto.setCodigoModeloMoto(Integer.valueOf(cdModeloMoto));
		
		DAOMoto.incluir(eMoto);
		
		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);

	};

	@Override
	public void consultarTodos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String nuDocumentoCliente = "";
		String placaMoto = "";
		ArrayList<EntidadeMoto> alMoto;
		
		// recupera os parametros do request
		nuDocumentoCliente = request.getParameter(this.NM_PARAMETRO_NumeroDocumentoCliente);
		placaMoto = request.getParameter(this.NM_PARAMETRO_PlacaMoto);
		
		//verifica se 
		if(nuDocumentoCliente != null && !nuDocumentoCliente.equals("")){
			alMoto = DAOMoto.consultarPorNumeroDocumentoCliente(nuDocumentoCliente);
		} else if(placaMoto != null && !placaMoto.equals("")){
			alMoto = DAOMoto.consultarPorPlaca(placaMoto);
		} else {
			alMoto = DAOMoto.consultarTodos();
		}
		
		request.setAttribute(this.NM_PARAMETRO_ArrayMoto, alMoto);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
	}

	@Override
	public void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// declara as variaveis
		String placaMoto = "";

		// recupera os parametros do request
		placaMoto = request.getParameter(this.NM_PARAMETRO_PlacaMoto);

		if (placaMoto != null && !placaMoto.equals("")) {
			DAOMoto.excluir(placaMoto);
		}

		this.consultarTodos(request, response);
	}

	@Override
	public void exibirAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String placaMoto = "";
		ArrayList<EntidadeMoto> alMoto;
		EntidadeMoto eMoto;
		
		// recupera os parametros do request
		placaMoto = request
				.getParameter(this.NM_PARAMETRO_PlacaMoto);

		//consulta o cliente por numero de documento para excluir
		alMoto = DAOMoto.consultarPorPlaca(placaMoto);
		eMoto = alMoto.get(0);

		request.setAttribute(this.NM_PARAMETRO_PlacaMoto, eMoto.getPlaca());
		request.setAttribute(this.NM_PARAMETRO_AnoFabricacao, eMoto.getAno());
		request.setAttribute(this.NM_PARAMETRO_Cor, eMoto.getCor());
		request.setAttribute(this.NM_PARAMETRO_NumeroDocumentoCliente, eMoto.getNumeroDocumentoCliente());
		request.setAttribute(this.NM_PARAMETRO_CodigoModeloMoto, String.valueOf(eMoto.getCodigoModeloMoto()));

		this.redirecionarPagina(request, response,
				this.NM_JSP_ALTERAR_MOTO);
	}

	@Override
	public void processarAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String placaMoto = "";
		String ano = "";
		String cor = "";
		String nuDocumentoCliente = "";
		String cdModeloMoto = "";

		// recupera os parametros do request
		placaMoto = request.getParameter(this.NM_PARAMETRO_PlacaMoto);
		ano = request.getParameter(this.NM_PARAMETRO_AnoFabricacao);
		cor = request.getParameter(this.NM_PARAMETRO_Cor);
		nuDocumentoCliente = request.getParameter(this.NM_PARAMETRO_NumeroDocumentoCliente);
		cdModeloMoto = request.getParameter(this.NM_PARAMETRO_CodigoModeloMoto);


		//monta entidadeMoto para poder alterar
		EntidadeMoto eMoto = new EntidadeMoto();
		eMoto.setPlaca(placaMoto);
		eMoto.setAno(ano);
		eMoto.setCor(cor);
		eMoto.setNumeroDocumentoCliente(nuDocumentoCliente);
		eMoto.setCodigoModeloMoto(Integer.valueOf(cdModeloMoto));
		
		//altera os dados da moto
		DAOMoto.alterar(eMoto);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
	}

}
