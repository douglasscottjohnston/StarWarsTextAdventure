package StarWars;

/**
 * 
 * @author Douglas Johnston
 *
 */
public class Dungeon {
	private final int MY_DUNGEON_WIDTH = 5;
	private final int MY_DUNGEON_HEIGHT = 5;
	
	/**An array whose first entry holds the y of the entrance and whose second entry holds the x of the entrance
	 * 
	 */
	private int[] myEntrance;
	
	private Helper myHelper;
	
	
	private Room[][] myDungeon;
	
	/**The constructor for the dungeon class, it creates the dungeon, sets the locations of the entrance, exit, and the holocrons
	 * 
	 */
	Dungeon(){
		myDungeon = new Room[MY_DUNGEON_HEIGHT][MY_DUNGEON_WIDTH];
		myEntrance = new int[2];
		myHelper = new Helper();
		
		//Fills the array with rooms that have random content
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(i == 0 && j == 0) {
					myDungeon[i][j] = new Room('R', "ES");//Sets the top left corner room
				} else if(i == 0 && j == 4) {
					myDungeon[i][j] = new Room('R', "SW");//Sets the top right corner room
				} else if(i == 0 && j > 0) {
					myDungeon[i][j] = new Room('R', "ESW");//Sets the top row of rooms
				} else if(i == 4 && j == 0) {
					myDungeon[i][j] = new Room('R', "NE");//Sets the bottom left corner room
				} else if(i > 0 && i < 4 && j == 0) {
					myDungeon[i][j] = new Room('R', "NES");//Sets the left column of rooms
				} else if(i == 4 && j == 4) {
					myDungeon[i][j] = new Room('R', "NW");//Sets the bottom right corner room
				} else if(i == 4 && j > 0 && j < 4) {
					myDungeon[i][j] = new Room('R', "NEW");//Sets the bottom row of rooms
				} else if(i > 0 && i < 4 && j == 4) {
					myDungeon[i][j] = new Room('R', "NSW");//Sets the right column of rooms
				} else {
					myDungeon[i][j] = new Room('R', "NESW");//Sets all other rooms
				}
			}
		}
		
		//Sets the entrance to a random spot on the bottom row of rooms excluding the corners
		int entranceX = myHelper.getRandomInRange(3, 1);
		myDungeon[4][entranceX].setRoomType('I');
		myEntrance[0] = 4;
		myEntrance[1] = entranceX;
		
		
		//Sets the exit to a random spot on the bottom row of rooms excluding the corners
		myDungeon[0][myHelper.getRandomInRange(3, 1)].setRoomType('O');
		
		//Sets A holocron in a random room in the dungeon excluding the top and bottom rows
		myDungeon[myHelper.getRandomInRange(3, 1)][myHelper.getRandomInRange(4, 0)].setRoomType('C');
		
		int randomY = myHelper.getRandomInRange(3, 1);
		int randomX = myHelper.getRandomInRange(4, 0);
		
		//Places the second holocron
		placeSecondHolocron(randomY, randomX);
	}
	
	
	/**Returns the dungeon 2D array
	 * 
	 * @return A 2D array of Room objects that represents the dungeon
	 */
	public Room[][] getDungeon(){
		return myDungeon;
	}
	
	/**Returns an array whose first entry holds the y of the entrance and whose second entry holds the x of the entrance
	 * 
	 * @return An array whose first entry holds the y of the entrance and whose second entry holds the x of the entrance
	 */
	public int[] getEntranceLocation() {
		return myEntrance;
	}
	
	/**Returns the room in the dungeon array at the passed location
	 * 
	 * @param theLocation An array with 2 values, it's first value should represent the Y and it's second value should represent the X of the location
	 * @return the room at that location in the array
	 */
	public Room getRoom(final int[] theLocation) {
		return myDungeon[theLocation[0]][theLocation[1]];
	}
	
	/**A recursive helper method that places the second holocron in a random room excluding the 
	 * top and bottom rows and makes sure that the selected room doesn't already have a holocron in it
	 * 
	 * @param theRandomX A random number between 1 and 3
	 * @param theRandomY A random number between 0 and 4
	 */
	private void placeSecondHolocron(final int theRandomX, final int theRandomY) {
		if(theRandomX < 1 || theRandomX > 3 || theRandomY < 0 || theRandomY > 4) {
			throw new IllegalArgumentException("The value is out of range for the dungeon array");
		}
		if(myDungeon[theRandomX][theRandomY].getRoomType() == 'C') {
			placeSecondHolocron(myHelper.getRandomInRange(3, 1), myHelper.getRandomInRange(4, 0));
		} else {
			myDungeon[theRandomX][theRandomY].setRoomType('C');
		}
	}
	
	@Override
	public String toString() {
		myHelper.getStringBuilder().setLength(0);
		for(int i = 0; i < MY_DUNGEON_WIDTH + 2; i++) {
			myHelper.getStringBuilder().append("*");
		}
		
		myHelper.getStringBuilder().append("\n");
		
		for(int j = 0; j < MY_DUNGEON_HEIGHT; j++) {
			myHelper.getStringBuilder().append("*");
			for(int k = 0; k < MY_DUNGEON_WIDTH; k++) {
				myHelper.getStringBuilder().append(myDungeon[j][k].getRoomType());
			}
			myHelper.getStringBuilder().append("*");
			myHelper.getStringBuilder().append("\n");
		}
		
		for(int i = 0; i < MY_DUNGEON_WIDTH + 2; i++) {
			myHelper.getStringBuilder().append("*");
		}
		
		String output = myHelper.getStringBuilder().toString();
		myHelper.getStringBuilder().setLength(0);
		return output;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
