package jdbc;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import model.Cliente;

public class DAO {
   public void incluir(Cliente cliente) {
	    String sql = "INSERT INTO cliente (nome, email, senha) VALUES (?, ?, ?)";

	    try (Connection conn = FabricaConexao.getConexao();
	         PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

	        stmt.setString(1, cliente.getNome());
	        stmt.setString(2, cliente.getEmail());
	        stmt.setString(3, cliente.getSenha());

	        stmt.executeUpdate();

	        try (ResultSet rs = stmt.getGeneratedKeys()) {
	            if (rs.next()) {
	                cliente.setId(rs.getInt(1));
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }
	}

    public void excluir(int codigo) throws SQLException {

		
		 Connection conexao = FabricaConexao.getConexao();
		 String sql ="DELETE FROM pessoas where codigo = ?";
		 
		 PreparedStatement stmt = conexao.prepareStatement(sql);
		 stmt.setInt(1, codigo);
		 
		 int contador = stmt.executeUpdate();
		 
		 if(contador > 0){
			 System.out.println("Pessoa excluida com sucesso ");
			 System.out.println("Linhas afetadas " + contador);
		 } else {
			System.out.println("Nada feito" );
		}
		 
			conexao.close();
			
    }
    
    public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, email = ?, senha = ? WHERE id = ?";

        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getSenha());
            stmt.setInt(4, (int) cliente.getId());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Cliente atualizado com sucesso.");
            } else {
                System.out.println("Nenhum cliente encontrado com o ID informado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }


}
