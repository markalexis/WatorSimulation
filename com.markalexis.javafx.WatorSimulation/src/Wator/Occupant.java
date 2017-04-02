/**
 * 
 */
package Wator;

import java.util.Random;



/**
 * @author markalexis
 *
 */
public abstract class Occupant {

	/** The row containing this Occupant. */
    int myRow;
    
    /** The column containing this Occupant.. */
    int myColumn;
    
    /** The number of time units this Occupant can survive without starving. */
    int timeToStarvation;
    
    /** The number of time units this Occupant. tries to give birth. */
    int timeToGestation;
    
    /** 
     * Whether this Occupant. has moved this turn. Each Denizen should be
     * permitted only one chance to move each turn, else it could move
     * a considerable distance.
     */
    boolean justMoved;
    private Random rand = new Random();
    
    
	public Occupant(int row, int column) {
		// TODO Auto-generated constructor stub
		myRow = row;
	    myColumn = column;
	}
	private Direction chooseRandomDirection() {
        int n = rand.nextInt(4);
        switch(n) {
            case 0: return Direction.LEFT;
            case 1: return Direction.RIGHT;
            case 2: return Direction.UP;
            default: return Direction.DOWN;
        }
    }
	
}
