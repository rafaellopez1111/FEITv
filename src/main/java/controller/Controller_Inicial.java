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

    public Controller_Inicial(JFrame_inicial jFrame_inicial) {
        this.jFrame_inicial = jFrame_inicial;
    }

    public void paginalistar() {
        JFrame_info jFrame_info = new JFrame_info();
        jFrame_info.initController();
        jFrame_info.setVisible(true);
        this.jFrame_inicial.setVisible(false);
    }

    public void paginabuscar() {
        Jframe_Buscar jframe_buscar = new Jframe_Buscar();
        jframe_buscar.initController();
        jframe_buscar.setVisible(true);
        this.jFrame_inicial.setVisible(false);
    }

    public void paginacurtidas() {
        JFrame_curtidas jFrame_curtidas = new JFrame_curtidas();
        jFrame_curtidas.initController();
        jFrame_curtidas.setVisible(true);
        this.jFrame_inicial.setVisible(false);
    }

    public void paginaplaylist() {
        JFrame_Inicial_favoritos jFrame_inicial_favoritos = new JFrame_Inicial_favoritos();
        jFrame_inicial_favoritos.setVisible(true);
        this.jFrame_inicial.setVisible(false);
    }

    public void paginalogin() throws SQLException {
        JFrame jframe = new JFrame();
        jframe.setVisible(true);
        this.jFrame_inicial.setVisible(false);
    }
}
