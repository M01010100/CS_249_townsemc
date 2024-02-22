package edu.realemj.exercises12;
import edu.realemj.exercises09.Matrix;
public class Shape {
    private Matrix center = Matrix.makePoint2D(0,0);
    protected boolean filled = true;

    public Shape() {}

    public Shape(Matrix center) {
        //this.center = new Matrix(center);
        this(center, true);
    }

    public Shape(Matrix center, boolean filled) {
        this.center = new Matrix(center);
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Matrix getCenter() {
        return new Matrix(center);
    }

    public void setCenter(Matrix center) {
        this.center = new Matrix(center);
    }

    public String toString() {
        String s = "Shape: ";
        s += center.toPoint2DString();
        if(filled) {
            s += ", filled";
        }
        return s;
    }
}
