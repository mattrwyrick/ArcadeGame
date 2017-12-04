import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Gold implements Entity {

	private Point2D.Double centerPoint;
	private boolean fall = false;
	private double vx = 0;
	private double vy = 0;
	private WorldComponent game;
	private double size;
	private int row;
	private int column;
	private boolean broken = false;
	private boolean willBrake;
	private boolean isFalling = false;
	private Digger digger;
	private int wait = 0;
	private Color color;
	private int gif = 0;

	public Gold(Point2D.Double pt, double size, WorldComponent game) {
		this.game = game;
		this.centerPoint = pt;
		this.size = size;
		this.centerPoint.x += this.size / 2;
		this.centerPoint.y += this.size / 2;
		this.column = (int) (pt.x / this.size);
		this.row = (int) (pt.y / this.size);
		this.digger = (Digger) this.game.getEntities().get(0);
		this.color = new Color(255, 255, 0);
	}

	@SuppressWarnings("static-access")
	@Override
	public void timePassed() {

		if (this.broken) {
			Point2D.Double pt = this.digger.getCenter();
			if (Point2D.Double.distance(this.centerPoint.x, this.centerPoint.y,
					pt.getX(), pt.getY()) < this.size) {
				this.game.addPoints(this);
			}
		} else {
			// trys to fall
			boolean[][] map = this.game.getMap();

			// coverts to rows and columns
			this.row = (int) ((this.centerPoint.y - this.size / 2) / this.size);
			this.column = (int) (this.centerPoint.x / this.size);

			// if not bottom row and underneath is empty
			if (this.row + 1 < 16 && map[this.row + 1][this.column]) {

				if (this.row + 2 < 16 && map[this.row + 2][this.column]) {
					this.willBrake = true;
				}

				// wait to fall
				if (this.wait >= 200
						&& (this.centerPoint.x - this.size / 2) % this.size == 0 && this.vx== 0) {
					this.isFalling = true;
					this.vy = 1.25;

				} else if (vx == 0) {
					// if its falling and in dirt
					if (!map[this.row][this.column]) {
						this.wait++;
						this.isFalling = true;
						// make it shake
						if (this.wait % 2 == 0) {
							this.centerPoint.x += 1;
						} else {
							this.centerPoint.x -= 1;
						}
					} else{
						this.isFalling = true;
						this.vy = 1.25;

					}
				}

			} else {
				this.vy = 0;
				this.isFalling = false;
				this.wait = 0;
				if (this.willBrake)
					this.broken = true;
			} // end fall

			// trys to be pushed
			Point2D.Double pt1 = this.digger.getCenter();
			if (Point2D.Double.distance(this.centerPoint.x + this.size / 2,
					this.centerPoint.y + this.size / 2, pt1.getX() + this.size
							/ 2, pt1.getY()) < this.size
					&& this.row == (int) (this.digger.getCenter().getY() / 50)
					&& !this.isFalling && this.column!=0 && this.column != 23) {
				this.vx = this.digger.getVxy()[0];
			}
			if (this.game.isInside(new Point2D.Double(this.centerPoint.x + vx,
					this.centerPoint.y + this.vy))) {
				this.centerPoint.x += this.vx;
				this.centerPoint.y += this.vy;
				Point2D.Double pt = this.digger.getCenter();
				if (Point2D.Double.distance(this.centerPoint.x,
						this.centerPoint.y, pt1.x, pt1.y) < 4 * this.size / 5
						&& !this.digger.isInvincible() && this.isFalling && this.wait >= 200) {
					this.game.diggerDies();
				}
			}

			if ((this.centerPoint.x - this.size / 2) % this.size == 0
					|| (this.centerPoint.y - this.size / 2) % this.size == 0
					&& this.isFalling) {
				this.vx = 0;
				this.vy = 0;

			}
		}

	}

	@Override
	public Shape getShape() {
		return null;
	}

	@Override
	public Color getColor() {
		if (this.broken)
			return new Color(255, 140, 0);
		return null;
	}

	@Override
	public int getPoints() {

		// sound
		if (!this.game.isMuted()) {
			String wavFile = new String(System.getProperty("user.dir")
					+ "/src/sounds/coin.wav");
			InputStream in = null;
			try {
				in = new FileInputStream(wavFile);
			} catch (FileNotFoundException exception) {
				exception.printStackTrace();
			}
			AudioStream audio = null;
			try {
				audio = new AudioStream(in);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			AudioPlayer.player.start(audio);
		}

		return 500;
	}

	@Override
	public Double getCenter() {
		return this.centerPoint;
	}

	public boolean getBroken() {
		return this.broken;
	}

	public boolean getIsFalling() {
		return this.isFalling;
	}

	public void moveCenter(int dx, int dy) {
		this.centerPoint.x += dx;
		this.centerPoint.y += dy;
	}

	@Override
	public ImageIcon getImage() {
		int t = 17;
		String e = "coin1";
		if (!this.broken) {
			
			if(this.isFalling){
				return new ImageIcon(System.getProperty("user.dir") + "/src/coins/coin1.png");
			}
			
			this.gif++;
			if (this.gif <= 1 * t) {
				e = "coin1";
			}
			if (this.gif <= 2 * t && this.gif > 1 * t) {
				e = "coin2";
			}
			if (this.gif <= 3 * t && this.gif > 2 * t) {
				e = "coin3";
			}
			if (this.gif <= 4 * t && this.gif > 3 * t) {
				e = "coin4";
			}
			if (this.gif <= 5 * t && this.gif > 4 * t) {
				e = "coin5";
			}
			if (this.gif <= 6 * t && this.gif > 5 * t) {
				e = "coin5";
			}
			if (this.gif <= 7 * t && this.gif > 6 * t) {
				e = "coin6";
			}
			if (this.gif <= 8 * t && this.gif > 7 * t) {
				e = "coin7";
			}
			if (this.gif <= 9 * t && this.gif > 8 * t) {
				e = "coin8";
			}
			if (this.gif <= 10 * t && this.gif > 9 * t) {
				e = "coin9";
			}
			if (this.gif <= 11 * t && this.gif > 10 * t) {
				e = "coin10";
			}
			if (this.gif == 12 * t) {
				this.gif = 0;
			}

			return new ImageIcon(System.getProperty("user.dir") + "/src/coins/"
					+ e + ".png");
		}
			
			
			return new ImageIcon(System.getProperty("user.dir")
					+ "/src/images/goldBar.png");
		
	}


}
