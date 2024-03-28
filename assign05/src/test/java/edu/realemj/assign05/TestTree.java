package edu.realemj.assign05;
// NOTE: CHANGE realemj to YOUR SITNETID!!!

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTree {

    @Test()
    public void test_inheritance() {
        Tree bob = new Tree("Bob");
        Assert.assertTrue(bob instanceof Giant);
    }

    @Test()
    public void test_getName() {
        Giant bob = new Tree("Bob");
        Giant job = new Tree("Joe Chill");
        Giant bruce = new Tree("Bruce Wayne");

        Assert.assertEquals(bob.getName(), "Bob");
        Assert.assertEquals(job.getName(), "Joe Chill");
        Assert.assertEquals(bruce.getName(), "Bruce Wayne");
    }

    @Test()
    public void test_setName() {
        Giant bob = new Tree("Bob");
        Giant job = new Tree("Joe Chill");
        Giant bruce = new Tree("Bruce Wayne");

        bob.setName("BOBERT");
        job.setName("Joseph Chillingworth");
        bruce.setName("Batman");

        Assert.assertEquals(bob.getName(), "BOBERT");
        Assert.assertEquals(job.getName(), "Joseph Chillingworth");
        Assert.assertEquals(bruce.getName(), "Batman");
    }

    @Test()
    public void test_toString() {
        Giant bob = new Tree("Bob");
        Giant job = new Tree("Joe Chill");
        Giant bruce = new Tree("Bruce Wayne");

        Assert.assertEquals(bob.toString(), "Bob of the trees");
        Assert.assertEquals(job.toString(), "Joe Chill of the trees");
        Assert.assertEquals(bruce.toString(), "Bruce Wayne of the trees");

        bob.setName("BOBERT");
        job.setName("Joseph Chillingworth");
        bruce.setName("Batman");

        Assert.assertEquals(bob.toString(), "BOBERT of the trees");
        Assert.assertEquals(job.toString(), "Joseph Chillingworth of the trees");
        Assert.assertEquals(bruce.toString(), "Batman of the trees");
    }

    @Test()
    public void test_speak() {
        Tree bob = new Tree("Bob");
        Assert.assertEquals(bob.speak(), "<rustling>");
     }
}

