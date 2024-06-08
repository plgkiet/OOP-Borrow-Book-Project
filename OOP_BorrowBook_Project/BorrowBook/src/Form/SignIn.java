package Form;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Student;
import utils.Camera;
import utils.StudentManager;

public class SignIn extends javax.swing.JFrame {

    Color panDefault, panEnter, panClick;
    private Camera camera;
    
    public SignIn() {
        StudentManager.loadStudentData();
        camera = new Camera(1);
        initComponents();
        panDefault = new Color(255, 153, 0);
        panClick = new Color(243, 183, 68);
        panEnter = new Color(234, 98, 43);
        menuLeftPanel.setBackground(panDefault);
        this.setVisible(true);
        new Thread(this::startCamera).start();
    }

    public void check(String data) {
        Student temp = StudentManager.checkUser(data);
        if (temp == null) {
            JOptionPane.showMessageDialog(rootPane, "User not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            this.setVisible(false);
            Menu menu = new Menu(temp);
            menu.setVisible(true);
            camera.setCanStart(false);
        }
    }

    public void startCamera() {
        camera.scanAndDecode(this);
    }

    public void setImage(BufferedImage image) {
        ImageIcon icon = new ImageIcon(image);
        cameraLabel.setIcon(icon);
        cameraPanel.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuRightPanel = new javax.swing.JPanel();
        menuLeftPanel = new javax.swing.JPanel();
        eiuLibraryLabel = new javax.swing.JLabel();
        loginIconLabel = new javax.swing.JLabel();
        eiusigninLabel = new javax.swing.JLabel();
        backIconLabel = new javax.swing.JLabel();
        signInPanel = new javax.swing.JPanel();
        signInLabel = new javax.swing.JLabel();
        cameraPanel = new javax.swing.JPanel();
        cameraLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuRightPanel.setBackground(new java.awt.Color(0, 2, 44));
        menuRightPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuLeftPanel.setBackground(new java.awt.Color(255, 153, 0));

        eiuLibraryLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        eiuLibraryLabel.setForeground(new java.awt.Color(255, 255, 255));
        eiuLibraryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eiuLibraryLabel.setText("EIU Library");

        loginIconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconlibrary.png"))); // NOI18N

        eiusigninLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        eiusigninLabel.setForeground(new java.awt.Color(255, 255, 255));
        eiusigninLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eiusigninLabel.setText("Sign In");

        backIconLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backIconLabel.setForeground(new java.awt.Color(255, 255, 255));
        backIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        backIconLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backIconLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuLeftPanelLayout = new javax.swing.GroupLayout(menuLeftPanel);
        menuLeftPanel.setLayout(menuLeftPanelLayout);
        menuLeftPanelLayout.setHorizontalGroup(
            menuLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginIconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(eiusigninLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(eiuLibraryLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
            .addGroup(menuLeftPanelLayout.createSequentialGroup()
                .addComponent(backIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menuLeftPanelLayout.setVerticalGroup(
            menuLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLeftPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(backIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(eiuLibraryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eiusigninLabel)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        menuRightPanel.add(menuLeftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 660));

        signInPanel.setBackground(new java.awt.Color(255, 153, 0));
        signInPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        signInPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signInPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signInPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signInPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                signInPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                signInPanelMouseReleased(evt);
            }
        });

        signInLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        signInLabel.setForeground(new java.awt.Color(255, 255, 255));
        signInLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signInLabel.setText("Sign In");

        javax.swing.GroupLayout signInPanelLayout = new javax.swing.GroupLayout(signInPanel);
        signInPanel.setLayout(signInPanelLayout);
        signInPanelLayout.setHorizontalGroup(
            signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signInPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(signInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        signInPanelLayout.setVerticalGroup(
            signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signInLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        menuRightPanel.add(signInPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 580, 230, 60));

        cameraLabel.setBackground(new java.awt.Color(0, 0, 0));
        cameraLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        cameraLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cameraLabel.setPreferredSize(new java.awt.Dimension(1000, 800));

        javax.swing.GroupLayout cameraPanelLayout = new javax.swing.GroupLayout(cameraPanel);
        cameraPanel.setLayout(cameraPanelLayout);
        cameraPanelLayout.setHorizontalGroup(
            cameraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cameraPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(cameraLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        cameraPanelLayout.setVerticalGroup(
            cameraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cameraPanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(cameraLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        menuRightPanel.add(cameraPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 580, 530));

        getContentPane().add(menuRightPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signInPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInPanelMouseEntered
        signInPanel.setBackground(panEnter);
    }//GEN-LAST:event_signInPanelMouseEntered

    private void signInPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInPanelMouseExited
        signInPanel.setBackground(panDefault);
    }//GEN-LAST:event_signInPanelMouseExited

    private void signInPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInPanelMousePressed
        signInPanel.setBackground(panClick);
    }//GEN-LAST:event_signInPanelMousePressed

    private void signInPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInPanelMouseReleased
        signInPanel.setBackground(panDefault);
    }//GEN-LAST:event_signInPanelMouseReleased

    private void backIconLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backIconLabelMouseClicked
        SignUp signup = new SignUp();
        signup.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backIconLabelMouseClicked

    private void signInPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInPanelMouseClicked

    }//GEN-LAST:event_signInPanelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backIconLabel;
    private javax.swing.JLabel cameraLabel;
    private javax.swing.JPanel cameraPanel;
    private javax.swing.JLabel eiuLibraryLabel;
    private javax.swing.JLabel eiusigninLabel;
    private javax.swing.JLabel loginIconLabel;
    private javax.swing.JPanel menuLeftPanel;
    private javax.swing.JPanel menuRightPanel;
    private javax.swing.JLabel signInLabel;
    private javax.swing.JPanel signInPanel;
    // End of variables declaration//GEN-END:variables
}
