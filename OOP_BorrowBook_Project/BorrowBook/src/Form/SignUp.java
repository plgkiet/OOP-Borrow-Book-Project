package Form;

import com.google.zxing.WriterException;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.QRCodeGenerator;
import utils.SendEmail;
import utils.StudentDAO;

public class SignUp extends javax.swing.JFrame {

    Color panDefault, panEnter, panClick;
    private StudentDAO studentDAO = new StudentDAO();

    public SignUp() {
        initComponents();
        panDefault = new Color(255, 153, 0);
        panClick = new Color(243, 183, 68);
        panEnter = new Color(234, 98, 43);

        signUpPanel.setBackground(panDefault);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuRightPanel = new javax.swing.JPanel();
        menuLeftPanel = new javax.swing.JPanel();
        eiuLibraryLabel = new javax.swing.JLabel();
        loginIconLabel = new javax.swing.JLabel();
        eiuSignUpLabel = new javax.swing.JLabel();
        fullNameLabel = new javax.swing.JLabel();
        fullNameTextField = new javax.swing.JTextField();
        fullNameBlank = new javax.swing.JLabel();
        rollNumberLabel = new javax.swing.JLabel();
        rollNumberBlank = new javax.swing.JLabel();
        signUpPanel = new javax.swing.JPanel();
        signUpLabel = new javax.swing.JLabel();
        loginAccLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        rollNumberTextField = new javax.swing.JTextField();
        emailBlank = new javax.swing.JLabel();
        passMarkLabel = new javax.swing.JLabel();
        usernameMarkLabel = new javax.swing.JLabel();
        emailMarkLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        menuRightPanel.setBackground(new java.awt.Color(0, 2, 44));
        menuRightPanel.setAutoscrolls(true);
        menuRightPanel.setPreferredSize(new java.awt.Dimension(880, 660));
        menuRightPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuLeftPanel.setBackground(new java.awt.Color(255, 153, 0));

        eiuLibraryLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        eiuLibraryLabel.setForeground(new java.awt.Color(255, 255, 255));
        eiuLibraryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eiuLibraryLabel.setText("EIU Library");

        loginIconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconlibrary.png"))); // NOI18N

        eiuSignUpLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        eiuSignUpLabel.setForeground(new java.awt.Color(255, 255, 255));
        eiuSignUpLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eiuSignUpLabel.setText("Sign Up");

        javax.swing.GroupLayout menuLeftPanelLayout = new javax.swing.GroupLayout(menuLeftPanel);
        menuLeftPanel.setLayout(menuLeftPanelLayout);
        menuLeftPanelLayout.setHorizontalGroup(
            menuLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginIconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(eiuSignUpLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(eiuLibraryLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        menuLeftPanelLayout.setVerticalGroup(
            menuLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLeftPanelLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(eiuLibraryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eiuSignUpLabel)
                .addContainerGap(255, Short.MAX_VALUE))
        );

        menuRightPanel.add(menuLeftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 660));

        fullNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        fullNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        fullNameLabel.setText("Full Name");
        menuRightPanel.add(fullNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        fullNameTextField.setBackground(new java.awt.Color(0, 2, 44));
        fullNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        fullNameTextField.setForeground(new java.awt.Color(255, 255, 255));
        fullNameTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fullNameTextField.setBorder(null);
        menuRightPanel.add(fullNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 410, 60));

        fullNameBlank.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        menuRightPanel.add(fullNameBlank, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 410, -1));

        rollNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        rollNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        rollNumberLabel.setText("Roll Number");
        menuRightPanel.add(rollNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, -1, -1));

        rollNumberBlank.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        menuRightPanel.add(rollNumberBlank, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, 410, -1));

        signUpPanel.setBackground(new java.awt.Color(255, 153, 0));
        signUpPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        signUpPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signUpPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signUpPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                signUpPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                signUpPanelMouseReleased(evt);
            }
        });

        signUpLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        signUpLabel.setForeground(new java.awt.Color(255, 255, 255));
        signUpLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signUpLabel.setText("Sign Up");

        javax.swing.GroupLayout signUpPanelLayout = new javax.swing.GroupLayout(signUpPanel);
        signUpPanel.setLayout(signUpPanelLayout);
        signUpPanelLayout.setHorizontalGroup(
            signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signUpPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(signUpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        signUpPanelLayout.setVerticalGroup(
            signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signUpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        menuRightPanel.add(signUpPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, 230, 60));

        loginAccLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        loginAccLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginAccLabel.setText("Already have Account");
        loginAccLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginAccLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginAccLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginAccLabelMouseExited(evt);
            }
        });
        menuRightPanel.add(loginAccLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 610, -1, -1));

        emailLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("Email");
        menuRightPanel.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, -1));

        rollNumberTextField.setBackground(new java.awt.Color(0, 2, 44));
        rollNumberTextField.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        rollNumberTextField.setForeground(new java.awt.Color(255, 255, 255));
        rollNumberTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        rollNumberTextField.setBorder(null);
        menuRightPanel.add(rollNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 410, 60));

        emailBlank.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        menuRightPanel.add(emailBlank, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 410, -1));

        passMarkLabel.setBackground(new java.awt.Color(255, 0, 0));
        passMarkLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        passMarkLabel.setForeground(new java.awt.Color(255, 0, 51));
        passMarkLabel.setText("*");
        menuRightPanel.add(passMarkLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 30, 30));

        usernameMarkLabel.setBackground(new java.awt.Color(255, 0, 0));
        usernameMarkLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        usernameMarkLabel.setForeground(new java.awt.Color(255, 0, 51));
        usernameMarkLabel.setText("*");
        menuRightPanel.add(usernameMarkLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 30, 30));

        emailMarkLabel.setBackground(new java.awt.Color(255, 0, 0));
        emailMarkLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        emailMarkLabel.setForeground(new java.awt.Color(255, 0, 51));
        emailMarkLabel.setText("*");
        menuRightPanel.add(emailMarkLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 30, 30));

        emailTextField.setBackground(new java.awt.Color(0, 2, 44));
        emailTextField.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        emailTextField.setForeground(new java.awt.Color(255, 255, 255));
        emailTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        emailTextField.setBorder(null);
        menuRightPanel.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 410, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuRightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuRightPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginAccLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginAccLabelMouseExited
        loginAccLabel.setForeground(new Color(255, 255, 255, 255));
    }//GEN-LAST:event_loginAccLabelMouseExited

    private void loginAccLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginAccLabelMouseEntered
        loginAccLabel.setForeground(new Color(12, 72, 187));
    }//GEN-LAST:event_loginAccLabelMouseEntered

    private void signUpPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpPanelMouseEntered
        signUpPanel.setBackground(panEnter);
    }//GEN-LAST:event_signUpPanelMouseEntered

    private void signUpPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpPanelMouseExited
        signUpPanel.setBackground(panDefault);
    }//GEN-LAST:event_signUpPanelMouseExited

    private void signUpPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpPanelMousePressed
        signUpPanel.setBackground(panClick);
    }//GEN-LAST:event_signUpPanelMousePressed

    private void signUpPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpPanelMouseReleased
        signUpPanel.setBackground(panDefault);
    }//GEN-LAST:event_signUpPanelMouseReleased

    private void signUpPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpPanelMouseClicked
        if (fullNameTextField.getText().equals("") | rollNumberTextField.getText().equals("") | rollNumberTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill out your informations!");
        } else {
            JOptionPane.showMessageDialog(null, "Thanks for signing up. Welcome to EIU Library!");
            String name = this.fullNameTextField.getText();
            String rollNumber = rollNumberTextField.getText();
            String email = emailTextField.getText();
            String filePath = "";
            try {
                filePath = QRCodeGenerator.generateQRCodeImage(rollNumber, 350, 350, "C:\\Testing", rollNumber + ".png");
            } catch (WriterException ex) {
                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            }
            SendEmail.sendEmail(email, filePath);
            if (studentDAO.insertStudentData(rollNumber, email, name) == 1) {
                SignIn signin = new SignIn();
                signin.setVisible(true);
                this.dispose();
            }
        }

    }//GEN-LAST:event_signUpPanelMouseClicked

    private void loginAccLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginAccLabelMouseClicked
        SignIn signin = new SignIn();
        signin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginAccLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel eiuLibraryLabel;
    private javax.swing.JLabel eiuSignUpLabel;
    private javax.swing.JLabel emailBlank;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailMarkLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel fullNameBlank;
    private javax.swing.JLabel fullNameLabel;
    private javax.swing.JTextField fullNameTextField;
    private javax.swing.JLabel loginAccLabel;
    private javax.swing.JLabel loginIconLabel;
    private javax.swing.JPanel menuLeftPanel;
    private javax.swing.JPanel menuRightPanel;
    private javax.swing.JLabel passMarkLabel;
    private javax.swing.JLabel rollNumberBlank;
    private javax.swing.JLabel rollNumberLabel;
    private javax.swing.JTextField rollNumberTextField;
    private javax.swing.JLabel signUpLabel;
    private javax.swing.JPanel signUpPanel;
    private javax.swing.JLabel usernameMarkLabel;
    // End of variables declaration//GEN-END:variables
}
