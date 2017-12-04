package LevelEditor;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlsPanel {

	private ArrayList<String> typesList;
	private JPanel panel;
	private EditorComponent ec;
	private EditorFrame frame;

	public ControlsPanel(ArrayList<String> typesList, double size,
			EditorFrame frame) {
		this.typesList = typesList;
		this.panel = new JPanel();
		this.frame = frame;
		this.ec = this.frame.getEditorComponent();

		this.panel.setLayout(new GridLayout((this.typesList.size() + 1), 2));
		this.panel.setPreferredSize(new Dimension(240, (int) (16 * size)));
		this.createButtons();
		this.createSaveButton();

	}

	private void createSaveButton() {
		JButton saveButton = new JButton("Save Data");
		saveButton.addActionListener(new SaveButtonListener(this.ec));
		this.panel.add(saveButton);

	}

	public JPanel getPanel() {
		return this.panel;
	}

	private void createButtons() {
		int count = 0;
		JButton button;
		for (String string : this.typesList) {
//			if (string.equals("Digger")) {
//				button = new JButton(new ImageIcon(
//						System.getProperty("user.dir")
//								+ "/src/images/kanyeHead.png"));
//			} 
//			else if(string.equals("Emerald")) {
//				button = new JButton(new ImageIcon(
//						System.getProperty("user.dir")
//								+ "/src/images/emerald.png"));
//			} 
//			else if(string.equals("Enemy Spawner")) {
//				button = new JButton(new ImageIcon(
//						System.getProperty("user.dir")
//								+ "/src/images/nobblin.png"));
//			} 
//			else if(string.equals("Dirt")) {
//				button = new JButton(new ImageIcon(
//						System.getProperty("user.dir")
//								+ "/src/images/dirt.png"));
//			} 
//			else {
				button = new JButton(string);
				button.setFont(new Font("Arial", Font.PLAIN, 18));
				button.setPreferredSize(new Dimension(350, 50));
//			}
			button.addActionListener(new NewStateListener(count, this.ec));

			this.panel.add(button);
			count++;
		}
	}

}
