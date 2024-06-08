/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ADMIN
 */
public class BorrowedBookTableModel extends AbstractTableModel {

    String[] columnHeaders = {"Book ID", "Book Name", "Return Date"};
    List<Object[]> listRow = new ArrayList<Object[]>();

    public BorrowedBookTableModel(List<BorrowedBook> borrowedBookList) {
        for (BorrowedBook book : borrowedBookList) {
            System.out.println(book.getReturnDate());
            Object[] row = {book.getBookID(), book.getBookName(), book.getReturnDate()};
            this.listRow.add(row);
            this.fireTableDataChanged();
        }
    }

    public void updateBorrowedBookTableModel(List<BorrowedBook> borrowedBookList) {
        for (BorrowedBook book : borrowedBookList) {
            System.out.println(book.getReturnDate());
            Object[] row = {book.getBookID(), book.getBookName(), book.getReturnDate()};
            this.listRow.add(row);
            this.fireTableDataChanged();
        }
        fireTableDataChanged();
    }

    public void deleteBorrowedBook(int row) {
        listRow.remove(row);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.listRow.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnHeaders.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.listRow.get(rowIndex)[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return this.columnHeaders[columnIndex].getClass();
    }

    @Override
    public String getColumnName(int column) {
        return this.columnHeaders[column];
    }

}
