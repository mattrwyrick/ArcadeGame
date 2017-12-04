import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import javax.swing.ImageIcon;


public class Bullet implements Entity {
	private Point2D.Double centerPoint;
	private double vx;
	private double vy;
	private double size;
	private WorldComponent game;
	
	public Bullet(Point2D.Double pt, double size, double vx, double vy, WorldComponent game){
		this.centerPoint = pt;
		this.vx = vx*4;
		this.vy = vy*4;
		if (vx == 0 && vy == 0){
			this.vx=4;
		}
		this.size = size;
		this.game = game;
		this.centerPoint.x-=this.size/2;
		this.centerPoint.y-=this.size/2;
	}

	@Override
	public void timePassed() {
		double x = this.centerPoint.x+vx;
		double y = this.centerPoint.y+vy;
		Point2D.Double point = new Point2D.Double(x,y);
		
		if(this.game.isInside(point)){
			this.centerPoint.x+=this.vx;
			this.centerPoint.y+=this.vy;
		}else{
			this.game.addPoints(this);
		}
		if (!this.game.getMap()[(int) (this.centerPoint.y/this.size)][(int) (this.centerPoint.x/this.size)])
			this.game.addPoints(this);
		
	}

	@Override
	public Shape getShape() {
//		double x,y;
//		x = this.centerPoint.x-this.size/5;
//		y = this.centerPoint.y-this.size/5;
//		Ellipse2D.Double shape = new Ellipse2D.Double(x,y,this.size/2.5,this.size/2.5);
//		return shape;
		return null;
	}
	
	public ImageIcon getImage(){
		return new ImageIcon(System.getProperty("user.dir") + "/src/images/bullet.png");
	}

	@Override
	public Color getColor() {
		return new Color(51,0,51);
	}

	@Override
	public int getPoints() {
		return 0;
	}
	
	@Override
	public Double getCenter() {
		return this.centerPoint;
	}


}
