package StarWars;

import java.util.Scanner;

/**Runs the game until the player defeats the imperial, the player runs away, or the player is defeated
 * 
 * @author Douglas Johnston
 *
 */

public class RunGame {
	private static boolean myGameRunning = true;
	private static boolean myExicute = false;
	private static Scanner myScanner = new Scanner(System.in);
	private static StringBuilder myMessage = new StringBuilder();
	private static String myPickCharacterMessage = "Pick your character (1) luke (2) han (3) leia (4) chewbacca";
	private static IllegalArgumentException myIllegal = new IllegalArgumentException("The entry was invalid");
	private static String myAnswer;
	
	/**If the game hasn't already been started then it runs the game
	 * 
	 */
	public static void main(String[] args) {
		if(!myExicute) {
			myExicute = true;
			runGame();
		}
		
	}
	
	/**Calls startBattle and pickCharacter and sets myGameRunning to true
	 * 
	 */
	private static void runGame() {
		myGameRunning = true;
		startBattle(pickCharacter());
	}
	
	/**Stops the game and terminates the program
	 * 
	 */
	private static void endGame() {
		myGameRunning = false;
		System.out.println("Thank you for playing!");
		System.exit(0);
	}
	
	/**Asks the player what character they would like to play as an returns their choice as a Rebel
	 * 
	 * @return A rebel representing the character the player chose
	 */
	public static Rebel pickCharacter() {
		System.out.println(myPickCharacterMessage);
		int characterChoice = myScanner.nextInt();
		if(characterChoice == 1) {
			return new Luke_Skywalker();
		} else if(characterChoice == 2) {
			return new Han_Solo();
		} else if(characterChoice == 3) {
			return new Leia_Organa();
		} else if(characterChoice == 4) {
			return new Chewbacca();
		} else {
			throw myIllegal;
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
		myMessage.append(myImperial.getCharacterName());
		myMessage.append(" appears");
		System.out.println(myMessage);
		myMessage.setLength(0);
		
		gameController : while(myGameRunning) {
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
			myAnswer = myScanner.next();
			
			switch(myAnswer) { 
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
		System.out.println("Would you like to play again? Y/N");
		myAnswer = myScanner.next();
		
		  switch(myAnswer){ 
		  	case "Y":
		  		startBattle(pickCharacter()); 
		  	case "y":
		  		startBattle(pickCharacter()); 
		  	case "Yes":
			  startBattle(pickCharacter()); 
		  	case"yes":
		  		startBattle(pickCharacter());
		  	case "N":
		  		endGame();
		  	case "n":
		  		endGame();
		  	case "No":
		  		endGame();
		  	case "no":
		  		endGame();
		  	default: 
		  		throw myIllegal;
		  	}
		 
	}
	
}
