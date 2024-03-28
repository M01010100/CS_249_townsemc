package edu.realemj.assign05;
// NOTE: CHANGE realemj to YOUR SITNETID!!!

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTroll {

    @Test()
    public void test_inheritance() {
        Troll bob = new Troll("Bob");
        Assert.assertTrue(bob instanceof Giant);
    }

    @Test()
    public void test_getName() {
        Giant bob = new Troll("Bob");
        Giant job = new Troll("Joe Chill");
        Giant bruce = new Troll("Bruce Wayne");

        Assert.assertEquals(bob.getName(), "Bob");
        Assert.assertEquals(job.getName(), "Joe Chill");
        Assert.assertEquals(bruce.getName(), "Bruce Wayne");
    }

    @Test()
    public void test_setName() {
        Giant bob = new Troll("Bob");
        Giant job = new Troll("Joe Chill");
        Giant bruce = new Troll("Bruce Wayne");

        bob.setName("BOBERT");
        job.setName("Joseph Chillingworth");
        bruce.setName("Batman");

        Assert.assertEquals(bob.getName(), "BOBERT");
        Assert.assertEquals(job.getName(), "Joseph Chillingworth");
        Assert.assertEquals(bruce.getName(), "Batman");
    }

    @Test()
    public void test_toString() {
        Giant bob = new Troll("Bob");
        Giant job = new Troll("Joe Chill");
        Giant bruce = new Troll("Bruce Wayne");

        Assert.assertEquals(bob.toString(), "Troll Bob");
        Assert.assertEquals(job.toString(), "Troll Joe Chill");
        Assert.assertEquals(bruce.toString(), "Troll Bruce Wayne");

        bob.setName("BOBERT");
        job.setName("Joseph Chillingworth");
        bruce.setName("Batman");

        Assert.assertEquals(bob.toString(), "Troll BOBERT");
        Assert.assertEquals(job.toString(), "Troll Joseph Chillingworth");
        Assert.assertEquals(bruce.toString(), "Troll Batman");
    }

    @Test()
    public void test_cook() {
        Troll bob = new Troll("Bob");
        Assert.assertEquals(bob.cook(), "Mutton again...");

    }
}

