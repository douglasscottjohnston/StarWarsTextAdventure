package StarWars;

/**A child of the Imperial class that contains all of the statistics of the imperial as well as its special abilities
 * 
 * @author Douglas Johnston
 *
 */

public class Dark_Trooper extends Imperial {
	private static int myHp = 150;
	private static int myAttackSpeed = 6;
	private static int myMinimumDamage = 40;
	private static int myMaximumDamage = 60;
	private static int myMinimumHeal = 50;
	private static int myMaximumHeal = 70;
	private static double myChanceToHit = 0.8;
	private static double myChanceToHeal = 0.3;
	private static String myCharacterName = "Dark Trooper";
	private static String myAttackMessage = "Dark Trooper: \"For the empire\"";
	private static String myHitMessage = "Dark Trooper: \"*Wilhelm scream*\"";
	private static String myMissMessage = "Dark Trooper: \"I will defeat you rebel scum\"";
	
	protected Dark_Trooper() {
		super(myCharacterName, myHp, myAttackSpeed, myChanceToHit, myMinimumDamage, myMaximumDamage, myHitMessage, myAttackMessage, myMissMessage, myChanceToHeal, myMinimumHeal, myMaximumHeal, myHp);
	}
	
	/**An attack that can only be partially blocked by the rebel
	 * If the conditions are met it will deal massive damage to the rebel
	 * 
	 * @param theOpponent A Rebel representing the rebel to perform the attack on
	 */
	private void sniperShot(final Rebel theOpponent) {
		System.out.println("The Dark Trooper shoots their sniper rifle at " + theOpponent.getCharacterName());
		if(theOpponent.getBlockChance() >= getHelper().getRandomInRange(1, 0)) {
			System.out.println(theOpponent.getCharacterName() + " partially dogged the attack");
			System.out.println(theOpponent.getCharacterName() + " took 20 damage");
			theOpponent.setHp(theOpponent.getHp() - 20);
		} else {
			System.out.println(theOpponent.getCharacterName() + " took 40 damage");
			theOpponent.setHp(theOpponent.getHp() - 40);
		}
	}
	
	@Override
	/**Passes the parameter to the sniperShot method
	 * 
	 * @param A rebel representing the rebel to pass to the sniperShot method
	 */
	protected void specialSkill(final Rebel theOpponent) {
		sniperShot(theOpponent);
	}
	
}
