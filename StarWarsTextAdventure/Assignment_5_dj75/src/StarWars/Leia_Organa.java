package StarWars;

/**A child of the Rebel class containing the statistics of the character and its special abilities
 * 
 * @author Douglas Johnston
 *
 */

//equivalent to the sorceress method
public class Leia_Organa extends Rebel {
	
	private final String FULL_HEAL_MESSAGE = "Leia healed to full health";
	
	
	private int myMinimumHeal = 5;
	private int myMaximumHeal = 15;
	private StringBuilder myHealMessage = new StringBuilder("Healed ");
	
	private static int myHp = 75;
	private static int myAttackSpeed = 5;
	private static int myMinimumDamage = 25;
	private static int myMaximumDamage = 45;
	private static double myChanceToHit = 0.7;
	private static double myChanceToBlock = 0.3;
	private static String myCharacterName = "Leia Organa";
	private static String myAttackMessage = "Leia: \"Someone has to save our skins\"";
	private static String myHitMessage = "Leia: \"Why, you stuck-up, half-witted, scruffy-looking nerf herder!\"";
	private static String myMissMessage = "Leia: \"Help me Obi-Wan Kenobi, you're my only hope\"";
	private static String mySpecialSkillName = "heal";
	
	protected Leia_Organa() {
		super(myCharacterName, myHp, myAttackSpeed, myChanceToHit, myMinimumDamage, myMaximumDamage, myHitMessage, myAttackMessage, myMissMessage, myChanceToBlock, mySpecialSkillName);
	}
	
	/**A method to heal Leia_Organa, if she is already at max health then she will heal no hit points
	 * 
	 */
	private void heal() {
		System.out.println("Leia attemps to heal");
		if(getHp() < myHp) {
			int healAmmount = getHelper().getRandomInRange(myMaximumHeal, myMinimumHeal);
			if(super.getHp() + healAmmount >= myHp) {
				super.setHp(myHp);
				System.out.println(FULL_HEAL_MESSAGE);
			} else {
				super.setHp(super.getHp() + healAmmount);
				myHealMessage.append(healAmmount);
				myHealMessage.append(" health points");
				System.out.println(myHealMessage);
				myHealMessage.setLength(0);
			}
		}
	}
	
	@Override
	/**Calls the heal class
	 * 
	 * @param An unused Character
	 */
	public void specialAttack(final Character theOpponent){
		heal();
	}
	
}
