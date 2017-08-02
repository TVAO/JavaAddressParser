import java.awt.*;
import javax.swing.*;
import java.util.*;
 
public class View extends JFrame implements Observer {
	public static final long serialVersionUID = 0;
	Model model;
	Canvas canvas;

	public View(Model m) {
		model = m;
		m.addObserver(this);
		canvas = new Canvas();
		setLayout(new BorderLayout());
		getContentPane().add(canvas, BorderLayout.CENTER);
		setSize(512, 512);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void update(Observable obs, Object obj) {
		canvas.repaint();
	}

	class Canvas extends JComponent {
		private final Font roadFont = new Font("Arial", Font.BOLD, 14);
		private final Font cityFont = new Font("Arial", Font.PLAIN, 14);
		public static final long serialVersionUID = 4;
		Random rnd = new Random();

		public void paint(Graphics g) {
			
			int ycoord = 20;
			for (Address addr : model) {
				g.setFont(roadFont);
				g.drawString(String.format("%s %s, %s. %s",
							addr.street(),
							addr.house(),
							addr.floor(),
							addr.side()), 10, ycoord);
				g.setFont(cityFont);
				g.drawString(String.format("%s %s",
							addr.postcode(),
							addr.city()), 10, ycoord+20);
				g.drawLine(0, ycoord - 20, 500, ycoord - 20);
				ycoord += 50;
			}
		}
	}
}

// should have x fields to write in address info separately