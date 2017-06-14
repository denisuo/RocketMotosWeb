package br.com.rocketmotos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.rocketmotos.entidade.EntidadeMarcaMoto;

public class DAOMarcaMoto extends Conexao {

	private static String NM_ENTIDADE = DAOMarcaMoto.class.getSimpleName();

	public DAOMarcaMoto() {

	}

	public static void incluir(EntidadeMarcaMoto eMarcaMoto) {

		//monta SQL para inserir em MARCA_MOTO
		String sql = "INSERT INTO " + EntidadeMarcaMoto.NM_TABELA + " ("
				+ EntidadeMarcaMoto.NM_COL_Nome + ") values ('"
				+ eMarcaMoto.getNome() + "')";
		//prepara SQL
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			//executa SQL
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir em " + NM_ENTIDADE);
		}
	}

	public static void alterar(EntidadeMarcaMoto eMarcaMoto) {

		//monta SQL para alterar em MARCA_MOTO
		String sql = "UPDATE " + EntidadeMarcaMoto.NM_TABELA + " SET "
				+ EntidadeMarcaMoto.NM_COL_Nome + " = '" + eMarcaMoto.getNome()
				+ "' WHERE " + EntidadeMarcaMoto.NM_COL_CodigoMarcaMoto + " = "
				+ eMarcaMoto.getCodigo();
		
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

	public static void excluir(Integer codigoMarcaMoto) {
		//monta SQL para excluir em MARCA_MOTO
		String sql = "DELETE FROM " + EntidadeMarcaMoto.NM_TABELA + " WHERE "
				+ EntidadeMarcaMoto.NM_COL_CodigoMarcaMoto + " = "
				+ codigoMarcaMoto;
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

	public static ArrayList<EntidadeMarcaMoto> consultarTodos() {
		
		//monta SQL de consulta
		String sql = "SELECT * FROM " + EntidadeMarcaMoto.NM_TABELA;
		ArrayList<EntidadeMarcaMoto> listaRetorno = new ArrayList<EntidadeMarcaMoto>();
		//prepara SQL
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			//executa SQL,  recupera o result set e itera a resposta para montar a lista de retorno
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeMarcaMoto eMarcaMoto = new EntidadeMarcaMoto();
				eMarcaMoto.setCodigo(Integer.valueOf(rs
						.getString(EntidadeMarcaMoto.NM_COL_CodigoMarcaMoto)));
				eMarcaMoto.setNome(rs.getString(EntidadeMarcaMoto.NM_COL_Nome));

				listaRetorno.add(eMarcaMoto);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

	public static EntidadeMarcaMoto consultarPorCodigo(
			Integer codigoMarcaMoto) {

		//monta SQL de consulta
		String sql = "SELECT * FROM " + EntidadeMarcaMoto.NM_TABELA + " WHERE "
				+ EntidadeMarcaMoto.NM_COL_CodigoMarcaMoto + " = "
				+ codigoMarcaMoto;
		ArrayList<EntidadeMarcaMoto> listaRetorno = new ArrayList<EntidadeMarcaMoto>();
		//prepara SQL
		PreparedStatement stmt = getPreparedStatement(sql);

		EntidadeMarcaMoto eMarcaMoto = new EntidadeMarcaMoto();
		try {
			//executa SQL e recupera o result para montar a entidade de retorno
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				eMarcaMoto.setCodigo(Integer.valueOf(rs
						.getString(EntidadeMarcaMoto.NM_COL_CodigoMarcaMoto)));
				eMarcaMoto.setNome(rs.getString(EntidadeMarcaMoto.NM_COL_Nome));
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}
		
		return eMarcaMoto;
	}

	public static ArrayList<EntidadeMarcaMoto> consultarPorNome(String nome) {

		//monta SQL de consulta
		String sql = "SELECT * FROM " + EntidadeMarcaMoto.NM_TABELA + " WHERE "
				+ EntidadeMarcaMoto.NM_COL_Nome + " LIKE '%" + nome + "%'";
		ArrayList<EntidadeMarcaMoto> listaRetorno = new ArrayList<EntidadeMarcaMoto>();
		//prepara SQL
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			//executa SQL,  recupera o result set e itera a resposta para montar a lista de retorno
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EntidadeMarcaMoto eMarcaMoto = new EntidadeMarcaMoto();
				eMarcaMoto.setCodigo(Integer.valueOf(rs
						.getString(EntidadeMarcaMoto.NM_COL_CodigoMarcaMoto)));
				eMarcaMoto.setNome(rs.getString(EntidadeMarcaMoto.NM_COL_Nome));

				listaRetorno.add(eMarcaMoto);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return listaRetorno;
	}

}
