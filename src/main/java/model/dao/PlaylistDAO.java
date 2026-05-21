package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaylistDAO {
    private Connection conn;

    /**
     * Construtor responsavel pelas operacoes na tabela playlist
     * @param conn
     */
    public PlaylistDAO(Connection conn) {
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
     * executa uma query INSERT para cadastrar uma nova playlist
     * associada a um usuário no banco de dados.
     * @param playlistName
     * @param userId
     * @throws SQLException
     */
    public void inserir(String playlistName, int userId) throws SQLException {
        String sql = "INSERT INTO playlist(playlist_name, user_Id) VALUES(?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, playlistName);
        statement.setInt(2, userId);
        statement.execute();
    }

    /**
     * executa uma query SELECT para buscar o ID de uma playlist
     * a partir do nome informado.
     * @param playlistName
     * @return
     * @throws SQLException
     */
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

    /**
     * executa uma query UPDATE para alterar o nome de uma playlist
     * já existente no banco de dados.
     * @param oldName
     * @param newName
     * @return
     * @throws SQLException
     */
    public boolean renomear(String oldName, String newName) throws SQLException {
        String sql = "UPDATE playlist SET playlist_name = ? WHERE playlist_name = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, newName);
        statement.setString(2, oldName);
        return statement.executeUpdate() > 0;
    }

    /**
     * executa queries DELETE para remover os vínculos da playlist
     * com vídeos e depois excluir a playlist do banco.
     * @param playlistName
     * @return
     * @throws SQLException
     */
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

    /**
     * executa uma query INSERT no banco de dados
     * para adicionar um vídeo em uma playlist.
     * @param playlistId
     * @param videoId
     * @throws SQLException
     */
    public void adicionarVideo(int playlistId, int videoId) throws SQLException {
        String sql = "INSERT INTO video_to_playlist(video_id, playlist_id) VALUES(?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, videoId);
        statement.setInt(2, playlistId);
        statement.execute();
    }

    /**
     * Executa uma query DELETE na no banco de dados
     * para remover um vídeo de uma playlist.
     * @param playlistId
     * @param videoId
     * @throws SQLException
     */
    public void removerVideo(int playlistId, int videoId) throws SQLException {
        String sql = "DELETE FROM video_to_playlist WHERE video_id = ? AND playlist_id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, videoId);
        statement.setInt(2, playlistId);
        statement.executeUpdate();
    }
}