package controller;

import javax.swing.JOptionPane;
import view.*;

public class Controller_inicial_admin {

    private JFrame_inicial_admin jframe_admin;

    public Controller_inicial_admin(JFrame_inicial_admin jframe_admin) {
        this.jframe_admin = jframe_admin;
    }

    public void paginabuscar() {
        Jframe_Buscar jframe_buscar = new Jframe_Buscar();
        jframe_buscar.initController();
        jframe_buscar.setVisible(true);
        this.jframe_admin.setVisible(false);
    }

    public void paginalistar() {
        JFrame_info jFrame_info = new JFrame_info();
        jFrame_info.setVisible(true);
        this.jframe_admin.setVisible(false);
    }

    public void paginacurtidas() {
        JFrame_curtidas jFrame_curtidas = new JFrame_curtidas();
        jFrame_curtidas.setVisible(true);
        this.jframe_admin.setVisible(false);
    }

    public void paginaplaylist() {
        JFrame_addplaylist jframe_addplaylist = new JFrame_addplaylist();
        jframe_addplaylist.initController();
        jframe_addplaylist.setVisible(true);
        this.jframe_admin.setVisible(false);
    }

    public void paginaConsultarUsuarios() {
        JFrame_consultaruser jframe_consultar = new JFrame_consultaruser();
        jframe_consultar.initController();
        jframe_consultar.setVisible(true);
        this.jframe_admin.setVisible(false);
    }

    public void paginaVideos() {
        JFrame_cadastrarvideo jframe_cadastrar = new JFrame_cadastrarvideo();
        jframe_cadastrar.initController();
        jframe_cadastrar.setVisible(true);
        this.jframe_admin.setVisible(false);
    }

    public void paginaInfoSistema() {
        JOptionPane.showMessageDialog(this.jframe_admin,
                "Tela de informações do sistema ainda não implementada.",
                "INFO", JOptionPane.INFORMATION_MESSAGE);
    }

    public void paginalogin() {
        JFrame_Login jframeLogin = new JFrame_Login();
        jframeLogin.initController();
        jframeLogin.setVisible(true);
        this.jframe_admin.dispose();
    }
}