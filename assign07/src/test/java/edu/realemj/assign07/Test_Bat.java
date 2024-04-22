package edu.realemj.assign07;

import edu.realemj.assign04.GameBoard;
import edu.realemj.assign06.Creature;
import edu.realemj.assign06.GameFileException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Test_Bat {

    private final static int EXTENT = 10;

    @Test()
    public void testConstructorAndData() {
        // Create Creature
        Creature m = new Bat();
        Assert.assertEquals(m.getRow(), 0);
        Assert.assertEquals(m.getCol(), 0);

        // Create Creature with different locations
        for (int row = -EXTENT; row <= EXTENT; row++) {
            for (int col = -EXTENT; col <= EXTENT; col++) {
                Creature m2 = new Bat(row, col);
                Assert.assertEquals(m2.getRow(), row);
                Assert.assertEquals(m2.getCol(), col);
            }
        }
    }

    @Test()
    public void testSetters() {
        // Create Creature
        Creature m = new Bat();

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
        // Create Monster (requires Bat to work)
        Creature m = new Bat();

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
        // Create Creature (requires Bat to work)
        Creature m = new Bat();

        // Create GameBoard
        GameBoard map = new GameBoard(10, 20, '.');

        // Draw orc a couple of times...
        // 1st draw
        m.draw(map);
        Assert.assertEquals(map.getBoardString(),
                "B...................\n" +
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
                "B...................\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        ".........B..........\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n");

        // 3rd draw
        m.setRow(1);
        m.setCol(17);
        m.draw(map);
        Assert.assertEquals(map.getBoardString(),
                "B...................\n" +
                        ".................B..\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        ".........B..........\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n");

        // 4th draw
        m = new Bat(7, -6);
        m.draw(map);
        Assert.assertEquals(map.getBoardString(),
                "B...................\n" +
                        ".................B..\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        ".........B..........\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n" +
                        "....................\n");
    }

    // Test that Bat implements Mover
    @Test()
    public void testImplementsMover() {
        Mover m = new Bat();
    }

    // Test that Bat uses an AvoidPlayer under the hood
    @DataProvider(name="posGen")
    public Object[][] posGen() {
        int numRows = 5;
        int numCols = 5;
        int offsetRowCnt = 4;
        int offsetColCnt = 4;
        int totalPosCnt = numRows*numCols*(2*offsetRowCnt+1)*(2*offsetColCnt+1);
        Object [][] allPositions = new Object[totalPosCnt][4];
        int index = 0;
        for(int row = 0; row < numRows; row++) {
            for(int col = 0; col < numCols; col++) {
                for(int offr = -offsetRowCnt; offr <= offsetRowCnt; offr++) {
                    for(int offc = -offsetColCnt; offc <= offsetColCnt; offc++) {
                        allPositions[index][0] = row;
                        allPositions[index][1] = col;
                        allPositions[index][2] = offr;
                        allPositions[index][3] = offc;
                        index++;
                    }
                }
            }
        }
        return allPositions;
    }

    @Test(dataProvider = "posGen")
    public void testAvoiding(Integer row, Integer col, Integer rowOff, Integer colOff) {
        Player p = new Player(row,col);
        Bat b = new Bat(row+rowOff,col+colOff);
        b.performMove(p);

        int rowInc = 0;
        if(rowOff > 0) rowInc = 1;
        else if(rowOff < 0) rowInc = -1;

        int colInc = 0;
        if(colOff > 0) colInc = 1;
        else if(colOff < 0) colInc = -1;

        if(Math.abs(rowOff) > Math.abs(colOff)) {
            colInc = 0;
        }
        else {
            rowInc = 0;
        }

        Assert.assertEquals(b.getRow(), row+rowOff+rowInc);
        Assert.assertEquals(b.getCol(), col+colOff+colInc);
    }

}
