import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;


public class LevelAction extends AbstractAction{
	private WorldComponent game;
	private int currentLevel;
	private int dl;
	private File files[];	
	
	public LevelAction(int dl, File files[], WorldComponent game){
		this.files = files;
		this.dl = dl;
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.game.getLevel() == this.files.length -1 && this.dl > 0){
			System.out.println("Max Level");
			this.game.setPause(true);
			this.game.getHud().setText("GAME WON!  SCORE:"+this.game.getScore());
			return;
		}
		if (this.game.getLevel() == 0 && this.dl < 0){
			System.out.println("Min Level");
			return;
		}
		System.out.println("Changing to next level: "+(this.game.getLevel()+dl+1));
		this.game.changeLevel(this.game.getSaveData(this.files[this.game.getLevel()+this.dl]),this.dl);
		this.game.repaint();
	}
	
}
