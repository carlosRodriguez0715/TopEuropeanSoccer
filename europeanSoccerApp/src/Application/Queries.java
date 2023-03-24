/**
 * @author: Carlos Rodriguez
 * Class handles the storing data from the CSV
 * files as well as sorting. */

package Application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Queries extends Thread{
	//Stores all players.
	private ArrayList<Player> foundPlayers;
	
	//Default Constructor
	public Queries() {
		run();
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
	
	private void sortByTeam(ArrayList<Player> al) {
		al.sort((o1, o2) -> o1.getCurrTeam().compareTo(o2.getCurrTeam()));
	}
	
	private void sortByAge(ArrayList<Player> al) {
		al.sort((o1, o2) -> o1.getAge().compareTo(o2.getAge()));
	}
	
	private void sortByPosition(ArrayList<Player> al) {
		al.sort((o1, o2) -> o1.getPosition().compareTo(o2.getPosition()));
	}
	
	private void sortByName(ArrayList<Player> al) {
		al.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
	}
	
	public ArrayList<Player> searchByTeam(String team){
		if(team == null) {return null;}
		sortByTeam(this.foundPlayers);
		//Some type of binary search
		int leftIdx = 0;
		int rightIdx = this.foundPlayers.size() - 1;
		int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
		boolean found = false;
		ArrayList<Player> sublist = new ArrayList<Player>();
		while(leftIdx <= rightIdx && found == false) {
			if(team.equals(this.foundPlayers.get(midIdx).getCurrTeam())) {
				found = true;
				sublist.add(this.foundPlayers.get(midIdx));
			}
			else {
				if(team.compareTo(this.foundPlayers.get(midIdx).getCurrTeam()) > 0) {
					leftIdx = midIdx + 1;
				}
				else {
					rightIdx = midIdx - 1;
				}
				midIdx = leftIdx + (rightIdx - leftIdx) / 2;
			}
		}
		if(found == false) {return null;}
		//Left Traversal
		int leftLimit = midIdx - 1;
		while(leftLimit >= 0 && team.equals(this.foundPlayers.get(leftLimit).getCurrTeam())) {
			sublist.add(this.foundPlayers.get(leftLimit));
			leftLimit--;
		}
		//Right Traversal
		int rightLimit = midIdx + 1;
		while(rightLimit < this.foundPlayers.size() && team.equals(this.foundPlayers.get(rightLimit).getCurrTeam())) {
			sublist.add(this.foundPlayers.get(rightLimit));
			rightLimit++;
		}
		sortByName(sublist);
		return sublist;
	}
	
	public ArrayList<Player> searchByAge(String age){
		if(age == null) {return null;}
		sortByAge(this.foundPlayers);
		//Some type of binary search
		int leftIdx = 0;
		int rightIdx = this.foundPlayers.size() - 1;
		int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
		boolean found = false;
		ArrayList<Player> sublist = new ArrayList<Player>();
		while(leftIdx <= rightIdx && found == false) {
			if(age.equals(this.foundPlayers.get(midIdx).getAge())) {
				found = true;
				sublist.add(this.foundPlayers.get(midIdx));
			}
			else {
				if(age.compareTo(this.foundPlayers.get(midIdx).getAge()) > 0) {
					leftIdx = midIdx + 1;
				}
				else {
					rightIdx = midIdx - 1;
				}
				midIdx = leftIdx + (rightIdx - leftIdx) / 2;
			}
		}
		if(found == false) {return null;}
		//Left Traversal
		int leftLimit = midIdx - 1;
		while(leftLimit >= 0 && age.equals(this.foundPlayers.get(leftLimit).getAge())) {
			sublist.add(this.foundPlayers.get(leftLimit));
			leftLimit--;
		}
		//Right Traversal
		int rightLimit = midIdx + 1;
		while(rightLimit < this.foundPlayers.size() && age.equals(this.foundPlayers.get(rightLimit).getAge())) {
			sublist.add(this.foundPlayers.get(rightLimit));
			rightLimit++;
		}
		sortByName(sublist);
		return sublist;
	}
	
	public ArrayList<Player> searchByPosition(String pos){
		if(pos == null) {return null;}
		sortByPosition(this.foundPlayers);
		//Some type of binary search
		int leftIdx = 0;
		int rightIdx = this.foundPlayers.size() - 1;
		int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
		boolean found = false;
		ArrayList<Player> sublist = new ArrayList<Player>();
		while(leftIdx <= rightIdx && found == false) {
			if(pos.equals(this.foundPlayers.get(midIdx).getPosition())) {
				found = true;
				sublist.add(this.foundPlayers.get(midIdx));
			}
			else {
				if(pos.compareTo(this.foundPlayers.get(midIdx).getPosition()) > 0) {
					leftIdx = midIdx + 1;
				}
				else {
					rightIdx = midIdx - 1;
				}
				midIdx = leftIdx + (rightIdx - leftIdx) / 2;
			}
		}
		if(found == false) {return null;}
		//Left Traversal
		int leftLimit = midIdx - 1;
		while(leftLimit >= 0 && pos.equals(this.foundPlayers.get(leftLimit).getPosition())) {
			sublist.add(this.foundPlayers.get(leftLimit));
			leftLimit--;
		}
		//Right Traversal
		int rightLimit = midIdx + 1;
		while(rightLimit < this.foundPlayers.size() && pos.equals(this.foundPlayers.get(rightLimit).getPosition())) {
			sublist.add(this.foundPlayers.get(rightLimit));
			rightLimit++;
		}
		sortByName(sublist);
		return sublist;
	}
	
	@Override
	public void run() {
		//try {
		this.foundPlayers = new ArrayList<Player>();
		//registerPlayersFromCSV();
		sortByName(this.foundPlayers);
	//}
	/*catch(IOException e) {
		System.out.println("File 'players.CSV' not found, program can no longer run.");
		e.printStackTrace();
		System.exit(0);
	}*/
	}
	
	
}
