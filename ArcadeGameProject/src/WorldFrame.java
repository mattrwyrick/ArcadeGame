import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WorldFrame {
	private JFrame frame;
	private final int SIZE = 50;
	private final int ROWS = 16;
	private final int COLUMNS = 24;

	public WorldFrame() throws FileNotFoundException {
		this.frame = new JFrame();
		this.frame.setSize(this.COLUMNS * this.SIZE + this.SIZE / 2 - 19,
				this.ROWS * this.SIZE + this.SIZE + 45);

		this.frame.setResizable(false);
		File[] levels = new File[10];
		levels[0] = new File(System.getProperty("user.dir")
				+ "/src/levels/level1.txt");
		levels[1] = new File(System.getProperty("user.dir")
				+ "/src/levels/level2.txt");
		levels[2] = new File(System.getProperty("user.dir")
				+ "/src/levels/level3.txt");
		levels[3] = new File(System.getProperty("user.dir")
				+ "/src/levels/level4.txt");
		levels[4] = new File(System.getProperty("user.dir")
				+ "/src/levels/level5.txt");
		levels[5] = new File(System.getProperty("user.dir")
				+ "/src/levels/level6.txt");
		levels[6] = new File(System.getProperty("user.dir")
				+ "/src/levels/level7.txt");
		levels[7] = new File(System.getProperty("user.dir")
				+ "/src/levels/level8.txt");
		levels[8] = new File(System.getProperty("user.dir")
				+ "/src/levels/level9.txt");
		levels[9] = new File(System.getProperty("user.dir")
				+ "/src/levels/llevel10.txt");

		JPanel HUD = new JPanel();

		JLabel HUDLabel = new JLabel();
		HUDLabel.setSize(this.COLUMNS * this.SIZE + this.SIZE / 2,
				this.SIZE / 2);
		HUDLabel.setFont(new Font("Serif", Font.BOLD, 4 * this.SIZE / 5));
		HUD.setBackground(new Color(51, 0, 51));
		HUDLabel.setBackground(new Color(51, 0, 51));
		HUDLabel.setForeground(Color.white);
		HUDLabel.setOpaque(true);

		ImageIcon muted = new ImageIcon(System.getProperty("user.dir")
				+ "/src/images/mute.png");
		ImageIcon unMuted = new ImageIcon(System.getProperty("user.dir")
				+ "/src/images/noMute.png");
		
		

		WorldComponent game = new WorldComponent(this.SIZE, this.ROWS,
				this.COLUMNS, levels, HUDLabel);
		this.addThing(game);
		MuteButton muteButton = new MuteButton(unMuted, muted, game);
		HUD.add(muteButton.getLabel());
		HUD.add(HUDLabel);
		this.frame.add(HUD, BorderLayout.SOUTH);

		this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
		

	}

	public void addThing(JComponent thing) {
		this.frame.add(thing);
	}

}
