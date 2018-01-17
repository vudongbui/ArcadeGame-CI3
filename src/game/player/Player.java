package game.player;

import core.GameObject;
import physic.PhysicBody;
import physic.BoxCollider;
import utils.Utils;

public class Player extends GameObject implements PhysicBody{

    private PlayerShoot playerShoot;
    public BoxCollider boxCollider = new BoxCollider(50,50);

    public Player() {
        this.image = Utils.loadImage("resources/player/straight.png");
        this.playerShoot = new PlayerShoot();
    }

    @Override
    public void run() {
        boxCollider.position.set(this.position);
        super.run();
        this.playerShoot.run(this);

    }
    public void getHit(){
        isAlive = false;
    }
    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
