package edu.realemj.assign05;

import edu.realemj.testing.GeneralTesting;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSilmarillion {

    @Test()
    public void test_main() {

        String [] allInputs = {
                "Bob\n" +
                        "Ent\n" +
                        "Rowboat Gilligan\n" +
                        "Tree\n" +
                        "Gork Mork\n" +
                        "Troll\n" +
                        "Ned\n" +
                        "Giant\n" +
                        "Sneezle\n" +
                        "Troll\n" +
                        "DirkDark Darkwood\n" +
                        "Huorn\n" +
                        "\n\n",

                "Bob\n" +
                        "Ent\n" +
                        "Rowboat Gilligan\n" +
                        "Tree\n" +
                        "Gork Mork\n" +
                        "Troll\n" +
                        "Ned\n" +
                        "Giant\n" +
                        "Sneezle\n" +
                        "Troll\n" +
                        "DirkDark Darkwood\n" +
                        "Huorn\n" +
                        "Goofy\n" +
                        "Dog\n"
        };

        GeneralTesting.OutPack [] correctOutputs = {
                new GeneralTesting.OutPack(
                        "**********\n" +
                                "Enter name:\n" +
                                "Enter type:\n" +
                                "**********\n" +
                                "**********\n" +
                                "Enter name:\n" +
                                "Enter type:\n" +
                                "**********\n" +
                                "**********\n" +
                                "Enter name:\n" +
                                "Enter type:\n" +
                                "**********\n" +
                                "**********\n" +
                                "Enter name:\n" +
                                "Enter type:\n" +
                                "**********\n" +
                                "**********\n" +
                                "Enter name:\n" +
                                "Enter type:\n" +
                                "**********\n" +
                                "**********\n" +
                                "Enter name:\n" +
                                "Enter type:\n" +
                                "**********\n" +
                                "**********\n" +
                                "Enter name:\n" +
                                "Enter type:\n" +
                                "**********\n" +
                                "ALL GIANTS:\n" +
                                "- Ent Bob of the trees\n" +
                                "- Rowboat Gilligan of the trees\n" +
                                "- Troll Gork Mork\n" +
                                "- Ned\n" +
                                "- Troll Sneezle\n" +
                                "- Huorn DirkDark Darkwood of the trees\n" +
                                "ALL TREES:\n" +
                                "- Ent Bob of the trees: HOOM\n" +
                                "- Rowboat Gilligan of the trees: <rustling>\n" +
                                "- Huorn DirkDark Darkwood of the trees: <angry rustling>\n" +
                                "ALL TROLLS:\n" +
                                "- Troll Gork Mork: Mutton again...\n" +
                                "- Troll Sneezle: Mutton again...\n",
                        ""),
                new GeneralTesting.OutPack(
                        "**********\n" +
                                "Enter name:\n" +
                                "Enter type:\n" +
                                "**********\n" +
                                "**********\n" +
                                "Enter name:\n" +
                                "Enter type:\n" +
                                "**********\n" +
                                "**********\n" +
                                "Enter name:\n" +
                                "Enter type:\n" +
                                "**********\n" +
                                "**********\n" +
                                "Enter name:\n" +
                                "Enter type:\n" +
                                "**********\n" +
                                "**********\n" +
                                "Enter name:\n" +
                                "Enter type:\n" +
                                "**********\n" +
                                "**********\n" +
                                "Enter name:\n" +
                                "Enter type:\n" +
                                "**********\n" +
                                "**********\n" +
                                "Enter name:\n" +
                                "Enter type:\n" +
                                "**********\n" +
                                "ALL GIANTS:\n" +
                                "- Ent Bob of the trees\n" +
                                "- Rowboat Gilligan of the trees\n" +
                                "- Troll Gork Mork\n" +
                                "- Ned\n" +
                                "- Troll Sneezle\n" +
                                "- Huorn DirkDark Darkwood of the trees\n" +
                                "ALL TREES:\n" +
                                "- Ent Bob of the trees: HOOM\n" +
                                "- Rowboat Gilligan of the trees: <rustling>\n" +
                                "- Huorn DirkDark Darkwood of the trees: <angry rustling>\n" +
                                "ALL TROLLS:\n" +
                                "- Troll Gork Mork: Mutton again...\n" +
                                "- Troll Sneezle: Mutton again...\n",
                        "")

        };

        for(int i = 0; i < allInputs.length; i++) {
            // Start redirect
            GeneralTesting.StreamPack.getInstance().start(allInputs[i]);

            // Call main
            Silmarillion.main(null);

            // Stop redirect
            GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();

            // Compare to correct result
            Assert.assertEquals(programOutput, correctOutputs[i]);
        }
    }
}
