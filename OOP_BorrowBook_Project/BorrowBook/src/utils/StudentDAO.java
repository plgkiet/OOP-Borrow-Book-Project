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

public class StudentDAO {

    private   Connection con;
    private  PreparedStatement st;
    private  ResultSet rs;

    public StudentDAO() {
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

    public  Map<String,Student> loadStudentsFromDatabase() {
        Map<String,Student> listOfStudent = new HashMap<String,Student>();
        try {
            String query = "SELECT * FROM student";
            st = con.prepareStatement(query);
            rs = st.executeQuery();

            while (rs.next()) {
                String studentId = rs.getString("student_id");
                String studentName = rs.getString("student_name");
                String studentEmail = rs.getString("student_email");
                listOfStudent.put(studentId, new Student(studentId,studentName,studentEmail));
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        closeResources();
        }
        return listOfStudent;
    }
    
    public int insertStudentData(String studentID,String studentEmail,String studentName){
        int k = 0;
        try {
            st = con.prepareStatement("insert into student(student_id,student_name,student_email) values (?,?,?)");
            st.setString(1, studentID);
            st.setString(2, studentName);
            st.setString(3, studentEmail);
            k = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
    }
    
   

    private   void  closeResources() {
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
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
