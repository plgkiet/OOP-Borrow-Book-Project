/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.HashMap;
import java.util.Map;
import model.Book;
import java.lang.*;
import model.Student;

/**
 *
 * @author Admin
 */
public class BookManager {

    static Map<String, Book> bookList = new HashMap<String, Book>();
    private static BookDAO bookDAO = new BookDAO();

    public static Map<String, Book> getBookList() {
        return bookList;
    }

    public static void setBookList(Map<String, Book> bookList) {
        BookManager.bookList = bookList;
    }

    public static void addBook(Book book) {
        bookList.put(book.getBookID(), book);
    }

    public static void deleteBook(Book book) {
        bookList.remove(book.getBookID());
    }

    public static void updateBook(String bookID, Book newBook) {
        bookList.get(bookID).updateBookInfor(newBook);
    }

    public static void addChildBook(String bookID, Book book) {
        bookList.get(bookID).getChildBookList().put(book.getBookID(), book);
    }

    public static void deleteChildBook(String bookID, String childBookID) {
        bookList.get(bookID).getChildBookList().remove(childBookID);
    }
    
   public static void loadBookData(){
        bookList = bookDAO.loadDataFromDatabase();
    } 
   public static Book checkBook(String bookId){
       Book book = bookList.get(bookId);
       if(book != null){
           return book;
       }else{
           return null;
       }
   }
}
