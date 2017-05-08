package br.com.rocketmotos.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rocketmotos.dao.DAOMarcaMoto;
import br.com.rocketmotos.entidade.EntidadeMarcaMoto;

/**
 * Servlet implementation class ServletMarcaMoto
 */
@WebServlet("/ServletMarcaMoto")
public class ServletMarcaMoto extends ServletGenerico {

	private static final String NM_JSP = "Teste.jsp";
	private static final String NM_JSP_ALTERAR_MARCA_MOTO = "alterarMarcaMoto.jsp";
	private static final String NM_SERVLET = ServletMarcaMoto.class
			.getSimpleName();
	
	public static final String NM_PARAMETRO_CodigoMarcaMoto = "cdMarcaMoto";
	public static final String NM_PARAMETRO_NomeMarcaMoto = "nmMarcaMoto";

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

		//declara as variaveis
		String acao = "";

		//recupera os parametros do request
		acao = request.getParameter("evento");

		if (acao != null && acao.equalsIgnoreCase(this.NM_EVENTO_INCLUIR)) {
			this.incluir(request, response);
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
			this.redirecionarPagina(request, response, this.NM_JSP);
		}

	}

	@Override
	protected void incluir(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {

		//declara as variaveis
		String nomeMarca = "";

		//recupera os parametros do request
		nomeMarca = request.getParameter("nomeMarca");

		EntidadeMarcaMoto eMarcaMoto = new EntidadeMarcaMoto();

		if (!nomeMarca.equals("")) {
			eMarcaMoto.setNome(nomeMarca);
		}

		DAOMarcaMoto.incluir(eMarcaMoto);
		ArrayList<EntidadeMarcaMoto> alMarcaMoto = new ArrayList<EntidadeMarcaMoto>();

		alMarcaMoto = DAOMarcaMoto.consultarTodos();

		System.out.println(alMarcaMoto);

	}

	@Override
	public void consultarTodos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ArrayList<EntidadeMarcaMoto> alMarcaMoto = DAOMarcaMoto
				.consultarTodos();

		request.setAttribute("arrayMarcaMoto", alMarcaMoto);

		this.redirecionarPagina(request, response, this.NM_JSP);
	}

	@Override
	public void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//declara as variaveis
		String codigoMarcaMoto = "";

		//recupera os parametros do request
		codigoMarcaMoto = request.getParameter("rdCodigoMarca");

		if (codigoMarcaMoto != null && !codigoMarcaMoto.equals("")) {
			DAOMarcaMoto.excluir(Integer.valueOf(codigoMarcaMoto));
		}

		this.consultarTodos(request, response);
	}

	@Override
	public void exibirAlteracao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//declara as variaveis
		String codigoMarcaMoto = "";
		String nomeMarcaMoto = "";

		//recupera os parametros do request
		codigoMarcaMoto = request.getParameter(this.NM_PARAMETRO_CodigoMarcaMoto);

		EntidadeMarcaMoto eMarcaMoto = DAOMarcaMoto.consultarPorCodigo(Integer.valueOf(codigoMarcaMoto));
		
		request.setAttribute(this.NM_PARAMETRO_CodigoMarcaMoto, eMarcaMoto.getCodigo());
		request.setAttribute(this.NM_PARAMETRO_NomeMarcaMoto, eMarcaMoto.getNome());
		
		this.redirecionarPagina(request, response, this.NM_JSP_ALTERAR_MARCA_MOTO);
	}


	@Override
	public void processarAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
