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
		 System.out.println(args[0]);
		 LangtonsPanel lp = new LangtonsPanel(d,Integer.valueOf(args[0]),Integer.valueOf(args[1]));
		 frame.setSize(d);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.add(lp);
		 frame.setVisible(true);
	 }
 }