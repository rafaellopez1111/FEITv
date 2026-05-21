package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;

import model.Storage_User;
import model.dao.Conexao;
import model.dao.PlaylistDAO;
import model.dao.UserAdmnDAO;
import model.dao.VideoDAO;
import view.*;

public class Controller_Playlist {
    private static final String PLAYLIST_FAVORITOS = "Favoritos";
    private PlaylistDAO playlistdao;
    private VideoDAO videodao;
    private UserAdmnDAO userAdmnDAO;
    private JFrame_addplaylist jframe_addplaylist;
    private JFrame_listadefavs jframe_listadefavs;

    /**
     *construtor para a pagina de criar/excluir/editar playlists
     * @param jframe
     * @throws SQLException
     */
    public Controller_Playlist(JFrame_addplaylist jframe) throws SQLException {
        this.jframe_addplaylist = jframe;
        Conexao conexao = new Conexao();
        this.playlistdao = new PlaylistDAO(conexao.getConnection());
        this.videodao = new VideoDAO(conexao.getConnection());
        this.userAdmnDAO = new UserAdmnDAO(conexao.getConnection());
    }

    /**
     *construtor para a pagina de favoritos
     * @param jframe
     * @throws SQLException
     */
    public Controller_Playlist(JFrame_listadefavs jframe) throws SQLException {
        this.jframe_listadefavs = jframe;
        Conexao conexao = new Conexao();
        this.playlistdao = new PlaylistDAO(conexao.getConnection());
        this.videodao = new VideoDAO(conexao.getConnection());
        this.userAdmnDAO = new UserAdmnDAO(conexao.getConnection());
    }

    /**
     *funcao que permite o usuario criar uma tabela, usando do input dado na pagina para criar
     * uma playlist no banco de dados com o auxilio do metodo inserir de playlistdao
     */
    public void criarPlaylist() {
        String nome = this.jframe_addplaylist.getPlaylist_name().getText().trim();
        int userId = Storage_User.getUserId();

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

            this.playlistdao.inserir(nome, userId);
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

    /**
     *funcao que guarda o nomeatual da playlist e possibilita o usuario a mudar o nome com o
     * metodo renomear de playlistdao.
     */
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

    /**
     *funcao que exclui a playlist usando o input do usuario e o metodo excluir de playlistdao,
     * que tira as informacoes da playlist do banco de dados
     */
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

    /**
     *funcao implementada para realizar o retorno para a pagina inicial, com verificacao para identificar o usuario
     * como administrador ou nao.
     * @throws SQLException
     */
    public void voltar() throws SQLException {
        System.out.println(Storage_User.getUserId());
        boolean isAdm = this.userAdmnDAO.isAdmin(Storage_User.getUserId());
        if (isAdm) {
            JFrame_inicial_admin jframe = new JFrame_inicial_admin();
            jframe.initController();
            jframe.setVisible(true);
            jframe_addplaylist.setVisible(false);
        } else {
        JFrame_inicial inicio = new JFrame_inicial();
        inicio.initController();
        this.jframe_addplaylist.dispose();
        inicio.setVisible(true);}
    }

    /**
     *funcao que garante a existencia de uma playlist favoritos para que videos possam ser adicionados,
     * usa o metodo buscarpornome de playlist dao e inserir, para colocar a playlist no banco de dados
     * @return
     * @throws SQLException
     */
    private int garantirPlaylistFavoritos() throws SQLException {
        int playlistId = playlistdao.buscarPorNome(PLAYLIST_FAVORITOS);
        int userId = Storage_User.getUserId();
        if (playlistId == -1) {
            playlistdao.inserir(PLAYLIST_FAVORITOS, userId);
            playlistId = playlistdao.buscarPorNome(PLAYLIST_FAVORITOS);
        }
        return playlistId;
    }

    /**
     * Adiciona um video a playlist de favoritos utilizando o metodo adicionarVideo de playlistdao,
     * no banco de dados.
     */
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
            int userId = Storage_User.getUserId();
            System.out.println(userId);
            int videoId = videodao.buscarId(nomeVideo);
            if (videoId == -1) {
                JOptionPane.showMessageDialog(this.jframe_listadefavs,
                        "Vídeo \"" + nomeVideo + "\" não encontrado no banco.",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
                return;
            }


            playlistdao.adicionarVideo(playlistId, videoId);

            JOptionPane.showMessageDialog(this.jframe_listadefavs,
                    "Vídeo \"" + nomeVideo + "\" adicionado aos Favoritos!",
                    "SUCESSO", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_listadefavs,
                    "Erro ao adicionar vídeo:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * funcao usada para remover um video dos favoritos do usuario, buscando-o no banco de dados
     * por meio da funcao buscarId de videodao
     */
    public void removerVideoDosFavoritos() {
        String nomeVideo = this.jframe_listadefavs.getVideo_name_remove().getText().trim();
        int userId = Storage_User.getUserId();

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

    /**
     * funcao usada para a pagina inicial de favoritos e playlists ao apertar o botao
     */
    public void voltarListaFavs() {
        JFrame_Inicial_favoritos favs = new JFrame_Inicial_favoritos();
        favs.initController();
        this.jframe_listadefavs.setVisible(false);
        favs.setVisible(true);
    }
}