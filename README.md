💻 Projeto Java com JDBC – Sistema de Cadastro de Clientes
Este projeto é um sistema simples em Java que realiza operações de CRUD (Create, Read, Update, Delete) utilizando JDBC puro com MySQL, seguindo boas práticas como o padrão DAO e separação em camadas.

📚 Funcionalidades
✅ Cadastrar cliente (nome, e-mail, senha)

🔍 Listar todos os clientes

✏️ Atualizar dados de um cliente existente

❌ Excluir cliente pelo ID

📦 Organização do código por pacotes (model, jdbc, etc.)

🛠 Tecnologias Utilizadas
Java SE

JDBC (Java Database Connectivity)

MySQL

Padrão DAO (Data Access Object)

IDE: Eclipse 

📁 Estrutura do Projeto
cpp
projeto-jdbc/
│
├── jdbc/
│   ├── FabricaConexao.java     // Conexão com o banco (lê conexao.properties)
│   └── ClienteDAO.java         // Lógica de acesso ao banco (CRUD)
│
├── model/
│   └── Cliente.java            // Classe que representa o cliente
│
├── App.java                    // Menu interativo no console
├── conexao.properties          // Configuração de acesso ao banco
🔌 Configuração do Banco de Dados
▶️ Como Executar
Compile e execute a classe App.java.

Um menu interativo será exibido no console.

Escolha uma opção (1 a 4) para testar as operações de CRUD.

🎯 Objetivo do Projeto
Este projeto foi desenvolvido para reforçar os fundamentos de conexão com banco de dados usando JDBC puro, sem frameworks como Hibernate ou Spring Data. Ideal para entender como funciona o acesso a dados em baixo nível antes de migrar para frameworks mais avançados.

🤝 Contribuição
Sinta-se livre para clonar, testar e melhorar este projeto. Feedbacks são bem-vindos!
