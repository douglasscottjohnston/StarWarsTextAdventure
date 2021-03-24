package StarWars;

/**A child of the Imperial class that contains all of the statistics of the imperial as well as its special abilities
 * 
 * @author Douglas Johnston
 *
 */

//equivalent to the ogre class
public class Darth_Vader extends Imperial {
	
	private static int myHp = 200;
	private static int myAttackSpeed = 2;
	private static int myMinimumDamage = 30;
	private static int myMaximumDamage = 60;
	private static int myMinimumHeal = 30;
	private static int myMaximumHeal = 60;
	private int myForceChokeDamage = 70;
	private static double myChanceToHit = 0.6;
	private static double myChanceToHeal = 0.1;
	private static String myCharacterName = "Darth Vader";
	private static String myAttackMessage = "Darth Vader: \"You don't know the power of the dark side\"";
	private static String myHitMessage = "Darth Vader: \"NOOOOOO\"";
	private static String myMissMessage = "Darth Vader: \"I find your lack of faith disturbing\"";
	
	protected Darth_Vader() {
		super(myCharacterName, myHp, myAttackSpeed, myChanceToHit, myMinimumDamage, myMaximumDamage, myHitMessage, myAttackMessage, myMissMessage, myChanceToHeal, myMinimumHeal, myMaximumHeal, myHp);
	}
	
	/**An attack that can only be partially blocked by the rebel
	 * If the conditions are met it will deal massive damage to the rebel
	 * 
	 * @param theOpponent A Rebel representing the rebel to perform the attack on
	 */
	private void forceChoke(final Rebel theOpponent) {
		System.out.println("Darth Vader force chokes " + theOpponent.getCharacterName());
		if(getHelper().getRandomInRange(1, 0) <= theOpponent.getBlockChance()) {
			theOpponent.setHp(theOpponent.getHp() - myForceChokeDamage/2);
			System.out.println(theOpponent.getCharacterName() + " partially blocked the attack!");
			System.out.println(theOpponent.getCharacterName() + " took " + (myForceChokeDamage/2) + " damage");
		} else {
			theOpponent.setHp(theOpponent.getHp() - myForceChokeDamage);
			System.out.println(theOpponent.getCharacterName() + " took " + myForceChokeDamage + " damage");
		}
	}
	
	@Override
	/**Passes the parameter to the forceChoke method
	 * 
	 * @param theOpponent A Rebel representing the rebel to pass to the forceChoke method
	 */
	protected void specialSkill(final Rebel theOpponent) {
		forceChoke(theOpponent);
	}
	
}
