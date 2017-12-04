package LevelEditor;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Space {
	private int state;
	private final double SIZE;
	
	public Space(int state, double size){
		this.state = state;
		this.SIZE = size;
	}
	
	public int getState(){
		return this.state;
	}
	public Shape getShape(){
		return new Rectangle2D.Double(0,0,this.SIZE,this.SIZE);
	}
	
	public void setState(int state){
		this.state = state;
	}

}
