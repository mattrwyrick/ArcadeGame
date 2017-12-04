import java.awt.geom.Point2D.Double;

import javax.swing.ImageIcon;


public class InvincibleUpgrade extends Upgrade{

	private Digger digger;

	public InvincibleUpgrade(Double pt, int size, WorldComponent game) {
		super(pt, size, game);
		this.digger = (Digger) this.game.getEntities().get(0);
	}
	
	protected void pickup(){
		super.pickup();
		this.digger.setInvincible(true);
	}

	public ImageIcon getImage(){
		return new ImageIcon(System.getProperty("user.dir") + "/src/images/invincibleUpgrade.png");
	}
}
