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
import br.com.rocketmotos.entidade.EntidadeCliente;
import br.com.rocketmotos.entidade.EntidadeMarcaMoto;
import br.com.rocketmotos.entidade.EntidadeModeloMoto;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends ServletGenerico {

	private static final String NM_JSP_CONSULTAR = "/cliente/consultarCliente.jsp";
	// private static final String NM_JSP_ALTERAR_MARCA_MOTO =
	// "/marcaMoto/alterarMarcaMoto.jsp";

	private static final String NM_JSP_INCLUIR_CLIENTE = "/cliente/adicionarCliente.jsp";

	private static final String NM_JSP_ALTERAR_CLIENTE = "/cliente/alterarCliente.jsp";

	private static final String NM_SERVLET = ServletCliente.class
			.getSimpleName();

	public static final String NM_PARAMETRO_NumeroDocumentoCliente = "nuDocumentoCliente";
	public static final String NM_PARAMETRO_NomeCliente = "nmCliente";
	public static final String NM_PARAMETRO_Endereco = "endereco";
	public static final String NM_PARAMETRO_Telefone = "telefone";
	public static final String NM_PARAMETRO_TipoCliente = "tpCliente";
	public static final String NM_PARAMETRO_ArrayCliente = "alCliente";

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
				this.NM_JSP_INCLUIR_CLIENTE);
	};

	@Override
	public void processarInclusao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String nuDocumentoCliente = "";
		String nomeCliente = "";
		String endereco = "";
		String telefone = "";
		String tipoCliente = "";

		// recupera os parametros do request
		nuDocumentoCliente = request.getParameter(this.NM_PARAMETRO_NumeroDocumentoCliente);
		nomeCliente = request.getParameter(this.NM_PARAMETRO_NomeCliente);
		endereco = request
				.getParameter(this.NM_PARAMETRO_Endereco);
		telefone = request.getParameter(this.NM_PARAMETRO_Telefone);
		tipoCliente = request.getParameter(this.NM_PARAMETRO_TipoCliente);

		EntidadeCliente eCliente = new EntidadeCliente();
		eCliente.setDocumento(nuDocumentoCliente);
		eCliente.setNome(nomeCliente);
		eCliente.setEndereco(endereco);
		eCliente.setTelefone(telefone);
		eCliente.setTipoCliente(tipoCliente);
		
		DAOCliente.incluir(eCliente);
		
		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);

	};

	@Override
	public void consultarTodos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String nuDocumentoCliente = "";
		String nomeCliente = "";
		ArrayList<EntidadeCliente> alCliente;
		
		// recupera os parametros do request
		nuDocumentoCliente = request.getParameter(this.NM_PARAMETRO_NumeroDocumentoCliente);
		nomeCliente = request.getParameter(this.NM_PARAMETRO_NomeCliente);
		
		
		if(nuDocumentoCliente != null && !nuDocumentoCliente.equals("")){
			alCliente = DAOCliente.consultarPorDocumento(nuDocumentoCliente);
		} else if(nomeCliente != null && !nomeCliente.equals("")){
			alCliente = DAOCliente.consultarPorNome(nomeCliente);
		} else {
			alCliente = DAOCliente.consultarTodos();
		}
		
		request.setAttribute(this.NM_PARAMETRO_ArrayCliente, alCliente);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
	}

	@Override
	public void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// declara as variaveis
		String nuDocumentoCliente = "";

		// recupera os parametros do request
		nuDocumentoCliente = request
				.getParameter(this.NM_PARAMETRO_NumeroDocumentoCliente);

		if (nuDocumentoCliente != null && !nuDocumentoCliente.equals("")) {
			DAOCliente.excluir(nuDocumentoCliente);
		}

		this.consultarTodos(request, response);
	}

	@Override
	public void exibirAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String nuDocumentoCliente = "";
		ArrayList<EntidadeCliente> alCliente;
		EntidadeCliente eCliente;
		
		// recupera os parametros do request
		nuDocumentoCliente = request
				.getParameter(this.NM_PARAMETRO_NumeroDocumentoCliente);

		//consulta o cliente por numero de documento para excluir
		alCliente = DAOCliente.consultarPorDocumento(nuDocumentoCliente);
		eCliente = alCliente.get(0);

		request.setAttribute(this.NM_PARAMETRO_NumeroDocumentoCliente, eCliente.getDocumento());
		request.setAttribute(this.NM_PARAMETRO_NomeCliente, eCliente.getNome());
		request.setAttribute(this.NM_PARAMETRO_Endereco, eCliente.getEndereco());
		request.setAttribute(this.NM_PARAMETRO_Telefone, eCliente.getTelefone());
		request.setAttribute(this.NM_PARAMETRO_TipoCliente, eCliente.getTipoCliente());

		this.redirecionarPagina(request, response,
				this.NM_JSP_ALTERAR_CLIENTE);
	}

	@Override
	public void processarAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// declara as variaveis
		String nuDocumentoCliente = "";
		String nomeCliente = "";
		String endereco = "";
		String telefone = "";
		String tipoCliente = "";

		// recupera os parametros do request
		nuDocumentoCliente = request.getParameter(this.NM_PARAMETRO_NumeroDocumentoCliente);
		nomeCliente = request.getParameter(this.NM_PARAMETRO_NomeCliente);
		endereco = request
				.getParameter(this.NM_PARAMETRO_Endereco);
		telefone = request.getParameter(this.NM_PARAMETRO_Telefone);
		tipoCliente = request.getParameter(this.NM_PARAMETRO_TipoCliente);

		//monta entidadeCliente para poder alterar
		EntidadeCliente eCliente = new EntidadeCliente();
		eCliente.setDocumento(nuDocumentoCliente);
		eCliente.setNome(nomeCliente);
		eCliente.setEndereco(endereco);
		eCliente.setTelefone(telefone);
		eCliente.setTipoCliente(tipoCliente);
		
		//altera os dados do cliente
		DAOCliente.alterar(eCliente);

		this.redirecionarPagina(request, response, this.NM_JSP_CONSULTAR);
	}

}
