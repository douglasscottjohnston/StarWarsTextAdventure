package StarWars;

//commented out imports for sound effect extra credit
//import java.io.File;
//import javax.sound.sampled.AudioFormat;
//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
//import javax.sound.sampled.DataLine;
//import javax.sound.sampled.FloatControl;
//import javax.sound.sampled.LineEvent;


/**
 *  An abstract class which is used to create different characters that can fight each other
 * @author Douglas Johnston
 * 
 * @version JDK 13.0.2
 * 
 *
 */


//equivalent to dungeon character class
public abstract class Character {
	private final int MY_NO_DAMAGE_DEALT = 0;
	private final int MY_ZERO = 0;
	private final int MY_ONE_HUNDRED = 100;
	private final double ONE_HUNDRED_PERCENT = 1.0;
	
	private int myHp;
	private int myAttackSpeed;
	private int lowDamageBound;
	private int highDamageBound;
	private double myHitChance;
	private String myCharacterName;
	private String myHitMessage; //the message the character says after they are hit by an attack
	private String myAttackMessage; //the message the character says before they attack another character
	private String myMissMessage; //the message the character says after they miss an attack
	private Helper myHelper = new Helper();
	
	protected Character(final String theName, final int theHp, final int theAttackSpeed, final double theHitChance, final int theLowDamageBound, final int theHighDamageBound, final String theHitMessage, final String theAttackMessage, final String theMissMessage) {
		setCharacterName(theName);
		setHp(theHp);
		setAttackSpeed(theAttackSpeed);
		setHitChance(theHitChance);
		setLowDamageBound(theLowDamageBound);
		setHighDamageBound(theHighDamageBound);
		setHitMessage(theHitMessage);
		setAttackMessage(theAttackMessage);
		setMissMessage(theMissMessage);
	}
	
	/**Attacks the passed Character
	 * 
	 * @param theOpponent A Character representing the current opponent of the current character
	 */
	protected void attack(final Character theOpponent) {
		System.out.println(getCharacterName() + " atemps to attack " + theOpponent.getCharacterName());
		if(getHitChance() > myHelper.getRandomInRange(MY_ZERO, ONE_HUNDRED_PERCENT)) {
			System.out.println(getAttackMessage());
			int damage = myHelper.getRandomInRange(getHighDamageBound(), getLowDamageBound());
			if(damage <= 0) {
				StringBuilder noDamageMessage = new StringBuilder(getCharacterName());
				noDamageMessage.append(" dealt ");
				noDamageMessage.append(Integer.toString(MY_NO_DAMAGE_DEALT));
				noDamageMessage.append(" damage");
				System.out.println(noDamageMessage);
				
			} else {
				StringBuilder defaultMessage = new StringBuilder(getCharacterName());
				defaultMessage.append(" dealt ");
				defaultMessage.append(Integer.toString(damage));
				defaultMessage.append(" damage");
				System.out.println(defaultMessage);
				theOpponent.subtractHitPoints(damage);
				System.out.println(theOpponent.getHitMessage());
			}
			
		} else {
			System.out.println(getMissMessage());
			StringBuilder missedMessage = new StringBuilder(getCharacterName());
			missedMessage.append(" missed");
			System.out.println(missedMessage);
			
		}
		
	}
	
	/**Subtracts the passed amount of hit points from the current character
	 * 
	 * @param theAmount An int representing the amount of hit points to subtract
	 */
	protected void subtractHitPoints(final int theAmount) {
		if(theAmount <= 0) {
			System.out.println(this.getCharacterName() + " lost no health");
		} else {
			System.out.println(this.getCharacterName() + " lost " + theAmount + " health");
			this.myHp -= theAmount;
		}
	}
	
//	protected void playSoundEffect(final String theFilePath) {
//		try {
//			File mySoundEffectPath = new File(theFilePath);
//			if(mySoundEffectPath.exists()) {
//				AudioInputStream myAudioInput = AudioSystem.getAudioInputStream(mySoundEffectPath);
//				AudioFormat myFormat = myAudioInput.getFormat();
//				DataLine.Info myInfo = new DataLine.Info(Clip.class, myFormat);
//				Clip myClip = (Clip) AudioSystem.getLine(myInfo);
//				myClip.addLineListener(event -> {
//					if(LineEvent.Type.STOP.equals(event.getType())) {
//						myClip.close();
//					}
//				});
//				myClip.open(myAudioInput);
//				FloatControl myVolume = (FloatControl) myClip.getControl(FloatControl.Type.MASTER_GAIN);
//				myVolume.setValue(1.0f);
//				myClip.start();
//				do {
//					Thread.sleep(2000);
//				} while(myClip.isRunning());
//					myClip.drain();
//					myClip.close();
//					myAudioInput.close();
//			} else {
//				System.out.println("Can't find file");
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	/**Gets the MY_ZERO constant
	 * 
	 * @return the MY_ZERO constant
	 */
	
	protected final int getZero() {
		return this.MY_ZERO;
	}
	
	/**Gets the MY_ONE_HUNDRED constant
	 * 
	 * @return the MY_ONE_HUNDRED constant
	 */
	protected final int getOneHundred() {
		return this.MY_ONE_HUNDRED;
	}
	
	/**Gets the name of the character
	 * 
	 * @return A string representing the name of the character
	 */
	protected final String getCharacterName() {
		return this.myCharacterName;
	}
	
	/**Sets the name of the character
	 * 
	 * @param theCharacterName A string representing the new name of the character
	 */
	protected final void setCharacterName(final String theCharacterName) {
		this.myCharacterName = theCharacterName;
	}
	
	/**gets the hit points of the character
	 * 
	 * @return An int representing the hit points of the character
	 */
	protected final int getHp() {
		return this.myHp;
	}
	
	/**Sets the hit points
	 * 
	 * @param theHp An int representing the new hit points
	 */
	protected final void setHp(final int theHp) {
		this.myHp = theHp;
	}
	
	/**Gets the attack speed of the character
	 * 
	 * @return An int representing the attack speed of the character
	 */
	protected final int getAttackSpeed() {
		return this.myAttackSpeed;
	}
	
	/**Sets the attack speed of the character
	 * 
	 * @param theAttackSpeed An int representing the new attack speed
	 */
	protected final void setAttackSpeed(final int theAttackSpeed) {
		this.myAttackSpeed = theAttackSpeed;
	}
	
	/**Gets the chance to hit of the character
	 * 
	 * @return A double representing the chance to hit of the character
	 */
	protected final double getHitChance() {
		return myHitChance;
	}
	
	/**Sets the chance to hit of the character
	 * 
	 * @param theHitChance A double representing the new chance to hit of the character
	 */
	protected final void setHitChance(final double theHitChance) {
		this.myHitChance = theHitChance;
	}
	
	/**Gets the low damage bound of the character
	 * 
	 * @return An int representing the low damage bound of the character
	 */
	protected final int getLowDamageBound() {
		return this.lowDamageBound;
	}
	
	/**Sets the low damage bound of the character
	 * 
	 * @param theLowDamageBound An int representing the new low damage bound of the character
	 */
	protected final void setLowDamageBound(final int theLowDamageBound) {
		this.lowDamageBound = theLowDamageBound;
	}
	
	/**Gets the high damage bound of the character
	 * 
	 * @return An int representing the high damage bound of the character
	 */
	protected final int getHighDamageBound() {
		return this.highDamageBound;
	}
	
	/**Sets the high damage bound of the character
	 * 
	 * @param theHighDamageBound An int representing the new low damage bound of the character
	 */
	protected final void setHighDamageBound(final int theHighDamageBound) {
		this.highDamageBound = theHighDamageBound;
	}
	
	/**Gets the message the character plays when hit
	 * 
	 * @return A string representing the message the character plays when hit
	 */
	protected final String getHitMessage() {
		return this.myHitMessage;
	}
	
	/**Sets the message the character plays when hit
	 * 
	 * @param A string representing the new message the character plays when hit
	 */
	protected final void setHitMessage(final String theHitMessage) {
		this.myHitMessage = theHitMessage;
	}
	
	/**Gets the message the character plays when they attack
	 * 
	 * @return A string representing the message the character plays when they attack
	 */
	protected final String getAttackMessage() {
		return this.myAttackMessage;
	}
	
	/**Sets the message the character plays when they attack
	 * 
	 * @param theAttackMessage A string representing the new message the character plays when they attack
	 */
	protected final void setAttackMessage(final String theAttackMessage) {
		this.myAttackMessage = theAttackMessage;
	}
	
	/**Gets the message the character plays when they miss an attack
	 * 
	 * @return A string representing the message the character plays when they miss an attack
	 */
	protected final String getMissMessage() {
		return this.myMissMessage;
	}
	
	/**Sets the message the character plays when they miss an attack
	 * 
	 * @param theMissMessage A string representing the new message the character plays when they miss an attack
	 */
	protected final void setMissMessage(final String theMissMessage) {
		this.myMissMessage = theMissMessage;
	}
	
	public Helper getHelper() {
		return myHelper;
	}
}
