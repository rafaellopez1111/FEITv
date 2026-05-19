package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Video;

public class VideoDAO {

    private Connection conn;

    public VideoDAO(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Video video) throws SQLException {
        String sql = "INSERT INTO video(video_name, release_date, like_amount, dislike_amount, description) "
                + "VALUES(?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, video.getVideo_name());
        statement.setDate(2, java.sql.Date.valueOf(video.getRelease_date()));
        statement.setInt(3, video.getLike_amount());
        statement.setInt(4, video.getDislike_amount());
        statement.setString(5, video.getDescription());
        statement.execute();
    }

    public int buscarId(String videoName) throws SQLException {
        String sql = "SELECT video_id FROM video WHERE video_name = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, videoName);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("video_id");
        }
        return -1;
    }

    public ResultSet consultar(String videoName) throws SQLException {
        String sql = "SELECT * FROM video WHERE video_name = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, videoName);
        return statement.executeQuery();
    }

    public ResultSet consultarVideos() throws SQLException {
        String sql = "SELECT * FROM video";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        return statement.executeQuery();
    }

    public boolean excluir(String videoName) throws SQLException {
        String sql = "DELETE FROM video WHERE video_name = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, videoName);
        int rowsAffected = statement.executeUpdate();
        return rowsAffected > 0;
    }
    public boolean curtir(String videoName) throws SQLException {
        String sql = "UPDATE video SET like_amount = like_amount + 1 WHERE video_name = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, videoName);
        return statement.executeUpdate() > 0;
    }

    public boolean descurtir(String videoName) throws SQLException {
        String sql = "UPDATE video SET dislike_amount = dislike_amount + 1 WHERE video_name = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, videoName);
        return statement.executeUpdate() > 0;
    }

    public boolean removerCurtida(String videoName) throws SQLException {
        String sql = "UPDATE video SET like_amount = like_amount - 1 WHERE video_name = ? AND like_amount > 0";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, videoName);
        return statement.executeUpdate() > 0;
    }

    public ResultSet consultarMaisCurtidos(int limit) throws SQLException {
        String sql = "SELECT video_name, like_amount, dislike_amount, release_date " +
                "FROM video ORDER BY like_amount DESC LIMIT ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setInt(1, limit);
        return statement.executeQuery();
    }
}