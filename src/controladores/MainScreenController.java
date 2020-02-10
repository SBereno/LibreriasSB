package controladores;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void entrarComoEmpleado(Event event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../vistas/EmployeeLogin.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setResizable(false);
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
