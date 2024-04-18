package edu.townsemc.exercises17;
import org.testng.annotations.*;
import org.testng.*;


public class TestEmployee {
    @Test
    public void testName(){
        String trueName = "Bobert";
        Employee e = new Employee("Bobert",1980);

        Assert.assertEquals(e.getName(), trueName);
    }
}
