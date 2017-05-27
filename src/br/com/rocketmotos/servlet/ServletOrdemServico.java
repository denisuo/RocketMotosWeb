package br.com.rocketmotos.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rocketmotos.dao.DAOOrdemServico;
import br.com.rocketmotos.entidade.EntidadeOrdemServico;

/**
 * Servlet implementation class ServletOrdemServico
 */
@WebServlet("/ServletOrdemServico")
public class ServletOrdemServico extends ServletGenerico {

	private static final String NM_JSP_CONSULTAR = "/ordemServico/consultarOrdemServico.jsp";
	// private static final String NM_JSP_ALTERAR_MARCA_MOTO =
	// "/marcaMoto/alterarMarcaMoto.jsp";

	private static final String NM_JSP_INCLUIR_ORDEM_SERVICO = "/ordemServico/adicionarOrdemServico.jsp";

	private static final String NM_JSP_ALTERAR_ORDEM_SERVICO = "/ordemServico/alterarOrdemServico.jsp";

	private static final String NM_SERVLET = ServletOrdemServico.class
			.getSimpleName();

	public static final String NM_PARAMETRO_CodigoOrdemServico = "cdOrdemServico";
	public static final String NM_PARAMETRO_PlacaMoto = "placaMoto";
	public static final String NM_PARAMETRO_Data = "data";
	public static final String NM_PARAMETRO_IndicadorOrcamento = "indicadorOrcamento";
	public static final String NM_PARAMETRO_ValorOrdemSerico = "valorOrdemServico";
	public static final String NM_PARAMETRO_Desconto = "desconto";
	public static final String NM_PARAMETRO_ArrayOrdemServico = "alOrdemServico";
	

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
				this.NM_JSP_INCLUIR_ORDEM_SERVICO);
	};

	@Override
	public void processarInclusao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String codigoOrdemServico = "";
		String placaMoto = "";
		
		// recupera os parametros do request
		codigoOrdemServico = request.getParameter(this.NM_PARAMETRO_CodigoOrdemServico);
		placaMoto = request.getParameter(this.NM_PARAMETRO_PlacaMoto);

		//monta a entidade ordem servico para incluir
		EntidadeOrdemServico eOrdemServico = new EntidadeOrdemServico();
		eOrdemServico.setCodigo(Integer.valueOf(codigoOrdemServico));
		eOrdemServico.setPlacaMoto(placaMoto);
		eOrdemServico.setData(new Date(System.currentTimeMillis()));
		eOrdemServico.setIndicadorOrcamento("S");
		eOrdemServico.setValor(new Double("0.00"));
		eOrdemServico.setDesconto(new Double("0.00"));
		
		DAOOrdemServico.incluir(eOrdemServico);
		
		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);

	};

	@Override
	public void consultarTodos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		ArrayList<EntidadeOrdemServico> alOrdemServico = new ArrayList<EntidadeOrdemServico>();
		
		// recupera os parametros do request
		String codigoOrdemServico = (String) request
				.getParameter(this.NM_PARAMETRO_CodigoOrdemServico);
		String placaMoto = (String) request.getParameter(this.NM_PARAMETRO_PlacaMoto);

		//caso o campo de pesquisa por nome seja preenchido consulta por nome
		//caso contrario consulta todos
		if(codigoOrdemServico != null && !codigoOrdemServico.equals("")){
			alOrdemServico.add(DAOOrdemServico.consultarPorCodigo(codigoOrdemServico));
		} else if(placaMoto != null && !placaMoto.equals("")){
			alOrdemServico = DAOOrdemServico.consultarPorPlacaMoto(placaMoto);
		} else {
			alOrdemServico = DAOOrdemServico.consultarTodos();
		}
		
		request.setAttribute(this.NM_PARAMETRO_ArrayOrdemServico, alOrdemServico);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
	}

	@Override
	public void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//TODO: EVENTO NAO IMPLEMENTADO NESSE SERVLET
		this.consultarTodos(request, response);
	}

	@Override
	public void exibirAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String codigoOrdemServico = "";

		// recupera os parametros do request
		codigoOrdemServico = request
				.getParameter(this.NM_PARAMETRO_CodigoOrdemServico);
		
		//consulta por codigo para recuperar os valores e setar no request				
		EntidadeOrdemServico eOrdemServico = DAOOrdemServico.consultarPorCodigo(codigoOrdemServico);
	
		//seta os atributos no request para recuperar na JSP
		request.setAttribute(this.NM_PARAMETRO_CodigoOrdemServico,
				String.valueOf(eOrdemServico.getCodigo()));
		request.setAttribute(this.NM_PARAMETRO_PlacaMoto,
				eOrdemServico.getPlacaMoto());
		request.setAttribute(this.NM_PARAMETRO_Data,
				eOrdemServico.getData().toString());
		request.setAttribute(this.NM_PARAMETRO_IndicadorOrcamento,
				eOrdemServico.getIndicadorOrcamento());
		request.setAttribute(this.NM_PARAMETRO_ValorOrdemSerico,
				eOrdemServico.getValor().toString());
		request.setAttribute(this.NM_PARAMETRO_Desconto,
				eOrdemServico.getDesconto().toString());

		this.redirecionarPagina(request, response,
				this.NM_JSP_ALTERAR_ORDEM_SERVICO);
	}

	@Override
	public void processarAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String codigoOrdemServico = "";
		String placaMoto = "";
		String indicadorOrcamento = "";
		String valorOrdemServico = "";
		String desconto = "";
		
		// recupera os parametros do request
		codigoOrdemServico = request.getParameter(this.NM_PARAMETRO_CodigoOrdemServico);
		placaMoto = request.getParameter(this.NM_PARAMETRO_PlacaMoto);
		indicadorOrcamento = request.getParameter(this.NM_PARAMETRO_IndicadorOrcamento);
		valorOrdemServico = request.getParameter(this.NM_PARAMETRO_ValorOrdemSerico);
		desconto = request.getParameter(this.NM_PARAMETRO_Desconto);

		//monta a entidade ordem servico para incluir
		EntidadeOrdemServico eOrdemServico = new EntidadeOrdemServico();
		eOrdemServico.setCodigo(Integer.valueOf(codigoOrdemServico));
		eOrdemServico.setPlacaMoto(placaMoto);
		eOrdemServico.setIndicadorOrcamento(indicadorOrcamento);
		eOrdemServico.setValor(new Double(valorOrdemServico));
		eOrdemServico.setDesconto(new Double(desconto));

		DAOOrdemServico.alterar(eOrdemServico);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
	}
	
	private String gerarNumeroOrdemServico(HttpServletRequest request,
			HttpServletResponse response, String placaMoto) {
		
		String nuOrdemServico = "";
		String dataHoje = new Date(System.currentTimeMillis()).toString();
		dataHoje = dataHoje.replace("-", "");
		
		nuOrdemServico = dataHoje + placaMoto;
		EntidadeOrdemServico eOrdemServico = DAOOrdemServico.consultarPorCodigo(nuOrdemServico);
		
		return new String("");
	}

}
