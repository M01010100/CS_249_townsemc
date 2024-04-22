package edu.realemj.assign07;

import edu.realemj.assign06.Creature;
import edu.realemj.assign06.Rat;
import org.testng.annotations.Test;

public class Test_MoveAlgorithm {

    private class MoveAlgorithmTest implements MoveAlgorithm {
        public void move(Creature current, Player p) {
            // Really just checking interface is correctly set up
        }
    }

    @Test()
    public void testMove() {
        MoveAlgorithm thing = new MoveAlgorithmTest();
        thing.move(new Rat(), new Player());
    }
}
