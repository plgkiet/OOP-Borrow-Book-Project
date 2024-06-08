package Form;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Book;
import model.BorrowedBook;
import model.BorrowedBookTableModel;
import model.TempBorrowedBookTableModel;
import model.Student;
import utils.BookManager;
import utils.BorrowedBookDAO;
import utils.Camera;
import utils.StudentManager;

public class Menu extends javax.swing.JFrame {

    Color panDefault, panEnter, panClick;
    private Camera camera;
    private BorrowedBookTableModel borrowedBookTableModel;
    private BorrowedBook borrowedBook;
    private Student student;
    private BorrowedBookDAO borrowedBookDAO = new BorrowedBookDAO();
    private TempBorrowedBookTableModel tempBorrowedBookTableModel;

    public Menu(Student student) {
        this.student = student;
        BookManager.loadBookData();
        initComponents();
        camera = new Camera(1);
        panDefault = new Color(255, 153, 0);
        panClick = new Color(243, 183, 68);
        panEnter = new Color(234, 98, 43);
        returnBookPanel.setBackground(panDefault);
        loadNameAndRollNumber();
        loadBorrowedBook();
        borrowedBookTableModel = new BorrowedBookTableModel(student.getBorrowedBookList());
        this.loadBorrowedBookTable.setModel(borrowedBookTableModel);
    }

    public void check(String data, int type) {
        if (type == 0) {
            Book temp = BookManager.checkBook(data);
            if (temp == null) {
                JOptionPane.showMessageDialog(rootPane, "Book not found", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                System.out.println("Checked");
                tempBorrowedBookTableModel.addBorrowedBook(temp);
            }
        } else {
            int i = 0;
            boolean flag = false;
            for (BorrowedBook book : student.getBorrowedBookList()) {
                if (book.getBookID().equalsIgnoreCase(data)) {
                    student.getBorrowedBookList().remove(i);
                    borrowedBookTableModel.deleteBorrowedBook(i);
                    if (borrowedBookDAO.deleteBorrowedBookData(data, student.getStudentID()) == 1) {
                        flag = true;
                        break;
                    }
                }
                i++;
            }
            if (flag) {
                JOptionPane.showMessageDialog(rootPane, "Returned", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showConfirmDialog(rootPane, "Book not found", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void setImage(BufferedImage image, int type) {
        ImageIcon icon = new ImageIcon(image);
        if (type == 0) {
            cameraLabel.setIcon(icon);
            cameraPanel.repaint();
        } else {
            cameraLabel1.setIcon(icon);
            cameraPanel1.repaint();
        }
    }

    public void startBorrowCamera() {
        camera.scanAndDecode(this, 0);
    }

    public void startReturnCamera() {
        camera.scanAndDecode(this, 1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        borrowDialog = new javax.swing.JDialog();
        borrowPanel = new javax.swing.JPanel();
        menuLeftPanel1 = new javax.swing.JPanel();
        eiuLibraryLabel = new javax.swing.JLabel();
        loginIconLabel = new javax.swing.JLabel();
        eiuBorrowLabel = new javax.swing.JLabel();
        borrowAnnouncePanel = new javax.swing.JPanel();
        acceptButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        borrowedBookTableScrollPane = new javax.swing.JScrollPane();
        borrowedBookTable = new javax.swing.JTable();
        cameraPanel = new javax.swing.JPanel();
        cameraLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        returnDialog = new javax.swing.JDialog();
        returnPanel = new javax.swing.JPanel();
        menuLeftPanel2 = new javax.swing.JPanel();
        eiuLibraryLabel1 = new javax.swing.JLabel();
        loginIconLabel1 = new javax.swing.JLabel();
        eiuBorrowLabel1 = new javax.swing.JLabel();
        borrowAnnouncePanel1 = new javax.swing.JPanel();
        cameraPanel1 = new javax.swing.JPanel();
        cameraLabel1 = new javax.swing.JLabel();
        menuRightPanel = new javax.swing.JPanel();
        menuLeftPanel = new javax.swing.JPanel();
        menuIconLabel = new javax.swing.JLabel();
        studentNameLabel = new javax.swing.JLabel();
        rollNumberLabel = new javax.swing.JLabel();
        logOutPanel = new javax.swing.JPanel();
        studentNameTextField = new javax.swing.JTextField();
        rollNumberTextField = new javax.swing.JTextField();
        returnBookPanel = new javax.swing.JPanel();
        returnBookLabel = new javax.swing.JLabel();
        borrowBookPanel = new javax.swing.JPanel();
        borrowLabel = new javax.swing.JLabel();
        loadBorrowedBookTableScrollPane = new javax.swing.JScrollPane();
        loadBorrowedBookTable = new javax.swing.JTable();

        borrowDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        borrowDialog.setResizable(false);
        borrowDialog.setSize(new java.awt.Dimension(880, 660));

        borrowPanel.setBackground(new java.awt.Color(0, 2, 44));
        borrowPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuLeftPanel1.setBackground(new java.awt.Color(255, 153, 0));

        eiuLibraryLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        eiuLibraryLabel.setForeground(new java.awt.Color(255, 255, 255));
        eiuLibraryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eiuLibraryLabel.setText("EIU Library");

        loginIconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconlibrary.png"))); // NOI18N

        eiuBorrowLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        eiuBorrowLabel.setForeground(new java.awt.Color(255, 255, 255));
        eiuBorrowLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eiuBorrowLabel.setText("Borrow");

        javax.swing.GroupLayout menuLeftPanel1Layout = new javax.swing.GroupLayout(menuLeftPanel1);
        menuLeftPanel1.setLayout(menuLeftPanel1Layout);
        menuLeftPanel1Layout.setHorizontalGroup(
            menuLeftPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginIconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(eiuBorrowLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(eiuLibraryLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        menuLeftPanel1Layout.setVerticalGroup(
            menuLeftPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLeftPanel1Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(eiuLibraryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eiuBorrowLabel)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        borrowPanel.add(menuLeftPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 660));

        borrowAnnouncePanel.setBackground(new java.awt.Color(204, 204, 204));

        acceptButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        acceptButton.setText("ACCEPT");
        acceptButton.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        acceptButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acceptButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                acceptButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                acceptButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                acceptButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                acceptButtonMouseReleased(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancelButton.setText("CANCEL");
        cancelButton.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelButtonMouseReleased(evt);
            }
        });

        borrowedBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        borrowedBookTableScrollPane.setViewportView(borrowedBookTable);

        cameraLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        cameraLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout cameraPanelLayout = new javax.swing.GroupLayout(cameraPanel);
        cameraPanel.setLayout(cameraPanelLayout);
        cameraPanelLayout.setHorizontalGroup(
            cameraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cameraLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cameraPanelLayout.setVerticalGroup(
            cameraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cameraLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        );

        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout borrowAnnouncePanelLayout = new javax.swing.GroupLayout(borrowAnnouncePanel);
        borrowAnnouncePanel.setLayout(borrowAnnouncePanelLayout);
        borrowAnnouncePanelLayout.setHorizontalGroup(
            borrowAnnouncePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borrowAnnouncePanelLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(borrowAnnouncePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(borrowAnnouncePanelLayout.createSequentialGroup()
                        .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cameraPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(borrowedBookTableScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        borrowAnnouncePanelLayout.setVerticalGroup(
            borrowAnnouncePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borrowAnnouncePanelLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(cameraPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(borrowedBookTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(borrowAnnouncePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        borrowPanel.add(borrowAnnouncePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 540, 600));

        javax.swing.GroupLayout borrowDialogLayout = new javax.swing.GroupLayout(borrowDialog.getContentPane());
        borrowDialog.getContentPane().setLayout(borrowDialogLayout);
        borrowDialogLayout.setHorizontalGroup(
            borrowDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(borrowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        borrowDialogLayout.setVerticalGroup(
            borrowDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(borrowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        returnPanel.setBackground(new java.awt.Color(0, 2, 44));
        returnPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuLeftPanel2.setBackground(new java.awt.Color(255, 153, 0));

        eiuLibraryLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        eiuLibraryLabel1.setForeground(new java.awt.Color(255, 255, 255));
        eiuLibraryLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eiuLibraryLabel1.setText("EIU Library");

        loginIconLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginIconLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconlibrary.png"))); // NOI18N

        eiuBorrowLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        eiuBorrowLabel1.setForeground(new java.awt.Color(255, 255, 255));
        eiuBorrowLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eiuBorrowLabel1.setText("Return");

        javax.swing.GroupLayout menuLeftPanel2Layout = new javax.swing.GroupLayout(menuLeftPanel2);
        menuLeftPanel2.setLayout(menuLeftPanel2Layout);
        menuLeftPanel2Layout.setHorizontalGroup(
            menuLeftPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginIconLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(eiuBorrowLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(eiuLibraryLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        menuLeftPanel2Layout.setVerticalGroup(
            menuLeftPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLeftPanel2Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(eiuLibraryLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginIconLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eiuBorrowLabel1)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        returnPanel.add(menuLeftPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 660));

        borrowAnnouncePanel1.setBackground(new java.awt.Color(204, 204, 204));

        cameraLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        cameraLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout cameraPanel1Layout = new javax.swing.GroupLayout(cameraPanel1);
        cameraPanel1.setLayout(cameraPanel1Layout);
        cameraPanel1Layout.setHorizontalGroup(
            cameraPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cameraPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(cameraLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        cameraPanel1Layout.setVerticalGroup(
            cameraPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cameraPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(cameraLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout borrowAnnouncePanel1Layout = new javax.swing.GroupLayout(borrowAnnouncePanel1);
        borrowAnnouncePanel1.setLayout(borrowAnnouncePanel1Layout);
        borrowAnnouncePanel1Layout.setHorizontalGroup(
            borrowAnnouncePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borrowAnnouncePanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(cameraPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        borrowAnnouncePanel1Layout.setVerticalGroup(
            borrowAnnouncePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borrowAnnouncePanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(cameraPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        returnPanel.add(borrowAnnouncePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 540, 600));

        javax.swing.GroupLayout returnDialogLayout = new javax.swing.GroupLayout(returnDialog.getContentPane());
        returnDialog.getContentPane().setLayout(returnDialogLayout);
        returnDialogLayout.setHorizontalGroup(
            returnDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(returnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
        );
        returnDialogLayout.setVerticalGroup(
            returnDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(returnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        menuRightPanel.setBackground(new java.awt.Color(0, 2, 44));
        menuRightPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuLeftPanel.setBackground(new java.awt.Color(255, 153, 0));

        menuIconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconlibrary.png"))); // NOI18N

        studentNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        studentNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        studentNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentNameLabel.setText("Student Name:");

        rollNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rollNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        rollNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rollNumberLabel.setText("Roll Number:");

        logOutPanel.setBackground(new java.awt.Color(197, 119, 0));
        logOutPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logOutPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logOutPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logOutPanelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout logOutPanelLayout = new javax.swing.GroupLayout(logOutPanel);
        logOutPanel.setLayout(logOutPanelLayout);
        logOutPanelLayout.setHorizontalGroup(
            logOutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );
        logOutPanelLayout.setVerticalGroup(
            logOutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        studentNameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentNameTextField.setText("full name");
        studentNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentNameTextFieldActionPerformed(evt);
            }
        });

        rollNumberTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rollNumberTextField.setText("number");

        javax.swing.GroupLayout menuLeftPanelLayout = new javax.swing.GroupLayout(menuLeftPanel);
        menuLeftPanel.setLayout(menuLeftPanelLayout);
        menuLeftPanelLayout.setHorizontalGroup(
            menuLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuIconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(studentNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rollNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuLeftPanelLayout.createSequentialGroup()
                .addGroup(menuLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLeftPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logOutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(menuLeftPanelLayout.createSequentialGroup()
                        .addGroup(menuLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menuLeftPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(studentNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(menuLeftPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(rollNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        menuLeftPanelLayout.setVerticalGroup(
            menuLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLeftPanelLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(menuIconLabel)
                .addGap(18, 18, 18)
                .addComponent(studentNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rollNumberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rollNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                .addComponent(logOutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menuRightPanel.add(menuLeftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 720));

        returnBookPanel.setBackground(new java.awt.Color(255, 153, 0));
        returnBookPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        returnBookPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnBookPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                returnBookPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                returnBookPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                returnBookPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                returnBookPanelMouseReleased(evt);
            }
        });

        returnBookLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        returnBookLabel.setForeground(new java.awt.Color(255, 255, 255));
        returnBookLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        returnBookLabel.setText("Return");

        javax.swing.GroupLayout returnBookPanelLayout = new javax.swing.GroupLayout(returnBookPanel);
        returnBookPanel.setLayout(returnBookPanelLayout);
        returnBookPanelLayout.setHorizontalGroup(
            returnBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(returnBookPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(returnBookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        returnBookPanelLayout.setVerticalGroup(
            returnBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(returnBookLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        menuRightPanel.add(returnBookPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 600, 230, 60));

        borrowBookPanel.setBackground(new java.awt.Color(255, 153, 0));
        borrowBookPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        borrowBookPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrowBookPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                borrowBookPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                borrowBookPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                borrowBookPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                borrowBookPanelMouseReleased(evt);
            }
        });

        borrowLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        borrowLabel.setForeground(new java.awt.Color(255, 255, 255));
        borrowLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        borrowLabel.setText("Borrow");

        javax.swing.GroupLayout borrowBookPanelLayout = new javax.swing.GroupLayout(borrowBookPanel);
        borrowBookPanel.setLayout(borrowBookPanelLayout);
        borrowBookPanelLayout.setHorizontalGroup(
            borrowBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borrowBookPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(borrowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        borrowBookPanelLayout.setVerticalGroup(
            borrowBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(borrowLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        menuRightPanel.add(borrowBookPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 600, 230, 60));

        loadBorrowedBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        loadBorrowedBookTableScrollPane.setViewportView(loadBorrowedBookTable);

        menuRightPanel.add(loadBorrowedBookTableScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 760, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuRightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuRightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutPanelMouseClicked
        SignUp signup = new SignUp();
        signup.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOutPanelMouseClicked

    private void logOutPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutPanelMouseEntered
        logOutPanel.setBackground(panEnter);
    }//GEN-LAST:event_logOutPanelMouseEntered

    private void logOutPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutPanelMouseExited
        logOutPanel.setBackground(panDefault);
    }//GEN-LAST:event_logOutPanelMouseExited

    private void logOutPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutPanelMousePressed
        logOutPanel.setBackground(panClick);
    }//GEN-LAST:event_logOutPanelMousePressed

    private void logOutPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutPanelMouseReleased
        logOutPanel.setBackground(panDefault);
    }//GEN-LAST:event_logOutPanelMouseReleased

    private void returnBookPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBookPanelMouseClicked
        returnDialog.setVisible(true);
        new Thread(this::startReturnCamera).start();
    }//GEN-LAST:event_returnBookPanelMouseClicked

    private void returnBookPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBookPanelMouseEntered
        returnBookPanel.setBackground(panEnter);
    }//GEN-LAST:event_returnBookPanelMouseEntered

    private void returnBookPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBookPanelMouseExited
        returnBookPanel.setBackground(panDefault);
    }//GEN-LAST:event_returnBookPanelMouseExited

    private void returnBookPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBookPanelMousePressed
        returnBookPanel.setBackground(panClick);
    }//GEN-LAST:event_returnBookPanelMousePressed

    private void returnBookPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBookPanelMouseReleased
        returnBookPanel.setBackground(panDefault);
    }//GEN-LAST:event_returnBookPanelMouseReleased

    private void borrowBookPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowBookPanelMouseClicked
        borrowDialog.setVisible(true);
        tempBorrowedBookTableModel = new TempBorrowedBookTableModel();
        borrowedBookTable.setModel(tempBorrowedBookTableModel);
        new Thread(this::startBorrowCamera).start();
    }//GEN-LAST:event_borrowBookPanelMouseClicked

    private void borrowBookPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowBookPanelMouseEntered
        borrowBookPanel.setBackground(panEnter);
    }//GEN-LAST:event_borrowBookPanelMouseEntered

    private void borrowBookPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowBookPanelMouseExited
        borrowBookPanel.setBackground(panDefault);
    }//GEN-LAST:event_borrowBookPanelMouseExited

    private void borrowBookPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowBookPanelMousePressed
        borrowBookPanel.setBackground(panClick);
    }//GEN-LAST:event_borrowBookPanelMousePressed

    private void borrowBookPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowBookPanelMouseReleased
        borrowBookPanel.setBackground(panDefault);
    }//GEN-LAST:event_borrowBookPanelMouseReleased

    private void studentNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentNameTextFieldActionPerformed
        }//GEN-LAST:event_studentNameTextFieldActionPerformed

    private void acceptButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acceptButtonMouseClicked
        int currentBorrowedBooks = this.student.getBorrowedBookList().size();
        int currentBorrowingBooks = this.borrowedBookTable.getRowCount();
        if (currentBorrowedBooks + currentBorrowingBooks > 5) {
            JOptionPane.showMessageDialog(rootPane, "You are not allowed to borrow more than 5 books", "Borrowal Failure", 0);

        } else {
            for (int i = 0; i < currentBorrowingBooks; i++) {
                Object[] obj = this.tempBorrowedBookTableModel.getObjectAtRow(i);
                Book book = BookManager.getBookList().get(obj[0]);
                BorrowedBook borrowedBook = new BorrowedBook(student.getStudentID(), book.getBookID(), book.getBookName(), book.getBookAuthor(), book.getBookType());
                student.getBorrowedBookList().add(borrowedBook);
            }
            for (BorrowedBook book : this.student.getBorrowedBookList()) {
                System.out.println(book.getBookID());
                System.out.println(book.getBorrowedDate());
                System.out.println(book.getReturnDate());
            }
            borrowedBookTableModel.updateBorrowedBookTableModel(student.getBorrowedBookList());
            borrowedBookDAO.insertBorrowBookFromDatabase(student.getBorrowedBookList());
            this.borrowDialog.dispose();
            camera.setCanStart(false);
        }
    }//GEN-LAST:event_acceptButtonMouseClicked

    public void loadNameAndRollNumber() {
        studentNameTextField.setText(student.getStudentName());
        rollNumberTextField.setText(student.getStudentID());
    }
    private void acceptButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acceptButtonMouseEntered
        acceptButton.setBackground(panEnter);
    }//GEN-LAST:event_acceptButtonMouseEntered

    private void acceptButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acceptButtonMouseExited
        acceptButton.setBackground(panDefault);
    }//GEN-LAST:event_acceptButtonMouseExited

    private void acceptButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acceptButtonMousePressed
        acceptButton.setBackground(panClick);
    }//GEN-LAST:event_acceptButtonMousePressed

    private void acceptButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acceptButtonMouseReleased
        acceptButton.setBackground(panDefault);
    }//GEN-LAST:event_acceptButtonMouseReleased

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        this.borrowDialog.dispose();
    }//GEN-LAST:event_cancelButtonMouseClicked

    private void cancelButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseEntered
        cancelButton.setBackground(panEnter);
    }//GEN-LAST:event_cancelButtonMouseEntered

    private void cancelButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseExited
        cancelButton.setBackground(panDefault);
    }//GEN-LAST:event_cancelButtonMouseExited

    private void cancelButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMousePressed
        cancelButton.setBackground(panClick);
    }//GEN-LAST:event_cancelButtonMousePressed

    private void cancelButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseReleased
        cancelButton.setBackground(panDefault);
    }//GEN-LAST:event_cancelButtonMouseReleased

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        int row = this.borrowedBookTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(rootPane, "Please choose the row before delete");
        } else {
            this.tempBorrowedBookTableModel.deleteBorrowedBook(row);
        }
    }//GEN-LAST:event_deleteButtonMouseClicked
    private void deleteButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonMouseEntered

    private void deleteButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonMouseExited

    private void deleteButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonMousePressed

    private void deleteButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonMouseReleased
    private void loadBorrowedBook() {
        student.setBorrowedBookList(borrowedBookDAO.loadBorrowBookFromDatabase(student.getStudentID()));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JPanel borrowAnnouncePanel;
    private javax.swing.JPanel borrowAnnouncePanel1;
    private javax.swing.JPanel borrowBookPanel;
    private javax.swing.JDialog borrowDialog;
    private javax.swing.JLabel borrowLabel;
    private javax.swing.JPanel borrowPanel;
    private javax.swing.JTable borrowedBookTable;
    private javax.swing.JScrollPane borrowedBookTableScrollPane;
    private javax.swing.JLabel cameraLabel;
    private javax.swing.JLabel cameraLabel1;
    private javax.swing.JPanel cameraPanel;
    private javax.swing.JPanel cameraPanel1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel eiuBorrowLabel;
    private javax.swing.JLabel eiuBorrowLabel1;
    private javax.swing.JLabel eiuLibraryLabel;
    private javax.swing.JLabel eiuLibraryLabel1;
    private javax.swing.JTable loadBorrowedBookTable;
    private javax.swing.JScrollPane loadBorrowedBookTableScrollPane;
    private javax.swing.JPanel logOutPanel;
    private javax.swing.JLabel loginIconLabel;
    private javax.swing.JLabel loginIconLabel1;
    private javax.swing.JLabel menuIconLabel;
    private javax.swing.JPanel menuLeftPanel;
    private javax.swing.JPanel menuLeftPanel1;
    private javax.swing.JPanel menuLeftPanel2;
    private javax.swing.JPanel menuRightPanel;
    private javax.swing.JLabel returnBookLabel;
    private javax.swing.JPanel returnBookPanel;
    private javax.swing.JDialog returnDialog;
    private javax.swing.JPanel returnPanel;
    private javax.swing.JLabel rollNumberLabel;
    private javax.swing.JTextField rollNumberTextField;
    private javax.swing.JLabel studentNameLabel;
    private javax.swing.JTextField studentNameTextField;
    // End of variables declaration//GEN-END:variables
}
