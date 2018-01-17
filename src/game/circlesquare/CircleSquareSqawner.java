package game.circlesquare;

import core.FrameCounter;
import core.GameObject;
import core.Vector2D;
import game.enemy.Enemy;
import game.square.Square;

import java.util.Random;

public class CircleSquareSqawner extends Square {
    private Random random;
    private FrameCounter frameCounter;
    public CircleSquareSqawner() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(200);
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            CircleSquare circleSquare = new CircleSquare();
            circleSquare.position.set(random.nextInt(400), 0);
            circleSquare.velocity.set(random.nextInt(7)-3, random.nextInt(2) + 2);
            GameObject.add(circleSquare);
            this.frameCounter.reset();
        }
    }
}
