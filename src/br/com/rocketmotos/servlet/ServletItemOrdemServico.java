package br.com.rocketmotos.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rocketmotos.dao.DAOItemOrdemServico;
import br.com.rocketmotos.dao.DAOMarcaMoto;
import br.com.rocketmotos.dao.DAOModeloMoto;
import br.com.rocketmotos.dao.DAOServico;
import br.com.rocketmotos.entidade.EntidadeItemOrdemServico;
import br.com.rocketmotos.entidade.EntidadeMarcaMoto;
import br.com.rocketmotos.entidade.EntidadeModeloMoto;
import br.com.rocketmotos.entidade.EntidadeServico;
import br.com.rocketmotos.util.Constantes;

/**
 * Servlet implementation class ServletItemOrdemServico
 */
@WebServlet("/ServletItemOrdemServico")
public class ServletItemOrdemServico extends ServletGenerico {

	private static final String NM_JSP_CONSULTAR = "/itemOrdemServico/consultarItemOrdemServico.jsp";
	// private static final String NM_JSP_ALTERAR_MARCA_MOTO =
	// "/marcaMoto/alterarMarcaMoto.jsp";

	private static final String NM_JSP_INCLUIR_ITEM_ORDEM_SERVICO = "/itemOrdemServico/adicionarItemOrdemServico.jsp";

	private static final String NM_JSP_ALTERAR_ITEM_ORDEM_SERVICO = "/itemOrdemServico/alterarItemOrdemServico.jsp";

	private static final String NM_SERVLET = ServletItemOrdemServico.class
			.getSimpleName();

	public static final String NM_PARAMETRO_CodigoOrdemServico = "cdOrdemServico";
	public static final String NM_PARAMETRO_CodigoProduto = "cdProduto";
	public static final String NM_PARAMETRO_CodigoServico = "cdServico";
	public static final String NM_PARAMETRO_QtdProdutoUtilizado = "qtdProdutoUtilizado";
	public static final String NM_PARAMETRO_ArrayItemOrdemServico = "alItemOrdemServico";

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

		// declara as variaveis
		String codigoOrdemServico = "";
		
		// recupera os parametros do request
		codigoOrdemServico = request
				.getParameter(this.NM_PARAMETRO_CodigoOrdemServico);
		
		//seta no request
		request.setAttribute(this.NM_PARAMETRO_CodigoOrdemServico,
				codigoOrdemServico);
		
		// redireciona para a pagina de inclusao
		this.redirecionarPagina(request, response,
				this.NM_JSP_INCLUIR_ITEM_ORDEM_SERVICO);
	};

	@Override
	public void processarInclusao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String codigoOrdemServico = "";
		String codigoProduto = "";
		String codigoServico = "";
		String qtdProdutoUtilizado = "";

		// recupera os parametros do request
		codigoOrdemServico = request
				.getParameter(this.NM_PARAMETRO_CodigoOrdemServico);
		codigoProduto = request.getParameter(this.NM_PARAMETRO_CodigoProduto);
		codigoServico = request.getParameter(this.NM_PARAMETRO_CodigoServico);
		qtdProdutoUtilizado = request
				.getParameter(this.NM_PARAMETRO_QtdProdutoUtilizado);

		// monta entidade item ordem servico para poder setar os itens
		// referentes a ordem de servico
		EntidadeItemOrdemServico eItemOrdemServico = new EntidadeItemOrdemServico();
		eItemOrdemServico.setCodigoOrdemServico(Integer
				.valueOf(codigoOrdemServico));
		eItemOrdemServico.setCodigoProduto(codigoProduto);
		eItemOrdemServico.setCodigoServico(Integer.valueOf(codigoServico));
		eItemOrdemServico.setQtdProdutoUtilizado(Integer
				.valueOf(qtdProdutoUtilizado));

		// inclui em unico item em ITEM_ORDEM_SERVICO
		DAOItemOrdemServico.incluir(eItemOrdemServico);
		
		//seta no request
		request.setAttribute(this.NM_PARAMETRO_CodigoOrdemServico,
				codigoOrdemServico);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);

	};

	@Override
	public void consultarTodos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String codigoOrdemServico = "";
		ResultSet rs = null;

		// recupera os parametros do request
		codigoOrdemServico = (String) request
				.getParameter(this.NM_PARAMETRO_CodigoOrdemServico);

		// consulta todos os itens por ordem de serviço
		rs = DAOItemOrdemServico
				.consultarTodosPorCodigoOrdem(Integer
						.valueOf(codigoOrdemServico));

		// seta o array de item ordem servico no request para recuperar na jsp
		// de consulta
		request.setAttribute(this.NM_PARAMETRO_ArrayItemOrdemServico,
				rs);
		request.setAttribute(this.NM_PARAMETRO_CodigoOrdemServico,
				codigoOrdemServico);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
	}

	@Override
	public void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// declara as variaveis
		String chavePrimaria = "";
		String[] arCamposChave;
		String codigoOrdemServico = "";
		String codigoProduto = "";
		String codigoServico = "";

		// recupera os parametros do request
		chavePrimaria = request.getParameter(this.NM_PARAMETRO_CHAVE_PRIMARIA);
		//separa os campos da chave primaria em um array para poder exlcuir
		arCamposChave = chavePrimaria.split(Constantes.CAMPO_SERPARADOR_CHAVE_PRIMARIA);
		
		//recupera os valores da chave primaria
		codigoOrdemServico = arCamposChave[0]; 
		codigoProduto = arCamposChave[1];
		codigoServico = arCamposChave[2];

		//exclui unico item da ordem de serviço
		DAOItemOrdemServico.excluirUnicoItem(
				Integer.valueOf(codigoOrdemServico), codigoProduto,
				Integer.valueOf(codigoServico));
		
		//seta codigo da ordem de servico no request 
		request.setAttribute(this.NM_PARAMETRO_CodigoOrdemServico, codigoOrdemServico);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
	}

	@Override
	public void exibirAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String codigoOrdemServico = "";
		String codigoProduto = "";
		String codigoServico = "";

		// recupera os parametros do request
		codigoOrdemServico = request
				.getParameter(this.NM_PARAMETRO_CodigoOrdemServico);
		codigoProduto = request.getParameter(this.NM_PARAMETRO_CodigoProduto);
		codigoServico = request.getParameter(this.NM_PARAMETRO_CodigoServico);

		// consulta único item
		EntidadeItemOrdemServico eItemOrdemServico = DAOItemOrdemServico
				.consultarUnicoItem(Integer.valueOf(codigoOrdemServico),
						codigoProduto, Integer.valueOf(codigoServico));

		// seta os atributos no request para recuperar na JSP
		request.setAttribute(this.NM_PARAMETRO_CodigoOrdemServico,
				String.valueOf(eItemOrdemServico.getCodigoOrdemServico()));
		request.setAttribute(this.NM_PARAMETRO_CodigoProduto,
				eItemOrdemServico.getCodigoProduto());
		request.setAttribute(this.NM_PARAMETRO_CodigoServico,
				String.valueOf(eItemOrdemServico.getCodigoServico()));
		request.setAttribute(this.NM_PARAMETRO_QtdProdutoUtilizado,
				String.valueOf(eItemOrdemServico.getQtdProdutoUtilizado()));

		this.redirecionarPagina(request, response,
				this.NM_JSP_ALTERAR_ITEM_ORDEM_SERVICO);
	}

	@Override
	public void processarAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String codigoOrdemServico = "";
		String codigoProduto = "";
		String codigoServico = "";
		String qtdProdutoUtilizado = "";

		// recupera os parametros do request
		codigoOrdemServico = request
				.getParameter(this.NM_PARAMETRO_CodigoOrdemServico);
		codigoProduto = request.getParameter(this.NM_PARAMETRO_CodigoProduto);
		codigoServico = request.getParameter(this.NM_PARAMETRO_CodigoServico);
		qtdProdutoUtilizado = request
				.getParameter(this.NM_PARAMETRO_QtdProdutoUtilizado);

		// monta entidade item ordem servico para alterar
		EntidadeItemOrdemServico eItemOrdemServico = new EntidadeItemOrdemServico();
		eItemOrdemServico.setCodigoOrdemServico(Integer
				.valueOf(codigoOrdemServico));
		eItemOrdemServico.setCodigoProduto(codigoProduto);
		eItemOrdemServico.setCodigoServico(Integer.valueOf(codigoServico));
		eItemOrdemServico.setQtdProdutoUtilizado(Integer
				.valueOf(qtdProdutoUtilizado));

		DAOItemOrdemServico.alterar(eItemOrdemServico);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
	}

}
