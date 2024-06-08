/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.BorrowedBookDAO;

/**
 *
 * @author Admin
 */
public class Student {
    private String studentID;
    private String studentName;
    private String studentEmail;
    private BorrowedBookDAO borrowedBookDAO = new BorrowedBookDAO();
    List<BorrowedBook> borrowedBookList = new ArrayList<BorrowedBook>();

    public Student(String studentID, String studentName, String studentEmail) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public List<BorrowedBook> getBorrowedBookList() {
        return borrowedBookList;
    }

    public void setBorrowedBookList(List<BorrowedBook> borrowedBookList) {
        this.borrowedBookList = borrowedBookList;
    }

    public void updateStudentInfor(Student newStudentInfor) {
        this.studentName = newStudentInfor.getStudentName();
        this.studentEmail = newStudentInfor.getStudentEmail();
    }
    
       
    
}
