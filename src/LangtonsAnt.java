import java.awt.Point;

/**
 * Class represents a single session of Langton's Ant.
 *
 * @author Christopher Medlin
 * @since Nov 17 2016
 */
//TODO: add comments
public class LangtonsAnt {
	private ArrayList<Point> blackCells;
	private ArrayList<Ant> ants;

	public void nextGeneration () {
		
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
}
