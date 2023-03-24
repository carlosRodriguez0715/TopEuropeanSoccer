/**
 * @author: Carlos Rodriguez
 * Class handles the scene for the main application */

package Application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class workingController implements Initializable{
	
	@FXML
	private TextField searchBar;
	
	@FXML
	private ChoiceBox<String> teamChoice, positionChoices, ageChoices;
	
	@FXML
	private TextArea printArea;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
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
