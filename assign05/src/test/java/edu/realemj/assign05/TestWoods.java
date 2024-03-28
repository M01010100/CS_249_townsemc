package edu.realemj.assign05;
// NOTE: CHANGE realemj to YOUR SITNETID!!!

import edu.realemj.testing.GeneralTesting;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWoods {

    private void testOneGiant(Woods f, String name, String typeName, Giant other) {
        Giant p = f.createGiant(name, typeName);
        Assert.assertEquals(p.getName(), name);
        Assert.assertEquals(p.getClass(), other.getClass());
    }

    private void testGetOneGiant(Woods f, int index, Giant other) {
        Giant p = f.getGiant(index);
        Assert.assertEquals(p.getName(), other.getName());
        Assert.assertEquals(p.getClass(), other.getClass());
    }

    @Test()
    public void test_createGiant() {
        Woods f = new Woods();

        testOneGiant(f, "Treebeard", "ENT", new Ent(""));
        testOneGiant(f, "Grunkle", "TROLL", new Troll(""));
        testOneGiant(f, "Fred", "GIANT", new Giant(""));

        testOneGiant(f, "Quickbeam", "ENT", new Ent(""));
        testOneGiant(f, "Hal", "TREE", new Tree(""));
        testOneGiant(f, "Ned", "TROLL", new Troll(""));

        testOneGiant(f, "Detritus", "TROLL", new Troll(""));
        testOneGiant(f, "Beardy", "GIANT", new Giant(""));
        testOneGiant(f, "Moodyleaf", "HUORN", new Huorn(""));

        Giant p;
        p = f.createGiant("", "ENT");
        Assert.assertNull(p);

        p = f.createGiant("Gandalf", "MAIAR");
        Assert.assertNull(p);
    }

    @Test()
    public void test_addAndGetGiant() {
        Woods f = new Woods();

        // Should NOT add giant just because create is called
        f.createGiant("Treebeard", "ENT");
        Assert.assertNull(f.getGiant(0));

        // Add some GIANTs
        Assert.assertTrue(f.addGiant("Happyleaf", "ENT"));
        f.addGiant("Gargle", "TROLL");
        f.addGiant("Tod", "GIANT");
        f.addGiant("Birchbrain", "ENT");
        f.addGiant("Harold", "TREE");
        f.addGiant("Golgas", "TROLL");
        f.addGiant("Nigel Stone", "TROLL");
        f.addGiant("Grumble", "GIANT");
        f.addGiant("Grimdark", "HUORN");

        // Try to get them back
        testGetOneGiant(f, 0, new Ent("Happyleaf"));
        testGetOneGiant(f, 1, new Troll("Gargle"));
        testGetOneGiant(f, 2, new Giant("Tod"));
        testGetOneGiant(f, 3, new Ent("Birchbrain"));
        testGetOneGiant(f, 4, new Tree("Harold"));
        testGetOneGiant(f, 5, new Troll("Golgas"));
        testGetOneGiant(f, 6, new Troll("Nigel Stone"));
        testGetOneGiant(f, 7, new Giant("Grumble"));
        testGetOneGiant(f, 8, new Huorn("Grimdark"));

        // Check for out of bounds in general
        Assert.assertNull(f.getGiant(-1));
        Assert.assertNull(f.getGiant(9));

        // Try to add bad examples
        Assert.assertFalse(f.addGiant("", "ENT"));
        Assert.assertFalse(f.addGiant("Gandalf", "MAIAR"));

    }


    @Test()
    public void test_printAllGiants() {
        Woods f = new Woods();

        f.addGiant("Treebeard", "ENT");
        f.addGiant("Gargle", "TROLL");
        f.addGiant("Tod", "GIANT");
        f.addGiant("Birchbrain", "ENT");
        f.addGiant("Harold", "TREE");
        f.addGiant("Golgas", "TROLL");
        f.addGiant("Nigel Stone", "TROLL");
        f.addGiant("Grumble", "GIANT");
        f.addGiant("Grimdark", "HUORN");

        // Start and end redirect
        GeneralTesting.StreamPack.getInstance().start("");
        f.printAllGiants();
        GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();

        // Compare to correct result
        Assert.assertEquals(programOutput,
                new GeneralTesting.OutPack(
                        "ALL GIANTS:\n" +
                                "- Ent Treebeard of the trees\n" +
                                "- Troll Gargle\n" +
                                "- Tod\n" +
                                "- Ent Birchbrain of the trees\n" +
                                "- Harold of the trees\n" +
                                "- Troll Golgas\n" +
                                "- Troll Nigel Stone\n" +
                                "- Grumble\n" +
                                "- Huorn Grimdark of the trees\n",
                        ""));

    }

    @Test()
    public void test_printAllTrees() {
        Woods f = new Woods();

        f.addGiant("Treebeard", "ENT");
        f.addGiant("Gargle", "TROLL");
        f.addGiant("Tod", "GIANT");
        f.addGiant("Birchbrain", "ENT");
        f.addGiant("Harold", "TREE");
        f.addGiant("Golgas", "TROLL");
        f.addGiant("Nigel Stone", "TROLL");
        f.addGiant("Grumble", "GIANT");
        f.addGiant("Grimdark", "HUORN");

        // Start and end redirect
        GeneralTesting.StreamPack.getInstance().start("");
        f.printAllTrees();
        GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();

        // Compare to correct result
        Assert.assertEquals(programOutput,
                new GeneralTesting.OutPack(
                        "ALL TREES:\n" +
                                "- Ent Treebeard of the trees: HOOM\n" +
                                "- Ent Birchbrain of the trees: HOOM\n" +
                                "- Harold of the trees: <rustling>\n" +
                                "- Huorn Grimdark of the trees: <angry rustling>\n",
                        ""));
    }

    @Test()
    public void test_printAllTrolls() {
        Woods f = new Woods();

        f.addGiant("Treebeard", "ENT");
        f.addGiant("Gargle", "TROLL");
        f.addGiant("Tod", "GIANT");
        f.addGiant("Birchbrain", "ENT");
        f.addGiant("Harold", "TREE");
        f.addGiant("Golgas", "TROLL");
        f.addGiant("Nigel Stone", "TROLL");
        f.addGiant("Grumble", "GIANT");
        f.addGiant("Grimdark", "HUORN");

        // Start and end redirect
        GeneralTesting.StreamPack.getInstance().start("");
        f.printAllTrolls();
        GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();

        // Compare to correct result
        Assert.assertEquals(programOutput,
                new GeneralTesting.OutPack(
                        "ALL TROLLS:\n" +
                                "- Troll Gargle: Mutton again...\n" +
                                "- Troll Golgas: Mutton again...\n" +
                                "- Troll Nigel Stone: Mutton again...\n",
                        ""));
    }
}

