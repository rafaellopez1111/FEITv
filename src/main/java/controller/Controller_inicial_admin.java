package controller;

import javax.swing.JOptionPane;
import view.*;

public class Controller_inicial_admin {

    private JFrame_inicial_admin jframe_admin;

    /**
     * construtor usado na pagina inicial
     * @param jframe_admin
     */
    public Controller_inicial_admin(JFrame_inicial_admin jframe_admin) {
        this.jframe_admin = jframe_admin;
    }

    /**
     * funcao que direciona o usuario para a pagina de buscar videos ao clicar no botao
     */
    public void paginabuscar() {
        Jframe_Buscar jframe_buscar = new Jframe_Buscar();
        jframe_buscar.initController();
        jframe_buscar.setVisible(true);
        this.jframe_admin.setVisible(false);
    }

    /**
     * funcao que direciona o usuario para a pagina de listar informacoes de videos buscados
     * ao clicar no botao
     */
    public void paginalistar() {
        JFrame_info jFrame_info = new JFrame_info();
        jFrame_info.initController();
        jFrame_info.setVisible(true);
        this.jframe_admin.setVisible(false);
    }

    /**
     * funcao que direciona o usuario para a pagina de curtir ou descurtir videos ao clicar no botao
     */
    public void paginacurtidas() {
        JFrame_curtidas jFrame_curtidas = new JFrame_curtidas();
        jFrame_curtidas.initController();
        jFrame_curtidas.setVisible(true);
        this.jframe_admin.setVisible(false);
    }

    /**
     * funcao que direciona o usuario para o menu inicial de playlists ao clicar no botao
     */
    public void paginaplaylist() {
        JFrame_addplaylist jframe_addplaylist = new JFrame_addplaylist();
        jframe_addplaylist.initController();
        jframe_addplaylist.setVisible(true);
        this.jframe_admin.setVisible(false);
    }

    /**
     * funcao que direciona o usuario para a pagina de consultar informacoes do usuario
     * ao clicar no botao
     */
    public void paginaConsultarUsuarios() {
        JFrame_consultaruser jframe_consultar = new JFrame_consultaruser();
        jframe_consultar.initController();
        jframe_consultar.setVisible(true);
        this.jframe_admin.setVisible(false);
    }

    /**
     * funcao que direciona o usuario para a pagina de criar videos ao clicar no botao
     */
    public void paginaVideos() {
        JFrame_cadastrarvideo jframe_cadastrar = new JFrame_cadastrarvideo();
        jframe_cadastrar.initController();
        jframe_cadastrar.setVisible(true);
        this.jframe_admin.setVisible(false);
    }

    /**
     * funcao que direciona o usuario para a pagina de listar informacoes do sistema
     * ao clicar no botao
     */
    public void paginaInfoSistema() {
        JFrame_visualizarestatisticas jFrame_visualizarestatisticas = new JFrame_visualizarestatisticas();
        jFrame_visualizarestatisticas.initController();
        jFrame_visualizarestatisticas.setVisible(true);
        this.jframe_admin.setVisible(false);
    }

    /**
     * funcao que direciona o usuario para a pagina de login inicial ao clicar no botao
     */
    public void paginalogin() {
        JFrame_Login jframeLogin = new JFrame_Login();
        jframeLogin.initController();
        jframeLogin.setVisible(true);
        this.jframe_admin.setVisible(false);
    }
}