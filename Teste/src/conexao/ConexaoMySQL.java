package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

	private static Connection con;

	public static Connection abrirConexao() {
		try {
			String driverName = "com.mysql.cj.jdbc.Driver"; // JDBC Driver padrão
			Class.forName(driverName); // registro do driver JDBC

			// configurando conexao com banco de dados
			String serverName = "localhost";
			String database = "sistemaCadastro";
			String url = "jdbc:mysql://" + serverName + ":3306/" + database;
			String userName = "camilaB";
			String password = "trabalho";

			con = DriverManager.getConnection(url, userName, password);
			
			return con; // se con != null -> conectou com o banco de dados
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return null; // driver não foi encontrado
		} catch (SQLException e) {
			e.printStackTrace();
			return null; // não foi possivel conectar com o banco de dados
		}
	}

	public static boolean fecharConexao() {
		try {
			con.close();
			return true; 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		ConexaoMySQL.con = con;
	}

}
