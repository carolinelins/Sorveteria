package ConexaoBanco;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class ConexaoMySQL {
	public static Connection getConexao()	{
		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sorveteria", "root", "123456");
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			System.err.println("Erro ao conectar");
		}
		return conn;
	}

	public static void main(String args[]) {
		ConexaoMySQL.getConexao();
	}

	public static void fecharConexao(Connection con) {

		try {
			con.close(); 
		} catch (SQLException e) { 
			System.out.println(e.getMessage());

		} catch (Exception e) { 
			System.out.println(e.getMessage());
		}
	}
}

