package edu.realemj.assign02;
// NOTE: CHANGE realemj to YOUR SITNETID!!!
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSpaceVessel {
    @Test()
    public void test_name() {
        SpaceVessel s1 = new SpaceVessel();
        SpaceVessel s2 = new SpaceVessel();
        Assert.assertEquals(s1.getName(), "");
        Assert.assertEquals(s2.getName(), "");

        s1.setName("Enterprise");
        s2.setName("Battlestar Galactica");
        Assert.assertEquals(s1.getName(), "Enterprise");
        Assert.assertEquals(s2.getName(), "Battlestar Galactica");
    }

    @Test()
    public void test_length() {
        SpaceVessel s1 = new SpaceVessel();
        SpaceVessel s2 = new SpaceVessel();

        Assert.assertEquals(s1.getLength(), 0);
        Assert.assertEquals(s2.getLength(), 0);

        s1.setLength(107);
        s2.setLength(92);

        Assert.assertEquals(s1.getLength(), 107);
        Assert.assertEquals(s2.getLength(), 92);
    }

    @Test()
    public void test_weight() {
        SpaceVessel s1 = new SpaceVessel();
        SpaceVessel s2 = new SpaceVessel();

        Assert.assertEquals(s1.getWeight(), 0);
        Assert.assertEquals(s2.getWeight(), 0);

        s1.setWeight(210);
        s2.setWeight(108);

        Assert.assertEquals(s1.getWeight(), 210);
        Assert.assertEquals(s2.getWeight(), 108);
    }

    @Test()
    public void test_getLengthString() {
        SpaceVessel p = new SpaceVessel();
        Assert.assertEquals(p.getLengthString(), "0 ft. (0.00 m)");

        p.setLength(72);
        Assert.assertEquals(p.getLengthString(), "72 ft. (21.95 m)");

        p.setLength(102);
        Assert.assertEquals(p.getLengthString(), "102 ft. (31.09 m)");

        p.setLength(4502);
        Assert.assertEquals(p.getLengthString(), "4502 ft. (1372.21 m)");
    }

    @Test()
    public void test_getWeightString() {
        SpaceVessel p = new SpaceVessel();
        Assert.assertEquals(p.getWeightString(), "0 lbs. (0.00 kg)");

        p.setWeight(1679);
        Assert.assertEquals(p.getWeightString(), "1679 lbs. (761.59 kg)");
    }

    @Test()
    public void test_toString() {
        SpaceVessel p = new SpaceVessel();

        String output = """
                NAME:\s
                LENGTH: 0 ft. (0.00 m)
                WEIGHT: 0 lbs. (0.00 kg)                
                """;

        Assert.assertEquals(p.toString(), output);

        p.setName("Millenium Falcon");
        p.setLength(113);
        p.setWeight(220462);
        output = """
                NAME: Millenium Falcon
                LENGTH: 113 ft. (34.44 m)
                WEIGHT: 220462 lbs. (100001.56 kg)
                """;
        Assert.assertEquals(p.toString(), output);
    }
}

