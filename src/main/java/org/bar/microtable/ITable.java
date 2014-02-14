package org.bar.microtable;

import java.util.List;

/**
 * Simple table interface
 *
 * @author baryshnikov
 * @param <T> Table type
 */
public interface ITable<T extends Object> {

    /**
     * Get list of cells values from row
     *
     * @param index row index, start from 0
     * @return List of cells values or NULL if index wrong
     */
    public List<T> getRow(int index);

    /**
     * Get list of cells values from column
     *
     * @param index column index, start from 0
     * @return List of cells values in one column or NULL if index wrong
     */
    public List<T> getColumn(int index);

    /**
     * Get cell value with specified row and column index
     *
     * @param row row index
     * @param column column index
     * @return cell value or NULL if indexes is wrong
     */
    public T getCell(int row, int column);

    /**
     * Set cell value. Columns and rows must exist
     *
     * @param row row index
     * @param column column index
     * @param value cell value
     * @return true if cell set or false if indexes is wrong
     */
    public boolean setCell(int row, int column, T value);

    /**
     * Add new row to table
     *
     * @return index of new row
     */
    public int addRow();

    /**
     * Add new row to table and set new cells with default value
     *
     * @param defaultValue value for new cells
     * @return index of new row
     */
    public int addRow(T defaultValue);

    /**
     * Add rows
     *
     * @param count number of rows
     */
    public void addRows(int count);

    /**
     * Add rows and set new cells values
     *
     * @param count number of new rows
     * @param defaultValue value for new cells
     */
    public void addRows(int count, T defaultValue);

    /**
     * Add row and fill values
     *
     * @param cellsRow cells values in row. Length must be not less then columns
     * count
     * @return index of new row or -1 if cellsRow has not enough length
     */
    public int attachRow(List<T> cellsRow);

    /**
     * Add new column without header
     *
     * @return column index
     */
    public int addColumn();

    /**
     * Add column and fill rows with values
     *
     * @param cellsColumn list of cell values for each row in neew column.
     * Length of values can't be less then table height
     * @return new column index or -1 if length of cellsColumn is not enought
     */
    public int attachColumn(List<T> cellsColumn);

    /**
     * Add column and set new cells with default value
     *
     * @param defaultValue value for new cells
     * @return new column index
     */
    public int addColumn(T defaultValue);

    /**
     * Add columns
     *
     * @param count columns count
     */
    public void addColumns(int count);

    /**
     * Add columns and fill new cells with value
     *
     * @param count number of new columns
     * @param defaultValue value for new cells
     */
    public void addColumns(int count, T defaultValue);

    /**
     * Move column from source index to destination index.
     *
     * @param sourceIndex column index
     * @param destIndex destination index
     * @return true if column moved or false if indexes are invalid
     */
    public boolean moveColumn(int sourceIndex, int destIndex);

    /**
     * Move row from source index to destination index
     *
     * @param sourceIndex row index
     * @param destIndex destination index
     * @return true if row moved or false if indexes are invalid
     */
    public boolean moveRow(int sourceIndex, int destIndex);

    /**
     * Remove column
     *
     * @param index column index
     * @return true if column removed or false if index is invalid
     */
    public boolean removeColumn(int index);

    /**
     * Remove row
     *
     * @param index row index
     * @return true if row removed or false if index is invalid
     */
    public boolean removeRow(int index);

    /**
     * Get rows count
     *
     * @return number of rows
     */
    public int getHeight();

    /**
     * Get columns count
     *
     * @return number of columns
     */
    public int getWidth();

    /**
     * Create new table, where target columns are current rows and target rows
     * are current columns. Important! This operation creates new copy of table
     * without column headers
     *
     * @return New rotated table
     */
    public ITable<T> rotateTable();

}
