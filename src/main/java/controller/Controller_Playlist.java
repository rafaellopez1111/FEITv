package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.dao.Conexao;
import model.dao.PlaylistDAO;
import model.dao.VideoDAO;
import view.JFrame_addplaylist;
import view.JFrame_inicial;
import view.JFrame_Inicial_favoritos;
import view.JFrame_listadefavs;

public class Controller_Playlist {

    private static final String PLAYLIST_FAVORITOS = "Favoritos";

    private PlaylistDAO playlistdao;
    private VideoDAO videodao;

    private JFrame_addplaylist jframe_addplaylist;
    private JFrame_listadefavs jframe_listadefavs;

    // ✅ Construtor para CRUD de playlist
    public Controller_Playlist(JFrame_addplaylist jframe) throws SQLException {
        this.jframe_addplaylist = jframe;
        Conexao conexao = new Conexao();
        this.playlistdao = new PlaylistDAO(conexao.getConnection());
        this.videodao = new VideoDAO(conexao.getConnection());
    }

    // ✅ Construtor para adicionar/remover vídeos dos favoritos
    public Controller_Playlist(JFrame_listadefavs jframe) throws SQLException {
        this.jframe_listadefavs = jframe;
        Conexao conexao = new Conexao();
        this.playlistdao = new PlaylistDAO(conexao.getConnection());
        this.videodao = new VideoDAO(conexao.getConnection());
    }

    // ============================================================
    //  CRUD PLAYLIST (JFrame_addplaylist)
    // ============================================================
    public void criarPlaylist() {
        String nome = this.jframe_addplaylist.getPlaylist_name().getText().trim();

        if (nome.isEmpty() || nome.equals("NOME DA PLAYLIST")) {
            JOptionPane.showMessageDialog(this.jframe_addplaylist,
                    "Digite o nome da playlist!",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            if (this.playlistdao.buscarPorNome(nome) != -1) {
                JOptionPane.showMessageDialog(this.jframe_addplaylist,
                        "Já existe uma playlist com esse nome!",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.playlistdao.inserir(nome);
            JOptionPane.showMessageDialog(this.jframe_addplaylist,
                    "Playlist \"" + nome + "\" criada com sucesso!",
                    "SUCESSO", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_addplaylist,
                    "Erro ao criar playlist:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editarPlaylist() {
        String nomeAtual = this.jframe_addplaylist.getEdit_playlist().getText().trim();

        if (nomeAtual.isEmpty() || nomeAtual.equals("NOME DA PLAYLIST")) {
            JOptionPane.showMessageDialog(this.jframe_addplaylist,
                    "Digite o nome da playlist que deseja editar!",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            if (this.playlistdao.buscarPorNome(nomeAtual) == -1) {
                JOptionPane.showMessageDialog(this.jframe_addplaylist,
                        "Playlist \"" + nomeAtual + "\" não encontrada!",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String novoNome = JOptionPane.showInputDialog(this.jframe_addplaylist,
                    "Digite o novo nome para a playlist:",
                    "EDITAR PLAYLIST", JOptionPane.QUESTION_MESSAGE);

            if (novoNome == null || novoNome.trim().isEmpty()) return;

            boolean editou = this.playlistdao.renomear(nomeAtual, novoNome.trim());
            if (editou) {
                JOptionPane.showMessageDialog(this.jframe_addplaylist,
                        "Playlist renomeada para \"" + novoNome.trim() + "\"!",
                        "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this.jframe_addplaylist,
                        "Erro ao renomear playlist.",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_addplaylist,
                    "Erro ao editar playlist:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void excluirPlaylist() {
        String nome = this.jframe_addplaylist.getExclude_playlist().getText().trim();

        if (nome.isEmpty() || nome.equals("NOME DA PLAYLIST")) {
            JOptionPane.showMessageDialog(this.jframe_addplaylist,
                    "Digite o nome da playlist para excluir!",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(this.jframe_addplaylist,
                "Tem certeza que deseja excluir a playlist \"" + nome + "\"?\n"
                        + "Os vídeos vinculados serão removidos da playlist.",
                "CONFIRMAR EXCLUSÃO", JOptionPane.YES_NO_OPTION);

        if (confirmacao != JOptionPane.YES_OPTION) return;

        try {
            boolean excluiu = this.playlistdao.excluir(nome);
            if (excluiu) {
                JOptionPane.showMessageDialog(this.jframe_addplaylist,
                        "Playlist \"" + nome + "\" excluída!",
                        "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this.jframe_addplaylist,
                        "Playlist não encontrada.",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_addplaylist,
                    "Erro ao excluir playlist:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void voltar() {
        JFrame_inicial inicio = new JFrame_inicial();
        inicio.initController();
        this.jframe_addplaylist.dispose();
        inicio.setVisible(true);
    }

    // ============================================================
    //  FAVORITOS (JFrame_listadefavs)
    // ============================================================

    // ✅ garante que a playlist Favoritos existe e devolve o ID dela
    private int garantirPlaylistFavoritos() throws SQLException {
        int playlistId = playlistdao.buscarPorNome(PLAYLIST_FAVORITOS);
        if (playlistId == -1) {
            playlistdao.inserir(PLAYLIST_FAVORITOS);
            playlistId = playlistdao.buscarPorNome(PLAYLIST_FAVORITOS);
        }
        return playlistId;
    }

    public void adicionarVideoNosFavoritos() {
        String nomeVideo = this.jframe_listadefavs.getVideo_name_add().getText().trim();

        if (nomeVideo.isEmpty() || nomeVideo.equals("NOME DO VÍDEO")) {
            JOptionPane.showMessageDialog(this.jframe_listadefavs,
                    "Digite o nome do vídeo para adicionar!",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int playlistId = garantirPlaylistFavoritos();

            int videoId = videodao.buscarId(nomeVideo);
            if (videoId == -1) {
                JOptionPane.showMessageDialog(this.jframe_listadefavs,
                        "Vídeo \"" + nomeVideo + "\" não encontrado no banco.",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // tenta inserir vínculo
            playlistdao.adicionarVideo(playlistId, videoId);

            JOptionPane.showMessageDialog(this.jframe_listadefavs,
                    "Vídeo \"" + nomeVideo + "\" adicionado aos Favoritos!",
                    "SUCESSO", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            // se você tiver unique constraint (video_id, playlist_id), pode cair aqui quando duplicar
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_listadefavs,
                    "Erro ao adicionar vídeo:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void removerVideoDosFavoritos() {
        String nomeVideo = this.jframe_listadefavs.getVideo_name_remove().getText().trim();

        if (nomeVideo.isEmpty() || nomeVideo.equals("NOME DO VÍDEO")) {
            JOptionPane.showMessageDialog(this.jframe_listadefavs,
                    "Digite o nome do vídeo para remover!",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int playlistId = garantirPlaylistFavoritos();

            int videoId = videodao.buscarId(nomeVideo);
            if (videoId == -1) {
                JOptionPane.showMessageDialog(this.jframe_listadefavs,
                        "Vídeo \"" + nomeVideo + "\" não encontrado no banco.",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
                return;
            }

            playlistdao.removerVideo(playlistId, videoId);

            JOptionPane.showMessageDialog(this.jframe_listadefavs,
                    "Vídeo \"" + nomeVideo + "\" removido dos Favoritos!",
                    "SUCESSO", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_listadefavs,
                    "Erro ao remover vídeo:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void voltarListaFavs() {
        JFrame_Inicial_favoritos favs = new JFrame_Inicial_favoritos();
        favs.initController();
        this.jframe_listadefavs.dispose();
        favs.setVisible(true);
    }
}