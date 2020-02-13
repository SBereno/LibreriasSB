package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.Callback;
import objetos.Autor;
import objetos.Editorial;
import objetos.Libro;

public class NewBookController implements Initializable {

	@FXML
	private TextField TextField_Nombre, TextField_ISBN, TextField_Cantidad, TextField_Paginas, TextField_Precio;

	@FXML
	private ComboBox<Editorial> ComboBox_Editorial;

	@FXML
	private ComboBox<Autor> ComboBox_Autor;

	@FXML
	private ComboBox<Boolean> ComboBox_TapaDura;

	@FXML
	private Button Button_Introducir;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ComboBox_Editorial.setItems(Datos.listaEditoriales);
		ComboBox_Autor.setItems(Datos.listaAutores);
		ComboBox_TapaDura.setItems(FXCollections.observableArrayList(true, false));
		ComboBox_Editorial.getSelectionModel().selectFirst();
		ComboBox_Autor.getSelectionModel().selectFirst();
		ComboBox_TapaDura.getSelectionModel().selectFirst();

		Callback<ListView<Editorial>, ListCell<Editorial>> factory = lv -> new ListCell<Editorial>() {
			@Override
			protected void updateItem(Editorial item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getNombre_Editorial());
			}
		};
		ComboBox_Editorial.setCellFactory(factory);
		ComboBox_Editorial.setButtonCell(factory.call(null));

		Callback<ListView<Autor>, ListCell<Autor>> factoryAu = lv -> new ListCell<Autor>() {
			@Override
			protected void updateItem(Autor item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getNombre_Autor());
			}
		};
		ComboBox_Autor.setCellFactory(factoryAu);
		ComboBox_Autor.setButtonCell(factoryAu.call(null));
	}

	public void addLibro() throws IOException {
		try {
			Libro aux = new Libro(TextField_ISBN.getText(), Integer.parseInt(TextField_Cantidad.getText()),
					Integer.parseInt(TextField_Paginas.getText()), TextField_Nombre.getText(),
					ComboBox_TapaDura.getValue(), ComboBox_Editorial.getValue(), ComboBox_Autor.getValue(),
					Float.parseFloat(TextField_Precio.getText()), false);
			Datos.listaLibros.add(aux);

		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Has introducido un valor no valido. Proceso abortado.");
			alert.showAndWait();
		}
		Stage stage = (Stage) Button_Introducir.getScene().getWindow();
		stage.close();
		Parent root = FXMLLoader.load(getClass().getResource("../vistas/EmployeeView.fxml"));
		Scene scene = new Scene(root, 1280, 720);
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}

}
