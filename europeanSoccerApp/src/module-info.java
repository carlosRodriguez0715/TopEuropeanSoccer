module europeanSoccerApp {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens Application to javafx.graphics, javafx.fxml;
}
