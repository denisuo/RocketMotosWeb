package br.com.rocketmotos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.rocketmotos.entidade.EntidadeServico;

public class DAOServico extends Conexao {

	private static String NM_ENTIDADE = DAOServico.class.getSimpleName();

	public DAOServico() {

	}

	public static void incluir(EntidadeServico eServico) {

		String sql = "INSERT INTO " + EntidadeServico.NM_TABELA + " ("
				+ EntidadeServico.NM_COL_CodigoServico + ", "
				+ EntidadeServico.NM_COL_Nome + ", "
				+ EntidadeServico.NM_COL_Descricao + ", "
				+ EntidadeServico.NM_COL_Valor + ") values ("
				+ eServico.getCodigoServico() + ",'" + eServico.getNome()
				+ "','" + eServico.getDescricao() + "'," + eServico.getValor()
				+ ")";

		// eServico.getDocumento()
		PreparedStatement stmt = getPreparedStatement(sql);
		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir em " + NM_ENTIDADE);
		}
	}

	public static void alterar(EntidadeServico eServico) {

		String sql = "UPDATE " + EntidadeServico.NM_TABELA + " SET "
				+ EntidadeServico.NM_COL_Nome + " = '" + eServico.getNome()
				+ "', " + EntidadeServico.NM_COL_Descricao + " = '"
				+ eServico.getDescricao() + "', "
				+ EntidadeServico.NM_COL_Valor + " = " + eServico.getValor()
				+ " WHERE " + EntidadeServico.NM_COL_CodigoServico + " = "
				+ eServico.getCodigoServico();

		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao alterar em " + NM_ENTIDADE);
		}
	}

	public static void excluir(Integer codigoServico) {

		String sql = "DELETE FROM " + EntidadeServico.NM_TABELA + " WHERE "
				+ EntidadeServico.NM_COL_CodigoServico + " = " + codigoServico;
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao excluir em " + NM_ENTIDADE);
		}
	}

	public static ArrayList<EntidadeServico> consultarTodos() {

		String sql = "SELECT * FROM " + EntidadeServico.NM_TABELA;
		ArrayList<EntidadeServico> listaRetorno = new ArrayList<EntidadeServico>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeServico eServico = new EntidadeServico();
				eServico.setCodigoServico(Integer.valueOf(rs
						.getString(EntidadeServico.NM_COL_CodigoServico)));
				eServico.setNome(rs.getString(EntidadeServico.NM_COL_Nome));
				eServico.setDescricao(rs
						.getString(EntidadeServico.NM_COL_Descricao));
				eServico.setValor(Double.valueOf(rs
						.getString(EntidadeServico.NM_COL_Valor)));

				listaRetorno.add(eServico);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

	public static ArrayList<EntidadeServico> consultarPorCodigo(
			String codigoServico) {

		String sql = "SELECT * FROM " + EntidadeServico.NM_TABELA + " WHERE "
				+ EntidadeServico.NM_COL_CodigoServico + " = " + codigoServico;

		ArrayList<EntidadeServico> listaRetorno = new ArrayList<EntidadeServico>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeServico eServico = new EntidadeServico();
				eServico.setCodigoServico(Integer.valueOf(rs
						.getString(EntidadeServico.NM_COL_CodigoServico)));
				eServico.setNome(rs.getString(EntidadeServico.NM_COL_Nome));
				eServico.setDescricao(rs
						.getString(EntidadeServico.NM_COL_Descricao));
				eServico.setValor(Double.valueOf(rs
						.getString(EntidadeServico.NM_COL_Valor)));

				listaRetorno.add(eServico);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

	public static ArrayList<EntidadeServico> consultarPorNomeServico(
			String nomeServico) {

		String sql = "SELECT * FROM " + EntidadeServico.NM_TABELA + " WHERE "
				+ EntidadeServico.NM_COL_Nome + " LIKE '%" + nomeServico + "%'";

		ArrayList<EntidadeServico> listaRetorno = new ArrayList<EntidadeServico>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeServico eServico = new EntidadeServico();
				eServico.setCodigoServico(Integer.valueOf(rs
						.getString(EntidadeServico.NM_COL_CodigoServico)));
				eServico.setNome(rs.getString(EntidadeServico.NM_COL_Nome));
				eServico.setDescricao(rs
						.getString(EntidadeServico.NM_COL_Descricao));
				eServico.setValor(Double.valueOf(rs
						.getString(EntidadeServico.NM_COL_Valor)));

				listaRetorno.add(eServico);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

}
