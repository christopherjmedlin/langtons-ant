import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.ArrayList;

/**
 * Class that draws the current generation of Langton's Ant.
 *
 * @author Ivan Kenevich
 * @since Nov 17 2016
 */
public class LangtonsPanel extends JPanel implements ActionListener, MouseListener {
	
	private LangtonsAnt la;
	private Dimension d;
	private Timer t;
	boolean displayInfoText;
	private int scale;
	
	public LangtonsPanel (Dimension d, int scale, int delay) {
		this.d = d;
		this.scale = scale;
		addMouseListener(this);
		
		setBackground(Color.WHITE);
		
		displayInfoText = true; 
		
		la = new LangtonsAnt();
		la.addAnt(new Ant(d.width/(2*scale),d.height/(2*scale)));  // The panel is initialized with a single ant in the middle of the screen
		
		t = new Timer(delay,this);
		t.start();
	}

	/**
    	Further increase in speed is possible
		by looping through the method calls inside this
	*/
    public void actionPerformed (ActionEvent e) {
		la.nextGeneration();
		repaint();
	}
	
	public void mousePressed (MouseEvent e) {
		if (e.getButton()==e.BUTTON1) {        // left mouse button spawns an ant
			la.addAnt(new Ant(e.getX()/scale,e.getY()/scale));
		}
		else if (e.getButton()==e.BUTTON2) {   // middle mouse button pauses/unpauses the simulation
			if (t.isRunning())
				t.stop();
			else
				t.start();
		}
		else if (e.getButton()==e.BUTTON3) {   // right mouse button spawns a black cell
			la.addBlackCell(new Point(e.getX()/scale,e.getY()/scale));
			repaint();
		}
		displayInfoText = false;               // once one of these buttons had been pressed, the informational text is removed
	}
	public void mouseClicked (MouseEvent e) {}
	public void mouseEntered (MouseEvent e) {}
	public void mouseExited (MouseEvent e) {}
	public void mouseReleased (MouseEvent e) {}

	public void paintComponent (Graphics g) {
		super.paintComponent(g);

		g.setFont(new Font("Ant font",Font.BOLD,17));         // increases the font from default and changse the type to bold
		g.setColor(Color.BLACK);
		
		for (Point cell : la.getBlackCells()) {               // drawing the cells that should be black, adjusted for scale
			g.fillRect(scale*cell.x-scale/2,scale*cell.y-scale/2,scale,scale);
		}
		
		g.setColor(Color.WHITE);                                                 // Draws a white background rectangle so that the
		g.fillRect(d.width/100,d.height/2-15,150,20);                            // generation is visible even if there are cells under it
		g.setColor(Color.BLACK);
		g.drawString("Generation: "+LangtonsAnt.generation,d.width/100,d.height/2);

		if (displayInfoText) {                                                   // Makes the user aware of the controls 
			g.drawString("CONTROLS:",100,d.height/20);                           // disappears as soon the user utilizes one of the controls
			g.drawString("LMB creates a new ant",d.width/100,2*d.height/20);
			g.drawString("CMB pauses or unpauses the simulation",d.width/100,3*d.height/20);
			g.drawString("RMB creates a new black cell",d.width/100,4*d.height/20);
		}
	 }
}