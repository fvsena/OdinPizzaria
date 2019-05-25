package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static ConnectionManager instance;
	private Connection conn;
	private String connUrl = "jdbc:sqlserver://SENA-LAPTOP\\SQLEXPRESS:1433;databaseName=OdinPizzaria;integratedSecurity=true";

	private ConnectionManager() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Driver Carregado");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		if (conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection(connUrl);
			System.out.println("Gerada uma nova conexão");
		} else {
			System.out.println("Reusando uma conexão existente");
		}
		return conn;
	}

}
