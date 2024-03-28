package edu.realemj.assign05;
// NOTE: CHANGE realemj to YOUR SITNETID!!!

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGiant {

    @Test()
    public void test_getName() {
        Giant bob = new Giant("Bob");
        Giant job = new Giant("Joe Chill");
        Giant bruce = new Giant("Bruce Wayne");

        Assert.assertEquals(bob.getName(), "Bob");
        Assert.assertEquals(job.getName(), "Joe Chill");
        Assert.assertEquals(bruce.getName(), "Bruce Wayne");
    }

    @Test()
    public void test_setName() {
        Giant bob = new Giant("Bob");
        Giant job = new Giant("Joe Chill");
        Giant bruce = new Giant("Bruce Wayne");

        bob.setName("BOBERT");
        job.setName("Joseph Chillingworth");
        bruce.setName("Batman");

        Assert.assertEquals(bob.getName(), "BOBERT");
        Assert.assertEquals(job.getName(), "Joseph Chillingworth");
        Assert.assertEquals(bruce.getName(), "Batman");
    }

    @Test()
    public void test_toString() {
        Giant bob = new Giant("Bob");
        Giant job = new Giant("Joe Chill");
        Giant bruce = new Giant("Bruce Wayne");

        Assert.assertEquals(bob.toString(), "Bob");
        Assert.assertEquals(job.toString(), "Joe Chill");
        Assert.assertEquals(bruce.toString(), "Bruce Wayne");

        bob.setName("BOBERT");
        job.setName("Joseph Chillingworth");
        bruce.setName("Batman");

        Assert.assertEquals(bob.toString(), "BOBERT");
        Assert.assertEquals(job.toString(), "Joseph Chillingworth");
        Assert.assertEquals(bruce.toString(), "Batman");
    }
}

