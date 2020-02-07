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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import objetos.Empleado;

public class EmployeeLoginController implements Initializable {

	@FXML
	private ListView<Empleado> ListView_Empleados;

	@FXML
	private PasswordField PasswordField_Password;

	@FXML
	private Button Button_Entrar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cargarDatos();
	}

	public void cargarDatos() {
		ListView_Empleados.getItems().addAll(Datos.listaEmpleados);
	}

	public void entrar(Event event) {
		try {
			if (ListView_Empleados.getSelectionModel().getSelectedItem().getPassword().equals(PasswordField_Password.getText())) {
				Stage stage = (Stage) Button_Entrar.getScene().getWindow();
				stage.close();
				Parent root = FXMLLoader.load(getClass().getResource("../vistas/EmployeeView.fxml"));
				Scene scene = new Scene(root, 1280, 720);
				Main.primaryStage.setScene(scene);
				Main.primaryStage.show();
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Login incorrecto");
				alert.setHeaderText(null);
				alert.setContentText("Password incorrecta.");
				alert.showAndWait();
			}
		} catch (Exception e) {
			if (ListView_Empleados.getSelectionModel().getSelectedItem() == null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Selecciona un empleado.");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Campo password vacio.");
				alert.showAndWait();
			}
		}
	}
}
