package br.com.rocketmotos.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.rocketmotos.entidade.EntidadeCliente;

public class ClienteDAO extends Conexao {

	private static final String CONSULTAR = " SELECT * FROM Cliente c";

	public <T extends EntidadeCliente> ArrayList<T> consultar(T t) throws SQLException {

		Connection connection = this.abrirConexao();

		connection.prepareStatement(CONSULTAR);

		return null;
	}

}
