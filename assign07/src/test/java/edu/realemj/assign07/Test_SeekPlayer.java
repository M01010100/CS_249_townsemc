package edu.realemj.assign07;

import edu.realemj.assign06.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Test_SeekPlayer {
    // Check it implements MoveAlgorithm
    @Test()
    public void testImplementsInterface() {
        MoveAlgorithm mv = new SeekPlayer();
    }

    // Check it correctly seeks player position

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
    public void testSeeking(Integer row, Integer col, Integer rowOff, Integer colOff) {
        Player p = new Player(row,col);
        Creature c = new Rat(row+rowOff,col+colOff);
        MoveAlgorithm mv = new SeekPlayer();
        mv.move(c, p);

        int rowInc = 0;
        if(rowOff > 0) rowInc = -1;
        else if(rowOff < 0) rowInc = 1;

        int colInc = 0;
        if(colOff > 0) colInc = -1;
        else if(colOff < 0) colInc = 1;

        if(Math.abs(rowOff) > Math.abs(colOff)) {
            colInc = 0;
        }
        else {
            rowInc = 0;
        }

        Assert.assertEquals(c.getRow(), row+rowOff+rowInc);
        Assert.assertEquals(c.getCol(), col+colOff+colInc);
    }

}
