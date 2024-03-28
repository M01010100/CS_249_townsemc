package edu.realemj.exercises13;
import edu.realemj.exercises09.Matrix;
public class Rescaler {
    public static void main(String [] args) {
        OBJModel model = new OBJModel();

        try {
            model.load("bunny.obj");

            Matrix r = Matrix.makeRotationZ3D(45);
            Matrix s = Matrix.makeScaling3D(1, 2, 1);

            Matrix t = s.multiply(r);

            model.transform(t);

            model.save("bunnyModified.obj");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
