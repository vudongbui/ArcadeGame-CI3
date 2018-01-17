package game.enemy;

import core.GameObject;
import core.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import utils.Utils;

public class Enemy extends GameObject implements PhysicBody{

    public Vector2D velocity;
    private EnemyShoot enemyShoot;
    public BoxCollider boxCollider = new BoxCollider(10,10);

    public Enemy() {
        this.image = Utils.loadImage("resources/square/enemy_square_medium.png");
        this.velocity = new Vector2D();
        this.enemyShoot = new EnemyShoot();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        this.enemyShoot.run(this);
        if(this.position.x>=400){
            this.velocity.x = -this.velocity.x;
        }
        if(this.position.x<=0){
            this.velocity.x = -this.velocity.x;
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
