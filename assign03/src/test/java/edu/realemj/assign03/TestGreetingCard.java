package edu.realemj.assign03;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGreetingCard {

    public static final String [] allLines = {
            "",

            "\n",

            """
            Happy Birthday!
            """,

            """
            Congratulations
            On Your Achievement!
            """,

            """
            Our Deepest
            Condolences
            At This Time of Grief
            
            
            
            IN HONOUR OF RAGAMUFFIN
            
              
                        
            Ragamuffin was a good dog.
            Not many canines can claim to have as
            illustrious career as dear Ragamuffin.
            
            
            
            From being a WWII flying ace to his successful
            endeavors as a private investigator
            to his unusual but nonetheless impressive days
            as a door-to-door circus tent salesdog,
            Ragamuffin is most fondly remembered
            for his tireless devotion
            to the cause of 
            "Allowing Dogs to Enter Libraries 
            Without Their Respective Owners."
            We honor Ragamuffin at this time, and
            we salute his memory.
            
            
            
            He is survived by 2,189 children 
            and 40,672 grandchildren, all of whom
            will miss him dearly.
            """,

            """
            A Poem
            
            Written in memory
            of dear Ragamuffin.
                        
            There once was a dog named Ragamuffin.
            Whose days were spent seeking a MacGuffin.
            He lost it a lot,
            to further the plot,
            And found that the item was good-for-nothing.          
            """
    };

    public static final char [] allChars = {'.', '.', '*', '$', '#', '@'};

    public static final String [] allAnswers = {
            "",

            """
            ..................................................
            ..................................................
            ..................................................
            ..................................................
            ..................................................
            ..................................................
            ..................................................
            ..................................................
            ..................................................
            """,

            """
            **************************************************
            **************************************************
            **************** Happy Birthday! *****************
            **************************************************
            **************************************************
            **************************************************
            **************************************************
            **************************************************
            **************************************************
            """,

            """
            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            $$$$$$$$$$$$$$$$ Congratulations $$$$$$$$$$$$$$$$$
            $$$$$$$$$$$$$$ On Your Achievement! $$$$$$$$$$$$$$
            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            """,

            """
            ##################################################
            ##################################################
            ################## Our Deepest ###################
            ################## Condolences ###################
            ############# At This Time of Grief ##############
            ##################################################
            ##################################################
            ##################################################
            ##################################################
            
            ##################################################
            ##################################################
            ##################################################
            ############ IN HONOUR OF RAGAMUFFIN #############
            ##################################################
            ##################################################
            ##################################################
            ##################################################
            ##################################################
            
            ##################################################
            ##################################################
            ########### Ragamuffin was a good dog. ###########
            ##### Not many canines can claim to have as ######
            ##### illustrious career as dear Ragamuffin. #####
            ##################################################
            ##################################################
            ##################################################
            ##################################################
            
            ##################################################
            ##################################################
            ##################################################
            # From being a WWII flying ace to his successful #
            ###### endeavors as a private investigator #######
            # to his unusual but nonetheless impressive days #
            #### as a door-to-door circus tent salesdog, #####
            ##################################################
            ##################################################
            
            ##################################################
            ##################################################
            ###### Ragamuffin is most fondly remembered ######
            ########### for his tireless devotion ############
            ################ to the cause of #################
            ####### "Allowing Dogs to Enter Libraries ########
            ####### Without Their Respective Owners." ########
            ##################################################
            ##################################################
            
            ##################################################
            ##################################################
            ##### We honor Ragamuffin at this time, and ######
            ############# we salute his memory. ##############
            ##################################################
            ##################################################
            ##################################################
            ##################################################
            ##################################################
            
            ##################################################
            ##################################################
            ######## He is survived by 2,189 children ########
            ##### and 40,672 grandchildren, all of whom ######
            ############# will miss him dearly. ##############
            ##################################################
            ##################################################
            ##################################################
            ##################################################
            """,

            """
            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            @@@@@@@@@@@@@@@@@@@@@ A Poem @@@@@@@@@@@@@@@@@@@@@
            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            @@@@@@@@@@@@@@@ Written in memory @@@@@@@@@@@@@@@@
            @@@@@@@@@@@@@@ of dear Ragamuffin. @@@@@@@@@@@@@@@
            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            
            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            @@@@@ There once was a dog named Ragamuffin. @@@@@
            @@@ Whose days were spent seeking a MacGuffin. @@@
            @@@@@@@@@@@@@@@ He lost it a lot, @@@@@@@@@@@@@@@@
            @@@@@@@@@@@@@@ to further the plot, @@@@@@@@@@@@@@
            @ And found that the item was good-for-nothing. @@
            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            """
    };

    public GreetingCard[] createSamples() {
        GreetingCard[] samples = new GreetingCard[allLines.length];
        samples[0] = new GreetingCard(new String[]{}, allChars[0]);
        samples[1] = new GreetingCard(new String[]{""}, allChars[1]);
        for(int i = 2; i < allLines.length; i++) {
            samples[i] = new GreetingCard(allLines[i].split("\n"), allChars[i]);
        }
        return samples;
    }

    public static int [] getLineCounts() {
        int [] allCounts = new int[allLines.length];
        allCounts[0] = 0;
        allCounts[1] = 1;
        for(int i = 2; i < allLines.length; i++) {
            allCounts[i] = allLines[i].split("\n").length;
        }
        return allCounts;
    }

    @Test()
    public void test_getLines() {
        GreetingCard[] samples = createSamples();
        for(int i = 0; i < samples.length; i++) {
            Assert.assertEquals(samples[i].getLines(), allLines[i] + "");
        }

        // Verify we aren't just copying the reference
        String fullExampleLine = "We do\n...stuff...\n";
        String [] exampleLine = fullExampleLine.split("\n");

        GreetingCard example = new GreetingCard(exampleLine, '$');
        Assert.assertEquals(example.getLines(), fullExampleLine);
        exampleLine[0] = "We really do";
        Assert.assertEquals(example.getLines(), fullExampleLine, "Do NOT just copy references!");
    }

    @Test()
    public void test_getBoundaryChar() {
        GreetingCard[] samples = createSamples();
        for(int i = 0; i < samples.length; i++) {
            Assert.assertEquals(samples[i].getBoundaryChar(), allChars[i]);
        }
    }

    @Test()
    public void test_setLines() {
        GreetingCard[] samples = createSamples();
        String newLine = "Do you know\nthe Muffin Man????\n";
        String [] lineArray = newLine.split("\n");
        samples[0].setLines(lineArray);
        Assert.assertEquals(samples[0].getLines(), newLine);

        // Changing the array to make sure a copy was made internally
        lineArray[0] = "Dost thou know";
        Assert.assertEquals(samples[0].getLines(), newLine, "Do NOT just copy references!");
    }

    @Test()
    public void test_setBoundaryChar() {
        GreetingCard[] samples = createSamples();
        char newChar = '&';
        samples[0].setBoundaryChar(newChar);
        Assert.assertEquals(samples[0].getBoundaryChar(), newChar);
    }

    @Test()
    public void test_generateBoundaryLine() {
        GreetingCard example = new GreetingCard(new String[]{""}, '*');
        Assert.assertEquals(
                example.generateBoundaryLine(),
                "**************************************************\n");

        example.setBoundaryChar('$');
        Assert.assertEquals(
                example.generateBoundaryLine(),
                "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
    }

    @Test()
    public void test_generateCenteredLine() {
        GreetingCard example = new GreetingCard(new String[]{""}, '*');
        Assert.assertEquals(
                example.generateCenteredLine(""),
                "**************************************************\n");

        Assert.assertEquals(
                example.generateCenteredLine("a"),
                "*********************** a ************************\n");

        Assert.assertEquals(
                example.generateCenteredLine("ab"),
                "*********************** ab ***********************\n");

        Assert.assertEquals(
                example.generateCenteredLine("0123456789012345678901234567890123456789012345"),
                "* 0123456789012345678901234567890123456789012345 *\n");

        Assert.assertEquals(
                example.generateCenteredLine("012345678901234567890123456789012345678901234"),
                "* 012345678901234567890123456789012345678901234 **\n");

        example.setBoundaryChar('$');
        Assert.assertEquals(
                example.generateCenteredLine("ab"),
                "$$$$$$$$$$$$$$$$$$$$$$$ ab $$$$$$$$$$$$$$$$$$$$$$$\n");
    }

    @Test()
    public void test_toString() {
        GreetingCard[] samples = createSamples();

        // Testing based strictly on constructor
        for(int i = 0; i < samples.length; i++) {
            Assert.assertEquals(samples[i].toString(), allAnswers[i]);
        }

        // Change one of them and try again
        String newLines = "Do you know\nthe Muffin Man????\n";
        samples[0].setLines(newLines.split("\n"));
        char newChar = '&';
        samples[0].setBoundaryChar(newChar);

        Assert.assertEquals(samples[0].toString(),
                """
                        &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
                        &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
                        &&&&&&&&&&&&&&&&&& Do you know &&&&&&&&&&&&&&&&&&&
                        &&&&&&&&&&&&&&& the Muffin Man???? &&&&&&&&&&&&&&&
                        &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
                        &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
                        &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
                        &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
                        &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
                        """);
    }
}
