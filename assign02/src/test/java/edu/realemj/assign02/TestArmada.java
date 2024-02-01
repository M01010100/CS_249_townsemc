package edu.realemj.assign02;
// NOTE: CHANGE realemj to YOUR SITNETID!!!
import edu.realemj.testing.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestArmada {

    private void compareEachLine(String actual, String expected, String typeData) {
        // Split each string
        String [] actualList = actual.split("\n");
        String [] expectedList = expected.split("\n");

        for(int i = 0; i < expectedList.length; i++) {
            String a = "";
            if(i < actualList.length) {
                a = actualList[i];
            }
            String e = expectedList[i];
            a = a.trim();
            e = e.trim();
            Assert.assertEquals(a, e, typeData + " Line " + i + ": output not the same!\n");
        }            
    }

    @Test()
    public void testMain() {

        String [] allInputs = {
            """
            Millenium Falcon
            113 220462
            """,

            """
            USS Enterprise (NCC-1701)
                  947 220462000
            """,

            """
            Puddle Jumper
                     42              44092
            """                
        };

        GeneralTesting.OutPack [] correctOutputs = {
            new GeneralTesting.OutPack(
                    """
                    Enter vessel name:
                    Enter length and weight:                   
                    NAME: Millenium Falcon
                    LENGTH: 113 ft. (34.44 m)
                    WEIGHT: 220462 lbs. (100001.56 kg)
                    """,
                    ""),
            new GeneralTesting.OutPack(
                    """
                    Enter vessel name:
                    Enter length and weight:                    
                    NAME: USS Enterprise (NCC-1701)
                    LENGTH: 947 ft. (288.65 m)
                    WEIGHT: 220462000 lbs. (100001563.20 kg)
                    """, 
                    ""),
            new GeneralTesting.OutPack(
                    """
                    Enter vessel name:
                    Enter length and weight:
                    NAME: Puddle Jumper
                    LENGTH: 42 ft. (12.80 m)
                    WEIGHT: 44092 lbs. (20000.13 kg)
                    """, 
                    ""),
        };

        for(int i = 0; i < allInputs.length; i++) {
            // Start redirect
            GeneralTesting.StreamPack.getInstance().start(allInputs[i]);

            // Call main
            Armada.main(null);

            // Stop redirect
            GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();

            // Compare to correct result            
            try {
                compareEachLine(programOutput.getStdOut(), correctOutputs[i].getStdOut(), "STDOUT");
                compareEachLine(programOutput.getStdErr(), correctOutputs[i].getStdErr(), "STDERR");
            }
            catch(Error e) {
                // OK, specific error
                e.printStackTrace();                
                // So give us the full view as well
                try {                    
                    Assert.assertEquals(programOutput, correctOutputs[i]);
                }
                catch(Error f) {
                    System.err.println("FULL OUTPUT:");
                    f.printStackTrace();
                    throw f;
                }
            }

        }
    }
}

