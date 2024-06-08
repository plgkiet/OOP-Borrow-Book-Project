/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.HashMap;
import java.util.Map;


public class Book {
    private String bookID;
    private String bookName;
    private String bookAuthor;
    private String bookType;
    Map<String,Book> childBookList = new HashMap<String,Book> ();

    public Book(String bookID, String bookName, String bookAuthor, String bookType) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookType = bookType;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public Map<String, Book> getChildBookList() {
        return childBookList;
    }

    public void setChildBookList(Map<String, Book> childBookList) {
        this.childBookList = childBookList;
    }

    public void updateBookInfor(Book newBook) {
        this.bookName = newBook.getBookName();
        this.bookAuthor = newBook.getBookAuthor();
        this.bookType = newBook.getBookType();
    }
    
}
