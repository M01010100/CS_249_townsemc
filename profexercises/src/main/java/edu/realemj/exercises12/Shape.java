package edu.realemj.exercises12;
import edu.realemj.exercises09.Matrix;
public abstract class Shape {
    private Matrix center = Matrix.makePoint2D(0,0);
    protected boolean filled = true;

    protected Shape() {}

    protected Shape(Matrix center) {
        //this.center = new Matrix(center);
        this(center, true);
    }

    protected Shape(Matrix center, boolean filled) {
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

    @Override
    public String toString() {
        String s = "Shape: ";
        s += center.toPoint2DString();
        if(filled) {
            s += ", filled";
        }
        return s;
    }

    public abstract double getArea();

    @Override
    public boolean equals(Object other) {
        boolean same = false;
        if(other instanceof Shape otherS) {
            if(filled == otherS.filled && center.equals(otherS.center)) {
                same = true;
            }
        }
        return same;
    }
}
