package edu.realemj.exercises13;

public class Rescaler {
    public static void main(String [] args) {
        OBJModel model = new OBJModel();

        try {
            model.load("bunny.obj");
            model.save("bunnyModified.obj");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
