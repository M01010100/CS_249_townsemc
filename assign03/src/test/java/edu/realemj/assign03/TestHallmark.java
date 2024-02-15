package edu.realemj.assign03;

import edu.realemj.testing.GeneralTesting;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class TestHallmark {
    private String [] generateInputs() {
        String [] allInputs = new String[TestGreetingCard.allLines.length];
        int [] allCounts = TestGreetingCard.getLineCounts();
        for(int i = 0; i < allInputs.length; i++) {
             String oneInput = TestGreetingCard.allChars[i] + "\n";
             oneInput += allCounts[i] + "\n";
             oneInput += TestGreetingCard.allLines[i];
            allInputs[i] = oneInput;
        }
        return allInputs;
    }

    private String getCommonPromptOutput() {
        String promptOutput = "Enter boundary character:\n"
                + "Enter number of lines:\n"
                + "Enter lines:\n";
        return promptOutput;
    }

    @Test()
    public void test_generateCard() {

        String [] allInputs = generateInputs();

        String promptOutput = getCommonPromptOutput();
        GeneralTesting.OutPack correctOutput = new GeneralTesting.OutPack(promptOutput, "");

        for(int i = 0; i < allInputs.length; i++) {

            // Start redirect
            GeneralTesting.StreamPack.getInstance().start(allInputs[i]);

            // Create Scanner
            Scanner input = new Scanner(allInputs[i]);

            // Generate header
            GreetingCard header = Hallmark.generateCard(input);

            // Stop redirect
            GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();

            // Compare to correct result
            Assert.assertEquals(programOutput, correctOutput);

            // Compare header content
            Assert.assertEquals(header.toString(), TestGreetingCard.allAnswers[i]);
        }

    }

    @Test()
    public void testMain() {

        String [] allInputs = generateInputs();

        String promptOutput = getCommonPromptOutput();
        promptOutput += "For any occasion:\n";

        GeneralTesting.OutPack [] correctOutputs = new GeneralTesting.OutPack[TestGreetingCard.allAnswers.length];
        for(int i = 0; i < correctOutputs.length; i++) {
            correctOutputs[i] = new GeneralTesting.OutPack(
                    promptOutput + TestGreetingCard.allAnswers[i] + "\n", "");
        }

        for(int i = 0; i < allInputs.length; i++) {

            // Start redirect
            GeneralTesting.StreamPack.getInstance().start(allInputs[i]);

            // Call main
            Hallmark.main(null);

            // Stop redirect
            GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();

            // Compare to correct result
            Assert.assertEquals(programOutput, correctOutputs[i]);

        }
    }
}
