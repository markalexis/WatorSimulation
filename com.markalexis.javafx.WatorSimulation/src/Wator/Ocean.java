/**
 * 
 */
package Wator;

import java.util.Random;

/**
 * @author markalexis
 *
 */
public class Ocean {

	/**
	 * 
	 */
	private Occupant[][] array;
    private int nRows;
    private int nColumns;
    private static Random rand = new Random();
    
	public Ocean(int nRows, int nColumns) {
		// Constructor
		//The ocean is an array of occupants (water, sharks, fish)
		array = new Occupant[nRows][nColumns];
        this.nRows = nRows;
        this.nColumns = nColumns;
		
	}
	
	public int getRowCount() { return nRows; }
	public int getColCount() { return nColumns; }
	Occupant[][] getArray() { return array; }
	
	
	
}
