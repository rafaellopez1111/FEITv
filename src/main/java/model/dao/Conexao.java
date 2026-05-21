/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rafael
 */
public class Conexao {
    /**
     * funcao responsavel pelo conexao do sistema com o banco de dados, identificando o caminho,
     * a porta e a senha necessarios para acessar o banco.
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        Dotenv dotenv = Dotenv.load();
        Connection conexao = DriverManager.getConnection(
            "jdbc:postgresql://localhost:8080/postgres", "postgres",
                dotenv.get("SENHA_DB"));
        System.out.println("Conexao bem sucedida"); 
        return conexao;
    }
}