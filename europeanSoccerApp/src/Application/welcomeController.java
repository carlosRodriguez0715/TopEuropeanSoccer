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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class welcomeController implements Initializable {

	@FXML
	private ImageView bg;
	
	@FXML
	private Button switchScene;
	
	@FXML
	private Label label;
	
	private Parent root;
	
	private Scene scene;
	
	private Stage stage;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.label = new Label("Top 5 European Soccer Data");
		this.switchScene = new Button("Enter");
	}
	
	public void changeScene(ActionEvent evt) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("WorkingSc.fxml"));
		this.root = loader.load();
		workingController wC = loader.getController();
		this.stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
		this.scene = new Scene(root);
		this.stage.setScene(scene);
		this.stage.show();
		
	}
	

}
