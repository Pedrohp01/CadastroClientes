package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class CriarTabelas {
       public static void main(String[] args) throws SQLException {
   		Connection conexao= FabricaConexao.getConexao();
   		String sql = " CREATE TABLE clientes("
   				+ "id INT AUTO_INCREMENT PRIMARY KEY,"
   				+ "nome VARCHAR(80) NOT NULL,"
   				+ " email VARCHAR(80) NOT NULL,"
   				+ " senha VARCHAR(20) NOT NULL"
   				+ ")";
   		
   		Statement stmt = conexao.createStatement();
   		stmt.execute(sql);
   		System.out.println("Tabela Criada com sucessos");
   		conexao.close();
	}
}
