package StarWars;

/**A child of the Rebel class containing the statistics of the character and its special abilities
 * 
 * @author Douglas Johnston
 *
 */

public class Chewbacca extends Rebel {
	private static int myHp = 150;
	private static int myAttackSpeed = 2;
	private static double myChanceToHit = 0.4;
	private static int myMinimumDamage = 40;
	private static int myMaximumDamage = 100;
	private static double myChanceToBlock = 0.2;
	private static String myCharacterName = "Chewbacca";
	private static String myAttackMessage = "Chewbacca: \"UUUUURRRRR\"";
	private static String myHitMessage = "Chewbacca: \"AAAHHUUUURRR\"";
	private static String myMissMessage = "Chewbacca: \"EEEUUUURRR\"";
	private static String mySpecialSkillName = "wookie strength";
	private boolean myAbilityUsed = false;
	
	protected Chewbacca() {
		super(myCharacterName, myHp, myAttackSpeed, myChanceToHit, myMinimumDamage, myMaximumDamage, myHitMessage, myAttackMessage, myMissMessage, myChanceToBlock, mySpecialSkillName);
	}
	
	/**If the conditions are met this attack will deal massive damage and permanently half the attack of the opponent but can only be performed once, otherwise it will print an "It misses" message
	 * If the attack has already been used it will print a message saying "Chewbacca is too tired, instead he attacks normally"
	 * 
	 * @param theOpponent 
	 */
	private void wookieStrength(final Character theOpponent) {
		System.out.println("Chewbacca atemps to use his wookie strength to rip " + theOpponent.getCharacterName() + "'s arm off");
		if(!myAbilityUsed) {
			if(30 >= getHelper().getRandomInRange(100, 0)) {
				System.out.println("Chewbacca ripped " + theOpponent.getCharacterName() + "'s arm off");
				theOpponent.subtractHitPoints(50);
				theOpponent.setHighDamageBound(theOpponent.getHighDamageBound()/2);
				theOpponent.setLowDamageBound(theOpponent.getLowDamageBound()/2);
				System.out.println(theOpponent.getCharacterName() + "'s attack is permenently halfed they should've let the wookie win");
				myAbilityUsed = true;
			} else {
				System.out.println("It misses");
			}
		} else  {
			System.out.println("Chewbacca is too tired, instead he attacks normally");
			attack(theOpponent);
		}
	}
	
	@Override
	/**Passes the parameter to the wookieStrength method
	 * 
	 * @param theOpponent A Character representing the character to pass to the wookieStrength method
	 */
	public void specialAttack(final Character theOpponent) {
		wookieStrength(theOpponent);
	}
	
}
