package view;

import controller.Controller_Videos;
import java.sql.SQLException;
import javax.swing.*;

public class Jframe_Buscar extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(Jframe_Buscar.class.getName());

    private Controller_Videos controller;

    /**
     * Construtor da tela de busca.
     */
    public Jframe_Buscar() {
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
                    "Erro ao conectar ao banco: " + e.getMessage(),
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
        jLabel2 = new javax.swing.JLabel();
        search_video = new javax.swing.JButton();
        video_name = new javax.swing.JTextField();
        go_back_button = new javax.swing.JButton();
        favoritar = new javax.swing.JButton();

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
        jLabel1.setText("BUSCAR VÍDEO");

        jLabel2.setText("Digite o nome do vídeo:");

        search_video.setText("BUSCAR VÍDEO");
        search_video.addActionListener(this::search_videoActionPerformed);

        video_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        video_name.setText("NOME DO VÍDEO");

        go_back_button.setText("Voltar");
        go_back_button.addActionListener(this::go_back_buttonActionPerformed);

        favoritar.setText("FAVORITAR");
        favoritar.addActionListener(this::favoritarActionPerformed);

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

                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup()

                                        .addGap(252, 252, 252)

                                        .addGroup(layout.createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING)

                                                .addComponent(jLabel2)

                                                .addComponent(jLabel1)

                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                false)

                                                        .addComponent(video_name,
                                                                javax.swing.GroupLayout.Alignment.LEADING)

                                                        .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)

                                                                .addGroup(layout.createSequentialGroup()

                                                                        .addGap(2, 2, 2)

                                                                        .addComponent(search_video))

                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        layout.createSequentialGroup()

                                                                                .addGroup(layout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                false)

                                                                                        .addComponent(favoritar,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)

                                                                                        .addComponent(go_back_button,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))

                                                                                .addGap(14, 14, 14)))))

                                        .addGap(241, 241, 241))
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

                                .addGap(18, 18, 18)

                                .addComponent(jLabel2)

                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)

                                .addComponent(video_name,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)

                                .addGap(17, 17, 17)

                                .addComponent(search_video)

                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        141,
                                        Short.MAX_VALUE)

                                .addComponent(favoritar)

                                .addGap(18, 18, 18)

                                .addComponent(go_back_button)

                                .addGap(20, 20, 20))
        );

        pack();
    }

    /**
     * Favorita um vídeo.
     * @param evt
     */
    private void favoritarActionPerformed(java.awt.event.ActionEvent evt) {

        if (controller != null) {
            controller.favoritarVideo();
        }
    }

    /**
     * Busca um vídeo.
     * @param evt
     */
    private void search_videoActionPerformed(java.awt.event.ActionEvent evt) {

        if (controller != null) {
            controller.buscarVideo();
        }
    }

    /**
     * Retorna para a tela anterior.
     * @param evt
     */
    private void go_back_buttonActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            controller.voltarBuscar();

        } catch (SQLException e) {
            e.printStackTrace();
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

            Jframe_Buscar frame = new Jframe_Buscar();

            frame.initController();

            frame.setVisible(true);
        });
    }

    /**
     * Retorna o botão favoritar.
     * @return favoritar
     */
    public JButton getFavoritar() {
        return favoritar;
    }

    /**
     * Define o botão favoritar.
     * @param favoritar
     */
    public void setFavoritar(JButton favoritar) {
        this.favoritar = favoritar;
    }

    /**
     * Retorna o botão voltar.
     * @return go_back_button
     */
    public JButton getGo_back_button() {
        return go_back_button;
    }

    /**
     * Define o botão voltar.
     * @param go_back_button
     */
    public void setGo_back_button(JButton go_back_button) {
        this.go_back_button = go_back_button;
    }

    /**
     * Retorna o label 1.
     * @return jLabel1
     */
    public JLabel getjLabel1() {
        return jLabel1;
    }

    /**
     * Define o label 1.
     * @param jLabel1
     */
    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    /**
     * Retorna o label 2.
     * @return jLabel2
     */
    public JLabel getjLabel2() {
        return jLabel2;
    }

    /**
     * Define o label 2.
     * @param jLabel2
     */
    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    /**
     * Retorna o label 5.
     * @return jLabel5
     */
    public JLabel getjLabel5() {
        return jLabel5;
    }

    /**
     * Define o label 5.
     * @param jLabel5
     */
    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    /**
     * Retorna o painel principal.
     * @return jPanel1
     */
    public JPanel getjPanel1() {
        return jPanel1;
    }

    /**
     * Define o painel principal.
     * @param jPanel1
     */
    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    /**
     * Retorna o botão buscar vídeo.
     * @return search_video
     */
    public JButton getSearch_video() {
        return search_video;
    }

    /**
     * Define o botão buscar vídeo.
     * @param search_video
     */
    public void setSearch_video(JButton search_video) {
        this.search_video = search_video;
    }

    /**
     * Retorna o campo nome do vídeo.
     * @return video_name
     */
    public JTextField getVideo_name() {
        return video_name;
    }

    /**
     * Define o campo nome do vídeo.
     * @param video_name
     */
    public void setVideo_name(JTextField video_name) {
        this.video_name = video_name;
    }

    private javax.swing.JButton favoritar;
    private javax.swing.JButton go_back_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton search_video;
    private javax.swing.JTextField video_name;
}