package br.com.speedrun.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectorDAO {
	public Connection getConnection() {
		// Atributos para conexão com o servidor local
		String user = "root";
		String senha = "12345678";
		String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
		
		// Chamada do método para tentar realizar conexão com o banco.
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, senha);
		}catch(Exception error) {
			throw new RuntimeException("Erro na conexao com o banco");
		}
		
	}
}
