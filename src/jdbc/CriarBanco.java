package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
	   public static void main(String[] args) throws SQLException {
		      final String url = "jdbc:mysql://localhost:3306";
		        final String usuario = "root";
		        final String senha = "31122007";

		        Connection conexao = DriverManager.getConnection(url, usuario, senha);
		        Statement stmt = conexao.createStatement();
		        stmt.execute("CREATE DATABASE Clientes_jdbc");
		        System.out.println("Banco criando com sucesso");
		        conexao.close();
	}

}
