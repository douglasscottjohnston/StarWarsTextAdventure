package StarWars;

/**A child of the Rebel class containing the statistics of the character and its special abilities
 * 
 * @author Douglas Johnston
 *
 */

//this is equivalent to the hero class
public class Luke_Skywalker extends Rebel {
	
	private int myForcePushHitChance = 40;
	private int myForcePushMinimumDamage = 75;
	private int myForcePushMaximumDamage = 175;
	
	
	private static int myHp = 125;
	private static int myAttackSpeed = 4;
	private static double myChanceToHit = 0.8;
	private static int myMinimumDamage = 35;
	private static int myMaximumDamage = 60;
	private static double myChanceToBlock = 0.2;
	private static String myCharacterName = "Luke Skywalker";
	private static String myAttackMessage = "Luke: \"You'll find I'm full of suprises\"";
	private static String myHitMessage = "Luke: \"No it's not true, that's imposible!\"";
	private static String myMissMessage = "Luke: \"Your overconfidence is your weakness\"";
	private static String mySpecialSkillName = "force push";
	//private String mySoundEffect = "forcePush.wav";
	
	protected Luke_Skywalker() {
		super(myCharacterName, myHp, myAttackSpeed, myChanceToHit, myMinimumDamage, myMaximumDamage, myHitMessage, myAttackMessage, myMissMessage, myChanceToBlock, mySpecialSkillName);
	}
	
	//equivalent to the crushing blow method
	/**Attempts to heavily damage the passed character and prints a "It missed" message if it cannot
	 * 
	 * @param theOpponent A Character that the attack is performed on
	 */
	private void forcePush(final Character theOpponent) {
		System.out.println("Luke attempts force push");
		if(this.myForcePushHitChance >= getHelper().getRandomInRange(getOneHundred(), getZero())) {
			int damage = getHelper().getRandomInRange(myForcePushMaximumDamage, myForcePushMinimumDamage);
			System.out.println("It dealt " + damage + " damage");
			//playSoundEffect(mySoundEffect);
			theOpponent.subtractHitPoints(damage);
			
			
		} else {
			System.out.println("It missed");
			System.out.println(myMissMessage);
		}
	}
	
	
	@Override
	/**Passes the parameter to the forcePush class
	 * 
	 * @param theOpponent A Character representing the character to pass to the forcePush method
	 */
	public void specialAttack(final Character theOpponent) {
		forcePush(theOpponent);
	}

}
