import java.awt.geom.Point2D.Double;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class NukeUpgrade extends Upgrade{

	public NukeUpgrade(Double pt, int size, WorldComponent game) {
		super(pt, size, game);
		// TODO Auto-generated constructor stub.
	}
	
	protected void pickup(){
		
		//sound
		String wavFile = new String(System.getProperty("user.dir")+"/src/sounds/nuke.wav");
		InputStream in = null;
		try {
				in = new FileInputStream(wavFile);
		} catch (FileNotFoundException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}
		AudioStream audio = null;
		try {
			if (!this.game.isMuted())
				audio = new AudioStream(in);
		} catch (IOException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}
		AudioPlayer.player.start(audio);
		
		super.pickup();
		for (Entity entity : this.game.getEntities()){
			if (entity.getClass().toString().equals("class Enemy")){
				this.game.addPoints(entity);
				((Enemy) entity).getParent().babyDied();
			}
		}
	}
	
	public ImageIcon getImage(){
		return new ImageIcon(System.getProperty("user.dir") + "/src/images/nukeUpgrade.png");
		
	}

}
