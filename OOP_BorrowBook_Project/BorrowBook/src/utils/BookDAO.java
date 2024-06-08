package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import model.Book;

public class BookDAO {

    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    public BookDAO() {
        connect();
    }

    public void connect() {
        try {
            // loading MySQL driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            // creating connection with the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/borrowbook", "root", "301103");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Map<String, Book> loadDataFromDatabase() {
        Map<String, Book> listOfBook = new HashMap<String, Book>();
        try {
            String query = "SELECT * FROM book";
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String bookAuthor = rs.getString("book_author");
                String bookType = rs.getString("book_type");
                listOfBook.put(bookId, new Book(bookId, bookName,bookAuthor,bookType));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            closeResources();
        }
        return listOfBook;

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
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
