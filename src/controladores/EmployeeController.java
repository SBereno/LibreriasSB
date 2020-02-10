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
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class EmployeeController implements Initializable {

	@FXML
	private MenuBar MenuBar_Employee;

	@FXML
	private MenuItem MenuItem_CambiarUsuario, MenuItem_Salir;
	
	@FXML
	private Label Label_Empleado;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Label_Empleado.setText("Empleado: " + EmployeeLoginController.empleadoSeleccionado);
	}

	public void cambiarUsuario(Event event) {
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
	
	public void salir() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../vistas/MainScreen.fxml"));
			Scene scene = new Scene(root, 1280, 720);
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
