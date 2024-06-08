package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Student;
import model.Book;
import model.BorrowedBook;

public class BorrowedBookDAO {

    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    public BorrowedBookDAO() {
        connect();
    }

    public void connect() {
        try {
            // loading MySQL driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            // creating connection with the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/borrowbook", "root", "301103");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BorrowedBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<BorrowedBook> loadBorrowBookFromDatabase(String studentId) {
        List<BorrowedBook> borrowedBookList = new ArrayList<>();
        try {
            String query = "SELECT * FROM borrowbook natural join book where student_id = ?";
            st = con.prepareStatement(query);
            st.setString(1, studentId);
            rs = st.executeQuery();
            while (rs.next()) {
                String bookName = rs.getString("book_name");
                String bookAuthor = rs.getString("book_author");
                String bookType = rs.getString("book_type");
                String studentID = rs.getString("student_id");
                String bookID = rs.getString("book_id");
                Date borrowedDate = rs.getDate("borrow_date");
                Date returnDate = rs.getDate("return_date");
                int bookStatus = rs.getInt("book_status");
                BookManager.getBookList().get(bookID);
                BorrowedBook borrowedBook = new BorrowedBook(studentID, bookID, borrowedDate.toLocalDate(), returnDate.toLocalDate(), bookName, bookAuthor, bookType);
                borrowedBookList.add(borrowedBook);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BorrowedBookDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Consider throwing or handling the exception here
        } 
        return borrowedBookList;
    }

    public void insertBorrowBookFromDatabase(List<BorrowedBook> borrowedBookList) {
        for (BorrowedBook book : borrowedBookList) {
            try {
                st = con.prepareStatement("insert into borrowbook(student_id,book_id,borrow_date,return_date,book_status) values (?,?,?,?,?)");
                st.setString(1, book.getStudentID());
                st.setString(2, book.getBookID());
                st.setDate(3, Date.valueOf(book.getBorrowedDate()));
                st.setDate(4, Date.valueOf(book.getReturnDate()));
                st.setInt(5, book.getStatus());
                int k = st.executeUpdate();
                System.out.println(k);
            } catch (SQLException ex) {
                Logger.getLogger(BorrowedBookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public int  deleteBorrowedBookData(String bookID,String studentID){
        int k = 0;
        try {
            st= con.prepareStatement("delete from borrowbook where book_id = ? and student_id = ?");
            st.setString(1, bookID);
            st.setString(2, studentID);
             k = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BorrowedBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
    }

    private void closeResources() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowedBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
