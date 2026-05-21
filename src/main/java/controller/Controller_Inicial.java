/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.*;

import java.sql.SQLException;

/**
 *
 * @author rafae
 */
public class Controller_Inicial {
    private JFrame_inicial jFrame_inicial;

    /**
     *Construtor usado para a pagina inicial dos usuarios comuns
     * @param jFrame_inicial
     */
    public Controller_Inicial(JFrame_inicial jFrame_inicial) {
        this.jFrame_inicial = jFrame_inicial;
    }

    /**
     *funcao usada para direcionar o usuario para a pagina de listar informacoes
     * dos videos buscados quando clica no botao
     */
    public void paginalistar() {
        JFrame_info jFrame_info = new JFrame_info();
        jFrame_info.initController();
        jFrame_info.setVisible(true);
        this.jFrame_inicial.setVisible(false);
    }

    /**
     *funcao usada para direcionar o usuario para a pagina de buscar video
     * quando clica no botao
     */
    public void paginabuscar() {
        Jframe_Buscar jframe_buscar = new Jframe_Buscar();
        jframe_buscar.initController();
        jframe_buscar.setVisible(true);
        this.jFrame_inicial.setVisible(false);
    }

    /**
     *funcao usada para direcionar o usuario para a pagina de curtir ou descurtir
     *um video quando clica no botao
     */
    public void paginacurtidas() {
        JFrame_curtidas jFrame_curtidas = new JFrame_curtidas();
        jFrame_curtidas.initController();
        jFrame_curtidas.setVisible(true);
        this.jFrame_inicial.setVisible(false);
    }

    /**
     *funcao usada para direcionar o usuario para o menu inicial de playlists
     *quando clica no botao
     */
    public void paginaplaylist() {
        JFrame_Inicial_favoritos jFrame_inicial_favoritos = new JFrame_Inicial_favoritos();
        jFrame_inicial_favoritos.initController();
        jFrame_inicial_favoritos.setVisible(true);
        this.jFrame_inicial.setVisible(false);
    }

    /**
     * funcao usada para direcionar o usuario para a pagina de login
     * quando clica no botao
     * @throws SQLException
     */
    public void paginalogin() throws SQLException {
        JFrame_Login jFrameLogin = new JFrame_Login();
        jFrameLogin.initController();
        jFrameLogin.setVisible(true);
        this.jFrame_inicial.setVisible(false);
    }
}
