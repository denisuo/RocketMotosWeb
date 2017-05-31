package br.com.rocketmotos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.rocketmotos.entidade.EntidadeCategoriaProduto;
import br.com.rocketmotos.entidade.EntidadeItemOrdemServico;
import br.com.rocketmotos.entidade.EntidadeProduto;
import br.com.rocketmotos.entidade.EntidadeServico;

public class DAOItemOrdemServico extends Conexao {

	private static String NM_ENTIDADE = DAOItemOrdemServico.class
			.getSimpleName();

	public DAOItemOrdemServico() {

	}

	public static void incluir(EntidadeItemOrdemServico eItemOrdemServico) {

		//monta sql
		String sql = "INSERT INTO " + EntidadeItemOrdemServico.NM_TABELA + " ("
				+ EntidadeItemOrdemServico.NM_COL_CodigoOrdemServico + ", "
				+ EntidadeItemOrdemServico.NM_COL_CodigoProduto + ", "
				+ EntidadeItemOrdemServico.NM_COL_CodigoServico + ", "
				+ EntidadeItemOrdemServico.NM_COL_QtdProdutoUtilizado
				+ ") values (" + eItemOrdemServico.getCodigoOrdemServico()
				+ ",'" + eItemOrdemServico.getCodigoProduto() + "',"
				+ eItemOrdemServico.getCodigoServico() + ","
				+ eItemOrdemServico.getQtdProdutoUtilizado() + ")";

		// eItemOrdemServico.getDocumento()
		//prepara sql
		PreparedStatement stmt = getPreparedStatement(sql);
		try {
			//executa sql
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir em " + NM_ENTIDADE);
		}
	}

	public static void alterar(EntidadeItemOrdemServico eItemOrdemServico) {

		//monta sql para ser executado
		String sql = "UPDATE " + EntidadeItemOrdemServico.NM_TABELA + " SET "
				+ EntidadeItemOrdemServico.NM_COL_QtdProdutoUtilizado + " = "
				+ eItemOrdemServico.getQtdProdutoUtilizado() + " WHERE "
				+ EntidadeItemOrdemServico.NM_COL_CodigoOrdemServico + " = "
				+ eItemOrdemServico.getCodigoOrdemServico() + " AND "
				+ EntidadeItemOrdemServico.NM_COL_CodigoProduto + " = "
				+ eItemOrdemServico.getCodigoProduto() + " AND "
				+ EntidadeItemOrdemServico.NM_COL_CodigoServico + " = "
				+ eItemOrdemServico.getCodigoServico();

		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao alterar em " + NM_ENTIDADE);
		}
	}

	//exclui unico item
	public static void excluirUnicoItem(Integer codigoOrdemServico,
			String codigoProduto, Integer codigoServico) {

		//monta sql para ser executado
		String sql = "DELETE FROM " + EntidadeItemOrdemServico.NM_TABELA
				+ " WHERE "
				+ EntidadeItemOrdemServico.NM_COL_CodigoOrdemServico + " = "
				+ codigoOrdemServico + " AND "
				+ EntidadeItemOrdemServico.NM_COL_CodigoProduto + " = '"
				+ codigoProduto + "' AND "
				+ EntidadeItemOrdemServico.NM_COL_CodigoServico + " = "
				+ codigoServico;

		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao excluir em " + NM_ENTIDADE);
		}
	}

	//metodo responsavel por exlcuir todos os Itens por numero de ordem de serviço
	public static void excluirTodosItensPorOrdemServico(
			Integer codigoOrdemServico) {

		//monta sql para ser executado
		String sql = "DELETE FROM " + EntidadeItemOrdemServico.NM_TABELA
				+ " WHERE "
				+ EntidadeItemOrdemServico.NM_COL_CodigoOrdemServico + " = "
				+ codigoOrdemServico;

		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao excluir em " + NM_ENTIDADE);
		}
	}

	//consulta todos os itens por codigo de ordem de serviço
	public static ArrayList<EntidadeItemOrdemServico> consultarTodosItensPorOrdemServico(
			Integer codigoOrdemServico) {

		//monta select
		String sql = "SELECT * FROM " + EntidadeItemOrdemServico.NM_TABELA
				+ " WHERE "
				+ EntidadeItemOrdemServico.NM_COL_CodigoOrdemServico + " = "
				+ codigoOrdemServico;

		//cria uma lista de retorno
		ArrayList<EntidadeItemOrdemServico> listaRetorno = new ArrayList<EntidadeItemOrdemServico>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			//itera o result set para montar a colecao de retorno
			while (rs.next()) {
				EntidadeItemOrdemServico eItemOrdemServico = new EntidadeItemOrdemServico();
				eItemOrdemServico
						.setCodigoOrdemServico(Integer.valueOf(rs
								.getString(EntidadeItemOrdemServico.NM_COL_CodigoOrdemServico)));
				eItemOrdemServico
						.setCodigoProduto(rs
								.getString(EntidadeItemOrdemServico.NM_COL_CodigoProduto));
				eItemOrdemServico
						.setCodigoServico(Integer.valueOf(rs
								.getString(EntidadeItemOrdemServico.NM_COL_CodigoServico)));
				eItemOrdemServico
						.setQtdProdutoUtilizado(Integer.valueOf(rs
								.getString(EntidadeItemOrdemServico.NM_COL_QtdProdutoUtilizado)));

				//adiciona o itemOrdemServico na colecao de retorno
				listaRetorno.add(eItemOrdemServico);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}
	
	//consulta todos os itens de uma ordem de servico com inner join em produto, categoria produto e serviço
	public static ResultSet consultarTodosPorCodigoOrdem(
			Integer codigoOrdemServico) {

		//monta select
		String sql = "SELECT " + EntidadeItemOrdemServico.NM_TABELA +".* , "
				+ EntidadeProduto.NM_TABELA + ".* , " + EntidadeCategoriaProduto.NM_TABELA + ".* ,"
				+ EntidadeServico.NM_TABELA + ".* "
				+ "FROM " + EntidadeItemOrdemServico.NM_TABELA
				
				+ "\n INNER JOIN " + EntidadeProduto.NM_TABELA + " ON(" + EntidadeProduto.NM_TABELA + "."
				+ EntidadeProduto.NM_COL_CodigoProduto + " = " + EntidadeItemOrdemServico.NM_TABELA + "."
						+ EntidadeItemOrdemServico.NM_COL_CodigoProduto + ")"
				
				+ "\n INNER JOIN " + EntidadeCategoriaProduto.NM_TABELA + " ON(" + EntidadeCategoriaProduto.NM_TABELA + "."
				+ EntidadeCategoriaProduto.NM_COL_CodigoCategoriaProduto + " = " + EntidadeProduto.NM_TABELA + "."
						+ EntidadeProduto.NM_COL_CodigoCategoriaProduto + ")"
						
				+ "\n INNER JOIN " + EntidadeServico.NM_TABELA + " ON(" + EntidadeServico.NM_TABELA + "."
				+ EntidadeServico.NM_COL_CodigoServico + " = " + EntidadeItemOrdemServico.NM_TABELA + "."
						+ EntidadeItemOrdemServico.NM_COL_CodigoServico + ")"						
						
				+ "\n WHERE "
				+ EntidadeItemOrdemServico.NM_COL_CodigoOrdemServico + " = "
				+ codigoOrdemServico;

		//prepara sql e executa retornando um resultset
		PreparedStatement stmt = getPreparedStatement(sql);
		ResultSet rs = null;
		try {
			//retorna o result set completo
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return rs;
	}
	
	//consulta por codigo
	public static EntidadeItemOrdemServico consultarUnicoItem(Integer codigoOrdemServico,
			String codigoProduto, Integer codigoServico) {

		//monta select 
		String sql = "SELECT * FROM " + EntidadeItemOrdemServico.NM_TABELA
				+ " WHERE "
				+ EntidadeItemOrdemServico.NM_COL_CodigoOrdemServico + " = "
				+ codigoOrdemServico + " AND "
				+ EntidadeItemOrdemServico.NM_COL_CodigoProduto + " = '"
				+ codigoProduto + "' AND "
				+ EntidadeItemOrdemServico.NM_COL_CodigoServico + " = "
				+ codigoServico;

		PreparedStatement stmt = getPreparedStatement(sql);
		EntidadeItemOrdemServico eItemOrdemServico = new EntidadeItemOrdemServico();

		try {
			ResultSet rs = stmt.executeQuery();
			//itera o result set para montar a entidade de retorno
			while (rs.next()) {
				eItemOrdemServico
						.setCodigoOrdemServico(Integer.valueOf(rs
								.getString(EntidadeItemOrdemServico.NM_COL_CodigoOrdemServico)));
				eItemOrdemServico
						.setCodigoProduto(rs
								.getString(EntidadeItemOrdemServico.NM_COL_CodigoProduto));
				eItemOrdemServico
						.setCodigoServico(Integer.valueOf(rs
								.getString(EntidadeItemOrdemServico.NM_COL_CodigoServico)));
				eItemOrdemServico
						.setQtdProdutoUtilizado(Integer.valueOf(rs
								.getString(EntidadeItemOrdemServico.NM_COL_QtdProdutoUtilizado)));
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}
		
		return eItemOrdemServico;
		
	}

}
