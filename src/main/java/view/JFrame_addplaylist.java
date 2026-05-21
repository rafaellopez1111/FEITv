package view;

import controller.Controller_Playlist;
import java.sql.SQLException;
import javax.swing.*;

public class JFrame_addplaylist extends javax.swing.JFrame {

    private Controller_Playlist controller;

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(JFrame_addplaylist.class.getName());

    /**
     * Construtor da tela de playlists.
     */
    public JFrame_addplaylist() {
        initComponents();
    }

    /**
     * Inicializa o controller.
     */
    public void initController() {
        try {
            this.controller = new Controller_Playlist(this);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Erro ao conectar ao banco:\n" + e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Inicializa os componentes da interface.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        go_back_button = new javax.swing.JButton();
        create_playlist = new javax.swing.JButton();
        edit_button = new javax.swing.JButton();
        exclude_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        playlist_name = new javax.swing.JTextField();
        edit_playlist = new javax.swing.JTextField();
        exclude_playlist = new javax.swing.JTextField();

        jLabel2.setText("jLabel2");

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

        go_back_button.setText("Voltar");
        go_back_button.addActionListener(this::go_back_buttonActionPerformed);

        create_playlist.setText("CRIAR");
        create_playlist.addActionListener(this::create_playlistActionPerformed);

        edit_button.setText("EDITAR");
        edit_button.addActionListener(this::edit_buttonActionPerformed);

        exclude_button.setText("EXCLUIR");
        exclude_button.addActionListener(this::exclude_buttonActionPerformed);

        jLabel1.setText("CRIAR PLAYLIST");
        jLabel3.setText("EDITAR PLAYLIST");
        jLabel4.setText("EXCLUIR PLAYLIST");

        playlist_name.setText("NOME DA PLAYLIST");
        edit_playlist.setText("NOME DA PLAYLIST");
        exclude_playlist.setText("NOME DA PLAYLIST");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))

                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup()

                                        .addGroup(layout.createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING)

                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(39, 39, 39)

                                                        .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)

                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel1)
                                                                        .addGap(0, 0, Short.MAX_VALUE))

                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(create_playlist)

                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))))

                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(20, 20, 20)

                                                        .addComponent(playlist_name,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)

                                                        .addGap(108, 108, 108)

                                                        .addComponent(edit_playlist,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)

                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)))

                                        .addGroup(layout.createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING)

                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(23, 23, 23)

                                                        .addComponent(exclude_playlist,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)

                                                        .addGap(30, 30, 30))

                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                        layout.createSequentialGroup()

                                                                .addComponent(exclude_button)
                                                                .addGap(52, 52, 52))))

                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup()

                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)

                                        .addGroup(layout.createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING)

                                                .addComponent(go_back_button)

                                                .addComponent(edit_button)

                                                .addGroup(layout.createSequentialGroup()

                                                        .addComponent(jLabel3)

                                                        .addGap(127, 127, 127)

                                                        .addComponent(jLabel4)))

                                        .addGap(44, 44, 44))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                        .addGroup(layout.createSequentialGroup()

                                .addComponent(jPanel1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)

                                .addGap(42, 42, 42)

                                .addGroup(layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)

                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))

                                .addGap(61, 61, 61)

                                .addGroup(layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)

                                        .addComponent(playlist_name,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)

                                        .addComponent(edit_playlist,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)

                                        .addComponent(exclude_playlist,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))

                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        92,
                                        Short.MAX_VALUE)

                                .addGroup(layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)

                                        .addComponent(create_playlist)
                                        .addComponent(exclude_button))

                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                                .addComponent(edit_button)

                                .addGap(49, 49, 49)

                                .addComponent(go_back_button)

                                .addGap(34, 34, 34))
        );

        pack();
    }

    /**
     * Cria uma playlist.
     * @param evt
     */
    private void create_playlistActionPerformed(java.awt.event.ActionEvent evt) {
        if (controller != null) {
            controller.criarPlaylist();
        }
    }

    /**
     * Edita uma playlist.
     * @param evt
     */
    private void edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (controller != null) {
            controller.editarPlaylist();
        }
    }

    /**
     * Exclui uma playlist.
     * @param evt
     */
    private void exclude_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (controller != null) {
            controller.excluirPlaylist();
        }
    }

    /**
     * Retorna para a tela anterior.
     * @param evt
     */
    private void go_back_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (controller != null) {
                controller.voltar();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

            JFrame_addplaylist frame = new JFrame_addplaylist();

            frame.initController();

            frame.setVisible(true);
        });
    }

    /**
     * Retorna o campo nome da playlist.
     * @return playlist_name
     */
    public JTextField getPlaylist_name() {
        return playlist_name;
    }

    /**
     * Retorna o campo editar playlist.
     * @return edit_playlist
     */
    public JTextField getEdit_playlist() {
        return edit_playlist;
    }

    /**
     * Retorna o campo excluir playlist.
     * @return exclude_playlist
     */
    public JTextField getExclude_playlist() {
        return exclude_playlist;
    }

    private javax.swing.JButton create_playlist;
    private javax.swing.JButton edit_button;
    private javax.swing.JTextField edit_playlist;
    private javax.swing.JButton exclude_button;
    private javax.swing.JTextField exclude_playlist;
    private javax.swing.JButton go_back_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField playlist_name;
}