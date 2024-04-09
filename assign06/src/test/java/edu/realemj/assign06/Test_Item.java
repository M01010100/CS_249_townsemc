package edu.realemj.assign06;
//NOTE: CHANGE realemj to YOUR SITNETID!!!
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Test_Item {

    @Test()
    public void testConstructorAndData() {
        // No-arg
        Item item = new Item();
        Assert.assertEquals(item.getID(), "");
        Assert.assertEquals(item.getValue(), 0);

        // Arg constructor
        item = new Item("BARNACLES", 1560);
        Assert.assertEquals(item.getID(), "BARNACLES");
        Assert.assertEquals(item.getValue(), 1560);
    }

    @Test()
    public void testGetSetID() {
        Item item1 = new Item("BOB", 197);
        Item item2 = new Item("JOE", 903);
        Assert.assertEquals(item1.getID(), "BOB");
        Assert.assertEquals(item2.getID(), "JOE");

        item1.setID("FRANK");
        item2.setID("WILLIAM");
        Assert.assertEquals(item1.getID(), "FRANK");
        Assert.assertEquals(item2.getID(), "WILLIAM");
    }

    @Test()
    public void testGetSetValue() {
        Item item1 = new Item("TEST", 197);
        Item item2 = new Item("TEST", 903);
        Assert.assertEquals(item1.getValue(), 197);
        Assert.assertEquals(item2.getValue(), 903);

        item1.setValue(345);
        item2.setValue(724);
        Assert.assertEquals(item1.getValue(), 345);
        Assert.assertEquals(item2.getValue(), 724);
    }

    @Test()
    public void testToString() {
        Item item1 = new Item("FORK", 197);
        Item item2 = new Item("SPOON", 903);

        Assert.assertEquals(item1.toString(), "FORK with value 197");
        Assert.assertEquals(item2.toString(), "SPOON with value 903");

        item1.setID("FRANK");
        item2.setID("WILLIAM");
        item1.setValue(345);
        item2.setValue(724);

        Assert.assertEquals(item1.toString(), "FRANK with value 345");
        Assert.assertEquals(item2.toString(), "WILLIAM with value 724");
    }

    @Test()
    public void testImplementsLoadable() {
        Item thing = new Item();
        Assert.assertTrue(thing instanceof Loadable);
    }

    @Test()
    public void testLoad() {
        // Good load
        Scanner input = new Scanner("CHRISTMAS_TREE 97");
        Item thing = new Item();
        boolean allGood = true;
        try {
            thing.load(input);
        }
        catch(Exception e) {
            allGood = false;
        }

        Assert.assertTrue(allGood, "Should NOT throw exception!");

        Assert.assertEquals(thing.getID(), "CHRISTMAS_TREE");
        Assert.assertEquals(thing.getValue(), 97);

        // Bad load
        input = new Scanner("CHRISTMAS_TREE");
        allGood = true;
        try {
            thing.load(input);
        }
        catch(Exception e) {
            allGood = false;
            Assert.assertTrue(e instanceof GameFileException);
            Assert.assertEquals(e.getMessage(), "Error loading Item");
            Assert.assertNotNull(e.getCause());

            Assert.assertEquals(thing.getID(), "");
            Assert.assertEquals(thing.getValue(), 0);
        }

        Assert.assertFalse(allGood, "SHOULD throw exception!");

        // Another bad load
        thing.setID("BARNACLES");
        thing.setValue(567);
        input = new Scanner("CHRISTMAS_TREE LOTS");
        allGood = true;
        try {
            thing.load(input);
        }
        catch(Exception e) {
            allGood = false;
            Assert.assertTrue(e instanceof GameFileException);
            Assert.assertEquals(e.getMessage(), "Error loading Item");
            Assert.assertNotNull(e.getCause());

            Assert.assertEquals(thing.getID(), "");
            Assert.assertEquals(thing.getValue(), 0);
        }

        Assert.assertFalse(allGood, "SHOULD throw exception!");
    }
}
