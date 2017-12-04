package LevelEditor;

import javax.swing.JFrame;

public class EditorFrame{
	private JFrame frame;
	private final double SIZE;
	private EditorComponent ec;
	
	public EditorFrame(double size){
		this.frame = new JFrame();
		this.SIZE = size;
		this.frame.setSize((int) (138+this.SIZE*24),(int)(45+this.SIZE*16));
		this.ec = new EditorComponent(this.SIZE);
		this.frame.add(ec);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getFrame(){
		return this.frame;
	}
	
	public EditorComponent getEditorComponent(){
		return this.ec;
	}
	

}
