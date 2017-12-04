import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import javax.swing.ImageIcon;

public class Emerald implements Entity {
	private Point2D.Double centerPoint;
	private double size;
	private final int POINTS;
	private Digger digger;
	private WorldComponent game;

	public Emerald(Point2D.Double centerPoint, double size, Digger digger,
			WorldComponent game) {
		this.centerPoint = centerPoint;
		this.centerPoint.x += size / 2;
		this.centerPoint.y += size / 2;
		this.size = size;
		this.POINTS = 150;
		this.digger = digger;
		this.game = game;
	}

	@SuppressWarnings("static-access")
	@Override
	public void timePassed() {
		Point2D.Double pt = this.digger.getCenter();
		if (Point2D.Double.distance(pt.getX(), pt.getY(), this.centerPoint.x,
				this.centerPoint.y) < (this.size / 2)) {
			this.digger.eatEntity(this);
		}
	}

	@Override
	public Shape getShape() {
		return null;
	}

	public void setCenter(double x, double y) {
		this.centerPoint.setLocation(x, y);
	}

	@Override
	public Color getColor() {
		return Color.green;
	}

	public int getPoints() {
		return this.POINTS;
	}

	@Override
	public Double getCenter() {
		return this.centerPoint;
	}

	@Override
	public ImageIcon getImage() {
		return new ImageIcon(System.getProperty("user.dir")
				+ "/src/images/emerald.png");
	}

}
