package br.com.rocketmotos.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletGenerico
 */
@WebServlet("/ServletGenerico")
public abstract class ServletGenerico extends HttpServlet {

	public static final String NM_EVENTO = "evento";
	public static final String NM_EVENTO_INCLUIR = "incluir";
	public static final String NM_EVENTO_EXIBIR_ALTERACAO = "exibirAlteracao";
	public static final String NM_EVENTO_PROCESSAR_ALTERACAO = "processarAlteracao";
<<<<<<< HEAD
	public static final String NM_EVENTO_EXCLUIR = "excluir";
=======
	public static final String NM_EVENTO_EXCLUIR = "exlcuir";
>>>>>>> origin/master
	public static final String NM_EVENTO_CONSULTAR_TODOS = "consultarTodos";

	protected abstract void incluir(HttpServletRequest request,
			HttpServletResponse response) throws ServletException;

	public abstract void exibirAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException;
	
	public abstract void processarAlteracao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException;

	public abstract void excluir(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException;

	public abstract void consultarTodos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException;

	public void redirecionarPagina(HttpServletRequest request,
			HttpServletResponse response, String nomeJsp)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(nomeJsp);
		dispatcher.forward(request, response);
	}

}
