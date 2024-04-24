package edu.townsemc.exercises17;
import org.testng.annotations.*;
import org.testng.*;

import java.security.PublicKey;


public class TestEmployee {
    @Test
    public void testName(){
        String trueName = "Bobert";
        Employee e = new Employee("Bobert",1980);

        Assert.assertEquals(e.getName(), trueName);
        Employee clintEastwood = new Employee();
        Assert.assertEquals(clintEastwood.getName(), "");
    }

    @DataProvider(name="employeeList")
    public Object[][] generateEmployeeList(){
        Object[][] data = {
                {new Employee("Moe",1981),2024,43},
                {new Employee("Larry",1973),2003,30},
                {new Employee("Curly",1851),1952,101}
        };
        return data;
    }
    @Test(dataProvider="employeeList")
    public void testYearsOfService(Employee e, int currentYear, int targetYears){
        int yearsService = e.calcYearsOfService(currentYear);
        Assert.assertEquals(yearsService,targetYears);
    }
}
