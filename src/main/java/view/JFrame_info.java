package view;

import controller.Controller_Videos;
import java.sql.SQLException;
import javax.swing.*;

public class JFrame_info extends javax.swing.JFrame {

    private Controller_Videos controller;

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(JFrame_info.class.getName());

    /**
     * Construtor da tela de informações.
     */
    public JFrame_info() {
        initComponents();
    }

    /**
     * Inicializa o controller.
     */
    public void initController() {

        try {

            this.controller = new Controller_Videos(this);

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
        list_button = new javax.swing.JButton();
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

        jLabel1.setText("Vídeos Buscados");

        list_button.setText("Listar");

        list_button.addActionListener(
                this::list_buttonActionPerformed);

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

                                .addGap(235, 235, 235)

                                .addComponent(jLabel1))

                        .addGroup(layout.createSequentialGroup()

                                .addGap(269, 269, 269)

                                .addGroup(layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)

                                        .addComponent(go_back_button)

                                        .addComponent(list_button)))
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

                                .addComponent(jLabel1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        29,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)

                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)

                                .addComponent(list_button)

                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        194,
                                        Short.MAX_VALUE)

                                .addComponent(go_back_button)

                                .addGap(48, 48, 48))
        );

        pack();
    }

    /**
     * Lista os vídeos.
     * @param evt
     */
    private void list_buttonActionPerformed(
            java.awt.event.ActionEvent evt) {

        if (controller != null) {
            controller.listarVideos();
        }
    }

    /**
     * Retorna para a tela anterior.
     * @param evt
     */
    private void go_back_buttonActionPerformed(
            java.awt.event.ActionEvent evt) {

        if (controller != null) {

            try {

                controller.voltarInfo();

            } catch (SQLException e) {

                throw new RuntimeException(e);
            }
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

            JFrame_info frame =
                    new JFrame_info();

            frame.initController();

            frame.setVisible(true);
        });
    }

    private javax.swing.JButton go_back_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton list_button;
}