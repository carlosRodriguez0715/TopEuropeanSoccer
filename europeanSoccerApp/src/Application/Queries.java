/**
 * @author: Carlos Rodriguez
 * Class handles the storing data from the CSV
 * files as well as sorting. */

package Application;
import java.util.ArrayList;

public class Queries {
	//Stores all players.
	private ArrayList<Player> foundPlayers;
	
	//Default Constructor
	public Queries() {
		this.foundPlayers = new ArrayList<Player>();
	}

	//Gets the list of all players
	public ArrayList<Player> getFoundPlayers() {
		return this.foundPlayers;
	}

	//Sets the list of players
	public void setFoundPlayers(ArrayList<Player> foundPlayers) {
		this.foundPlayers = foundPlayers;
	}
	

	
}
