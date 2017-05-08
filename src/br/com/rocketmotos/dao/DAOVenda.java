package br.com.rocketmotos.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.rocketmotos.entidade.EntidadeVenda;

public class DAOVenda extends Conexao {

	private static String NM_ENTIDADE = DAOVenda.class.getSimpleName();

	public DAOVenda() {

	}

	public static void incluir(EntidadeVenda eVenda) {

		String sql = "INSERT INTO " + EntidadeVenda.NM_TABELA + " ("
				+ EntidadeVenda.NM_COL_CodigoVenda + ", "
				+ EntidadeVenda.NM_COL_NumeroDocumentoCliente + ", "
				+ EntidadeVenda.NM_COL_Data + ", " + EntidadeVenda.NM_COL_Valor
				+ ", " + EntidadeVenda.NM_COL_TipoPagamento + ", "
				+ EntidadeVenda.NM_COL_Desconto + ") values ("
				+ eVenda.getCodigo() + ",'" + eVenda.getDocumentoCliente()
				+ "','" + eVenda.getData() + "'," + eVenda.getValor() + ",'"
				+ eVenda.getTipoPagamento() + "'," + eVenda.getDesconto() + ")";
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir em " + NM_ENTIDADE);
		}
	}

	public static void alterar(EntidadeVenda eVenda) {

		String sql = "UPDATE " + EntidadeVenda.NM_TABELA + " SET "
				+ EntidadeVenda.NM_COL_Valor + " = " + eVenda.getValor() + ", "
				+ EntidadeVenda.NM_COL_TipoPagamento + " = '"
				+ eVenda.getTipoPagamento() + "', "
				+ EntidadeVenda.NM_COL_Desconto + " = " + eVenda.getDesconto()
				+ " WHERE " + EntidadeVenda.NM_COL_CodigoVenda + " = "
				+ eVenda.getCodigo();

		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao alterar em " + NM_ENTIDADE);
		}
	}

	public static void excluir(Integer codigoVenda) {

		String sql = "DELETE FROM " + EntidadeVenda.NM_TABELA + " WHERE "
				+ EntidadeVenda.NM_COL_CodigoVenda + " = " + codigoVenda;
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao excluir em " + NM_ENTIDADE);
		}
	}

	public static ArrayList<EntidadeVenda> consultarTodos() {

		String sql = "SELECT * FROM " + EntidadeVenda.NM_TABELA;
		ArrayList<EntidadeVenda> listaRetorno = new ArrayList<EntidadeVenda>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeVenda eVenda = new EntidadeVenda();
				eVenda.setCodigo(Integer.valueOf(rs
						.getString(EntidadeVenda.NM_COL_CodigoVenda)));
				eVenda.setDocumentoCliente(rs
						.getString(EntidadeVenda.NM_COL_NumeroDocumentoCliente));
				eVenda.setData(Date.valueOf(rs
						.getString(EntidadeVenda.NM_COL_Data)));
				eVenda.setValor(Double.valueOf(rs
						.getString(EntidadeVenda.NM_COL_Valor)));
				eVenda.setTipoPagamento(rs
						.getString(EntidadeVenda.NM_COL_TipoPagamento));
				eVenda.setDesconto(Double.valueOf(rs
						.getString(EntidadeVenda.NM_COL_Desconto)));

				listaRetorno.add(eVenda);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

	public static ArrayList<EntidadeVenda> consultarPorCodigoVenda(
			String codigoVenda) {

		String sql = "SELECT * FROM " + EntidadeVenda.NM_TABELA + " WHERE "
				+ EntidadeVenda.NM_COL_CodigoVenda + " = "
				+ codigoVenda;

		ArrayList<EntidadeVenda> listaRetorno = new ArrayList<EntidadeVenda>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeVenda eVenda = new EntidadeVenda();
				eVenda.setCodigo(Integer.valueOf(rs
						.getString(EntidadeVenda.NM_COL_CodigoVenda)));
				eVenda.setDocumentoCliente(rs
						.getString(EntidadeVenda.NM_COL_NumeroDocumentoCliente));
				eVenda.setData(Date.valueOf(rs
						.getString(EntidadeVenda.NM_COL_Data)));
				eVenda.setValor(Double.valueOf(rs
						.getString(EntidadeVenda.NM_COL_Valor)));
				eVenda.setTipoPagamento(rs
						.getString(EntidadeVenda.NM_COL_TipoPagamento));
				eVenda.setDesconto(Double.valueOf(rs
						.getString(EntidadeVenda.NM_COL_Desconto)));

				listaRetorno.add(eVenda);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

	public static ArrayList<EntidadeVenda> consultarPorDocumentoCliente(
			String numeroDocumentoCliente) {

		String sql = "SELECT * FROM " + EntidadeVenda.NM_TABELA + " WHERE "
				+ EntidadeVenda.NM_COL_NumeroDocumentoCliente + " = '" + numeroDocumentoCliente + "'";

		ArrayList<EntidadeVenda> listaRetorno = new ArrayList<EntidadeVenda>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeVenda eVenda = new EntidadeVenda();
				eVenda.setCodigo(Integer.valueOf(rs
						.getString(EntidadeVenda.NM_COL_CodigoVenda)));
				eVenda.setDocumentoCliente(rs
						.getString(EntidadeVenda.NM_COL_NumeroDocumentoCliente));
				eVenda.setData(Date.valueOf(rs
						.getString(EntidadeVenda.NM_COL_Data)));
				eVenda.setValor(Double.valueOf(rs
						.getString(EntidadeVenda.NM_COL_Valor)));
				eVenda.setTipoPagamento(rs
						.getString(EntidadeVenda.NM_COL_TipoPagamento));
				eVenda.setDesconto(Double.valueOf(rs
						.getString(EntidadeVenda.NM_COL_Desconto)));

				listaRetorno.add(eVenda);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

}
