package StarWars;

/**To print the dungeon during the movement select type map
 * 
 * @author Douglas Johnston
 *
 */
public class DungeonAdventure {
	
	private static Dungeon myDungeon = new Dungeon();
	private static Rebel myRebel;
	private static Helper myHelper = new Helper();
	private static String myGameInfo = "Star Wars: Star Destroyer Infiltration\nThe Rebels have inviltrated an Imperial star destroyer inorder to obtain two valuble jedi holocrons which\ncontain knowlege that could turn the tides of war into the Rebels favor\n";
	private static String myPickCharacterMessage = "Pick your character (1) luke (2) han (3) leia (4) chewbacca";
	
	public static void main(String args[]) {
		runGame();
	}
	
	
	public static void runGame() {
		boolean gameRunning = true;
		int location[] = myDungeon.getEntranceLocation();
		System.out.println(myGameInfo);
		myRebel = pickCharacter();
		System.out.println(myRebel.getCharacterName() + " has entered the star destroyer");
		while(gameRunning) {
			location = move(location);
			
			searchRoom(location);
			
			System.out.println("\n"+myRebel.toString());
			
			if(myRebel.getHealthPotions() > 0 || myRebel.getVisionPotions() > 0) {
				System.out.println("Would you like to use a potion? (1) Health Potion (2) Vision Potion (3) None");
				
				switch(myHelper.getScanner().nextInt()) {
				case 1:
					useHealthPotion();
					if(myRebel.getVisionPotions() > 0) {
						System.out.println("Would you like to use a vision potion? Y/N");
						switch(myHelper.getScanner().next()) {
						case "Y":
							useVisionPotion(location);
							break;
						case "y":
							useVisionPotion(location);
							break;
						default:
							break;
						}
						
					}
					break;
					
				case 2:
					if(myRebel.getVisionPotions() > 0) {
						useVisionPotion(location);
					} else {
						System.out.println("You do not have any vision potions");
					}
					
					System.out.println("Would you like to use a health potion? Y/N");
					switch(myHelper.getScanner().next()) {
					case "Y":
						useHealthPotion();
						break;
					case "y":
						useHealthPotion();
						break;
					case "N":
						break;
					case "n":
						break;
					}
				}
			}
			
			if(myDungeon.getRoom(location).getRoomType() == 'O' && myRebel.getHolocrons() == 2) {
				System.out.println(myRebel.getCharacterName() + " found both holocrons and sucessfully escaped");
				System.out.println("THANK YOU FOR PLAYING");
				System.out.println(myDungeon.toString());
				gameRunning = false;
				System.exit(0);
			}
		}
	}
	
	/**Asks the player which cardinal direction to move then uses the power of math to generate an array that contains the
	 * x and y locations of the room the player moved to
	 * 
	 * @param theLocation An array of two values whose first value is the y, and the second value is the x of what room the player is in
	 * @return
	 */
	public static int[] move(final int[] theLocation) {
		int[] newLocation = new int[2];
		System.out.println("The room " + myRebel.getCharacterName() + " is in");
		System.out.println(myDungeon.getDungeon()[theLocation[0]][theLocation[1]].toString());
		System.out.println("Would you like to move " + myDungeon.getDungeon()[theLocation[0]][theLocation[1]].getDoorLocation() + "?");
		switch(myHelper.getScanner().next()) {
		case "N":
			if(myDungeon.getRoom(theLocation).hasDoor("N")) {
				newLocation[0] = theLocation[0] - 1;
				newLocation[1] = theLocation[1];
				return newLocation;
			} else {
				throw myHelper.getIllegal();
			}
		case "E":
			if(myDungeon.getRoom(theLocation).hasDoor("E")) {
				newLocation[0] = theLocation[0];
				newLocation[1] = theLocation[1] + 1;
				return newLocation;
			} else {
				throw myHelper.getIllegal();
			}
		case "W":
			if(myDungeon.getRoom(theLocation).hasDoor("W")) {
				newLocation[0] = theLocation[0];
				newLocation[1] = theLocation[1] - 1;
				return newLocation;
			} else {
				throw myHelper.getIllegal();
			}
		case "S":
			if(myDungeon.getRoom(theLocation).hasDoor("S")) {
				newLocation[0] = theLocation[0] + 1;
				newLocation[1] = theLocation[1];
				return newLocation;
			} else {
				throw myHelper.getIllegal();
			}
		case "n":
			if(myDungeon.getRoom(theLocation).hasDoor("N")) {
				newLocation[0] = theLocation[0] - 1;
				newLocation[1] = theLocation[1];
				return newLocation;
			} else {
				throw myHelper.getIllegal();
			}
		case "e":
			if(myDungeon.getRoom(theLocation).hasDoor("E")) {
				newLocation[0] = theLocation[0];
				newLocation[1] = theLocation[1] + 1;
				return newLocation;
			} else {
				throw myHelper.getIllegal();
			}
		case "w":
			if(myDungeon.getRoom(theLocation).hasDoor("W")) {
				newLocation[0] = theLocation[0];
				newLocation[1] = theLocation[1] - 1;
				return newLocation;
			} else {
				throw myHelper.getIllegal();
			}
		case "s":
			if(myDungeon.getRoom(theLocation).hasDoor("S")) {
				newLocation[0] = theLocation[0] + 1;
				newLocation[1] = theLocation[1];
				return newLocation;
			} else {
				throw myHelper.getIllegal();
			}
		case "map":
			System.out.println(myDungeon.toString());
			return move(theLocation);
		default:
			throw myHelper.getIllegal();
			
		}
	}
	
	/**Starts the battle by randomly selecting an Imperial then the player and the imperial fight until the player defeats the imperial, the player runs away, or the player is defeated
	 * 
	 * @param theRebel A rebel representing the character the player chose
	 */
	public static void startBattle(final Rebel theRebel) {
		Imperial myImperial;
		int randomNumber = theRebel.getHelper().getRandomInRange(3, 0);
		if(randomNumber == 0) {
			myImperial = new Darth_Vader();
		} else if(randomNumber == 1) {
			myImperial = new Boba_Fett();
		} else if(randomNumber == 2) {
			myImperial = new Stormtrooper();
		} else {
			myImperial = new Dark_Trooper();
		}
		myHelper.getStringBuilder().setLength(0);
		myHelper.getStringBuilder().append(myImperial.getCharacterName());
		myHelper.getStringBuilder().append(" appears");
		System.out.println(myHelper.getStringBuilder());
		myHelper.getStringBuilder().setLength(0);
		
		boolean fighting = true;
		gameController : while(fighting) {
			int turns = theRebel.getAttackSpeed() / myImperial.getAttackSpeed();
			theRebel.attack(myImperial);
			for(int i = 1; i < turns;i++) { 
				theRebel.attack(myImperial); 
			}
			
			if(myImperial.getHp() <= 0) {
				System.out.println(theRebel.getCharacterName() + " defeated " + myImperial.getCharacterName());
				break gameController;
			} if(30 >= myImperial.getHelper().getRandomInRange(100, 0)){
				myImperial.specialSkill(theRebel);
			} else {
				myImperial.attack(theRebel);
			}
			
			if(theRebel.getHp() <= 0) {
				System.out.println(theRebel.getCharacterName() + " has been defeated \n GAME OVER");
				break gameController;
			}
			
			System.out.println(myImperial.getCharacterName() + "'s health: " + myImperial.getHp());
			System.out.println(theRebel.getCharacterName() + "'s health: " + theRebel.getHp());
			
			System.out.println("Would you like to run away? Y/N");
			
			switch(myHelper.getScanner().next()) { 
				case "Y": 
			  		break gameController;
			  	case "y": 
			  		break gameController;
			  	case "Yes":
			  		break gameController;
			  	case "yes": 
			  		break gameController;
			}
		}
	}
	
	/**Asks the player what character they would like to play as an returns their choice as a Rebel
	 * 
	 * @return A rebel representing the character the player chose
	 */
	public static Rebel pickCharacter() {
		System.out.println(myPickCharacterMessage);
		int characterChoice = myHelper.getScanner().nextInt();
		if(characterChoice == 1) {
			return new Luke_Skywalker();
		} else if(characterChoice == 2) {
			return new Han_Solo();
		} else if(characterChoice == 3) {
			return new Leia_Organa();
		} else if(characterChoice == 4) {
			return new Chewbacca();
		} else {
			throw myHelper.getIllegal();
		}
	}
	
	public static void searchRoom(final int[] theLocation) {
		switch(myDungeon.getRoom(theLocation).getRoomType()) {
		case 'E':
			System.out.println("The room is empty");
			myDungeon.getRoom(theLocation).setRoomType('S');
			break;
		case 'S':
			System.out.println(myRebel.getCharacterName() + " already searched this room");
			break;
		case 'X':
			System.out.println("There is an enemy in the room!");
			startBattle(myRebel);
			myDungeon.getRoom(theLocation).setRoomType('S');
			break;
		case 'P':
			System.out.println(myRebel.getCharacterName() + " fell into a pit");
			myRebel.subtractHitPoints(myHelper.getRandomInRange(20, 1));
			myDungeon.getRoom(theLocation).setRoomType('S');
			break;
		case 'I':
			System.out.println("The room is empty");
			myDungeon.getRoom(theLocation).setRoomType('S');
			break;
		case 'O':
			System.out.println("The room is empty");
			myDungeon.getRoom(theLocation).setRoomType('S');
			break;
		case 'V':
			System.out.println(myRebel.getCharacterName() + " found a vision potion");
			myRebel.setVisionPotions(myRebel.getVisionPotions() + 1);
			myDungeon.getRoom(theLocation).setVisionPotion(false);
			myDungeon.getRoom(theLocation).setRoomType('S');
			break;
		case 'H':
			System.out.println(myRebel.getCharacterName() + " found a healing potion");
			myRebel.setHealthPotions(myRebel.getHealthPotions() + 1);
			myDungeon.getRoom(theLocation).setHealthPotion(false);
			myDungeon.getRoom(theLocation).setRoomType('S');
			break;
		case 'M':
			if(myDungeon.getRoom(theLocation).hasPit()) {
				System.out.println(myRebel.getCharacterName() + " fell into a pit");
				myRebel.subtractHitPoints(myHelper.getRandomInRange(20, 1));
			}
			
			if(myDungeon.getRoom(theLocation).hasMonster()) {
				System.out.println("There is an enemy in the room!");
				startBattle(myRebel);
			}
			
			if(myDungeon.getRoom(theLocation).hasVisionPotion()) {
				System.out.println(myRebel.getCharacterName() + " found a vision potion");
				myRebel.setVisionPotions(myRebel.getVisionPotions() + 1);
				myDungeon.getRoom(theLocation).setVisionPotion(false);
			}
			
			if(myDungeon.getRoom(theLocation).hasHealthPotion()) {
				System.out.println(myRebel.getCharacterName() + " found a healing potion");
				myRebel.setHealthPotions(myRebel.getHealthPotions() + 1);
				myDungeon.getRoom(theLocation).setHealthPotion(false);
			}
			myDungeon.getRoom(theLocation).setRoomType('S');
			break;
		}
	}
	
	public static void useVisionPotion(final int[] theLocation) {
		int[] location = new int[2];
		myRebel.setVisionPotions(myRebel.getVisionPotions() - 1);
		myHelper.getStringBuilder().setLength(0);
		if(myDungeon.getRoom(theLocation).hasDoor("N")) {
			location[0] = theLocation[0] - 1;
			location[1] = theLocation[1];
			myHelper.getStringBuilder().append(" " + myDungeon.getRoom(location).getRoomType() + " \n");
		}
		
		if(myDungeon.getRoom(theLocation).hasDoor("W")) {
			location[0] = theLocation[0];
			location[1] = theLocation[1] - 1;
			myHelper.getStringBuilder().append("" + myDungeon.getRoom(location).getRoomType() + myDungeon.getRoom(theLocation).getRoomType());
		} else {
			myHelper.getStringBuilder().append(" " + myDungeon.getRoom(theLocation).getRoomType());
		}
		
		if(myDungeon.getRoom(theLocation).hasDoor("E")) {
			location[0] = theLocation[0];
			location[1] = theLocation[1] + 1;
			myHelper.getStringBuilder().append(myDungeon.getRoom(location).getRoomType());
		}
		
		if(myDungeon.getRoom(theLocation).hasDoor("S")) {
			location[0] = theLocation[0] + 1;
			location[1] = theLocation[1];
			myHelper.getStringBuilder().append("\n " + myDungeon.getRoom(location).getRoomType());
		}
		
		System.out.println("You can now see whats in the rooms connected to this room");
		System.out.println(myHelper.getStringBuilder().toString());
		myHelper.getStringBuilder().setLength(0);
	}
	
	public static void useHealthPotion() {
		int amount;
		System.out.println("How many? (In invantory: " + myRebel.getHealthPotions() + ")");
		amount = myHelper.getScanner().nextInt();
		if(amount > myRebel.getHealthPotions()) {
			System.out.println("That's more than in your invantory, try an ammount thats less than or equal to " + myRebel.getHealthPotions());
			amount = myHelper.getScanner().nextInt();
			if(amount > myRebel.getHealthPotions()) {
				throw myHelper.getIllegal();
			}
		} else {
			while(amount < 0) {
				myRebel.useHealthPotion();
				amount--;
			}
		}
	}
}
