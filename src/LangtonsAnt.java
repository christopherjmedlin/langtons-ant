import java.awt.Point;
import java.util.ArrayList;
/**
 * Class represents a single session of Langton's Ant.
 *
 * @author Christopher Medlin and Ivan Kenevich
 * @since Nov 17 2016
 */
//TODO: add comments
public class LangtonsAnt {
	private ArrayList<Point> blackCells;
	private ArrayList<Ant> ants;
	
	public LangtonsAnt() {
		blackCells = new ArrayList<Point>();
		ants = new ArrayList<Ant>();
	}
	
	public void nextGeneration () {
		boolean isOnBlackCell;
		for (Ant ant : ants) {
			isOnBlackCell = false;
			
			ArrayList<Point> blackCellsCopy = new ArrayList<Point>(blackCells);   // You need a copy because you cannot
																				  // iterate through an ArrayList while changing it
			
			for (Point cell : blackCells) {
				if (ant.x == cell.x &&
				    ant.y == cell.y) {
					ant.turnLeft();
					blackCellsCopy.remove(cell);
					isOnBlackCell = true;
				}
			}
			if (!isOnBlackCell) {
				ant.turnRight();
				blackCellsCopy.add(new Point(ant.x, ant.y));
			}
			blackCells = blackCellsCopy;    // A copy becomes the actual list again
			ant.move();

		}	
	} 

	public boolean addBlackCell (Point blackCell) {
		boolean success = true;

		for (int i = 0; i < blackCells.size(); i++) {
			if (blackCells.get(i).x == blackCell.x ||
			    blackCells.get(i).y == blackCell.y) 
				success = false;
		}
		
		if (success == true)
			blackCells.add(blackCell);
		
		return success;
	}
    
	public boolean addAnt (Ant ant) {
		boolean success = true;
		// foreach maybe?
		for (int i = 0; i < ants.size(); i++) {
			if (ants.get(i).x == ant.x ||
			    ants.get(i).y == ant.y)
				success = false;
		}
		
		if (success == true)
			ants.add(ant);
		
		return success;
	}

	public ArrayList<Point> getBlackCells () {
		return blackCells;
	}
	
	public ArrayList<Ant> getAnts () {
		return ants;
	}	
}
