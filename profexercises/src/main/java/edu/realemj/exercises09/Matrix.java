package edu.realemj.exercises09;

public class Matrix {
    private double [][] m;

    public Matrix(int rowCnt, int colCnt) {
        m = new double[rowCnt][colCnt];
    }

    public int getRowCnt() {
        return m.length;
    }

    public int getColCnt() {
        return m[0].length;
    }

    public boolean isValidPosition(int r, int c) {
        return (
                r >= 0 &&
                c >= 0 &&
                r < getRowCnt() &&
                c < getColCnt()
        );
    }

    public double get(int r, int c) {
        if(isValidPosition(r,c)) {
            return m[r][c];
        }
        else {
            System.err.println("ERROR: Out of bounds!");
            return 0.0;
        }
    }

    public void set(int r, int c, double val) {
        if(isValidPosition(r,c)) {
            m[r][c] = val;
        }
        else {
            System.err.println("ERROR: Out of bounds!");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int row = 0; row < getRowCnt(); row++) {
            for(int col = 0; col < getColCnt(); col++) {
                sb.append(m[row][col]);
                sb.append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
