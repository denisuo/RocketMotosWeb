package br.com.rocketmotos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.rocketmotos.entidade.EntidadeMoto;

public class DAOMoto extends Conexao {

	private static String NM_ENTIDADE = DAOMoto.class.getSimpleName();

	public DAOMoto() {

	}

	public static void incluir(EntidadeMoto eMoto) {

		String sql = "INSERT INTO " + EntidadeMoto.NM_TABELA + " ("
				+ EntidadeMoto.NM_COL_PlacaMoto + ", "
				+ EntidadeMoto.NM_COL_Ano + ", " + EntidadeMoto.NM_COL_Cor
				+ ", " + EntidadeMoto.NM_COL_NumeroDocumentoCliente + ", "
				+ EntidadeMoto.NM_COL_CodigoModeloMoto + ", "
				+ EntidadeMoto.NM_COL_CodigoMarcaMoto + ") values ('"
				+ eMoto.getPlaca() + "','" + eMoto.getAno() + "','"
				+ eMoto.getCor() + "','" + eMoto.getNumeroDocumentoCliente()
				+ "','" + eMoto.getCodigoModeloMoto() + "','"
				+ eMoto.getCodigoMarcaMoto() + "')";

		// eMoto.getDocumento()
		PreparedStatement stmt = getPreparedStatement(sql);
		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir em " + NM_ENTIDADE);
		}
	}

	public static void alterar(EntidadeMoto eMoto) {

		String sql = "UPDATE " + EntidadeMoto.NM_TABELA + " SET "
				+ EntidadeMoto.NM_COL_Ano + " = '" + eMoto.getAno() + "', "
				+ EntidadeMoto.NM_COL_Cor + " = '" + eMoto.getCor()
				+ "' WHERE " + EntidadeMoto.NM_COL_PlacaMoto + " = '"
				+ eMoto.getPlaca() + "' ";

		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao alterar em " + NM_ENTIDADE);
		}
	}

	public static void excluir(String placaMoto) {

		String sql = "DELETE FROM " + EntidadeMoto.NM_TABELA + " WHERE "
				+ EntidadeMoto.NM_COL_PlacaMoto + " = '" + placaMoto + "' ";
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao excluir em " + NM_ENTIDADE);
		}
	}

	public static ArrayList<EntidadeMoto> consultarTodos() {

		String sql = "SELECT * FROM " + EntidadeMoto.NM_TABELA;
		ArrayList<EntidadeMoto> listaRetorno = new ArrayList<EntidadeMoto>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeMoto eMoto = new EntidadeMoto();
				eMoto.setPlaca(rs.getString(EntidadeMoto.NM_COL_PlacaMoto));
				eMoto.setAno(rs.getString(EntidadeMoto.NM_COL_Ano));
				eMoto.setCor(rs.getString(EntidadeMoto.NM_COL_Cor));
				eMoto.setNumeroDocumentoCliente(rs
						.getString(EntidadeMoto.NM_COL_NumeroDocumentoCliente));
				eMoto.setCodigoModeloMoto(Integer.valueOf(rs
						.getString(EntidadeMoto.NM_COL_CodigoModeloMoto)));
				eMoto.setCodigoMarcaMoto(Integer.valueOf(rs
						.getString(EntidadeMoto.NM_COL_CodigoMarcaMoto)));

				listaRetorno.add(eMoto);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

	public static ArrayList<EntidadeMoto> consultarPorNumeroDocumentoCliente(
			String numeroDocumentoCliente) {

		String sql = "SELECT * FROM " + EntidadeMoto.NM_TABELA + " WHERE "
				+ EntidadeMoto.NM_COL_NumeroDocumentoCliente + " = "
				+ numeroDocumentoCliente;

		ArrayList<EntidadeMoto> listaRetorno = new ArrayList<EntidadeMoto>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeMoto eMoto = new EntidadeMoto();
				eMoto.setPlaca(rs.getString(EntidadeMoto.NM_COL_PlacaMoto));
				eMoto.setAno(rs.getString(EntidadeMoto.NM_COL_Ano));
				eMoto.setCor(rs.getString(EntidadeMoto.NM_COL_Cor));
				eMoto.setNumeroDocumentoCliente(rs
						.getString(EntidadeMoto.NM_COL_NumeroDocumentoCliente));
				eMoto.setCodigoModeloMoto(Integer.valueOf(rs
						.getString(EntidadeMoto.NM_COL_CodigoModeloMoto)));
				eMoto.setCodigoMarcaMoto(Integer.valueOf(rs
						.getString(EntidadeMoto.NM_COL_CodigoMarcaMoto)));

				listaRetorno.add(eMoto);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

	public static ArrayList<EntidadeMoto> consultarPorPlaca(String placa) {

		String sql = "SELECT * FROM " + EntidadeMoto.NM_TABELA + " WHERE "
				+ EntidadeMoto.NM_COL_PlacaMoto + " = '" + placa + "'";
		ArrayList<EntidadeMoto> listaRetorno = new ArrayList<EntidadeMoto>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeMoto eMoto = new EntidadeMoto();
				eMoto.setPlaca(rs.getString(EntidadeMoto.NM_COL_PlacaMoto));
				eMoto.setAno(rs.getString(EntidadeMoto.NM_COL_Ano));
				eMoto.setCor(rs.getString(EntidadeMoto.NM_COL_Cor));
				eMoto.setNumeroDocumentoCliente(rs
						.getString(EntidadeMoto.NM_COL_NumeroDocumentoCliente));
				eMoto.setCodigoModeloMoto(Integer.valueOf(rs
						.getString(EntidadeMoto.NM_COL_CodigoModeloMoto)));
				eMoto.setCodigoMarcaMoto(Integer.valueOf(rs
						.getString(EntidadeMoto.NM_COL_CodigoMarcaMoto)));

				listaRetorno.add(eMoto);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

}
