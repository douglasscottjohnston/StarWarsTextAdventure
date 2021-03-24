package StarWars;

/**A child of the Rebel class containing the statistics of the character and its special abilities
 * 
 * @author Douglas Johnston
 *
 */

//equivalent to the thief class
public class Han_Solo extends Rebel {
	
	private static int myHp = 75;
	private static int myAttackSpeed = 6;
	private static int myMinimumDamage = 20;
	private static int myMaximumDamage = 40;
	private static int myShootFirstChance = 40;
	private static double myChanceToBlock = 0.4;
	private static double myChanceToHit = 0.8;
	private static String myCharacterName = "Han Solo";
	private static String myAttackMessage = "Han: \"Never tell me the odds!\"";
	private static String myHitMessage = "Han: \"I've got a bad feeling about this\"";
	private static String myMissMessage = "Han: \"Let's keep a little optimism here\"";
	private static String mySpecialSkillName = "shoot first";
	
	protected Han_Solo() {
		super(myCharacterName, myHp, myAttackSpeed, myChanceToHit, myMinimumDamage, myMaximumDamage, myHitMessage, myAttackMessage, myMissMessage, myChanceToBlock, mySpecialSkillName);
	}
	
	//equivalent to the supriseAttack method
	/**If the conditions are met Han_Solo will attack the passed character twice, if not it will print a "It misses" message
	 * 
	 * @param theOpponent A character representing the character the attack is performed on
	 */
	private void shootFirst(final Character theOpponent) {
		System.out.println("Han attemps to shoot first");
		if(myShootFirstChance > getHelper().getRandomInRange(getOneHundred(), getZero())) {
			System.out.println("Han shot first!");
			basicAttack(theOpponent);
			basicAttack(theOpponent);
		} else {
			System.out.println("It misses");
			System.out.println(myMissMessage);
		}
	}
	
	@Override
	/**Passes the parameter to the shootFirst method
	 * 
	 * @param theOpponent A character representing the character to pass to the shootFirst method
	 */
	public void specialAttack(final Character theOpponent) {
		shootFirst(theOpponent);
	}
	
}
