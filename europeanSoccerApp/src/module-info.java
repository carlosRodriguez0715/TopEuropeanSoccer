module europeanSoccerApp {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens Application to javafx.graphics, javafx.fxml;
}
