package com.homework.numbermazeapp.solver;

public class Position<ROW, COL> implements Comparable<Position<ROW, COL>> {

    private ROW row;
    private COL col;

    public Position(ROW row, COL col) {
        this.row = row;
        this.col = col;
    }

    public static <ROW, COL> Position<ROW, COL> of(ROW row,
            COL col) {
        return new Position<ROW, COL>(row, col);
    }
       
    public ROW getRow() {
		return row;
    }

    public void setRow(ROW row) {
            this.row = row;
    }

    public COL getCol() {
            return col;
    }

    public void setCol(COL col) {
            this.col = col;
    }

    @Override
    public int compareTo(Position<ROW, COL> o) {
    int cmp = compare(row, o.row);
    return cmp == 0 ? compare(col, o.col) : cmp;
    }

    private static int compare(Object o1, Object o2) {
        return o1 == null ? o2 == null ? 0 : -1 : o2 == null ? +1
                : ((Comparable) o1).compareTo(o2);
    }

    @Override
    public int hashCode() {
        return 31 * hashcode(row) + hashcode(col);
    }

    private static int hashcode(Object o) {
        return o == null ? 0 : o.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position))
            return false;
        if (this == obj)
            return true;
        return equal(row, ((Position) obj).row)
                && equal(col, ((Position) obj).col);
    }

    private boolean equal(Object o1, Object o2) {
        return o1 == null ? o2 == null : (o1 == o2 || o1.equals(o2));
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ')';
    }
}