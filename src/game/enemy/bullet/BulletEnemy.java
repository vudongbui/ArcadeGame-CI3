package game.enemy.bullet;

import core.GameObject;
import core.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import utils.Utils;

public class BulletEnemy extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider = new BoxCollider(10,10);
    public BulletEnemy() {
        this.image = Utils.loadImage("resources/square/enemy_square_bullet.png");
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }
    public void getHit(){
        isAlive = false;
    }
    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
