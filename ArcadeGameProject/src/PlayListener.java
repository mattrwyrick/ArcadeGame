import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class PlayListener implements MouseListener {
	JLabel parent;
	private ImageIcon defaultIcon;
	private ImageIcon mouseOverIcon;
	private AudioStream audio;
	
	public PlayListener(JLabel label, ImageIcon defaultIcon, ImageIcon mouseOverIcon, AudioStream audio){
		this.parent = label;
		this.defaultIcon = defaultIcon;
		this.mouseOverIcon = mouseOverIcon;
		this.audio = audio;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		try{
			AudioPlayer.player.stop(this.audio);
		}finally{
			//nothing
		}
		try {
			WorldFrame game = new WorldFrame();
		} catch (FileNotFoundException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		this.parent.setIcon(this.mouseOverIcon);

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		this.parent.setIcon(this.defaultIcon);

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub.

	}

}
