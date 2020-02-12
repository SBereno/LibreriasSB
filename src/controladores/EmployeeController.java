package controladores;

import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import objetos.Libro;

public class EmployeeController implements Initializable {

	ArrayList<Pane> paneList = new ArrayList<>();
	String paneEscogido;
	
	@FXML
	private Pane Pane_Stock;
	
	@FXML 
	private TableView<Libro> TableView_Stock;
	
	@FXML
	private MenuBar MenuBar_Employee;

	@FXML
	private MenuItem MenuItem_CambiarUsuario, MenuItem_Salir, MenuItem_Stock, MenuItem_Editoriales;
	
	@FXML
	private Label Label_Empleado;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Label_Empleado.setText("Empleado: " + EmployeeLoginController.empleadoSeleccionado);
		paneList.add(Pane_Stock);
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
	
	public void definePane(Event event) {
	    MenuItem source = (MenuItem) event.getSource();
	    switch (source.getId()) {
		case "MenuItem_Stock":
			paneEscogido = "Pane_Stock";
			showPane();
			break;
		case "MenuItem_Editoriales":
			paneEscogido = "asd";
			showPane();
			break;
		default:
			break;
		}
		
	}
	
	public void showPane() {
		for (Pane pane : paneList) {
			if (pane.getId().equals(paneEscogido)) {
				pane.setVisible(true);
			} else {
				pane.setVisible(false);
			}
		}
	}
}
