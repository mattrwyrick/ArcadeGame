import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import LevelEditor.ControlsPanel;
import LevelEditor.EditorFrame;


public class EditorListener implements MouseListener {

	private JLabel parent;
	private ImageIcon defaultIcon;
	private ImageIcon mouseOverIcon;
	private AudioStream audio;

	public EditorListener(JLabel editorButton, ImageIcon defaultImage,ImageIcon mouseOverImage, AudioStream audio) {
		// TODO Auto-generated constructor stub.
		this.parent = editorButton;
		this.defaultIcon = defaultImage;
		this.mouseOverIcon = mouseOverImage;
		this.audio = audio;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		try{
			AudioPlayer.player.stop(this.audio);
		}finally{
			//nothing
		}
		
		
		EditorFrame editorFrame = new EditorFrame(50);
		JFrame frame = editorFrame.getFrame();
		int setType = 0;
		
		ArrayList<String> typeList = new ArrayList<String>();
		typeList.add("Dirt");	 		//0
		typeList.add("Tunnel"); 		//1
		typeList.add("Emerald");		//2
		typeList.add("Gold");			//3
		typeList.add("Digger");			//4
		typeList.add("Enemy Spawner");	//5
		
		ControlsPanel controlsPanel = new ControlsPanel(typeList,50, editorFrame);
		frame.add(controlsPanel.getPanel(),BorderLayout.WEST);
		
		frame.setVisible(true);

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
