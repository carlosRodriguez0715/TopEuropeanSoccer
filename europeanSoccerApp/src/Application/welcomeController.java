/**
 * @author: Carlos Rodriguez
 * Class will handle the initial application GUI */

package Application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class welcomeController implements Initializable{
	
	@FXML
	private AnchorPane bgPane;
	
	@FXML
	private ImageView bg;
	
	@FXML
	private Button switchScene;
	
	private AnchorPane root;
	
	private Scene scene;
	
	private Stage stage;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void changeScene(ActionEvent evt) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("WorkingSc.fxml"));
			this.root = loader.load();
			this.stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
			this.scene = new Scene(root);
			this.stage.setScene(scene);
			this.stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
