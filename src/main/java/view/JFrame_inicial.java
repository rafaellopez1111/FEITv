package view;

import controller.Controller_Inicial;

import javax.swing.*;
import java.sql.SQLException;

public class JFrame_inicial extends javax.swing.JFrame {

    private Controller_Inicial controller_inicial;
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(JFrame_inicial.class.getName());

    public JFrame_inicial() {
        initComponents();
    }

    public void initController() {
        this.controller_inicial = new Controller_Inicial(this);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        buscar_video_button = new javax.swing.JButton();
        list_button = new javax.swing.JButton();
        like_button = new javax.swing.JButton();
        playlist_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        exit_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel5.setFont(new java.awt.Font("Showcard Gothic", 1, 24));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("FEITV");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 226,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel1.setText("PÁGINA INICIAL");

        jLabel2.setText("1.");
        jLabel3.setText("2.");
        jLabel4.setText("3.");
        jLabel6.setText("4.");

        buscar_video_button.setText("Buscar Vídeo");

        buscar_video_button.addActionListener(this::buscar_video_buttonActionPerformed);

        list_button.setText("Listar Informações");

        list_button.addActionListener(this::list_buttonActionPerformed);

        like_button.setText("Curtir Vídeos");

        like_button.addActionListener(this::like_buttonActionPerformed);

        playlist_button.setText("Gerenciar Playlists");

        playlist_button.addActionListener(this::playlist_buttonActionPerformed);

        exit_button.setText("SAIR");

        exit_button.addActionListener(this::exit_buttonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(list_button)
                                                .addComponent(playlist_button))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(234, 234, 234)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(buscar_video_button))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(232, 232, 232)
                                                .addComponent(jLabel6))
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addComponent(like_button))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(268, 268, 268)
                                .addComponent(exit_button))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buscar_video_button)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(list_button)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(like_button)
                                        .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(playlist_button)
                                        .addComponent(jLabel6))
                                .addGap(48, 48, 48)
                                .addComponent(exit_button)
                                .addGap(0, 105, Short.MAX_VALUE))
        );

        pack();
    }

    private void buscar_video_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (controller_inicial != null) controller_inicial.paginabuscar();
    }

    private void list_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (controller_inicial != null) controller_inicial.paginalistar();
    }

    private void like_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (controller_inicial != null) controller_inicial.paginacurtidas();
    }

    private void playlist_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (controller_inicial != null) controller_inicial.paginaplaylist();
    }

    private void exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (controller_inicial != null) {
            try {
                controller_inicial.paginalogin();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Erro ao voltar para login: " + e.getMessage(),
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        // ★ FIX: inicializa controller antes de exibir
        java.awt.EventQueue.invokeLater(() -> {
            JFrame_inicial frame = new JFrame_inicial();
            frame.initController();
            frame.setVisible(true);
        });
    }

    private javax.swing.JButton buscar_video_button;
    private javax.swing.JButton exit_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton like_button;
    private javax.swing.JButton list_button;
    private javax.swing.JButton playlist_button;
}