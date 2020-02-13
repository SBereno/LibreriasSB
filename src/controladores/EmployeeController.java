package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import objetos.Autor;
import objetos.Editorial;
import objetos.Libro;

public class EmployeeController implements Initializable {

	ArrayList<Pane> paneList = new ArrayList<>();
	String paneEscogido;

	@FXML
	private Pane Pane_Stock, Pane_Editoriales, Pane_Autores;

	@FXML
	private TableView<Libro> TableView_Stock;

	@FXML
	private TableView<Editorial> TableView_Editoriales;

	@FXML
	private TableView<Autor> TableView_Autores;

	@FXML
	private MenuBar MenuBar_Employee;

	@FXML
	private MenuItem MenuItem_CambiarUsuario, MenuItem_Salir, MenuItem_Stock, MenuItem_Editoriales, MenuItem_Autores,
			MenuItem_NuevoLibro, MenuItem_BorrarLibro;

	@FXML
	private TableColumn<Libro, String> ColNombre, ColISBN, ColCantidad, ColPaginas, ColTapaDura, ColNombreEditorial,
			ColNombreAutor, ColPrecio;
	@FXML
	private TableColumn<Editorial, String> ColIDEditorial, ColNombreEditorial2, ColAutores;

	@FXML
	private TableColumn<Autor, String> ColID, ColNombreAutor2, ColLibrosPublicados, ColPais, ColNacimiento;

	@FXML
	private Label Label_Empleado;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cargarDatos();
		TableView_Stock.setPlaceholder(new Label(""));
		TableView_Editoriales.setPlaceholder(new Label(""));
		TableView_Autores.setPlaceholder(new Label(""));
		Label_Empleado.setText("Empleado: " + EmployeeLoginController.empleadoSeleccionado);
		paneList.add(Pane_Stock);
		paneList.add(Pane_Editoriales);
		paneList.add(Pane_Autores);
		Pane_Editoriales.setVisible(false);
		Pane_Autores.setVisible(false);
	}

	public void cargarDatos() {
		try {
			TableView_Stock.getItems().clear();

			ColNombre.setCellValueFactory(new PropertyValueFactory<Libro, String>("nombre_Libro"));
			ColISBN.setCellValueFactory(new PropertyValueFactory<Libro, String>("ISBN"));
			ColCantidad.setCellValueFactory(new PropertyValueFactory<Libro, String>("cantidad"));
			ColPaginas.setCellValueFactory(new PropertyValueFactory<Libro, String>("paginas"));
			ColTapaDura.setCellValueFactory(new PropertyValueFactory<Libro, String>("tapa_Dura"));
			ColNombreEditorial.setCellValueFactory(
					cellData -> new SimpleStringProperty(cellData.getValue().getEditorial().getNombre_Editorial()));
			ColNombreAutor.setCellValueFactory(
					cellData -> new SimpleStringProperty(cellData.getValue().getAutor().getNombre_Autor()));
			ColPrecio.setCellValueFactory(new PropertyValueFactory<Libro, String>("precio"));

			TableView_Stock.getItems().addAll(Datos.listaLibros);

			TableView_Editoriales.getItems().clear();

			ColIDEditorial.setCellValueFactory(new PropertyValueFactory<Editorial, String>("id_Editorial"));
			ColNombreEditorial2.setCellValueFactory(new PropertyValueFactory<Editorial, String>("nombre_Editorial"));
			ColAutores.setCellValueFactory(
					cellData -> new SimpleStringProperty(cellData.getValue().getLista_de_autores()));
			TableView_Editoriales.getItems().addAll(Datos.listaEditoriales);

			TableView_Autores.getItems().clear();

			ColID.setCellValueFactory(new PropertyValueFactory<Autor, String>("id_Autor"));
			ColNombreAutor2.setCellValueFactory(new PropertyValueFactory<Autor, String>("nombre_Autor"));
			ColLibrosPublicados.setCellValueFactory(new PropertyValueFactory<Autor, String>("libros_Publicados"));
			ColPais.setCellValueFactory(new PropertyValueFactory<Autor, String>("pais"));
			ColNacimiento.setCellValueFactory(new PropertyValueFactory<Autor, String>("nacimiento"));

			TableView_Autores.getItems().addAll(Datos.listaAutores);
		} catch (Exception e) {
			e.printStackTrace();
		}

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
			paneEscogido = "Pane_Editoriales";
			showPane();
			break;
		case "MenuItem_Autores":
			paneEscogido = "Pane_Autores";
			showPane();
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

	public void borrarLibro() {
		if (TableView_Stock.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Selecciona un libro para eliminar.");
			alert.showAndWait();
		} else {
			TableView_Stock.getItems().remove(TableView_Stock.getSelectionModel().getSelectedItem());
		}
	}
	
	public void nuevoLibro() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../vistas/NewBookView.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
}
