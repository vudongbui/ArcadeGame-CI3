import core.GameObject;
import core.Vector2D;
import game.background.Background;
import game.circlesquare.CircleSquare;
import game.circlesquare.CircleSquareSqawner;
import game.enemy.EnemySqawner;
import game.player.Player;
import game.square.SquareSqawner;
import game.flyquare.FlySquareSqawner;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    Player player;
    BufferedImage backBuffered;
    Graphics graphics;
    public Vector2D positionPlayer = new Vector2D();


    public GameCanvas() {
        this.setSize(400, 600);
        this.setVisible(true);
        this.setupBackBuffered();
        this.setupBackground();
        this.setupPlayer();
        this.setupSquare();
        this.setupEnemy();
        this.setupCircleSquare();
        this.setupFlySquare();
        //GameObject.add(new CircleSquare());
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupBackground() {
        GameObject.add(new Background());
    }

    private void setupPlayer() {
        this.player = new Player();
        GameObject.add(player);
    }

    private void setupSquare() {
        GameObject.add(new SquareSqawner());
    }
    private void setupCircleSquare(){GameObject.add(new CircleSquareSqawner());}
    private void setupFlySquare(){GameObject.add(new FlySquareSqawner());}

    private void setupEnemy() {
        GameObject.add(new EnemySqawner());
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        GameObject.renderAll(graphics);
        this.repaint();
    }

    public void runAll() {
        this.player.position.set(this.positionPlayer);
        GameObject.runAll();

    }
}
