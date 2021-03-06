import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Enemy implements Entity {

	private ArrayList<int[]> pathway;
	private boolean[][] map;
	private WorldComponent game;
	private Point2D.Double centerPoint;
	private Digger digger;
	private double vx;
	private double vy;
	private boolean isHobblin = false;
	private int size;
	private Pathway path;
	private double speed = 1.25;

	private int rate = 0;
	private int morphTime = 8000;
	private EnemyCreator parent;
	private int[] lastPoint;
	private int row;
	private int column;

	public Enemy(Point2D.Double pt, WorldComponent game, EnemyCreator parent) {
		this.centerPoint = pt;
		this.game = game;
		this.map = game.getMap().clone();
		this.size = game.getBlockSize();
		this.digger = (Digger) game.getEntities().get(0);
		this.vx = 0;
		this.vy = 0;
		this.parent = parent;
		this.lastPoint = new int[2];
		this.lastPoint[0] = this.lastPoint[1];

	}

	@Override
	public void timePassed() {
		int[] point = new int[2];

		touchesEntity();
		this.changeEnemy();
		if (((int) this.centerPoint.x - this.size / 2) % this.size == 0
				&& ((int) this.centerPoint.y - this.size / 2) % this.size == 0) {

			this.path = new Pathway(this.game, this);

			// converts to coordinates to row/column
			this.row = (int) (this.centerPoint.getY() / this.size);
			this.column = (int) (this.centerPoint.getX() / this.size);

			point = this.path.pathFinder(row, column, this.isHobblin);

			if (point[1] * this.size > this.centerPoint.x - this.size / 2) {
				this.vx = speed;
				this.vy = 0;
			} else if (point[1] * this.size < this.centerPoint.x - this.size
					/ 2) {
				this.vx = -speed;
				this.vy = 0;
			} else if (point[0] * this.size > this.centerPoint.y - this.size
					/ 2) {
				this.vy = speed;
				this.vx = 0;
			} else if (point[0] * this.size < this.centerPoint.y - this.size
					/ 2) {
				this.vy = -speed;
				this.vx = 0;
			}

		} else {
			this.lastPoint[1] = column;
			this.lastPoint[0] = row;
		}

		this.centerPoint.setLocation(this.centerPoint.x + vx,
				this.centerPoint.y + vy);

	}

	public void touchesEntity() {
		for (Entity entity : this.game.getEntities()) {

			// if entity is bullet
			if (entity.getClass().toString().equals("class Bullet")) {
				if (Math.abs(entity.getCenter().getX() - this.centerPoint.x) < this.size / 1.5
						&& Math.abs(entity.getCenter().getY()
								- this.centerPoint.y) < this.size / 1.5) {
					this.game.addPoints(this);
					this.game.addPoints(entity);
					this.parent.babyDied();
				}
			}

			if (entity.getClass().toString().equals("class Gold")) {
				if (Math.abs(entity.getCenter().getX() - this.centerPoint.x) < this.size / 1.5
						&& Math.abs(entity.getCenter().getY()
								- this.centerPoint.y) < this.size / 1.5) {
					if (((Gold) entity).getBroken()) {
						this.game.getEntitiesToRemove().add(entity);
					}
					if (((Gold) entity).getIsFalling()) {
						this.game.addPoints(this);
						this.parent.babyDied();
					}

				}
			}

			if (entity.getClass().toString().equals("class Digger")) {
				if (Math.abs(entity.getCenter().getX() - this.centerPoint.x) < this.size / 1.8
						&& Math.abs(entity.getCenter().getY()
								- this.centerPoint.y) < this.size / 1.8) {
					if (((Digger) this.game.getEntities().get(0))
							.isInvincible()) {
						this.game.addPoints(this);
						this.parent.babyDied();
					} else
						this.game.diggerDies();
				}
			}

		}

	}

	@Override
	public Shape getShape() {

		return null;
	}

	@Override
	public Color getColor() {
		Color[] colors = new Color[4];
		Random random = new Random();

		colors[0] = Color.red;
		colors[1] = Color.blue;
		colors[2] = Color.green;
		colors[3] = Color.yellow;

		if (this.isHobblin) {
			return colors[random.nextInt(4)];
		}

		return Color.red;

	}

	@Override
	public int getPoints() {
		return 150;
	}

	@Override
	public Double getCenter() {
		return this.centerPoint;
	}

	public EnemyCreator getParent() {
		return this.parent;
	}

	public void changeEnemy() {
		Random random = new Random();
		int num = random.nextInt(this.morphTime);
		if (num < 2) {
			this.isHobblin = true;
		}
		if (num == 50)
			this.isHobblin = false;

	}

	public int[] getLastPoint() {
		return this.lastPoint;
	}

	@Override
	public ImageIcon getImage() {
		if (this.isHobblin)
			return new ImageIcon(System.getProperty("user.dir")
					+ "/src/images/hobblin.png");
		return new ImageIcon(System.getProperty("user.dir")
				+ "/src/images/nobblin.png");
	}

}
