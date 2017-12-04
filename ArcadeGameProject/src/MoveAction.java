import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


public class MoveAction extends AbstractAction {
	private Digger digger;
	private double dx;
	private double dy;
	
	public MoveAction(Digger digger, double dx, double dy){
		this.digger = digger;
		this.dx = dx;
		this.dy = dy;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.digger.setSpeed(this.dx, this.dy);
		
	}

}
