package LevelEditor;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;


public class EditorMain {
	static final double SIZE = 50;
	/**
	 * Starts the thing
	 *
	 * @param args
	 */
	public static void main(String[] args){
		EditorFrame editorFrame = new EditorFrame(SIZE);
		JFrame frame = editorFrame.getFrame();
		int setType = 0;
		
		ArrayList<String> typeList = new ArrayList<String>();
		typeList.add("Dirt");	 		//0
		typeList.add("Tunnel"); 		//1
		typeList.add("Emerald");		//2
		typeList.add("Gold");			//3
		typeList.add("Digger");			//4
		typeList.add("Enemy Spawner");	//5
		typeList.add("Super");			//6
		typeList.add("temp1");			//7
		typeList.add("temp2");			//8
		typeList.add("temp3");			//9
		typeList.add("temp4");			//10
		typeList.add("temp5");			//11
		typeList.add("temp6");			//12
		
		ControlsPanel controlsPanel = new ControlsPanel(typeList,SIZE, editorFrame);
		frame.add(controlsPanel.getPanel(),BorderLayout.WEST);
		
		frame.setVisible(true);
	}
}
