/**
 * @author: Carlos Rodriguez
 * Class handles the storing data from the CSV
 * files as well as sorting. */

package Application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Queries {
	//Stores all players.
	private ArrayList<Player> foundPlayers;
	
	//Default Constructor
	public Queries() {
		try {
			this.foundPlayers = new ArrayList<Player>();
			registerPlayersFromCSV();
		}
		catch(IOException e) {
			System.out.println("File 'players.CSV' not found, program can no longer run");
			e.printStackTrace();
			System.exit(0);
		}
	}

	//Gets the list of all players
	public ArrayList<Player> getFoundPlayers() {
		return this.foundPlayers;
	}

	//Sets the list of players
	public void setFoundPlayers(ArrayList<Player> foundPlayers) {
		this.foundPlayers = foundPlayers;
	}
	
	private void registerPlayersFromCSV() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("players.CSV"));
		String read = br.readLine();
		if(read == null) {br.close(); throw new IOException();}
		else {
			String[] data = read.split(",");
			if(data.length < 6) {System.out.println("Missing data, exiting program."); System.exit(0);}
			Player pl = new Player(data[0], data[1], data[2], data[3], data[4], Double.parseDouble(data[5]));
			foundPlayers.add(pl);
			
			while((read = br.readLine()) != null) {
				data = read.split(",");
				if(data.length < 6) {System.out.println("Missing data, exiting program."); System.exit(0);}
				pl.setName(data[0]);
				pl.setAge(data[1]);
				pl.setPosition(data[2]);
				pl.setNationalTeam(data[3]);
				pl.setCurrTeam(data[4]);
				pl.setMarketValue(Double.parseDouble(data[5]));
				foundPlayers.add(pl);
			}
		}
		br.close();
	}
	
	public void sortByTeam() {
		this.foundPlayers.sort((o1, o2) -> o1.getCurrTeam().compareTo(o2.getCurrTeam()));
	}
	
	public void sortByAge() {
		this.foundPlayers.sort((o1, o2) -> o1.getAge().compareTo(o2.getAge()));
	}
	
	public void sortByPosition() {
		this.foundPlayers.sort((o1, o2) -> o1.getPosition().compareTo(o2.getPosition()));
	}
	

	
}
