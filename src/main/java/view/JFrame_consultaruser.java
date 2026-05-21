package view;

import controller.Controller;
import java.sql.SQLException;
import javax.swing.*;

public class JFrame_consultaruser extends javax.swing.JFrame {

    private Controller controller;

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(JFrame_consultaruser.class.getName());

    /**
     * Construtor da tela de consulta de usuário.
     */
    public JFrame_consultaruser() {
        initComponents();
    }

    /**
     * Inicializa o controller.
     */
    public void initController() {

        try {

            this.controller = new Controller(this);

        } catch (SQLException e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(this,
                    "Erro ao conectar ao banco:\n" + e.getMessage(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Inicializa os componentes da interface.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        consult_button = new javax.swing.JButton();
        go_back_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel5.setFont(new java.awt.Font("Showcard Gothic", 1, 24));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel5.setText("FEITV");

        javax.swing.GroupLayout jPanel1Layout =
                new javax.swing.GroupLayout(jPanel1);

        jPanel1.setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)

                        .addGroup(jPanel1Layout.createSequentialGroup()

                                .addGap(196, 196, 196)

                                .addComponent(jLabel5,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        226,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)

                                .addContainerGap(201, Short.MAX_VALUE))
        );

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)

                        .addGroup(jPanel1Layout.createSequentialGroup()

                                .addContainerGap()

                                .addComponent(jLabel5,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        40,
                                        Short.MAX_VALUE)

                                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18));

        jLabel1.setText("CONSULTA DE USUÁRIO");

        username.setText("NOME DO USUÁRIO");

        consult_button.setText("CONSULTAR");

        consult_button.addActionListener(
                this::consult_buttonActionPerformed);

        go_back_button.setText("Voltar");

        go_back_button.addActionListener(
                this::go_back_buttonActionPerformed);

        javax.swing.GroupLayout layout =
                new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)

                        .addComponent(jPanel1,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)

                        .addGroup(layout.createSequentialGroup()

                                .addGap(204, 204, 204)

                                .addComponent(jLabel1))

                        .addGroup(layout.createSequentialGroup()

                                .addGap(245, 245, 245)

                                .addComponent(username,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))

                        .addGroup(layout.createSequentialGroup()

                                .addGap(259, 259, 259)

                                .addComponent(consult_button))

                        .addGroup(layout.createSequentialGroup()

                                .addGap(273, 273, 273)

                                .addComponent(go_back_button))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)

                        .addGroup(layout.createSequentialGroup()

                                .addComponent(jPanel1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)

                                .addGap(18, 18, 18)

                                .addComponent(jLabel1)

                                .addGap(28, 28, 28)

                                .addComponent(username,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)

                                .addGap(28, 28, 28)

                                .addComponent(consult_button)

                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        187,
                                        Short.MAX_VALUE)

                                .addComponent(go_back_button)

                                .addGap(14, 14, 14))
        );

        pack();
    }

    /**
     * Consulta um usuário.
     * @param evt
     */
    private void consult_buttonActionPerformed(
            java.awt.event.ActionEvent evt) {

        if (controller != null) {
            controller.consultarUsuario();
        }
    }

    /**
     * Retorna para a tela anterior.
     * @param evt
     */
    private void go_back_buttonActionPerformed(
            java.awt.event.ActionEvent evt) {

        if (controller != null) {
            controller.voltarConsulta();
        }
    }

    /**
     * Método principal da aplicação.
     * @param args
     */
    public static void main(String args[]) {

        try {

            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {

                if ("Nimbus".equals(info.getName())) {

                    javax.swing.UIManager.setLookAndFeel(
                            info.getClassName());

                    break;
                }
            }

        } catch (ReflectiveOperationException |
                 javax.swing.UnsupportedLookAndFeelException ex) {

            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {

            JFrame_consultaruser frame =
                    new JFrame_consultaruser();

            frame.initController();

            frame.setVisible(true);
        });
    }

    /**
     * Retorna o campo username.
     * @return username
     */
    public JTextField getUsername() {
        return username;
    }

    private javax.swing.JButton consult_button;
    private javax.swing.JButton go_back_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField username;
}