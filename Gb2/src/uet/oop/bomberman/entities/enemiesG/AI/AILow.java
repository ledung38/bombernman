package uet.oop.bomberman.entities.enemiesG.AI;

import java.util.Random;

public class AILow extends AI{
    @Override
    public int checkBombss() {
        return 0;
    }

    public int calculateDirection() {
        return random.nextInt(4) + 1;
    }
}