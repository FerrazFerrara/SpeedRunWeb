package br.com.speedrun.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectorDAO {
	public Connection getConnection() {
		
		String user = "root";
		String senha = "12345678";
		String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, senha);
		}catch(Exception error) {
			throw new RuntimeException("Erro na conexao com o banco");
		}
		
	}
}
