package br.com.rocketmotos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.rocketmotos.entidade.EntidadeMarcaMoto;

public class MarcaMotoDAO extends Conexao {

	public MarcaMotoDAO() {

	}

	public static boolean incluir(EntidadeMarcaMoto eMarcaMoto) {
		boolean retorno = false;

		String sql = "INSERT INTO " + EntidadeMarcaMoto.NM_TABELA + " ("
				+ EntidadeMarcaMoto.NM_COL_Nome + ") values ('"
				+ eMarcaMoto.getNome() + "')";
		PreparedStatement stmt = getPreparedStatement(sql);

		// String sql = "INSERT INTO " + EntidadeMarcaMoto.NM_TABELA + " ("
		// + EntidadeMarcaMoto.NM_COL_Nome + ") values (?)";
		try {
			// stmt.setString(1, marcaMoto.getNome());

			if (stmt.executeUpdate() == 0) {
				retorno = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao inserir em "
					+ EntidadeMarcaMoto.NM_TABELA);
		}

		return retorno;
	}

	public static boolean alterar(EntidadeMarcaMoto eMarcaMoto) {
		boolean retorno = false;

		String sql = "UPDATE " + EntidadeMarcaMoto.NM_TABELA + " SET "
				+ EntidadeMarcaMoto.NM_COL_Nome + " = '" + eMarcaMoto.getNome()
				+ "' WHERE " + EntidadeMarcaMoto.NM_COL_CodigoMarcaMoto + " = "
				+ eMarcaMoto.getCodigo();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			// stmt.setString(s);

			if (stmt.executeUpdate() == 0) {
				retorno = true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao alterar em "
					+ EntidadeMarcaMoto.NM_TABELA);
		}

		return retorno;
	}

	public boolean excluir(EntidadeMarcaMoto eMarcaMoto) {
		boolean retorno = false;

		String sql = "DELETE FROM " + EntidadeMarcaMoto.NM_TABELA + " WHERE "
				+ EntidadeMarcaMoto.NM_COL_CodigoMarcaMoto + " = "
				+ eMarcaMoto.getCodigo();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			if (stmt.executeUpdate() == 0) {
				retorno = true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao excluir em "
					+ EntidadeMarcaMoto.NM_TABELA);
		}

		return retorno;
	}

	public static ArrayList<EntidadeMarcaMoto> consultarTodos() {

		String sql = "SELECT * FROM " + EntidadeMarcaMoto.NM_TABELA;
		ArrayList<EntidadeMarcaMoto> listaRetorno = new ArrayList<EntidadeMarcaMoto>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeMarcaMoto marcaMoto = new EntidadeMarcaMoto();
				marcaMoto.setCodigo(Integer.valueOf(rs
						.getString(EntidadeMarcaMoto.NM_COL_CodigoMarcaMoto)));
				marcaMoto.setNome(rs.getString(EntidadeMarcaMoto.NM_COL_Nome));

				listaRetorno.add(marcaMoto);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em ");
		}

		return listaRetorno;
	}

	public static ArrayList<EntidadeMarcaMoto> consultarPorCodigo(
			Integer codigoMarcaMoto) {

		String sql = "SELECT * FROM " + EntidadeMarcaMoto.NM_TABELA + " WHERE "
				+ EntidadeMarcaMoto.NM_COL_CodigoMarcaMoto + " = "
				+ codigoMarcaMoto;
		ArrayList<EntidadeMarcaMoto> listaRetorno = new ArrayList<EntidadeMarcaMoto>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeMarcaMoto marcaMoto = new EntidadeMarcaMoto();
				marcaMoto.setCodigo(Integer.valueOf(rs
						.getString(EntidadeMarcaMoto.NM_COL_CodigoMarcaMoto)));
				marcaMoto.setNome(rs.getString(EntidadeMarcaMoto.NM_COL_Nome));

				listaRetorno.add(marcaMoto);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em ");
		}

		return listaRetorno;
	}

	public static ArrayList<EntidadeMarcaMoto> consultarPorNome(String nome) {

		String sql = "SELECT * FROM " + EntidadeMarcaMoto.NM_TABELA + " WHERE "
				+ EntidadeMarcaMoto.NM_COL_Nome + " LIKE '%" + nome + "%'";
		ArrayList<EntidadeMarcaMoto> listaRetorno = new ArrayList<EntidadeMarcaMoto>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeMarcaMoto marcaMoto = new EntidadeMarcaMoto();
				marcaMoto.setCodigo(Integer.valueOf(rs
						.getString(EntidadeMarcaMoto.NM_COL_CodigoMarcaMoto)));
				marcaMoto.setNome(rs.getString(EntidadeMarcaMoto.NM_COL_Nome));

				listaRetorno.add(marcaMoto);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em ");
		}

		return listaRetorno;
	}

}
