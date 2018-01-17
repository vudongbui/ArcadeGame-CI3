package game.flyquare;

import core.FrameCounter;
import core.GameObject;
import core.Vector2D;
import game.square.Square;
import physic.BoxCollider;
import physic.PhysicBody;
import utils.Utils;

public class FlySquare extends Square implements PhysicBody{

    public Vector2D velocity;
    public BoxCollider boxCollider = new BoxCollider(20,20);
    private FrameCounter frameCounter;

    public FlySquare() {
        this.frameCounter = new FrameCounter(1);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()){
            for (int i = 0; i < 10; i++){
                for ( int j = 0; j <5; j ++){
                    Square flySquare = new Square();
                    flySquare.position.set(20*i,20*j);
                    flySquare.velocity.set(5,0);
                    GameObject.add(flySquare); if(this.position.x>=400){
                        this.velocity.x = -this.velocity.x;
                        this.position.y = this.position.y + 50;
                    }
                    if(this.position.x<=0){
                        this.velocity.x = -this.velocity.x;
                        this.position.y = this.position.y + 50;
                    }
                }
            }

        }
    }

    public void getHit(){
        isAlive = false;
    }
    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
