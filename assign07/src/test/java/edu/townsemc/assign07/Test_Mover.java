package edu.townsemc.assign07;

import edu.townsemc.assign06.Creature;
import edu.townsemc.assign06.Rat;
import org.testng.annotations.Test;

public class Test_Mover {

    private class MoverTest implements Mover {
        public void performMove(Player p) {
            // Really just checking interface is correctly set up
        }
    }

    @Test()
    public void testPerformMove() {
        Mover thing = new MoverTest();
        thing.performMove(new Player());
    }
}
