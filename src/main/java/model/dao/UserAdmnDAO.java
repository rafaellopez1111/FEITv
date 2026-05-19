package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAdmnDAO {

    private Connection conn;

    public UserAdmnDAO(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    // ★ CORRIGIDO: busca pelo user_id (a tabela admin_user não tem username)
    public boolean isAdmin(int userId) throws SQLException {
        String sql = "SELECT admin_id FROM admin_user WHERE user_id = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setInt(1, userId);
        ResultSet rs = statement.executeQuery();
        return rs.next(); // true se encontrou registro = é admin
    }

    public ResultSet consultarUsuarioadm() throws SQLException {
        String sql = "SELECT * FROM admin_user";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.execute();
        return statement.getResultSet();
    }
}