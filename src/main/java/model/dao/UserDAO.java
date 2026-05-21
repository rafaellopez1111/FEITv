package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UserDAO {
    private Connection conn;

    /**
     * Construtor dao para conexao com o banco
     * @param conn
     */
    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * retorna a conexão atualmente utilizada pelo DAO.
     * @return
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * define uma nova conexão para ser utilizada pelo DAO.
     * @param conn
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    /**
     * executa uma query INSERT para cadastrar um novo usuário
     * na tabela users do banco de dados.
     * @param usuario
     * @throws SQLException
     */
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

    /**
     * executa uma query SELECT para consultar um usuário
     * a partir do username informado.
     * @param username
     * @return
     * @throws SQLException
     */
    public ResultSet consultar(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, username);
        statement.execute();
        return statement.getResultSet();
    }

    /**
     * executa uma query SELECT para validar o login do usuário
     * utilizando username e senha.
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public int validarLogin(String username, String password) throws SQLException {
        String sql = "SELECT user_id FROM users WHERE username = ? AND user_password = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("user_id");
        }
        return -1;
    }

    /**
     * executa uma query SELECT para consultar todos os usuários
     * cadastrados na tabela users.
     * @return
     * @throws SQLException
     */
    public ResultSet consultarUsuarios() throws SQLException {
        String sql = "SELECT * FROM users";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.execute();
        return statement.getResultSet();
    }
}