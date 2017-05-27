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

		String sql = "INSERT INTO " + EntidadeCategoriaProduto.NM_TABELA + " ("
				+ EntidadeCategoriaProduto.NM_COL_Nome + ", "
				+ EntidadeCategoriaProduto.NM_COL_Descricao + ") values ('"
				+ eCategoriaProduto.getNome() + "', '"
				+ eCategoriaProduto.getDescricao() + "')";
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir em " + NM_ENTIDADE);
		}
	}

	public static void alterar(EntidadeCategoriaProduto eCategoriaProduto) {

		String sql = "UPDATE " + EntidadeCategoriaProduto.NM_TABELA + " SET "
				+ EntidadeCategoriaProduto.NM_COL_Nome + " = '"
				+ eCategoriaProduto.getNome() + "', "
				+ EntidadeCategoriaProduto.NM_COL_Descricao + " = '"
				+ eCategoriaProduto.getDescricao() + "' WHERE "
				+ EntidadeCategoriaProduto.NM_COL_CodigoCategoriaProduto
				+ " = " + eCategoriaProduto.getCodigo();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao alterar em " + NM_ENTIDADE);
		}
	}

	public static void excluir(Integer codigoCategoriaProduto) {

		String sql = "DELETE FROM " + EntidadeCategoriaProduto.NM_TABELA
				+ " WHERE "
				+ EntidadeCategoriaProduto.NM_COL_CodigoCategoriaProduto
				+ " = " + codigoCategoriaProduto;
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao excluir em " + NM_ENTIDADE);
		}
	}

	public static ArrayList<EntidadeCategoriaProduto> consultarTodos() {

		String sql = "SELECT * FROM " + EntidadeCategoriaProduto.NM_TABELA;
		ArrayList<EntidadeCategoriaProduto> listaRetorno = new ArrayList<EntidadeCategoriaProduto>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
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

		String sql = "SELECT * FROM " + EntidadeCategoriaProduto.NM_TABELA
				+ " WHERE "
				+ EntidadeCategoriaProduto.NM_COL_CodigoCategoriaProduto
				+ " = " + codigoCategoriaProduto;
		ArrayList<EntidadeCategoriaProduto> listaRetorno = new ArrayList<EntidadeCategoriaProduto>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
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

		String sql = "SELECT * FROM " + EntidadeCategoriaProduto.NM_TABELA
				+ " WHERE "
				+ EntidadeCategoriaProduto.NM_COL_Nome
				+ " LIKE '%" + nomeCategoria + "%'";
		ArrayList<EntidadeCategoriaProduto> listaRetorno = new ArrayList<EntidadeCategoriaProduto>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
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
