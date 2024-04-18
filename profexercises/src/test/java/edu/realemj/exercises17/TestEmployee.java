package edu.realemj.exercises17;

import org.testng.annotations.*;
import org.testng.*;

public class TestEmployee {
    @Test
    public void testName() {
        String trueName = "Bobert";
        Employee e = new Employee(trueName, 1998);

        Assert.assertEquals(e.getName(), trueName);

        Employee clintEastwood = new Employee();
        Assert.assertEquals(clintEastwood.getName(), "");
    }
}
