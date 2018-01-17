package game.flyquare;

import core.FrameCounter;
import core.GameObject;

import java.util.Random;

public class FlySquareSqawner extends GameObject{
    public FlySquareSqawner(){

    }
    @Override
    public void run(){
        super.run();
        FlySquare flySquare = new FlySquare();
        GameObject.add(flySquare);

    }

}
