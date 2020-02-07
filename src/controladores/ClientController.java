package controladores;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import objetos.Libro;

public class ClientController implements Initializable {
	
	ObservableList<Libro> listaAux = FXCollections.observableArrayList();
	public static String libroEscogido;
	public static float precio;

	@FXML
	private ListView<Libro> ListView_Stock;
	
	@FXML
	private TextField TextField_Stock;
	
	@FXML
	private Button Button_ComprobarStock, Button_Comprar, Button_Salir;

	@FXML
	private TableView<Libro> TableView_Informacion;
	
	@FXML 
	private TableColumn<Libro, String> ColISBN, ColPaginas, ColTapaDura, ColNombreEditorial, ColNombreAutor, ColPrecio;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TableView_Informacion.setPlaceholder(new Label(""));
		cargarDatos();
	}
	
	public void cargarDatos() {
		ListView_Stock.getItems().addAll(Datos.listaLibros);
		
		ListView_Stock.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Libro>() {
		  
			@Override
			public void changed(ObservableValue<? extends Libro> arg0, Libro arg1, Libro arg2) {
				listaAux.clear();
				TextField_Stock.setText("");
				listaAux.add(new Libro());
				
				ColISBN.setCellValueFactory(c-> new SimpleStringProperty(ListView_Stock.getSelectionModel().getSelectedItem().getISBN()));
				ColPaginas.setCellValueFactory(c-> new SimpleStringProperty(Integer.toString(ListView_Stock.getSelectionModel().getSelectedItem().getPaginas())));
				ColTapaDura.setCellValueFactory(c-> new SimpleStringProperty(Boolean.toString(ListView_Stock.getSelectionModel().getSelectedItem().isTapa_Dura())));
				ColNombreEditorial.setCellValueFactory(c-> new SimpleStringProperty(ListView_Stock.getSelectionModel().getSelectedItem().getEditorial().getNombre_Editorial()));
				ColNombreAutor.setCellValueFactory(c-> new SimpleStringProperty(ListView_Stock.getSelectionModel().getSelectedItem().getAutor().getNombre_Autor()));
				ColPrecio.setCellValueFactory(c-> new SimpleStringProperty(Float.toString(ListView_Stock.getSelectionModel().getSelectedItem().getPrecio())));
				
				TableView_Informacion.setItems(listaAux);
			}
		});
	}
	
	public void comprobarStock() {
		try {
			if (ListView_Stock.getSelectionModel().getSelectedItem().getCantidad() == 0) {
				TextField_Stock.setText("El libro no se encuentra en stock");
			} else {
				TextField_Stock.setText("El libro se encuentra en stock");
			}
		} catch (Exception e) {
			TextField_Stock.setText("Selecciona un libro");
		}
	}
	
	public void salir() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../vistas/MainScreen.fxml"));
			Scene scene = new Scene(root, 1280, 720);
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void comprarLibro() {
		if (ListView_Stock.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Selecciona un libro primero.");
			alert.showAndWait();
		} else if (ListView_Stock.getSelectionModel().getSelectedItem().getCantidad() == 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("No hay stock del libro seleccionado.");
			alert.showAndWait();
		} else {
			try {
				libroEscogido = ListView_Stock.getSelectionModel().getSelectedItem().getNombre_Libro();
				precio = ListView_Stock.getSelectionModel().getSelectedItem().getPrecio();
				Parent root = FXMLLoader.load(getClass().getResource("../vistas/BuyView.fxml"));
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
