package game.player;

import core.GameObject;
import game.enemy.Enemy;
import game.square.Square;
import game.enemy.bullet.BulletEnemy;

class HitPLayer {
    public void run(BulletEnemy bulletEnemy){
        Player player = GameObject.checkCollider(bulletEnemy.boxCollider, Player.class );
        if (player != null){
            player.getHit();
            System.out.println("Game over!!");
        }
    }
    public void run(Enemy enemy){
        Player player = GameObject.checkCollider(enemy.boxCollider, Player.class );
        if (player != null){
            player.getHit();
            System.out.println("Game over!!");
        }
    }
    public void run(Square square){
        Player player = GameObject.checkCollider(square.boxCollider, Player.class );
        if (player != null){
            player.getHit();
            System.out.println("Game over!!");
        }
    }

}