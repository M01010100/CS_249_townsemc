package edu.realemj.exercises13;
import edu.realemj.exercises09.Matrix;
public class Rescaler {
    public static void main(String [] args) {
        OBJModel model = new OBJModel();

        try {
            model.load("bunny.obj");

            //Matrix r = Matrix.
            //model.save("bunnyModified.obj");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
