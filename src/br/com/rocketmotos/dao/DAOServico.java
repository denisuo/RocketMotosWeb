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
		//monta SQL para inserir em SERVICO
		String sql = "INSERT INTO " + EntidadeServico.NM_TABELA + " ("
				+ EntidadeServico.NM_COL_CodigoServico + ", "
				+ EntidadeServico.NM_COL_Nome + ", "
				+ EntidadeServico.NM_COL_Descricao + ", "
				+ EntidadeServico.NM_COL_Valor + ") values ("
				+ eServico.getCodigoServico() + ",'" + eServico.getNome()
				+ "','" + eServico.getDescricao() + "'," + eServico.getValor()
				+ ")";

		//prepara SQP
		PreparedStatement stmt = getPreparedStatement(sql);
		try {
			//executa SQL
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir em " + NM_ENTIDADE);
		}
	}

	public static void alterar(EntidadeServico eServico) {

		//monta SQL para alterar em SERVICO
		String sql = "UPDATE " + EntidadeServico.NM_TABELA + " SET "
				+ EntidadeServico.NM_COL_Nome + " = '" + eServico.getNome()
				+ "', " + EntidadeServico.NM_COL_Descricao + " = '"
				+ eServico.getDescricao() + "', "
				+ EntidadeServico.NM_COL_Valor + " = " + eServico.getValor()
				+ " WHERE " + EntidadeServico.NM_COL_CodigoServico + " = "
				+ eServico.getCodigoServico();

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

	public static void excluir(Integer codigoServico) {
		
		//monta SQL para excluir em SERVICO
		String sql = "DELETE FROM " + EntidadeServico.NM_TABELA + " WHERE "
				+ EntidadeServico.NM_COL_CodigoServico + " = " + codigoServico;
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

	public static ArrayList<EntidadeServico> consultarTodos() {

		//monta SQL para consultar
		String sql = "SELECT * FROM " + EntidadeServico.NM_TABELA;
		ArrayList<EntidadeServico> listaRetorno = new ArrayList<EntidadeServico>();
		//prepara SQL
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			//executa SQL, recupera o result set e itera a resposta para montar a lista de retorno
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

	public static EntidadeServico consultarPorCodigo(
			String codigoServico) {

		//monta SQL para consultar
		String sql = "SELECT * FROM " + EntidadeServico.NM_TABELA + " WHERE "
				+ EntidadeServico.NM_COL_CodigoServico + " = " + codigoServico;

		//prepara SQL
		PreparedStatement stmt = getPreparedStatement(sql);
		EntidadeServico eServico = new EntidadeServico();

		try {
			//executa SQL, recupera o result set para montar a entidade de retorno
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				eServico.setCodigoServico(Integer.valueOf(rs
						.getString(EntidadeServico.NM_COL_CodigoServico)));
				eServico.setNome(rs.getString(EntidadeServico.NM_COL_Nome));
				eServico.setDescricao(rs
						.getString(EntidadeServico.NM_COL_Descricao));
				eServico.setValor(Double.valueOf(rs
						.getString(EntidadeServico.NM_COL_Valor)));
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar em " + NM_ENTIDADE);
		}

		return eServico;
	}

	public static ArrayList<EntidadeServico> consultarPorNomeServico(
			String nomeServico) {

		String sql = "SELECT * FROM " + EntidadeServico.NM_TABELA + " WHERE "
				+ EntidadeServico.NM_COL_Nome + " LIKE '%" + nomeServico + "%'";

		ArrayList<EntidadeServico> listaRetorno = new ArrayList<EntidadeServico>();
		PreparedStatement stmt = getPreparedStatement(sql);

		try {
			//executa SQL, recupera o result set e itera a resposta para montar a lista de retorno
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
