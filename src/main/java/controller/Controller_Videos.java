package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import model.Video;
import model.dao.Conexao;
import model.dao.PlaylistDAO;
import model.dao.VideoDAO;
import view.*;

public class Controller_Videos {

    private VideoDAO videodao;
    private PlaylistDAO playlistdao;
    private Jframe_Buscar jframe_buscar;
    private JFrame_cadastrarvideo jframe_cadastrar;
    private JFrame_curtidas jframe_curtidas;           // ★ NOVO
    private JFrame_info jframe_info;

    public Controller_Videos(Jframe_Buscar jframe_buscar) throws SQLException {
        this.jframe_buscar = jframe_buscar;
        Conexao conexao = new Conexao();
        this.videodao = new VideoDAO(conexao.getConnection());
        this.playlistdao = new PlaylistDAO(conexao.getConnection());
    }

    public Controller_Videos(JFrame_cadastrarvideo jframe_cadastrar) throws SQLException {
        this.jframe_cadastrar = jframe_cadastrar;
        Conexao conexao = new Conexao();
        this.videodao = new VideoDAO(conexao.getConnection());
        this.playlistdao = new PlaylistDAO(conexao.getConnection());
    }

    public Controller_Videos(JFrame_curtidas jframe_curtidas) throws SQLException {
        this.jframe_curtidas = jframe_curtidas;
        Conexao conexao = new Conexao();
        this.videodao = new VideoDAO(conexao.getConnection());
    }

    public Controller_Videos(JFrame_info jframe_info) throws SQLException {
        this.jframe_info = jframe_info;
        Conexao conexao = new Conexao();
        this.videodao = new VideoDAO(conexao.getConnection());
    }

    public void buscarVideo() {
        String nomeVideo = this.jframe_buscar.getVideo_name().getText().trim();

        if (nomeVideo.isEmpty() || nomeVideo.equals("NOME DO VÍDEO")) {
            JOptionPane.showMessageDialog(this.jframe_buscar,
                    "Digite o nome do vídeo antes de buscar.",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            ResultSet resultado = this.videodao.consultar(nomeVideo);
            boolean encontrou = false;

            while (resultado.next()) {
                String rNome = resultado.getString("video_name");
                if (rNome.equalsIgnoreCase(nomeVideo)) {
                    encontrou = true;
                    JOptionPane.showMessageDialog(this.jframe_buscar,
                            "Vídeo encontrado: " + rNome,
                            "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
            resultado.close();

            if (!encontrou) {
                JOptionPane.showMessageDialog(this.jframe_buscar,
                        "Vídeo não encontrado.",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_buscar,
                    "Erro ao buscar vídeo:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void favoritarVideo() {
        String nomeVideo = this.jframe_buscar.getVideo_name().getText().trim();

        if (nomeVideo.isEmpty() || nomeVideo.equals("NOME DO VÍDEO")) {
            JOptionPane.showMessageDialog(this.jframe_buscar,
                    "Busque um vídeo antes de favoritar.",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int videoId = this.videodao.buscarId(nomeVideo);
            if (videoId == -1) {
                JOptionPane.showMessageDialog(this.jframe_buscar,
                        "Vídeo \"" + nomeVideo + "\" não encontrado no banco!",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nomePlaylist = JOptionPane.showInputDialog(this.jframe_buscar,
                    "Digite o nome da playlist para adicionar o vídeo:",
                    "FAVORITAR", JOptionPane.QUESTION_MESSAGE);

            if (nomePlaylist == null || nomePlaylist.trim().isEmpty()) return;
            nomePlaylist = nomePlaylist.trim();

            int playlistId = this.playlistdao.buscarPorNome(nomePlaylist);
            if (playlistId == -1) {
                JOptionPane.showMessageDialog(this.jframe_buscar,
                        "Playlist \"" + nomePlaylist + "\" não encontrada!\nCrie a playlist primeiro.",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.playlistdao.adicionarVideo(playlistId, videoId);
            JOptionPane.showMessageDialog(this.jframe_buscar,
                    "Vídeo \"" + nomeVideo + "\" adicionado à playlist \"" + nomePlaylist + "\"!",
                    "SUCESSO", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_buscar,
                    "Erro ao favoritar vídeo:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void curtirVideo() {
        String nomeVideo = this.jframe_curtidas.getVideo_name().getText().trim();

        if (nomeVideo.isEmpty() || nomeVideo.equals("NOME DO VÍDEO")) {
            JOptionPane.showMessageDialog(this.jframe_curtidas,
                    "Digite o nome do vídeo para curtir!",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            boolean curtiu = this.videodao.curtir(nomeVideo);
            if (curtiu) {
                JOptionPane.showMessageDialog(this.jframe_curtidas,
                        "Vídeo \"" + nomeVideo + "\" curtido! 👍",
                        "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this.jframe_curtidas,
                        "Vídeo não encontrado.",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_curtidas,
                    "Erro ao curtir vídeo:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void descurtirVideo() {
        String nomeVideo = this.jframe_curtidas.getDislike_video_name().getText().trim();

        if (nomeVideo.isEmpty() || nomeVideo.equals("NOME DO VÍDEO")) {
            JOptionPane.showMessageDialog(this.jframe_curtidas,
                    "Digite o nome do vídeo para descurtir!",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            boolean removeu = this.videodao.removerCurtida(nomeVideo);
            if (removeu) {
                JOptionPane.showMessageDialog(this.jframe_curtidas,
                        "Curtida removida de \"" + nomeVideo + "\"!",
                        "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this.jframe_curtidas,
                        "Vídeo não encontrado ou não tem curtidas.",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_curtidas,
                    "Erro ao descurtir vídeo:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void darDislike() {
        String nomeVideo = this.jframe_curtidas.getDislike_video_name1().getText().trim();

        if (nomeVideo.isEmpty() || nomeVideo.equals("NOME DO VÍDEO")) {
            JOptionPane.showMessageDialog(this.jframe_curtidas,
                    "Digite o nome do vídeo para dar dislike!",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            boolean dislikou = this.videodao.descurtir(nomeVideo);
            if (dislikou) {
                JOptionPane.showMessageDialog(this.jframe_curtidas,
                        "Dislike dado em \"" + nomeVideo + "\"! 👎",
                        "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this.jframe_curtidas,
                        "Vídeo não encontrado.",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_curtidas,
                    "Erro ao dar dislike:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void criarVideo() {
        String nome = this.jframe_cadastrar.getVideo_name().getText().trim();
        String dataStr = this.jframe_cadastrar.getDate().getText().trim();
        String descricao = this.jframe_cadastrar.getDescription().getText().trim();

        if (nome.isEmpty() || nome.equals("NOME DO VÍDEO")
                || dataStr.isEmpty() || dataStr.equals("DATA DE LANÇAMENTO")
                || descricao.isEmpty() || descricao.equals("DESCRIÇÃO")) {
            JOptionPane.showMessageDialog(this.jframe_cadastrar,
                    "Preencha todos os campos para criar o vídeo!",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            LocalDate.parse(dataStr);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this.jframe_cadastrar,
                    "Data inválida!\nUse o formato: AAAA-MM-DD",
                    "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Video video = new Video(nome, dataStr, descricao);
        try {
            this.videodao.inserir(video);
            JOptionPane.showMessageDialog(this.jframe_cadastrar,
                    "Vídeo \"" + nome + "\" criado com sucesso!",
                    "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_cadastrar,
                    "Erro ao criar vídeo:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void excluirVideo() {
        String nome = this.jframe_cadastrar.getName_exclude().getText().trim();

        if (nome.isEmpty() || nome.equals("NOME DO VÍDEO")) {
            JOptionPane.showMessageDialog(this.jframe_cadastrar,
                    "Digite o nome do vídeo para excluir!",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(this.jframe_cadastrar,
                "Tem certeza que deseja excluir \"" + nome + "\"?",
                "CONFIRMAR EXCLUSÃO", JOptionPane.YES_NO_OPTION);

        if (confirmacao != JOptionPane.YES_OPTION) return;

        try {
            boolean excluiu = this.videodao.excluir(nome);
            if (excluiu) {
                JOptionPane.showMessageDialog(this.jframe_cadastrar,
                        "Vídeo \"" + nome + "\" excluído!",
                        "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this.jframe_cadastrar,
                        "Vídeo não encontrado.",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_cadastrar,
                    "Erro ao excluir vídeo:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void listarVideos() {
        try {
            ResultSet resultado = this.videodao.consultarVideos();
            StringBuilder lista = new StringBuilder();
            int count = 0;

            while (resultado.next()) {
                count++;
                String nome = resultado.getString("video_name");
                String data = resultado.getString("release_date");
                int likes = resultado.getInt("like_amount");
                int dislikes = resultado.getInt("dislike_amount");
                String descricao = resultado.getString("description");

                lista.append(count).append(". ").append(nome).append("\n")
                        .append("   Data: ").append(data).append("\n")
                        .append("   Likes: ").append(likes)
                        .append(" | Dislikes: ").append(dislikes).append("\n")
                        .append("   Descrição: ").append(descricao).append("\n\n");
            }
            resultado.close();

            if (count == 0) {
                JOptionPane.showMessageDialog(this.jframe_info,
                        "Nenhum vídeo cadastrado.",
                        "INFO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this.jframe_info,
                        lista.toString(),
                        "VÍDEOS CADASTRADOS (" + count + ")", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_info,
                    "Erro ao listar vídeos:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ── Field ────────────────────────────────────────────────────
    private JFrame_visualizarestatisticas jframe_estatisticas;

    // ── Construtor para tela de ESTATÍSTICAS ─────────────────────
    public Controller_Videos(JFrame_visualizarestatisticas jframe_estatisticas) throws SQLException {
        this.jframe_estatisticas = jframe_estatisticas;
        Conexao conexao = new Conexao();
        this.videodao = new VideoDAO(conexao.getConnection());
    }

    // ══════════════════════════════════════════════════════════════
//  VÍDEOS MAIS CURTIDOS
// ══════════════════════════════════════════════════════════════
    public void listarMaisCurtidos() {
        try {
            ResultSet rs = this.videodao.consultarMaisCurtidos(10);
            StringBuilder sb = new StringBuilder();
            int count = 0;

            while (rs.next()) {
                count++;
                String nome = rs.getString("video_name");
                int likes = rs.getInt("like_amount");
                int dislikes = rs.getInt("dislike_amount");
                String data = rs.getString("release_date");

                sb.append(count).append(". ").append(nome).append("\n")
                        .append("   Data: ").append(data).append("\n")
                        .append("   Likes: ").append(likes)
                        .append(" | Dislikes: ").append(dislikes).append("\n\n");
            }
            rs.close();

            if (count == 0) {
                JOptionPane.showMessageDialog(this.jframe_estatisticas,
                        "Nenhum vídeo cadastrado.",
                        "INFO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this.jframe_estatisticas,
                        sb.toString(),
                        "TOP " + count + " VÍDEOS MAIS CURTIDOS", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_estatisticas,
                    "Erro ao listar vídeos:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void listarTodosVideosEstatisticas() {
        try {
            ResultSet rs = this.videodao.consultarVideos();
            StringBuilder sb = new StringBuilder();
            int count = 0;

            while (rs.next()) {
                count++;
                String nome = rs.getString("video_name");
                String data = rs.getString("release_date");
                int likes = rs.getInt("like_amount");
                int dislikes = rs.getInt("dislike_amount");
                String desc = rs.getString("description");

                sb.append(count).append(". ").append(nome).append("\n")
                        .append("   Data: ").append(data).append("\n")
                        .append("   Likes: ").append(likes)
                        .append(" | Dislikes: ").append(dislikes).append("\n")
                        .append("   Descrição: ").append(desc).append("\n\n");
            }
            rs.close();

            if (count == 0) {
                JOptionPane.showMessageDialog(this.jframe_estatisticas,
                        "Nenhum vídeo cadastrado.",
                        "INFO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this.jframe_estatisticas,
                        sb.toString(),
                        "VÍDEOS CADASTRADOS (" + count + ")", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_estatisticas,
                    "Erro ao listar vídeos:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void voltarEstatisticas() {
        JFrame_inicial_admin admin = new JFrame_inicial_admin();
        admin.initController();
        admin.setVisible(true);
        this.jframe_estatisticas.dispose();
    }
    public void voltarInfo() {
        JFrame_inicial inicio = new JFrame_inicial();
        inicio.initController();
        this.jframe_info.dispose();
        inicio.setVisible(true);
    }

    public void voltarBuscar() {
        JFrame_inicial inicio = new JFrame_inicial();
        inicio.initController();
        this.jframe_buscar.dispose();
        inicio.setVisible(true);
    }

    public void voltarCadastrar() {
        JFrame_inicial_admin jFrame_inicial_admin = new JFrame_inicial_admin();
        jFrame_inicial_admin.initController();
        jFrame_inicial_admin.setVisible(true);
        this.jframe_cadastrar.dispose();
    }

    public void voltarCurtidas() {
        JFrame_inicial_admin jFrame_inicial_admin = new JFrame_inicial_admin();
        jFrame_inicial_admin.initController();
        jFrame_inicial_admin.setVisible(true);
        this.jframe_curtidas.dispose();
    }
}