package edu.realemj.exercises09;

public class Matrix {
    private double [][] m;

    public Matrix(int rowCnt, int colCnt) {
        m = new double[rowCnt][colCnt];
    }

    public Matrix(Matrix other) {
        m = new double[other.getRowCnt()][other.getColCnt()];
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[i].length; j++) {
                m[i][j] = other.m[i][j];
            }
        }
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

    public Matrix multiply(Matrix other) {
        if(getColCnt() != other.getRowCnt()) {
            System.err.println("CANNOT MULTIPLY!");
            return null;
        }

        Matrix r = new Matrix(getRowCnt(), other.getColCnt());
        for(int i = 0; i < r.getRowCnt(); i++) {
            for(int j = 0; j < r.getColCnt(); j++) {
                // r[i][j]
                for(int k = 0; k < getColCnt(); k++) {
                    double val = get(i,k)*other.get(k,j);
                    r.set(i, j, r.get(i,j) + val);
                }
            }
        }
        return r;
    }

    public static Matrix makePoint2D(double x, double y) {
        Matrix v = new Matrix(3, 1);
        v.set(0,0, x);
        v.set(1,0, y);
        v.set(2, 0, 1);
        return v;
    }

    public static Matrix makeTranslation2D(double tx, double ty) {
        Matrix m = new Matrix(3,3);
        m.set(0,0, 1);
        m.set(1,1,1);
        m.set(2,2,1);
        m.set(0, 2, tx);
        m.set(1, 2, ty);
        return m;
    }

    public String toPoint2DString() {
        return "(" + m[0][0] + "," + m[1][0] + ")";
    }

    @Override
    public boolean equals(Object other) {
        boolean same = false;
        if(other instanceof Matrix otherM) {
            if(this.getRowCnt() == otherM.getRowCnt() &&
                this.getColCnt() == otherM.getColCnt()) {

                boolean valuesSame = true;
                for(int r = 0; r < getRowCnt(); r++) {
                    for(int c = 0; c < getColCnt(); c++) {
                        if(!MathCompare.equalDoubles(m[r][c], otherM.m[r][c])) {
                            valuesSame = false;
                            break;
                        }
                    }
                }

                same = valuesSame;
            }
        }
        return same;
    }
}
