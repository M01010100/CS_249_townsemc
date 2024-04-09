package edu.realemj.assign06;
//NOTE: CHANGE realemj to YOUR SITNETID!!!
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_GameFileException {
    @Test()
    public void test_Constructor() {
        // Create another Exception
        Exception e = new ArithmeticException("Banana!");

        // Create a SpriteFileException
        Exception se = new GameFileException("Potato?", e);

        // Check the message
        Assert.assertEquals(se.getMessage(), "Potato?");

        // Check the chained exception
        Assert.assertEquals(se.getCause(), e);

        // Create a GameFileException
        Exception anotherE = new GameFileException("Roll out the barrel...");

        // Check the message
        Assert.assertEquals(anotherE.getMessage(), "Roll out the barrel...");

        // Check the chained exception
        Assert.assertNull(anotherE.getCause());
    }
}
