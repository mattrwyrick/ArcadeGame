import java.awt.geom.Point2D.Double;

import javax.swing.ImageIcon;


public class ShotUpgrade extends Upgrade{

	public ShotUpgrade(Double pt, int size, WorldComponent game) {
		super(pt, size, game);
	}
	
	protected void pickup(){
		super.pickup();
		((Digger) this.game.getEntities().get(0)).setShotSpeedMultiplier(0.5);
	}
	
	public ImageIcon getImage(){
		return new ImageIcon(System.getProperty("user.dir") + "/src/images/upgrade.png");
	}

}
