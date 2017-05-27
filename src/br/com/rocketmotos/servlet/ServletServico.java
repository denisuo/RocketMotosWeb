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
import br.com.rocketmotos.dao.DAOServico;
import br.com.rocketmotos.entidade.EntidadeMarcaMoto;
import br.com.rocketmotos.entidade.EntidadeModeloMoto;
import br.com.rocketmotos.entidade.EntidadeServico;

/**
 * Servlet implementation class ServletServico
 */
@WebServlet("/ServletServico")
public class ServletServico extends ServletGenerico {

	private static final String NM_JSP_CONSULTAR = "/servico/consultarServico.jsp";
	// private static final String NM_JSP_ALTERAR_MARCA_MOTO =
	// "/marcaMoto/alterarMarcaMoto.jsp";

	private static final String NM_JSP_INCLUIR_SERVICO = "/servico/adicionarServico.jsp";

	private static final String NM_JSP_ALTERAR_SERVICO = "/servico/alterarServico.jsp";

	private static final String NM_SERVLET = ServletServico.class
			.getSimpleName();

	public static final String NM_PARAMETRO_CodigoServico = "cdServico";
	public static final String NM_PARAMETRO_NomeServico = "nmServico";
	public static final String NM_PARAMETRO_Descricao = "descricao";
	public static final String NM_PARAMETRO_ValorSerico = "valor";
	public static final String NM_PARAMETRO_ArrayServico = "alServico";
	

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
		acao = request.getParameter(this.NM_EVENTO);

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
				this.NM_JSP_INCLUIR_SERVICO);
	};

	@Override
	public void processarInclusao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String nomeServico = "";
		String descricao = "";
		String valor = "";

		// recupera os parametros do request
		nomeServico = request.getParameter(this.NM_PARAMETRO_NomeServico);
		descricao = request.getParameter(this.NM_PARAMETRO_Descricao);
		valor = request.getParameter(this.NM_PARAMETRO_ValorSerico);

		//monta a entidade servico para incluir
		EntidadeServico eServico = new EntidadeServico();
		eServico.setNome(nomeServico);
		eServico.setDescricao(descricao);
		eServico.setValor(new Double(valor));

		DAOServico.incluir(eServico);
		
		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);

	};

	@Override
	public void consultarTodos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		ArrayList<EntidadeServico> alServico;
		
		// recupera os parametros do request
		String nomeServico = (String) request
				.getParameter(this.NM_PARAMETRO_NomeServico);

		//caso o campo de pesquisa por nome seja preenchido consulta por nome
		//caso contrario consulta todos
		if(nomeServico != null && !nomeServico.equals("")){
			alServico = DAOServico.consultarPorNomeServico(nomeServico);
		} else {
			alServico = DAOServico.consultarTodos();
		}
		
		request.setAttribute(this.NM_PARAMETRO_ArrayServico, alServico);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
	}

	@Override
	public void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// declara as variaveis
		String codigoServico = "";

		// recupera os parametros do request
		codigoServico = request
				.getParameter(this.NM_PARAMETRO_CodigoServico);

		//so exclui se o codigo do servico vier preenchido
		if (codigoServico != null && !codigoServico.equals("")) {
			DAOServico.excluir(Integer.valueOf(codigoServico));
		}

		this.consultarTodos(request, response);
	}

	@Override
	public void exibirAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String codigoServico = "";

		// recupera os parametros do request
		codigoServico = request
				.getParameter(this.NM_PARAMETRO_CodigoServico);
		
		//consulta por codigo para recuperar os valores e setar no request				
		EntidadeServico eServico = DAOServico.consultarPorCodigo(codigoServico);
	
		//seta os atributos no request para recuperar na JSP
		request.setAttribute(this.NM_PARAMETRO_CodigoServico,
				String.valueOf(eServico.getCodigoServico()));
		request.setAttribute(this.NM_PARAMETRO_NomeServico,
				eServico.getNome());
		request.setAttribute(this.NM_PARAMETRO_Descricao,
				eServico.getDescricao());
		request.setAttribute(this.NM_PARAMETRO_ValorSerico,
				eServico.getValor().toString());

		this.redirecionarPagina(request, response,
				this.NM_JSP_ALTERAR_SERVICO);
	}

	@Override
	public void processarAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String codigoServico = "";
		String nomeServico = "";
		String descricao = "";
		String valorServico = "";

		// recupera os parametros do request
		codigoServico = request
				.getParameter(this.NM_PARAMETRO_CodigoServico);
		nomeServico = request.getParameter(this.NM_PARAMETRO_NomeServico);
		descricao = request.getParameter(this.NM_PARAMETRO_Descricao);
		valorServico = request
				.getParameter(this.NM_PARAMETRO_ValorSerico);

		//monta a entidade servico para alterar
		EntidadeServico eServico = new EntidadeServico();
		eServico.setCodigoServico(Integer.valueOf(codigoServico));
		eServico.setNome(nomeServico);
		eServico.setDescricao(descricao);
		eServico.setValor(new Double(valorServico));

		DAOServico.alterar(eServico);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
	}

}
