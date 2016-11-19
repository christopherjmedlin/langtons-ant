import javax.swing.JFrame;
import java.awt.Dimension;
/**
 * Main class. Creates and runs the window
 * with Langon's Ant in it.
 * 
 *
 * @author Ivan Kenevich
 * @since Nov 17 2016
 */
 public class Main {
	 public static void main(String[] args) {
		Dimension d = new Dimension(1920,1080);
		JFrame frame = new JFrame("Langton's Ant");
		
		// The first number passed to the main method on the call is the scale parameter for the cells
		// the second number passed is the delay between two successive generations (inversely proportional to the speed of the animation)
		LangtonsPanel lp = new LangtonsPanel(d,Integer.valueOf(args[0]),Integer.valueOf(args[1]));
		
		frame.setSize(d);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(lp);
		frame.setVisible(true);
	 }
 }