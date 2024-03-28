package edu.realemj.exercises13;
import java.util.*;
import java.io.*;
import edu.realemj.exercises09.Matrix;
public class OBJModel {
    private ArrayList<Matrix> vertices = new ArrayList<>();
    private ArrayList<Integer> indices = new ArrayList<>();

    public void save(String filename) throws IOException {
        try (
            PrintWriter output = new PrintWriter(new File(filename));
        ) {
            for(Matrix v : vertices) {
                output.println(v.getOBJVertexString());
            }

            for(int i = 0; i < indices.size(); i += 3) {
                output.println("f "
                                + indices.get(i) + " "
                                + indices.get(i+1) + " "
                                + indices.get(i+2));
            }
        }
        catch(Exception e) {
            throw new IOException("Could not save file: " + filename, e);
        }
    }

    public void load(String filename) throws IOException {
        vertices.clear();
        indices.clear();

        try (
            Scanner fileInput = new Scanner(new File(filename));
        ) {
            while(fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                line = line.trim();
                if(!line.isEmpty()) {
                    Scanner parseLine = new Scanner(line);
                    String token = parseLine.next();
                    if(token.equals("v")) {
                        // v x y z
                        double x = parseLine.nextDouble();
                        double y = parseLine.nextDouble();
                        double z = parseLine.nextDouble();
                        Matrix v = Matrix.makePoint3D(x,y,z);
                        vertices.add(v);
                    }
                    else if(token.equals("f")) {
                        // f i0 i1 i2
                        indices.add(parseLine.nextInt());
                        indices.add(parseLine.nextInt());
                        indices.add(parseLine.nextInt());
                    }
                }
            }
        }
        catch(Exception e) {
            vertices.clear();
            indices.clear();
            throw new IOException("Could not load file: " + filename, e);
        }
    }

    public void transform(Matrix m) {
        for(int i = 0; i < vertices.size(); i++) {
            vertices.set(i, m.multiply(vertices.get(i)));
        }
    }
}
