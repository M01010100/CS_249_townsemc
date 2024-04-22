package edu.realemj.assign07;

import edu.realemj.assign04.GameBoard;
import edu.realemj.assign06.Creature;
import edu.realemj.assign06.GameFileException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Test_Player {

    private final static int EXTENT = 10;

    @Test()
    public void testConstructorAndData() {
        // Create Creature
        Creature m = new Player();
        Assert.assertEquals(m.getRow(), 0);
        Assert.assertEquals(m.getCol(), 0);

        // Create Creature with different locations
        for (int row = -EXTENT; row <= EXTENT; row++) {
            for (int col = -EXTENT; col <= EXTENT; col++) {
                Creature m2 = new Player(row, col);
                Assert.assertEquals(m2.getRow(), row);
                Assert.assertEquals(m2.getCol(), col);
            }
        }
    }

    @Test()
    public void testSetters() {
        // Create Creature
        Creature m = new Player();

        // Set Creature with different locations
        for (int row = -EXTENT; row <= EXTENT; row++) {
            for (int col = -EXTENT; col <= EXTENT; col++) {
                m.setRow(row);
                m.setCol(col);
                Assert.assertEquals(m.getRow(), row);
                Assert.assertEquals(m.getCol(), col);
            }
        }
    }

    @Test()
    public void testLoad() {
        // Create Monster (requires Player to work)
        Creature m = new Player();

        // Create Scanners that contain different rows and columns
        for (int row = -EXTENT; row <= EXTENT; row++) {
            for (int col = -EXTENT; col <= EXTENT; col++) {
                Scanner s = new Scanner("" + row + " " + col);

                boolean testOK = false;
                try {
                    m.load(s);
                    testOK = true;
                }
                catch(GameFileException e) {
                    e.printStackTrace();
                    testOK = false;
                }

                Assert.assertTrue(testOK);

                Assert.assertEquals(m.getRow(), row);
                Assert.assertEquals(m.getCol(), col);
            }
        }

        // Give it intentionally bad data...
        Scanner s = new Scanner(" 3 a");

        boolean testOK = false;
        try {
            m.load(s);
            testOK = false;
        }
        catch(GameFileException e) {
            Assert.assertEquals(e.getMessage(), "Error loading Creature");
            Assert.assertNotEquals(e.getCause(), null);
            testOK = true;
        }

        Assert.assertTrue(testOK);

        Assert.assertEquals(m.getRow(), 0);
        Assert.assertEquals(m.getCol(), 0);
    }

    @Test()
    public void testDraw() {
        // Create Creature (requires Player to work)
        Creature m = new Player();

        // Create GameBoard
        GameBoard map = new GameBoard(10, 20, '.');

        // Draw orc a couple of times...
        // 1st draw
        m.draw(map);
        Assert.assertEquals(map.getBoardString(),
                "P...................\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n");

        // 2nd draw
        m.setRow(5);
        m.setCol(9);
        m.draw(map);
        Assert.assertEquals(map.getBoardString(),
                "P...................\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        ".........P..........\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n");

        // 3rd draw
        m.setRow(1);
        m.setCol(17);
        m.draw(map);
        Assert.assertEquals(map.getBoardString(),
                "P...................\n" +
                        ".................P..\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        ".........P..........\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n");

        // 4th draw
        m = new Player(7, -6);
        m.draw(map);
        Assert.assertEquals(map.getBoardString(),
                "P...................\n" +
                        ".................P..\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        ".........P..........\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n");
    }
}
