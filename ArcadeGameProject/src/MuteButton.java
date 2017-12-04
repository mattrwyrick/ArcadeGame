import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;


public class MuteButton extends JComponent implements MouseListener{
	private ImageIcon defaultImage;
	private ImageIcon mutedImage;
	private JLabel label;
	private boolean isMuted;
	private WorldComponent game;
	
	public MuteButton(ImageIcon defaultImage, ImageIcon mutedImage, WorldComponent game){
		this.defaultImage = defaultImage;
		this.mutedImage = mutedImage;
		this.label = new JLabel(defaultImage);
		this.isMuted = false;
		this.label.addMouseListener(this);
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.isMuted = !this.isMuted;
		if (this.isMuted)
			this.label.setIcon(this.mutedImage);
		else
			this.label.setIcon(this.defaultImage);
		this.game.setMuted(this.isMuted);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub.
		
	}

	public Component getLabel() {
		// TODO Auto-generated method stub.
		return this.label;
	}
}
