import java.awt.Point;

/**
 * Ant is a class that resembles an ant in a session of Langton's Ant.
 *
 * @author Christopher Medlin
 * @since Nov 17 2016
 */
public class Ant {
	
	private Point currentCell;
	private ArrayList<Point> notableCells;
	private Direction direction;
        
	private enum Direction {
		int dir;
		LEFT(-1), UP(0), RIGHT(1), DOWN(2);
		
		public Direction (int dir) {
			this.dir = dir;
		}

		public void turnRight () {
			if (dir == 2) {
				dir = -1;
			}
			else {
				dir++;
			}
		}

		public void turnLeft () {
			if (dir == -1) {
				dir = 2;
			}
			else {
				dir--;
			}
		}
	}

	public Ant (ArrayList<Point> notableCells, Point currentCell) {
		this.notableCells = notableCells;
		this.currentCell = currentCell;
		direction = Direction.RIGHT;
	}

	public Ant (ArrayList<Point> notableCells) {
		this.notableCells = notableCells;
		currentCell = new Point (0,0);
		direction = Direction.RIGHT;
	}

	public void move () {
		if (direction == Direction.LEFT) {
			currentCell.x--;
		}
		else if (direction == Direction.UP) {
			currentCell.y++;
		}
		else if (direction == Direction.RIGHT) {
			currentCell.x++;
		}
		else if (direction == Direction.DOWN) {
			currentCell.y--;
		}
	}

	public Point getCurrentCell () {
		return currentCell;
	}
}
