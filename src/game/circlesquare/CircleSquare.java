package game.circlesquare;

import core.FrameCounter;
import core.GameObject;
import core.Vector2D;
import game.square.Square;

public class CircleSquare extends Square {
    private FrameCounter frameCounter;
    public CircleSquare() {
        this.frameCounter = new FrameCounter(120);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            for (double angle = 0.0; angle <= 360.0; angle += 360.0 / 12) {
                Square square = new Square();
                square.position.set((new Vector2D(50.0f, 0.0f)).rotate(angle)).addUp(60, 60);
                GameObject.add(square);
                this.frameCounter.reset();
            }
        }
    }
}
