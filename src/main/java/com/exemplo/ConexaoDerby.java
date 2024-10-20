package com.exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ConexaoDerby {
    private static final Logger LOGGER = Logger.getLogger(ConexaoDerby.class.getName());
    private static final String JDBC_URL = "jdbc:derby:myDB;create=true";
    private static final String USER = "admin";
    private static final String PASSWORD = "adminpassword";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            // Apaga a tabela Aluno se ela existir.
            String dropTableSQL = "DROP TABLE Aluno";
            LOGGER.log(Level.INFO, "Executando SQL: {0}", dropTableSQL);
            try {
                stmt.executeUpdate(dropTableSQL);
            } catch (SQLException e) {
                // Ignora o erro se a tabela não existir.
                LOGGER.log(Level.INFO, "A tabela não existia. Criando uma nova.");
            }

            // Cria a tabela Aluno.
            String createTableSQL = "CREATE TABLE Aluno (nome VARCHAR(100), idade INT, curso VARCHAR(100))";
            LOGGER.log(Level.INFO, "Executando SQL: {0}", createTableSQL);
            stmt.executeUpdate(createTableSQL);

            // Insere dados de exemplo.
            String insertSQL = "INSERT INTO Aluno (nome, idade, curso) VALUES ('{0}', {1}, '{2}')";
            LOGGER.log(Level.INFO, "Executando SQL: {0}", insertSQL);
            stmt.executeUpdate("INSERT INTO Aluno (nome, idade, curso) VALUES ('Ana', 23, 'Engenharia')");
            stmt.executeUpdate("INSERT INTO Aluno (nome, idade, curso) VALUES ('Bruno', 25, 'Medicina')");
            stmt.executeUpdate("INSERT INTO Aluno (nome, idade, curso) VALUES ('Carol', 22, 'Direito')");

            // Lista os dados da tabela.
            String selectSQL = "SELECT * FROM Aluno";
            LOGGER.log(Level.INFO, "Executando SQL: {0}", selectSQL);
            System.out.println("=======================================================");
            ResultSet rs = stmt.executeQuery(selectSQL);
            while (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome") + ", Idade: " + rs.getInt("idade") + ", Curso: " + rs.getString("curso"));
            }
            System.out.println("=======================================================");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
