package edu.realemj.exercises09;

public class MatrixLand {
    public static void main(String [] args) {
        Matrix m = new Matrix(4,3);
        System.out.println(m);

        Matrix v = Matrix.makePoint2D(5,4);
        Matrix T = Matrix.makeTranslation2D(10, -25);

        Matrix w = T.multiply(v);
        System.out.println(T);
        System.out.println(v);
        System.out.println(w);
    }
}
