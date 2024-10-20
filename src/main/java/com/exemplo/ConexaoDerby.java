package com.exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

// É apenas um código de exemplo para você constatar o funcionamento da conexão.
// Num cenário ideal você deveria usar PreparedStatement.

public class ConexaoDerby {
    
    // Como estou usando o Derby Embbbed não preciso usar a url completa 
    // indicando a porta como o exemplo abaixo
    // JDBC_URL = "jdbc:derby://localhost:1527/myDB;create=true";
    
    private static final String JDBC_URL = "jdbc:derby:myDB;create=true";
    private static final String USER = "admin";
    private static final String PASSWORD = "adminpassword";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            // Apaga a tabela Aluno se ela existir.
            try {
                stmt.executeUpdate("DROP TABLE Aluno");
            } catch (SQLException e) {
                // Ignora o erro se a tabela não existir
                System.out.println("A tabela não existia. Criando uma nova.");
            }

            // Cria a tabela Aluno.
            stmt.executeUpdate("CREATE TABLE Aluno (nome VARCHAR(100), idade INT, curso VARCHAR(100))");

            // Insere dados de exemplo
            stmt.executeUpdate("INSERT INTO Aluno (nome, idade, curso) VALUES ('Ana', 23, 'Engenharia')");
            stmt.executeUpdate("INSERT INTO Aluno (nome, idade, curso) VALUES ('Bruno', 25, 'Medicina')");
            stmt.executeUpdate("INSERT INTO Aluno (nome, idade, curso) VALUES ('Carol', 22, 'Direito')");

            // Lista os dados da tabela.
            ResultSet rs = stmt.executeQuery("SELECT * FROM Aluno");
            while (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome") + ", Idade: " + rs.getInt("idade") + ", Curso: " + rs.getString("curso"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
