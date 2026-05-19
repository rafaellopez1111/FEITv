package controller;

import view.JFrame_Inicial_favoritos;
import view.JFrame_addplaylist;
import view.JFrame_inicial;
import view.JFrame_listadefavs;

public class Controller_inicial_favoritos {

    private JFrame_Inicial_favoritos jframe;

    public Controller_inicial_favoritos(JFrame_Inicial_favoritos jframe) {
        this.jframe = jframe;
    }

    // 1) Abre tela CRUD de playlist
    public void abrirPlaylistCRUD() {
        JFrame_addplaylist tela = new JFrame_addplaylist();
        tela.initController();          // IMPORTANTÍSSIMO
        tela.setVisible(true);
        this.jframe.setVisible(false);
    }

    // 2) Abre tela para adicionar/remover vídeos dos favoritos
    public void abrirGerenciarVideosFavoritos() {
        JFrame_listadefavs tela = new JFrame_listadefavs();
        tela.initController();          // IMPORTANTÍSSIMO
        tela.setVisible(true);
        this.jframe.setVisible(false);
    }

    // 3) Volta para a tela inicial (usuário normal)
    public void voltar() {
        JFrame_inicial inicio = new JFrame_inicial();
        inicio.initController();        // IMPORTANTÍSSIMO
        inicio.setVisible(true);
        this.jframe.dispose();
    }
}