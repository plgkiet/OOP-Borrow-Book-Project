/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author Admin
 */
public class StudentManager {
     private static Map<String,Student> studentList = new HashMap<String,Student>();
     private  static StudentDAO studentDAO = new StudentDAO();
    public static Map<String, Student> getStudentList() {
        return studentList;
    }

    public static void setStudentList(Map<String, Student> studentList) {
        StudentManager.studentList = studentList;
    }
     
    public static void addStudent(Student student){
        studentList.put(student.getStudentID(), student);
    }
    public static void deleteStudent(String studentID){
        studentList.remove(studentID);
    }
    public static void updateStudent(String studentID, Student newStudentInfor){
        Student student = studentList.get(studentID);
        student.updateStudentInfor(newStudentInfor);
    }
    public  static Student  checkUser(String studentID){
        Student stu  = studentList.get(studentID);
        if(stu != null){
            return stu;
        }else{
            return null;
        }
    }
    public static void loadStudentData(){
        studentList = studentDAO.loadStudentsFromDatabase();
    }
}
    
