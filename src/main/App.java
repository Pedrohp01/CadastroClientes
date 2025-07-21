package main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import jdbc.DAO;
import model.Cliente;

public class App {

    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);
       DAO dao = new DAO();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n====== MENU CLIENTE ======");
            System.out.println("1 - Incluir Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Atualizar Cliente");
            System.out.println("4 - Excluir Cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("Email: ");
                    String email = entrada.nextLine();

                    System.out.print("Senha: ");
                    String senha = entrada.nextLine();

                    Cliente novo = new Cliente(nome, email, senha);
                    dao.incluir(novo);
                    break;

                case 2:
                    List<Cliente> clientes = dao.listar();
                    for (Cliente c : clientes) {
                        System.out.println("ID: " + c.getId());
                        System.out.println("Nome: " + c.getNome());
                        System.out.println("Email: " + c.getEmail());
                        System.out.println("Senha: " + c.getSenha());
                        System.out.println("--------------------------");
                    }
                    break;

                case 3:
                    System.out.print("ID do cliente a atualizar: ");
                    int idAtualizar = entrada.nextInt();
                   

                    System.out.print("Novo nome: ");
                    String novoNome = entrada.nextLine();

                    System.out.print("Novo email: ");
                    String novoEmail = entrada.nextLine();

                    System.out.print("Nova senha: ");
                    String novaSenha = entrada.nextLine();

                    Cliente atualiza = new Cliente(novoNome, novoEmail, novaSenha);
                    dao.atualizar(atualiza);
                    break;

                case 4:
                    System.out.print("ID do cliente a excluir: ");
                    int idExcluir = entrada.nextInt();
                    dao.excluir(idExcluir);
                    break;

                case 0:
                    System.out.println("Encerrando o programa.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        entrada.close();
    }
}
