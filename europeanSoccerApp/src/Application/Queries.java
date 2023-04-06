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

public class Queries {
	//Stores all players.
	private ArrayList<Player> foundPlayers;
	
	//Default Constructor
	public Queries() {
		this.foundPlayers = new ArrayList<Player>();
		try {
			registerPlayersFromCSV();
			sortByName(this.foundPlayers);
		} catch (IOException e) {
			System.out.println("File 'premCSV.csv' not found, program can no longer run.");
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
		BufferedReader br = new BufferedReader(new FileReader("src/premCSV.csv"));
		String read = br.readLine();
		if(read == null) {br.close(); throw new IOException();}
		else {
			String[] data = null;
			while(read != null) {
				data = read.split(",");
				Player pl = new Player(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim(), Double.parseDouble(data[5]));
				this.foundPlayers.add(pl);
				read = br.readLine();
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
		if(team == null || team.isBlank()) {return null;}
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
	
	public ArrayList<Player> searchByName(String name){
		if(name == null) {return null;}
		sortByName(this.foundPlayers);
		//Some type of binary search
		int leftIdx = 0;
		int rightIdx = this.foundPlayers.size() - 1;
		int midIdx = leftIdx + (rightIdx - leftIdx) / 2; 
		boolean found = false;
		ArrayList<Player> sublist = new ArrayList<Player>();
		while(leftIdx <= rightIdx && found == false) {
			if(name.equals(this.foundPlayers.get(midIdx).getName())) {
				found = true;
				sublist.add(this.foundPlayers.get(midIdx));
			}
			else {
				if(name.compareTo(this.foundPlayers.get(midIdx).getName()) > 0) {
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
		while(leftLimit >= 0 && name.equals(this.foundPlayers.get(leftLimit).getName())) {
			sublist.add(this.foundPlayers.get(leftLimit));
			leftLimit--;
		}
		//Right Traversal
		int rightLimit = midIdx + 1;
		while(rightLimit < this.foundPlayers.size() && name.equals(this.foundPlayers.get(rightLimit).getName())) {
			sublist.add(this.foundPlayers.get(rightLimit));
			rightLimit++;
		}
		sortByName(sublist);
		return sublist;
	}
}
