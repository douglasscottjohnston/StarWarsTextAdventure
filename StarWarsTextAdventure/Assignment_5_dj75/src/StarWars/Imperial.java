package StarWars;


/**A child of the Character class that has specialties that only Imperials can use
 * 
 * @author Douglas Johnston
 *
 */
public abstract class Imperial extends Character {
	private final String FULL_HEAL_MESSAGE = " healed to full health";
	
	private int myMinimumHeal;
	private int myMaximumHeal;
	private int myDefaultHp; //need this for the heal method to function properly
	private double myChanceToHeal;
	private StringBuilder myHealMessage = new StringBuilder(super.getCharacterName());
	
	protected Imperial(final String theName, final int theHp, final int theAttackSpeed, final double theHitChance, final int theLowDamageBound, final int theHighDamageBound, final String theHitMessage, final String theAttackMessage, final String theMissMessage, final double theChanceToHeal, final int theMinimumHeal, final int theMaximumHeal, final int theDefaultHp) {
		super(theName, theHp, theAttackSpeed, theHitChance, theLowDamageBound, theHighDamageBound, theHitMessage, theAttackMessage, theMissMessage);
		setChanceToHeal(theChanceToHeal);
		setMinimumHeal(theMinimumHeal);
		setMaximumHeal(theMaximumHeal);
		setDefaultHp(theDefaultHp);
	}
	
	/**A class that allows imperials to heal
	 * 
	 */
	protected void heal() {
		if(getHp() > 0) {
			int healAmmount = getHelper().getRandomInRange(getMaximumHeal(), getMinimumHeal());
			if(getHp() <= getDefaultHp() + healAmmount) {
				setHp(myDefaultHp);
				System.out.println(getCharacterName() + FULL_HEAL_MESSAGE);
			} else {
				setHp(getHp() + healAmmount);
				myHealMessage.append(" healed ");
				myHealMessage.append(healAmmount);
				myHealMessage.append(" health");
				System.out.println(myHealMessage);
			}
		}
	}
	
	@Override
	/**Checks if the imperial can heal and, if it can, passes the amount to the super attack class then heals
	 * and if it cannot it simply passes the amount to the super attack class
	 * 
	 * @param theAmount An int representing the amount of hit points to subtract
	 */
	protected void subtractHitPoints(final int theAmount) {
		System.out.println(getCharacterName() + " attempts to heal");
		if(getChanceToHeal() >= getHelper().getRandomInRange(1, 0)) {
			super.subtractHitPoints(theAmount);
			heal();
		} else {
			System.out.println(getCharacterName() + " failed to heal");
			super.subtractHitPoints(theAmount);
		}
	}
	
	/**An abstract class to be overridden in child classes of this method
	 * 
	 * @param theOpponent A rebel representing the opponent to perform the special skill on
	 */
	protected abstract void specialSkill(final Rebel theOpponent);
	
	/**Gets the chance to heal of the imperial
	 * 
	 * @return A double representing the chance to heal of the imperial
	 */
	public double getChanceToHeal() {
		return this.myChanceToHeal;
	}
	
	/**Sets the chance to heal of the imperial
	 * 
	 * @param theChanceToHeal A double representing the new chance to heal of the imperial
	 */
	public void setChanceToHeal(final double theChanceToHeal) {
		this.myChanceToHeal = theChanceToHeal;
	}
	
	/**Gets the minimum amount the imperial can heal
	 * 
	 * @return An int representing the minimum amount the imperial can heal
	 */
	public int getMinimumHeal() {
		return this.myMinimumHeal;
	}
	
	/**Sets  the minimum amount the imperial can heal
	 * 
	 * @param theMinimumHeal An int representing the new minimum amount the imperial can heal
	 */
	public void setMinimumHeal(final int theMinimumHeal) {
		this.myMinimumHeal = theMinimumHeal;
	}
	
	/**Gets the maximum amount the imperial can heal
	 * 
	 * @return An int representing the maximum amount the imperial can heal
	 */
	public int getMaximumHeal() {
		return this.myMaximumHeal;
	}
	
	/**Sets the maximum amount the imperial can heal
	 * 
	 * @param theMaximumHeal An int representing the new maximum amount the imperial can heal
	 */
	public void setMaximumHeal(final int theMaximumHeal) {
		this.myMaximumHeal = theMaximumHeal;
	}
	
	/**Gets the default hit points of the imperial
	 * 
	 * @return An int representing the default hit points of the imperial
	 */
	public int getDefaultHp() {
		return this.myDefaultHp;
	}
	
	/**Sets the default hit points of the imperial
	 * 
	 * @param theDefaultHp An int representing the new default hit points of the imperial
	 */
	public void setDefaultHp(final int theDefaultHp) {
		this.myDefaultHp = theDefaultHp;
	}
	
}
