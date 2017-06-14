package br.com.rocketmotos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.rocketmotos.entidade.EntidadeCategoriaProduto;

public class DAOCategoriaProduto extends Conexao {

	private static String NM_ENTIDADE = DAOCategoriaProduto.class
			.getSimpleName();

	public DAOCategoriaProduto() {

	}

	public static void incluir(EntidadeCategoriaProduto eCategoriaProduto) {

		//monta SQL para inserir em CATEGORIA_PRODUTO
		String sql = "INSERT INTO " + EntidadeCategoriaProduto.NM_TABELA + " ("
				+ EntidadeCategoriaProduto.NM_COL_Nome + ", "
				+ EntidadeCategoriaProduto.NM_COL_Descricao + ") values ('"
				+ eCategoriaProduto.getNome() + "', '"
				+ eCategoriaProduto.getDescricao() + "')";
		
		//prepara SQL
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			//executa SQL
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir em " + NM_ENTIDADE);
		}
	}

	public static void alterar(EntidadeCategoriaProduto eCategoriaProduto) {

		//monta SQL para alterar em CATEGORIA_PRODUTO
		String sql = "UPDATE " + EntidadeCategoriaProduto.NM_TABELA + " SET "
				+ EntidadeCategoriaProduto.NM_COL_Nome + " = '"
				+ eCategoriaProduto.getNome() + "', "
				+ EntidadeCategoriaProduto.NM_COL_Descricao + " = '"
				+ eCategoriaProduto.getDescricao() + "' WHERE "
				+ EntidadeCategoriaProduto.NM_COL_CodigoCategoriaProduto
				+ " = " + eCategoriaProduto.getCodigo();
		
		//prepara SQL
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			//executa SQL
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao alterar em " + NM_ENTIDADE);
		}
	}

	public static void excluir(Integer codigoCategoriaProduto) {

		//monta SQL para excluir em CATEGORIA_PRODUTO
		String sql = "DELETE FROM " + EntidadeCategoriaProduto.NM_TABELA
				+ " WHERE "
				+ EntidadeCategoriaProduto.NM_COL_CodigoCategoriaProduto
				+ " = " + codigoCategoriaProduto;
		
		//prepara SQL
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			//executa SQL
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao excluir em " + NM_ENTIDADE);
		}
	}

	public static ArrayList<EntidadeCategoriaProduto> consultarTodos() {

		//monta SQL de consulta 
		String sql = "SELECT * FROM " + EntidadeCategoriaProduto.NM_TABELA;
		ArrayList<EntidadeCategoriaProduto> listaRetorno = new ArrayList<EntidadeCategoriaProduto>();
		
		//prepara SQL
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			//recupera o result set e itera a resposta para montar a lista de retorno
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeCategoriaProduto eCategoriaProduto = new EntidadeCategoriaProduto();
				eCategoriaProduto
						.setCodigo(Integer.valueOf(rs
								.getString(EntidadeCategoriaProduto.NM_COL_CodigoCategoriaProduto)));
				eCategoriaProduto.setNome(rs
						.getString(EntidadeCategoriaProduto.NM_COL_Nome));
				eCategoriaProduto.setDescricao(rs
						.getString(EntidadeCategoriaProduto.NM_COL_Descricao));

				listaRetorno.add(eCategoriaProduto);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

	public static ArrayList<EntidadeCategoriaProduto> consultarPorCodigo(
			Integer codigoCategoriaProduto) {

		//monta SQL de consulta por codigo 
		String sql = "SELECT * FROM " + EntidadeCategoriaProduto.NM_TABELA
				+ " WHERE "
				+ EntidadeCategoriaProduto.NM_COL_CodigoCategoriaProduto
				+ " = " + codigoCategoriaProduto;
		ArrayList<EntidadeCategoriaProduto> listaRetorno = new ArrayList<EntidadeCategoriaProduto>();
		
		//prepara SQL
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			//executa SQL,  recupera o result set e itera a resposta para montar a lista de retorno
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeCategoriaProduto eCategoriaProduto = new EntidadeCategoriaProduto();
				eCategoriaProduto
						.setCodigo(Integer.valueOf(rs
								.getString(EntidadeCategoriaProduto.NM_COL_CodigoCategoriaProduto)));
				eCategoriaProduto.setNome(rs
						.getString(EntidadeCategoriaProduto.NM_COL_Nome));
				eCategoriaProduto.setDescricao(rs
						.getString(EntidadeCategoriaProduto.NM_COL_Descricao));

				listaRetorno.add(eCategoriaProduto);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}
	
	public static ArrayList<EntidadeCategoriaProduto> consultarPorNome(
			String nomeCategoria) {
		//monta SQL de consulta por nome da categoria
		String sql = "SELECT * FROM " + EntidadeCategoriaProduto.NM_TABELA
				+ " WHERE "
				+ EntidadeCategoriaProduto.NM_COL_Nome
				+ " LIKE '%" + nomeCategoria + "%'";
		ArrayList<EntidadeCategoriaProduto> listaRetorno = new ArrayList<EntidadeCategoriaProduto>();
		
		//prepara sql
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			//executa SQL,  recupera o result set e itera a resposta para montar a lista de retorno
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeCategoriaProduto eCategoriaProduto = new EntidadeCategoriaProduto();
				eCategoriaProduto
						.setCodigo(Integer.valueOf(rs
								.getString(EntidadeCategoriaProduto.NM_COL_CodigoCategoriaProduto)));
				eCategoriaProduto.setNome(rs
						.getString(EntidadeCategoriaProduto.NM_COL_Nome));
				eCategoriaProduto.setDescricao(rs
						.getString(EntidadeCategoriaProduto.NM_COL_Descricao));

				listaRetorno.add(eCategoriaProduto);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}
}
