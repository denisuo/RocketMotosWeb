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
import br.com.rocketmotos.dao.DAOVenda;
import br.com.rocketmotos.entidade.EntidadeProduto;
import br.com.rocketmotos.entidade.EntidadeVenda;
import br.com.rocketmotos.util.BibliotecaMetodos;

/**
 * Servlet implementation class ServletVenda
 */
@WebServlet("/ServletVenda")
public class ServletVenda extends ServletGenerico {

	private static final String NM_JSP_CONSULTAR = "/venda/consultarVenda.jsp";
	// private static final String NM_JSP_ALTERAR_MARCA_MOTO =
	// "/marcaMoto/alterarMarcaMoto.jsp";

	private static final String NM_JSP_INCLUIR_VENDA = "/venda/adicionarVenda.jsp";

	private static final String NM_JSP_ALTERAR_VENDA = "/venda/alterarVenda.jsp";

	private static final String NM_SERVLET = ServletVenda.class
			.getSimpleName();

	public static final String NM_PARAMETRO_CodigoVenda = "cdVenda";
	public static final String NM_PARAMETRO_NuDocumentoCliente = "nuDocumentoCliente";
	public static final String NM_PARAMETRO_DataVenda = "dataVenda";
	public static final String NM_PARAMETRO_ValorVenda = "valorVenda";
	public static final String NM_PARAMETRO_TipoPagamento = "tipoPagamento";
	public static final String NM_PARAMETRO_Desconto = "desconto";
	public static final String NM_PARAMETRO_ArrayVenda = "alVenda";
	

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
				this.NM_JSP_INCLUIR_VENDA);
	};

	@Override
	public void processarInclusao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		Date dataVendaConvertida = null;
		String codigoVenda = "";
		String nuDocumentoCliente = "";
		String valor = "";
		String tipoPagamento = "";

		// recupera os parametros do request
		codigoVenda = request.getParameter(this.NM_PARAMETRO_CodigoVenda);
		nuDocumentoCliente = request.getParameter(this.NM_PARAMETRO_NuDocumentoCliente);
		valor = request.getParameter(this.NM_PARAMETRO_ValorVenda);
		tipoPagamento = request.getParameter(this.NM_PARAMETRO_TipoPagamento);
		
		//monta a entidade venda para incluir
		EntidadeVenda eVenda = new EntidadeVenda();
		eVenda.setCodigo(Integer.valueOf(codigoVenda));
		eVenda.setDocumentoCliente(nuDocumentoCliente);
		eVenda.setData(new Date(System.currentTimeMillis()));
		eVenda.setValor(new Double(valor));
		eVenda.setTipoPagamento(tipoPagamento);
		eVenda.setDesconto(new Double("0.00"));

		//inclui em venda
		DAOVenda.incluir(eVenda);
		
		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);

	};

	@Override
	public void consultarTodos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String codigoVenda = "";
		String nuDocumentoCliente = "";
		ArrayList<EntidadeVenda> alVenda;
		
		// recupera os parametros do request
		codigoVenda = (String) request.getParameter(this.NM_PARAMETRO_CodigoVenda);
		nuDocumentoCliente = (String) request.getParameter(this.NM_PARAMETRO_NuDocumentoCliente);

		//consulta por codigo de venda ou numeroDocumento do cliente
		if(codigoVenda != null && !codigoVenda.equals("")){
			alVenda = DAOVenda.consultarPorCodigoVenda(codigoVenda);
		} else if(nuDocumentoCliente != null && !nuDocumentoCliente.equals("")){
			alVenda = DAOVenda.consultarPorDocumentoCliente(nuDocumentoCliente);
		} else {
			alVenda = DAOVenda.consultarTodos();
		}
		
		request.setAttribute(this.NM_PARAMETRO_ArrayVenda, alVenda);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
	}

	@Override
	public void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// declara as variaveis
		String codigoVenda = "";

		// recupera os parametros do request
		codigoVenda = request
				.getParameter(this.NM_PARAMETRO_CodigoVenda);

		//so exclui se o codigo do servico vier preenchido
		if (codigoVenda != null && !codigoVenda.equals("")) {
			DAOVenda.excluir(Integer.valueOf(codigoVenda));
		}

		this.consultarTodos(request, response);
	}

	@Override
	public void exibirAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String codigoVenda = "";

		// recupera os parametros do request
		codigoVenda = request
				.getParameter(this.NM_PARAMETRO_CodigoVenda);
		
		//consulta por codigo para recuperar os valores e setar no request			
		EntidadeVenda eVenda = DAOVenda.consultarPorCodigoVenda(codigoVenda).get(0);
	
		//seta os atributos no request para recuperar na JSP
		request.setAttribute(this.NM_PARAMETRO_CodigoVenda,
				String.valueOf(eVenda.getCodigo()));
		request.setAttribute(this.NM_PARAMETRO_NuDocumentoCliente,
				eVenda.getDocumentoCliente());
		request.setAttribute(this.NM_PARAMETRO_DataVenda,
				eVenda.getData().toString());
		request.setAttribute(this.NM_PARAMETRO_ValorVenda,
				String.valueOf(eVenda.getValor()));
		request.setAttribute(this.NM_PARAMETRO_TipoPagamento,
				eVenda.getTipoPagamento());
		request.setAttribute(this.NM_PARAMETRO_Desconto,
				String.valueOf(eVenda.getDesconto()));

		this.redirecionarPagina(request, response,
				this.NM_JSP_ALTERAR_VENDA);
	}

	@Override
	public void processarAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		Date dataVendaConvertida = null;
		String codigoVenda = "";
		String nuDocumentoCliente = "";
		String dataVenda = "";
		String valor = "";
		String tipoPagamento = "";
		String desconto = "";

		// recupera os parametros do request
		codigoVenda = request.getParameter(this.NM_PARAMETRO_CodigoVenda);
		nuDocumentoCliente = request.getParameter(this.NM_PARAMETRO_NuDocumentoCliente);
		dataVenda = request.getParameter(this.NM_PARAMETRO_DataVenda);
		valor = request.getParameter(this.NM_PARAMETRO_ValorVenda);
		tipoPagamento = request.getParameter(this.NM_PARAMETRO_TipoPagamento);
		desconto = request.getParameter(this.NM_PARAMETRO_Desconto);
		
		try {
			dataVendaConvertida = new java.sql.Date(BibliotecaMetodos.formatarData(dataVenda).getTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//monta a entidade venda para incluir
		EntidadeVenda eVenda = new EntidadeVenda();
		eVenda.setCodigo(Integer.valueOf(codigoVenda));
		eVenda.setDocumentoCliente(nuDocumentoCliente);
		eVenda.setData(dataVendaConvertida);
		eVenda.setValor(new Double(valor));
		eVenda.setTipoPagamento(tipoPagamento);
		eVenda.setDesconto(new Double(desconto));

		//inclui em venda
		DAOVenda.alterar(eVenda);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
	}

}
