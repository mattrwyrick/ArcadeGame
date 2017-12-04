import java.awt.geom.Point2D;



public class SaveData {
	private Point2D.Double point;
	private int state;
	
	public SaveData(Point2D.Double point, int state){
		this.point = point;
		this.state= state;
	}
	
	public Point2D.Double getPoint(){
		return this.point;
	}
	
	public int getState(){
		return this.state;
	}
	
	public boolean getIsTunnel(){
		return this.state == 1;
	}

}
