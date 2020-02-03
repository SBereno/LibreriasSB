package controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainScreenController implements Initializable {

	@FXML
	private Button Button_EntrarComoCliente, Button_EntrarComoEmpleado;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	public void entrarComoCliente(Event event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../vistas/ClientView.fxml"));
			Scene scene = new Scene(root, 1280, 720);
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
