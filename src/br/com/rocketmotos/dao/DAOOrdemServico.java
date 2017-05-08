package br.com.rocketmotos.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.rocketmotos.entidade.EntidadeOrdemServico;

public class DAOOrdemServico extends Conexao {

	private static String NM_ENTIDADE = DAOOrdemServico.class.getSimpleName();

	public DAOOrdemServico() {

	}

	public static void incluir(EntidadeOrdemServico eOrdemServico) {

		String sql = "INSERT INTO " + EntidadeOrdemServico.NM_TABELA + " ("
				+ EntidadeOrdemServico.NM_COL_CodigoOrdemServico + ", "
				+ EntidadeOrdemServico.NM_COL_PlacaMoto + ", "
				+ EntidadeOrdemServico.NM_COL_Data + ", "
				+ EntidadeOrdemServico.NM_COL_IndicadorOrcamento + ", "
				+ EntidadeOrdemServico.NM_COL_Valor + ", "
				+ EntidadeOrdemServico.NM_COL_Desconto + ") values ("
				+ eOrdemServico.getCodigo() + ",'"
				+ eOrdemServico.getPlacaMoto() + "','"
				+ eOrdemServico.getData() + "','"
				+ eOrdemServico.getIndicadorOrcamento() + "',"
				+ eOrdemServico.getValor() + "," + eOrdemServico.getDesconto()
				+ ")";
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir em " + NM_ENTIDADE);
		}
	}

	public static void alterar(EntidadeOrdemServico eOrdemServico) {

		String sql = "UPDATE " + EntidadeOrdemServico.NM_TABELA + " SET "
				+ EntidadeOrdemServico.NM_COL_Data + " = '"
				+ eOrdemServico.getData() + "', "
				+ EntidadeOrdemServico.NM_COL_IndicadorOrcamento + " = '"
				+ eOrdemServico.getIndicadorOrcamento() + "', "
				+ EntidadeOrdemServico.NM_COL_Valor + " = "
				+ eOrdemServico.getValor() + ", "
				+ EntidadeOrdemServico.NM_COL_Desconto + " = "
				+ eOrdemServico.getDesconto() + " WHERE "
				+ EntidadeOrdemServico.NM_COL_CodigoOrdemServico + " = "
				+ eOrdemServico.getCodigo();

		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao alterar em " + NM_ENTIDADE);
		}
	}

	public static void excluir(Integer codigoOrdemServico) {

		String sql = "DELETE FROM " + EntidadeOrdemServico.NM_TABELA
				+ " WHERE " + EntidadeOrdemServico.NM_COL_CodigoOrdemServico
				+ " = " + codigoOrdemServico;
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao excluir em " + NM_ENTIDADE);
		}
	}

	public static ArrayList<EntidadeOrdemServico> consultarTodos() {

		String sql = "SELECT * FROM " + EntidadeOrdemServico.NM_TABELA;
		ArrayList<EntidadeOrdemServico> listaRetorno = new ArrayList<EntidadeOrdemServico>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeOrdemServico eOrdemServico = new EntidadeOrdemServico();
				eOrdemServico
						.setCodigo(Integer.valueOf(rs
								.getString(EntidadeOrdemServico.NM_COL_CodigoOrdemServico)));
				eOrdemServico.setPlacaMoto(rs
						.getString(EntidadeOrdemServico.NM_COL_PlacaMoto));
				eOrdemServico.setData(Date.valueOf(rs
						.getString(EntidadeOrdemServico.NM_COL_Data)));
				eOrdemServico
						.setIndicadorOrcamento(rs
								.getString(EntidadeOrdemServico.NM_COL_IndicadorOrcamento));
				eOrdemServico.setValor(Double.valueOf(rs
						.getString(EntidadeOrdemServico.NM_COL_Valor)));
				eOrdemServico.setDesconto(Double.valueOf(rs
						.getString(EntidadeOrdemServico.NM_COL_Desconto)));

				listaRetorno.add(eOrdemServico);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

	public static ArrayList<EntidadeOrdemServico> consultarPorCodigo(
			String codigoOrdemServico) {

		String sql = "SELECT * FROM " + EntidadeOrdemServico.NM_TABELA
				+ " WHERE " + EntidadeOrdemServico.NM_COL_CodigoOrdemServico
				+ " = " + codigoOrdemServico;

		ArrayList<EntidadeOrdemServico> listaRetorno = new ArrayList<EntidadeOrdemServico>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeOrdemServico eOrdemServico = new EntidadeOrdemServico();
				eOrdemServico
						.setCodigo(Integer.valueOf(rs
								.getString(EntidadeOrdemServico.NM_COL_CodigoOrdemServico)));
				eOrdemServico.setPlacaMoto(rs
						.getString(EntidadeOrdemServico.NM_COL_PlacaMoto));
				eOrdemServico.setData(Date.valueOf(rs
						.getString(EntidadeOrdemServico.NM_COL_Data)));
				eOrdemServico
						.setIndicadorOrcamento(rs
								.getString(EntidadeOrdemServico.NM_COL_IndicadorOrcamento));
				eOrdemServico.setValor(Double.valueOf(rs
						.getString(EntidadeOrdemServico.NM_COL_Valor)));
				eOrdemServico.setDesconto(Double.valueOf(rs
						.getString(EntidadeOrdemServico.NM_COL_Desconto)));

				listaRetorno.add(eOrdemServico);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

	public static ArrayList<EntidadeOrdemServico> consultarPorPlacaMoto(
			String placaMoto) {

		String sql = "SELECT * FROM " + EntidadeOrdemServico.NM_TABELA
				+ " WHERE " + EntidadeOrdemServico.NM_COL_PlacaMoto + " = '"
				+ placaMoto + "'";

		ArrayList<EntidadeOrdemServico> listaRetorno = new ArrayList<EntidadeOrdemServico>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeOrdemServico eOrdemServico = new EntidadeOrdemServico();
				eOrdemServico
						.setCodigo(Integer.valueOf(rs
								.getString(EntidadeOrdemServico.NM_COL_CodigoOrdemServico)));
				eOrdemServico.setPlacaMoto(rs
						.getString(EntidadeOrdemServico.NM_COL_PlacaMoto));
				eOrdemServico.setData(Date.valueOf(rs
						.getString(EntidadeOrdemServico.NM_COL_Data)));
				eOrdemServico
						.setIndicadorOrcamento(rs
								.getString(EntidadeOrdemServico.NM_COL_IndicadorOrcamento));
				eOrdemServico.setValor(Double.valueOf(rs
						.getString(EntidadeOrdemServico.NM_COL_Valor)));
				eOrdemServico.setDesconto(Double.valueOf(rs
						.getString(EntidadeOrdemServico.NM_COL_Desconto)));

				listaRetorno.add(eOrdemServico);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

}