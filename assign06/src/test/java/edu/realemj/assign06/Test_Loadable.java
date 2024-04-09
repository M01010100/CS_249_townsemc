package edu.realemj.assign06;
//NOTE: CHANGE realemj to YOUR SITNETID!!!
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Test_Loadable {
    private class LoadTest implements Loadable {
        public void load(Scanner input) throws GameFileException {
            throw new GameFileException("Test", new ArithmeticException("Math"));
        }
    }

    @Test()
    public void testDrawable() {
        Loadable loadableThing = new LoadTest();
        boolean testOK = false;
        try {
            loadableThing.load(new Scanner("HELP"));
            testOK = false;
        }
        catch(GameFileException e) {
            Assert.assertEquals(e.getMessage(), "Test");
            Assert.assertNotNull(e.getCause());
            Assert.assertEquals(e.getCause().getClass(), ArithmeticException.class);
            Assert.assertEquals(e.getCause().getMessage(), "Math");
            testOK = true;
        }

        Assert.assertTrue(testOK);
    }
}
