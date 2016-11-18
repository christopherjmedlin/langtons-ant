import java.awt.Point;

/**
 * Ant is a class that resembles an ant in a session of Langton's Ant.
 *
 * @author Christopher Medlin and Ivan Kenevich
 * @since Nov 17 2016
 */
public class Ant extends Point {
	
	
	//           IMPORTANT!!!! (READ THIS, SCUM)
	//     your enum didn't work for some reason - the ant didn't turn at all
	//     now, I know that the reason for that might be something else but
	//     I'm very confident that it was the enum that messed it up
	//     
	//     P.S.   out of my great respect for your coding skills, the original
	//     code is left commented out. If you wish to go back, delete the
	//     comment marks and whatever is TOUCHING (that is, immideately follows) the "end comment" (*/) mark
	//        
	//                                                  best wishes,
	//												retatded person
	
	
	
	
	
	
	
	
	
	
	
	private /*Direction*/int direction;
        
	/*private enum Direction {
		LEFT(-1), UP(0), RIGHT(1), DOWN(2);
		public int dir;
	
		private Direction (int dir) {
			this.dir = dir;
		}
	}*/
	
	public Ant (int x, int y) {
		super(x, y);
		direction = /*Direction.RIGHT*/1;
	}

	public void move () {
		if (direction == /*Direction.LEFT*/-1) {
			x--;
		}
		else if (direction == /*Direction.UP*/0) {
			y--;
		}
		else if (direction == /*Direction.RIGHT*/1) {
			x++;
		}
		else if (direction == /*Direction.DOWN*/2) {
			y++;
		}
	}

	public void turnRight () {
		if (direction/*.dir*/ == 2) {
			direction/*.dir*/ = -1;
		}
		else {
			direction/*.dir*/++;
		}
	}

	public void turnLeft () {
		if (direction/*.dir*/ == -1) {
			direction/*.dir*/ = 2;
		}
		else {
			direction/*.dir*/--;
		}
	}
}
