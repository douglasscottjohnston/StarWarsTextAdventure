package StarWars;

/**A child of the Imperial class that contains all of the statistics of the imperial as well as its special abilities
 * 
 * @author Douglas Johnston
 *
 */

//equivalent to the skeleton class
public class Boba_Fett extends Imperial{
	
	private static int myHp = 100;
	private static int myAttackSpeed = 3;
	private static int myMinimumDamage = 30;
	private static int myMaximumDamage = 50;
	private static int myMinimumHeal = 30;
	private static int myMaximumHeal = 50;
	private static int myRocketPackDamage = 65;
	private static double myChanceToHit = 0.8;
	private static double myChanceToHeal = 0.3;
	private static String myCharacterName = "Boba Fett";
	private static String myAttackMessage = "Boba Fett: \"You're no good to me dead\"";
	private static String myHitMessage = "Boba Fett: \"*Wilhelm scream*\"";
	private static String myMissMessage = "Boba Fett: \"You can run but you'll only die tired\"";
	
	protected Boba_Fett() {
		super(myCharacterName, myHp, myAttackSpeed, myChanceToHit, myMinimumDamage, myMaximumDamage, myHitMessage, myAttackMessage, myMissMessage, myChanceToHeal, myMinimumHeal, myMaximumHeal, myHp);
	}
	
	/**An attack that can directly land or completely miss, if it directly lands the rebel will take massive damage
	 * 
	 * @param theOpponent A Rebel representing the rebel to perform the attack on
	 */
	private void rocketPack(final Rebel theOpponent) {
		System.out.println("Boba Fett shoots his rocket pack at " + theOpponent.getCharacterName());
		if(getHelper().getRandomInRange(1, 0) <= theOpponent.getBlockChance()) {
			System.out.println(theOpponent.getCharacterName() + " doged the rocket and took no damage");
		} else {
			System.out.println("It directly hits " + theOpponent.getCharacterName());
			System.out.println(theOpponent.getCharacterName() + " took " + myRocketPackDamage + " damage");
			theOpponent.setHp(theOpponent.getHp() - myRocketPackDamage);
		}
	}
	
	@Override
	/**Passes the parameter to the rocketPack method
	 * 
	 * @param A Rebel representing the rebel to pass to the rocketPass method
	 */
	protected void specialSkill(final Rebel theOpponent) {
		rocketPack(theOpponent);
	}
	
}
