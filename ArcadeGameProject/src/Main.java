import java.awt.Color;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Main {

	public static void main(String[] args) throws IOException,
			UnsupportedAudioFileException {
		Main main = new Main();
		final JFrame mainMenu = new JFrame();
		mainMenu.setSize(700, 250);

		String wavFile = new String(System.getProperty("user.dir")
				+ "/src/sounds/ThemeSong.wav");

		InputStream in = new FileInputStream(wavFile);
		AudioStream audio = new AudioStream(in);
		AudioPlayer.player.start(audio);

		JPanel mainPanel = new JPanel();
		mainMenu.add(mainPanel);
		mainPanel.setBackground(new Color(0, 100, 0));

		JLabel playButton = new JLabel(new ImageIcon(
				System.getProperty("user.dir") + "/src/images/playDefault.png"));
		ImageIcon defaultImage = new ImageIcon(System.getProperty("user.dir")
				+ "/src/images/playDefault.png");
		ImageIcon mouseOverImage = new ImageIcon(System.getProperty("user.dir")
				+ "/src/images/playMouseOver.png");
		playButton.addMouseListener(new PlayListener(playButton, defaultImage,
				mouseOverImage, audio));
		mainPanel.add(playButton);

		JLabel editorButton = new JLabel(new ImageIcon(
				System.getProperty("user.dir")
						+ "/src/images/editorDefault.png"));
		defaultImage = new ImageIcon(System.getProperty("user.dir")
				+ "/src/images/editorDefault.png");
		mouseOverImage = new ImageIcon(System.getProperty("user.dir")
				+ "/src/images/editorMouseOver.png");
		editorButton.addMouseListener(new EditorListener(editorButton,
				defaultImage, mouseOverImage, audio));
		mainPanel.add(editorButton);

		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenu.setVisible(true);

	}
}
