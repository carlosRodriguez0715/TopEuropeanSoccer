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
	
	//private Queries q;
	
	@FXML
	private TextField searchBar;
	
	@FXML
	private TextArea printArea;
	
	@FXML
	private ChoiceBox<String> team, age, position;
		
	public void initialize(URL arg0, ResourceBundle arg1) {
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
