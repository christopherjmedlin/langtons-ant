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
public class LangtonsPanel extends JPanel implements ActionListener {
	
	private LangtonsAnt la;
	private Timer t;
	private int scale, generationCounter, adjustedMiddleX, adjustedMiddleY;
	
	public LangtonsPanel (Dimension d, int scale, int delay) {
		this.scale = scale;
		
		adjustedMiddleX = d.width/(2*scale);
		adjustedMiddleY = d.height/(2*scale);
		
		la = new LangtonsAnt();
		la.addAnt(new Ant(adjustedMiddleX,adjustedMiddleY));
		
		generationCounter = 0;   // To display the generation
		t = new Timer(delay,this);
		t.start();
	}

    public void actionPerformed (ActionEvent e) {
		la.nextGeneration();
		generationCounter++;
		repaint();
	}

	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		for (Point cell : la.getBlackCells()) {
			g.fillRect(scale*cell.x-scale/2,scale*cell.y-scale/2,scale,scale);
		}
		g.drawString("Generation: "+generationCounter,40,adjustedMiddleY*scale);
	 }
}