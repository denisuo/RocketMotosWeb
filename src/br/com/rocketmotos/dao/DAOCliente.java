package br.com.rocketmotos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.rocketmotos.entidade.EntidadeCliente;

public class DAOCliente extends Conexao {

	private static String NM_ENTIDADE = DAOCliente.class.getSimpleName();

	public DAOCliente() {

	}

	public static void incluir(EntidadeCliente eCliente) {

		String sql = "INSERT INTO " + EntidadeCliente.NM_TABELA + " ("
				+ EntidadeCliente.NM_COL_NumeroDocumento + ", "
				+ EntidadeCliente.NM_COL_Nome + ", "
				+ EntidadeCliente.NM_COL_Endereco + ", "
				+ EntidadeCliente.NM_COL_Telefone + ", "
				+ EntidadeCliente.NM_COL_TipoCliente + ") values ('"
				+ eCliente.getDocumento() + "','" + eCliente.getNome() + "','"
				+ eCliente.getEndereco() + "','" + eCliente.getTelefone()
				+ "','" + eCliente.getTipoCliente() + "')";

		// eCliente.getDocumento()
		PreparedStatement stmt = getPreparedStatement(sql);
		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir em " + NM_ENTIDADE);
		}
	}

	public static void alterar(EntidadeCliente eCliente) {

		String sql = "UPDATE " + EntidadeCliente.NM_TABELA + " SET "
				+ EntidadeCliente.NM_COL_Nome + " = '" + eCliente.getNome()
				+ "', " + EntidadeCliente.NM_COL_Endereco + " = '"
				+ eCliente.getEndereco() + "', "
				+ EntidadeCliente.NM_COL_Telefone + " = '"
				+ eCliente.getTelefone() + "' WHERE "
				+ EntidadeCliente.NM_COL_NumeroDocumento + " = '"
				+ eCliente.getDocumento() + "' ";

		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao alterar em " + NM_ENTIDADE);
		}
	}

	public static void excluir(String numeroDocumentoCliente) {

		String sql = "DELETE FROM " + EntidadeCliente.NM_TABELA + " WHERE "
				+ EntidadeCliente.NM_COL_NumeroDocumento + " = "
				+ numeroDocumentoCliente;
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao excluir em " + NM_ENTIDADE);
		}
	}

	public static ArrayList<EntidadeCliente> consultarTodos() {

		String sql = "SELECT * FROM " + EntidadeCliente.NM_TABELA;
		ArrayList<EntidadeCliente> listaRetorno = new ArrayList<EntidadeCliente>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeCliente eCliente = new EntidadeCliente();
				eCliente.setDocumento(rs
						.getString(EntidadeCliente.NM_COL_NumeroDocumento));
				eCliente.setNome(rs.getString(EntidadeCliente.NM_COL_Nome));
				eCliente.setEndereco(rs
						.getString(EntidadeCliente.NM_COL_Endereco));
				eCliente.setTelefone(rs
						.getString(EntidadeCliente.NM_COL_Telefone));
				eCliente.setTipoCliente(rs
						.getString(EntidadeCliente.NM_COL_TipoCliente));

				listaRetorno.add(eCliente);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

	public static ArrayList<EntidadeCliente> consultarPorDocumento(
			String numeroDocumento) {

		String sql = "SELECT * FROM " + EntidadeCliente.NM_TABELA + " WHERE "
				+ EntidadeCliente.NM_COL_NumeroDocumento + " = "
				+ numeroDocumento;

		ArrayList<EntidadeCliente> listaRetorno = new ArrayList<EntidadeCliente>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeCliente eCliente = new EntidadeCliente();
				eCliente.setDocumento(rs
						.getString(EntidadeCliente.NM_COL_NumeroDocumento));
				eCliente.setNome(rs.getString(EntidadeCliente.NM_COL_Nome));
				eCliente.setEndereco(rs
						.getString(EntidadeCliente.NM_COL_Endereco));
				eCliente.setTelefone(rs
						.getString(EntidadeCliente.NM_COL_Telefone));
				eCliente.setTipoCliente(rs
						.getString(EntidadeCliente.NM_COL_TipoCliente));

				listaRetorno.add(eCliente);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

	public static ArrayList<EntidadeCliente> consultarPorNome(String nome) {

		String sql = "SELECT * FROM " + EntidadeCliente.NM_TABELA + " WHERE "
				+ EntidadeCliente.NM_COL_Nome + " LIKE '%" + nome + "%'";
		ArrayList<EntidadeCliente> listaRetorno = new ArrayList<EntidadeCliente>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeCliente eCliente = new EntidadeCliente();
				eCliente.setDocumento(rs
						.getString(EntidadeCliente.NM_COL_NumeroDocumento));
				eCliente.setNome(rs.getString(EntidadeCliente.NM_COL_Nome));
				eCliente.setEndereco(rs
						.getString(EntidadeCliente.NM_COL_Endereco));
				eCliente.setTelefone(rs
						.getString(EntidadeCliente.NM_COL_Telefone));
				eCliente.setTipoCliente(rs
						.getString(EntidadeCliente.NM_COL_TipoCliente));

				listaRetorno.add(eCliente);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

}
