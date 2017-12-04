import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import javax.swing.ImageIcon;


public class Upgrade implements Entity{

	protected Point2D.Double centerPoint;
	protected WorldComponent game;
	protected int size;
	
	public Upgrade(Point2D.Double pt, int size,WorldComponent game){
		this.centerPoint = pt;
		this.game = game;
		this.size = size;
		
		this.centerPoint.x -= this.size/2;
		this.centerPoint.y -= this.size/2;
	}

	@Override
	public void timePassed() {
		Point2D.Double pt = (Double) this.game.getEntities().get(0).getCenter();
		if (Point2D.Double.distance(this.centerPoint.x, this.centerPoint.y, pt.x, pt.y) < 4*this.size/5){
			this.pickup();
		}
		
	}

	protected void pickup() {
		this.game.addPoints(this);
		
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

	@Override
	public ImageIcon getImage() {
		// TODO Auto-generated method stub.
		return null;
	}
	

}
