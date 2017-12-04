import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import javax.swing.ImageIcon;

/*
 * TODO fix enemy spawning
 */

public class EnemyCreator implements Entity {
	private WorldComponent game;
	private int spawnRate = 350;
	private int spawnTimer;
	private Point2D.Double centerPoint;
	private Digger digger;
	private int enemyCount;
	private boolean allSpawned = false;

	public EnemyCreator(Point2D.Double pt, WorldComponent game) {
		this.centerPoint = pt;
		this.game = game;
		this.spawnTimer = 0;
		this.enemyCount = 0;
	}

	@Override
	public void timePassed() {
		if (this.enemyCount <= this.game.getLevel() + 1) {
			this.spawnTimer++;
			if (this.spawnTimer >= this.spawnRate) {
				this.spawnTimer = 0;
				this.spawnEnemy();
				this.enemyCount++;
			}
			if (this.enemyCount == this.game.getLevel() + 1 && !this.allSpawned) {
				this.spawnRate *= 2;
				this.allSpawned = true;
			}
			else if (this.enemyCount == this.game.getLevel() + 1 && this.allSpawned){
				this.allSpawned = true;
			}
		}
	}

	private void spawnEnemy() {
		if (game.getDebug())
			System.out.println("Enemy theoretically created");
		Point2D.Double pt = (Double) this.centerPoint.clone();
		pt.x += this.game.getBlockSize() / 2;
		pt.y += this.game.getBlockSize() / 2;
		this.game.getEntitiesToAdd().add(new Enemy(pt, this.game, this));

	}

	@Override
	public Shape getShape() {
		return null;
	}

	@Override
	public Color getColor() {
		return null;
	}

	@Override
	public int getPoints() {
		return 0;
	}

	@Override
	public Double getCenter() {
		return this.centerPoint;
	}

	public void babyDied() {
		this.enemyCount--;
	}

	@Override
	public ImageIcon getImage() {
		// TODO Auto-generated method stub.
		return null;
	}

}
