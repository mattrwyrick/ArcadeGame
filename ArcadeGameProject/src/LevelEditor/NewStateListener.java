package LevelEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewStateListener implements ActionListener{
	private int newState;
	private EditorComponent ec;
	
	public NewStateListener (int state, EditorComponent ec){
		this.newState = state;
		this.ec = ec;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ec.setNewState(this.newState);
		
	}

}
