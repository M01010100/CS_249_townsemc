package edu.realemj.assign01;
// NOTE: CHANGE realemj to YOUR SITNETID!!!
import edu.realemj.testing.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGreetings {

    @Test()
    public void testMain() {

        String [] allInputs = {
                ""
        };

        GeneralTesting.OutPack [] incorrectOutputs = {
                new GeneralTesting.OutPack(
                        "",
                        ""),
        };

        for(int i = 0; i < allInputs.length; i++) {
            // Start redirect
            GeneralTesting.StreamPack.getInstance().start(allInputs[i]);

            // Call main
            Greetings.main(null);

            // Stop redirect
            GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();

            // In this case, make sure output is NOT empty String or all whitespace            
            programOutput.trimData();
            Assert.assertNotEquals(programOutput, incorrectOutputs[i], "Output cannot be empty String or all whitespace!\n");
        }
    }
}
