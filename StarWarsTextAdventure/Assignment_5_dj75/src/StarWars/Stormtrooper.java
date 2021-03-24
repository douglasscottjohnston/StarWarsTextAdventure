package StarWars;

/**A child of the Imperial class that contains all of the statistics of the imperial as well as its special abilities
 * 
 * @author Douglas Johnston
 *
 */

//equivalent to the gremlin class
public class Stormtrooper extends Imperial{
	
	private static int myHp = 70;
	private static int myAttackSpeed = 5;
	private static int myMinimumDamage = 15;
	private static int myMaximumDamage = 30;
	private static int myMinimumHeal = 20;
	private static int myMaximumHeal = 40;
	private static int myPlasmaGrenadeDamage = 60;
	private static double myChanceToHit = 0.2; //I changed this because stormtroopers can't hit anything
	private static double myChanceToHeal = 0.4;
	private static String myCharacterName = "Stormtrooper";
	private static String myAttackMessage = "Stormtrooper: \"Rebels! Blast 'em\"";
	private static String myHitMessage = "Stormtrooper: \"*Wilhelm scream*\"";
	private static String myMissMessage = "Stormtrooper: \"Maybe it's just another drill\"";
	
	protected Stormtrooper() {
		super(myCharacterName, myHp, myAttackSpeed, myChanceToHit, myMinimumDamage, myMaximumDamage, myHitMessage, myAttackMessage, myMissMessage, myChanceToHeal, myMinimumHeal, myMaximumHeal, myHp);
	}
	
	/**An attack that can be reflected back at the Stormtrooper if the condition is met
	 * otherwise it will deal massive damage to the rebel
	 * 
	 * @param theOpponent A Rebel representing the rebel to perform the attack on
	 */
	private void plasmaGrenade(final Rebel theOpponent) {
		System.out.println("Stormtrooper throws a plasma grenade at " + theOpponent.getCharacterName());
		if(getHelper().getRandomInRange(1, 0) <= theOpponent.getBlockChance()) {
			System.out.println(theOpponent.getCharacterName() + " deflected the grenade back at the Stormtrooper");
			System.out.println("The Stormtroomer took " + 30 + " damage");
			subtractHitPoints(30);
		} else {
			System.out.println(theOpponent.getCharacterName() + " took " + myPlasmaGrenadeDamage);
			theOpponent.setHp(theOpponent.getHp() - myPlasmaGrenadeDamage);
		}
	}
	
	@Override
	/**Passes the parameter to the plasmaGrenade method
	 * 
	 * @param A Rebel representing the rebel to pass to the plasmaGrenade method
	 */
	protected void specialSkill(final Rebel theOpponent) {
		plasmaGrenade(theOpponent);
	}
	
}
