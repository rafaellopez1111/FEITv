package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAdmnDAO {

    private Connection conn;

    /**
     * cria o DAO responsável pelas operações da tabela admin_user
     * utilizando a conexão com o banco de dados.
     * @param conn
     */
    public UserAdmnDAO(Connection conn) {
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
     * executa uma query SELECT para verificar se um usuário
     * possui registro de administrador no banco de dados.
     * @param userId
     * @return
     * @throws SQLException
     */
    public boolean isAdmin(int userId) throws SQLException {
        String sql = "SELECT admin_id FROM admin_user WHERE user_id = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setInt(1, userId);
        ResultSet rs = statement.executeQuery();
        return rs.next();
    }

}