package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaylistDAO {

    private Connection conn;

    public PlaylistDAO(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public void inserir(String playlistName) throws SQLException {
        String sql = "INSERT INTO playlist(playlist_name) VALUES(?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, playlistName);
        statement.execute();
    }

    public int buscarPorNome(String playlistName) throws SQLException {
        String sql = "SELECT playlist_id FROM playlist WHERE playlist_name = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, playlistName);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("playlist_id");
        }
        return -1;
    }

    public boolean renomear(String oldName, String newName) throws SQLException {
        String sql = "UPDATE playlist SET playlist_name = ? WHERE playlist_name = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, newName);
        statement.setString(2, oldName);
        return statement.executeUpdate() > 0;
    }

    public boolean excluir(String playlistName) throws SQLException {
        int playlistId = buscarPorNome(playlistName);
        if (playlistId == -1) {
            return false;
        }

        String sqlJunction = "DELETE FROM video_to_playlist WHERE playlist_id = ?";
        PreparedStatement stmtJunction = conn.prepareStatement(sqlJunction);
        stmtJunction.setInt(1, playlistId);
        stmtJunction.executeUpdate();

        String sqlPlaylist = "DELETE FROM playlist WHERE playlist_id = ?";
        PreparedStatement stmtPlaylist = conn.prepareStatement(sqlPlaylist);
        stmtPlaylist.setInt(1, playlistId);
        return stmtPlaylist.executeUpdate() > 0;
    }

    public void adicionarVideo(int playlistId, int videoId) throws SQLException {
        String sql = "INSERT INTO video_to_playlist(video_id, playlist_id) VALUES(?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, videoId);
        statement.setInt(2, playlistId);
        statement.execute();
    }

    public void removerVideo(int playlistId, int videoId) throws SQLException {
        String sql = "DELETE FROM video_to_playlist WHERE video_id = ? AND playlist_id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, videoId);
        statement.setInt(2, playlistId);
        statement.executeUpdate();
    }
}