import java.awt.Point;
import java.util.Random;
/**
 * Ant is a class that resembles an ant in a session of Langton's Ant.
 *
 * @author Christopher Medlin and Ivan Kenevich
 * @since Nov 17 2016
 */
public class Ant extends Point {
	
	// DIRECTIONS as numbers:
	// -1 left
	// 0  up
	// 1  right
	// 2  down
	private int direction;
	
	public Ant (int x, int y) {
		super(x, y);
		Random r = new Random();     // give each new ant a random direction
		direction = r.nextInt(3)-1;
	}

	public void move () {
		if (direction == -1) {
			x--;
		}
		else if (direction == 0) {
			y--;
		}
		else if (direction == 1) {
			x++;
		}
		else if (direction == 2) {
			y++;
		}
	}

	public void turnRight () {
		if (direction == 2) {
			direction = -1;
		}
		else {
			direction++;
		}
	}

	public void turnLeft () {
		if (direction == -1) {
			direction = 2;
		}
		else {
			direction--;
		}
	}
}
