package StarWars;

/**A child of the character class that has specialties that only children of this class can use
 * 
 * 
 * 
 * @author Douglas Johnston
 * 
 * @version JDK 13.0.2
 * 
 * 
 *
 */

//equivalent to the hero class
public abstract class Rebel extends Character {
	
	private double myBlockChance;
	private String mySpeacialSkillName;
	private int myDefaultHp;
	private int myHealthPotions;
	private int myVisionPotions;
	private int myHolocrons;//Equivalent to crown pieces
	
	public Rebel(final String theName, final int theHp, final int theAttackSpeed, final double theHitChance, final int theLowDamageBound, final int theHighDamageBound, final String theHitMessage, final String theAttackMessage, final String theMissMessage, final double theBlockChance, final String theSpecialSkillName) {
		super(theName, theHp, theAttackSpeed, theHitChance, theLowDamageBound, theHighDamageBound, theHitMessage, theAttackMessage, theMissMessage);
		myDefaultHp = theHp;
		setBlockChance(theBlockChance);
		setSpecialSkillName(theSpecialSkillName);
	}
	
	@Override
	/**Attacks the passed character
	 * @param theOpponent a Character that the current rebel attacks
	 * 
	 */
	public void attack(final Character theOpponent) { //asks the player if they want to use a special attack and if they do then the method returns -1
		StringBuilder attackChoiceMessage = new StringBuilder("Type 1 to attack, 2 to use ");
		attackChoiceMessage.append(getSpecialSkillName());
		System.out.println(attackChoiceMessage);
		int theAttackChoice = getHelper().getScanner().nextInt();
		
		if(theAttackChoice == 1) {
			super.attack(theOpponent);
			
		} else if(theAttackChoice == 2) {
			specialAttack(theOpponent);
			
		} else {
			throw getHelper().getIllegal();
			
		}
	}
	
	@Override
	/**Doesn't subtract hit points if it is blocked otherwise passes the amount to the super subtractHitPoints class
	 * @param theAmount the amount of hit points to be subtracted
	 * 
	 */
	public void subtractHitPoints(final int theAmount) {
		if(getHelper().getRandomInRange(100, 0) <= myBlockChance) {
			System.out.println(super.getCharacterName() + " blocked the attack!");
		} else {
			super.subtractHitPoints(theAmount);
		}
	}
	
	/**An abstract method to be overridden in child classes
	 * 
	 * @param theOpponent the character to perform the attack on
	 */
	public abstract void specialAttack(final Character theOpponent);
	
	/**A method so that children of this class can access the super class attack method more easily
	 * 
	 * @param theOpponent the character to perform the attack on
	 */
	public void basicAttack(final Character theOpponent) {
		super.attack(theOpponent);
	}
	
	public void useHealthPotion() {
		if(getHp() > 0) {
			int healAmmount = getHelper().getRandomInRange(15, 5);
			if(getHp() <= myDefaultHp + healAmmount) {
				setHp(myDefaultHp);
				System.out.println(getCharacterName() + " healed to full health");
			} else {
				setHp(getHp() + healAmmount);
				getHelper().getStringBuilder().setLength(0);
				getHelper().getStringBuilder().append(" healed ");
				getHelper().getStringBuilder().append(healAmmount);
				getHelper().getStringBuilder().append(" health");
				System.out.println(getHelper().getStringBuilder().toString());
				getHelper().getStringBuilder().setLength(0);
				setHealthPotions(getHealthPotions() - 1);
			}
		}
	}
	
	/**Gets the block chance of the current rebel
	 * @return A double representing the block chance
	 */
	public double getBlockChance() {
		return this.myBlockChance;
	}
	
	/**Sets the block chance of the current rebel
	 * 
	 * @param theBlockChance a double representing the new block chance
	 */
	public void setBlockChance(final double theBlockChance) {
		this.myBlockChance = theBlockChance;
	}
	
	/**Gets the special skill name
	 * 
	 * @return A string representing the special skill name
	 */
	public String getSpecialSkillName() {
		return this.mySpeacialSkillName;
	}
	
	/**Sets the special skill name
	 * 
	 * @param theSpecialSkillName A string representing the new special skill name
	 */
	public void setSpecialSkillName(String theSpecialSkillName) {
		this.mySpeacialSkillName = theSpecialSkillName;
	}
	
	/**Returns a number representing the amount of health potions this rebel has
	 * 
	 * @return A number representing the amount of health potions this rebel has
	 */
	public int getHealthPotions() {
		return this.myHealthPotions;
	}
	
	/**Sets the number of health potions the rebel has to the passed amount
	 * 
	 * @param theHealthPotions A number representing the new amount of potions the rebel will have
	 */
	public void setHealthPotions(final int theHealthPotions) {
		this.myHealthPotions = theHealthPotions;
	}
	
	/**Returns a number representing the amount of vision potions this rebel has
	 * 
	 * @return A number representing the amount of vision potions this rebel has
	 */
	public int getVisionPotions() {
		return this.myVisionPotions;
	}
	
	/**Sets the number of vision potions the rebel has to the passed amount
	 * 
	 * @param theVisionPotions A number representing the new amount of potions the rebel will have
	 */
	public void setVisionPotions(final int theVisionPotions) {
		myVisionPotions = theVisionPotions;
	}
	
	/**Returns an int representing the number of holocrons the rebel has
	 * 
	 * @return An int representing the number of holocrons the rebel has
	 */
	public int getHolocrons() {
		return myHolocrons;
	}
	
	/**Sets the number of holocrons to the passed input
	 * 
	 * @param theHolocrons An int representing the new number of holocrons the rebel has
	 */
	public void setHolocrons(final int theHolocrons) {
		myHolocrons = theHolocrons;
	}
	
	@Override
	/**Returns a string representation of all the information about the rebel
	 * 
	 * @return A string representation of all the information about the rebel
	 */
	public String toString() {
		getHelper().getStringBuilder().setLength(0);
		getHelper().getStringBuilder().append(getCharacterName() + "\n");
		getHelper().getStringBuilder().append("Health: ");
		getHelper().getStringBuilder().append(getHp() + "\n");
		getHelper().getStringBuilder().append("Health Potions: ");
		getHelper().getStringBuilder().append(getHealthPotions() + "\n");
		getHelper().getStringBuilder().append("Vision Potions: ");
		getHelper().getStringBuilder().append(getVisionPotions() + "\n");
		getHelper().getStringBuilder().append("Holocrons: ");
		getHelper().getStringBuilder().append(getHolocrons() + "\n");
		
		String output = getHelper().getStringBuilder().toString();
		getHelper().getStringBuilder().setLength(0);
		return output;
	}
}
