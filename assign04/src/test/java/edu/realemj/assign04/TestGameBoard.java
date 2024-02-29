package edu.realemj.assign04;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestGameBoard {
    
    @DataProvider(name="mapGen")
    public Object[][] mapGen() {
        int numRows = 10;
        int numCols = 10;
        char defaultChar = '@';
        int totalMapCnt = numRows*numCols;
        Object [][] maps = new Object[totalMapCnt][4];
        int index = 0;
        for(int rows = 1; rows <= numRows; rows++) {
            for(int cols = 1; cols <= numCols; cols++) {
                maps[index][0] = new GameBoard(rows, cols, defaultChar);
                maps[index][1] = rows;
                maps[index][2] = cols;
                maps[index][3] = defaultChar;
                index++;
            }
        }
        return maps;
    }

    @Test(dataProvider = "mapGen")
    public void test_getRowCnt(GameBoard myMap, Integer rowCnt, Integer colCnt, Character defaultChar) {
        Assert.assertEquals(myMap.getRowCnt(), rowCnt.intValue());        
    }

    @Test(dataProvider = "mapGen")
    public void test_getColCnt(GameBoard myMap, Integer rowCnt, Integer colCnt, Character defaultChar) {
        Assert.assertEquals(myMap.getColCnt(), colCnt.intValue());        
    }

    @Test(dataProvider = "mapGen")
    public void test_isValidPosition(GameBoard myMap, Integer rowCnt, Integer colCnt, Character defaultChar) {
        // Check negative
        Assert.assertFalse(myMap.isValidPosition(-1, -1));
        Assert.assertFalse(myMap.isValidPosition(-1, 0));
        Assert.assertFalse(myMap.isValidPosition(0, -1));

        // Check just outside
        Assert.assertFalse(myMap.isValidPosition(0, colCnt));
        Assert.assertFalse(myMap.isValidPosition(rowCnt, 0));
        Assert.assertFalse(myMap.isValidPosition(rowCnt, colCnt));    
        
        // Check inside
        for(int row = 0; row < rowCnt; row++) {
            for(int col = 0; col < colCnt; col++) {
                Assert.assertTrue(myMap.isValidPosition(row, col));
            }
        }
    }
    
    @Test(dataProvider = "mapGen")
    public void test_GetAndSetPos(GameBoard myMap, Integer rowCnt, Integer colCnt, Character defaultChar) {
        
        // Check negative
        Assert.assertEquals(myMap.getPos(-1, -1), ' ');
        Assert.assertEquals(myMap.getPos(-1, 0), ' ');
        Assert.assertEquals(myMap.getPos(0, -1), ' ');

        Assert.assertFalse(myMap.setPos(-1, -1, '!'));
        Assert.assertFalse(myMap.setPos(-1, 0, '!'));
        Assert.assertFalse(myMap.setPos(0, -1, '!'));

        // Check just outside
        Assert.assertEquals(myMap.getPos(0, colCnt), ' ');
        Assert.assertEquals(myMap.getPos(rowCnt, 0), ' ');
        Assert.assertEquals(myMap.getPos(rowCnt, colCnt), ' ');

        Assert.assertFalse(myMap.setPos(0, colCnt, '!'));
        Assert.assertFalse(myMap.setPos(rowCnt, 0, '!'));
        Assert.assertFalse(myMap.setPos(rowCnt, colCnt, '!'));

        // Check inside
        int randTrials = 100;
        for(int i = 0; i < randTrials; i++) {
            int row = ((int)(Math.random()*rowCnt));
            int col = ((int)(Math.random()*colCnt));
            char c = ((char)(Math.random()*127));

            Assert.assertTrue(myMap.setPos(row, col, c));
            Assert.assertEquals(myMap.getPos(row, col), c);
        }
    }

    @Test()
    public void test_toString() {
        GameBoard m = new GameBoard(5, 10, 'a');
        Assert.assertEquals(m.toString(), "5 x 10 GameBoard (default: a)");

        m = new GameBoard(7, 8, '@');
        Assert.assertEquals(m.toString(), "7 x 8 GameBoard (default: @)");
    }
        
    @Test()
    public void test_getDisplayString() {
        GameBoard m = new GameBoard(5, 10, 'a');

        m.setPos(0, 1, 'b');
        m.setPos(2, 0, 'c');
        m.setPos(5, 0, 'd');
        m.setPos(4, 8, 'e');

        String s = m.getBoardString();
        String exp =
                "abaaaaaaaa\n" +
                "aaaaaaaaaa\n" +
                "caaaaaaaaa\n" +
                "aaaaaaaaaa\n" +
                "aaaaaaaaea\n";
        Assert.assertEquals(s, exp);
    }

    @Test()
    public void test_clear() {
        GameBoard m = new GameBoard(5, 10, 'a');

        m.setPos(0, 1, 'b');
        m.setPos(2, 0, 'c');
        m.setPos(5, 0, 'd');
        m.setPos(4, 8, 'e');

        String s = m.getBoardString();
        String exp =
                "abaaaaaaaa\n" +
                "aaaaaaaaaa\n" +
                "caaaaaaaaa\n" +
                "aaaaaaaaaa\n" +
                "aaaaaaaaea\n";
        Assert.assertEquals(s, exp);

        m.clear();

        s = m.getBoardString();
        exp =
                "aaaaaaaaaa\n" +
                "aaaaaaaaaa\n" +
                "aaaaaaaaaa\n" +
                "aaaaaaaaaa\n" +
                "aaaaaaaaaa\n";
        Assert.assertEquals(s, exp);
    }
}
