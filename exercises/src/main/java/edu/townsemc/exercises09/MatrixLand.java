package edu.townsemc.exercises09;

public class MatrixLand {
    public static void main(String [] args){
        Matrix m = new Matrix(4, 3);
        System.out.println(m);
        Matrix v = Matrix.makePoint2D(5,4);
        Matrix t = Matrix.makeTranslation2D(10,-20);
        Matrix W = t.multiply(v);
        System.out.println(v);
        System.out.println(t);
        System.out.println(W);
    }

}
