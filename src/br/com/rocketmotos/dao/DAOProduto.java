package br.com.rocketmotos.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.rocketmotos.entidade.EntidadeProduto;

public class DAOProduto extends Conexao {

	private static String NM_ENTIDADE = DAOProduto.class.getSimpleName();

	public DAOProduto() {

	}

	public static boolean incluir(EntidadeProduto eProduto) {
		boolean retorno = false;

		String sql = "INSERT INTO " + EntidadeProduto.NM_TABELA + " ("
				+ EntidadeProduto.NM_COL_CodigoProduto + ", "
				+ EntidadeProduto.NM_COL_Nome + ", "
				+ EntidadeProduto.NM_COL_Descricao + ", "
				+ EntidadeProduto.NM_COL_Validade + ", "
				+ EntidadeProduto.NM_COL_CodigoCategoriaProduto + ", "
				+ EntidadeProduto.NM_COL_Valor + ", "
				+ EntidadeProduto.NM_COL_QtdEstoque + ") values ('"
				+ eProduto.getCodigoProduto() + "','" + eProduto.getNome()
				+ "','" + eProduto.getDescricao() + "','"
				+ eProduto.getValidade() + "'," + eProduto.getCodigoCategoria()
				+ "," + eProduto.getValor() + "," + eProduto.getQuantidade()
				+ ")";

		// eProduto.getDocumento()
		PreparedStatement stmt = getPreparedStatement(sql);
		try {
			if (stmt.executeUpdate() == 0) {
				retorno = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao inserir em " + NM_ENTIDADE);
		}

		return retorno;
	}

	public static boolean alterar(EntidadeProduto eProduto) {
		boolean retorno = false;

		String sql = "UPDATE " + EntidadeProduto.NM_TABELA + " SET "
				+ EntidadeProduto.NM_COL_Nome + " = '" + eProduto.getNome()
				+ "', " + EntidadeProduto.NM_COL_Descricao + " = '"
				+ eProduto.getDescricao() + "', "
				+ EntidadeProduto.NM_COL_Validade + " = '"
				+ eProduto.getValidade() + "', "
				+ EntidadeProduto.NM_COL_CodigoCategoriaProduto + " = "
				+ eProduto.getCodigoCategoria() + ", "
				+ EntidadeProduto.NM_COL_Valor + " = " + eProduto.getValor()
				+ ", " + EntidadeProduto.NM_COL_QtdEstoque + " = "
				+ eProduto.getQuantidade() + " WHERE "
				+ EntidadeProduto.NM_COL_CodigoProduto + " = '"
				+ eProduto.getCodigoProduto() + "'";

		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			if (stmt.executeUpdate() == 0) {
				retorno = true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao alterar em " + NM_ENTIDADE);
		}

		return retorno;
	}

	public static boolean excluir(String codigoProduto) {
		boolean retorno = false;

		String sql = "DELETE FROM " + EntidadeProduto.NM_TABELA + " WHERE "
				+ EntidadeProduto.NM_COL_CodigoProduto + " = '" + codigoProduto
				+ "' ";
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			if (stmt.executeUpdate() == 0) {
				retorno = true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao excluir em " + NM_ENTIDADE);
		}

		return retorno;
	}

	public static ArrayList<EntidadeProduto> consultarTodos() {

		String sql = "SELECT * FROM " + EntidadeProduto.NM_TABELA;
		ArrayList<EntidadeProduto> listaRetorno = new ArrayList<EntidadeProduto>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeProduto eProduto = new EntidadeProduto();
				eProduto.setCodigoProduto(rs
						.getString(EntidadeProduto.NM_COL_CodigoProduto));
				eProduto.setNome(rs.getString(EntidadeProduto.NM_COL_Nome));
				eProduto.setDescricao(rs
						.getString(EntidadeProduto.NM_COL_Descricao));
				eProduto.setValidade(Date.valueOf(rs
						.getString(EntidadeProduto.NM_COL_Validade)));
				eProduto.setCodigoCategoria(Integer.valueOf(rs
						.getString(EntidadeProduto.NM_COL_CodigoCategoriaProduto)));
				eProduto.setValor(Double.valueOf(rs
						.getString(EntidadeProduto.NM_COL_Valor)));
				eProduto.setQuantidade(Integer.valueOf(rs
						.getString(EntidadeProduto.NM_COL_QtdEstoque)));

				listaRetorno.add(eProduto);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

	public static ArrayList<EntidadeProduto> consultarPorCodigo(
			String codigoProduto) {

		String sql = "SELECT * FROM " + EntidadeProduto.NM_TABELA + " WHERE "
				+ EntidadeProduto.NM_COL_CodigoProduto + " = " + codigoProduto;

		ArrayList<EntidadeProduto> listaRetorno = new ArrayList<EntidadeProduto>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeProduto eProduto = new EntidadeProduto();
				eProduto.setCodigoProduto(rs
						.getString(EntidadeProduto.NM_COL_CodigoProduto));
				eProduto.setNome(rs.getString(EntidadeProduto.NM_COL_Nome));
				eProduto.setDescricao(rs
						.getString(EntidadeProduto.NM_COL_Descricao));
				eProduto.setValidade(Date.valueOf(rs
						.getString(EntidadeProduto.NM_COL_Validade)));
				eProduto.setCodigoCategoria(Integer.valueOf(rs
						.getString(EntidadeProduto.NM_COL_CodigoCategoriaProduto)));
				eProduto.setValor(Double.valueOf(rs
						.getString(EntidadeProduto.NM_COL_Valor)));
				eProduto.setQuantidade(Integer.valueOf(rs
						.getString(EntidadeProduto.NM_COL_QtdEstoque)));

				listaRetorno.add(eProduto);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

	public static ArrayList<EntidadeProduto> consultarPorNomeProduto(
			String nomeProduto) {

		String sql = "SELECT * FROM " + EntidadeProduto.NM_TABELA + " WHERE "
				+ EntidadeProduto.NM_COL_Nome + " LIKE '%" + nomeProduto + "%'";

		ArrayList<EntidadeProduto> listaRetorno = new ArrayList<EntidadeProduto>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeProduto eProduto = new EntidadeProduto();
				eProduto.setCodigoProduto(rs
						.getString(EntidadeProduto.NM_COL_CodigoProduto));
				eProduto.setNome(rs.getString(EntidadeProduto.NM_COL_Nome));
				eProduto.setDescricao(rs
						.getString(EntidadeProduto.NM_COL_Descricao));
				eProduto.setValidade(Date.valueOf(rs
						.getString(EntidadeProduto.NM_COL_Validade)));
				eProduto.setCodigoCategoria(Integer.valueOf(rs
						.getString(EntidadeProduto.NM_COL_CodigoCategoriaProduto)));
				eProduto.setValor(Double.valueOf(rs
						.getString(EntidadeProduto.NM_COL_Valor)));
				eProduto.setQuantidade(Integer.valueOf(rs
						.getString(EntidadeProduto.NM_COL_QtdEstoque)));

				listaRetorno.add(eProduto);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

}
