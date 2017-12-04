import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import javax.swing.ImageIcon;


public class SpeedUpgrade extends Upgrade{

	public SpeedUpgrade(Double pt, int size, WorldComponent game) {
		super(pt, size, game);
	}
	
	public ImageIcon getImage(){
		return new ImageIcon(System.getProperty("user.dir") + "/src/images/speedUpgrade.png");
	}
	
	public void timePassed(){
		if (this.centerPoint.x == this.game.getEntities().get(0).getCenter().getX()
				&& this.centerPoint.y == this.game.getEntities().get(0).getCenter().getY()){
			this.pickup();
		}
	}
	
	protected void pickup(){
		super.pickup();
		((Digger) this.game.getEntities().get(0)).setMoveSpeedMultiplier(1.25);
		Point2D.Double pt = this.game.getEntities().get(0).getCenter();
		pt.setLocation(this.centerPoint.getX(),this.centerPoint.getY());
	}

}
