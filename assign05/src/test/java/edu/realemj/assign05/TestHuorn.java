package edu.realemj.assign05;
// NOTE: CHANGE realemj to YOUR SITNETID!!!

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHuorn {
    @Test()
    public void test_inheritance() {
        Huorn bob = new Huorn("Bob");
        Assert.assertTrue(bob instanceof Giant);
        Assert.assertTrue(bob instanceof Tree);
    }

    @Test()
    public void test_getName() {
        Giant bob = new Huorn("Bob");
        Giant job = new Huorn("Joe Chill");
        Giant bruce = new Huorn("Bruce Wayne");

        Assert.assertEquals(bob.getName(), "Bob");
        Assert.assertEquals(job.getName(), "Joe Chill");
        Assert.assertEquals(bruce.getName(), "Bruce Wayne");
    }

    @Test()
    public void test_setName() {
        Giant bob = new Huorn("Bob");
        Giant job = new Huorn("Joe Chill");
        Giant bruce = new Huorn("Bruce Wayne");

        bob.setName("BOBERT");
        job.setName("Joseph Chillingworth");
        bruce.setName("Batman");

        Assert.assertEquals(bob.getName(), "BOBERT");
        Assert.assertEquals(job.getName(), "Joseph Chillingworth");
        Assert.assertEquals(bruce.getName(), "Batman");
    }

    @Test()
    public void test_toString() {
        Giant bob = new Huorn("Bob");
        Giant job = new Huorn("Joe Chill");
        Giant bruce = new Huorn("Bruce Wayne");

        Assert.assertEquals(bob.toString(), "Huorn Bob of the trees");
        Assert.assertEquals(job.toString(), "Huorn Joe Chill of the trees");
        Assert.assertEquals(bruce.toString(), "Huorn Bruce Wayne of the trees");

        bob.setName("BOBERT");
        job.setName("Joseph Chillingworth");
        bruce.setName("Batman");

        Assert.assertEquals(bob.toString(), "Huorn BOBERT of the trees");
        Assert.assertEquals(job.toString(), "Huorn Joseph Chillingworth of the trees");
        Assert.assertEquals(bruce.toString(), "Huorn Batman of the trees");
    }

    @Test()
    public void test_speak() {
        Tree bob = new Huorn("Bob");
        Assert.assertEquals(bob.speak(), "<angry rustling>");
    }
}

