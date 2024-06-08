package model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class BorrowedBook extends Book {
    private String studentID;
    private LocalDate borrowedDate;
    private LocalDate returnDate;
    private int status; //0 là còn hạn, 1 là hết hạn
    Map<String, BorrowedBook> BorrowedBookList = new HashMap<String, BorrowedBook>();

    public BorrowedBook(String studentID, String bookID,
            String bookName, String bookAuthor, String bookType) {
        
        super(bookID, bookName, bookAuthor, bookType);
        this.studentID = studentID;
        this.borrowedDate = LocalDate.now();
        this.returnDate = borrowedDate.plusDays(14);
        this.status = 0;
    }
    public BorrowedBook(String studentID, String bookID, LocalDate borrowedDay, LocalDate returnDay,
            String bookName, String bookAuthor, String bookType) {
        
        super(bookID, bookName, bookAuthor, bookType);
        this.studentID = studentID;
        this.borrowedDate = borrowedDay;
        this.returnDate = returnDay;
        checkStatus();
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void checkStatus() {
       LocalDate today= LocalDate.now();
        if ( borrowedDate != null && today.compareTo(borrowedDate) > 0) {
            status = 1;
        }
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
    
    public int getStatus() {
        return status;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Map<String, BorrowedBook> getBorrowBookList() {
        return BorrowedBookList;
    }

}
