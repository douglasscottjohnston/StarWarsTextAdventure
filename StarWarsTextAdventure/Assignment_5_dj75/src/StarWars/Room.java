package StarWars;


/**
 * 
 * @author Douglas Johnston
 *
 */
public class Room {
	private char myRoomType;
	private Helper myHelper = new Helper();
	
	//true if the room contains the item
	private boolean myHealthPotion;
	private boolean myVisionPotion;
	private boolean myHolocron;
	private boolean myPit;
	private boolean myMonster;
	
	/*A string that contains the door locations for each room
	 * MUST be in this specific order
	 * 	N - North
	 * 	W - West
	 * 	S - South
	 * 	E - East
	 */
	private String myDoorLocation;
	
	/**A string containing all the possible types a room can be
	 *  I - Entrance (In)
	 *	O - Exit (Out)
	 *	E - Empty Room
	 *	X - Monster
	 *	P - Pit
	 *	V - Vision Potion
	 *	H - Healing Potion
	 *	M - Multiple Items
	 *	C - Holocron
	 *	R - Random(not including the entrance or exit)
	 *	S - The room was already searched
	 */
	private String possibleTypes = "IOEXPVHMCRS";
	
	/**The constructor for the Room class, it takes a char as a parameter
	 * 
	 * @param theRoomType A char representing the type of room this room should be
	 */
	Room(final char theRoomType, final String theDoorLocation){
		setRoomType(theRoomType);
		setDoorLocation(theDoorLocation);
		myHelper = new Helper();
		possibleTypes = "IOEXPVHMCRS";
	}
	
	/**Returns a char which represents what type of room this is
	 * 
	 * @return A char which represents what type of room this is
	 */
	public char getRoomType() {
		return this.myRoomType;
	}
	
	/**Sets the type of room from a list of possible types
	 * 
	 * @param theRoomType A char representing the type of room to set the room type to
	 */
	public void setRoomType(final char theRoomType) {
		if(possibleTypes.indexOf(theRoomType) < 0) {
			throw new IllegalArgumentException("The passed room type isn't possible");
		} else if(theRoomType == 'C') {
			this.myRoomType = theRoomType;
			setHolocron(true);
		} else if(theRoomType == 'R'){
			setRandomRoomType();
		} else {
			this.myRoomType = theRoomType;
		}
	}
	
	/**A helper method to set the room type to a random type
	 * 
	 */
	private void setRandomRoomType() {
		//The chance for the room to contain a health potion
		if(myHelper.percentChance(0.1f)) {
			if(isEmpty()) {
				this.myRoomType = 'H';
			} else {
				this.myRoomType = 'M';
			}
			setHealthPotion(true);
		}
		
		//The chance for the room to contain a vision potion
		if(myHelper.percentChance(0.5f)) {
			if(isEmpty()) {
				this.myRoomType = 'V';
			} else {
				this.myRoomType = 'M';
			}
			setVisionPotion(true);
		}
		
		//The chance for the room to contain a pit
		if(myHelper.percentChance(0.1f)) {
			if(isEmpty()) {
				this.myRoomType = 'P';
			} else {
				this.myRoomType = 'M';
			}
			setPit(true);
		}
		
		//The chance for the room to contain a monster
		if(myHelper.percentChance(0.1f)) {
			if(isEmpty()) {
				this.myRoomType = 'X';
			} else {
				this.myRoomType = 'M';
			}
			setMonster(true);
		}
		
		if(isEmpty()) {
			this.myRoomType = 'E';
		}
	}
	
	/**Returns a string representing the locations of all the doors in the room
	 * 
	 * @return A string representing the locations of all the doors in the room
	 */
	public String getDoorLocation() {
		return this.myDoorLocation;
	}
	
	/**Sets the door location string to the passed string, will throw an illegal argument exception if the passed string doesn't contain N, W, S, or E
	 * 
	 * @param theDoorLocation A string representing the locations to put a door in the room
	 */
	public void setDoorLocation(final String theDoorLocation) {
//		if(!theDoorLocation.contains("N") || !theDoorLocation.contains("W") || !theDoorLocation.contains("S") || !theDoorLocation.contains("E")) {
//			throw new IllegalArgumentException("The passed door location doesn't contain a NESW location");
//		} else {
			this.myDoorLocation = theDoorLocation;
//		}
	}
	
	/**Returns true if the room contains a health potion
	 * 
	 * @return True if the room contains a health potion, false otherwise
	 */
	public boolean hasHealthPotion() {
		return this.myHealthPotion;
	}
	
	/**Sets weather or not the room contains a health potion
	 * 
	 * @param theValue A boolean to determine if the room should contain a health potion
	 */
	public void setHealthPotion(final boolean theValue) {
		this.myHealthPotion = theValue;
	}
	
	/**Returns true if the room contains a vision potion
	 * 
	 * @return True if the room contains a vision potion, false otherwise
	 */
	public boolean hasVisionPotion() {
		return this.myVisionPotion;
	}
	
	/**Sets weather or not the room contains a vision potion
	 * 
	 * @param theValue A boolean to determine if the room should contain a vision potion
	 */
	public void setVisionPotion(final boolean theValue) {
		this.myVisionPotion = theValue;
	}
	
	/**Sets weather or not the room contains a holocron
	 * 
	 * @param theValue A boolean to determine if the room should contain a holocron
	 */
	public boolean hasHolocron() {
		return this.myHolocron;
	}
	
	/**Sets weather or not the room contains a holocron
	 * 
	 * @param theValue A boolean to determine if the room should contain a holocron
	 */
	public void setHolocron(final boolean theValue) {
		this.myHolocron = theValue;
	}
	
	/**Sets weather or not the room contains a pit
	 * 
	 * @param theValue A boolean to determine if the room should contain a pit
	 */
	public boolean hasPit() {
		return this.myPit;
	}
	
	/**Sets weather or not the room contains a pit
	 * 
	 * @param theValue A boolean to determine if the room should contain a pit
	 */
	public void setPit(final boolean theValue) {
		this.myPit = theValue;
	}
	
	/**Sets weather or not the room contains a monster
	 * 
	 * @param theValue A boolean to determine if the room should contain a monster
	 */
	public boolean hasMonster() {
		return this.myMonster;
	}
	
	/**Sets weather or not the room contains a monster
	 * 
	 * @param theValue A boolean to determine if the room should contain a monster
	 */
	public void setMonster(final boolean theValue) {
		this.myMonster = theValue;
	}
	
	/**A method that determines if the room contains anything
	 * 
	 * @return false if the room isn't empty, true otherwise
	 */
	private boolean isEmpty() {
		if(hasPit()||hasMonster()||hasHealthPotion()||hasVisionPotion()||hasHolocron()) {
			return false;
		} else {
			return true;
		}
	}
	
	/**A method to tell if the room has a door in a certain direction
	 * 
	 * @param theDirection A string representing the cardinal direction of a potential door
	 * @return true if the door location string contains the direction passed
	 */
	public boolean hasDoor(final String theDirection) {
		return getDoorLocation().contains(theDirection);
	}
	
	/**A helper method that returns a string with all the door locations
	 * 
	 * @return A string that visualizes all the door locations in the room
	 */
	private String doorLocationToString() {
		myHelper.getStringBuilder().setLength(0);
		if(getDoorLocation().contains("N")) {
			myHelper.getStringBuilder().append("*-*\n");
		} else {
			myHelper.getStringBuilder().append("***\n");
		}
		
		if(getDoorLocation().contains("W")) {
			myHelper.getStringBuilder().append("|");
		} else {
			myHelper.getStringBuilder().append("*");
		}
		
		if(getDoorLocation().contains("E")) {
			myHelper.getStringBuilder().append("|\n");
		} else {
			myHelper.getStringBuilder().append("*\n");
		}
		
		if(getDoorLocation().contains("S")) {
			myHelper.getStringBuilder().append("*-*");
		} else {
			myHelper.getStringBuilder().append("***");
		}
		
		String output = myHelper.getStringBuilder().toString();
		myHelper.getStringBuilder().setLength(0);
		return output;
	}
	
	
	@Override
	/**Creates a string representation of the room
	 * 
	 * @return A string representation of the room
	 */
	public String toString() {
		StringBuilder myRoom = new StringBuilder(doorLocationToString());
		myRoom.insert(5, getRoomType());
		return myRoom.toString();
				
	}
}
