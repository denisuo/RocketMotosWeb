package br.com.rocketmotos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.rocketmotos.entidade.EntidadeMarcaMoto;

public class Conexao {

	public static Connection aConexao = null;

	// try {
	// Connection connection;
	// // Load the JDBC driver
	// String driverName = "org.gjt.mm.mysql.Driver"; // MySQL MM JDBC driver
	// Class.forName(driverName);
	//
	// // Create a connection to the database
	// String serverName = "localhost";
	// String mydatabase = "mydatabase";
	// String url = "jdbc:mysql://" + serverName + "/" + mydatabase; // a JDBC
	// url
	// String username = "username";
	// String password = "password";
	// connection = DriverManager.getConnection(url, username, password);
	// } catch (ClassNotFoundException ex) {
	// // Could not find the database driver<%-- --%>
	// } catch (SQLException e) {
	// // Could not connect to the database
	// }

	public static Connection abrirConexao() {

		try {
			if (aConexao == null) {
				Class.forName("com.mysql.jdbc.Driver");
				aConexao = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/rocketmotos", "root", "");
			}
			return aConexao;
		} catch (SQLException e) {
			System.out.println("Erro de SQL: " + e.getMessage());
			throw new RuntimeException(
					"Erro SQLException ao abrir a conexão em Conexao.java", e);
		} catch (ClassNotFoundException e) {
			System.out.println("Erro classe not found: " + e.getMessage());
			throw new RuntimeException(
					"Erro ClassNotFoundException em Conexao.java", e);
		}
	}

	public static void fecharConexao() {
		try {
			//verifica se existe conexao aberta para poder fechar
			if (aConexao != null) {
				aConexao.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static PreparedStatement getPreparedStatement(String sql) {
		//caso a conexao nao seja válida, cria uma nova
		if (aConexao == null) {
			aConexao = abrirConexao();
		}

		try {
			return aConexao.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("Erro de SQL: " + e.getMessage());
			throw new RuntimeException(
					"Erro SQLException ao executar getPreparedStatement em Conexao.java",
					e);
		}
	}

}
