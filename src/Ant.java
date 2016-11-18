import java.awt.Point;

/**
 * Ant is a class that resembles an ant in a session of Langton's Ant.
 *
 * @author Christopher Medlin
 * @since Nov 17 2016
 */
public class Ant extends Point {
	
	private Direction direction;
        
	private enum Direction {
		public int dir;
		LEFT(-1), UP(0), RIGHT(1), DOWN(2);
		
		public Direction (int dir) {
			this.dir = dir;
		}
	}

	public Ant (x, y) {
		super(x, y);
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

	public void turnRight () {
		if (direction.dir == 2) {
			direction.dir = -1;
		}
		else {
			direction.dir++;
		}
	}

	public void turnLeft () {
		if (direction.dir == -1) {
			direction.dir = 2;
		}
		else {
			direction.dir--;
		}
	}

	public Point getCurrentCell () {
		return currentCell;
	}
}
