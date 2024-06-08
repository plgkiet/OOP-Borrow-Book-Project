/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import utils.StudentManager;

/**
 *
 * @author Admin
 */
public class TempBorrowedBookTableModel extends AbstractTableModel {

    String[] columnHeaders = {"Book ID", "Name", "Author", "Type"};
    List<Object[]> listRow = new ArrayList<Object[]>();

    public TempBorrowedBookTableModel() {
    }

    public void addBorrowedBook(Book book) {
        listRow.add(new Object[]{book.getBookID(), book.getBookName(), book.getBookAuthor(), book.getBookType()});
        fireTableDataChanged();
    }
    public void deleteBorrowedBook(int row){
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
    public String getColumnName(int column) {
        return this.columnHeaders[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return this.columnHeaders[columnIndex].getClass();
    }

    public Object[] getObjectAtRow(int row) {
        return this.listRow.get(row);
    }

}
