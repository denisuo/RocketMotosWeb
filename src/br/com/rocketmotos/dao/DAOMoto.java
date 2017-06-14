package br.com.rocketmotos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.rocketmotos.entidade.EntidadeModeloMoto;
import br.com.rocketmotos.entidade.EntidadeMoto;

public class DAOMoto extends Conexao {

	private static String NM_ENTIDADE = DAOMoto.class.getSimpleName();

	public DAOMoto() {

	}

	public static void incluir(EntidadeMoto eMoto) {

		//monta SQL para inserir em MOTO
		String sql = "INSERT INTO " + EntidadeMoto.NM_TABELA + " ("
				+ EntidadeMoto.NM_COL_PlacaMoto + ", "
				+ EntidadeMoto.NM_COL_Ano + ", " + EntidadeMoto.NM_COL_Cor
				+ ", " + EntidadeMoto.NM_COL_NumeroDocumentoCliente + ", "
				+ EntidadeMoto.NM_COL_CodigoModeloMoto + ") values ('"
				+ eMoto.getPlaca() + "','" + eMoto.getAno() + "','"
				+ eMoto.getCor() + "','" + eMoto.getNumeroDocumentoCliente()
				+ "','" + eMoto.getCodigoModeloMoto() + "')";

		//prepara SQL
		PreparedStatement stmt = getPreparedStatement(sql);
		try {
			//executa SQL
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir em " + NM_ENTIDADE);
		}
	}

	public static void alterar(EntidadeMoto eMoto) {

		//cria sql para atualizar moto
		String sql = "UPDATE " + EntidadeMoto.NM_TABELA + " SET "
				+ EntidadeMoto.NM_COL_Ano + " = '" + eMoto.getAno() + "', "
				+ EntidadeMoto.NM_COL_Cor + " = '" + eMoto.getCor() + "', "
				+ EntidadeMoto.NM_COL_CodigoModeloMoto + " = "
				+ eMoto.getCodigoModeloMoto() + " WHERE "
				+ EntidadeMoto.NM_COL_PlacaMoto + " = '" + eMoto.getPlaca()
				+ "' ";

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

	public static void excluir(String placaMoto) {

		//monta SQL para excluir em MOTO
		String sql = "DELETE FROM " + EntidadeMoto.NM_TABELA + " WHERE "
				+ EntidadeMoto.NM_COL_PlacaMoto + " = '" + placaMoto + "' ";
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

	public static ArrayList<EntidadeMoto> consultarTodos() {

		// monta o select indo em MODELO_MOTO para recuperar nome e cilindrada
		String sql = "SELECT " + EntidadeMoto.NM_TABELA + ".*, "
				+ EntidadeModeloMoto.NM_TABELA + "."
				+ EntidadeModeloMoto.NM_COL_Nome + ", "
				+ EntidadeModeloMoto.NM_TABELA + "."
				+ EntidadeModeloMoto.NM_COL_Cilindrada

				+ " FROM " + EntidadeMoto.NM_TABELA + " INNER JOIN "
				+ EntidadeModeloMoto.NM_TABELA + " ON ("
				+ EntidadeModeloMoto.NM_TABELA + "."
				+ EntidadeModeloMoto.NM_COL_CodigoModeloMoto + " = "
				+ EntidadeMoto.NM_TABELA + "."
				+ EntidadeMoto.NM_COL_CodigoModeloMoto + ")";

		ArrayList<EntidadeMoto> listaRetorno = new ArrayList<EntidadeMoto>();
		//prepara SQL
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			//executa SQL, recupera o result set e itera a resposta para montar a lista de retorno
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
				eMoto.setNomeModeloMoto(rs
						.getString(EntidadeModeloMoto.NM_COL_Nome)
						+ "-"
						+ rs.getString(EntidadeModeloMoto.NM_COL_Cilindrada));

				listaRetorno.add(eMoto);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

	public static ArrayList<EntidadeMoto> consultarPorNumeroDocumentoCliente(
			String numeroDocumentoCliente) {

		//monta SQL de consulta
		String sql = "SELECT * FROM " + EntidadeMoto.NM_TABELA + " WHERE "
				+ EntidadeMoto.NM_COL_NumeroDocumentoCliente + " = "
				+ numeroDocumentoCliente;

		ArrayList<EntidadeMoto> listaRetorno = new ArrayList<EntidadeMoto>();
		//prepara SQL
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			//executa SQL,  recupera o result set e itera a resposta para montar a lista de retorno
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

				listaRetorno.add(eMoto);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

	public static ArrayList<EntidadeMoto> consultarPorPlaca(String placa) {

		//monta SQL de consulta
		String sql = "SELECT * FROM " + EntidadeMoto.NM_TABELA + " WHERE "
				+ EntidadeMoto.NM_COL_PlacaMoto + " = '" + placa + "'";
		ArrayList<EntidadeMoto> listaRetorno = new ArrayList<EntidadeMoto>();
		//prepara SQL
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			//executa SQL,  recupera o result set e itera a resposta para montar a lista de retorno
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

				listaRetorno.add(eMoto);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

}
