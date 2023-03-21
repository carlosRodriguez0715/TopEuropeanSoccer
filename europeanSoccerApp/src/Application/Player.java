/**
 * @author: Carlos Rodriguez
 * Class stores information about a soccer player. */

package Application;

public class Player {

	private String name, age, position, nationalTeam, currTeam;
	private double marketValue;
	
	/**
	 * Default constructor: No parameters passed therefore creates
	 * a Player object with values set to null. */
	public Player() {
		this.name = this.age = this.position = this.nationalTeam = this.currTeam = null;
		this.marketValue = -1.0;
	}
	
	/**
	 * Constructor parameter passing to create a player.
	 * @param name = name to register.
	 * @param age = age of the player.
	 * @param position = player's position.
	 * @param nationalTeam = current country the player represents.
	 * @param currTeam = current club.
	 * @param marketValue = actual market value. */
	public Player(String name, String age, String position, String nationalTeam, String currTeam, double marketValue) {
		this.name = name;
		this.age = age;
		this.position = position;
		this.nationalTeam = nationalTeam;
		this.currTeam = currTeam;
		this.marketValue = marketValue;
	}
	
	
	
}
