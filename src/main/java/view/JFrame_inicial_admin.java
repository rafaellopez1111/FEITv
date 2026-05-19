package view;

import controller.Controller_inicial_admin;
import javax.swing.*;

public class JFrame_inicial_admin extends javax.swing.JFrame {

    private Controller_inicial_admin controller;
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(JFrame_inicial_admin.class.getName());

    public JFrame_inicial_admin() {
        initComponents();
    }

    public void initController() {
        this.controller = new Controller_inicial_admin(this);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        quit_button = new javax.swing.JButton();
        buscar_button = new javax.swing.JButton();
        list_button = new javax.swing.JButton();
        like_button = new javax.swing.JButton();
        playlist_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        consult_users_button = new javax.swing.JButton();
        videos_button = new javax.swing.JButton();
        list_info_sistem_button = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("2.");
        jLabel4.setText("3.");
        jLabel6.setText("4.");

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

        quit_button.setText("SAIR");
        quit_button.addActionListener(this::quit_buttonActionPerformed);

        buscar_button.setText("Buscar Vídeo");
        buscar_button.addActionListener(this::buscar_buttonActionPerformed);

        list_button.setText("Listar Informações de vídeo");
        list_button.addActionListener(this::list_buttonActionPerformed);

        like_button.setText("Curtir Vídeos");
        like_button.addActionListener(this::like_buttonActionPerformed);

        playlist_button.setText("Gerenciar Playlists");
        playlist_button.addActionListener(this::playlist_buttonActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel1.setText("PÁGINA INICIAL");

        jLabel2.setText("1.");

        consult_users_button.setText("Consultar Usuários");
        consult_users_button.addActionListener(this::consult_users_buttonActionPerformed);

        videos_button.setText("Criar/Excluir Vídeos");
        videos_button.addActionListener(this::videos_buttonActionPerformed);

        list_info_sistem_button.setText("Listar Informações do sistema");
        list_info_sistem_button.addActionListener(this::list_info_sistem_buttonActionPerformed);

        jLabel7.setText("5.");
        jLabel8.setText("6.");
        jLabel9.setText("7.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(232, 232, 232)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(jLabel6))))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(playlist_button)
                                                        .addComponent(consult_users_button)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(13, 13, 13)
                                                                .addComponent(like_button)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(list_info_sistem_button)
                                .addGap(212, 212, 212))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(219, 219, 219)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(buscar_button))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addComponent(jLabel1))
                                                        .addComponent(list_button)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(230, 230, 230)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(videos_button))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(273, 273, 273)
                                                .addComponent(quit_button)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                        .addComponent(buscar_button)
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
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(consult_users_button)
                                        .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(videos_button)
                                        .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(list_info_sistem_button)
                                        .addComponent(jLabel9))
                                .addGap(38, 38, 38)
                                .addComponent(quit_button)
                                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }

    private void buscar_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (controller != null) controller.paginabuscar();
    }

    private void list_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (controller != null) controller.paginalistar();
    }

    private void like_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (controller != null) controller.paginacurtidas();
    }

    private void playlist_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (controller != null) controller.paginaplaylist();
    }

    private void consult_users_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (controller != null) controller.paginaConsultarUsuarios();
    }

    private void videos_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (controller != null) controller.paginaVideos();
    }

    private void list_info_sistem_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (controller != null) controller.paginaInfoSistema();
    }

    private void quit_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (controller != null) controller.paginalogin();
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

        java.awt.EventQueue.invokeLater(() -> {
            JFrame_inicial_admin frame = new JFrame_inicial_admin();
            frame.initController();
            frame.setVisible(true);
        });
    }

    private javax.swing.JButton buscar_button;
    private javax.swing.JButton consult_users_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton like_button;
    private javax.swing.JButton list_button;
    private javax.swing.JButton list_info_sistem_button;
    private javax.swing.JButton playlist_button;
    private javax.swing.JButton quit_button;
    private javax.swing.JButton videos_button;
}