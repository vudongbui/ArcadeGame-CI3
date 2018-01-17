package game.square;

import core.GameObject;
import core.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import utils.Utils;

public class Square extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;

    public Square() {
        this.image = Utils.loadImage("resources/square/enemy_square_small.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(20, 20);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        if(this.position.x>=400){
            this.velocity.x = -this.velocity.x;
        }
        if(this.position.x<=0){
            this.velocity.x = -this.velocity.x;
        }
        if (this.position.y>= 700) this.getHit();
    }

    public void getHit() {
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
