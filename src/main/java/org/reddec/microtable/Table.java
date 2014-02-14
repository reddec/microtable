package org.reddec.microtable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author reddec
 */
public class Table<T> implements ITable<T> {

    private final ArrayList<ArrayList<T>> rows = new ArrayList<ArrayList<T>>();
    private int columnCount = 0;

    public List<T> getRow(int index) {
        if (index >= 0 && index < getHeight()) {
            return rows.get(index);
        }
        return null;
    }

    public List<T> getColumn(int index) {
        if (index >= 0 && index < columnCount) {
            ArrayList<T> column = new ArrayList<T>(getHeight());
            for (int i = 0; i < getHeight(); ++i) {
                column.add(getCell(i, index));
            }
            return column;
        }
        return null;
    }

    public T getCell(int row, int column) {
        if (row >= 0 && row < getHeight() && column >= 0 && column < columnCount) {
            return rows.get(row).get(column);
        }
        return null;
    }

    public boolean setCell(int row, int column, T value) {
        if (row >= 0 && row < getHeight() && column >= 0 && column < columnCount) {
            rows.get(row).set(column, value);
            return true;
        }
        return false;
    }

    public int addRow() {
        return addRow(null);
    }

    public int addRow(T defaultValue) {
        rows.add(new ArrayList<T>(columnCount));
        int indx = rows.size() - 1;
        for (int i = 0; i < columnCount; ++i) {
            rows.get(indx).add(defaultValue);
        }
        return indx;
    }

    public int attachRow(List<T> cellsRow) {
        if (cellsRow.size() < columnCount) {
            return -1;
        }
        rows.add(new ArrayList<T>(columnCount));
        int indx = rows.size() - 1;
        for (int i = 0; i < columnCount; ++i) {
            rows.get(indx).add(cellsRow.get(i));
        }
        return indx;
    }

    public int addColumn() {
        return addColumn(null);
    }

    public int addColumn(T defaultValue) {
        columnCount += 1;
        for (int i = 0; i < getHeight(); ++i) {
            rows.get(i).add(defaultValue);
        }
        return columnCount - 1;
    }

    public void addRows(int count) {
        addRows(count, null);
    }

    public void addRows(int count, T defaultValue) {
        for (int i = 0; i < count; ++i) {
            addRow(defaultValue);
        }
    }

    public void addColumns(int count) {
        addColumns(count, null);
    }

    public void addColumns(int count, T defaultValue) {
        for (int i = 0; i < count; ++i) {
            addColumn(defaultValue);
        }
    }

    public int attachColumn(List<T> cellsColumn) {
        if (cellsColumn.size() < getHeight()) {
            return -1;
        }
        columnCount += 1;
        for (int i = 0; i < getHeight(); ++i) {
            rows.get(i).add(cellsColumn.get(i));
        }
        return columnCount - 1;
    }

    public boolean moveColumn(int sourceIndex, int destIndex) {
        if (sourceIndex < 0 || sourceIndex >= getWidth() || destIndex < 0 || destIndex >= getWidth()) {
            return false;
        }
        for (int i = 0; i < getHeight(); ++i) {
            rows.get(i).add(destIndex, rows.get(i).remove(sourceIndex));
        }
        return true;
    }

    public boolean moveRow(int sourceIndex, int destIndex) {
        if (sourceIndex < 0 || sourceIndex >= getHeight() || destIndex < 0 || destIndex >= getHeight()) {
            return false;
        }
        rows.add(destIndex, rows.remove(sourceIndex));
        return true;
    }

    public boolean removeColumn(int index) {
        if (index < 0 || index >= getWidth()) {
            return false;
        }
        for (int i = 0; i < getHeight(); ++i) {
            rows.get(i).remove(index);
        }
        return true;
    }

    public boolean removeRow(int index) {
        if (index < 0 || index >= getHeight()) {
            return false;
        }
        rows.remove(index);
        return true;
    }

    public int getHeight() {
        return rows.size();
    }

    public int getWidth() {
        return columnCount;
    }

    public Table<T> rotateTable() {
        Table<T> ptable = new Table<T>();
        for (int i = 0; i < getHeight(); ++i) {
            ptable.addColumn();
        }
        for (int i = 0; i < columnCount; ++i) {
            ptable.attachRow(getColumn(i));
        }
        return ptable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getHeight(); ++i) {
            sb.append("#").append(i);
            for (int j = 0; j < columnCount; ++j) {
                sb.append("\t").append(getCell(i, j));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
