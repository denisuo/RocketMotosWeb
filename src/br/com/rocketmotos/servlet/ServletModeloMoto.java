package br.com.rocketmotos.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rocketmotos.dao.DAOMarcaMoto;
import br.com.rocketmotos.dao.DAOModeloMoto;
import br.com.rocketmotos.entidade.EntidadeMarcaMoto;
import br.com.rocketmotos.entidade.EntidadeModeloMoto;

/**
 * Servlet implementation class ServletModeloMoto
 */
@WebServlet("/ServletModeloMoto")
public class ServletModeloMoto extends ServletGenerico {

	private static final String NM_JSP_CONSULTAR = "/modeloMoto/consultarModeloMoto.jsp";
	// private static final String NM_JSP_ALTERAR_MARCA_MOTO =
	// "/marcaMoto/alterarMarcaMoto.jsp";

	private static final String NM_JSP_INCLUIR_MODELO_MOTO = "/modeloMoto/adicionarModeloMoto.jsp";

	private static final String NM_JSP_ALTERAR_MODELO_MOTO = "/modeloMoto/alterarModeloMoto.jsp";

	private static final String NM_SERVLET = ServletModeloMoto.class
			.getSimpleName();

	public static final String NM_PARAMETRO_CodigoModeloMoto = "cdModeloMoto";
	public static final String NM_PARAMETRO_NomeModeloMoto = "nmModeloMoto";
	public static final String NM_PARAMETRO_CodigoMarcaMoto = "cdMarcaMoto";
	public static final String NM_PARAMETRO_Cilindrada = "cilindrada";
	public static final String NM_PARAMETRO_ArrayModeloMoto = "alModeloMoto";

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
				this.NM_JSP_INCLUIR_MODELO_MOTO);
	};

	@Override
	public void processarInclusao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String nomeModelo = "";
		String codigoMarcaMoto = "";
		String cilindrada = "";

		// recupera os parametros do request
		nomeModelo = request.getParameter(this.NM_PARAMETRO_NomeModeloMoto);
		codigoMarcaMoto = request
				.getParameter(this.NM_PARAMETRO_CodigoMarcaMoto);
		cilindrada = request.getParameter(this.NM_PARAMETRO_Cilindrada);

		EntidadeModeloMoto eModeloMoto = new EntidadeModeloMoto();

		if ((nomeModelo != null && !nomeModelo.equals(""))
				&& (codigoMarcaMoto != null && !codigoMarcaMoto.equals(""))
				&& (cilindrada != null && !cilindrada.equals(""))) {
			eModeloMoto.setNome(nomeModelo);
			eModeloMoto.setCodigoMarcaMoto(Integer.valueOf(codigoMarcaMoto));
			eModeloMoto.setCilindrada(cilindrada);
			DAOModeloMoto.incluir(eModeloMoto);
		}

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);

	};

	@Override
	public void consultarTodos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ArrayList<EntidadeModeloMoto> alModeloMoto;
		String nomeModeloMoto = (String) request
				.getParameter(this.NM_PARAMETRO_NomeModeloMoto);

		// if (nomeModeloMoto != null && !nomeModeloMoto.equals("")) {
		// alModeloMoto = DAOModeloMoto.consultarTodos()(nomeModeloMoto);
		// } else {
		// }
		alModeloMoto = DAOModeloMoto.consultarTodos();

		request.setAttribute(this.NM_PARAMETRO_ArrayModeloMoto, alModeloMoto);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
	}

	@Override
	public void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// declara as variaveis
		String codigoModeloMoto = "";

		// recupera os parametros do request
		codigoModeloMoto = request
				.getParameter(this.NM_PARAMETRO_CodigoModeloMoto);

		if (codigoModeloMoto != null && !codigoModeloMoto.equals("")) {
			DAOModeloMoto.excluir(Integer.valueOf(codigoModeloMoto));
		}

		this.consultarTodos(request, response);
	}

	@Override
	public void exibirAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String codigoModeloMoto = "";

		// recupera os parametros do request
		codigoModeloMoto = request
				.getParameter(this.NM_PARAMETRO_CodigoModeloMoto);

		EntidadeModeloMoto eModeloMoto = DAOModeloMoto.consultarPorCodigoModelo(Integer
				.valueOf(codigoModeloMoto));

		request.setAttribute(this.NM_PARAMETRO_CodigoModeloMoto,
				String.valueOf(eModeloMoto.getCodigoModeloMoto()));
		request.setAttribute(this.NM_PARAMETRO_NomeModeloMoto,
				eModeloMoto.getNome());
		request.setAttribute(this.NM_PARAMETRO_Cilindrada,
				eModeloMoto.getCilindrada());
		request.setAttribute(this.NM_PARAMETRO_CodigoMarcaMoto,
				String.valueOf(eModeloMoto.getCodigoMarcaMoto()));

		this.redirecionarPagina(request, response,
				this.NM_JSP_ALTERAR_MODELO_MOTO);
	}

	@Override
	public void processarAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String codigoModeloMoto = "";
		String nomeModeloMoto = "";
		String cilindrada = "";
		String codigoMarcaMoto = "";

		// recupera os parametros do request
		codigoModeloMoto = request
				.getParameter(this.NM_PARAMETRO_CodigoModeloMoto);
		nomeModeloMoto = request.getParameter(this.NM_PARAMETRO_NomeModeloMoto);
		cilindrada = request.getParameter(this.NM_PARAMETRO_Cilindrada);
		codigoMarcaMoto = request
				.getParameter(this.NM_PARAMETRO_CodigoMarcaMoto);

		EntidadeModeloMoto eModeloMoto = new EntidadeModeloMoto();
		eModeloMoto.setCodigoModeloMoto(Integer.valueOf(codigoModeloMoto));
		eModeloMoto.setNome(nomeModeloMoto);
		eModeloMoto.setCilindrada(cilindrada);
		eModeloMoto.setCodigoMarcaMoto(Integer.valueOf(codigoMarcaMoto));

		DAOModeloMoto.alterar(eModeloMoto);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
	}

}
