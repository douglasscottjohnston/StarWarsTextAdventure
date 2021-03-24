package StarWars;

import java.util.Random;
import java.util.Scanner;

/**A class to help other classes generate random numbers and many other functions
 * 
 * @author Douglas Johnston
 *
 */
public class Helper {
	private Random myRandom;
	private StringBuilder mySB;
	private Scanner myScanner;
	private IllegalArgumentException myIllegal;
	
	/**The constructor for the helper class, initializes all the fields
	 * 
	 */
	Helper(){
		myRandom = new Random();
		mySB = new StringBuilder();
		myScanner = new Scanner(System.in);
		myIllegal = new IllegalArgumentException("Invalid argument");
	}
	
	/**Takes a percent chance and returns true if the chance is greater than or equal to a randomly generated float
	 * 
	 * @param thePercentChance A float representing the chance to return true
	 * @return true if the chance is met, false otherwise
	 */
	public boolean percentChance(final float thePercentChance) {
		if(myRandom.nextFloat() <= thePercentChance) {
			return true;
		} else {
			return false;
		}
	}
	
	/**Gets a random int in the range of the passed ints
	 * 
	 * @param theHighBound An int representing the high bound of the range
	 * @param theLowBound An int representing the low bound of the range
	 * @return An int representing a random number found in the range
	 */
	public int getRandomInRange(final int theHighBound, final int theLowBound) {
		return this.myRandom.nextInt(theHighBound - theLowBound + 1) + theLowBound;
	}
	
	/**Gets a random double in the range of passed doubles
	 * 
	 * @param theHighBound A double representing the high bound of the range
	 * @param theLowBound A double representing the low bound of the range
	 * @return A double representing a random number found in the range
	 */
	public double getRandomInRange(final double theHighBound, final double theLowBound) {
		return theLowBound + (theHighBound - theLowBound) * this.myRandom.nextDouble();
	}
	
	/**Returns a string builder
	 * 
	 * @return A string builder
	 */
	public StringBuilder getStringBuilder() {
		return mySB;
	}
	
	/**Returns a scanner
	 * 
	 * @return A scanner
	 */
	public Scanner getScanner() {
		return myScanner;
	}
	
	/**Returns a illegal argument exception
	 * 
	 * @return A illegal argument exception
	 */
	public IllegalArgumentException getIllegal() {
		return myIllegal;
	}
}
