package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UserDAO {

    private Connection conn;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO users(full_name, username, birth_date, user_password) "
                + "VALUES(?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getFull_name());
        statement.setString(2, usuario.getUsername());
        statement.setDate(3, java.sql.Date.valueOf(usuario.getBirth_date()));
        statement.setString(4, usuario.getUser_password());
        statement.execute();
    }

    public ResultSet consultar(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, username);
        statement.execute();
        return statement.getResultSet();
    }

    // ★ NOVO: valida login (username + senha) e retorna o user_id, ou -1 se inválido
    public int validarLogin(String username, String password) throws SQLException {
        String sql = "SELECT user_id FROM users WHERE username = ? AND user_password = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("user_id"); // ★ retorna o ID do usuário
        }
        return -1; // não encontrou
    }

    public ResultSet consultarUsuarios() throws SQLException {
        String sql = "SELECT * FROM users";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.execute();
        return statement.getResultSet();
    }
}