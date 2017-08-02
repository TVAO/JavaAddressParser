import java.awt.event.*;

public class Controller implements MouseListener {
	public static final long serialVersionUID = 42;
	Model model;
	View view;

	public Controller(Model m, View v) {
		model = m;
		view = v;
		view.canvas.addMouseListener(this);
	}
 
	public void mousePressed(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
