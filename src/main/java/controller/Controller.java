package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.Usuario;
import model.dao.Conexao;
import model.dao.UserDAO;
import view.*;

public class Controller {
    private UserDAO userdao;
    private JFrame jframe;
    private JFrame_consultaruser jframe_consultar;
    private JFrame_visualizarestatisticas jframe_estatisticas;

    /**
     *construtor para a pagina de cadastro
     * @param jframe
     * @throws SQLException
     */
    public Controller(JFrame jframe) throws SQLException {
        this.jframe = jframe;
        Conexao conexao = new Conexao();
        this.userdao = new UserDAO(conexao.getConnection());
    }

    /**
     *construtor usado para o jframe de consultar um usuario especifico
     * @param jframe_consultar
     * @throws SQLException
     */
    public Controller(JFrame_consultaruser jframe_consultar) throws SQLException {
        this.jframe_consultar = jframe_consultar;
        Conexao conexao = new Conexao();
        this.userdao = new UserDAO(conexao.getConnection());
    }

    /**
     * controller feito para uso na pagina de visualizacao de estatisticas para ver todos os usuarios.
     * @param jframe_estatisticas
     * @throws SQLException
     */
    public Controller(JFrame_visualizarestatisticas jframe_estatisticas) throws SQLException {
        this.jframe_estatisticas = jframe_estatisticas;
        Conexao conexao = new Conexao();
        this.userdao = new UserDAO(conexao.getConnection());
    }


    /**
     * funcao que pega os inputs do usuario e os insere no banco de dados, seguindo o principio de
     * chave unica imposto no banco de dados para username.
     */
    public void inserir() {
        String nome = this.jframe.getFull_name().getText();
        String usuario = this.jframe.getUsername().getText();
        String senha = this.jframe.getPassword().getText();
        LocalDate nascimento = LocalDate.parse(this.jframe.getBirth_date().getText());

        Usuario user = new Usuario(nome, usuario, nascimento, senha);
        try {
            this.userdao.inserir(user);
            JOptionPane.showMessageDialog(this.jframe,
                    "Usuário cadastrado com sucesso!",
                    "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe,
                    "Erro ao inserir usuário:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * funcao que consulta a existencia de um usuario ou nao, para isso pega o input do usuario dentro do
     * jframe e tenta encontrar no banco de dados, exibindo as informacoes caso ache.
     */
    public void consultarUsuario() {
        String usuario = this.jframe_consultar.getUsername().getText().trim();

        if (usuario.isEmpty() || usuario.equals("NOME DO USUÁRIO")) {
            JOptionPane.showMessageDialog(this.jframe_consultar,
                    "Digite o nome do usuário!",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            ResultSet resultado = this.userdao.consultar(usuario);

            if (resultado.next()) {
                String nome = resultado.getString("full_name");
                String username = resultado.getString("username");
                String nascimento = resultado.getString("birth_date");

                String info = "Usuário encontrado!\n\n"
                        + "Nome: " + nome + "\n"
                        + "Usuário: " + username + "\n"
                        + "Nascimento: " + nascimento;

                JOptionPane.showMessageDialog(this.jframe_consultar,
                        info, "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this.jframe_consultar,
                        "Usuário \"" + usuario + "\" não encontrado.",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }

            resultado.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_consultar,
                    "Erro ao consultar usuário:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * funcao feita para listar todos os usuarios registrados no sistema, usa da funcao consultarusuarios de userdao para procurar os usuarios no banco de dados.
     */
    public void listarUsuarios() {
        try {
            ResultSet rs = this.userdao.consultarUsuarios();
            StringBuilder sb = new StringBuilder();
            int count = 0;

            while (rs.next()) {
                count++;
                String nome = rs.getString("full_name");
                String username = rs.getString("username");
                String nasc = rs.getString("birth_date");

                sb.append(count).append(". ").append(nome).append("\n")
                        .append("   Username: ").append(username).append("\n")
                        .append("   Nascimento: ").append(nasc).append("\n\n");
            }
            rs.close();

            if (count == 0) {
                JOptionPane.showMessageDialog(this.jframe_estatisticas,
                        "Nenhum usuário cadastrado.",
                        "INFO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this.jframe_estatisticas,
                        sb.toString(),
                        "USUÁRIOS CADASTRADOS (" + count + ")", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.jframe_estatisticas,
                    "Erro ao listar usuários:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * funcao que fecha a pagina de cadastro e abre a pagina de login
     */
    public void abreLogin() {
        JFrame_Login jFrameLogin = new JFrame_Login();
        jFrameLogin.initController();
        jFrameLogin.setVisible(true);
        this.jframe.setVisible(false);
    }

    /**
     * funcao para voltar a página inicial de administrador
     */
    public void voltarConsulta() {
        JFrame_inicial_admin jFrame_inicial_admin = new JFrame_inicial_admin();
        jFrame_inicial_admin.initController();
        jFrame_inicial_admin.setVisible(true);
        this.jframe_consultar.dispose();
    }
}