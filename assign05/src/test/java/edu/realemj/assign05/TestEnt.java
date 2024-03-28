package edu.realemj.assign05;
// NOTE: CHANGE realemj to YOUR SITNETID!!!

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEnt {
    @Test()
    public void test_inheritance() {
        Ent bob = new Ent("Bob");
        Assert.assertTrue(bob instanceof Giant);
        Assert.assertTrue(bob instanceof Tree);
    }

    @Test()
    public void test_getName() {
        Giant bob = new Ent("Bob");
        Giant job = new Ent("Joe Chill");
        Giant bruce = new Ent("Bruce Wayne");

        Assert.assertEquals(bob.getName(), "Bob");
        Assert.assertEquals(job.getName(), "Joe Chill");
        Assert.assertEquals(bruce.getName(), "Bruce Wayne");
    }

    @Test()
    public void test_setName() {
        Giant bob = new Ent("Bob");
        Giant job = new Ent("Joe Chill");
        Giant bruce = new Ent("Bruce Wayne");

        bob.setName("BOBERT");
        job.setName("Joseph Chillingworth");
        bruce.setName("Batman");

        Assert.assertEquals(bob.getName(), "BOBERT");
        Assert.assertEquals(job.getName(), "Joseph Chillingworth");
        Assert.assertEquals(bruce.getName(), "Batman");
    }

    @Test()
    public void test_toString() {
        Giant bob = new Ent("Bob");
        Giant job = new Ent("Joe Chill");
        Giant bruce = new Ent("Bruce Wayne");

        Assert.assertEquals(bob.toString(), "Ent Bob of the trees");
        Assert.assertEquals(job.toString(), "Ent Joe Chill of the trees");
        Assert.assertEquals(bruce.toString(), "Ent Bruce Wayne of the trees");

        bob.setName("BOBERT");
        job.setName("Joseph Chillingworth");
        bruce.setName("Batman");

        Assert.assertEquals(bob.toString(), "Ent BOBERT of the trees");
        Assert.assertEquals(job.toString(), "Ent Joseph Chillingworth of the trees");
        Assert.assertEquals(bruce.toString(), "Ent Batman of the trees");
    }

    @Test()
    public void test_speak() {
        Tree bob = new Ent("Bob");
        Assert.assertEquals(bob.speak(), "HOOM");

    }
}

