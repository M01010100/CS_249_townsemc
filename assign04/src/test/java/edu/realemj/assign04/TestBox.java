package edu.realemj.assign04;
import org.testng.Assert;
import org.testng.annotations.*;
public class TestBox {
    private final Box [] allBoxes = {
            // In-bounds, filled
            new Box(0, 0, 3, 5, true, '*'),
            new Box(2, 1, 4, 9, true, '@'),
            new Box(1, 3, 3, 7, true, '$'),
            new Box(3, 2, 3, 8, true, '%'),
            new Box(1, 6, 4, 6, true, '^'),

            // In-bounds, empty
            new Box(0, 0, 3, 5, false, '!'),
            new Box(2, 1, 4, 9, false, '#'),
            new Box(1, 3, 3, 7, false, '&'),
            new Box(3, 2, 3, 8, false, '-'),
            new Box(1, 6, 4, 6, false, '+'),

            // Out-of-bounds, empty
            new Box(-2, -1, 3, 5, false, 'a'),
            new Box(2, 1, 6, 11, false, 'b'),
            new Box(-2, -1, 5, 10, false, 'c'),
            new Box(-3, -2, -1, -1, false, 'd'),
            new Box(5, 10, 7, 12, false, 'e'),
    };

    private final String [] allToStringOutputs = {
            "Filled Box from (0,0) to (3,5) with char '*'",
            "Filled Box from (2,1) to (4,9) with char '@'",
            "Filled Box from (1,3) to (3,7) with char '$'",
            "Filled Box from (3,2) to (3,8) with char '%'",
            "Filled Box from (1,6) to (4,6) with char '^'",

            "Box from (0,0) to (3,5) with char '!'",
            "Box from (2,1) to (4,9) with char '#'",
            "Box from (1,3) to (3,7) with char '&'",
            "Box from (3,2) to (3,8) with char '-'",
            "Box from (1,6) to (4,6) with char '+'",

            "Box from (-2,-1) to (3,5) with char 'a'",
            "Box from (2,1) to (6,11) with char 'b'",
            "Box from (-2,-1) to (5,10) with char 'c'",
            "Box from (-3,-2) to (-1,-1) with char 'd'",
            "Box from (5,10) to (7,12) with char 'e'",
    };

    private final String [] allSingleMapOutputs = {
            """
            ******....
            ******....
            ******....
            ******....
            ..........
            """,

            """
            ..........
            ..........
            .@@@@@@@@@
            .@@@@@@@@@
            .@@@@@@@@@
            """,

            """
            ..........
            ...$$$$$..
            ...$$$$$..
            ...$$$$$..
            ..........
            """,

            """
            ..........
            ..........
            ..........
            ..%%%%%%%.
            ..........
            """,

            """
            ..........
            ......^...
            ......^...
            ......^...
            ......^...
            """,

            """
            !!!!!!....
            !....!....
            !....!....
            !!!!!!....
            ..........
            """,

            """
           ..........
           ..........
           .#########
           .#.......#
           .#########
           """,

            """
            ..........
            ...&&&&&..
            ...&...&..
            ...&&&&&..
            ..........
            """,

            """
            ..........
            ..........
            ..........
            ..-------.
            ..........
            """,

            """
            ..........
            ......+...
            ......+...
            ......+...
            ......+...
            """,

            """
            .....a....
            .....a....
            .....a....
            aaaaaa....
            ..........
            """,

            """
            ..........
            ..........
            .bbbbbbbbb
            .b........
            .b........
            """,

            """
            ..........
            ..........
            ..........
            ..........
            ..........
            """,

            """
            ..........
            ..........
            ..........
            ..........
            ..........
            """,

            """
            ..........
            ..........
            ..........
            ..........
            ..........
            """
    };

    private final String [] allComboMapOutputs = {
            """
            ******....
            ******....
            ******....
            ******....
            ..........
            """,

            """
            ******....
            ******....
            *@@@@@@@@@
            *@@@@@@@@@
            .@@@@@@@@@
            """,

            """
            ******....
            ***$$$$$..
            *@@$$$$$@@
            *@@$$$$$@@
            .@@@@@@@@@
            """,

            """
            ******....
            ***$$$$$..
            *@@$$$$$@@
            *@%%%%%%%@
            .@@@@@@@@@
            """,

            """
            ******....
            ***$$$^$..
            *@@$$$^$@@
            *@%%%%^%%@
            .@@@@@^@@@
            """,

            """
            !!!!!!....
            !**$$!^$..
            !@@$$!^$@@
            !!!!!!^%%@
            .@@@@@^@@@
            """,

            """
            !!!!!!....
            !**$$!^$..
            !#########
            !#!!!!^%%#
            .#########
            """,

            """
            !!!!!!....
            !**&&&&&..
            !##&###&##
            !#!&&&&&%#
            .#########
            """,

            """
            !!!!!!....
            !**&&&&&..
            !##&###&##
            !#-------#
            .#########
            """,

            """
            !!!!!!....
            !**&&&+&..
            !##&##+&##
            !#----+--#
            .#####+###
            """,

            """
            !!!!!a....
            !**&&a+&..
            !##&#a+&##
            aaaaaa+--#
            .#####+###
            """,

            """
            !!!!!a....
            !**&&a+&..
            !bbbbbbbbb
            abaaaa+--#
            .b####+###
            """,

            """
            !!!!!a....
            !**&&a+&..
            !bbbbbbbbb
            abaaaa+--#
            .b####+###
            """,

            """
            !!!!!a....
            !**&&a+&..
            !bbbbbbbbb
            abaaaa+--#
            .b####+###
            """,

            """
            !!!!!a....
            !**&&a+&..
            !bbbbbbbbb
            abaaaa+--#
            .b####+###
            """
    };

    @DataProvider(name="boxGen")
    public Object[][] boxGen() {
        Object [][] testValues = new Object[allBoxes.length][2];
        for(int i = 0; i < testValues.length; i++) {
            testValues[i][0] = allBoxes[i];
            testValues[i][1] = i;
        }
        return testValues;
    }



    @Test(dataProvider = "boxGen")
    public void test_toString(Box b, Integer index) {
        // Check answer
        Assert.assertEquals(b.toString(), allToStringOutputs[index]);
    }

    @Test(dataProvider = "boxGen")
    public void test_draw_one(Box b, Integer index) {
        // Create map
        GameBoard singleMap = new GameBoard(5, 10, '.');
        // Get desired output for a SINGLE draw
        String desiredSingle = allSingleMapOutputs[index];
        // Draw on map
        b.draw(singleMap);
        // Compare results
        Assert.assertEquals(singleMap.getBoardString(), desiredSingle);
    }

    @Test()
    public void test_draw_combo() {
        // Create map
        GameBoard comboMap = new GameBoard(5, 10, '.');
        // Loop through each box
        for(int i = 0; i < allBoxes.length; i++) {
            // Get the box
            Box b = allBoxes[i];
            // Get desired output at this point
            String desiredOutput = allComboMapOutputs[i];
            // Draw on map
            b.draw(comboMap);
            // Get output at this point
            Assert.assertEquals(comboMap.getBoardString(), desiredOutput, "Up to Box at index " + i + ":");
        }
    }
}
