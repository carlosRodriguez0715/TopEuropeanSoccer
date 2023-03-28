/**
 * @author: Carlos Rodriguez
 * Class handles the scene for the main application */

package Application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class workingController implements Initializable{
	
	private Queries q;
	
	private ArrayList<String> allTeams, allAges, allPositions;
	
	@FXML
	private TextField searchBar;
	
	@FXML
	private ChoiceBox<String> teamChoice, positionChoices, ageChoices;
	
	@FXML
	private TextArea printArea;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.printArea = new TextArea();
		this.printArea.setText("oa");
		this.q = new Queries();
		this.allTeams = new ArrayList<String>();
		this.allTeams.add("---");
		this.allTeams.add("Liverpool");
		this.allTeams.add("PSG");
		this.allTeams.add("Barcelona");
		this.teamChoice = new ChoiceBox<String>(FXCollections.observableArrayList(this.allTeams));
		
		this.allAges = new ArrayList<String>();
		this.allAges.add("20");
		this.allAges.add("21");
		this.allAges.add("22");
		this.allAges.add("23");
		this.ageChoices = new ChoiceBox<String>(FXCollections.observableArrayList(this.allAges));
	}
	
	public void displayFound() {
		
	}
	
	public void showTChoices() {
		
	}
	public void showAChoices() {
	
	}
	
	public void showPChoices() {
		
	}
	
}
