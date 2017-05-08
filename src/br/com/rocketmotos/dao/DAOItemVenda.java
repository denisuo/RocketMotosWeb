package br.com.rocketmotos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.rocketmotos.entidade.EntidadeItemVenda;

public class DAOItemVenda extends Conexao {

	private static String NM_ENTIDADE = DAOItemVenda.class.getSimpleName();

	public DAOItemVenda() {

	}

	public static void incluir(EntidadeItemVenda eItemVenda) {

		String sql = "INSERT INTO " + EntidadeItemVenda.NM_TABELA + " ("
				+ EntidadeItemVenda.NM_COL_CodigoVenda + ", "
				+ EntidadeItemVenda.NM_COL_CodigoProduto + ", "
				+ EntidadeItemVenda.NM_COL_Quantidade + ") values ("
				+ eItemVenda.getCodigoVenda() + ",'"
				+ eItemVenda.getCodigoProduto() + "'," + eItemVenda.getQtd()
				+ ")";

		// eItemVenda.getDocumento()
		PreparedStatement stmt = getPreparedStatement(sql);
		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir em " + NM_ENTIDADE);
		}
	}

	public static void alterar(EntidadeItemVenda eItemVenda) {

		String sql = "UPDATE " + EntidadeItemVenda.NM_TABELA + " SET "
				+ EntidadeItemVenda.NM_COL_Quantidade + " = "
				+ eItemVenda.getQtd() + " WHERE "
				+ EntidadeItemVenda.NM_COL_CodigoVenda + " = "
				+ eItemVenda.getCodigoVenda() + " AND "
				+ EntidadeItemVenda.NM_COL_CodigoProduto + " = "
				+ eItemVenda.getCodigoProduto() + " AND "
				+ EntidadeItemVenda.NM_COL_CodigoProduto;

		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao alterar em " + NM_ENTIDADE);
		}
	}

	public static void excluirUnicoItem(Integer codigoVenda,
			String codigoProduto) {

		String sql = "DELETE FROM " + EntidadeItemVenda.NM_TABELA + " WHERE "
				+ EntidadeItemVenda.NM_COL_CodigoVenda + " = " + codigoVenda
				+ " AND " + EntidadeItemVenda.NM_COL_CodigoProduto + " = "
				+ codigoProduto;

		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao excluir em " + NM_ENTIDADE);
		}
	}

	public static void excluirTodosItensPorVenda(Integer codigoVenda) {

		String sql = "DELETE FROM " + EntidadeItemVenda.NM_TABELA + " WHERE "
				+ EntidadeItemVenda.NM_COL_CodigoVenda + " = " + codigoVenda;

		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao excluir em " + NM_ENTIDADE);
		}
	}

	public static ArrayList<EntidadeItemVenda> consultarTodosItensPorVenda(
			Integer codigoVenda) {

		String sql = "SELECT * FROM " + EntidadeItemVenda.NM_TABELA + " WHERE "
				+ EntidadeItemVenda.NM_COL_CodigoVenda + " = " + codigoVenda;

		ArrayList<EntidadeItemVenda> listaRetorno = new ArrayList<EntidadeItemVenda>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeItemVenda eItemVenda = new EntidadeItemVenda();
				eItemVenda.setCodigoVenda(Integer.valueOf(rs
						.getString(EntidadeItemVenda.NM_COL_CodigoVenda)));
				eItemVenda.setCodigoProduto(rs
						.getString(EntidadeItemVenda.NM_COL_CodigoProduto));
				eItemVenda.setQtd(Integer.valueOf(rs
						.getString(EntidadeItemVenda.NM_COL_Quantidade)));

				listaRetorno.add(eItemVenda);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

}
