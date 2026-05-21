package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;

import model.Storage_User;
import model.dao.Conexao;
import model.dao.UserDAO;
import model.dao.UserAdmnDAO;
import view.JFrame_Login;
import view.JFrame_inicial;
import view.JFrame_inicial_admin;

public class Controller_Login {

    private UserDAO userdao;
    private UserAdmnDAO useradmndao;
    private JFrame_Login jframeLogin;
    private UserAdmnDAO userAdmnDAO;

    /**
     * construtor usado para a pagina de login
     * @param jframeLogin
     * @throws SQLException
     */
    public Controller_Login(JFrame_Login jframeLogin) throws SQLException {
        this.jframeLogin = jframeLogin;
        Conexao conexao = new Conexao();
        this.userdao = new UserDAO(conexao.getConnection());
        this.useradmndao = new UserAdmnDAO(conexao.getConnection());
    }

    /**
     * funcao usada para autentificar o login do usuario, com os inputs feitas na pagina de login,
     * utilizando validarLogin de userdao para buscar o usuario no banco de dados para identifica-lo
     * como administrador, usuario normal ou nao existente
     */
    public void login() {
        String username = this.jframeLogin.getUsername_text().getText().trim();
        String password = this.jframeLogin.getPassword().getText().trim();

        if (username.isEmpty() || username.equals("SEU USUARIO")
                || password.isEmpty() || password.equals("DIGITE SUA SENHA")) {
            JOptionPane.showMessageDialog(this.jframeLogin,
                    "Preencha usuário e senha!",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int userId = this.userdao.validarLogin(username, password);

            Storage_User user = new Storage_User();
            user.setUserId(userId);

            if (userId == -1) {
                JOptionPane.showMessageDialog(this.jframeLogin,
                        "Usuário ou senha incorretos!",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean admin = this.useradmndao.isAdmin(userId);

            if (admin) {
                JOptionPane.showMessageDialog(this.jframeLogin,
                        "Bem-vindo, Administrador!",
                        "LOGIN", JOptionPane.INFORMATION_MESSAGE);
                JFrame_inicial_admin jFrameInicialAdmin = new JFrame_inicial_admin();
                jFrameInicialAdmin.initController();
                jFrameInicialAdmin.setVisible(true);
                jframeLogin.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(this.jframeLogin,
                        "Bem-vindo, " + username + "!",
                        "LOGIN", JOptionPane.INFORMATION_MESSAGE);
                JFrame_inicial frameInicial = new JFrame_inicial();
                frameInicial.initController();
                frameInicial.setVisible(true);
            }

            this.jframeLogin.dispose();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframeLogin,
                    "Erro ao fazer login:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
}