package br.edu.saolucas.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
	
	private static ConexaoDB instancia;
	public static Connection conexao;
	
	private String host = "localhost"; // 127.0.0.1 ou endereço do servidor
	private String port = "3306"; // Mysql 3306, Postgres 5432
	private String user = "root"; // Mysql root, Postgres postgres
	private String pass = "123456";
	private String database = "poo";
	private String driver = "com.mysql.jdbc.Driver"; //org.postgresql.Driver"; // com.mysql.jdbc.Driver
	private String nameDB = "mysql"; // postgres
	
	private ConexaoDB() {
		
		String url = String.format("jdbc:%s://%s:%s/%s", nameDB, host, port, database);
	
		try {
			conexao = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.err.print("Não foi possível realizar a conexão. \n" + e.getMessage()); // e.printStackTrace());
		}
	}

	public static ConexaoDB getInstancia() {
		
		if(instancia == null) 
			instancia = new ConexaoDB();
		
		return instancia;
		
	}
}
