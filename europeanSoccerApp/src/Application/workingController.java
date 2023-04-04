/**
 * @author: Carlos Rodriguez
 * Class handles the scene for the main application */

package Application;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class workingController {
	
	private Queries q;
	@FXML private AnchorPane bgPane;
	@FXML private TextField searchBar;
	@FXML public TextArea printArea;
	@FXML private ComboBox<String> teams;
	@FXML private ComboBox<Integer> age;
	@FXML private ComboBox<String> position;
	
	@FXML private void initialize() {
		this.q = new Queries();
		this.searchBar.setText("Search here by a player's lastname or by a team's name");
		loadTeams();
		loadAges();
		loadPositions();
	}
	
	private void loadAges() {
		this.q.searchByAge("1");
		ArrayList<Player> l = this.q.getFoundPlayers();
		int min = Integer.parseInt(l.get(0).getAge());
		int max = Integer.parseInt(l.get(l.size()-1).getAge());
		
		ArrayList<Integer> age = new ArrayList<Integer>();
		while(min < max) {
			age.add(min);
			min++;
		}
		age.add(max);
		this.age.getItems().addAll(age);
	}
	
	private void loadPositions() {
		this.q.searchByPosition("Left-Back");
		ArrayList<Player> l = this.q.getFoundPlayers();		
		ArrayList<String> pos = new ArrayList<String>();
		for(int i=0; i<l.size(); i++) {
			if(!(pos.contains(l.get(i).getPosition()))) {
				pos.add(l.get(i).getPosition());
			}
		}
		this.position.getItems().addAll(pos);
	}
	
	private void loadTeams() {
		this.q.searchByTeam("LiverpoolFC");
		ArrayList<Player> l = this.q.getFoundPlayers();		
		ArrayList<String> t = new ArrayList<String>();
		for(int i=0; i<l.size(); i++) {
			if(!(t.contains(l.get(i).getCurrTeam()))) {
				t.add(l.get(i).getCurrTeam());
			}
		}
		this.teams.getItems().addAll(t);
	}
}
