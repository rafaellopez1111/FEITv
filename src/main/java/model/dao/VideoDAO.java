package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Video;

public class VideoDAO {
    private Connection conn;

    /**
     * Construtor dao para conexao com o banco
     * @param conn
     */
    public VideoDAO(Connection conn) {
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
     * executa uma query INSERT para cadastrar um novo vídeo
     * na tabela video do banco de dados.
     * @param video
     * @throws SQLException
     */
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

    /**
     * executa uma query SELECT para buscar o ID de um vídeo
     * a partir do nome informado.
     * @param videoName
     * @return
     * @throws SQLException
     */
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

    /**
     * executa uma query SELECT para consultar um vídeo
     * a partir do nome informado.
     * @param videoName
     * @return
     * @throws SQLException
     */
    public ResultSet consultar(String videoName) throws SQLException {
        String sql = "SELECT * FROM video WHERE video_name = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, videoName);
        return statement.executeQuery();
    }

    /**
     * executa uma query SELECT para consultar todos os vídeos
     * cadastrados na tabela video.
     * @return
     * @throws SQLException
     */
    public ResultSet consultarVideos() throws SQLException {
        String sql = "SELECT * FROM video";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        return statement.executeQuery();
    }

    /**
     * executa uma query DELETE para remover um vídeo
     * da tabela video do banco de dados.
     * @param videoName
     * @return
     * @throws SQLException
     */
    public boolean excluir(String videoName) throws SQLException {
        String sql = "DELETE FROM video WHERE video_name = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, videoName);
        int rowsAffected = statement.executeUpdate();
        return rowsAffected > 0;
    }

    /**
     * executa uma query UPDATE para incrementar a quantidade
     * de curtidas de um vídeo.
     * @param videoName
     * @return
     * @throws SQLException
     */
    public boolean curtir(String videoName) throws SQLException {
        String sql = "UPDATE video SET like_amount = like_amount + 1 WHERE video_name = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, videoName);
        return statement.executeUpdate() > 0;
    }

    /**
     * executa uma query UPDATE para incrementar a quantidade
     * de descurtidas de um vídeo.
     * @param videoName
     * @return
     * @throws SQLException
     */
    public boolean descurtir(String videoName) throws SQLException {
        String sql = "UPDATE video SET dislike_amount = dislike_amount + 1 WHERE video_name = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, videoName);
        return statement.executeUpdate() > 0;
    }

    /**
     * executa uma query UPDATE para remover uma curtida
     * de um vídeo caso o total seja maior que zero.
     * @param videoName
     * @return
     * @throws SQLException
     */
    public boolean removerCurtida(String videoName) throws SQLException {
        String sql = "UPDATE video SET like_amount = like_amount - 1 WHERE video_name = ? AND like_amount > 0";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, videoName);
        return statement.executeUpdate() > 0;
    }

    /**
     * executa uma query SELECT para consultar os vídeos
     * mais curtidos utilizando um limite de resultados.
     * @param limit
     * @return
     * @throws SQLException
     */
    public ResultSet consultarMaisCurtidos(int limit) throws SQLException {
        String sql = "SELECT video_name, like_amount, dislike_amount, release_date " +
                "FROM video ORDER BY like_amount DESC LIMIT ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setInt(1, limit);
        return statement.executeQuery();
    }
}