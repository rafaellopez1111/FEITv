package controller;

import view.JFrame_Inicial_favoritos;
import view.JFrame_addplaylist;
import view.JFrame_inicial;
import view.JFrame_listadefavs;

public class Controller_inicial_favoritos {
    private JFrame_Inicial_favoritos jframe;

    /**
     * construtor usado na pagina inicial de playlists
     * @param jframe
     */
    public Controller_inicial_favoritos(JFrame_Inicial_favoritos jframe) {
        this.jframe = jframe;
    }

    /**
     * funcao para abrir a pagina de criacao/edicao/exclusao de playlist
     */
    public void abrirPlaylistCRUD() {
        JFrame_addplaylist tela = new JFrame_addplaylist();
        tela.initController();
        tela.setVisible(true);
        this.jframe.setVisible(false);
    }

    /**
     * funcao para abrir o menu para gerenciar os videos dentro da playlist de favoritos
     */
    public void abrirGerenciarVideosFavoritos() {
        JFrame_listadefavs tela = new JFrame_listadefavs();
        tela.initController();
        tela.setVisible(true);
        this.jframe.setVisible(false);
    }

    /**
     * funcao para voltar ao menu inicial do programa ao clicar no botao
     */
    public void voltar() {
        JFrame_inicial inicio = new JFrame_inicial();
        inicio.initController();
        inicio.setVisible(true);
        this.jframe.dispose();
    }
}