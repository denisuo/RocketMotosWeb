package br.com.rocketmotos.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rocketmotos.dao.DAOProduto;
import br.com.rocketmotos.dao.DAOServico;
import br.com.rocketmotos.entidade.EntidadeProduto;
import br.com.rocketmotos.util.BibliotecaMetodos;

/**
 * Servlet implementation class ServletProduto
 */
@WebServlet("/ServletProduto")
public class ServletProduto extends ServletGenerico {

	private static final String NM_JSP_CONSULTAR = "/produto/consultarProduto.jsp";
	// private static final String NM_JSP_ALTERAR_MARCA_MOTO =
	// "/marcaMoto/alterarMarcaMoto.jsp";

	private static final String NM_JSP_INCLUIR_PRODUTO = "/produto/adicionarProduto.jsp";

	private static final String NM_JSP_ALTERAR_PRODUTO = "/produto/alterarProduto.jsp";

	private static final String NM_SERVLET = ServletProduto.class
			.getSimpleName();

	public static final String NM_PARAMETRO_CodigoProduto = "cdProduto";
	public static final String NM_PARAMETRO_NomeProduto = "nmProduto";
	public static final String NM_PARAMETRO_Descricao = "descricao";
	public static final String NM_PARAMETRO_Validade = "validade";
	public static final String NM_PARAMETRO_CodigoCategoriaProduto = "cdCategoriaProduto";
	public static final String NM_PARAMETRO_ValorProduto = "valorProduto";
	public static final String NM_PARAMETRO_QtdEstoque = "qtdEstoque";
	public static final String NM_PARAMETRO_ArrayProduto = "alProduto";
	

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
				this.NM_JSP_INCLUIR_PRODUTO);
	};

	@Override
	public void processarInclusao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		Date dataValidadeConvertida = null;
		String codigoProduto = "";
		String nomeProduto = "";
		String descricao = "";
		String validade = "";
		String codigoCategoriaProduto = "";
		String valor = "";
		String qtdEstoque = "";

		// recupera os parametros do request
		codigoProduto = request.getParameter(this.NM_PARAMETRO_CodigoProduto);
		nomeProduto = request.getParameter(this.NM_PARAMETRO_NomeProduto);
		descricao = request.getParameter(this.NM_PARAMETRO_Descricao);
		validade = request.getParameter(this.NM_PARAMETRO_Validade);
		codigoCategoriaProduto = request.getParameter(this.NM_PARAMETRO_CodigoCategoriaProduto);
		valor = request.getParameter(this.NM_PARAMETRO_ValorProduto);
		qtdEstoque = request.getParameter(this.NM_PARAMETRO_QtdEstoque);
		
		try {
			dataValidadeConvertida = new java.sql.Date(BibliotecaMetodos.formatarData(validade).getTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//monta a entidade produto para incluir
		EntidadeProduto eProduto = new EntidadeProduto();
		eProduto.setCodigoProduto(codigoProduto);
		eProduto.setNome(nomeProduto);
		eProduto.setDescricao(descricao);
		eProduto.setValidade(dataValidadeConvertida);
		eProduto.setCodigoCategoria(Integer.valueOf(codigoCategoriaProduto));
		eProduto.setValor(new Double(valor));
		eProduto.setQuantidade(Integer.valueOf(qtdEstoque));

		//inclui em produto
		DAOProduto.incluir(eProduto);
		
		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);

	};

	@Override
	public void consultarTodos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String codigoProduto = "";
		String nomeProduto = "";
		ArrayList<EntidadeProduto> alProduto;
		
		// recupera os parametros do request
		codigoProduto = (String) request.getParameter(this.NM_PARAMETRO_CodigoProduto);
		nomeProduto = (String) request.getParameter(this.NM_PARAMETRO_NomeProduto);

		if(codigoProduto != null && !codigoProduto.equals("")){
			alProduto = DAOProduto.consultarPorCodigo(codigoProduto);
		} else if(nomeProduto != null && !nomeProduto.equals("")){
			alProduto = DAOProduto.consultarPorNomeProduto(nomeProduto);
		} else {
			alProduto = DAOProduto.consultarTodos();
		}
		
		request.setAttribute(this.NM_PARAMETRO_ArrayProduto, alProduto);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
	}

	@Override
	public void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// declara as variaveis
		String codigoProduto = "";

		// recupera os parametros do request
		codigoProduto = request
				.getParameter(this.NM_PARAMETRO_CodigoProduto);

		//so exclui se o codigo do servico vier preenchido
		if (codigoProduto != null && !codigoProduto.equals("")) {
			DAOProduto.excluir(codigoProduto);
		}

		this.consultarTodos(request, response);
	}

	@Override
	public void exibirAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String codigoProduto = "";

		// recupera os parametros do request
		codigoProduto = request
				.getParameter(this.NM_PARAMETRO_CodigoProduto);
		
		//consulta por codigo para recuperar os valores e setar no request			
		EntidadeProduto eProduto = DAOProduto.consultarPorCodigo(codigoProduto).get(0);
	
		//seta os atributos no request para recuperar na JSP
		request.setAttribute(this.NM_PARAMETRO_CodigoProduto,
				String.valueOf(eProduto.getCodigoProduto()));
		request.setAttribute(this.NM_PARAMETRO_NomeProduto,
				eProduto.getNome());
		request.setAttribute(this.NM_PARAMETRO_Descricao,
				eProduto.getDescricao());
		request.setAttribute(this.NM_PARAMETRO_Validade,
				eProduto.getValidade().toString());
		request.setAttribute(this.NM_PARAMETRO_CodigoCategoriaProduto,
				String.valueOf(eProduto.getCodigoCategoria()));
		request.setAttribute(this.NM_PARAMETRO_ValorProduto,
				eProduto.getValor().toString());
		request.setAttribute(this.NM_PARAMETRO_QtdEstoque,
				String.valueOf(eProduto.getQuantidade()));

		this.redirecionarPagina(request, response,
				this.NM_JSP_ALTERAR_PRODUTO);
	}

	@Override
	public void processarAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		Date dataValidadeConvertida = null;
		String codigoProduto = "";
		String nomeProduto = "";
		String descricao = "";
		String validade = "";
		String codigoCategoriaProduto = "";
		String valor = "";
		String qtdEstoque = "";

		// recupera os parametros do request
		codigoProduto = request.getParameter(this.NM_PARAMETRO_CodigoProduto);
		nomeProduto = request.getParameter(this.NM_PARAMETRO_NomeProduto);
		descricao = request.getParameter(this.NM_PARAMETRO_Descricao);
		validade = request.getParameter(this.NM_PARAMETRO_Validade);
		codigoCategoriaProduto = request.getParameter(this.NM_PARAMETRO_CodigoCategoriaProduto);
		valor = request.getParameter(this.NM_PARAMETRO_ValorProduto);
		qtdEstoque = request.getParameter(this.NM_PARAMETRO_QtdEstoque);
		
		try {
			dataValidadeConvertida = new java.sql.Date(BibliotecaMetodos.formatarData(validade).getTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//monta a entidade produto para incluir
		EntidadeProduto eProduto = new EntidadeProduto();
		eProduto.setCodigoProduto(codigoProduto);
		eProduto.setNome(nomeProduto);
		eProduto.setDescricao(descricao);
		eProduto.setValidade(dataValidadeConvertida);
		eProduto.setCodigoCategoria(Integer.valueOf(codigoCategoriaProduto));
		eProduto.setValor(new Double(valor));
		eProduto.setQuantidade(Integer.valueOf(qtdEstoque));
		
		//altera em produto
		DAOProduto.alterar(eProduto);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
	}

}
