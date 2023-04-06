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
	 * @param marketValue = actual market value (in millions) */
	public Player(String name, String age, String position, String nationalTeam, String currTeam, double marketValue) {
		this.name = name;
		this.age = age;
		this.position = position;
		this.nationalTeam = nationalTeam;
		this.currTeam = currTeam;
		this.marketValue = marketValue;
	}

	//Getters
	public String getName() {
		return this.name;
	}

	public String getAge() {
		return this.age;
	}

	public String getPosition() {
		return this.position;
	}

	public String getNationalTeam() {
		return this.nationalTeam;
	}

	public String getCurrTeam() {
		return this.currTeam;
	}

	public double getMarketValue() {
		return this.marketValue;
	}

	//Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setNationalTeam(String nationalTeam) {
		this.nationalTeam = nationalTeam;
	}

	public void setCurrTeam(String currTeam) {
		this.currTeam = currTeam;
	}

	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}
	
	//toString
	public String toString() {
		return String.format("Name: %s|Age: %s|Position: %s|National Team: %s|Current Team: %s|Market Value(in millions of Euros): %f", this.name, this.age,
				this.position, this.nationalTeam, this.currTeam, this.marketValue);
	}
	
	//equals
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Player)) {return false;}
		if(obj == this) {return true;}
		Player playerObj = (Player) obj;
		return this.name.equals(playerObj.name) && this.age.equals(playerObj.age) && this.position.equals(playerObj.position)
				&& this.nationalTeam.equals(playerObj.nationalTeam) && this.currTeam.equals(playerObj.currTeam) &&
				this.marketValue == playerObj.marketValue;
	}
	
	
}
